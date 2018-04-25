package com.gujian.debitapp.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.gujian.debitapp.R;
import com.gujian.debitapp.activity.WebViewActivity;
import com.gujian.debitapp.base.BaseFragment;
import com.gujian.debitapp.databinding.FragmentAssessBinding;
import com.gujian.debitapp.databinding.FragmentForumBinding;

/**
 * Created by gujian
 * Time is 2017/10/15
 * Email is gujian@maihaoche.com
 */

public class ForumFragment extends BaseFragment<FragmentForumBinding> implements View.OnClickListener {

    private static final String URL = "http://114.215.210.61:10080/bbs/portal.php?mobile=2";

    private String[] urls = {
            "http://app.diantudaikuan.com/calc/house/?&channel=ios_sb_app_dg",
            "http://app.diantudaikuan.com/calc/house/?&channel=ios_sb_app_dg",
            "http://app.diantudaikuan.com/calc/prepay?&channel=ios_sb_app_dg",
            "http://api.dashebao.com/dsbapi/Jsq/socialIndex?app=1&version=1",
            "http://app.diantudaikuan.com/calc/car",
            "http://api.dashebao.com/dsbapi/jsq/incomeTaxIndex?app=1"
    };

    private FragmentForumBinding binding;


    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_forum;
    }

    @Override
    protected void onAfterCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        binding = getLayoutBinding();
        binding.xiaoe.setOnClickListener(this);
        binding.xinyong.setOnClickListener(this);
        binding.fangdai.setOnClickListener(this);
        binding.gongjijin.setOnClickListener(this);
        binding.zuhefang.setOnClickListener(this);
        binding.xinyongka.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.xiaoe:
                WebViewActivity.getIntence(getContext(),urls[0],"小额贷款");
                break;
            case R.id.xinyong:
                WebViewActivity.getIntence(getContext(),urls[1],"信用");
                break;
            case R.id.fangdai:
                WebViewActivity.getIntence(getContext(),urls[2],"房贷计算");
                break;
            case R.id.gongjijin:
                WebViewActivity.getIntence(getContext(),urls[3],"公积金查询");
                break;
            case R.id.zuhefang:
                WebViewActivity.getIntence(getContext(),urls[4],"组合房贷");
                break;
            case R.id.xinyongka:
                WebViewActivity.getIntence(getContext(),urls[5],"信用卡积分");
                break;
        }
    }
}
