// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: stockManager.proto

package ds.stockManager;

/**
 * Protobuf type {@code stockmanager.RemoveStockMessage}
 */
public  final class RemoveStockMessage extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:stockmanager.RemoveStockMessage)
    RemoveStockMessageOrBuilder {
private static final long serialVersionUID = 0L;
  // Use RemoveStockMessage.newBuilder() to construct.
  private RemoveStockMessage(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private RemoveStockMessage() {
    isSuccess_ = false;
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private RemoveStockMessage(
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

            isSuccess_ = input.readBool();
            break;
          }
          case 18: {
            ds.stockManager.StockMessage.Builder subBuilder = null;
            if (stockMessage_ != null) {
              subBuilder = stockMessage_.toBuilder();
            }
            stockMessage_ = input.readMessage(ds.stockManager.StockMessage.parser(), extensionRegistry);
            if (subBuilder != null) {
              subBuilder.mergeFrom(stockMessage_);
              stockMessage_ = subBuilder.buildPartial();
            }

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
    return ds.stockManager.StockManagerImpl.internal_static_stockmanager_RemoveStockMessage_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return ds.stockManager.StockManagerImpl.internal_static_stockmanager_RemoveStockMessage_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            ds.stockManager.RemoveStockMessage.class, ds.stockManager.RemoveStockMessage.Builder.class);
  }

  public static final int ISSUCCESS_FIELD_NUMBER = 1;
  private boolean isSuccess_;
  /**
   * <pre>
   *true if there was enough stock to remove and was removed.
   * </pre>
   *
   * <code>bool isSuccess = 1;</code>
   */
  public boolean getIsSuccess() {
    return isSuccess_;
  }

  public static final int STOCKMESSAGE_FIELD_NUMBER = 2;
  private ds.stockManager.StockMessage stockMessage_;
  /**
   * <code>.stockmanager.StockMessage stockMessage = 2;</code>
   */
  public boolean hasStockMessage() {
    return stockMessage_ != null;
  }
  /**
   * <code>.stockmanager.StockMessage stockMessage = 2;</code>
   */
  public ds.stockManager.StockMessage getStockMessage() {
    return stockMessage_ == null ? ds.stockManager.StockMessage.getDefaultInstance() : stockMessage_;
  }
  /**
   * <code>.stockmanager.StockMessage stockMessage = 2;</code>
   */
  public ds.stockManager.StockMessageOrBuilder getStockMessageOrBuilder() {
    return getStockMessage();
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
    if (isSuccess_ != false) {
      output.writeBool(1, isSuccess_);
    }
    if (stockMessage_ != null) {
      output.writeMessage(2, getStockMessage());
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (isSuccess_ != false) {
      size += com.google.protobuf.CodedOutputStream
        .computeBoolSize(1, isSuccess_);
    }
    if (stockMessage_ != null) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(2, getStockMessage());
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
    if (!(obj instanceof ds.stockManager.RemoveStockMessage)) {
      return super.equals(obj);
    }
    ds.stockManager.RemoveStockMessage other = (ds.stockManager.RemoveStockMessage) obj;

    boolean result = true;
    result = result && (getIsSuccess()
        == other.getIsSuccess());
    result = result && (hasStockMessage() == other.hasStockMessage());
    if (hasStockMessage()) {
      result = result && getStockMessage()
          .equals(other.getStockMessage());
    }
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
    hash = (37 * hash) + ISSUCCESS_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashBoolean(
        getIsSuccess());
    if (hasStockMessage()) {
      hash = (37 * hash) + STOCKMESSAGE_FIELD_NUMBER;
      hash = (53 * hash) + getStockMessage().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static ds.stockManager.RemoveStockMessage parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static ds.stockManager.RemoveStockMessage parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static ds.stockManager.RemoveStockMessage parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static ds.stockManager.RemoveStockMessage parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static ds.stockManager.RemoveStockMessage parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static ds.stockManager.RemoveStockMessage parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static ds.stockManager.RemoveStockMessage parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static ds.stockManager.RemoveStockMessage parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static ds.stockManager.RemoveStockMessage parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static ds.stockManager.RemoveStockMessage parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static ds.stockManager.RemoveStockMessage parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static ds.stockManager.RemoveStockMessage parseFrom(
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
  public static Builder newBuilder(ds.stockManager.RemoveStockMessage prototype) {
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
   * Protobuf type {@code stockmanager.RemoveStockMessage}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:stockmanager.RemoveStockMessage)
      ds.stockManager.RemoveStockMessageOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return ds.stockManager.StockManagerImpl.internal_static_stockmanager_RemoveStockMessage_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return ds.stockManager.StockManagerImpl.internal_static_stockmanager_RemoveStockMessage_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              ds.stockManager.RemoveStockMessage.class, ds.stockManager.RemoveStockMessage.Builder.class);
    }

    // Construct using ds.stockManager.RemoveStockMessage.newBuilder()
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
      isSuccess_ = false;

      if (stockMessageBuilder_ == null) {
        stockMessage_ = null;
      } else {
        stockMessage_ = null;
        stockMessageBuilder_ = null;
      }
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return ds.stockManager.StockManagerImpl.internal_static_stockmanager_RemoveStockMessage_descriptor;
    }

    @java.lang.Override
    public ds.stockManager.RemoveStockMessage getDefaultInstanceForType() {
      return ds.stockManager.RemoveStockMessage.getDefaultInstance();
    }

    @java.lang.Override
    public ds.stockManager.RemoveStockMessage build() {
      ds.stockManager.RemoveStockMessage result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public ds.stockManager.RemoveStockMessage buildPartial() {
      ds.stockManager.RemoveStockMessage result = new ds.stockManager.RemoveStockMessage(this);
      result.isSuccess_ = isSuccess_;
      if (stockMessageBuilder_ == null) {
        result.stockMessage_ = stockMessage_;
      } else {
        result.stockMessage_ = stockMessageBuilder_.build();
      }
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
      if (other instanceof ds.stockManager.RemoveStockMessage) {
        return mergeFrom((ds.stockManager.RemoveStockMessage)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(ds.stockManager.RemoveStockMessage other) {
      if (other == ds.stockManager.RemoveStockMessage.getDefaultInstance()) return this;
      if (other.getIsSuccess() != false) {
        setIsSuccess(other.getIsSuccess());
      }
      if (other.hasStockMessage()) {
        mergeStockMessage(other.getStockMessage());
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
      ds.stockManager.RemoveStockMessage parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (ds.stockManager.RemoveStockMessage) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private boolean isSuccess_ ;
    /**
     * <pre>
     *true if there was enough stock to remove and was removed.
     * </pre>
     *
     * <code>bool isSuccess = 1;</code>
     */
    public boolean getIsSuccess() {
      return isSuccess_;
    }
    /**
     * <pre>
     *true if there was enough stock to remove and was removed.
     * </pre>
     *
     * <code>bool isSuccess = 1;</code>
     */
    public Builder setIsSuccess(boolean value) {
      
      isSuccess_ = value;
      onChanged();
      return this;
    }
    /**
     * <pre>
     *true if there was enough stock to remove and was removed.
     * </pre>
     *
     * <code>bool isSuccess = 1;</code>
     */
    public Builder clearIsSuccess() {
      
      isSuccess_ = false;
      onChanged();
      return this;
    }

    private ds.stockManager.StockMessage stockMessage_ = null;
    private com.google.protobuf.SingleFieldBuilderV3<
        ds.stockManager.StockMessage, ds.stockManager.StockMessage.Builder, ds.stockManager.StockMessageOrBuilder> stockMessageBuilder_;
    /**
     * <code>.stockmanager.StockMessage stockMessage = 2;</code>
     */
    public boolean hasStockMessage() {
      return stockMessageBuilder_ != null || stockMessage_ != null;
    }
    /**
     * <code>.stockmanager.StockMessage stockMessage = 2;</code>
     */
    public ds.stockManager.StockMessage getStockMessage() {
      if (stockMessageBuilder_ == null) {
        return stockMessage_ == null ? ds.stockManager.StockMessage.getDefaultInstance() : stockMessage_;
      } else {
        return stockMessageBuilder_.getMessage();
      }
    }
    /**
     * <code>.stockmanager.StockMessage stockMessage = 2;</code>
     */
    public Builder setStockMessage(ds.stockManager.StockMessage value) {
      if (stockMessageBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        stockMessage_ = value;
        onChanged();
      } else {
        stockMessageBuilder_.setMessage(value);
      }

      return this;
    }
    /**
     * <code>.stockmanager.StockMessage stockMessage = 2;</code>
     */
    public Builder setStockMessage(
        ds.stockManager.StockMessage.Builder builderForValue) {
      if (stockMessageBuilder_ == null) {
        stockMessage_ = builderForValue.build();
        onChanged();
      } else {
        stockMessageBuilder_.setMessage(builderForValue.build());
      }

      return this;
    }
    /**
     * <code>.stockmanager.StockMessage stockMessage = 2;</code>
     */
    public Builder mergeStockMessage(ds.stockManager.StockMessage value) {
      if (stockMessageBuilder_ == null) {
        if (stockMessage_ != null) {
          stockMessage_ =
            ds.stockManager.StockMessage.newBuilder(stockMessage_).mergeFrom(value).buildPartial();
        } else {
          stockMessage_ = value;
        }
        onChanged();
      } else {
        stockMessageBuilder_.mergeFrom(value);
      }

      return this;
    }
    /**
     * <code>.stockmanager.StockMessage stockMessage = 2;</code>
     */
    public Builder clearStockMessage() {
      if (stockMessageBuilder_ == null) {
        stockMessage_ = null;
        onChanged();
      } else {
        stockMessage_ = null;
        stockMessageBuilder_ = null;
      }

      return this;
    }
    /**
     * <code>.stockmanager.StockMessage stockMessage = 2;</code>
     */
    public ds.stockManager.StockMessage.Builder getStockMessageBuilder() {
      
      onChanged();
      return getStockMessageFieldBuilder().getBuilder();
    }
    /**
     * <code>.stockmanager.StockMessage stockMessage = 2;</code>
     */
    public ds.stockManager.StockMessageOrBuilder getStockMessageOrBuilder() {
      if (stockMessageBuilder_ != null) {
        return stockMessageBuilder_.getMessageOrBuilder();
      } else {
        return stockMessage_ == null ?
            ds.stockManager.StockMessage.getDefaultInstance() : stockMessage_;
      }
    }
    /**
     * <code>.stockmanager.StockMessage stockMessage = 2;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        ds.stockManager.StockMessage, ds.stockManager.StockMessage.Builder, ds.stockManager.StockMessageOrBuilder> 
        getStockMessageFieldBuilder() {
      if (stockMessageBuilder_ == null) {
        stockMessageBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            ds.stockManager.StockMessage, ds.stockManager.StockMessage.Builder, ds.stockManager.StockMessageOrBuilder>(
                getStockMessage(),
                getParentForChildren(),
                isClean());
        stockMessage_ = null;
      }
      return stockMessageBuilder_;
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


    // @@protoc_insertion_point(builder_scope:stockmanager.RemoveStockMessage)
  }

  // @@protoc_insertion_point(class_scope:stockmanager.RemoveStockMessage)
  private static final ds.stockManager.RemoveStockMessage DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new ds.stockManager.RemoveStockMessage();
  }

  public static ds.stockManager.RemoveStockMessage getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<RemoveStockMessage>
      PARSER = new com.google.protobuf.AbstractParser<RemoveStockMessage>() {
    @java.lang.Override
    public RemoveStockMessage parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new RemoveStockMessage(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<RemoveStockMessage> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<RemoveStockMessage> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public ds.stockManager.RemoveStockMessage getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}
