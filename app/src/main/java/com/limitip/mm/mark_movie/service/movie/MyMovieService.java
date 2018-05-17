package com.limitip.mm.mark_movie.service.movie;

import com.limitip.mm.mark_movie.pojo.DoubanMovie;
import com.limitip.mm.mark_movie.pojo.Message;
import com.limitip.mm.mark_movie.pojo.Subjects;
import com.limitip.mm.mark_movie.pojo.User;
import com.limitip.mm.mark_movie.util.Id;
import com.limitip.mm.mark_movie.util.connectBase.ConnectBase;
import com.parkingwang.okhttp3.LogInterceptor.LogInterceptor;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import io.reactivex.Observable;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface MyMovieService {
    OkHttpClient okHttpClient = new OkHttpClient.Builder()
            .addInterceptor(new LogInterceptor()).build();

    @POST("/movieapi/add.do")
    Observable<Message> addtMovies(@Body Subjects subjects,
                                   @Header("userid") int userid,
                                   @Header("token") String token);

    @POST("/movieapi/findId.do")
    Observable<Map<String,ArrayList<Subjects>>> findMyMovie(@Body RequestBody requestBody,
                                                            @Header("userid") int userid,
                                                            @Header("token") String token);

    @POST("/movieapi/delete.do")
    Observable<Message> deleteMyMovie(@Body RequestBody requestBody,
                                                            @Header("userid") int userid,
                                                            @Header("token") String token);

    Retrofit retrofit1 = new Retrofit.Builder()
            .baseUrl(ConnectBase.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(okHttpClient)
            .build();

    MyMovieService MY_MOVIE_SERVICE = retrofit1.create(MyMovieService.class);
}
