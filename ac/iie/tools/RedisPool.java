package cn.ac.iie.tools;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.JedisSentinelPool;
import redis.clients.jedis.exceptions.JedisException;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class RedisPool {
    private String url;
    private JedisSentinelPool jsp = null;
    private JedisPool jp = null;
    private String masterName;
    private Type type;

    public enum Type{
        SENTINEL,STANDALONE;
        Type(){
        }
    }

    public RedisPool(String url, String masterName) throws Exception {
        this.url = url;
        this.masterName = masterName;
        if (url.startsWith("STL"))
            type = Type.SENTINEL;
        else if (url.startsWith("STA"))
            type = Type.STANDALONE;
        else
            throw new Exception("when redis pool init, url '" + url + "' is illegal!");
    }

    public Jedis getResource() throws JedisException {
        switch (type) {
            case SENTINEL:{
                if (jsp != null)
                    return jsp.getResource();
                else {
                    synchronized (this) {
                        if (jsp == null){
                            JedisPoolConfig c = new JedisPoolConfig();
                            Set<String> sentinels = new HashSet<>();
                            sentinels.addAll(Arrays.asList(url.substring(6).split(";")));
                            jsp = new JedisSentinelPool(masterName, sentinels, c,
                                    30 * 1000);
                            System.out.println("New sentinel pool @ " + masterName);
                        }
                        return jsp.getResource();
                    }
                }
            }
            case STANDALONE:{
                if (jp == null){
                    synchronized (this) {
                        if (jp == null){
                            JedisPoolConfig c = new JedisPoolConfig();
                            c.setMaxTotal(20);
                            c.setMaxIdle(20);
                            String[] urls = url.substring(6).split(":");
                            jp = new JedisPool(c, urls[0], Integer.parseInt(urls[1]),
                                    60 * 1000);
                            System.out.println("New standalone pool @ " + url);
                        }
                        return jp.getResource();
                    }
                } else {
                    return jp.getResource();
                }
            }
            default:{
                return null;
            }
        }
    }
    public void putInstance(Jedis jedis){
        jedis.close();
    }
}
