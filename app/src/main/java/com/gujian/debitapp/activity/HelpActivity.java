package com.gujian.debitapp.activity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.gujian.debitapp.R;
import com.gujian.debitapp.base.BaseActivity;
import com.gujian.debitapp.base.HeaderActivity;
import com.gujian.debitapp.databinding.ActivityHelpBinding;
import com.gujian.debitapp.entity.HelpEntity;
import com.gujian.debitapp.utils.AssetsUtil;

import java.util.List;

public class HelpActivity extends HeaderActivity<ActivityHelpBinding> {

    private ActivityHelpBinding binding;

    private HelpEntity helpEntity;

    private ArrayAdapter<String> adapter;

    @Override
    public int getContentResId() {
        return R.layout.activity_help;
    }

    @Override
    protected void afterViewCreated(Bundle savedInstanceState) {
        binding = getContentBinding();
        initHeader("帮助");
        initView();
    }

    private void initView() {
        helpEntity = AssetsUtil.getHelpJson(this);
        List<HelpEntity.DataBean.ListBean> list = helpEntity.getData().getList();
        for(HelpEntity.DataBean.ListBean listBean:list){
            LinearLayout view = (LinearLayout) LayoutInflater.from(this).inflate(R.layout.help_item,null);
            TextView textView = view.findViewById(R.id.question);
            textView.setText(listBean.getName());
            adapter = new ArrayAdapter<>(this,R.layout.answer_item,listBean.getAnswer());
            ListView listView = view.findViewById(R.id.listView);
            listView.setAdapter(adapter);
            binding.content.addView(view);
        }
    }
}
