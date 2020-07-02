package cn.ac.iie.server;

import cn.ac.iie.conf.Conf;
import cn.ac.iie.grpctool.GrpcClient;
import cn.ac.iie.tools.RedisPool;
import redis.clients.jedis.Jedis;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class RefreshEnginesThread extends TimerTask {
    private RedisPool redisPool;
    private static Map<String, GrpcClient> engineAddrHash = new ConcurrentHashMap<>();
    private static List<String> activeEngines = Collections
            .synchronizedList(new ArrayList<>());
    private static List<String> addrEngines = Collections
            .synchronizedList(new ArrayList<>());

    public RedisPool getRedisPool() {
        return redisPool;
    }

    public static List<String> getAddrEngines() {
        return addrEngines;
    }

    public static Map<String, GrpcClient> getEngineAddrHash() {
        return engineAddrHash;
    }
    public static List<String> getActiveEngines() {
        return activeEngines;
    }

    public void init() throws Exception {
        redisPool = new RedisPool(Conf.redisUrl, Conf.redisMasterName);
        Jedis jedis = redisPool.getResource();
        Map<String, String> activeMap = jedis.hgetAll(Conf.active);
        Map<String, String> addrMap = jedis.hgetAll(Conf.addr);
        jedis.close();
        activeMap.forEach((k, v) -> {
            activeEngines.add(k + ":" +v);
        });
        addrEngines.addAll(addrMap.keySet());
        activeEngines.forEach(activeEngine -> {
            if (addrEngines.contains(activeEngine)){
                engineAddrHash.put(activeEngine, new GrpcClient(addrMap.get(activeEngine),
                        activeEngine.split(":")[0], activeEngine.split(":")[1]));
                System.out.println("server '" + activeEngine + "' connection init completely.");
            }else {
                System.out.println("redis 'engine.addr.conf' no addr for active engine " + activeEngine);
            }
        });
        System.out.println("RefreshEngines init completely!--> active size " + activeEngines.size()
        + ", engineHash size " + engineAddrHash.size());
    }

    @Override
    public void run() {
        Jedis jedis = redisPool.getResource();
        Map<String, String> activeMap = jedis.hgetAll(Conf.active);
        Map<String, String> addrMap = jedis.hgetAll(Conf.addr);
        Map<String, EngineThreadHash.EngineThread> curActive = EngineThreadHash.getMap();
        jedis.close();
        Set<String> curActiveList = curActive.keySet();
        List<String> actives = new ArrayList<>();
        List<String> addrs = new ArrayList<>();
        activeMap.forEach((k, v) -> {
            actives.add(k + ":" + v);
        });
        addrs.addAll(addrMap.keySet());
        boolean activeChanged = false;
        if (!actives.containsAll(activeEngines) || !activeEngines.containsAll(actives)){
            synchronized (activeEngines){
                activeEngines.clear();
                activeEngines.addAll(actives);
            }
            activeChanged = true;
        }
        activeEngines.forEach(activeEngine -> {
            if (addrs.contains(activeEngine)){//engine.index.active
                if ( engineAddrHash.get(activeEngine) == null){//engine.index.active中，grpcClient没有初始化
                    engineAddrHash.put(activeEngine, new GrpcClient(addrMap.get(activeEngine),
                            activeEngine.split(":")[0], activeEngine.split(":")[1]));
                    System.out.println("server '" + activeEngine + "' connection init completely.");
                }else if (!addrMap.get(activeEngine).equals(engineAddrHash.get(activeEngine).getAddr())){//引擎地址改变
                    try {
                        System.out.println(activeEngine + " : connection addr changed . old->"
                                + engineAddrHash.get(activeEngine).getAddr()
                        + ", new->" + addrMap.get(activeEngine));
                        engineAddrHash.get(activeEngine).shutdown();
                        engineAddrHash.put(activeEngine, new GrpcClient(addrMap.get(activeEngine),
                                activeEngine.split(":")[0], activeEngine.split(":")[1]));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }else {
                    //no action
                }
            }else {//engine.addr.conf内没有这个active的engine
                try {
                    if (engineAddrHash.get(activeEngine) != null){
                        engineAddrHash.get(activeEngine).shutdown();
                        engineAddrHash.remove(activeEngine);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        //增加或删除引擎
        if(activeChanged){
            for (String active : actives) {
                if (activeEngines.contains(active)){

                }else {
                    EngineThreadHash.EngineThread thread = new EngineThreadHash.EngineThread(active.split(":")[0],
                            active.split(":")[1]);
                    EngineThreadHash.addToThreadHash(thread);
                    System.out.println("add new engine '" + active + "' completely. ");
                }
            }
            for (String active : activeEngines) {
                if (actives.contains(active)){

                }else {
                    EngineThreadHash.delThreadFromHash(active);
                }
            }
        }
    }
}
