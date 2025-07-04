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
 * Describes a range of bytes to read in a BidiReadObjectRanges request.
 * </pre>
 *
 * Protobuf type {@code google.storage.v2.ReadRange}
 */
public final class ReadRange extends com.google.protobuf.GeneratedMessageV3
    implements
    // @@protoc_insertion_point(message_implements:google.storage.v2.ReadRange)
    ReadRangeOrBuilder {
  private static final long serialVersionUID = 0L;

  // Use ReadRange.newBuilder() to construct.
  private ReadRange(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }

  private ReadRange() {}

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(UnusedPrivateParameter unused) {
    return new ReadRange();
  }

  public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
    return com.google.storage.v2.StorageProto
        .internal_static_google_storage_v2_ReadRange_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.google.storage.v2.StorageProto
        .internal_static_google_storage_v2_ReadRange_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.google.storage.v2.ReadRange.class, com.google.storage.v2.ReadRange.Builder.class);
  }

  public static final int READ_OFFSET_FIELD_NUMBER = 1;
  private long readOffset_ = 0L;

  /**
   *
   *
   * <pre>
   * Required. The offset for the first byte to return in the read, relative to
   * the start of the object.
   *
   * A negative read_offset value will be interpreted as the number of bytes
   * back from the end of the object to be returned. For example, if an object's
   * length is 15 bytes, a ReadObjectRequest with read_offset = -5 and
   * read_length = 3 would return bytes 10 through 12 of the object. Requesting
   * a negative offset with magnitude larger than the size of the object will
   * return the entire object. A read_offset larger than the size of the object
   * will result in an OutOfRange error.
   * </pre>
   *
   * <code>int64 read_offset = 1 [(.google.api.field_behavior) = REQUIRED];</code>
   *
   * @return The readOffset.
   */
  @java.lang.Override
  public long getReadOffset() {
    return readOffset_;
  }

  public static final int READ_LENGTH_FIELD_NUMBER = 2;
  private long readLength_ = 0L;

  /**
   *
   *
   * <pre>
   * Optional. The maximum number of data bytes the server is allowed to return
   * across all response messages with the same read_id. A read_length of zero
   * indicates to read until the resource end, and a negative read_length will
   * cause an error. If the stream returns fewer bytes than allowed by the
   * read_length and no error occurred, the stream includes all data from the
   * read_offset to the resource end.
   * </pre>
   *
   * <code>int64 read_length = 2 [(.google.api.field_behavior) = OPTIONAL];</code>
   *
   * @return The readLength.
   */
  @java.lang.Override
  public long getReadLength() {
    return readLength_;
  }

  public static final int READ_ID_FIELD_NUMBER = 3;
  private long readId_ = 0L;

  /**
   *
   *
   * <pre>
   * Required. Read identifier provided by the client. When the client issues
   * more than one outstanding ReadRange on the same stream, responses can be
   * mapped back to their corresponding requests using this value. Clients must
   * ensure that all outstanding requests have different read_id values. The
   * server may close the stream with an error if this condition is not met.
   * </pre>
   *
   * <code>int64 read_id = 3 [(.google.api.field_behavior) = REQUIRED];</code>
   *
   * @return The readId.
   */
  @java.lang.Override
  public long getReadId() {
    return readId_;
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
    if (readOffset_ != 0L) {
      output.writeInt64(1, readOffset_);
    }
    if (readLength_ != 0L) {
      output.writeInt64(2, readLength_);
    }
    if (readId_ != 0L) {
      output.writeInt64(3, readId_);
    }
    getUnknownFields().writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (readOffset_ != 0L) {
      size += com.google.protobuf.CodedOutputStream.computeInt64Size(1, readOffset_);
    }
    if (readLength_ != 0L) {
      size += com.google.protobuf.CodedOutputStream.computeInt64Size(2, readLength_);
    }
    if (readId_ != 0L) {
      size += com.google.protobuf.CodedOutputStream.computeInt64Size(3, readId_);
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
    if (!(obj instanceof com.google.storage.v2.ReadRange)) {
      return super.equals(obj);
    }
    com.google.storage.v2.ReadRange other = (com.google.storage.v2.ReadRange) obj;

    if (getReadOffset() != other.getReadOffset()) return false;
    if (getReadLength() != other.getReadLength()) return false;
    if (getReadId() != other.getReadId()) return false;
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
    hash = (37 * hash) + READ_OFFSET_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(getReadOffset());
    hash = (37 * hash) + READ_LENGTH_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(getReadLength());
    hash = (37 * hash) + READ_ID_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(getReadId());
    hash = (29 * hash) + getUnknownFields().hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.google.storage.v2.ReadRange parseFrom(java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }

  public static com.google.storage.v2.ReadRange parseFrom(
      java.nio.ByteBuffer data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }

  public static com.google.storage.v2.ReadRange parseFrom(com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }

  public static com.google.storage.v2.ReadRange parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }

  public static com.google.storage.v2.ReadRange parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }

  public static com.google.storage.v2.ReadRange parseFrom(
      byte[] data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }

  public static com.google.storage.v2.ReadRange parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
  }

  public static com.google.storage.v2.ReadRange parseFrom(
      java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3.parseWithIOException(
        PARSER, input, extensionRegistry);
  }

  public static com.google.storage.v2.ReadRange parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
  }

  public static com.google.storage.v2.ReadRange parseDelimitedFrom(
      java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(
        PARSER, input, extensionRegistry);
  }

  public static com.google.storage.v2.ReadRange parseFrom(
      com.google.protobuf.CodedInputStream input) throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
  }

  public static com.google.storage.v2.ReadRange parseFrom(
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

  public static Builder newBuilder(com.google.storage.v2.ReadRange prototype) {
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
   * Describes a range of bytes to read in a BidiReadObjectRanges request.
   * </pre>
   *
   * Protobuf type {@code google.storage.v2.ReadRange}
   */
  public static final class Builder extends com.google.protobuf.GeneratedMessageV3.Builder<Builder>
      implements
      // @@protoc_insertion_point(builder_implements:google.storage.v2.ReadRange)
      com.google.storage.v2.ReadRangeOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
      return com.google.storage.v2.StorageProto
          .internal_static_google_storage_v2_ReadRange_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.google.storage.v2.StorageProto
          .internal_static_google_storage_v2_ReadRange_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.google.storage.v2.ReadRange.class, com.google.storage.v2.ReadRange.Builder.class);
    }

    // Construct using com.google.storage.v2.ReadRange.newBuilder()
    private Builder() {}

    private Builder(com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
    }

    @java.lang.Override
    public Builder clear() {
      super.clear();
      bitField0_ = 0;
      readOffset_ = 0L;
      readLength_ = 0L;
      readId_ = 0L;
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor getDescriptorForType() {
      return com.google.storage.v2.StorageProto
          .internal_static_google_storage_v2_ReadRange_descriptor;
    }

    @java.lang.Override
    public com.google.storage.v2.ReadRange getDefaultInstanceForType() {
      return com.google.storage.v2.ReadRange.getDefaultInstance();
    }

    @java.lang.Override
    public com.google.storage.v2.ReadRange build() {
      com.google.storage.v2.ReadRange result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public com.google.storage.v2.ReadRange buildPartial() {
      com.google.storage.v2.ReadRange result = new com.google.storage.v2.ReadRange(this);
      if (bitField0_ != 0) {
        buildPartial0(result);
      }
      onBuilt();
      return result;
    }

    private void buildPartial0(com.google.storage.v2.ReadRange result) {
      int from_bitField0_ = bitField0_;
      if (((from_bitField0_ & 0x00000001) != 0)) {
        result.readOffset_ = readOffset_;
      }
      if (((from_bitField0_ & 0x00000002) != 0)) {
        result.readLength_ = readLength_;
      }
      if (((from_bitField0_ & 0x00000004) != 0)) {
        result.readId_ = readId_;
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
      if (other instanceof com.google.storage.v2.ReadRange) {
        return mergeFrom((com.google.storage.v2.ReadRange) other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.google.storage.v2.ReadRange other) {
      if (other == com.google.storage.v2.ReadRange.getDefaultInstance()) return this;
      if (other.getReadOffset() != 0L) {
        setReadOffset(other.getReadOffset());
      }
      if (other.getReadLength() != 0L) {
        setReadLength(other.getReadLength());
      }
      if (other.getReadId() != 0L) {
        setReadId(other.getReadId());
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
            case 8:
              {
                readOffset_ = input.readInt64();
                bitField0_ |= 0x00000001;
                break;
              } // case 8
            case 16:
              {
                readLength_ = input.readInt64();
                bitField0_ |= 0x00000002;
                break;
              } // case 16
            case 24:
              {
                readId_ = input.readInt64();
                bitField0_ |= 0x00000004;
                break;
              } // case 24
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

    private long readOffset_;

    /**
     *
     *
     * <pre>
     * Required. The offset for the first byte to return in the read, relative to
     * the start of the object.
     *
     * A negative read_offset value will be interpreted as the number of bytes
     * back from the end of the object to be returned. For example, if an object's
     * length is 15 bytes, a ReadObjectRequest with read_offset = -5 and
     * read_length = 3 would return bytes 10 through 12 of the object. Requesting
     * a negative offset with magnitude larger than the size of the object will
     * return the entire object. A read_offset larger than the size of the object
     * will result in an OutOfRange error.
     * </pre>
     *
     * <code>int64 read_offset = 1 [(.google.api.field_behavior) = REQUIRED];</code>
     *
     * @return The readOffset.
     */
    @java.lang.Override
    public long getReadOffset() {
      return readOffset_;
    }

    /**
     *
     *
     * <pre>
     * Required. The offset for the first byte to return in the read, relative to
     * the start of the object.
     *
     * A negative read_offset value will be interpreted as the number of bytes
     * back from the end of the object to be returned. For example, if an object's
     * length is 15 bytes, a ReadObjectRequest with read_offset = -5 and
     * read_length = 3 would return bytes 10 through 12 of the object. Requesting
     * a negative offset with magnitude larger than the size of the object will
     * return the entire object. A read_offset larger than the size of the object
     * will result in an OutOfRange error.
     * </pre>
     *
     * <code>int64 read_offset = 1 [(.google.api.field_behavior) = REQUIRED];</code>
     *
     * @param value The readOffset to set.
     * @return This builder for chaining.
     */
    public Builder setReadOffset(long value) {

      readOffset_ = value;
      bitField0_ |= 0x00000001;
      onChanged();
      return this;
    }

    /**
     *
     *
     * <pre>
     * Required. The offset for the first byte to return in the read, relative to
     * the start of the object.
     *
     * A negative read_offset value will be interpreted as the number of bytes
     * back from the end of the object to be returned. For example, if an object's
     * length is 15 bytes, a ReadObjectRequest with read_offset = -5 and
     * read_length = 3 would return bytes 10 through 12 of the object. Requesting
     * a negative offset with magnitude larger than the size of the object will
     * return the entire object. A read_offset larger than the size of the object
     * will result in an OutOfRange error.
     * </pre>
     *
     * <code>int64 read_offset = 1 [(.google.api.field_behavior) = REQUIRED];</code>
     *
     * @return This builder for chaining.
     */
    public Builder clearReadOffset() {
      bitField0_ = (bitField0_ & ~0x00000001);
      readOffset_ = 0L;
      onChanged();
      return this;
    }

    private long readLength_;

    /**
     *
     *
     * <pre>
     * Optional. The maximum number of data bytes the server is allowed to return
     * across all response messages with the same read_id. A read_length of zero
     * indicates to read until the resource end, and a negative read_length will
     * cause an error. If the stream returns fewer bytes than allowed by the
     * read_length and no error occurred, the stream includes all data from the
     * read_offset to the resource end.
     * </pre>
     *
     * <code>int64 read_length = 2 [(.google.api.field_behavior) = OPTIONAL];</code>
     *
     * @return The readLength.
     */
    @java.lang.Override
    public long getReadLength() {
      return readLength_;
    }

    /**
     *
     *
     * <pre>
     * Optional. The maximum number of data bytes the server is allowed to return
     * across all response messages with the same read_id. A read_length of zero
     * indicates to read until the resource end, and a negative read_length will
     * cause an error. If the stream returns fewer bytes than allowed by the
     * read_length and no error occurred, the stream includes all data from the
     * read_offset to the resource end.
     * </pre>
     *
     * <code>int64 read_length = 2 [(.google.api.field_behavior) = OPTIONAL];</code>
     *
     * @param value The readLength to set.
     * @return This builder for chaining.
     */
    public Builder setReadLength(long value) {

      readLength_ = value;
      bitField0_ |= 0x00000002;
      onChanged();
      return this;
    }

    /**
     *
     *
     * <pre>
     * Optional. The maximum number of data bytes the server is allowed to return
     * across all response messages with the same read_id. A read_length of zero
     * indicates to read until the resource end, and a negative read_length will
     * cause an error. If the stream returns fewer bytes than allowed by the
     * read_length and no error occurred, the stream includes all data from the
     * read_offset to the resource end.
     * </pre>
     *
     * <code>int64 read_length = 2 [(.google.api.field_behavior) = OPTIONAL];</code>
     *
     * @return This builder for chaining.
     */
    public Builder clearReadLength() {
      bitField0_ = (bitField0_ & ~0x00000002);
      readLength_ = 0L;
      onChanged();
      return this;
    }

    private long readId_;

    /**
     *
     *
     * <pre>
     * Required. Read identifier provided by the client. When the client issues
     * more than one outstanding ReadRange on the same stream, responses can be
     * mapped back to their corresponding requests using this value. Clients must
     * ensure that all outstanding requests have different read_id values. The
     * server may close the stream with an error if this condition is not met.
     * </pre>
     *
     * <code>int64 read_id = 3 [(.google.api.field_behavior) = REQUIRED];</code>
     *
     * @return The readId.
     */
    @java.lang.Override
    public long getReadId() {
      return readId_;
    }

    /**
     *
     *
     * <pre>
     * Required. Read identifier provided by the client. When the client issues
     * more than one outstanding ReadRange on the same stream, responses can be
     * mapped back to their corresponding requests using this value. Clients must
     * ensure that all outstanding requests have different read_id values. The
     * server may close the stream with an error if this condition is not met.
     * </pre>
     *
     * <code>int64 read_id = 3 [(.google.api.field_behavior) = REQUIRED];</code>
     *
     * @param value The readId to set.
     * @return This builder for chaining.
     */
    public Builder setReadId(long value) {

      readId_ = value;
      bitField0_ |= 0x00000004;
      onChanged();
      return this;
    }

    /**
     *
     *
     * <pre>
     * Required. Read identifier provided by the client. When the client issues
     * more than one outstanding ReadRange on the same stream, responses can be
     * mapped back to their corresponding requests using this value. Clients must
     * ensure that all outstanding requests have different read_id values. The
     * server may close the stream with an error if this condition is not met.
     * </pre>
     *
     * <code>int64 read_id = 3 [(.google.api.field_behavior) = REQUIRED];</code>
     *
     * @return This builder for chaining.
     */
    public Builder clearReadId() {
      bitField0_ = (bitField0_ & ~0x00000004);
      readId_ = 0L;
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

    // @@protoc_insertion_point(builder_scope:google.storage.v2.ReadRange)
  }

  // @@protoc_insertion_point(class_scope:google.storage.v2.ReadRange)
  private static final com.google.storage.v2.ReadRange DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new com.google.storage.v2.ReadRange();
  }

  public static com.google.storage.v2.ReadRange getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<ReadRange> PARSER =
      new com.google.protobuf.AbstractParser<ReadRange>() {
        @java.lang.Override
        public ReadRange parsePartialFrom(
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

  public static com.google.protobuf.Parser<ReadRange> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<ReadRange> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.storage.v2.ReadRange getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }
}
