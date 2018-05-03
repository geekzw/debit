package com.gujian.debitapp.fragment;


import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVObject;
import com.avos.avoscloud.AVQuery;
import com.avos.avoscloud.FindCallback;
import com.bumptech.glide.Glide;
import com.gujian.debitapp.R;
import com.gujian.debitapp.adapter.HomeAdapter;
import com.gujian.debitapp.base.BaseFragment;
import com.gujian.debitapp.databinding.FragmentHomeBinding;
import com.mylhyl.crlayout.SwipeRefreshAdapterView;
import com.zhouwei.mzbanner.holder.MZHolderCreator;
import com.zhouwei.mzbanner.holder.MZViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gujian
 * Time is 2017/10/15
 * Email is gujian@maihaoche.com
 */

public class HomeFragment extends BaseFragment<FragmentHomeBinding> implements SwipeRefreshAdapterView.OnListLoadListener, SwipeRefreshLayout.OnRefreshListener {

    private FragmentHomeBinding binding;

    private List<String> images;

    private HomeAdapter homeAdapter;

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_home;
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

        homeAdapter = new HomeAdapter(getContext());
        binding.swipeRefresh.setAdapter(homeAdapter);
        homeAdapter.setmList(new ArrayList<>());
    }

    private void initData() {
        images = new ArrayList<>();
        AVQuery<AVObject> avQuery = new AVQuery<>("QDBorrow");
        avQuery.orderByAscending("companyId");
        avQuery.include("owner");
        avQuery.findInBackground(new FindCallback<AVObject>() {
            @Override
            public void done(List<AVObject> list, AVException e) {
                homeAdapter.setmList(list);

                binding.swipeRefresh.setRefreshing(false);
            }
        });

        AVQuery<AVObject> avQueryBanner = new AVQuery<>("QDBanner");
        avQuery.orderByDescending("bannerId");
        avQuery.include("owner");
        avQueryBanner.findInBackground(new FindCallback<AVObject>() {
            @Override
            public void done(List<AVObject> list, AVException e) {

                for(AVObject avObject:list){
                    images.add(avObject.getString("imageUrl"));
                }
                binding.banner.setPages(images, new MZHolderCreator<BannerViewHolder>() {
                    @Override
                    public BannerViewHolder createViewHolder() {
                        return new BannerViewHolder();
                    }
                });

            }
        });




    }

    @Override
    public void onResume() {
        super.onResume();
        binding.banner.start();
    }

    @Override
    public void onPause() {
        super.onPause();
        binding.banner.pause();
    }

    @Override
    public void onListLoad() {
        binding.swipeRefresh.setLoading(false);
    }

    @Override
    public void onRefresh() {
        initData();
    }

    public static class BannerViewHolder implements MZViewHolder<String> {
        private ImageView mImageView;

        @Override
        public View createView(Context context) {
            // 返回页面布局
            View view = LayoutInflater.from(context).inflate(R.layout.banner_view,null);
            mImageView = (ImageView) view.findViewById(R.id.image);
            return view;
        }

        @Override
        public void onBind(Context context, int position, String data) {
            // 数据绑定
            Glide.with(context).load(data).into(mImageView);
        }
    }
}
