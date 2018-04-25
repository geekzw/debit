package com.gujian.debitapp.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gujian.debitapp.MyApp;
import com.gujian.debitapp.R;
import com.gujian.debitapp.activity.HelpActivity;
import com.gujian.debitapp.activity.KeFuActivity;
import com.gujian.debitapp.activity.LoginActivity;
import com.gujian.debitapp.activity.MessageActivity;
import com.gujian.debitapp.activity.RegisterActivity;
import com.gujian.debitapp.base.BaseFragment;
import com.gujian.debitapp.databinding.FragmentMainBinding;
import com.gujian.debitapp.entity.HelpEntity;

/**
 * Created by gujian
 * Time is 2017/10/15
 * Email is gujian@maihaoche.com
 */

public class MainFragment extends BaseFragment<FragmentMainBinding> {

    private FragmentMainBinding binding;

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_main;
    }

    @Override
    protected void onAfterCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        binding = getLayoutBinding();

        binding.kefu.setOnClickListener(v->{
            startActivity(new Intent(getContext(), KeFuActivity.class));
        });

        binding.help.setOnClickListener(v->{
            startActivity(new Intent(getContext(), HelpActivity.class));
        });
        binding.zhuxiao.setOnClickListener(v->{
            startActivity(new Intent(getContext(), LoginActivity.class));
            ((Activity)getContext()).finish();
        });

        binding.register.setOnClickListener(v->{
            startActivity(new Intent(getContext(), MessageActivity.class));
        });
        binding.unLogin.setOnClickListener(v->{
            startActivity(new Intent(getContext(), LoginActivity.class));
        });
        binding.zhuxiao.setOnClickListener(v->{
            binding.unLogin.setVisibility(View.VISIBLE);
            binding.logined.setVisibility(View.GONE);
            binding.zhuxiao.setVisibility(View.GONE);
            binding.register.setVisibility(View.GONE);
            MyApp.setUsername("");
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        if(TextUtils.isEmpty(MyApp.getUsername())){
            binding.unLogin.setVisibility(View.VISIBLE);
            binding.logined.setVisibility(View.GONE);
            binding.zhuxiao.setVisibility(View.GONE);
            binding.register.setVisibility(View.GONE);
        }else{
            binding.unLogin.setVisibility(View.GONE);
            binding.logined.setVisibility(View.VISIBLE);
            binding.username.setText(MyApp.getUsername());
            binding.zhuxiao.setVisibility(View.VISIBLE);
            binding.register.setVisibility(View.VISIBLE);
        }
    }
}
