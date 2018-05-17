package com.limitip.mm.mark_movie.view;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.limitip.mm.mark_movie.R;
import com.limitip.mm.mark_movie.databinding.ActivityUserRegisterBinding;
import com.limitip.mm.mark_movie.pojo.User;
import com.limitip.mm.mark_movie.viewmodel.UserVM;

public class UserRegisterActivity extends AppCompatActivity {
    private ActivityUserRegisterBinding binding;
    private User user;
    private Activity activity;
    private Toolbar toolbar;
    private UserVM userVM;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initialize();
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

    void initialize() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_user_register);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        //开启toolbar返回按钮
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        activity = this;
        user = new User();
        binding.setUser(user);
        userVM = new UserVM();
        binding.setUserVm(userVM);
    }
}
