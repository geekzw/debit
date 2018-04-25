package com.gujian.debitapp.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.avos.avoscloud.AVObject;
import com.bumptech.glide.Glide;
import com.gujian.debitapp.R;
import com.gujian.debitapp.activity.ListDetaileActivity;
import com.gujian.debitapp.databinding.HomeItemBinding;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gujian
 * Time is 2017/10/15
 * Email is gujian@maihaoche.com
 */

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.MyHolder> {

    private Context context;

    private List<AVObject> mList;

    public HomeAdapter(Context context) {
        this.context = context;
        mList = new ArrayList<>();
    }

    public void setmList(List<AVObject> mList) {
        this.mList = mList;
        notifyDataSetChanged();
    }

    public void add(List<AVObject> list){
        mList.addAll(list);
        notifyItemChanged(mList.size()-list.size(),mList.size());
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyHolder(DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.home_item,parent,false));

    }

    @Override
    public void onBindViewHolder(MyHolder holder, int position) {
        AVObject avObject = mList.get(position);
        Glide.with(context).load(avObject.getString("imageIcon")).into(holder.binding.icon);
        holder.binding.name.setText(avObject.getString("companyName"));
        String decs = "简介:"+avObject.getString("companyDetail");
        holder.binding.decs.setText(decs);
        String count = avObject.getInt("peopleNum")+"人已放款";
        SpannableString textSpanned1 = new SpannableString(count);
        textSpanned1.setSpan(new ForegroundColorSpan(Color.RED),
                0, count.length()-4, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        holder.binding.count.setText(textSpanned1);

        holder.binding.getRoot().setOnClickListener(v->{
            context.startActivity(ListDetaileActivity.getInstence(context,avObject));
        });
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public static class MyHolder extends RecyclerView.ViewHolder{

        public HomeItemBinding binding;

        public MyHolder(HomeItemBinding binding) {

            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
