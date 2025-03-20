/*
 * Copyright 2025 Google LLC
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

import static java.util.Objects.requireNonNull;

import com.google.api.core.ApiFuture;
import com.google.api.core.BetaApi;
import com.google.cloud.storage.BaseObjectReadSessionStreamRead.AccumulatingRead;
import com.google.cloud.storage.ReadProjectionConfigs.BaseConfig;
import com.google.common.base.MoreObjects;
import java.util.Objects;
import javax.annotation.concurrent.Immutable;

@BetaApi
@Immutable
final class ReadAsFutureBytes extends BaseConfig<ApiFuture<byte[]>, AccumulatingRead<byte[]>> {
  static final ReadAsFutureBytes INSTANCE =
      new ReadAsFutureBytes(RangeSpec.all(), Hasher.enabled());

  private final RangeSpec range;
  private final Hasher hasher;

  private ReadAsFutureBytes(RangeSpec range, Hasher hasher) {
    super();
    this.range = range;
    this.hasher = hasher;
  }

  @BetaApi
  public RangeSpec getRange() {
    return range;
  }

  @BetaApi
  public ReadAsFutureBytes withRangeSpec(RangeSpec range) {
    requireNonNull(range, "range must be non null");
    if (this.range.equals(range)) {
      return this;
    }
    return new ReadAsFutureBytes(range, hasher);
  }

  @BetaApi
  boolean getCrc32cValidationEnabled() {
    return Hasher.enabled().equals(hasher);
  }

  @BetaApi
  ReadAsFutureBytes withCrc32cValidationEnabled(boolean enabled) {
    if (enabled && Hasher.enabled().equals(hasher)) {
      return this;
    } else if (!enabled && Hasher.noop().equals(hasher)) {
      return this;
    }
    return new ReadAsFutureBytes(range, enabled ? Hasher.enabled() : Hasher.noop());
  }

  @Override
  BaseConfig<ApiFuture<byte[]>, ?> cast() {
    return this;
  }

  @Override
  AccumulatingRead<byte[]> newRead(long readId, RetryContext retryContext) {
    return ObjectReadSessionStreamRead.createByteArrayAccumulatingRead(
        readId, range, hasher, retryContext);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof ReadAsFutureBytes)) {
      return false;
    }
    ReadAsFutureBytes that = (ReadAsFutureBytes) o;
    return Objects.equals(range, that.range) && Objects.equals(hasher, that.hasher);
  }

  @Override
  public int hashCode() {
    return Objects.hash(range, hasher);
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("range", range)
        .add("crc32cValidationEnabled", getCrc32cValidationEnabled())
        .toString();
  }
}
