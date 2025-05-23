/*
 * Copyright 2023 Google LLC
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

import static com.google.cloud.storage.StorageV2ProtoUtils.fmtProto;

import com.google.cloud.storage.BidiWriteCtx.BidiWriteObjectRequestBuilderFactory;
import com.google.storage.v2.BidiWriteObjectRequest;
import com.google.storage.v2.StartResumableWriteRequest;
import com.google.storage.v2.StartResumableWriteResponse;
import java.util.Objects;
import java.util.function.Function;
import org.checkerframework.checker.nullness.qual.Nullable;

final class BidiResumableWrite implements BidiWriteObjectRequestBuilderFactory {

  private final StartResumableWriteRequest req;
  private final StartResumableWriteResponse res;

  private final BidiWriteObjectRequest writeRequest;

  public BidiResumableWrite(
      StartResumableWriteRequest req,
      StartResumableWriteResponse res,
      Function<String, BidiWriteObjectRequest> f) {
    this.req = req;
    this.res = res;
    this.writeRequest = f.apply(res.getUploadId());
  }

  public StartResumableWriteRequest getReq() {
    return req;
  }

  public StartResumableWriteResponse getRes() {
    return res;
  }

  @Override
  public BidiWriteObjectRequest.Builder newBuilder() {
    return writeRequest.toBuilder().clearWriteObjectSpec();
  }

  @Override
  public @Nullable String bucketName() {
    if (req.hasWriteObjectSpec() && req.getWriteObjectSpec().hasResource()) {
      return req.getWriteObjectSpec().getResource().getBucket();
    }
    return null;
  }

  @Override
  public String toString() {
    return "BidiResumableWrite{" + "req=" + fmtProto(req) + ", res=" + fmtProto(res) + '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof ResumableWrite)) {
      return false;
    }
    ResumableWrite resumableWrite = (ResumableWrite) o;
    return Objects.equals(req, resumableWrite.getReq())
        && Objects.equals(res, resumableWrite.getRes());
  }

  @Override
  public int hashCode() {
    return Objects.hash(req, res);
  }

  /**
   * Helper function which is more specific than {@link Function#identity()}. Constraining the input
   * and output to be exactly {@link BidiResumableWrite}.
   */
  static BidiResumableWrite identity(BidiResumableWrite w) {
    return w;
  }
}

final class BidiAppendableWrite implements BidiWriteObjectRequestBuilderFactory {

  private final BidiWriteObjectRequest req;

  public BidiAppendableWrite(BidiWriteObjectRequest req) {
    this(req, false);
  }

  public BidiAppendableWrite(BidiWriteObjectRequest req, boolean takeOver) {
    if (takeOver) {
      this.req = req;
    } else {
      req =
          req.toBuilder()
              .setWriteObjectSpec(req.getWriteObjectSpec().toBuilder().setAppendable(true).build())
              .build();
      this.req = req;
    }
  }

  public BidiWriteObjectRequest getReq() {
    return req;
  }

  @Override
  public BidiWriteObjectRequest.Builder newBuilder() {
    return req.toBuilder();
  }

  @Override
  public @Nullable String bucketName() {
    if (req.hasWriteObjectSpec() && req.getWriteObjectSpec().hasResource()) {
      return req.getWriteObjectSpec().getResource().getBucket();
    } else if (req.hasAppendObjectSpec()) {
      return req.getAppendObjectSpec().getBucket();
    }
    return null;
  }

  @Override
  public String toString() {
    return "BidiAppendableWrite{" + "req=" + fmtProto(req) + '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof BidiAppendableWrite)) {
      return false;
    }
    BidiAppendableWrite BidiAppendableWrite = (BidiAppendableWrite) o;
    return Objects.equals(req, BidiAppendableWrite.getReq());
  }

  @Override
  public int hashCode() {
    return Objects.hash(req);
  }

  /**
   * Helper function which is more specific than {@link Function#identity()}. Constraining the input
   * and output to be exactly {@link BidiAppendableWrite}.
   */
  static BidiAppendableWrite identity(BidiAppendableWrite w) {
    return w;
  }
}
