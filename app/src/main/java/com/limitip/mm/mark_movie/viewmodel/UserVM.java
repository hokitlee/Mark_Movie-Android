package com.limitip.mm.mark_movie.viewmodel;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.Toast;

import com.limitip.mm.mark_movie.Model.UserModel;
import com.limitip.mm.mark_movie.Model.modelImp.UserModelImpl;
import com.limitip.mm.mark_movie.base.BaseLoadListener;
import com.limitip.mm.mark_movie.connectBase.Id;
import com.limitip.mm.mark_movie.connectBase.util.GetActivity;
import com.limitip.mm.mark_movie.pojo.User;
import com.limitip.mm.mark_movie.view.Iview.UserView;
import com.limitip.mm.mark_movie.view.MainActivity;
import com.limitip.mm.mark_movie.view.UserLoginActivity;


public class UserVM implements BaseLoadListener<User> {

    private UserView userView;
    UserModel userModel = new UserModelImpl();

    public UserVM() {
    }

    public UserVM(UserView userView) {
        this.userView = userView;
    }

    public void login(final User user, final View view) {
        userModel.userLogin(user, new BaseLoadListener<User>() {
            Activity activity = GetActivity.getActivityFromView(view);

            @Override
            public void LoadSuccess(User user) {
                if (user.getId() == -1) {
                    Toast.makeText(activity,"用户名或密码错误",Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(activity,"Welcome !",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(activity, MainActivity.class);
                    activity.startActivity(intent);
                    activity.finish();
                }
            }

            @Override
            public void LoadFail(String msg) {
                System.out.println(msg);
            }
        });
    }

    public void userRegister(User user, final View view) {

        userModel.userRegister(user, new BaseLoadListener<String>() {
            @Override
            public void LoadSuccess(String result) {
                Activity activity = GetActivity.getActivityFromView(view);
                if (result.equals("Success")){
                    Toast.makeText(activity,"注册成功",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(activity, UserLoginActivity.class);
                    activity.startActivity(intent);
                    activity.finish();
                }else {
                    Toast.makeText(activity,"用户名已存在",Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void LoadFail(String msg) {

            }
        });
    }

    @Override
    public void LoadSuccess(User user) {
        if (user.getId() == -1) {
            userView.Fail();
        } else {
            Id.token = user.getToken();
            Id.id = String.valueOf(user.getId());
            userView.Success();
        }
    }

    @Override
    public void LoadFail(String msg) {
        System.out.println(msg);
    }
}
