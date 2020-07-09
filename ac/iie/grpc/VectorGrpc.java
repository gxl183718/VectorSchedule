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
  private static volatile io.grpc.MethodDescriptor<cn.ac.iie.grpc.Test,
      cn.ac.iie.grpc.Test> getTestMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "test",
      requestType = cn.ac.iie.grpc.Test.class,
      responseType = cn.ac.iie.grpc.Test.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<cn.ac.iie.grpc.Test,
      cn.ac.iie.grpc.Test> getTestMethod() {
    io.grpc.MethodDescriptor<cn.ac.iie.grpc.Test, cn.ac.iie.grpc.Test> getTestMethod;
    if ((getTestMethod = VectorGrpc.getTestMethod) == null) {
      synchronized (VectorGrpc.class) {
        if ((getTestMethod = VectorGrpc.getTestMethod) == null) {
          VectorGrpc.getTestMethod = getTestMethod = 
              io.grpc.MethodDescriptor.<cn.ac.iie.grpc.Test, cn.ac.iie.grpc.Test>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "Vector", "test"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  cn.ac.iie.grpc.Test.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  cn.ac.iie.grpc.Test.getDefaultInstance()))
                  .setSchemaDescriptor(new VectorMethodDescriptorSupplier("test"))
                  .build();
          }
        }
     }
     return getTestMethod;
  }

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

  private static volatile io.grpc.MethodDescriptor<cn.ac.iie.grpc.ImageBytes,
      cn.ac.iie.grpc.LocateEntries> getGetObjectsByBytesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getObjectsByBytes",
      requestType = cn.ac.iie.grpc.ImageBytes.class,
      responseType = cn.ac.iie.grpc.LocateEntries.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<cn.ac.iie.grpc.ImageBytes,
      cn.ac.iie.grpc.LocateEntries> getGetObjectsByBytesMethod() {
    io.grpc.MethodDescriptor<cn.ac.iie.grpc.ImageBytes, cn.ac.iie.grpc.LocateEntries> getGetObjectsByBytesMethod;
    if ((getGetObjectsByBytesMethod = VectorGrpc.getGetObjectsByBytesMethod) == null) {
      synchronized (VectorGrpc.class) {
        if ((getGetObjectsByBytesMethod = VectorGrpc.getGetObjectsByBytesMethod) == null) {
          VectorGrpc.getGetObjectsByBytesMethod = getGetObjectsByBytesMethod = 
              io.grpc.MethodDescriptor.<cn.ac.iie.grpc.ImageBytes, cn.ac.iie.grpc.LocateEntries>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "Vector", "getObjectsByBytes"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  cn.ac.iie.grpc.ImageBytes.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  cn.ac.iie.grpc.LocateEntries.getDefaultInstance()))
                  .setSchemaDescriptor(new VectorMethodDescriptorSupplier("getObjectsByBytes"))
                  .build();
          }
        }
     }
     return getGetObjectsByBytesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<cn.ac.iie.grpc.ImageUrl,
      cn.ac.iie.grpc.LocateEntries> getGetObjectsByUrlMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getObjectsByUrl",
      requestType = cn.ac.iie.grpc.ImageUrl.class,
      responseType = cn.ac.iie.grpc.LocateEntries.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<cn.ac.iie.grpc.ImageUrl,
      cn.ac.iie.grpc.LocateEntries> getGetObjectsByUrlMethod() {
    io.grpc.MethodDescriptor<cn.ac.iie.grpc.ImageUrl, cn.ac.iie.grpc.LocateEntries> getGetObjectsByUrlMethod;
    if ((getGetObjectsByUrlMethod = VectorGrpc.getGetObjectsByUrlMethod) == null) {
      synchronized (VectorGrpc.class) {
        if ((getGetObjectsByUrlMethod = VectorGrpc.getGetObjectsByUrlMethod) == null) {
          VectorGrpc.getGetObjectsByUrlMethod = getGetObjectsByUrlMethod = 
              io.grpc.MethodDescriptor.<cn.ac.iie.grpc.ImageUrl, cn.ac.iie.grpc.LocateEntries>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "Vector", "getObjectsByUrl"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  cn.ac.iie.grpc.ImageUrl.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  cn.ac.iie.grpc.LocateEntries.getDefaultInstance()))
                  .setSchemaDescriptor(new VectorMethodDescriptorSupplier("getObjectsByUrl"))
                  .build();
          }
        }
     }
     return getGetObjectsByUrlMethod;
  }

  private static volatile io.grpc.MethodDescriptor<cn.ac.iie.grpc.MImageUrl,
      cn.ac.iie.grpc.MLocateEntries> getMGetObjectsByUrlMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "mGetObjectsByUrl",
      requestType = cn.ac.iie.grpc.MImageUrl.class,
      responseType = cn.ac.iie.grpc.MLocateEntries.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<cn.ac.iie.grpc.MImageUrl,
      cn.ac.iie.grpc.MLocateEntries> getMGetObjectsByUrlMethod() {
    io.grpc.MethodDescriptor<cn.ac.iie.grpc.MImageUrl, cn.ac.iie.grpc.MLocateEntries> getMGetObjectsByUrlMethod;
    if ((getMGetObjectsByUrlMethod = VectorGrpc.getMGetObjectsByUrlMethod) == null) {
      synchronized (VectorGrpc.class) {
        if ((getMGetObjectsByUrlMethod = VectorGrpc.getMGetObjectsByUrlMethod) == null) {
          VectorGrpc.getMGetObjectsByUrlMethod = getMGetObjectsByUrlMethod = 
              io.grpc.MethodDescriptor.<cn.ac.iie.grpc.MImageUrl, cn.ac.iie.grpc.MLocateEntries>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "Vector", "mGetObjectsByUrl"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  cn.ac.iie.grpc.MImageUrl.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  cn.ac.iie.grpc.MLocateEntries.getDefaultInstance()))
                  .setSchemaDescriptor(new VectorMethodDescriptorSupplier("mGetObjectsByUrl"))
                  .build();
          }
        }
     }
     return getMGetObjectsByUrlMethod;
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

  private static volatile io.grpc.MethodDescriptor<cn.ac.iie.grpc.UrlRequest,
      cn.ac.iie.grpc.BytesResponse> getSearchByUrlMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "searchByUrl",
      requestType = cn.ac.iie.grpc.UrlRequest.class,
      responseType = cn.ac.iie.grpc.BytesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<cn.ac.iie.grpc.UrlRequest,
      cn.ac.iie.grpc.BytesResponse> getSearchByUrlMethod() {
    io.grpc.MethodDescriptor<cn.ac.iie.grpc.UrlRequest, cn.ac.iie.grpc.BytesResponse> getSearchByUrlMethod;
    if ((getSearchByUrlMethod = VectorGrpc.getSearchByUrlMethod) == null) {
      synchronized (VectorGrpc.class) {
        if ((getSearchByUrlMethod = VectorGrpc.getSearchByUrlMethod) == null) {
          VectorGrpc.getSearchByUrlMethod = getSearchByUrlMethod = 
              io.grpc.MethodDescriptor.<cn.ac.iie.grpc.UrlRequest, cn.ac.iie.grpc.BytesResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "Vector", "searchByUrl"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  cn.ac.iie.grpc.UrlRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  cn.ac.iie.grpc.BytesResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new VectorMethodDescriptorSupplier("searchByUrl"))
                  .build();
          }
        }
     }
     return getSearchByUrlMethod;
  }

  private static volatile io.grpc.MethodDescriptor<cn.ac.iie.grpc.MUrlRequest,
      cn.ac.iie.grpc.MBytesResponse> getMSearchByUrlMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "mSearchByUrl",
      requestType = cn.ac.iie.grpc.MUrlRequest.class,
      responseType = cn.ac.iie.grpc.MBytesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<cn.ac.iie.grpc.MUrlRequest,
      cn.ac.iie.grpc.MBytesResponse> getMSearchByUrlMethod() {
    io.grpc.MethodDescriptor<cn.ac.iie.grpc.MUrlRequest, cn.ac.iie.grpc.MBytesResponse> getMSearchByUrlMethod;
    if ((getMSearchByUrlMethod = VectorGrpc.getMSearchByUrlMethod) == null) {
      synchronized (VectorGrpc.class) {
        if ((getMSearchByUrlMethod = VectorGrpc.getMSearchByUrlMethod) == null) {
          VectorGrpc.getMSearchByUrlMethod = getMSearchByUrlMethod = 
              io.grpc.MethodDescriptor.<cn.ac.iie.grpc.MUrlRequest, cn.ac.iie.grpc.MBytesResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "Vector", "mSearchByUrl"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  cn.ac.iie.grpc.MUrlRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  cn.ac.iie.grpc.MBytesResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new VectorMethodDescriptorSupplier("mSearchByUrl"))
                  .build();
          }
        }
     }
     return getMSearchByUrlMethod;
  }

  private static volatile io.grpc.MethodDescriptor<cn.ac.iie.grpc.QueryByBytesEntry,
      cn.ac.iie.grpc.ResultEntryHash> getGetVectorByBytesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getVectorByBytes",
      requestType = cn.ac.iie.grpc.QueryByBytesEntry.class,
      responseType = cn.ac.iie.grpc.ResultEntryHash.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<cn.ac.iie.grpc.QueryByBytesEntry,
      cn.ac.iie.grpc.ResultEntryHash> getGetVectorByBytesMethod() {
    io.grpc.MethodDescriptor<cn.ac.iie.grpc.QueryByBytesEntry, cn.ac.iie.grpc.ResultEntryHash> getGetVectorByBytesMethod;
    if ((getGetVectorByBytesMethod = VectorGrpc.getGetVectorByBytesMethod) == null) {
      synchronized (VectorGrpc.class) {
        if ((getGetVectorByBytesMethod = VectorGrpc.getGetVectorByBytesMethod) == null) {
          VectorGrpc.getGetVectorByBytesMethod = getGetVectorByBytesMethod = 
              io.grpc.MethodDescriptor.<cn.ac.iie.grpc.QueryByBytesEntry, cn.ac.iie.grpc.ResultEntryHash>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "Vector", "getVectorByBytes"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  cn.ac.iie.grpc.QueryByBytesEntry.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  cn.ac.iie.grpc.ResultEntryHash.getDefaultInstance()))
                  .setSchemaDescriptor(new VectorMethodDescriptorSupplier("getVectorByBytes"))
                  .build();
          }
        }
     }
     return getGetVectorByBytesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<cn.ac.iie.grpc.QueryByUrlEntry,
      cn.ac.iie.grpc.ResultEntryHash> getGetVectorByUrlMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getVectorByUrl",
      requestType = cn.ac.iie.grpc.QueryByUrlEntry.class,
      responseType = cn.ac.iie.grpc.ResultEntryHash.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<cn.ac.iie.grpc.QueryByUrlEntry,
      cn.ac.iie.grpc.ResultEntryHash> getGetVectorByUrlMethod() {
    io.grpc.MethodDescriptor<cn.ac.iie.grpc.QueryByUrlEntry, cn.ac.iie.grpc.ResultEntryHash> getGetVectorByUrlMethod;
    if ((getGetVectorByUrlMethod = VectorGrpc.getGetVectorByUrlMethod) == null) {
      synchronized (VectorGrpc.class) {
        if ((getGetVectorByUrlMethod = VectorGrpc.getGetVectorByUrlMethod) == null) {
          VectorGrpc.getGetVectorByUrlMethod = getGetVectorByUrlMethod = 
              io.grpc.MethodDescriptor.<cn.ac.iie.grpc.QueryByUrlEntry, cn.ac.iie.grpc.ResultEntryHash>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "Vector", "getVectorByUrl"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  cn.ac.iie.grpc.QueryByUrlEntry.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  cn.ac.iie.grpc.ResultEntryHash.getDefaultInstance()))
                  .setSchemaDescriptor(new VectorMethodDescriptorSupplier("getVectorByUrl"))
                  .build();
          }
        }
     }
     return getGetVectorByUrlMethod;
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
    public void test(cn.ac.iie.grpc.Test request,
        io.grpc.stub.StreamObserver<cn.ac.iie.grpc.Test> responseObserver) {
      asyncUnimplementedUnaryCall(getTestMethod(), responseObserver);
    }

    /**
     * <pre>
     *1.通过url批量获取vector
     * </pre>
     */
    public void search(cn.ac.iie.grpc.VectorRequest request,
        io.grpc.stub.StreamObserver<cn.ac.iie.grpc.VectorResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getSearchMethod(), responseObserver);
    }

    /**
     * <pre>
     *2.yolo v3实体识别接口
     * </pre>
     */
    public void getObjectsByBytes(cn.ac.iie.grpc.ImageBytes request,
        io.grpc.stub.StreamObserver<cn.ac.iie.grpc.LocateEntries> responseObserver) {
      asyncUnimplementedUnaryCall(getGetObjectsByBytesMethod(), responseObserver);
    }

    /**
     */
    public void getObjectsByUrl(cn.ac.iie.grpc.ImageUrl request,
        io.grpc.stub.StreamObserver<cn.ac.iie.grpc.LocateEntries> responseObserver) {
      asyncUnimplementedUnaryCall(getGetObjectsByUrlMethod(), responseObserver);
    }

    /**
     * <pre>
     *新增批量接口
     * </pre>
     */
    public void mGetObjectsByUrl(cn.ac.iie.grpc.MImageUrl request,
        io.grpc.stub.StreamObserver<cn.ac.iie.grpc.MLocateEntries> responseObserver) {
      asyncUnimplementedUnaryCall(getMGetObjectsByUrlMethod(), responseObserver);
    }

    /**
     * <pre>
     *3.查询向量接口，通过bytes或url
     * </pre>
     */
    public void searchByBytes(cn.ac.iie.grpc.BytesRequest request,
        io.grpc.stub.StreamObserver<cn.ac.iie.grpc.BytesResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getSearchByBytesMethod(), responseObserver);
    }

    /**
     */
    public void searchByUrl(cn.ac.iie.grpc.UrlRequest request,
        io.grpc.stub.StreamObserver<cn.ac.iie.grpc.BytesResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getSearchByUrlMethod(), responseObserver);
    }

    /**
     * <pre>
     *新增批量接口
     * </pre>
     */
    public void mSearchByUrl(cn.ac.iie.grpc.MUrlRequest request,
        io.grpc.stub.StreamObserver<cn.ac.iie.grpc.MBytesResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getMSearchByUrlMethod(), responseObserver);
    }

    /**
     * <pre>
     *4.向量服务提供的对外接口
     * </pre>
     */
    public void getVectorByBytes(cn.ac.iie.grpc.QueryByBytesEntry request,
        io.grpc.stub.StreamObserver<cn.ac.iie.grpc.ResultEntryHash> responseObserver) {
      asyncUnimplementedUnaryCall(getGetVectorByBytesMethod(), responseObserver);
    }

    /**
     */
    public void getVectorByUrl(cn.ac.iie.grpc.QueryByUrlEntry request,
        io.grpc.stub.StreamObserver<cn.ac.iie.grpc.ResultEntryHash> responseObserver) {
      asyncUnimplementedUnaryCall(getGetVectorByUrlMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getTestMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                cn.ac.iie.grpc.Test,
                cn.ac.iie.grpc.Test>(
                  this, METHODID_TEST)))
          .addMethod(
            getSearchMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                cn.ac.iie.grpc.VectorRequest,
                cn.ac.iie.grpc.VectorResponse>(
                  this, METHODID_SEARCH)))
          .addMethod(
            getGetObjectsByBytesMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                cn.ac.iie.grpc.ImageBytes,
                cn.ac.iie.grpc.LocateEntries>(
                  this, METHODID_GET_OBJECTS_BY_BYTES)))
          .addMethod(
            getGetObjectsByUrlMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                cn.ac.iie.grpc.ImageUrl,
                cn.ac.iie.grpc.LocateEntries>(
                  this, METHODID_GET_OBJECTS_BY_URL)))
          .addMethod(
            getMGetObjectsByUrlMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                cn.ac.iie.grpc.MImageUrl,
                cn.ac.iie.grpc.MLocateEntries>(
                  this, METHODID_M_GET_OBJECTS_BY_URL)))
          .addMethod(
            getSearchByBytesMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                cn.ac.iie.grpc.BytesRequest,
                cn.ac.iie.grpc.BytesResponse>(
                  this, METHODID_SEARCH_BY_BYTES)))
          .addMethod(
            getSearchByUrlMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                cn.ac.iie.grpc.UrlRequest,
                cn.ac.iie.grpc.BytesResponse>(
                  this, METHODID_SEARCH_BY_URL)))
          .addMethod(
            getMSearchByUrlMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                cn.ac.iie.grpc.MUrlRequest,
                cn.ac.iie.grpc.MBytesResponse>(
                  this, METHODID_M_SEARCH_BY_URL)))
          .addMethod(
            getGetVectorByBytesMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                cn.ac.iie.grpc.QueryByBytesEntry,
                cn.ac.iie.grpc.ResultEntryHash>(
                  this, METHODID_GET_VECTOR_BY_BYTES)))
          .addMethod(
            getGetVectorByUrlMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                cn.ac.iie.grpc.QueryByUrlEntry,
                cn.ac.iie.grpc.ResultEntryHash>(
                  this, METHODID_GET_VECTOR_BY_URL)))
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
    public void test(cn.ac.iie.grpc.Test request,
        io.grpc.stub.StreamObserver<cn.ac.iie.grpc.Test> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getTestMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     *1.通过url批量获取vector
     * </pre>
     */
    public void search(cn.ac.iie.grpc.VectorRequest request,
        io.grpc.stub.StreamObserver<cn.ac.iie.grpc.VectorResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSearchMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     *2.yolo v3实体识别接口
     * </pre>
     */
    public void getObjectsByBytes(cn.ac.iie.grpc.ImageBytes request,
        io.grpc.stub.StreamObserver<cn.ac.iie.grpc.LocateEntries> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetObjectsByBytesMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getObjectsByUrl(cn.ac.iie.grpc.ImageUrl request,
        io.grpc.stub.StreamObserver<cn.ac.iie.grpc.LocateEntries> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetObjectsByUrlMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     *新增批量接口
     * </pre>
     */
    public void mGetObjectsByUrl(cn.ac.iie.grpc.MImageUrl request,
        io.grpc.stub.StreamObserver<cn.ac.iie.grpc.MLocateEntries> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getMGetObjectsByUrlMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     *3.查询向量接口，通过bytes或url
     * </pre>
     */
    public void searchByBytes(cn.ac.iie.grpc.BytesRequest request,
        io.grpc.stub.StreamObserver<cn.ac.iie.grpc.BytesResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSearchByBytesMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void searchByUrl(cn.ac.iie.grpc.UrlRequest request,
        io.grpc.stub.StreamObserver<cn.ac.iie.grpc.BytesResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSearchByUrlMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     *新增批量接口
     * </pre>
     */
    public void mSearchByUrl(cn.ac.iie.grpc.MUrlRequest request,
        io.grpc.stub.StreamObserver<cn.ac.iie.grpc.MBytesResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getMSearchByUrlMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     *4.向量服务提供的对外接口
     * </pre>
     */
    public void getVectorByBytes(cn.ac.iie.grpc.QueryByBytesEntry request,
        io.grpc.stub.StreamObserver<cn.ac.iie.grpc.ResultEntryHash> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetVectorByBytesMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getVectorByUrl(cn.ac.iie.grpc.QueryByUrlEntry request,
        io.grpc.stub.StreamObserver<cn.ac.iie.grpc.ResultEntryHash> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetVectorByUrlMethod(), getCallOptions()), request, responseObserver);
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
    public cn.ac.iie.grpc.Test test(cn.ac.iie.grpc.Test request) {
      return blockingUnaryCall(
          getChannel(), getTestMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     *1.通过url批量获取vector
     * </pre>
     */
    public cn.ac.iie.grpc.VectorResponse search(cn.ac.iie.grpc.VectorRequest request) {
      return blockingUnaryCall(
          getChannel(), getSearchMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     *2.yolo v3实体识别接口
     * </pre>
     */
    public cn.ac.iie.grpc.LocateEntries getObjectsByBytes(cn.ac.iie.grpc.ImageBytes request) {
      return blockingUnaryCall(
          getChannel(), getGetObjectsByBytesMethod(), getCallOptions(), request);
    }

    /**
     */
    public cn.ac.iie.grpc.LocateEntries getObjectsByUrl(cn.ac.iie.grpc.ImageUrl request) {
      return blockingUnaryCall(
          getChannel(), getGetObjectsByUrlMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     *新增批量接口
     * </pre>
     */
    public cn.ac.iie.grpc.MLocateEntries mGetObjectsByUrl(cn.ac.iie.grpc.MImageUrl request) {
      return blockingUnaryCall(
          getChannel(), getMGetObjectsByUrlMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     *3.查询向量接口，通过bytes或url
     * </pre>
     */
    public cn.ac.iie.grpc.BytesResponse searchByBytes(cn.ac.iie.grpc.BytesRequest request) {
      return blockingUnaryCall(
          getChannel(), getSearchByBytesMethod(), getCallOptions(), request);
    }

    /**
     */
    public cn.ac.iie.grpc.BytesResponse searchByUrl(cn.ac.iie.grpc.UrlRequest request) {
      return blockingUnaryCall(
          getChannel(), getSearchByUrlMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     *新增批量接口
     * </pre>
     */
    public cn.ac.iie.grpc.MBytesResponse mSearchByUrl(cn.ac.iie.grpc.MUrlRequest request) {
      return blockingUnaryCall(
          getChannel(), getMSearchByUrlMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     *4.向量服务提供的对外接口
     * </pre>
     */
    public cn.ac.iie.grpc.ResultEntryHash getVectorByBytes(cn.ac.iie.grpc.QueryByBytesEntry request) {
      return blockingUnaryCall(
          getChannel(), getGetVectorByBytesMethod(), getCallOptions(), request);
    }

    /**
     */
    public cn.ac.iie.grpc.ResultEntryHash getVectorByUrl(cn.ac.iie.grpc.QueryByUrlEntry request) {
      return blockingUnaryCall(
          getChannel(), getGetVectorByUrlMethod(), getCallOptions(), request);
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
    public com.google.common.util.concurrent.ListenableFuture<cn.ac.iie.grpc.Test> test(
        cn.ac.iie.grpc.Test request) {
      return futureUnaryCall(
          getChannel().newCall(getTestMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     *1.通过url批量获取vector
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<cn.ac.iie.grpc.VectorResponse> search(
        cn.ac.iie.grpc.VectorRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getSearchMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     *2.yolo v3实体识别接口
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<cn.ac.iie.grpc.LocateEntries> getObjectsByBytes(
        cn.ac.iie.grpc.ImageBytes request) {
      return futureUnaryCall(
          getChannel().newCall(getGetObjectsByBytesMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<cn.ac.iie.grpc.LocateEntries> getObjectsByUrl(
        cn.ac.iie.grpc.ImageUrl request) {
      return futureUnaryCall(
          getChannel().newCall(getGetObjectsByUrlMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     *新增批量接口
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<cn.ac.iie.grpc.MLocateEntries> mGetObjectsByUrl(
        cn.ac.iie.grpc.MImageUrl request) {
      return futureUnaryCall(
          getChannel().newCall(getMGetObjectsByUrlMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     *3.查询向量接口，通过bytes或url
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<cn.ac.iie.grpc.BytesResponse> searchByBytes(
        cn.ac.iie.grpc.BytesRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getSearchByBytesMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<cn.ac.iie.grpc.BytesResponse> searchByUrl(
        cn.ac.iie.grpc.UrlRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getSearchByUrlMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     *新增批量接口
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<cn.ac.iie.grpc.MBytesResponse> mSearchByUrl(
        cn.ac.iie.grpc.MUrlRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getMSearchByUrlMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     *4.向量服务提供的对外接口
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<cn.ac.iie.grpc.ResultEntryHash> getVectorByBytes(
        cn.ac.iie.grpc.QueryByBytesEntry request) {
      return futureUnaryCall(
          getChannel().newCall(getGetVectorByBytesMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<cn.ac.iie.grpc.ResultEntryHash> getVectorByUrl(
        cn.ac.iie.grpc.QueryByUrlEntry request) {
      return futureUnaryCall(
          getChannel().newCall(getGetVectorByUrlMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_TEST = 0;
  private static final int METHODID_SEARCH = 1;
  private static final int METHODID_GET_OBJECTS_BY_BYTES = 2;
  private static final int METHODID_GET_OBJECTS_BY_URL = 3;
  private static final int METHODID_M_GET_OBJECTS_BY_URL = 4;
  private static final int METHODID_SEARCH_BY_BYTES = 5;
  private static final int METHODID_SEARCH_BY_URL = 6;
  private static final int METHODID_M_SEARCH_BY_URL = 7;
  private static final int METHODID_GET_VECTOR_BY_BYTES = 8;
  private static final int METHODID_GET_VECTOR_BY_URL = 9;

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
        case METHODID_TEST:
          serviceImpl.test((cn.ac.iie.grpc.Test) request,
              (io.grpc.stub.StreamObserver<cn.ac.iie.grpc.Test>) responseObserver);
          break;
        case METHODID_SEARCH:
          serviceImpl.search((cn.ac.iie.grpc.VectorRequest) request,
              (io.grpc.stub.StreamObserver<cn.ac.iie.grpc.VectorResponse>) responseObserver);
          break;
        case METHODID_GET_OBJECTS_BY_BYTES:
          serviceImpl.getObjectsByBytes((cn.ac.iie.grpc.ImageBytes) request,
              (io.grpc.stub.StreamObserver<cn.ac.iie.grpc.LocateEntries>) responseObserver);
          break;
        case METHODID_GET_OBJECTS_BY_URL:
          serviceImpl.getObjectsByUrl((cn.ac.iie.grpc.ImageUrl) request,
              (io.grpc.stub.StreamObserver<cn.ac.iie.grpc.LocateEntries>) responseObserver);
          break;
        case METHODID_M_GET_OBJECTS_BY_URL:
          serviceImpl.mGetObjectsByUrl((cn.ac.iie.grpc.MImageUrl) request,
              (io.grpc.stub.StreamObserver<cn.ac.iie.grpc.MLocateEntries>) responseObserver);
          break;
        case METHODID_SEARCH_BY_BYTES:
          serviceImpl.searchByBytes((cn.ac.iie.grpc.BytesRequest) request,
              (io.grpc.stub.StreamObserver<cn.ac.iie.grpc.BytesResponse>) responseObserver);
          break;
        case METHODID_SEARCH_BY_URL:
          serviceImpl.searchByUrl((cn.ac.iie.grpc.UrlRequest) request,
              (io.grpc.stub.StreamObserver<cn.ac.iie.grpc.BytesResponse>) responseObserver);
          break;
        case METHODID_M_SEARCH_BY_URL:
          serviceImpl.mSearchByUrl((cn.ac.iie.grpc.MUrlRequest) request,
              (io.grpc.stub.StreamObserver<cn.ac.iie.grpc.MBytesResponse>) responseObserver);
          break;
        case METHODID_GET_VECTOR_BY_BYTES:
          serviceImpl.getVectorByBytes((cn.ac.iie.grpc.QueryByBytesEntry) request,
              (io.grpc.stub.StreamObserver<cn.ac.iie.grpc.ResultEntryHash>) responseObserver);
          break;
        case METHODID_GET_VECTOR_BY_URL:
          serviceImpl.getVectorByUrl((cn.ac.iie.grpc.QueryByUrlEntry) request,
              (io.grpc.stub.StreamObserver<cn.ac.iie.grpc.ResultEntryHash>) responseObserver);
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
              .addMethod(getTestMethod())
              .addMethod(getSearchMethod())
              .addMethod(getGetObjectsByBytesMethod())
              .addMethod(getGetObjectsByUrlMethod())
              .addMethod(getMGetObjectsByUrlMethod())
              .addMethod(getSearchByBytesMethod())
              .addMethod(getSearchByUrlMethod())
              .addMethod(getMSearchByUrlMethod())
              .addMethod(getGetVectorByBytesMethod())
              .addMethod(getGetVectorByUrlMethod())
              .build();
        }
      }
    }
    return result;
  }
}
