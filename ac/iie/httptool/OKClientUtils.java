package cn.ac.iie.httptool;

import okhttp3.*;

import java.io.File;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @author zhangzhanqi
 * @version 1.0
 * @date 2019-8-26 16:18
 */
public class OKClientUtils {

    // 定义请求客户端
    //private static OkHttpClient client = new OkHttpClient();

    private static OkHttpClient client = new OkHttpClient.Builder()
            .readTimeout(10, TimeUnit.SECONDS)
            .connectTimeout(10, TimeUnit.SECONDS)
            .build();

    /**
     * get 请求
     * @param url 请求URL
     */
    public static byte[] doGet(String url) throws Exception {
        return doGet(url, null);
    }


    /**
     * get 请求
     * @param url 请求URL
     * @param query 携带参数参数
     */
    public static byte[] doGet(String url, Map<String, String> query) throws Exception {

        return doGet(url, null, query);
    }

    /**
     * get 请求
     * @param url url
     * @param header 请求头参数
     * @param query 参数
     */
    public static byte[] doGet(String url, Map<String, String> header, Map<String, String> query) throws Exception {

        // 创建一个请求 Builder
        Request.Builder builder = new Request.Builder();
        // 创建一个 request
        Request request = builder.url(url).build();

        // 创建一个 HttpUrl.Builder
        HttpUrl.Builder urlBuilder = request.url().newBuilder();
        // 创建一个 Headers.Builder
        Headers.Builder headerBuilder = request.headers().newBuilder();

        // 装载请求头参数
        if (header != null) {
            header.forEach(headerBuilder::add);
        }
        // 装载请求的参数
        if (query != null) {
            query.forEach(urlBuilder::addQueryParameter);
        }
        // 设置自定义的 builder
        builder.url(urlBuilder.build()).headers(headerBuilder.build());

        try (Response execute = client.newCall(builder.build()).execute()) {
            ResponseBody body = execute.body();
            if (body != null) {
                return body.bytes();
            }
        }
        return null;
    }

    /**
     * post 请求， 请求参数 并且 携带文件上传
     * @param url url
     * @param header 请求头参数
     * @param parameter 参数
     * @param file 上传文件
     */
    public static String doPost(String url, Map<String, String> header, Map<String, String> parameter, File file) throws Exception {

        // 创建一个请求 Builder
        Request.Builder builder = new Request.Builder();
        // 创建一个 request
        Request request = builder.url(url).build();

        // 创建一个 Headers.Builder
        Headers.Builder headerBuilder = request.headers().newBuilder();

        // 装载请求头参数
        if (header != null) {
            header.forEach(headerBuilder::add);
        }
        MultipartBody.Builder requestBuilder = new MultipartBody.Builder();
        // 状态请求参数
        if (parameter != null) {
            parameter.forEach(requestBuilder::addFormDataPart);
        }
        if (file != null) {
            // application/octet-stream
            requestBuilder.addFormDataPart("uploadFiles", file.getName(), RequestBody.create(MediaType.parse("application/octet-stream"), file));
        }

        // 设置自定义的 builder
        builder.headers(headerBuilder.build()).post(requestBuilder.build());

        // 然后再 build 一下
        try (Response execute = client.newCall(builder.build()).execute()) {
            ResponseBody body = execute.body();
            if (body != null) {
                return body.string();
            }
        }
        return null;
    }

