package com.gujian.debitapp.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.widget.Toast;

import com.gujian.debitapp.R;
import com.gujian.debitapp.base.HeaderActivity;
import com.gujian.debitapp.databinding.ActivityMainBinding;
import com.gujian.debitapp.entity.Constants;
import com.gujian.debitapp.fragment.AssessFragment;
import com.gujian.debitapp.fragment.ForumFragment;
import com.gujian.debitapp.fragment.HomeFragment;
import com.gujian.debitapp.fragment.MainFragment;

public class MainActivity extends HeaderActivity<ActivityMainBinding> {

    private static final int FRAGMENT_COUNT = 4;

    private ActivityMainBinding binding;

    private ForumFragment forumFragment;

    private int[] iconRes = {R.drawable.home_unselect, R.drawable.assess_unselect,R.drawable.forum_unselect,R.drawable.main_unselect};
    private int[] iconResSelected = {R.drawable.home_select, R.drawable.assess_select,R.drawable.forum_select,R.drawable.main_select};
    private String[] textRes = {"首页", "评估", "工具","我的"};

    @Override
    public int getContentResId() {
        return R.layout.activity_main;
    }

    @Override
    protected void afterViewCreated(Bundle savedInstanceState) {
        hiddenHeader();
        binding = getContentBinding();
        binding.navLayout.setIconRes(iconRes)//设置未选中图标
                .setIconResSelected(iconResSelected)//设置选中图标
                .setTextRes(textRes)//设置文字
                .setSelected(0);//设置选中的位置

        binding.navLayout.setOnItemSelectedListener(position-> {
            binding.viewpager.setCurrentItem(position);//选中后切换viwepager
        });

        binding.viewpager.setAdapter(new MyFragmentAdapter(getSupportFragmentManager()));
        binding.viewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                binding.navLayout.setSelected(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    class MyFragmentAdapter extends FragmentPagerAdapter{

        public MyFragmentAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {

            switch (position){
                case Constants.HOME:
                    return new HomeFragment();
                case Constants.ASSESS:
                    return new AssessFragment();
                case Constants.FORUM:
                    forumFragment = new ForumFragment();
                    return forumFragment;
                case Constants.MAIN:
                    return new MainFragment();
            }
            return null;
        }

        @Override
        public int getCount() {
            return FRAGMENT_COUNT;
        }
    }
}
