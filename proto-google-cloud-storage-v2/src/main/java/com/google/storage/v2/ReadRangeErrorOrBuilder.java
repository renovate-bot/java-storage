/*
 * Copyright 2025 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: google/storage/v2/storage.proto

// Protobuf Java Version: 3.25.8
package com.google.storage.v2;

public interface ReadRangeErrorOrBuilder
    extends
    // @@protoc_insertion_point(interface_extends:google.storage.v2.ReadRangeError)
    com.google.protobuf.MessageOrBuilder {

  /**
   *
   *
   * <pre>
   * The id of the corresponding read_range
   * </pre>
   *
   * <code>int64 read_id = 1;</code>
   *
   * @return The readId.
   */
  long getReadId();

  /**
   *
   *
   * <pre>
   * The status which should be an enum value of [google.rpc.Code].
   * </pre>
   *
   * <code>.google.rpc.Status status = 2;</code>
   *
   * @return Whether the status field is set.
   */
  boolean hasStatus();

  /**
   *
   *
   * <pre>
   * The status which should be an enum value of [google.rpc.Code].
   * </pre>
   *
   * <code>.google.rpc.Status status = 2;</code>
   *
   * @return The status.
   */
  com.google.rpc.Status getStatus();

  /**
   *
   *
   * <pre>
   * The status which should be an enum value of [google.rpc.Code].
   * </pre>
   *
   * <code>.google.rpc.Status status = 2;</code>
   */
  com.google.rpc.StatusOrBuilder getStatusOrBuilder();
}
