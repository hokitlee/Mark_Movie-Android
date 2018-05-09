package com.limitip.mm.mark_movie.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.limitip.mm.mark_movie.pojo.User;
import com.limitip.mm.mark_movie.R;
import com.limitip.mm.mark_movie.service.user.UserService;

public class UserLoginActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText userName;
    private EditText userPsd;
    private Button userLogin;
    private Button userRegister;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_login);
        userName = findViewById(R.id.loginUserName);
        userPsd = findViewById(R.id.loginUserPsd);
        userLogin = findViewById(R.id.user_login);
        userRegister = findViewById(R.id.user_register);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        userLogin.setOnClickListener(this);
        userRegister.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.user_login:
                UserService userService =new UserService();
                User user = new User();
                user.setUserName(userName.getText().toString());
                user.setUserPsd(userPsd.getText().toString());
                userService.doLogin(this,user);
                break;
            case R.id.user_register:
                Toast.makeText(this, "发生错误", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(this,UserRegisterActivity.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }
}
