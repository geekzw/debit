package com.gujian.debitapp.activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Toast;

import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVUser;
import com.avos.avoscloud.LogInCallback;
import com.avos.avoscloud.SignUpCallback;
import com.gujian.debitapp.MyApp;
import com.gujian.debitapp.R;
import com.gujian.debitapp.base.BaseActivity;
import com.gujian.debitapp.databinding.ActivityRegisterBinding;
import com.gujian.debitapp.utils.PhoneFormatCheckUtils;

public class RegisterActivity extends BaseActivity<ActivityRegisterBinding> {

    private ActivityRegisterBinding binding;

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_register;
    }

    @Override
    protected void afterCreate(Bundle savedInstanceState) {
        binding = getLayoutBinding();
        binding.login.setOnClickListener(v->login());
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

        AVUser user = new AVUser();// 新建 AVUser 对象实例
        user.setUsername(username);// 设置用户名
        user.setPassword(password);// 设置密码
        ProgressDialog dialog = new ProgressDialog(this);
        dialog.show();
        user.signUpInBackground(new SignUpCallback() {
            @Override
            public void done(AVException e) {
                dialog.dismiss();
                if(e==null){
                    MyApp.setUsername(username);
                    finish();
                }else{
                    Toast.makeText(RegisterActivity.this, "注册失败", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
