package cn.ac.iie.grpc;

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
    value = "by gRPC proto compiler (version 1.22.1)",
    comments = "Source: vector.proto")
public final class VectorGrpc {

  private VectorGrpc() {}

  public static final String SERVICE_NAME = "Vector";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<cn.ac.iie.grpc.VectorRequest,
      cn.ac.iie.grpc.VectorResponse> getSearchMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "search",
      requestType = cn.ac.iie.grpc.VectorRequest.class,
      responseType = cn.ac.iie.grpc.VectorResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<cn.ac.iie.grpc.VectorRequest,
      cn.ac.iie.grpc.VectorResponse> getSearchMethod() {
    io.grpc.MethodDescriptor<cn.ac.iie.grpc.VectorRequest, cn.ac.iie.grpc.VectorResponse> getSearchMethod;
    if ((getSearchMethod = VectorGrpc.getSearchMethod) == null) {
      synchronized (VectorGrpc.class) {
        if ((getSearchMethod = VectorGrpc.getSearchMethod) == null) {
          VectorGrpc.getSearchMethod = getSearchMethod = 
              io.grpc.MethodDescriptor.<cn.ac.iie.grpc.VectorRequest, cn.ac.iie.grpc.VectorResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "Vector", "search"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  cn.ac.iie.grpc.VectorRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  cn.ac.iie.grpc.VectorResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new VectorMethodDescriptorSupplier("search"))
                  .build();
          }
        }
     }
     return getSearchMethod;
  }

  private static volatile io.grpc.MethodDescriptor<cn.ac.iie.grpc.BytesRequest,
      cn.ac.iie.grpc.BytesResponse> getSearchByBytesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "searchByBytes",
      requestType = cn.ac.iie.grpc.BytesRequest.class,
      responseType = cn.ac.iie.grpc.BytesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<cn.ac.iie.grpc.BytesRequest,
      cn.ac.iie.grpc.BytesResponse> getSearchByBytesMethod() {
    io.grpc.MethodDescriptor<cn.ac.iie.grpc.BytesRequest, cn.ac.iie.grpc.BytesResponse> getSearchByBytesMethod;
    if ((getSearchByBytesMethod = VectorGrpc.getSearchByBytesMethod) == null) {
      synchronized (VectorGrpc.class) {
        if ((getSearchByBytesMethod = VectorGrpc.getSearchByBytesMethod) == null) {
          VectorGrpc.getSearchByBytesMethod = getSearchByBytesMethod = 
              io.grpc.MethodDescriptor.<cn.ac.iie.grpc.BytesRequest, cn.ac.iie.grpc.BytesResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "Vector", "searchByBytes"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  cn.ac.iie.grpc.BytesRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  cn.ac.iie.grpc.BytesResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new VectorMethodDescriptorSupplier("searchByBytes"))
                  .build();
          }
        }
     }
     return getSearchByBytesMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static VectorStub newStub(io.grpc.Channel channel) {
    return new VectorStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static VectorBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new VectorBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static VectorFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new VectorFutureStub(channel);
  }

  /**
   */
  public static abstract class VectorImplBase implements io.grpc.BindableService {

    /**
     */
    public void search(cn.ac.iie.grpc.VectorRequest request,
        io.grpc.stub.StreamObserver<cn.ac.iie.grpc.VectorResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getSearchMethod(), responseObserver);
    }

    /**
     */
    public void searchByBytes(cn.ac.iie.grpc.BytesRequest request,
        io.grpc.stub.StreamObserver<cn.ac.iie.grpc.BytesResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getSearchByBytesMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getSearchMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                cn.ac.iie.grpc.VectorRequest,
                cn.ac.iie.grpc.VectorResponse>(
                  this, METHODID_SEARCH)))
          .addMethod(
            getSearchByBytesMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                cn.ac.iie.grpc.BytesRequest,
                cn.ac.iie.grpc.BytesResponse>(
                  this, METHODID_SEARCH_BY_BYTES)))
          .build();
    }
  }

  /**
   */
  public static final class VectorStub extends io.grpc.stub.AbstractStub<VectorStub> {
    private VectorStub(io.grpc.Channel channel) {
      super(channel);
    }

    private VectorStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected VectorStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new VectorStub(channel, callOptions);
    }

    /**
     */
    public void search(cn.ac.iie.grpc.VectorRequest request,
        io.grpc.stub.StreamObserver<cn.ac.iie.grpc.VectorResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSearchMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void searchByBytes(cn.ac.iie.grpc.BytesRequest request,
        io.grpc.stub.StreamObserver<cn.ac.iie.grpc.BytesResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSearchByBytesMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class VectorBlockingStub extends io.grpc.stub.AbstractStub<VectorBlockingStub> {
    private VectorBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private VectorBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected VectorBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new VectorBlockingStub(channel, callOptions);
    }

    /**
     */
    public cn.ac.iie.grpc.VectorResponse search(cn.ac.iie.grpc.VectorRequest request) {
      return blockingUnaryCall(
          getChannel(), getSearchMethod(), getCallOptions(), request);
    }

    /**
     */
    public cn.ac.iie.grpc.BytesResponse searchByBytes(cn.ac.iie.grpc.BytesRequest request) {
      return blockingUnaryCall(
          getChannel(), getSearchByBytesMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class VectorFutureStub extends io.grpc.stub.AbstractStub<VectorFutureStub> {
    private VectorFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private VectorFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected VectorFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new VectorFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<cn.ac.iie.grpc.VectorResponse> search(
        cn.ac.iie.grpc.VectorRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getSearchMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<cn.ac.iie.grpc.BytesResponse> searchByBytes(
        cn.ac.iie.grpc.BytesRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getSearchByBytesMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_SEARCH = 0;
  private static final int METHODID_SEARCH_BY_BYTES = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final VectorImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(VectorImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_SEARCH:
          serviceImpl.search((cn.ac.iie.grpc.VectorRequest) request,
              (io.grpc.stub.StreamObserver<cn.ac.iie.grpc.VectorResponse>) responseObserver);
          break;
        case METHODID_SEARCH_BY_BYTES:
          serviceImpl.searchByBytes((cn.ac.iie.grpc.BytesRequest) request,
              (io.grpc.stub.StreamObserver<cn.ac.iie.grpc.BytesResponse>) responseObserver);
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
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class VectorBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    VectorBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return cn.ac.iie.grpc.VectorServer.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Vector");
    }
  }

  private static final class VectorFileDescriptorSupplier
      extends VectorBaseDescriptorSupplier {
    VectorFileDescriptorSupplier() {}
  }

  private static final class VectorMethodDescriptorSupplier
      extends VectorBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    VectorMethodDescriptorSupplier(String methodName) {
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
      synchronized (VectorGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new VectorFileDescriptorSupplier())
              .addMethod(getSearchMethod())
              .addMethod(getSearchByBytesMethod())
              .build();
        }
      }
    }
    return result;
  }
}
