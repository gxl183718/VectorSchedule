package cn.ac.iie.test;

import cn.ac.iie.conf.TestConf;
import cn.ac.iie.tools.LogTool;
import com.alibaba.fastjson.JSON;
import com.zzq.dolls.config.LoadConfig;
import lombok.Setter;
import mammoth.jclient.ClientAPI;
import org.apache.commons.io.Charsets;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;

public class TestMain{
    public static void main(String[] args) {
        try {
            LoadConfig.load(TestConf.class);
            ClientAPI clientAPI = new ClientAPI();
            clientAPI.init(TestConf.mamAddr);

            String fieldJson = FileUtils.readFileToString(new File("conf/mqfile.json"), Charsets.UTF_8);
            List<MField> mFields = JSON.parseArray(fieldJson, MField.class);

            TestConsumer testConsumer = new TestConsumer(mFields);
            testConsumer.start();

            for (int i = 0; i < 10; i++) {
                AccessMediaData accessMediaData = new AccessMediaData(clientAPI);
                Thread thread = new Thread(accessMediaData);
                thread.start();
            }
            AccessTextData accessTextData = new AccessTextData();
            Thread thread = new Thread(accessTextData);
            thread.start();


            TestProducer testProducer = new TestProducer();
            Thread thread1 = new Thread(testProducer);
            thread1.start();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
