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

public interface RewriteResponseOrBuilder
    extends
    // @@protoc_insertion_point(interface_extends:google.storage.v2.RewriteResponse)
    com.google.protobuf.MessageOrBuilder {

  /**
   *
   *
   * <pre>
   * The total bytes written so far, which can be used to provide a waiting user
   * with a progress indicator. This property is always present in the response.
   * </pre>
   *
   * <code>int64 total_bytes_rewritten = 1;</code>
   *
   * @return The totalBytesRewritten.
   */
  long getTotalBytesRewritten();

  /**
   *
   *
   * <pre>
   * The total size of the object being copied in bytes. This property is always
   * present in the response.
   * </pre>
   *
   * <code>int64 object_size = 2;</code>
   *
   * @return The objectSize.
   */
  long getObjectSize();

  /**
   *
   *
   * <pre>
   * `true` if the copy is finished; otherwise, `false` if
   * the copy is in progress. This property is always present in the response.
   * </pre>
   *
   * <code>bool done = 3;</code>
   *
   * @return The done.
   */
  boolean getDone();

  /**
   *
   *
   * <pre>
   * A token to use in subsequent requests to continue copying data. This token
   * is present in the response only when there is more data to copy.
   * </pre>
   *
   * <code>string rewrite_token = 4;</code>
   *
   * @return The rewriteToken.
   */
  java.lang.String getRewriteToken();

  /**
   *
   *
   * <pre>
   * A token to use in subsequent requests to continue copying data. This token
   * is present in the response only when there is more data to copy.
   * </pre>
   *
   * <code>string rewrite_token = 4;</code>
   *
   * @return The bytes for rewriteToken.
   */
  com.google.protobuf.ByteString getRewriteTokenBytes();

  /**
   *
   *
   * <pre>
   * A resource containing the metadata for the copied-to object. This property
   * is present in the response only when copying completes.
   * </pre>
   *
   * <code>.google.storage.v2.Object resource = 5;</code>
   *
   * @return Whether the resource field is set.
   */
  boolean hasResource();

  /**
   *
   *
   * <pre>
   * A resource containing the metadata for the copied-to object. This property
   * is present in the response only when copying completes.
   * </pre>
   *
   * <code>.google.storage.v2.Object resource = 5;</code>
   *
   * @return The resource.
   */
  com.google.storage.v2.Object getResource();

  /**
   *
   *
   * <pre>
   * A resource containing the metadata for the copied-to object. This property
   * is present in the response only when copying completes.
   * </pre>
   *
   * <code>.google.storage.v2.Object resource = 5;</code>
   */
  com.google.storage.v2.ObjectOrBuilder getResourceOrBuilder();
}
