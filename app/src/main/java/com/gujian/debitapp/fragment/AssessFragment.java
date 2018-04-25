package com.gujian.debitapp.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVObject;
import com.avos.avoscloud.AVQuery;
import com.avos.avoscloud.FindCallback;
import com.gujian.debitapp.R;
import com.gujian.debitapp.adapter.AssessAdapter;
import com.gujian.debitapp.adapter.HomeAdapter;
import com.gujian.debitapp.base.BaseFragment;
import com.gujian.debitapp.databinding.FragmentAssessBinding;
import com.mylhyl.crlayout.SwipeRefreshAdapterView;
import com.zhouwei.mzbanner.holder.MZHolderCreator;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gujian
 * Time is 2017/10/15
 * Email is gujian@maihaoche.com
 */

public class AssessFragment extends BaseFragment<FragmentAssessBinding> implements SwipeRefreshAdapterView.OnListLoadListener, SwipeRefreshLayout.OnRefreshListener {

    private FragmentAssessBinding binding;

    private AssessAdapter adapter;

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_assess;
    }

    @Override
    protected void onAfterCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        binding = getLayoutBinding();
        initView();
        initData();
    }

    private void initView() {
        binding.swipeRefresh.setLayoutManager(new LinearLayoutManager(getContext(),
                LinearLayoutManager.VERTICAL, false));
        binding.swipeRefresh.setOnListLoadListener(this);
        binding.swipeRefresh.setOnRefreshListener(this);

        adapter = new AssessAdapter(getContext());
        binding.swipeRefresh.setAdapter(adapter);
    }

    private void initData() {
        AVQuery<AVObject> avQuery = new AVQuery<>("QDBorrow");
        avQuery.orderByAscending("companyId");
        avQuery.include("owner");
        avQuery.findInBackground(new FindCallback<AVObject>() {
            @Override
            public void done(List<AVObject> list, AVException e) {
                adapter.setmList(list);
                binding.swipeRefresh.setRefreshing(false);
            }
        });

    }

    @Override
    public void onListLoad() {
        binding.swipeRefresh.setLoading(false);
    }

    @Override
    public void onRefresh() {
        initData();
    }
}
