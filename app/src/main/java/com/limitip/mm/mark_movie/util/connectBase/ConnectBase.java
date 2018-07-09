package com.limitip.mm.mark_movie.util.connectBase;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.limitip.mm.mark_movie.pojo.DoubanMovie;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by hokitlee on 2018/3/21.
 */

public class ConnectBase {
    //public static String BASE_URL = "http://10.11.73.218:8080/";
    //public static String BASE_URL = "http://192.168.139.128:8080/a/";
    public static String BASE_URL = "http://mark.limitip.com/";
    public static String API_DOUBAN_URL = "http://api.douban.com/";


    public static void main(String[] args) {
        OkHttpClient client = new OkHttpClient.Builder()
                .readTimeout(5, TimeUnit.SECONDS)
                .build();
        Request request = new Request.Builder()
                .url("http://api.douban.com/v2/movie/coming_soon")
                .build();
        Call call = client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                DoubanMovie doubanMovie = new DoubanMovie();
                Gson gson = new Gson();
                java.lang.reflect.Type type = new TypeToken<DoubanMovie>() {
                }.getType();
                doubanMovie = gson.fromJson(response.body().string(), type);
                System.out.println(doubanMovie.toString());
            }
        });
    }
}
