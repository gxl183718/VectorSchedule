package cn.ac.iie.server;

import cn.ac.iie.conf.Conf;
import cn.ac.iie.grpctool.GrpcClient;
import cn.ac.iie.pulsarTools.PulsarConsumer;
import cn.ac.iie.pulsarTools.PulsarProducer;
import com.google.protobuf.ByteString;
import org.apache.pulsar.client.api.Message;
import org.apache.pulsar.client.api.Messages;
import org.apache.pulsar.client.api.PulsarClientException;

import java.nio.ByteBuffer;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class EngineThreadHash {
    private static Map<String, EngineThread> map = new ConcurrentHashMap<>();

    public static Map<String, EngineThread> getMap() {
        return map;
    }

    public static void setMap(Map<String, EngineThread> map) {
        EngineThreadHash.map = map;
    }

    public static void addToThreadHash(EngineThread engineThread){
        if (!engineThread.getState().equals("RUNNABLE")){
            engineThread.setName(engineThread.getName() + "--father");
            engineThread.setDaemon(true);
            engineThread.start();
            System.out.println("add new engine " + engineThread.getName());
        }
        map.put(engineThread.engineName + ":" + engineThread.engineVersion, engineThread);
    }
    public static void delThreadFromHash(String engine){
        try {
            if(map.get(engine) != null){
                map.get(engine).interrupt();
                map.get(engine).pulsarConsumer.close();
                map.get(engine).pulsarProducer.close();
                map.get(engine).grpcClient.shutdown();
                RefreshEnginesThread.getEngineAddrHash().remove(engine);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public static class EngineThread extends Thread{
        String engineName;
        String engineVersion;
        PulsarConsumer pulsarConsumer;
        PulsarProducer pulsarProducer;
        GrpcClient grpcClient;

        EngineThread(String engineName, String engineVersion){
            this.engineName = engineName;
            this.engineVersion = engineVersion;
        }

        @Override
        public void run() {
            super.run();
                pulsarConsumer = new PulsarConsumer(engineName, engineVersion);
                pulsarProducer = new PulsarProducer(engineName, engineVersion);
                grpcClient = RefreshEnginesThread.getEngineAddrHash().get(engineName + ":" + engineVersion);
                if (grpcClient != null){
                    try {
                        long num = 0l;
//                        while(true){
//                            System.out.println("receive message start true.");
//                            if (Thread.currentThread().isInterrupted()){
//                                break;
//                            }
//                            Messages<CData> messages = pulsarConsumer.getConsumer().batchReceive();
//                            if (messages.size() == 0) {
//                                System.out.println(engineName + ":.............2" + pulsarConsumer.getConsumer().getTopic());
//                                Thread.sleep(5000);
//                            }else {
//                                num ++;
//                                Map<String, String> mapResponse = new HashMap<>();
//                                Map<String, CData> mapCData = new HashMap<>();
//                                for (Message<CData> message : messages) {
//                                    if (message.getValue().getM_mm_url() == null ||
//                                            message.getValue().getM_type() == 1){
//                                        pulsarConsumer.getConsumer().acknowledge(message);
//                                        continue;
//                                    }
//                                    mapResponse.put(message.getValue().getM_id(), Conf.mamPre + message.getValue().getM_mm_url());
//                                    mapCData.put(message.getValue().getM_id(), message.getValue());
//                                    pulsarConsumer.getConsumer().acknowledge(message);
//                                }
//                                System.out.println(engineName + "start-searc.");
//                                long s = System.currentTimeMillis();
//                                Map<String, List<ByteString>> results = grpcClient.search(mapResponse);
//                                System.out.println(engineName +"end-search--time " + (System.currentTimeMillis() - s) + "ms.");
//                                results.forEach((k,v) ->{
//                                    if (v.size() != 0){
//                                        VectorData vData = new VectorData();
//                                        vData.setSpace(engineName);
//                                        vData.setVersion(engineVersion);
//                                        vData.setGId(mapCData.get(k).getM_id());
//                                        vData.setPublishTime(mapCData.get(k).getM_publish_time());
//                                        for (ByteString bytes : v) {
//                                            vData.setVector(ByteBuffer.wrap(bytes.toByteArray()));
//                                            System.out.println("2.....vectors : " + vData.getSpace()
//                                                    + ":" + vData.getVersion() + ",gid=" + vData.getGId()
//                                                    + ",vector size = " + bytes.size() + ", pubTime=" + vData.getPublishTime());
//                                                pulsarProducer.getProducer().sendAsync(vData).thenAccept(msg -> {
//                                                    System.out.println("ok send " + msg);
//                                                });
//                                            System.out.println("2.....end");
//                                        }
//                                    } else if (v.size() == 0){
//                                        System.out.println(k + ": no vector!");
//                                    }
////                                    else {
////                                        VectorData vData = new VectorData();
////                                        vData.setSpace(engineName);
////                                        vData.setVersion(engineVersion);
////                                        vData.setGId(mapCData.get(k).getM_id());
////                                        vData.setPublishTime(mapCData.get(k).getM_publish_time());
////                                        vData.setVector(ByteBuffer.wrap(v.get(0).toByteArray()));
////                                        System.out.println("1.....vectors : " + vData.getSpace()
////                                                + ":" + vData.getVersion() + ",gid=" + vData.getGId()
////                                                + ",vector size=" + v.get(0).size() + ", pubTime=" + vData.getPublishTime());
//////                                        try {
////                                            pulsarProducer.getProducer().sendAsync(vData).thenAccept(msgid->{
////                                                System.out.println("ok send : " + msgid);
////                                            });
//////                                        } catch (PulsarClientException e) {
//////                                            e.printStackTrace();
//////                                        }
////                                        System.out.println("1.....end");
////                                    }
//                                });
//                            }
//                        }
                        for (int i = 0; i < Conf.engineThreadNum; i++) {
                            ChildEngineThread childEngineThread = new ChildEngineThread(engineName, engineVersion, pulsarConsumer, pulsarProducer, grpcClient);
                            childEngineThread.setName(engineName + ":" + engineVersion + "--" + i);
                            childEngineThread.setDaemon(true);
                            childEngineThread.start();
                        }
                        while(true){
                            if (Thread.currentThread().isInterrupted())
                                break;
                            Thread.sleep(10*1000);
                        }
//                    } catch (PulsarClientException ex) {
//                        ex.printStackTrace();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        try {
                            map.get(engineName + ":" + engineVersion).pulsarConsumer.close();
                            map.get(engineName + ":" + engineVersion).pulsarProducer.close();
                            map.get(engineName + ":" + engineVersion).grpcClient.shutdown();
                            RefreshEnginesThread.getEngineAddrHash().remove(engineName + ":" + engineVersion);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
        }

    }
    static class ChildEngineThread extends Thread{
        String engineName;
        String engineVersion;
        PulsarConsumer pulsarConsumer;
        PulsarProducer pulsarProducer;
        GrpcClient grpcClient;

        public ChildEngineThread(String engineName, String engineVersion, PulsarConsumer pulsarConsumer, PulsarProducer pulsarProducer, GrpcClient grpcClient) {
            this.engineName = engineName;
            this.engineVersion = engineVersion;
            this.pulsarConsumer = pulsarConsumer;
            this.pulsarProducer = pulsarProducer;
            this.grpcClient = grpcClient;
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

        public PulsarConsumer getPulsarConsumer() {
            return pulsarConsumer;
        }

        public void setPulsarConsumer(PulsarConsumer pulsarConsumer) {
            this.pulsarConsumer = pulsarConsumer;
        }

        public PulsarProducer getPulsarProducer() {
            return pulsarProducer;
        }

        public void setPulsarProducer(PulsarProducer pulsarProducer) {
            this.pulsarProducer = pulsarProducer;
        }

        public GrpcClient getGrpcClient() {
            return grpcClient;
        }

        public void setGrpcClient(GrpcClient grpcClient) {
            this.grpcClient = grpcClient;
        }

        @Override
        public void run() {
            super.run();
            while(true){
                try {
                    if (Thread.currentThread().isInterrupted()){
                        break;
                    }
                    int batchNum = 0;
                    Messages<CData> messages = pulsarConsumer.getConsumer().batchReceive();
                    if (messages.size() == 0) {
                        System.out.println(Thread.currentThread().getName() + ":" + engineName + ":" + pulsarConsumer.getConsumer().getTopic() + " has no data wait 5 minutes.");
                        Thread.sleep(5000);
                    }else {
                        Map<String, String> mapResponse = new HashMap<>();
                        Map<String, CData> mapCData = new HashMap<>();
                        for (Message<CData> message : messages) {
                            if (message.getValue().getM_mm_url() == null ||
                                    message.getValue().getM_type() == 1){
                                pulsarConsumer.getConsumer().acknowledge(message);
                                continue;
                            }
                            batchNum ++;
                            mapResponse.put(message.getValue().getM_id(), Conf.mamPre + message.getValue().getM_mm_url());
                            mapCData.put(message.getValue().getM_id(), message.getValue());
                            pulsarConsumer.getConsumer().acknowledge(message);
                        }
                        if (batchNum == 0)
                            continue;
                        System.out.println(getTime() + Thread.currentThread().getName() + ":" + engineName + "start-searc , with batchNum=" + batchNum);
                        long s = System.currentTimeMillis();
                        Map<String, List<ByteString>> results = grpcClient.search(mapResponse);
                        System.out.println(getTime() + Thread.currentThread().getName() + ":" + engineName +"end-search--time " + (System.currentTimeMillis() - s) + "ms.");
                        results.forEach((k,v) ->{
                            if (v.size() != 0){
                                VectorData vData = new VectorData();
                                vData.setSpace(engineName);
                                vData.setVersion(engineVersion);
                                vData.setGId(mapCData.get(k).getM_id());
                                vData.setPublishTime(mapCData.get(k).getM_publish_time());
                                for (ByteString bytes : v) {
                                    vData.setVector(ByteBuffer.wrap(bytes.toByteArray()));
                                    System.out.println("vectors : " + vData.getSpace()
                                            + ":" + vData.getVersion() + ",gid=" + vData.getGId()
                                            + ",vector size = " + bytes.size() + ", pubTime=" + vData.getPublishTime()
                                            + ", url = " + mapCData.get(k).getM_mm_url());
                                    pulsarProducer.getProducer().sendAsync(vData).thenAccept(msg -> {
                                        System.out.println("ok send " + msg);
                                    });
                                }
                            } else if (v.size() == 0){
                                System.out.println(k + ": no vector!");
                            }
                        });
                    }
                }catch (InterruptedException e) {
                    e.printStackTrace();
                    System.out.println(getTime() + Thread.currentThread().getName() + ", " + e.getMessage());
                    try {
                        Thread.sleep(10*1000);
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                } catch (PulsarClientException e) {
                    e.printStackTrace();
                    try {
                        Thread.sleep(10*1000);
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                    System.out.println(getTime() + Thread.currentThread().getName() + ", " + e.getMessage());
                }
            }

        }
    }
    private static String getTime(){
        return DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(LocalDateTime.now()) + " ----> ";
    }
}
