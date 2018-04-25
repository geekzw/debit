package com.gujian.debitapp.activity;

import android.app.ProgressDialog;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.gujian.debitapp.R;
import com.gujian.debitapp.base.HeaderActivity;
import com.gujian.debitapp.databinding.ActivityMessageBinding;

public class MessageActivity extends HeaderActivity<ActivityMessageBinding> {

    private ActivityMessageBinding binding;
    ProgressDialog dialog;

    private Handler handler = new Handler(){

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            dialog.dismiss();
            binding.message.setVisibility(View.VISIBLE);
        }
    };

    @Override
    public int getContentResId() {
        return R.layout.activity_message;
    }

    @Override
    protected void afterViewCreated(Bundle savedInstanceState) {
        binding = getContentBinding();
        initHeader("我的消息");

        dialog = new ProgressDialog(this);
        dialog.show();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Message message = new Message();
                handler.handleMessage(message);
            }
        },2000);

    }
}
