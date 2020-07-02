package cn.ac.iie.test;

import cn.ac.iie.conf.TestConf;
import cn.ac.iie.httptool.OKClientUtils;
import cn.ac.iie.tools.LogTool;
import lombok.Setter;
import mammoth.jclient.ClientAPI;
import mammoth.jclient.KeyFactory;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author zhangzhanqi
 * @version 1.0
 * @date 2019-9-5 10:04
 */
public class AccessTextData implements Runnable {

/*
预留10.136.140.130  9876端口为http服务端口用于获取龙存内的微博数据
 */
    private List<MField> fields;

    public static LinkedBlockingQueue<Map<String, Object>> cacheData = new LinkedBlockingQueue<>(50);

    public static final SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:00:00");


    private static LogTool logTool = new LogTool();

    private ClientAPI clientAPI;

    public AccessTextData() {
    }

    @Setter
    private boolean start = true;



    @Override
    public void run() {

        while (start) {
            Map<String, Object> data = null;
            try {
                data = cacheData.take();
                List<String> ma_picture_files = data.get("ma_picture_files").toString().length() <= 2 ? null : (List<String>) data.get("ma_picture_files");
                List<String> ma_audio_files = data.get("ma_audio_files").toString().length() <= 2 ? null : (List<String>) data.get("ma_audio_files");
                List<String> ma_video_files = data.get("ma_video_files").toString().length() <= 2 ? null : (List<String>) data.get("ma_video_files");
                long time = data.get("m_publish_time") == null ? System.currentTimeMillis() / 1000 : (Long) data.get("m_publish_time");
                String key = null;
                String md5 = null;
                int m_type = 1;
                if (null != ma_picture_files && !ma_picture_files.isEmpty()) {
                    continue;
                }else if (ma_audio_files !=null || ma_video_files != null){
                    continue;
                }

                data.remove("ma_picture_files");

                data.put("m_id", data.get("g_ch_key"));
                data.remove("g_ch_key");
                data.put("m_chat_room", data.get("m_group_id"));
                data.remove("m_group_id");

                data.put("m_mm_url", key);
                data.put("m_type", m_type);

                TestProducer.cacheData.put(data);

//                LogManager.info("...... media put : " + data.toString());
            //LogManager.info(String.format("mmType:%s; downType:%s; mmUrl:%s; dup:%s", mmType, downType, mmUrl, dup));
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 生成md5
     * @param bytes
     * @return
     * @throws NoSuchAlgorithmException
     */
    private  String getMd5(byte[] bytes) throws NoSuchAlgorithmException {
        MessageDigest md;
        md = MessageDigest.getInstance("md5");
        md.update(bytes);
        byte[] mdbytes = md.digest();
        StringBuffer sb = new StringBuffer();
        for (int j = 0; j < mdbytes.length; j++) {
            sb.append(Integer.toString((mdbytes[j] & 0xff) + 0x100, 16).substring(1));
        }
        return sb.toString();
    }

}
