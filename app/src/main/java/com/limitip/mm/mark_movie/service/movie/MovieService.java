package com.limitip.mm.mark_movie.service.movie;

import com.limitip.mm.mark_movie.util.connectBase.ConnectBase;
import com.limitip.mm.mark_movie.pojo.DoubanMovie;
import com.parkingwang.okhttp3.LogInterceptor.LogInterceptor;

import io.reactivex.Observable;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

public interface MovieService {
    OkHttpClient okHttpClient = new OkHttpClient.Builder()
            .addInterceptor(new LogInterceptor()).build();

    @GET("/v2/movie/in_theaters")
    Observable<DoubanMovie> getNowShowMovie(@Header("Scope") String Scope);
    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(ConnectBase.DOUBAN_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(okHttpClient)
            .build();

    @GET("/v2/movie/coming_soon")
    Observable<DoubanMovie> getComingSoonMovie(@Header("Scope") String scope);

    @GET("/v2/movie/top250?")
    Observable<DoubanMovie> getTop250Movie(@Header("Scope") String scope);

    @GET("/v2/movie/search")
    Observable<DoubanMovie> getSearchMovie(@Query("q") String search1);


    MovieService movieService = retrofit.create(MovieService.class);
}
