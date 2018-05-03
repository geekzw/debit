package com.gujian.debitapp.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.databinding.DataBindingUtil;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;

import com.gujian.debitapp.R;
import com.gujian.debitapp.databinding.ItemViewBinding;

/**
 * Created with Android Studio
 * Auth gujian
 * Time is 2018/5/3
 * Email is gujian@maihaoche.com
 */
public class ItemView extends RelativeLayout {
    private ItemViewBinding binding;
    private ItemClick itemClick;
    public ItemView(Context context) {
        this(context,null);
    }

    public ItemView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public ItemView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context, attrs, defStyleAttr);
    }

    private void initView(Context context, AttributeSet attrs, int defStyleAttr) {
        View labelView = LayoutInflater.from(context).inflate(R.layout.item_view,this,false);
        binding = DataBindingUtil.bind(labelView);
        TypedArray attributes = context.obtainStyledAttributes(attrs, R.styleable.ItemView);
        String titleName = attributes.getString(R.styleable.ItemView_titleName);
        binding.name.setText(titleName);
        addView(labelView);
        binding.getRoot().setOnClickListener(v->{
            if (itemClick!=null){
                itemClick.click(v);
            }
        });
    }

    public void setContent(String text){
        if(binding!=null){
            binding.content.setText(text);
        }
    }

    public void setItemClick(ItemClick itemClick){
        this.itemClick = itemClick;
    }

    public interface ItemClick{
        void click(View view);
    }
}
