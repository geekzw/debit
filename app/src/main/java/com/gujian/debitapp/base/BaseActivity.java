package com.gujian.debitapp.base;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.gujian.debitapp.R;

public class BaseActivity<T extends ViewDataBinding> extends AppCompatActivity {

    protected final String TAG = BaseActivity.this.getClass().getSimpleName();

    private ViewDataBinding binding;

    protected int getLayoutResId() {
        return 0;
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        int layoutResId = getLayoutResId();
        if (layoutResId > 0) {
            binding = DataBindingUtil.setContentView(this, getLayoutResId());
        }
        afterCreate(savedInstanceState);

    }

    protected void afterCreate(Bundle savedInstanceState) {

    }

    protected void reLoad(){}

    /**
     * 获取布局binding
     *
     * @return
     */
    protected T getLayoutBinding() {
        if (binding == null) {
            throw new NullPointerException(TAG + ":该页面未设置正确的布局资源id：" + getLayoutResId());
        }
        return (T) binding;
    }
}
