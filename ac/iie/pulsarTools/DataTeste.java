package cn.ac.iie.pulsarTools;

import java.io.BufferedWriter;
import java.nio.ByteBuffer;

public class DataTeste {
    private String space = "image";
    private String engine = "face";
    private String url;
    private Long publish_time;
    private ByteBuffer vector;

    public String getSpace() {
        return space;
    }

    public void setSpace(String space) {
        this.space = space;
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Long getPublish_time() {
        return publish_time;
    }

    public void setPublish_time(Long publish_time) {
        this.publish_time = publish_time;
    }

    public ByteBuffer getVector() {
        return vector;
    }

    public void setVector(ByteBuffer vector) {
        this.vector = vector;
    }
}
