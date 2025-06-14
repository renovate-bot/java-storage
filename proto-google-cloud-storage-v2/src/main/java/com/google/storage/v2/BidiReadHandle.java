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

/**
 *
 *
 * <pre>
 * BidiReadHandle contains a handle from a previous BiDiReadObject
 * invocation. The client can use this instead of BidiReadObjectSpec as an
 * optimized way of opening subsequent bidirectional streams to the same object.
 * </pre>
 *
 * Protobuf type {@code google.storage.v2.BidiReadHandle}
 */
public final class BidiReadHandle extends com.google.protobuf.GeneratedMessageV3
    implements
    // @@protoc_insertion_point(message_implements:google.storage.v2.BidiReadHandle)
    BidiReadHandleOrBuilder {
  private static final long serialVersionUID = 0L;

  // Use BidiReadHandle.newBuilder() to construct.
  private BidiReadHandle(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }

  private BidiReadHandle() {
    handle_ = com.google.protobuf.ByteString.EMPTY;
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(UnusedPrivateParameter unused) {
    return new BidiReadHandle();
  }

  public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
    return com.google.storage.v2.StorageProto
        .internal_static_google_storage_v2_BidiReadHandle_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.google.storage.v2.StorageProto
        .internal_static_google_storage_v2_BidiReadHandle_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.google.storage.v2.BidiReadHandle.class,
            com.google.storage.v2.BidiReadHandle.Builder.class);
  }

  public static final int HANDLE_FIELD_NUMBER = 1;
  private com.google.protobuf.ByteString handle_ = com.google.protobuf.ByteString.EMPTY;

  /**
   *
   *
   * <pre>
   * Required. Opaque value describing a previous read.
   * </pre>
   *
   * <code>bytes handle = 1 [(.google.api.field_behavior) = REQUIRED];</code>
   *
   * @return The handle.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString getHandle() {
    return handle_;
  }

  private byte memoizedIsInitialized = -1;

  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output) throws java.io.IOException {
    if (!handle_.isEmpty()) {
      output.writeBytes(1, handle_);
    }
    getUnknownFields().writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (!handle_.isEmpty()) {
      size += com.google.protobuf.CodedOutputStream.computeBytesSize(1, handle_);
    }
    size += getUnknownFields().getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
      return true;
    }
    if (!(obj instanceof com.google.storage.v2.BidiReadHandle)) {
      return super.equals(obj);
    }
    com.google.storage.v2.BidiReadHandle other = (com.google.storage.v2.BidiReadHandle) obj;

    if (!getHandle().equals(other.getHandle())) return false;
    if (!getUnknownFields().equals(other.getUnknownFields())) return false;
    return true;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    hash = (37 * hash) + HANDLE_FIELD_NUMBER;
    hash = (53 * hash) + getHandle().hashCode();
    hash = (29 * hash) + getUnknownFields().hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.google.storage.v2.BidiReadHandle parseFrom(java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }

  public static com.google.storage.v2.BidiReadHandle parseFrom(
      java.nio.ByteBuffer data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }

  public static com.google.storage.v2.BidiReadHandle parseFrom(com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }

  public static com.google.storage.v2.BidiReadHandle parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }

  public static com.google.storage.v2.BidiReadHandle parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }

  public static com.google.storage.v2.BidiReadHandle parseFrom(
      byte[] data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }

  public static com.google.storage.v2.BidiReadHandle parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
  }

  public static com.google.storage.v2.BidiReadHandle parseFrom(
      java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3.parseWithIOException(
        PARSER, input, extensionRegistry);
  }

  public static com.google.storage.v2.BidiReadHandle parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
  }

  public static com.google.storage.v2.BidiReadHandle parseDelimitedFrom(
      java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(
        PARSER, input, extensionRegistry);
  }

  public static com.google.storage.v2.BidiReadHandle parseFrom(
      com.google.protobuf.CodedInputStream input) throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
  }

  public static com.google.storage.v2.BidiReadHandle parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3.parseWithIOException(
        PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() {
    return newBuilder();
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(com.google.storage.v2.BidiReadHandle prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  @java.lang.Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }

  /**
   *
   *
   * <pre>
   * BidiReadHandle contains a handle from a previous BiDiReadObject
   * invocation. The client can use this instead of BidiReadObjectSpec as an
   * optimized way of opening subsequent bidirectional streams to the same object.
   * </pre>
   *
   * Protobuf type {@code google.storage.v2.BidiReadHandle}
   */
  public static final class Builder extends com.google.protobuf.GeneratedMessageV3.Builder<Builder>
      implements
      // @@protoc_insertion_point(builder_implements:google.storage.v2.BidiReadHandle)
      com.google.storage.v2.BidiReadHandleOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
      return com.google.storage.v2.StorageProto
          .internal_static_google_storage_v2_BidiReadHandle_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.google.storage.v2.StorageProto
          .internal_static_google_storage_v2_BidiReadHandle_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.google.storage.v2.BidiReadHandle.class,
              com.google.storage.v2.BidiReadHandle.Builder.class);
    }

    // Construct using com.google.storage.v2.BidiReadHandle.newBuilder()
    private Builder() {}

    private Builder(com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
    }

    @java.lang.Override
    public Builder clear() {
      super.clear();
      bitField0_ = 0;
      handle_ = com.google.protobuf.ByteString.EMPTY;
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor getDescriptorForType() {
      return com.google.storage.v2.StorageProto
          .internal_static_google_storage_v2_BidiReadHandle_descriptor;
    }

    @java.lang.Override
    public com.google.storage.v2.BidiReadHandle getDefaultInstanceForType() {
      return com.google.storage.v2.BidiReadHandle.getDefaultInstance();
    }

    @java.lang.Override
    public com.google.storage.v2.BidiReadHandle build() {
      com.google.storage.v2.BidiReadHandle result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public com.google.storage.v2.BidiReadHandle buildPartial() {
      com.google.storage.v2.BidiReadHandle result = new com.google.storage.v2.BidiReadHandle(this);
      if (bitField0_ != 0) {
        buildPartial0(result);
      }
      onBuilt();
      return result;
    }

    private void buildPartial0(com.google.storage.v2.BidiReadHandle result) {
      int from_bitField0_ = bitField0_;
      if (((from_bitField0_ & 0x00000001) != 0)) {
        result.handle_ = handle_;
      }
    }

    @java.lang.Override
    public Builder clone() {
      return super.clone();
    }

    @java.lang.Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field, java.lang.Object value) {
      return super.setField(field, value);
    }

    @java.lang.Override
    public Builder clearField(com.google.protobuf.Descriptors.FieldDescriptor field) {
      return super.clearField(field);
    }

    @java.lang.Override
    public Builder clearOneof(com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return super.clearOneof(oneof);
    }

    @java.lang.Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field, int index, java.lang.Object value) {
      return super.setRepeatedField(field, index, value);
    }

    @java.lang.Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field, java.lang.Object value) {
      return super.addRepeatedField(field, value);
    }

    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof com.google.storage.v2.BidiReadHandle) {
        return mergeFrom((com.google.storage.v2.BidiReadHandle) other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.google.storage.v2.BidiReadHandle other) {
      if (other == com.google.storage.v2.BidiReadHandle.getDefaultInstance()) return this;
      if (other.getHandle() != com.google.protobuf.ByteString.EMPTY) {
        setHandle(other.getHandle());
      }
      this.mergeUnknownFields(other.getUnknownFields());
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      return true;
    }

    @java.lang.Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      if (extensionRegistry == null) {
        throw new java.lang.NullPointerException();
      }
      try {
        boolean done = false;
        while (!done) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              done = true;
              break;
            case 10:
              {
                handle_ = input.readBytes();
                bitField0_ |= 0x00000001;
                break;
              } // case 10
            default:
              {
                if (!super.parseUnknownField(input, extensionRegistry, tag)) {
                  done = true; // was an endgroup tag
                }
                break;
              } // default:
          } // switch (tag)
        } // while (!done)
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.unwrapIOException();
      } finally {
        onChanged();
      } // finally
      return this;
    }

    private int bitField0_;

    private com.google.protobuf.ByteString handle_ = com.google.protobuf.ByteString.EMPTY;

    /**
     *
     *
     * <pre>
     * Required. Opaque value describing a previous read.
     * </pre>
     *
     * <code>bytes handle = 1 [(.google.api.field_behavior) = REQUIRED];</code>
     *
     * @return The handle.
     */
    @java.lang.Override
    public com.google.protobuf.ByteString getHandle() {
      return handle_;
    }

    /**
     *
     *
     * <pre>
     * Required. Opaque value describing a previous read.
     * </pre>
     *
     * <code>bytes handle = 1 [(.google.api.field_behavior) = REQUIRED];</code>
     *
     * @param value The handle to set.
     * @return This builder for chaining.
     */
    public Builder setHandle(com.google.protobuf.ByteString value) {
      if (value == null) {
        throw new NullPointerException();
      }
      handle_ = value;
      bitField0_ |= 0x00000001;
      onChanged();
      return this;
    }

    /**
     *
     *
     * <pre>
     * Required. Opaque value describing a previous read.
     * </pre>
     *
     * <code>bytes handle = 1 [(.google.api.field_behavior) = REQUIRED];</code>
     *
     * @return This builder for chaining.
     */
    public Builder clearHandle() {
      bitField0_ = (bitField0_ & ~0x00000001);
      handle_ = getDefaultInstance().getHandle();
      onChanged();
      return this;
    }

    @java.lang.Override
    public final Builder setUnknownFields(final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFields(unknownFields);
    }

    @java.lang.Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }

    // @@protoc_insertion_point(builder_scope:google.storage.v2.BidiReadHandle)
  }

  // @@protoc_insertion_point(class_scope:google.storage.v2.BidiReadHandle)
  private static final com.google.storage.v2.BidiReadHandle DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new com.google.storage.v2.BidiReadHandle();
  }

  public static com.google.storage.v2.BidiReadHandle getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<BidiReadHandle> PARSER =
      new com.google.protobuf.AbstractParser<BidiReadHandle>() {
        @java.lang.Override
        public BidiReadHandle parsePartialFrom(
            com.google.protobuf.CodedInputStream input,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws com.google.protobuf.InvalidProtocolBufferException {
          Builder builder = newBuilder();
          try {
            builder.mergeFrom(input, extensionRegistry);
          } catch (com.google.protobuf.InvalidProtocolBufferException e) {
            throw e.setUnfinishedMessage(builder.buildPartial());
          } catch (com.google.protobuf.UninitializedMessageException e) {
            throw e.asInvalidProtocolBufferException().setUnfinishedMessage(builder.buildPartial());
          } catch (java.io.IOException e) {
            throw new com.google.protobuf.InvalidProtocolBufferException(e)
                .setUnfinishedMessage(builder.buildPartial());
          }
          return builder.buildPartial();
        }
      };

  public static com.google.protobuf.Parser<BidiReadHandle> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<BidiReadHandle> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.storage.v2.BidiReadHandle getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }
}
