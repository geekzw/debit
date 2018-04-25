package com.gujian.debitapp.activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Toast;

import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVObject;
import com.avos.avoscloud.AVQuery;
import com.avos.avoscloud.AVUser;
import com.avos.avoscloud.FindCallback;
import com.avos.avoscloud.LogInCallback;
import com.gujian.debitapp.MyApp;
import com.gujian.debitapp.R;
import com.gujian.debitapp.base.BaseActivity;
import com.gujian.debitapp.databinding.ActivityLoginBinding;
import com.gujian.debitapp.utils.AssetsUtil;
import com.gujian.debitapp.utils.PhoneFormatCheckUtils;

import java.util.List;

public class LoginActivity extends BaseActivity<ActivityLoginBinding> {

    private ActivityLoginBinding binding;

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_login;
    }

    @Override
    protected void afterCreate(Bundle savedInstanceState) {
        binding = getLayoutBinding();
        binding.login.setOnClickListener(v->login());
        binding.register.setOnClickListener(v->{
            startActivity(new Intent(this,RegisterActivity.class));
        });
    }

    private void login() {
        String password = binding.etPwd.getText().toString().trim();
        String username = binding.etMobile.getText().toString().trim();
        if(TextUtils.isEmpty(username)){
            Toast.makeText(this,"手机号码不能为空",Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(password)){
            Toast.makeText(this,"密码不能为空",Toast.LENGTH_SHORT).show();
            return;
        }
        try{
            if(!PhoneFormatCheckUtils.isMobile(username)){
                Toast.makeText(this,"手机号码不合法",Toast.LENGTH_SHORT).show();
                return;
            }
        }catch (Exception e){
            Toast.makeText(this,"手机号码不合法",Toast.LENGTH_SHORT).show();
            return;
        }


        ProgressDialog dialog = new ProgressDialog(this);
        dialog.show();
        AVUser.logInInBackground(username, password, new LogInCallback<AVUser>() {
            @Override
            public void done(AVUser avUser, AVException e) {
                dialog.dismiss();
                if(e==null){
                    MyApp.setUsername(username);
                    finish();
                }else{
                    Toast.makeText(LoginActivity.this, "用户名密码错误或者用户名不存在", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

}
