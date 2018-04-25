package com.gujian.debitapp.base;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.Nullable;
import android.os.Bundle;
import android.view.View;

import com.gujian.debitapp.R;
import com.gujian.debitapp.databinding.ActivityHeaderBinding;

public abstract class HeaderActivity <T extends ViewDataBinding> extends BaseActivity<ViewDataBinding> {

    private ViewDataBinding contentBinding;

    @Override
    final protected int getLayoutResId() {
        return R.layout.activity_header;
    }

    @Override
    final protected void afterCreate(@Nullable Bundle savedInstanceState) {
        super.afterCreate(savedInstanceState);
        contentBinding = DataBindingUtil.inflate(getLayoutInflater(), getContentResId(), null, false);
        getLayoutBinding().content.addView(contentBinding.getRoot());
        getLayoutBinding().leftBack.setOnClickListener(v -> onBackPressed());
        afterViewCreated(savedInstanceState);
    }

    public abstract int getContentResId();


    protected void afterViewCreated(Bundle savedInstanceState) {

    }

    /**
     * 返回页面内容
     *
     * @return
     */
    protected T getContentBinding() {
        return (T) contentBinding;
    }

    /**
     * 该方法不允许被重写。
     */
    @Override
    final protected ActivityHeaderBinding getLayoutBinding() {
        return (ActivityHeaderBinding) super.getLayoutBinding();
    }



    protected void hiddenHeader() {
        getLayoutBinding().titleArea.setVisibility(View.GONE);
    }
    public void initHeader(String title) {
        initTitleWithClick(title, 0, null);
    }

    public void initTitleWithClick(String title, int titleIconResId, View.OnClickListener onTitleClick) {
        getLayoutBinding().titleText.setText(title);
        if (onTitleClick != null) {
            getLayoutBinding().title.setOnClickListener(onTitleClick);
        }
    }

    protected void initHeader(String title, String rightText, View.OnClickListener listener) {
        getLayoutBinding().titleText.setText(title);
        getLayoutBinding().rightText.setText(rightText);
        getLayoutBinding().rightText.setOnClickListener(listener);
    }

    protected void hiddenLeftArrow() {
        getLayoutBinding().leftBack.setVisibility(View.GONE);
    }

    protected void hiddenRightText() {
        getLayoutBinding().rightText.setVisibility(View.GONE);
    }

    protected void setRightText(String rightText) {
        getLayoutBinding().rightText.setText(rightText);
    }

    protected void setRightText(String rightText, View.OnClickListener listener) {
        getLayoutBinding().rightText.setText(rightText);
        getLayoutBinding().rightText.setOnClickListener(listener);
    }

    protected void showContent(){
        getLayoutBinding().progress.getRoot().setVisibility(View.GONE);
        getLayoutBinding().content.setVisibility(View.VISIBLE);
        getLayoutBinding().empty.getRoot().setVisibility(View.GONE);
    }

    protected void showProgress(){
        getLayoutBinding().progress.getRoot().setVisibility(View.VISIBLE);
        getLayoutBinding().content.setVisibility(View.GONE);
        getLayoutBinding().empty.getRoot().setVisibility(View.GONE);
    }

    protected void showEmpty(){
        getLayoutBinding().progress.getRoot().setVisibility(View.GONE);
        getLayoutBinding().content.setVisibility(View.GONE);
        getLayoutBinding().empty.getRoot().setVisibility(View.VISIBLE);
    }

    protected void showProgressWithContent(){
        getLayoutBinding().progress.getRoot().setVisibility(View.VISIBLE);
        getLayoutBinding().content.setVisibility(View.VISIBLE);
    }

}
