package cn.ac.iie.test;

import com.alibaba.fastjson.JSON;
import io.javalin.Javalin;
import io.javalin.http.staticfiles.Location;
import io.javalin.plugin.json.JavalinJson;

import java.util.HashMap;
import java.util.Map;

public class HttpUI {
    public static void main(String[] args) {
        Javalin app =Javalin.create(config -> {
            config.addStaticFiles("ACCESS-SERVICE/conf/html/", Location.EXTERNAL)
                    .defaultContentType = "text/plain;charset=utf-8";

        });
        JavalinJson.setToJsonMapper(JSON::toJSONString);
        app.exception(Exception.class, (exception, ctx) -> {
            exception.printStackTrace();
            Map<String, Object> map = new HashMap<>();
            map.put("message", exception.getMessage());
            ctx.json(map);
        });
        app.post("", ctx -> {

        });
        app.start(8088);
    }
}
