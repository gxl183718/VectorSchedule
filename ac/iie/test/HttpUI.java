package cn.ac.iie.test;

import com.alibaba.fastjson.JSON;
import io.javalin.Javalin;
import io.javalin.http.staticfiles.Location;
import io.javalin.plugin.json.JavalinJson;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.HashMap;
import java.util.Map;

public class HttpUI {
    public static void main(String[] args) {
        JedisPoolConfig c = new JedisPoolConfig();
        c.setMaxTotal(20);
        c.setMaxIdle(20);
        JedisPool jp = new JedisPool(c, "10.136.75.18", 30099,
                60 * 1000);
        System.out.println("init...");
        Jedis jedis = jp.getResource();
        System.out.println(jedis.hget("engine.version.conf", "face:v1.0"));
    }
}
