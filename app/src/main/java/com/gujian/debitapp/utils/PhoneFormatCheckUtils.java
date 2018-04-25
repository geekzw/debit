package com.gujian.debitapp.utils;

import java.util.regex.Pattern;

/**
 * Created by gujian
 * Time is 2017/10/19
 * Email is gujian@maihaoche.com
 */

public class PhoneFormatCheckUtils {

    public static final String REGEX_MOBILE = "^[1][0-9][0-9]{9}$";

    /**
     * 校验手机号
     *
     * @param mobile
     * @return 校验通过返回true，否则返回false
     */
    public static boolean isMobile(String mobile) {
        if(mobile == null){
            return false;
        }
        return Pattern.matches(REGEX_MOBILE, mobile);
    }
}
