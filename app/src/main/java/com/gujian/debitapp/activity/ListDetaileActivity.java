package com.gujian.debitapp.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;

import com.avos.avoscloud.AVObject;
import com.bumptech.glide.Glide;
import com.gujian.debitapp.MyApp;
import com.gujian.debitapp.R;
import com.gujian.debitapp.base.HeaderActivity;
import com.gujian.debitapp.databinding.ActivityListDetaileBinding;

import java.math.BigDecimal;
import java.util.List;

public class ListDetaileActivity extends HeaderActivity<ActivityListDetaileBinding> {

    private static final String AVOBJECT = "avobject";

    private AVObject avObject;

    private ActivityListDetaileBinding binding;



    @Override
    public int getContentResId() {
        return R.layout.activity_list_detaile;
    }


    public static Intent getInstence(Context context, AVObject avObject){
        Intent intent = new Intent(context,ListDetaileActivity.class);
        intent.putExtra(AVOBJECT,avObject);
        return intent;

    }

    @Override
    protected void afterViewCreated(Bundle savedInstanceState) {
        binding = getContentBinding();
        avObject = (AVObject) getIntent().getParcelableExtra(AVOBJECT);
        initView();
    }

    private void initView() {

        initHeader(avObject.getString("companyName"));
        Glide.with(this).load(avObject.getString("imageIcon")).into(binding.icon);
        binding.name.setText(avObject.getString("companyName"));
        String count = avObject.getInt("peopleNum")+"人已放款";
        int showBtn = avObject.getInt("showButton");
        SpannableString textSpanned1 = new SpannableString(count);
        textSpanned1.setSpan(new ForegroundColorSpan(Color.RED),
                0, count.length()-4, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        binding.count.setText(textSpanned1);
        binding.slogan.setText(avObject.getString("companyDetail"));


        String lable1Left = "借款金额(";
        int minMoney = avObject.getInt("minMoney");
        int maxMoney = avObject.getInt("maxMoney");
        lable1Left+=getFloat(minMoney)+"-"+getFloat(maxMoney)+")万";
        binding.lable1Left.setText(lable1Left);
        binding.lable1Right.setText(minMoney+"");

        List<Integer> list = avObject.getList("amortizationNumArray");
        String lable2Left = "分期期限"+"("+list.get(0)+"-"+list.get(list.size()-1)+")月";
        binding.lable2Left.setText(lable2Left);
        binding.lable2Right.setText(1+"");

        double monthyRates = avObject.getDouble("monthyRate")/100;
        String monthyRate = monthyRates+"0%";
        binding.lable3Text2.setText(monthyRate);
        binding.lable3Text3.setText(avObject.getString("fastestTime"));


        double monthlyRepayment = minMoney * monthyRates * Math.pow((1 + monthyRates), 1) / (Math.pow((1 + monthyRates), 1) - 1);
        BigDecimal bd  =   new  BigDecimal((double)monthlyRepayment);
        bd   =  bd.setScale(2,4);
        binding.lable3Text1.setText(bd.floatValue()+"");

        binding.zige.setText(avObject.getString("qualification"));

        binding.cailiao.setText(avObject.getString("needdata"));

        binding.content.setText(avObject.getString("companyIntroduce"));
        if(showBtn == 1){
            binding.apply.setText("申请贷款");
        }else{
            binding.apply.setText("申请评估");
        }
        binding.apply.setOnClickListener(v->{
            if(showBtn == 1){

                startActivity(WebViewActivity.getIntence(this,avObject.getString("redirectUrl")));
            }else{
                if(TextUtils.isEmpty(MyApp.getUsername())){
                    startActivity(new Intent(this,LoginActivity.class));
                }else{

                    startActivity(new Intent(this,CollectionInfo.class));
                }
            }

        });





    }

    private float getFloat(int index){
        int scale = 2;
        double minM = (index*1.0 /10000);
        BigDecimal bd  =   new  BigDecimal((double)minM);
        bd   =  bd.setScale(scale,4);
        return bd.floatValue();
    }


}
