package cn.ac.iie.pulsarTools;


import cn.ac.iie.conf.Conf;
import cn.ac.iie.server.VectorData;
import org.apache.pulsar.client.api.*;


public class PulsarProducer {
    private String engineName;
    private String engineVersion;

    private PulsarClient pulsarClient;
    private Producer<VectorData> producer;

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

    public PulsarClient getPulsarClient() {
        return pulsarClient;
    }

    public void setPulsarClient(PulsarClient pulsarClient) {
        this.pulsarClient = pulsarClient;
    }

    public Producer<VectorData> getProducer() {
        return producer;
    }

    public void setProducer(Producer<VectorData> producer) {
        this.producer = producer;
    }

    public PulsarProducer(String engineName, String engineVersion) {
        this.engineName = engineName;
        this.engineVersion = engineVersion;
        try {
            this.pulsarClient = PulsarClient.builder().serviceUrl(Conf.producer_urls).build();
            this.producer = pulsarClient.newProducer(Schema.AVRO(VectorData.class))
                    .topic(Conf.pTopic)
                    .producerName(engineName + System.currentTimeMillis()%1000)
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


}
