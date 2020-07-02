package cn.ac.iie.test;

import cn.ac.iie.conf.TestConf;
import cn.ac.iie.di.datadock.rdata.exchange.client.connector.impl.RERmqClientConfigBuilder;
import cn.ac.iie.di.datadock.rdata.exchange.client.connector.impl.RERmqConnector;
import cn.ac.iie.di.datadock.rdata.exchange.client.connector.impl.RERmqReceiver;
import cn.ac.iie.di.datadock.rdata.exchange.client.connector.impl.RERmqReceiverBuilder;
import cn.ac.iie.di.datadock.rdata.exchange.client.data.REArray;
import cn.ac.iie.di.datadock.rdata.exchange.client.data.REBasicValue;
import cn.ac.iie.di.datadock.rdata.exchange.client.data.RERecord;
import cn.ac.iie.di.datadock.rdata.exchange.client.data.REValue;
import cn.ac.iie.di.datadock.rdata.exchange.client.exception.REConnectionException;
import cn.ac.iie.tools.LogTool;
import org.apache.rocketmq.common.consumer.ConsumeFromWhere;
import org.apache.rocketmq.common.protocol.heartbeat.MessageModel;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

/**
 * @author zhangzhanqi
 * @version 1.0
 * @date 2019-7-23 14:45
 */

public class TestConsumer {
    LogTool logTool = new LogTool();
    public static AtomicLong num = new AtomicLong(0);
    public static ConcurrentHashMap<String, AtomicLong> dayNum = new ConcurrentHashMap<>();

    private List<MField> fields;

    private RERmqReceiver receiver;

    public TestConsumer(List<MField> fields) {
        this.fields = fields;
    }

    public void start() throws REConnectionException {
        RERmqReceiverBuilder receiverBuilder = new RERmqConnector().receiverBuilder(TestConf.consumer_urls);
//        AtomicInteger i = new AtomicInteger();
        receiver = receiverBuilder.setGroup(TestConf.consumer_group)
                .setInstanceName("s-zzq-" + System.nanoTime())
                .setConsumeThreadNum(4)
                .setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_TIMESTAMP)
                .setMessageModel(MessageModel.CLUSTERING)
                .setConsumeTimestamp(1592928000000L)
                .setVersion(RERmqClientConfigBuilder.RmqVersion.V3_X_X)
                .registerMessageListener(TestConf.consumer_topic, (msg, pac) -> {
                    List<RERecord> recs = pac.getRecs();
                    for (RERecord rec : recs) {
                        //统计每天数据
//                        long currentTimeSecond = Instant.now().getEpochSecond();
//                        if (dayNum.get(getDay(currentTimeSecond)) != null){
//                            dayNum.get(getDay(currentTimeSecond)).incrementAndGet();
//                        }else{
//                            dayNum.putIfAbsent(getDay(currentTimeSecond), new AtomicLong(1));
//                        }
//                        num.getAndIncrement();

                        Map<String, Object> map = new HashMap<>();
                        for (MField field : fields) {
                            String cName = field.getCName();
                            String cType = field.getCType();
                            //对应字段
                            if (cName != null) {
                                REValue reValue = rec.get(cName);
                                    if (reValue != null) {
                                        if ("string".equals(cType.toLowerCase())) {
                                            String value = ((REBasicValue.REString) reValue).getValue();
                                            map.put(cName, value);
                                        } else if ("int".equals(cType.toLowerCase())) {
                                            int value = ((REBasicValue.REInt) reValue).getValue();
                                            map.put(cName, value);
                                        } else if ("long".equals(cType.toLowerCase())) {
                                            long value = ((REBasicValue.RELong) reValue).getValue();
                                            map.put(cName, value);
                                        } else if ("strings".equals(cType.toLowerCase())) {
                                            List<REBasicValue.REString> value = ((REArray<REBasicValue.REString>) reValue).getValue();
                                            List<String> strings = value.stream().map(REBasicValue.REString::getValue).collect(Collectors.toList());
                                            map.put(cName, strings);
                                        } else if ("longs".equals(cType.toLowerCase())) {
                                            List<REBasicValue.RELong> value = ((REArray<REBasicValue.RELong>) reValue).getValue();
                                            List<Long> longs = value.stream().map(REBasicValue.RELong::getValue).collect(Collectors.toList());
                                            map.put(cName, longs);
                                        } else if ("ints".equals(cType.toLowerCase())) {
                                            List<REBasicValue.REInt> value = ((REArray<REBasicValue.REInt>) reValue).getValue();
                                            List<Integer> ints = value.stream().map(REBasicValue.REInt::getValue).collect(Collectors.toList());
                                            map.put(cName, ints);
                                        }
                                    }
                            }
                        }
                        try {
                            if(map.get("ma_picture_files").toString().length() > 2){
                                AccessMediaData.cacheData.put(map);
                            }else if (map.get("ma_audio_files").toString().length() > 2){
                            }else if (map.get("ma_video_files").toString().length() > 2){
                            }else{
                                AccessTextData.cacheData.put(map);
                            }
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        //TODO:
                    }
//                    if(i.get() > flag)
//                        exit(0);
                }, (msg, ex) -> logTool.warn(ex)).build();

        receiver.start();
        System.out.println("mq consumer start: ");
    }

    public void stop() throws REConnectionException {
        receiver.stopGracefully();
    }

    public String getDay(long time){
        DateTimeFormatter ftf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return ftf.format(LocalDateTime.ofInstant(Instant.ofEpochMilli(time*1000),
                ZoneId.systemDefault()));
    }

}
