package com.limitip.mm.mark_movie.viewmodel;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.Toast;

import com.limitip.mm.mark_movie.Model.UserModel;
import com.limitip.mm.mark_movie.Model.modelImp.UserModelImpl;
import com.limitip.mm.mark_movie.R;
import com.limitip.mm.mark_movie.adapter.CustomDialog;
import com.limitip.mm.mark_movie.base.BaseLoadListener;
import com.limitip.mm.mark_movie.util.Id;
import com.limitip.mm.mark_movie.util.GetActivity;
import com.limitip.mm.mark_movie.pojo.User;
import com.limitip.mm.mark_movie.view.Iview.UserView;
import com.limitip.mm.mark_movie.view.MainActivity;
import com.limitip.mm.mark_movie.view.UserLoginActivity;


public class UserVM{

    private UserView userView;
    UserModel userModel = new UserModelImpl();

    public UserVM() {
    }


    public void login(final User user, final View view) {
        final CustomDialog dialog = new CustomDialog(GetActivity.getActivityFromView(view), R.style.CustomDialog);
        dialog.show();
        userModel.userLogin(user, new BaseLoadListener<User>() {
            Activity activity = GetActivity.getActivityFromView(view);
            @Override
            public void LoadSuccess(User user) {
                if (user.getId() == -1) {
                    Toast.makeText(activity,"用户名或密码错误",Toast.LENGTH_SHORT).show();
                    dialog.dismiss();
                } else {
                    Id.id = user.getId();
                    Id.token = user.getToken();
                    Toast.makeText(activity,"Welcome !",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(activity, MainActivity.class);
                    activity.startActivity(intent);
                    dialog.dismiss();
                    activity.finish();
                }
            }

            @Override
            public void LoadFail(String msg) {
                dialog.dismiss();
            }
        });
    }

    public void userRegister(User user, final View view) {
        final CustomDialog dialog = new CustomDialog(GetActivity.getActivityFromView(view), R.style.CustomDialog);
        dialog.show();
        userModel.userRegister(user, new BaseLoadListener<String>() {
            @Override
            public void LoadSuccess(String result) {
                Activity activity = GetActivity.getActivityFromView(view);
                if (result.equals("Success")){
                    Toast.makeText(activity,"注册成功",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(activity, UserLoginActivity.class);
                    dialog.dismiss();
                    activity.startActivity(intent);
                    activity.finish();
                }else {
                    dialog.dismiss();
                    Toast.makeText(activity,"用户名已存在",Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void LoadFail(String msg) {
                dialog.dismiss();
            }
        });
    }

}
