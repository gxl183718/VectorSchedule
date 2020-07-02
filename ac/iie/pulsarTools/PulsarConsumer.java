package cn.ac.iie.pulsarTools;

import cn.ac.iie.conf.Conf;
import cn.ac.iie.server.CData;
import org.apache.pulsar.client.api.*;

public class PulsarConsumer {
    private String engineName;
    private String engineVersion;

    private PulsarClient pulsarClient;
    private Consumer<CData> consumer;

    public String getEngineName() {
        return engineName;
    }

    public void setEngineName(String engineName) {
        this.engineName = engineName;
    }

    public String getEngineVersion() {
        return engineVersion;
    }

    public void setEngineVersion(String engineVersion) {
        this.engineVersion = engineVersion;
    }

    public Consumer getConsumer() {
        return consumer;
    }

    public void setConsumer(Consumer consumer) {
        this.consumer = consumer;
    }

    public PulsarConsumer(String engineName, String engineVersion) {
        this.engineName = engineName;
        this.engineVersion = engineVersion;
        try {
            this.pulsarClient = PulsarClient.builder().serviceUrl(Conf.consumer_urls).build();
            consumer = pulsarClient.newConsumer(Schema.JSON(CData.class))
                    .batchReceivePolicy(BatchReceivePolicy.builder().maxNumMessages(50).build())
                    .subscriptionInitialPosition(SubscriptionInitialPosition.Latest)
                    .topic(Conf.cTopic)
                    //
                    .subscriptionName(engineName + ":" + engineVersion)
                    .subscriptionType(SubscriptionType.Shared)
                    .subscribe();
        } catch (PulsarClientException e) {
            e.printStackTrace();
        }
        this.consumer = consumer;
    }
    public Message receive() throws PulsarClientException {
        return consumer.receive();
    }

    public void close() {
        try {
            if (consumer != null)
                consumer.close();
            if (pulsarClient != null)
                pulsarClient.close();
        } catch (PulsarClientException e) {
            e.printStackTrace();
        }
    }

}
