package com.limitip.mm.mark_movie.service.user;

import com.limitip.mm.mark_movie.connectBase.ConnectBase;
import com.limitip.mm.mark_movie.pojo.Message;
import com.limitip.mm.mark_movie.pojo.User;
import com.parkingwang.okhttp3.LogInterceptor.LogInterceptor;

import io.reactivex.Observable;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface UserService {


    OkHttpClient okHttpClient = new OkHttpClient.Builder()
            .addInterceptor(new LogInterceptor()).build();

    @POST("user/login.do")
    Observable<User> DouserLogin(@Body User user);

    @POST("user/register.do")
    Observable<Message> DoRegister(@Body User user);

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(ConnectBase.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(okHttpClient)
            .build();

    UserService userService = retrofit.create(UserService.class);


}