    /**
     * post 请求， 请求参数 并且 携带文件上传
     * @param url url
     * @param header 请求头参数
     * @param parameter 参数
     * @param json body
     */
    public static String doPost(String url, Map<String, String> header, Map<String, String> parameter, String json) throws Exception {

        // 创建一个请求 Builder
        Request.Builder builder = new Request.Builder();
        // 创建一个 request
        Request request = builder.url(url).build();

        // 创建一个 Headers.Builder
        Headers.Builder headerBuilder = request.headers().newBuilder();

        // 装载请求头参数
        if (header != null) {
            header.forEach(headerBuilder::add);
        }
        MultipartBody.Builder requestBuilder = new MultipartBody.Builder();
        // 状态请求参数
        if (parameter != null) {
            parameter.forEach(requestBuilder::addFormDataPart);
        }
        if (json != null && !json.isEmpty()) {
            requestBuilder.addPart(RequestBody.create(MediaType.parse("application/json; charset=utf-8"), json));
        }

        // 设置自定义的 builder
        builder.headers(headerBuilder.build()).post(requestBuilder.build());

        // 然后再 build 一下
        try (Response execute = client.newCall(builder.build()).execute()) {
            ResponseBody body = execute.body();
            if (body != null) {
                return body.string();
            }
        }
        return null;
    }

    /**
     * post 请求， 请求参数 并且 携带文件上传二进制流
     * @param url url
     * @param header 请求头参数
     * @param parameter 参数
     * @param fileName 文件名
     * @param fileByte 文件的二进制流
     */
    public static String doPost(String url, Map<String, String> header,
                                Map<String, String> parameter, String fileName, byte [] fileByte) throws Exception {
        // 创建一个请求 Builder
        Request.Builder builder = new Request.Builder();
        // 创建一个 request
        Request request = builder.url(url).build();

        // 创建一个 Headers.Builder
        Headers.Builder headerBuilder = request.headers().newBuilder();

        // 装载请求头参数
        if (header != null) {
            header.forEach(headerBuilder::add);
        }

        MultipartBody.Builder requestBuilder = new MultipartBody.Builder();

        // 状态请求参数
        if (parameter != null) {
            parameter.forEach(requestBuilder::addFormDataPart);
        }

        if (fileByte.length > 0) {
            // application/octet-stream
            requestBuilder.addFormDataPart("uploadFiles", fileName, RequestBody.create(MediaType.parse("application/octet-stream"), fileByte));
        }

        // 设置自定义的 builder
        builder.headers(headerBuilder.build()).post(requestBuilder.build());

        try (Response execute = client.newCall(builder.build()).execute()) {
            ResponseBody body = execute.body();
            if (body != null) {
                return body.string();
            } else {
                return null;
            }
        }
    }




    /**
     * post 请求  携带文件上传
     * @param url url
     * @param file 上传件
     */
    public static String doPost(String url, File file) throws Exception {
        return doPost(url, null, null, file);
    }

    /**
     * post 请求
     * @param url url
     * @param header 请求头
     * @param parameter 参数
     */
    public static String doPost(String url, Map<String, String> header, Map<String, String> parameter) throws Exception {
        return doPost(url, header, parameter, "");
    }

    /**
     * post 请求
     * @param url url
     * @param parameter 参数
     */
    public static String doPost(String url, Map<String, String> parameter) throws Exception {
        return doPost(url, null, parameter, "");
    }

    /**
     * post 请求
     * @param url url
     * @param json body
     */
    public static String doPost(String url, String json) throws Exception {
        Request request = new Request.Builder().url(url).post(RequestBody.create(json, MediaType.parse("application/octet-stream"))).build();
        Response response = client.newCall(request).execute();

        if (!response.isSuccessful()) {
            throw new Exception("服务器端错误: " + response);
        }
        ResponseBody body = response.body();
        if (body != null) {
            String string = body.string();
            body.close();
            response.close();
            return string;
        } else {
            response.close();
            return null;
        }
    }
    public static byte[] doPost(String url, String json, String haha) throws Exception {
        Request request = new Request.Builder().url(url).post(RequestBody.create(json, MediaType.parse("application/octet-stream"))).build();
        Response response = client.newCall(request).execute();

        if (!response.isSuccessful()) {
            throw new Exception("服务器端错误: " + response);
        }
        ResponseBody body = response.body();
        if (body != null) {
            byte[] bs = body.bytes();
            body.close();
            response.close();
            return bs;
        } else {
            response.close();
            return null;
        }
    }

}
