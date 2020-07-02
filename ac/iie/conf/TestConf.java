package cn.ac.iie.conf;

import com.zzq.dolls.config.From;

@From(name = "conf/test.yml", alternateNames = "test.yaml")
public class TestConf {
    @From(name = "consumer.urls")
    public static String consumer_urls;
    @From(name = "consumer.topic")
    public static String consumer_topic;
    @From(name = "consumer.group")
    public static String consumer_group;

    @From(name = "producer.urls")
    public static String producer_urls;
    @From(name = "producer.topic")
    public static String producer_topic;
    @From(name = "producer.sub")
    public static String producer_sub;

    @From(name = "loongAddr")
    public static String loongAddr;
    @From(name = "mamAddr")
    public static String mamAddr;

}
