package cn.ac.iie.server;

import cn.ac.iie.conf.Conf;
import com.alibaba.fastjson.JSON;
import com.zzq.dolls.config.LoadConfig;
import java.util.Timer;

public class SearchServer {
    public static int logLevel;
    public static void main(String[] args) throws Exception{
        logLevel = Integer.parseInt(args[0]);
        LoadConfig.load(Conf.class);
        //监控向量提取引擎的注册、停用、升级事件
        Timer timer = new Timer("MonitorRegistration");
        RefreshEnginesThread refreshEnginesThread = new RefreshEnginesThread();
        refreshEnginesThread.init();
        timer.schedule(refreshEnginesThread, 10 * 60 * 1000, 60 * 1000);

        EngineThreadHash engineThreadHash = new EngineThreadHash();
        for (String activeEngine : RefreshEnginesThread.getActiveEngines()) {
            String[] engine = activeEngine.split(":");
            EngineThreadHash.EngineThread thread = new EngineThreadHash.EngineThread(engine[0], engine[1]);
            thread.setName(activeEngine);
            engineThreadHash.addToThreadHash(thread);
        }
    }

    public static void logInfo(int level, String info){
        if (level <= logLevel){
            System.out.println(info);
        }
    }
}
