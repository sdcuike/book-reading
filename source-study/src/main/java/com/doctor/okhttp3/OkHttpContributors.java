package com.doctor.okhttp3;

import java.io.IOException;
import java.time.Duration;
import java.time.Instant;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.google.gson.Gson;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.ResponseBody;

/**
 * @author sdcuike
 *
 * @time 2016年2月1日 上午10:14:02
 */
public class OkHttpContributors {
    private static final String endpoint = "https://api.github.com/repos/square/okhttp/contributors";

    public static void main(String[] args) throws IOException {
        Request request = new Request.Builder().url(endpoint).build();
        OkHttpClient okHttpClient = new OkHttpClient();

        Instant start = Instant.now();
        ResponseBody responseBody = okHttpClient.newCall(request).execute().body();
        Instant end = Instant.now();
        long seconds = Duration.between(start, end).getSeconds();
        System.out.println(seconds);
        // TypeToken<List<Contributors>> type = new
        // TypeToken<List<Contributors>>() {
        // private static final long serialVersionUID = 1L;
        // };

        // List<Contributors> list = new
        // Gson().fromJson(responseBody.charStream(), type.getType());
        List<Contributors> list = JSON.parseArray(responseBody.string(), Contributors.class);
        responseBody.close();

        list.forEach(System.out::println);
    }

    private static class Contributors {
        private long id;
        private String login;
        private String url;
        private long contributions;

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public String getLogin() {
            return login;
        }

        public void setLogin(String login) {
            this.login = login;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public long getContributions() {
            return contributions;
        }

        public void setContributions(long contributions) {
            this.contributions = contributions;
        }

        @Override
        public String toString() {
            return new Gson().toJson(this);
        }
    }

}
