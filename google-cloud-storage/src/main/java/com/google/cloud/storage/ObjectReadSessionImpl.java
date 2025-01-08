/*
 * Copyright 2024 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.storage;

import static com.google.common.base.Preconditions.checkState;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.gax.grpc.GrpcCallContext;
import com.google.cloud.storage.GrpcUtils.ZeroCopyBidiStreamingCallable;
import com.google.cloud.storage.ObjectReadSessionStreamRead.AccumulatingRead;
import com.google.cloud.storage.ObjectReadSessionStreamRead.StreamingRead;
import com.google.cloud.storage.RetryContext.RetryContextProvider;
import com.google.cloud.storage.ZeroCopySupport.DisposableByteString;
import com.google.common.annotations.VisibleForTesting;
import com.google.storage.v2.BidiReadObjectRequest;
import com.google.storage.v2.BidiReadObjectResponse;
import com.google.storage.v2.Object;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.nio.channels.ScatteringByteChannel;
import java.util.ArrayList;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.locks.ReentrantLock;
import org.checkerframework.checker.lock.qual.GuardedBy;

final class ObjectReadSessionImpl implements ObjectReadSession {

  private final ScheduledExecutorService executor;
  private final ZeroCopyBidiStreamingCallable<BidiReadObjectRequest, BidiReadObjectResponse>
      callable;
  private final ObjectReadSessionStream stream;
  @VisibleForTesting final ObjectReadSessionState state;
  private final Object resource;
  private final RetryContextProvider retryContextProvider;

  @GuardedBy("this.lock")
  private final IdentityHashMap<ObjectReadSessionStream, ObjectReadSessionState> children;

  private final ReentrantLock lock;

  @GuardedBy("this.lock")
  private volatile boolean open;

  private ObjectReadSessionImpl(
      ScheduledExecutorService executor,
      ZeroCopyBidiStreamingCallable<BidiReadObjectRequest, BidiReadObjectResponse> callable,
      ObjectReadSessionStream stream,
      ObjectReadSessionState state,
      RetryContextProvider retryContextProvider) {
    this.executor = executor;
    this.callable = callable;
    this.stream = stream;
    this.state = state;
    this.resource = state.getMetadata();
    this.retryContextProvider = retryContextProvider;
    this.children = new IdentityHashMap<>();
    this.lock = new ReentrantLock();
    this.open = true;
  }

  @Override
  public Object getResource() {
    return resource;
  }

  @Override
  public ApiFuture<byte[]> readRangeAsBytes(RangeSpec range) {
    lock.lock();
    try {
      checkState(open, "stream already closed");
      long readId = state.newReadId();
      AccumulatingRead<byte[]> read =
          ObjectReadSessionStreamRead.createByteArrayAccumulatingRead(
              readId, range, retryContextProvider.create());
      registerReadInState(readId, read);
      return read;
    } finally {
      lock.unlock();
    }
  }

  @Override
  public ScatteringByteChannel readRangeAsChannel(RangeSpec range) {
    lock.lock();
    try {
      checkState(open, "stream already closed");
      long readId = state.newReadId();
      StreamingRead read =
          ObjectReadSessionStreamRead.streamingRead(readId, range, retryContextProvider.create());
      registerReadInState(readId, read);
      return read;
    } finally {
      lock.unlock();
    }
  }

  public ApiFuture<DisposableByteString> readRangeAsByteString(RangeSpec range) {
    lock.lock();
    try {
      checkState(open, "stream already closed");
      long readId = state.newReadId();
      AccumulatingRead<DisposableByteString> read =
          ObjectReadSessionStreamRead.createZeroCopyByteStringAccumulatingRead(
              readId, range, retryContextProvider.create());
      registerReadInState(readId, read);
      return read;
    } finally {
      lock.unlock();
    }
  }

  @Override
  public void close() throws IOException {
    open = false;
    lock.lock();
    try {
      Iterator<Entry<ObjectReadSessionStream, ObjectReadSessionState>> it =
          children.entrySet().iterator();
      ArrayList<ApiFuture<Void>> closing = new ArrayList<>(children.size());
      while (it.hasNext()) {
        Entry<ObjectReadSessionStream, ObjectReadSessionState> next = it.next();
        ObjectReadSessionStream subStream = next.getKey();
        it.remove();
        closing.add(subStream.closeAsync());
      }
      stream.close();
      ApiFutures.allAsList(closing).get();
    } catch (ExecutionException e) {
      throw new IOException(e.getCause());
    } catch (InterruptedException e) {
      Thread.currentThread().interrupt();
      throw new InterruptedIOException();
    } finally {
      lock.unlock();
    }
  }

  private void registerReadInState(long readId, ObjectReadSessionStreamRead read) {
    BidiReadObjectRequest request =
        BidiReadObjectRequest.newBuilder().addReadRanges(read.makeReadRange()).build();
    if (state.canHandleNewRead(read)) {
      state.putOutstandingRead(readId, read);
      stream.send(request);
    } else {
      ObjectReadSessionState child = state.forkChild();
      ObjectReadSessionStream newStream =
          ObjectReadSessionStream.create(executor, callable, child, retryContextProvider.create());
      children.put(newStream, child);
      read.setOnCloseCallback(
          () -> {
            children.remove(newStream);
            newStream.close();
          });
      child.putOutstandingRead(readId, read);
      newStream.send(request);
    }
  }

  static ApiFuture<ObjectReadSession> create(
      BidiReadObjectRequest openRequest,
      GrpcCallContext context,
      ZeroCopyBidiStreamingCallable<BidiReadObjectRequest, BidiReadObjectResponse> callable,
      ScheduledExecutorService executor,
      RetryContextProvider retryContextProvider) {
    ObjectReadSessionState state = new ObjectReadSessionState(context, openRequest);

    ObjectReadSessionStream stream =
        ObjectReadSessionStream.create(executor, callable, state, retryContextProvider.create());

    ApiFuture<ObjectReadSession> objectReadSessionFuture =
        ApiFutures.transform(
            stream,
            nowOpen ->
                new ObjectReadSessionImpl(executor, callable, stream, state, retryContextProvider),
            executor);
    stream.send(openRequest);
    return objectReadSessionFuture;
  }
}
