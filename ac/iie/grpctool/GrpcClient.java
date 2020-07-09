package cn.ac.iie.grpctool;

import cn.ac.iie.grpc.*;
import com.google.protobuf.ByteString;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import java.util.*;
import java.util.concurrent.TimeUnit;

public class GrpcClient {
    private String engineName;
    private String engineVersion;
    private int port;
    private String host;
    private String addr;
    private final VectorGrpc.VectorBlockingStub blockingStub;
    private final ManagedChannel channel;

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }
    public String getEngineName() {
        return engineName;
    }

    public void setEngineName(String engineName) {
        this.engineName = engineName;
    }

    public String getEngineVersion() {
        return engineVersion;
    }

    public void setEngineVersion(String engineVersion) {
        this.engineVersion = engineVersion;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public GrpcClient(String host, int port, String name, String version) {
        this.engineName = name;
        this.engineVersion = version;
        this.addr= host + ":" + port;
        this.port = port;
        this.host = host;
        channel = ManagedChannelBuilder.forAddress(host, port).usePlaintext().build();
        blockingStub = VectorGrpc.newBlockingStub(channel);
    }
    public GrpcClient(String address, String name, String version) {
        this.addr = address;
        this.engineName = name;
        this.engineVersion = version;
        this.port = Integer.parseInt(address.split(":")[1]);
        this.host = address.split(":")[0];
        channel = ManagedChannelBuilder.forAddress(host, port).usePlaintext().build();
        blockingStub = VectorGrpc.newBlockingStub(channel);
    }
    public void shutdown() throws InterruptedException {
        System.out.println("shut down " );
        new Exception("shut down").printStackTrace();
        channel.shutdown().awaitTermination(10, TimeUnit.SECONDS);
    }

    //    public VectorResponse search(Map<String, String> map) {
//        VectorRequest vectorRequest = VectorRequest.newBuilder().putAllBatchQuery(map).build();
//        return blockingStub.search(vectorRequest);
//    }
    public Map<String, List<ByteString>> search(Map<String, String> map) {
        Map<String, List<ByteString>> result = new HashMap<>();
        VectorRequest vectorRequest = VectorRequest.newBuilder().putAllBatchQuery(map).build();
        VectorResponse tasks = blockingStub.search(vectorRequest);
        tasks.getBatchVectorMap().forEach((k, v) -> {
            if (!v.getCode().equals("-1")){
                List<ByteString> list = new ArrayList<>();
                list.addAll(v.getImageVectorsMap().values());
                result.put(k, list);
            }else {
                System.out.println("taks '" + k + "' url '" + v + "', request failed with code :" + v.getCode() + ", info : " + v.getFailed() + ", " +
                        "engienName: " + engineName);
            }
        });
        return result;
    }
    public VectorResponse search(VectorRequest vectorRequest) {
        return blockingStub.search(vectorRequest);
    }

    public BytesResponse searchByBytes(BytesRequest bytesRequest) {
        return blockingStub.searchByBytes(bytesRequest);
    }

}