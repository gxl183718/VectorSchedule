// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: vector.proto

package cn.ac.iie.grpc;

/**
 * Protobuf type {@code BytesResponse}
 */
public  final class BytesResponse extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:BytesResponse)
    BytesResponseOrBuilder {
private static final long serialVersionUID = 0L;
  // Use BytesResponse.newBuilder() to construct.
  private BytesResponse(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private BytesResponse() {
    code_ = "";
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private BytesResponse(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new java.lang.NullPointerException();
    }
    int mutable_bitField0_ = 0;
    com.google.protobuf.UnknownFieldSet.Builder unknownFields =
        com.google.protobuf.UnknownFieldSet.newBuilder();
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          case 10: {
            if (!((mutable_bitField0_ & 0x00000001) != 0)) {
              vectorBytes_ = com.google.protobuf.MapField.newMapField(
                  VectorBytesDefaultEntryHolder.defaultEntry);
              mutable_bitField0_ |= 0x00000001;
            }
            com.google.protobuf.MapEntry<java.lang.String, com.google.protobuf.ByteString>
            vectorBytes__ = input.readMessage(
                VectorBytesDefaultEntryHolder.defaultEntry.getParserForType(), extensionRegistry);
            vectorBytes_.getMutableMap().put(
                vectorBytes__.getKey(), vectorBytes__.getValue());
            break;
          }
          case 18: {
            java.lang.String s = input.readStringRequireUtf8();

            code_ = s;
            break;
          }
          default: {
            if (!parseUnknownField(
                input, unknownFields, extensionRegistry, tag)) {
              done = true;
            }
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return cn.ac.iie.grpc.VectorServer.internal_static_BytesResponse_descriptor;
  }

  @SuppressWarnings({"rawtypes"})
  @java.lang.Override
  protected com.google.protobuf.MapField internalGetMapField(
      int number) {
    switch (number) {
      case 1:
        return internalGetVectorBytes();
      default:
        throw new RuntimeException(
            "Invalid map field number: " + number);
    }
  }
  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return cn.ac.iie.grpc.VectorServer.internal_static_BytesResponse_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            cn.ac.iie.grpc.BytesResponse.class, cn.ac.iie.grpc.BytesResponse.Builder.class);
  }

  private int bitField0_;
  public static final int VECTORBYTES_FIELD_NUMBER = 1;
  private static final class VectorBytesDefaultEntryHolder {
    static final com.google.protobuf.MapEntry<
        java.lang.String, com.google.protobuf.ByteString> defaultEntry =
            com.google.protobuf.MapEntry
            .<java.lang.String, com.google.protobuf.ByteString>newDefaultInstance(
                cn.ac.iie.grpc.VectorServer.internal_static_BytesResponse_VectorBytesEntry_descriptor, 
                com.google.protobuf.WireFormat.FieldType.STRING,
                "",
                com.google.protobuf.WireFormat.FieldType.BYTES,
                com.google.protobuf.ByteString.EMPTY);
  }
  private com.google.protobuf.MapField<
      java.lang.String, com.google.protobuf.ByteString> vectorBytes_;
  private com.google.protobuf.MapField<java.lang.String, com.google.protobuf.ByteString>
  internalGetVectorBytes() {
    if (vectorBytes_ == null) {
      return com.google.protobuf.MapField.emptyMapField(
          VectorBytesDefaultEntryHolder.defaultEntry);
    }
    return vectorBytes_;
  }

  public int getVectorBytesCount() {
    return internalGetVectorBytes().getMap().size();
  }
  /**
   * <code>map&lt;string, bytes&gt; vectorBytes = 1;</code>
   */

  public boolean containsVectorBytes(
      java.lang.String key) {
    if (key == null) { throw new java.lang.NullPointerException(); }
    return internalGetVectorBytes().getMap().containsKey(key);
  }
  /**
   * Use {@link #getVectorBytesMap()} instead.
   */
  @java.lang.Deprecated
  public java.util.Map<java.lang.String, com.google.protobuf.ByteString> getVectorBytes() {
    return getVectorBytesMap();
  }
  /**
   * <code>map&lt;string, bytes&gt; vectorBytes = 1;</code>
   */

  public java.util.Map<java.lang.String, com.google.protobuf.ByteString> getVectorBytesMap() {
    return internalGetVectorBytes().getMap();
  }
  /**
   * <code>map&lt;string, bytes&gt; vectorBytes = 1;</code>
   */

  public com.google.protobuf.ByteString getVectorBytesOrDefault(
      java.lang.String key,
      com.google.protobuf.ByteString defaultValue) {
    if (key == null) { throw new java.lang.NullPointerException(); }
    java.util.Map<java.lang.String, com.google.protobuf.ByteString> map =
        internalGetVectorBytes().getMap();
    return map.containsKey(key) ? map.get(key) : defaultValue;
  }
  /**
   * <code>map&lt;string, bytes&gt; vectorBytes = 1;</code>
   */

  public com.google.protobuf.ByteString getVectorBytesOrThrow(
      java.lang.String key) {
    if (key == null) { throw new java.lang.NullPointerException(); }
    java.util.Map<java.lang.String, com.google.protobuf.ByteString> map =
        internalGetVectorBytes().getMap();
    if (!map.containsKey(key)) {
      throw new java.lang.IllegalArgumentException();
    }
    return map.get(key);
  }

  public static final int CODE_FIELD_NUMBER = 2;
  private volatile java.lang.Object code_;
  /**
   * <code>string code = 2;</code>
   */
  public java.lang.String getCode() {
    java.lang.Object ref = code_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      code_ = s;
      return s;
    }
  }
  /**
   * <code>string code = 2;</code>
   */
  public com.google.protobuf.ByteString
      getCodeBytes() {
    java.lang.Object ref = code_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      code_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
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
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    com.google.protobuf.GeneratedMessageV3
      .serializeStringMapTo(
        output,
        internalGetVectorBytes(),
        VectorBytesDefaultEntryHolder.defaultEntry,
        1);
    if (!getCodeBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 2, code_);
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    for (java.util.Map.Entry<java.lang.String, com.google.protobuf.ByteString> entry
         : internalGetVectorBytes().getMap().entrySet()) {
      com.google.protobuf.MapEntry<java.lang.String, com.google.protobuf.ByteString>
      vectorBytes__ = VectorBytesDefaultEntryHolder.defaultEntry.newBuilderForType()
          .setKey(entry.getKey())
          .setValue(entry.getValue())
          .build();
      size += com.google.protobuf.CodedOutputStream
          .computeMessageSize(1, vectorBytes__);
    }
    if (!getCodeBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, code_);
    }
    size += unknownFields.getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof cn.ac.iie.grpc.BytesResponse)) {
      return super.equals(obj);
    }
    cn.ac.iie.grpc.BytesResponse other = (cn.ac.iie.grpc.BytesResponse) obj;

    if (!internalGetVectorBytes().equals(
        other.internalGetVectorBytes())) return false;
    if (!getCode()
        .equals(other.getCode())) return false;
    if (!unknownFields.equals(other.unknownFields)) return false;
    return true;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    if (!internalGetVectorBytes().getMap().isEmpty()) {
      hash = (37 * hash) + VECTORBYTES_FIELD_NUMBER;
      hash = (53 * hash) + internalGetVectorBytes().hashCode();
    }
    hash = (37 * hash) + CODE_FIELD_NUMBER;
    hash = (53 * hash) + getCode().hashCode();
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static cn.ac.iie.grpc.BytesResponse parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static cn.ac.iie.grpc.BytesResponse parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static cn.ac.iie.grpc.BytesResponse parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static cn.ac.iie.grpc.BytesResponse parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static cn.ac.iie.grpc.BytesResponse parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static cn.ac.iie.grpc.BytesResponse parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static cn.ac.iie.grpc.BytesResponse parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static cn.ac.iie.grpc.BytesResponse parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static cn.ac.iie.grpc.BytesResponse parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static cn.ac.iie.grpc.BytesResponse parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static cn.ac.iie.grpc.BytesResponse parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static cn.ac.iie.grpc.BytesResponse parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(cn.ac.iie.grpc.BytesResponse prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @java.lang.Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code BytesResponse}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:BytesResponse)
      cn.ac.iie.grpc.BytesResponseOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return cn.ac.iie.grpc.VectorServer.internal_static_BytesResponse_descriptor;
    }

    @SuppressWarnings({"rawtypes"})
    protected com.google.protobuf.MapField internalGetMapField(
        int number) {
      switch (number) {
        case 1:
          return internalGetVectorBytes();
        default:
          throw new RuntimeException(
              "Invalid map field number: " + number);
      }
    }
    @SuppressWarnings({"rawtypes"})
    protected com.google.protobuf.MapField internalGetMutableMapField(
        int number) {
      switch (number) {
        case 1:
          return internalGetMutableVectorBytes();
        default:
          throw new RuntimeException(
              "Invalid map field number: " + number);
      }
    }
    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return cn.ac.iie.grpc.VectorServer.internal_static_BytesResponse_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              cn.ac.iie.grpc.BytesResponse.class, cn.ac.iie.grpc.BytesResponse.Builder.class);
    }

    // Construct using cn.ac.iie.grpc.BytesResponse.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
      }
    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      internalGetMutableVectorBytes().clear();
      code_ = "";

      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return cn.ac.iie.grpc.VectorServer.internal_static_BytesResponse_descriptor;
    }

    @java.lang.Override
    public cn.ac.iie.grpc.BytesResponse getDefaultInstanceForType() {
      return cn.ac.iie.grpc.BytesResponse.getDefaultInstance();
    }

    @java.lang.Override
    public cn.ac.iie.grpc.BytesResponse build() {
      cn.ac.iie.grpc.BytesResponse result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public cn.ac.iie.grpc.BytesResponse buildPartial() {
      cn.ac.iie.grpc.BytesResponse result = new cn.ac.iie.grpc.BytesResponse(this);
      int from_bitField0_ = bitField0_;
      int to_bitField0_ = 0;
      result.vectorBytes_ = internalGetVectorBytes();
      result.vectorBytes_.makeImmutable();
      result.code_ = code_;
      result.bitField0_ = to_bitField0_;
      onBuilt();
      return result;
    }

    @java.lang.Override
    public Builder clone() {
      return super.clone();
    }
    @java.lang.Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.setField(field, value);
    }
    @java.lang.Override
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return super.clearField(field);
    }
    @java.lang.Override
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return super.clearOneof(oneof);
    }
    @java.lang.Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return super.setRepeatedField(field, index, value);
    }
    @java.lang.Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.addRepeatedField(field, value);
    }
    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof cn.ac.iie.grpc.BytesResponse) {
        return mergeFrom((cn.ac.iie.grpc.BytesResponse)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(cn.ac.iie.grpc.BytesResponse other) {
      if (other == cn.ac.iie.grpc.BytesResponse.getDefaultInstance()) return this;
      internalGetMutableVectorBytes().mergeFrom(
          other.internalGetVectorBytes());
      if (!other.getCode().isEmpty()) {
        code_ = other.code_;
        onChanged();
      }
      this.mergeUnknownFields(other.unknownFields);
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
      cn.ac.iie.grpc.BytesResponse parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (cn.ac.iie.grpc.BytesResponse) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }
    private int bitField0_;

    private com.google.protobuf.MapField<
        java.lang.String, com.google.protobuf.ByteString> vectorBytes_;
    private com.google.protobuf.MapField<java.lang.String, com.google.protobuf.ByteString>
    internalGetVectorBytes() {
      if (vectorBytes_ == null) {
        return com.google.protobuf.MapField.emptyMapField(
            VectorBytesDefaultEntryHolder.defaultEntry);
      }
      return vectorBytes_;
    }
    private com.google.protobuf.MapField<java.lang.String, com.google.protobuf.ByteString>
    internalGetMutableVectorBytes() {
      onChanged();;
      if (vectorBytes_ == null) {
        vectorBytes_ = com.google.protobuf.MapField.newMapField(
            VectorBytesDefaultEntryHolder.defaultEntry);
      }
      if (!vectorBytes_.isMutable()) {
        vectorBytes_ = vectorBytes_.copy();
      }
      return vectorBytes_;
    }

    public int getVectorBytesCount() {
      return internalGetVectorBytes().getMap().size();
    }
    /**
     * <code>map&lt;string, bytes&gt; vectorBytes = 1;</code>
     */

    public boolean containsVectorBytes(
        java.lang.String key) {
      if (key == null) { throw new java.lang.NullPointerException(); }
      return internalGetVectorBytes().getMap().containsKey(key);
    }
    /**
     * Use {@link #getVectorBytesMap()} instead.
     */
    @java.lang.Deprecated
    public java.util.Map<java.lang.String, com.google.protobuf.ByteString> getVectorBytes() {
      return getVectorBytesMap();
    }
    /**
     * <code>map&lt;string, bytes&gt; vectorBytes = 1;</code>
     */

    public java.util.Map<java.lang.String, com.google.protobuf.ByteString> getVectorBytesMap() {
      return internalGetVectorBytes().getMap();
    }
    /**
     * <code>map&lt;string, bytes&gt; vectorBytes = 1;</code>
     */

    public com.google.protobuf.ByteString getVectorBytesOrDefault(
        java.lang.String key,
        com.google.protobuf.ByteString defaultValue) {
      if (key == null) { throw new java.lang.NullPointerException(); }
      java.util.Map<java.lang.String, com.google.protobuf.ByteString> map =
          internalGetVectorBytes().getMap();
      return map.containsKey(key) ? map.get(key) : defaultValue;
    }
    /**
     * <code>map&lt;string, bytes&gt; vectorBytes = 1;</code>
     */

    public com.google.protobuf.ByteString getVectorBytesOrThrow(
        java.lang.String key) {
      if (key == null) { throw new java.lang.NullPointerException(); }
      java.util.Map<java.lang.String, com.google.protobuf.ByteString> map =
          internalGetVectorBytes().getMap();
      if (!map.containsKey(key)) {
        throw new java.lang.IllegalArgumentException();
      }
      return map.get(key);
    }

    public Builder clearVectorBytes() {
      internalGetMutableVectorBytes().getMutableMap()
          .clear();
      return this;
    }
    /**
     * <code>map&lt;string, bytes&gt; vectorBytes = 1;</code>
     */

    public Builder removeVectorBytes(
        java.lang.String key) {
      if (key == null) { throw new java.lang.NullPointerException(); }
      internalGetMutableVectorBytes().getMutableMap()
          .remove(key);
      return this;
    }
    /**
     * Use alternate mutation accessors instead.
     */
    @java.lang.Deprecated
    public java.util.Map<java.lang.String, com.google.protobuf.ByteString>
    getMutableVectorBytes() {
      return internalGetMutableVectorBytes().getMutableMap();
    }
    /**
     * <code>map&lt;string, bytes&gt; vectorBytes = 1;</code>
     */
    public Builder putVectorBytes(
        java.lang.String key,
        com.google.protobuf.ByteString value) {
      if (key == null) { throw new java.lang.NullPointerException(); }
      if (value == null) { throw new java.lang.NullPointerException(); }
      internalGetMutableVectorBytes().getMutableMap()
          .put(key, value);
      return this;
    }
    /**
     * <code>map&lt;string, bytes&gt; vectorBytes = 1;</code>
     */

    public Builder putAllVectorBytes(
        java.util.Map<java.lang.String, com.google.protobuf.ByteString> values) {
      internalGetMutableVectorBytes().getMutableMap()
          .putAll(values);
      return this;
    }

    private java.lang.Object code_ = "";
    /**
     * <code>string code = 2;</code>
     */
    public java.lang.String getCode() {
      java.lang.Object ref = code_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        code_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string code = 2;</code>
     */
    public com.google.protobuf.ByteString
        getCodeBytes() {
      java.lang.Object ref = code_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        code_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string code = 2;</code>
     */
    public Builder setCode(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      code_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string code = 2;</code>
     */
    public Builder clearCode() {
      
      code_ = getDefaultInstance().getCode();
      onChanged();
      return this;
    }
    /**
     * <code>string code = 2;</code>
     */
    public Builder setCodeBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      code_ = value;
      onChanged();
      return this;
    }
    @java.lang.Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFields(unknownFields);
    }

    @java.lang.Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:BytesResponse)
  }

  // @@protoc_insertion_point(class_scope:BytesResponse)
  private static final cn.ac.iie.grpc.BytesResponse DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new cn.ac.iie.grpc.BytesResponse();
  }

  public static cn.ac.iie.grpc.BytesResponse getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<BytesResponse>
      PARSER = new com.google.protobuf.AbstractParser<BytesResponse>() {
    @java.lang.Override
    public BytesResponse parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new BytesResponse(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<BytesResponse> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<BytesResponse> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public cn.ac.iie.grpc.BytesResponse getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}
