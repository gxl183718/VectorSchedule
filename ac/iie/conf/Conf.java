package cn.ac.iie.conf;

import com.zzq.dolls.config.From;

@From(name = "conf/conf.yml", alternateNames = "conf.yaml")
public class Conf {
    @From(name = "consumer.urls")
    public static String consumer_urls;
    @From(name = "consumer.topic")
    public static String cTopic;
    @From(name = "consumer.group")
    public static String cGroup;

    @From(name = "producer.urls")
    public static String producer_urls;
    @From(name = "producer.topic")
    public static String pTopic;
    @From(name = "engine.thread.num")
    public static int engineThreadNum;

    @From(name = "redisUrl")
    public static String redisUrl;
    @From(name = "redisMasterName")
    public static String redisMasterName;

    @From(name = "mamPre")
    public static String mamPre;

    @From(name = "httpServerPort")
    public static int httpServerPort;

    @From(name = "addr.conf")
    public static String addr;
    @From(name = "index.active")
    public static String active;

}
