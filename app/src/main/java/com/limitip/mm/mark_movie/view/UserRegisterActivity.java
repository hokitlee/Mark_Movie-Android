package com.limitip.mm.mark_movie.view;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.limitip.mm.mark_movie.pojo.User;
import com.limitip.mm.mark_movie.R;
import com.limitip.mm.mark_movie.service.user.UserService;
import com.limitip.mm.mark_movie.databinding.ActivityUserRegisterBinding;

public class UserRegisterActivity extends AppCompatActivity {
    private ActivityUserRegisterBinding binding;
    private User user;
    private UserService userService;
    private Activity activity;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_user_register);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        //开启toolbar返回按钮
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        activity = this;
        binding.setController(new Controller());
        user = new User();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
            default:
                break;
        }
        return true;
    }

    public class Controller {
        public void onUserNameChanged(CharSequence s, int start, int before, int count) {
            user.setUserName(s.toString());
        }

        public void onUserPsdChanged(CharSequence s, int start, int before, int count) {
            user.setUserPsd(s.toString());
        }

        public void onUserSexChanged(CharSequence s, int start, int before, int count) {
            user.setSex(s.toString());
        }

        public void onUserPhoneChanged(CharSequence s, int start, int before, int count) {
            user.setPhone(Integer.parseInt(s.toString()));
        }

        public void onClickListenerBinding() {
            userService = new UserService();
            userService.doRegister(activity, user);
        }
    }
}
