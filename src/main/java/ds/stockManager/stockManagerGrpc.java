package ds.stockManager;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.15.0)",
    comments = "Source: stockManager.proto")
public final class stockManagerGrpc {

  private stockManagerGrpc() {}

  public static final String SERVICE_NAME = "stockmanager.stockManager";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<ds.stockManager.StockMessage,
      ds.stockManager.StockMessage> getAddStockMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "AddStock",
      requestType = ds.stockManager.StockMessage.class,
      responseType = ds.stockManager.StockMessage.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<ds.stockManager.StockMessage,
      ds.stockManager.StockMessage> getAddStockMethod() {
    io.grpc.MethodDescriptor<ds.stockManager.StockMessage, ds.stockManager.StockMessage> getAddStockMethod;
    if ((getAddStockMethod = stockManagerGrpc.getAddStockMethod) == null) {
      synchronized (stockManagerGrpc.class) {
        if ((getAddStockMethod = stockManagerGrpc.getAddStockMethod) == null) {
          stockManagerGrpc.getAddStockMethod = getAddStockMethod = 
              io.grpc.MethodDescriptor.<ds.stockManager.StockMessage, ds.stockManager.StockMessage>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "stockmanager.stockManager", "AddStock"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.stockManager.StockMessage.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.stockManager.StockMessage.getDefaultInstance()))
                  .setSchemaDescriptor(new stockManagerMethodDescriptorSupplier("AddStock"))
                  .build();
          }
        }
     }
     return getAddStockMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ds.stockManager.StockMessage,
      ds.stockManager.RemoveStockMessage> getRemoveStockMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "RemoveStock",
      requestType = ds.stockManager.StockMessage.class,
      responseType = ds.stockManager.RemoveStockMessage.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<ds.stockManager.StockMessage,
      ds.stockManager.RemoveStockMessage> getRemoveStockMethod() {
    io.grpc.MethodDescriptor<ds.stockManager.StockMessage, ds.stockManager.RemoveStockMessage> getRemoveStockMethod;
    if ((getRemoveStockMethod = stockManagerGrpc.getRemoveStockMethod) == null) {
      synchronized (stockManagerGrpc.class) {
        if ((getRemoveStockMethod = stockManagerGrpc.getRemoveStockMethod) == null) {
          stockManagerGrpc.getRemoveStockMethod = getRemoveStockMethod = 
              io.grpc.MethodDescriptor.<ds.stockManager.StockMessage, ds.stockManager.RemoveStockMessage>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "stockmanager.stockManager", "RemoveStock"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.stockManager.StockMessage.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.stockManager.RemoveStockMessage.getDefaultInstance()))
                  .setSchemaDescriptor(new stockManagerMethodDescriptorSupplier("RemoveStock"))
                  .build();
          }
        }
     }
     return getRemoveStockMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ds.stockManager.EmptyStockMessage,
      ds.stockManager.StockMessage> getStockSummaryMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "StockSummary",
      requestType = ds.stockManager.EmptyStockMessage.class,
      responseType = ds.stockManager.StockMessage.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<ds.stockManager.EmptyStockMessage,
      ds.stockManager.StockMessage> getStockSummaryMethod() {
    io.grpc.MethodDescriptor<ds.stockManager.EmptyStockMessage, ds.stockManager.StockMessage> getStockSummaryMethod;
    if ((getStockSummaryMethod = stockManagerGrpc.getStockSummaryMethod) == null) {
      synchronized (stockManagerGrpc.class) {
        if ((getStockSummaryMethod = stockManagerGrpc.getStockSummaryMethod) == null) {
          stockManagerGrpc.getStockSummaryMethod = getStockSummaryMethod = 
              io.grpc.MethodDescriptor.<ds.stockManager.EmptyStockMessage, ds.stockManager.StockMessage>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "stockmanager.stockManager", "StockSummary"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.stockManager.EmptyStockMessage.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.stockManager.StockMessage.getDefaultInstance()))
                  .setSchemaDescriptor(new stockManagerMethodDescriptorSupplier("StockSummary"))
                  .build();
          }
        }
     }
     return getStockSummaryMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static stockManagerStub newStub(io.grpc.Channel channel) {
    return new stockManagerStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static stockManagerBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new stockManagerBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static stockManagerFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new stockManagerFutureStub(channel);
  }

  /**
   */
  public static abstract class stockManagerImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     *Stream of stock to be added each call returns the current levels of that paticular stock
     * </pre>
     */
    public io.grpc.stub.StreamObserver<ds.stockManager.StockMessage> addStock(
        io.grpc.stub.StreamObserver<ds.stockManager.StockMessage> responseObserver) {
      return asyncUnimplementedStreamingCall(getAddStockMethod(), responseObserver);
    }

    /**
     * <pre>
     *Remove stock, retunr message is current level of that stock
     * </pre>
     */
    public void removeStock(ds.stockManager.StockMessage request,
        io.grpc.stub.StreamObserver<ds.stockManager.RemoveStockMessage> responseObserver) {
      asyncUnimplementedUnaryCall(getRemoveStockMethod(), responseObserver);
    }

    /**
     */
    public void stockSummary(ds.stockManager.EmptyStockMessage request,
        io.grpc.stub.StreamObserver<ds.stockManager.StockMessage> responseObserver) {
      asyncUnimplementedUnaryCall(getStockSummaryMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getAddStockMethod(),
            asyncBidiStreamingCall(
              new MethodHandlers<
                ds.stockManager.StockMessage,
                ds.stockManager.StockMessage>(
                  this, METHODID_ADD_STOCK)))
          .addMethod(
            getRemoveStockMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                ds.stockManager.StockMessage,
                ds.stockManager.RemoveStockMessage>(
                  this, METHODID_REMOVE_STOCK)))
          .addMethod(
            getStockSummaryMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                ds.stockManager.EmptyStockMessage,
                ds.stockManager.StockMessage>(
                  this, METHODID_STOCK_SUMMARY)))
          .build();
    }
  }

  /**
   */
  public static final class stockManagerStub extends io.grpc.stub.AbstractStub<stockManagerStub> {
    private stockManagerStub(io.grpc.Channel channel) {
      super(channel);
    }

    private stockManagerStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected stockManagerStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new stockManagerStub(channel, callOptions);
    }

    /**
     * <pre>
     *Stream of stock to be added each call returns the current levels of that paticular stock
     * </pre>
     */
    public io.grpc.stub.StreamObserver<ds.stockManager.StockMessage> addStock(
        io.grpc.stub.StreamObserver<ds.stockManager.StockMessage> responseObserver) {
      return asyncBidiStreamingCall(
          getChannel().newCall(getAddStockMethod(), getCallOptions()), responseObserver);
    }

    /**
     * <pre>
     *Remove stock, retunr message is current level of that stock
     * </pre>
     */
    public void removeStock(ds.stockManager.StockMessage request,
        io.grpc.stub.StreamObserver<ds.stockManager.RemoveStockMessage> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getRemoveStockMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void stockSummary(ds.stockManager.EmptyStockMessage request,
        io.grpc.stub.StreamObserver<ds.stockManager.StockMessage> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getStockSummaryMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class stockManagerBlockingStub extends io.grpc.stub.AbstractStub<stockManagerBlockingStub> {
    private stockManagerBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private stockManagerBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected stockManagerBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new stockManagerBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     *Remove stock, retunr message is current level of that stock
     * </pre>
     */
    public ds.stockManager.RemoveStockMessage removeStock(ds.stockManager.StockMessage request) {
      return blockingUnaryCall(
          getChannel(), getRemoveStockMethod(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<ds.stockManager.StockMessage> stockSummary(
        ds.stockManager.EmptyStockMessage request) {
      return blockingServerStreamingCall(
          getChannel(), getStockSummaryMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class stockManagerFutureStub extends io.grpc.stub.AbstractStub<stockManagerFutureStub> {
    private stockManagerFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private stockManagerFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected stockManagerFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new stockManagerFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     *Remove stock, retunr message is current level of that stock
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<ds.stockManager.RemoveStockMessage> removeStock(
        ds.stockManager.StockMessage request) {
      return futureUnaryCall(
          getChannel().newCall(getRemoveStockMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_REMOVE_STOCK = 0;
  private static final int METHODID_STOCK_SUMMARY = 1;
  private static final int METHODID_ADD_STOCK = 2;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final stockManagerImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(stockManagerImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_REMOVE_STOCK:
          serviceImpl.removeStock((ds.stockManager.StockMessage) request,
              (io.grpc.stub.StreamObserver<ds.stockManager.RemoveStockMessage>) responseObserver);
          break;
        case METHODID_STOCK_SUMMARY:
          serviceImpl.stockSummary((ds.stockManager.EmptyStockMessage) request,
              (io.grpc.stub.StreamObserver<ds.stockManager.StockMessage>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_ADD_STOCK:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.addStock(
              (io.grpc.stub.StreamObserver<ds.stockManager.StockMessage>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class stockManagerBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    stockManagerBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return ds.stockManager.StockManagerImpl.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("stockManager");
    }
  }

  private static final class stockManagerFileDescriptorSupplier
      extends stockManagerBaseDescriptorSupplier {
    stockManagerFileDescriptorSupplier() {}
  }

  private static final class stockManagerMethodDescriptorSupplier
      extends stockManagerBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    stockManagerMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (stockManagerGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new stockManagerFileDescriptorSupplier())
              .addMethod(getAddStockMethod())
              .addMethod(getRemoveStockMethod())
              .addMethod(getStockSummaryMethod())
              .build();
        }
      }
    }
    return result;
  }
}
