package com.limitip.mm.mark_movie.service.user;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.limitip.mm.mark_movie.pojo.User;
import com.limitip.mm.mark_movie.view.MainActivity;
import com.limitip.mm.mark_movie.view.UserLoginActivity;
import com.limitip.mm.mark_movie.connectBase.ConnectBase;
import com.limitip.mm.mark_movie.connectBase.Id;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * User: hokitlee
 * Date: 2018/4/11
 * Time: 22:24
 * Description:
 */
public class UserServiceImpl {

    public void doRegister(final Activity activity, User user) {
        String url = "user/register.do";
        RequestBody body = new FormBody.Builder()
                .add("userName", user.getUserName())
                .add("userPsd", user.getUserPsd())
                .add("sex", user.getSex())
                .add("phone", String.valueOf(user.getPhone()))
                .build();
        ConnectBase connectBase = new ConnectBase();
        Call call = connectBase.getPostCall(body, url);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

        }
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Gson gson = new Gson();
                java.lang.reflect.Type type = new TypeToken<User>(){}.getType();
                String msg = "";
                Boolean flag = false;
                if (response.body().string().equals("true")) {
                    msg = "注册成功，请返回登陆！";
                    flag = true;
                } else {
                    msg = "用户名已存在或其他错误，请重试！";
                    flag = false;
                }
                final Boolean FLAG = flag;
                final String MSG = msg;
                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(activity, MSG, Toast.LENGTH_SHORT).show();
                        if (FLAG) {
                            Intent intent = new Intent(activity, UserLoginActivity.class);
                            activity.startActivity(intent);
                            activity.finish();
                        }
                    }
                });
            }
        });
    }

    public void doLogin(final Activity activity, User user) {
        String url = "user/login.do";
        RequestBody body = new FormBody.Builder()
                .add("userName", user.getUserName())
                .add("userPsd", user.getUserPsd())
                .build();
        ConnectBase connectBase = new ConnectBase();
        Call call = connectBase.getPostCall(body,url);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(activity, "发生错误", Toast.LENGTH_SHORT).show();
                    }
                });
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String msg = "";
                boolean flag = false;
                Gson gson = new Gson();
                java.lang.reflect.Type type = new TypeToken<User>(){}.getType();
//                String tmp = response.body().string();
                User rUser = gson.fromJson(response.body().string(),type);
                if (rUser.getId() == -1){
                    msg = "用户名或密码错误！";
                }else{
                    msg = "登陆成功！";
                    flag = true;
                }
                final String MSG = msg;
                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(activity, MSG, Toast.LENGTH_SHORT).show();
                    }
                });
                if(flag){
                    Id.id = String.valueOf(rUser.getId());
                    Id.token = rUser.getToken();
                    Intent intent = new Intent(activity, MainActivity.class);
                    activity.startActivity(intent);
                    activity.finish();
                }
            }
        });
    }
}