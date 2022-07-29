// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: alerter.proto

package ds.alerter;

/**
 * Protobuf type {@code alerter.AlertMessage}
 */
public  final class AlertMessage extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:alerter.AlertMessage)
    AlertMessageOrBuilder {
private static final long serialVersionUID = 0L;
  // Use AlertMessage.newBuilder() to construct.
  private AlertMessage(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private AlertMessage() {
    priorityLevel_ = 0;
    description_ = "";
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private AlertMessage(
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
          case 8: {
            int rawValue = input.readEnum();

            priorityLevel_ = rawValue;
            break;
          }
          case 18: {
            java.lang.String s = input.readStringRequireUtf8();

            description_ = s;
            break;
          }
          default: {
            if (!parseUnknownFieldProto3(
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
    return ds.alerter.AlerterImpl.internal_static_alerter_AlertMessage_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return ds.alerter.AlerterImpl.internal_static_alerter_AlertMessage_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            ds.alerter.AlertMessage.class, ds.alerter.AlertMessage.Builder.class);
  }

  /**
   * Protobuf enum {@code alerter.AlertMessage.PriorityLevel}
   */
  public enum PriorityLevel
      implements com.google.protobuf.ProtocolMessageEnum {
    /**
     * <pre>
     *Default
     * </pre>
     *
     * <code>MEDIUM = 0;</code>
     */
    MEDIUM(0),
    /**
     * <code>HIGH = 1;</code>
     */
    HIGH(1),
    /**
     * <code>LOW = 2;</code>
     */
    LOW(2),
    UNRECOGNIZED(-1),
    ;

    /**
     * <pre>
     *Default
     * </pre>
     *
     * <code>MEDIUM = 0;</code>
     */
    public static final int MEDIUM_VALUE = 0;
    /**
     * <code>HIGH = 1;</code>
     */
    public static final int HIGH_VALUE = 1;
    /**
     * <code>LOW = 2;</code>
     */
    public static final int LOW_VALUE = 2;


    public final int getNumber() {
      if (this == UNRECOGNIZED) {
        throw new java.lang.IllegalArgumentException(
            "Can't get the number of an unknown enum value.");
      }
      return value;
    }

    /**
     * @deprecated Use {@link #forNumber(int)} instead.
     */
    @java.lang.Deprecated
    public static PriorityLevel valueOf(int value) {
      return forNumber(value);
    }

    public static PriorityLevel forNumber(int value) {
      switch (value) {
        case 0: return MEDIUM;
        case 1: return HIGH;
        case 2: return LOW;
        default: return null;
      }
    }

    public static com.google.protobuf.Internal.EnumLiteMap<PriorityLevel>
        internalGetValueMap() {
      return internalValueMap;
    }
    private static final com.google.protobuf.Internal.EnumLiteMap<
        PriorityLevel> internalValueMap =
          new com.google.protobuf.Internal.EnumLiteMap<PriorityLevel>() {
            public PriorityLevel findValueByNumber(int number) {
              return PriorityLevel.forNumber(number);
            }
          };

    public final com.google.protobuf.Descriptors.EnumValueDescriptor
        getValueDescriptor() {
      return getDescriptor().getValues().get(ordinal());
    }
    public final com.google.protobuf.Descriptors.EnumDescriptor
        getDescriptorForType() {
      return getDescriptor();
    }
    public static final com.google.protobuf.Descriptors.EnumDescriptor
        getDescriptor() {
      return ds.alerter.AlertMessage.getDescriptor().getEnumTypes().get(0);
    }

    private static final PriorityLevel[] VALUES = values();

    public static PriorityLevel valueOf(
        com.google.protobuf.Descriptors.EnumValueDescriptor desc) {
      if (desc.getType() != getDescriptor()) {
        throw new java.lang.IllegalArgumentException(
          "EnumValueDescriptor is not for this type.");
      }
      if (desc.getIndex() == -1) {
        return UNRECOGNIZED;
      }
      return VALUES[desc.getIndex()];
    }

    private final int value;

    private PriorityLevel(int value) {
      this.value = value;
    }

    // @@protoc_insertion_point(enum_scope:alerter.AlertMessage.PriorityLevel)
  }

  public static final int PRIORITYLEVEL_FIELD_NUMBER = 1;
  private int priorityLevel_;
  /**
   * <code>.alerter.AlertMessage.PriorityLevel priorityLevel = 1;</code>
   */
  public int getPriorityLevelValue() {
    return priorityLevel_;
  }
  /**
   * <code>.alerter.AlertMessage.PriorityLevel priorityLevel = 1;</code>
   */
  public ds.alerter.AlertMessage.PriorityLevel getPriorityLevel() {
    @SuppressWarnings("deprecation")
    ds.alerter.AlertMessage.PriorityLevel result = ds.alerter.AlertMessage.PriorityLevel.valueOf(priorityLevel_);
    return result == null ? ds.alerter.AlertMessage.PriorityLevel.UNRECOGNIZED : result;
  }

  public static final int DESCRIPTION_FIELD_NUMBER = 2;
  private volatile java.lang.Object description_;
  /**
   * <code>string description = 2;</code>
   */
  public java.lang.String getDescription() {
    java.lang.Object ref = description_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      description_ = s;
      return s;
    }
  }
  /**
   * <code>string description = 2;</code>
   */
  public com.google.protobuf.ByteString
      getDescriptionBytes() {
    java.lang.Object ref = description_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      description_ = b;
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
    if (priorityLevel_ != ds.alerter.AlertMessage.PriorityLevel.MEDIUM.getNumber()) {
      output.writeEnum(1, priorityLevel_);
    }
    if (!getDescriptionBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 2, description_);
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (priorityLevel_ != ds.alerter.AlertMessage.PriorityLevel.MEDIUM.getNumber()) {
      size += com.google.protobuf.CodedOutputStream
        .computeEnumSize(1, priorityLevel_);
    }
    if (!getDescriptionBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, description_);
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
    if (!(obj instanceof ds.alerter.AlertMessage)) {
      return super.equals(obj);
    }
    ds.alerter.AlertMessage other = (ds.alerter.AlertMessage) obj;

    boolean result = true;
    result = result && priorityLevel_ == other.priorityLevel_;
    result = result && getDescription()
        .equals(other.getDescription());
    result = result && unknownFields.equals(other.unknownFields);
    return result;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    hash = (37 * hash) + PRIORITYLEVEL_FIELD_NUMBER;
    hash = (53 * hash) + priorityLevel_;
    hash = (37 * hash) + DESCRIPTION_FIELD_NUMBER;
    hash = (53 * hash) + getDescription().hashCode();
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static ds.alerter.AlertMessage parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static ds.alerter.AlertMessage parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static ds.alerter.AlertMessage parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static ds.alerter.AlertMessage parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static ds.alerter.AlertMessage parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static ds.alerter.AlertMessage parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static ds.alerter.AlertMessage parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static ds.alerter.AlertMessage parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static ds.alerter.AlertMessage parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static ds.alerter.AlertMessage parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static ds.alerter.AlertMessage parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static ds.alerter.AlertMessage parseFrom(
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
  public static Builder newBuilder(ds.alerter.AlertMessage prototype) {
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
   * Protobuf type {@code alerter.AlertMessage}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:alerter.AlertMessage)
      ds.alerter.AlertMessageOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return ds.alerter.AlerterImpl.internal_static_alerter_AlertMessage_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return ds.alerter.AlerterImpl.internal_static_alerter_AlertMessage_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              ds.alerter.AlertMessage.class, ds.alerter.AlertMessage.Builder.class);
    }

    // Construct using ds.alerter.AlertMessage.newBuilder()
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
      priorityLevel_ = 0;

      description_ = "";

      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return ds.alerter.AlerterImpl.internal_static_alerter_AlertMessage_descriptor;
    }

    @java.lang.Override
    public ds.alerter.AlertMessage getDefaultInstanceForType() {
      return ds.alerter.AlertMessage.getDefaultInstance();
    }

    @java.lang.Override
    public ds.alerter.AlertMessage build() {
      ds.alerter.AlertMessage result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public ds.alerter.AlertMessage buildPartial() {
      ds.alerter.AlertMessage result = new ds.alerter.AlertMessage(this);
      result.priorityLevel_ = priorityLevel_;
      result.description_ = description_;
      onBuilt();
      return result;
    }

    @java.lang.Override
    public Builder clone() {
      return (Builder) super.clone();
    }
    @java.lang.Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return (Builder) super.setField(field, value);
    }
    @java.lang.Override
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return (Builder) super.clearField(field);
    }
    @java.lang.Override
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return (Builder) super.clearOneof(oneof);
    }
    @java.lang.Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return (Builder) super.setRepeatedField(field, index, value);
    }
    @java.lang.Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return (Builder) super.addRepeatedField(field, value);
    }
    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof ds.alerter.AlertMessage) {
        return mergeFrom((ds.alerter.AlertMessage)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(ds.alerter.AlertMessage other) {
      if (other == ds.alerter.AlertMessage.getDefaultInstance()) return this;
      if (other.priorityLevel_ != 0) {
        setPriorityLevelValue(other.getPriorityLevelValue());
      }
      if (!other.getDescription().isEmpty()) {
        description_ = other.description_;
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
      ds.alerter.AlertMessage parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (ds.alerter.AlertMessage) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private int priorityLevel_ = 0;
    /**
     * <code>.alerter.AlertMessage.PriorityLevel priorityLevel = 1;</code>
     */
    public int getPriorityLevelValue() {
      return priorityLevel_;
    }
    /**
     * <code>.alerter.AlertMessage.PriorityLevel priorityLevel = 1;</code>
     */
    public Builder setPriorityLevelValue(int value) {
      priorityLevel_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>.alerter.AlertMessage.PriorityLevel priorityLevel = 1;</code>
     */
    public ds.alerter.AlertMessage.PriorityLevel getPriorityLevel() {
      @SuppressWarnings("deprecation")
      ds.alerter.AlertMessage.PriorityLevel result = ds.alerter.AlertMessage.PriorityLevel.valueOf(priorityLevel_);
      return result == null ? ds.alerter.AlertMessage.PriorityLevel.UNRECOGNIZED : result;
    }
    /**
     * <code>.alerter.AlertMessage.PriorityLevel priorityLevel = 1;</code>
     */
    public Builder setPriorityLevel(ds.alerter.AlertMessage.PriorityLevel value) {
      if (value == null) {
        throw new NullPointerException();
      }
      
      priorityLevel_ = value.getNumber();
      onChanged();
      return this;
    }
    /**
     * <code>.alerter.AlertMessage.PriorityLevel priorityLevel = 1;</code>
     */
    public Builder clearPriorityLevel() {
      
      priorityLevel_ = 0;
      onChanged();
      return this;
    }

    private java.lang.Object description_ = "";
    /**
     * <code>string description = 2;</code>
     */
    public java.lang.String getDescription() {
      java.lang.Object ref = description_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        description_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string description = 2;</code>
     */
    public com.google.protobuf.ByteString
        getDescriptionBytes() {
      java.lang.Object ref = description_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        description_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string description = 2;</code>
     */
    public Builder setDescription(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      description_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string description = 2;</code>
     */
    public Builder clearDescription() {
      
      description_ = getDefaultInstance().getDescription();
      onChanged();
      return this;
    }
    /**
     * <code>string description = 2;</code>
     */
    public Builder setDescriptionBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      description_ = value;
      onChanged();
      return this;
    }
    @java.lang.Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFieldsProto3(unknownFields);
    }

    @java.lang.Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:alerter.AlertMessage)
  }

  // @@protoc_insertion_point(class_scope:alerter.AlertMessage)
  private static final ds.alerter.AlertMessage DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new ds.alerter.AlertMessage();
  }

  public static ds.alerter.AlertMessage getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<AlertMessage>
      PARSER = new com.google.protobuf.AbstractParser<AlertMessage>() {
    @java.lang.Override
    public AlertMessage parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new AlertMessage(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<AlertMessage> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<AlertMessage> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public ds.alerter.AlertMessage getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

