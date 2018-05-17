package com.limitip.mm.mark_movie.view;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.RadioButton;

import com.limitip.mm.mark_movie.R;
import com.limitip.mm.mark_movie.databinding.ActivityUserRegisterBinding;
import com.limitip.mm.mark_movie.pojo.User;
import com.limitip.mm.mark_movie.util.MyRegexUtil;
import com.limitip.mm.mark_movie.viewmodel.UserVM;

public class UserRegisterActivity extends AppCompatActivity implements View.OnClickListener {
    private ActivityUserRegisterBinding binding;
    private User user;
    private Activity activity;
    private Toolbar toolbar;
    private UserVM userVM = new UserVM();
    private RadioButton radioButton;

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

        binding.setUserVm(userVM);
//        binding.select.getCheckedRadioButtonId();
        binding.registerButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.registerButton:
                User user = binding.getUser();
                if( user.getUserPsd() == null || !MyRegexUtil.cheakUserPsd(user.getUserPsd())){
                    binding.hint.setText("密码必须是8-20位的英文或数字");
                    return;
                }
                radioButton = findViewById(binding.select.getCheckedRadioButtonId());
                user.setSex((String) radioButton.getText());
                userVM.userRegister(user, binding);
                break;
            default:
                break;
        }
    }
}
