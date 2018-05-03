package com.gujian.debitapp.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created with Android Studio
 * Auth gujian
 * Time is 2018/5/3
 * Email is gujian@maihaoche.com
 */
public class Constant {

    public static final String DKYT_N = "贷款用途";

    public static final List<String> DKYT = new ArrayList<>(Arrays.asList(new String[]{
            "消费贷款",
            "结婚贷款",
            "购房贷款",
            "装修贷款",
            "购车贷款"
    }));

    public static final String DKJE_N = "贷款金额";

    public static final List<String> DKJE = new ArrayList<>(Arrays.asList(new String[]{
            "5w",
            "2w",
            "1w",
            "5k",
            "2k",
            "1k"
    }));

    public static final String DKSJ_N = "贷款时间";

    public static final List<String> DKSJ = new ArrayList<>(Arrays.asList(new String[]{
            "1个月",
            "2个月",
            "3个月",
            "4个月",
            "5个月",
            "6个月",
            "8个月",
            "10个月",
            "12个月",
            "16个月"
    }));

    public static final String ZYSF_N = "职业身份";

    public static final List<String> ZYSF = new ArrayList<>(Arrays.asList(new String[]{
            "上班族",
            "自由职业",
            "个体户"
    }));

    public static final String XYKED_N = "信用卡额度";

    public static final List<String> XYKED = new ArrayList<>(Arrays.asList(new String[]{
            "无",
            "3000元以下",
            "3000-10000元",
            "10000-30000元",
            "30000元以上"
    }));

    public static final String MXFC_N = "名下房产";

    public static final List<String> MXFC = new ArrayList<>(Arrays.asList(new String[]{
            "无房产",
            "有房产，不接受抵押",
            "有房产，可接受抵押"
    }));

    public static final String MXCC_N = "名下车产";

    public static final List<String> MXCC = new ArrayList<>(Arrays.asList(new String[]{
            "无车产",
            "无车产，准备购买",
            "有车产，不接受抵押",
            "有车产，接受抵押"
    }));

    public static final String XXJL_N = "信息记录";

    public static final List<String> XXJL = new ArrayList<>(Arrays.asList(new String[]{
            "无信用卡或者贷款",
            "一年内预期少于过三次或者90天以上",
            "一年内预期超过三次或者90天以上",
            "信用良好，无逾期"
    }));

    public static final String WHCD_N = "文化程度";

    public static final List<String> WHCD = new ArrayList<>(Arrays.asList(new String[]{
            "初中",
            "高中",
            "中专",
            "大专",
            "本科及以上"
    }));

    public static final String YSR_N = "月收入";

    public static final List<String> YSR = new ArrayList<>(Arrays.asList(new String[]{
            "2000以下",
            "2000-4000元",
            "4000-8000元",
            "8000以上"
    }));

    public static final String SRXS_N = "收入形式";

    public static final List<String> SRXS = new ArrayList<>(Arrays.asList(new String[]{
            "现金发放",
            "转涨工资",
            "银行代发"
    }));

    public static final String BDSB_N = "本地社保";

    public static final List<String> BDSB = new ArrayList<>(Arrays.asList(new String[]{
            "连续12个月以上",
            "连续6个月以上",
            "连续3个月以上",
            "无本地社保"
    }));

    public static final String BDGJJ_N = "本地公积金";

    public static final List<String> BDGJJ = new ArrayList<>(Arrays.asList(new String[]{
            "连续12个月以上",
            "连续6个月以上",
            "连续3个月以上",
            "无本地公积金"
    }));

    public static final String GRZJ_N = "个人证件";

    public static final List<String> GRZJ = new ArrayList<>(Arrays.asList(new String[]{
            "无",
            "学位证",
            "教师证",
            "军官证",
            "护士执业证书",
            "医师执业证书"
    }));

}
