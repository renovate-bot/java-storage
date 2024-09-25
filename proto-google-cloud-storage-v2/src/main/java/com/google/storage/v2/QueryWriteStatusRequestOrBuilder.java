/*
 * Copyright 2024 Google LLC
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

// Protobuf Java Version: 3.25.5
package com.google.storage.v2;

public interface QueryWriteStatusRequestOrBuilder
    extends
    // @@protoc_insertion_point(interface_extends:google.storage.v2.QueryWriteStatusRequest)
    com.google.protobuf.MessageOrBuilder {

  /**
   *
   *
   * <pre>
   * Required. The name of the resume token for the object whose write status is
   * being requested.
   * </pre>
   *
   * <code>string upload_id = 1 [(.google.api.field_behavior) = REQUIRED];</code>
   *
   * @return The uploadId.
   */
  java.lang.String getUploadId();
  /**
   *
   *
   * <pre>
   * Required. The name of the resume token for the object whose write status is
   * being requested.
   * </pre>
   *
   * <code>string upload_id = 1 [(.google.api.field_behavior) = REQUIRED];</code>
   *
   * @return The bytes for uploadId.
   */
  com.google.protobuf.ByteString getUploadIdBytes();

  /**
   *
   *
   * <pre>
   * A set of parameters common to Storage API requests concerning an object.
   * </pre>
   *
   * <code>.google.storage.v2.CommonObjectRequestParams common_object_request_params = 2;</code>
   *
   * @return Whether the commonObjectRequestParams field is set.
   */
  boolean hasCommonObjectRequestParams();
  /**
   *
   *
   * <pre>
   * A set of parameters common to Storage API requests concerning an object.
   * </pre>
   *
   * <code>.google.storage.v2.CommonObjectRequestParams common_object_request_params = 2;</code>
   *
   * @return The commonObjectRequestParams.
   */
  com.google.storage.v2.CommonObjectRequestParams getCommonObjectRequestParams();
  /**
   *
   *
   * <pre>
   * A set of parameters common to Storage API requests concerning an object.
   * </pre>
   *
   * <code>.google.storage.v2.CommonObjectRequestParams common_object_request_params = 2;</code>
   */
  com.google.storage.v2.CommonObjectRequestParamsOrBuilder getCommonObjectRequestParamsOrBuilder();
}
