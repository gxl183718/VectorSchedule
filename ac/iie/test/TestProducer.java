package cn.ac.iie.test;

import cn.ac.iie.conf.Conf;
import cn.ac.iie.conf.TestConf;
import cn.ac.iie.server.VectorData;
import com.alibaba.fastjson.JSON;
import org.apache.pulsar.client.api.Producer;
import org.apache.pulsar.client.api.PulsarClient;
import org.apache.pulsar.client.api.PulsarClientException;
import org.apache.pulsar.client.api.Schema;

import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;

public class TestProducer implements Runnable{
    public static LinkedBlockingQueue<Map<String, Object>> cacheData = new LinkedBlockingQueue<>(1000);
    private PulsarClient pulsarClient;
    private Producer<Data> producer;

    static class Data{
        private String m_id;
        private String u_ch_id;
        private String m_chat_room;
        private Long m_publish_time;
        private String m_content;
        private Integer m_type;
        private String m_mm_url;

        public String getM_id() {
            return m_id;
        }

        public void setM_id(String m_id) {
            this.m_id = m_id;
        }

        public String getU_ch_id() {
            return u_ch_id;
        }

        public void setU_ch_id(String u_ch_id) {
            this.u_ch_id = u_ch_id;
        }

        public String getM_chat_room() {
            return m_chat_room;
        }

        public void setM_chat_room(String m_chat_room) {
            this.m_chat_room = m_chat_room;
        }

        public Long getM_publish_time() {
            return m_publish_time;
        }

        public void setM_publish_time(Long m_publish_time) {
            this.m_publish_time = m_publish_time;
        }

        public String getM_content() {
            return m_content;
        }

        public void setM_content(String m_content) {
            this.m_content = m_content;
        }

        public Integer getM_type() {
            return m_type;
        }

        public void setM_type(Integer m_type) {
            this.m_type = m_type;
        }

        public String getM_mm_url() {
            return m_mm_url;
        }

        public void setM_mm_url(String m_mm_url) {
            this.m_mm_url = m_mm_url;
        }
    }
    public TestProducer() {
        try {
            this.pulsarClient = PulsarClient.builder().serviceUrl(TestConf.producer_urls).build();
            this.producer = pulsarClient.newProducer(Schema.JSON(Data.class))
                    .topic(TestConf.producer_topic)
                    .create();
        } catch (PulsarClientException e) {
            e.printStackTrace();
        }
    }
    public void close() {
        try {
            if (producer != null)
                producer.close();
            if (pulsarClient != null)
                pulsarClient.close();
        } catch (PulsarClientException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        long num = 0l;
        long iNum = 0l;
        long tNum = 0l;
        while (true){
            try {
                Map<String, Object> map = cacheData.take();
                num ++;
                Data data = new Data();
                data.setM_id((String)map.get("m_id"));
                data.setU_ch_id((String)map.get("u_ch_id"));
                data.setM_chat_room((String)map.get("m_chat_room"));
                data.setM_content((String)map.get("m_content"));
                data.setM_publish_time(((Long)map.get("m_publish_time")) * 1000l);
                data.setM_type((Integer)map.get("m_type"));
                data.setM_mm_url((String)map.get("m_mm_url"));
//                producer.send(data);
                producer.sendAsync(data).thenAccept(msgId -> {
//                    System.out.printf("Message with ID %s successfully sent", msgId);
                });
                if (data.getM_type() == 1){
                    tNum ++;
                }else if (data.getM_type() == 3){
                    iNum ++;
                }
                if (num%1000 == 0){
                    System.out.println("total = " + num + ", image = " + iNum + ", text = " + tNum);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
//            catch (PulsarClientException e) {
//                e.printStackTrace();
//            }
        }
    }
}
