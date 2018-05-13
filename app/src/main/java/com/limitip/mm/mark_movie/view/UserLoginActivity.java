package com.limitip.mm.mark_movie.view;

import android.app.Activity;
import android.content.Intent;
import android.databinding.Bindable;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.limitip.mm.mark_movie.R;
import com.limitip.mm.mark_movie.databinding.ActivityUserLoginBinding;
import com.limitip.mm.mark_movie.pojo.User;
import com.limitip.mm.mark_movie.viewmodel.UserVM;

public class UserLoginActivity extends AppCompatActivity implements View.OnClickListener {
    private ActivityUserLoginBinding binding;
    private Toolbar toolbar;
    private Activity activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_user_login);
        initialize();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.user_login:
                System.out.println("onClick");
                break;
            case R.id.user_register:
                Intent intent = new Intent(this, UserRegisterActivity.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }

    private void initialize() {
        activity = this;
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        binding.setUser(new User());
        binding.setUserVm(new UserVM());
        binding.userRegister.setOnClickListener(this);
    }

}
