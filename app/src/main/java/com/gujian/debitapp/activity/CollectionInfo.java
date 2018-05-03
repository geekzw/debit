package com.gujian.debitapp.activity;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.bigkoo.pickerview.builder.OptionsPickerBuilder;
import com.bigkoo.pickerview.listener.CustomListener;
import com.bigkoo.pickerview.listener.OnOptionsSelectListener;
import com.bigkoo.pickerview.view.OptionsPickerView;
import com.gujian.debitapp.R;
import com.gujian.debitapp.base.HeaderActivity;
import com.gujian.debitapp.databinding.ActivityCollectionInfoBinding;
import com.gujian.debitapp.databinding.ActivityKeFuBinding;
import com.gujian.debitapp.utils.Constant;
import com.gujian.debitapp.view.ItemView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CollectionInfo extends HeaderActivity<ActivityCollectionInfoBinding> {

    private ActivityCollectionInfoBinding binding;
    private OptionsPickerView pvCustomOptions;
    private ItemView[] itemViews = new ItemView[14];
    private String[] results = new String[14];
    private TextView titleText;
    private ProgressDialog dialog;
    @SuppressLint("HandlerLeak")
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            dialog.dismiss();
            Toast.makeText(CollectionInfo.this,"评估已提交，请注意接听电话反馈",Toast.LENGTH_LONG).show();
            finish();
        }
    };

    private Map<Integer,List<String>> dataMap = new HashMap<>();


    private int index = 0;

    @Override
    public int getContentResId() {
        return R.layout.activity_collection_info;
    }

    @Override
    protected void afterViewCreated(Bundle savedInstanceState) {
        super.afterViewCreated(savedInstanceState);
        binding = getContentBinding();
        initDate();
        initHeader("资产评估");
        initCustomOptionPicker();
        initLinstener();

    }

    private void initDate() {
        dataMap.put(0,Constant.DKYT);
        dataMap.put(1,Constant.DKJE);
        dataMap.put(2,Constant.DKSJ);
        dataMap.put(3,Constant.ZYSF);
        dataMap.put(4,Constant.XYKED);
        dataMap.put(5,Constant.MXFC);
        dataMap.put(6,Constant.MXCC);
        dataMap.put(7,Constant.XXJL);
        dataMap.put(8,Constant.WHCD);
        dataMap.put(9,Constant.YSR);
        dataMap.put(10,Constant.SRXS);
        dataMap.put(11,Constant.BDSB);
        dataMap.put(12,Constant.BDGJJ);
        dataMap.put(13,Constant.GRZJ);
        itemViews[0] = binding.DKYT;
        itemViews[1] = binding.DKJE;
        itemViews[2] = binding.DKSJ;
        itemViews[3] = binding.ZYSF;
        itemViews[4] = binding.XYKED;
        itemViews[5] = binding.MXFC;
        itemViews[6] = binding.MXCC;
        itemViews[7] = binding.XXJL;
        itemViews[8] = binding.WHCD;
        itemViews[9] = binding.YSR;
        itemViews[10] = binding.SRXS;
        itemViews[11] = binding.BDSB;
        itemViews[12] = binding.BDGJJ;
        itemViews[13] = binding.GRZJ;
    }

    private void initCustomOptionPicker() {//条件选择器初始化，自定义布局
        /**
         * @description
         *
         * 注意事项：
         * 自定义布局中，id为 optionspicker 或者 timepicker 的布局以及其子控件必须要有，否则会报空指针。
         * 具体可参考demo 里面的两个自定义layout布局。
         */
        pvCustomOptions = new OptionsPickerBuilder(this, (options1,option2,options3,v)-> {
            itemViews[index].setContent(dataMap.get(index).get(options1));
            results[index] = dataMap.get(index).get(options1);
        })
                .setLayoutRes(R.layout.pickerview_custom_options, v-> {
                        titleText = v.findViewById(R.id.title);
                        v.findViewById(R.id.tv_finish).setOnClickListener(v1-> {
                            pvCustomOptions.returnData();
                            pvCustomOptions.dismiss();
                        });
                        v.findViewById(R.id.iv_cancel).setOnClickListener(v1->{
                            pvCustomOptions.dismiss();
                        });
                })
                .isDialog(true)
                .setTitleText(Constant.DKYT_N)
                .build();

//        pvCustomOptions.setPicker(cardItem);//添加数据


    }

    private void initLinstener() {
        binding.DKYT.setItemClick(v->{
            index = 0;
            pvCustomOptions.setPicker(Constant.DKYT);
            titleText.setText(Constant.DKYT_N);
            pvCustomOptions.show();

        });
        binding.DKJE.setItemClick(v->{
            index = 1;
            pvCustomOptions.setPicker(Constant.DKJE);
            titleText.setText(Constant.DKJE_N);
            pvCustomOptions.show();
        });
        binding.DKSJ.setItemClick(v->{
            index = 2;
            pvCustomOptions.setPicker(Constant.DKSJ);
            titleText.setText(Constant.DKSJ_N);
            pvCustomOptions.show();
        });
        binding.ZYSF.setItemClick(v->{
            index = 3;
            pvCustomOptions.setPicker(Constant.ZYSF);
            titleText.setText(Constant.ZYSF_N);
            pvCustomOptions.show();
        });
        binding.XYKED.setItemClick(v->{
            index = 4;
            pvCustomOptions.setPicker(Constant.XYKED);
            titleText.setText(Constant.XYKED_N);
            pvCustomOptions.show();
        });
        binding.MXFC.setItemClick(v->{
            index = 5;
            pvCustomOptions.setPicker(Constant.MXFC);
            titleText.setText(Constant.MXFC_N);
            pvCustomOptions.show();
        });
        binding.MXCC.setItemClick(v->{
            index = 6;
            pvCustomOptions.setPicker(Constant.MXCC);
            titleText.setText(Constant.MXCC_N);
            pvCustomOptions.show();
        });
        binding.XXJL.setItemClick(v->{
            index = 7;
            pvCustomOptions.setPicker(Constant.XXJL);
            titleText.setText(Constant.XXJL_N);
            pvCustomOptions.show();
        });
        binding.WHCD.setItemClick(v->{
            index = 8;
            pvCustomOptions.setPicker(Constant.WHCD);
            titleText.setText(Constant.WHCD_N);
            pvCustomOptions.show();
        });
        binding.YSR.setItemClick(v->{
            index = 9;
            pvCustomOptions.setPicker(Constant.YSR);
            titleText.setText(Constant.YSR_N);
            pvCustomOptions.show();
        });
        binding.SRXS.setItemClick(v->{
            index = 10;
            pvCustomOptions.setPicker(Constant.SRXS);
            titleText.setText(Constant.SRXS_N);
            pvCustomOptions.show();
        });
        binding.BDSB.setItemClick(v->{
            index = 11;
            pvCustomOptions.setPicker(Constant.BDSB);
            titleText.setText(Constant.BDSB_N);
            pvCustomOptions.show();
        });

        binding.BDGJJ.setItemClick(v->{
            index = 12;
            pvCustomOptions.setPicker(Constant.BDGJJ);
            titleText.setText(Constant.BDGJJ_N);
            pvCustomOptions.show();
        });
        binding.GRZJ.setItemClick(v->{
            index = 13;
            pvCustomOptions.setPicker(Constant.GRZJ);
            titleText.setText(Constant.GRZJ_N);
            pvCustomOptions.show();
        });

        binding.apply.setOnClickListener(v->{
            dialog = new ProgressDialog(this);
            int count = 0;
            for(int i=0;i<results.length;i++){
                if(!TextUtils.isEmpty(results[i])){
                   count++;
                }
            }
            if(count <6){
                Toast.makeText(CollectionInfo.this,"信息不足，请填写完整",Toast.LENGTH_SHORT).show();
                return;
            }
            dialog.setTitle("数据提交中");
            dialog.show();
            handler.sendEmptyMessageDelayed(1,1000*2);
        });
    }
}
