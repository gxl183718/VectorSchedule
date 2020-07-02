package cn.ac.iie.server;

import com.google.protobuf.ByteString;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.pulsar.client.api.*;
import org.jetbrains.annotations.TestOnly;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class TestPu {


    static class CData{
        private String name;
        private int age;

        public CData() {
            super();
        }

        public CData(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }
    public static void main(String[] args) throws Exception {
        doJson();
//        doString();

    }
    public static void doJson() throws PulsarClientException {
        PulsarClient pulsarClient1 = PulsarClient.builder().serviceUrl("pulsar://192.168.99.100:6650").build();
//        Producer<CData> producer1 = pulsarClient1.newProducer(Schema.JSON(CData.class)).
//                topic("persistent://public/default/gg6").create();
//        long t1 = System.currentTimeMillis();
////        int i = 1000;
////        while(i -- > 0){
//        producer1.send(new CData("gg", 1));
//        producer1.send(new CData("gg", 2));
//        producer1.send(new CData("gg", 3));
//        }
        long t2 = System.currentTimeMillis();
        Consumer<CData> consumer1 = pulsarClient1.newConsumer(Schema.JSON(CData.class))
                .topic("persistent://public/default/gg6")
                .subscriptionName("sub1")
                .subscriptionInitialPosition(SubscriptionInitialPosition.Earliest)
                .subscriptionType(SubscriptionType.Shared)
                .subscribe();
        MessageId messageId = consumer1.getLastMessageId();
        consumer1.seek(messageId);
        Message<CData> message = consumer1.receive();
        System.out.println("......." + message.getPublishTime());
        consumer1.close();
//        producer1.close();
        pulsarClient1.close();
    }
    public static void doString() throws PulsarClientException {
        PulsarClient pulsarClient1 = PulsarClient.builder().serviceUrl("pulsar://192.168.99.100:6650").build();
        Producer<String> producer1 = pulsarClient1.newProducer(Schema.STRING).
                topic("persistent://public/default/gg5").create();
        long t1 = System.currentTimeMillis();
        int i = 1000;
        while(i -- > 0){
            producer1.send("gg 3");
        }
        long t2 = System.currentTimeMillis();
        Consumer<String> consumer1 = pulsarClient1.newConsumer(Schema.STRING)
                .topic("persistent://public/default/gg5")
                .subscriptionName("sub1")
                .subscriptionInitialPosition(SubscriptionInitialPosition.Earliest)
//                .subscriptionInitialPosition(SubscriptionInitialPosition.valueOf())
                .subscriptionType(SubscriptionType.Shared)
                .subscribe();
        System.out.println("start : " + (t2-t1));
        while(true){
            Messages<String> message = consumer1.batchReceive();
            if (message.size() == 0){
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("batch r size :" + message.size());
        }
//        System.out.println("end");
//        consumer1.close();
//        producer1.close();
//        pulsarClient1.close();
    }
}
