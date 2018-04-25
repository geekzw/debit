package com.gujian.debitapp;

import android.app.Application;

import com.avos.avoscloud.AVAnalytics;
import com.avos.avoscloud.AVOSCloud;

/**
 * Created by gujian
 * Time is 2017/10/15
 * Email is gujian@maihaoche.com
 */

public class MyApp extends Application {

    public static String username;

    @Override
    public void onCreate() {
        super.onCreate();
        AVOSCloud.initialize(this,"QGSs41nGgfDofETOfRgAKdSj-gzGzoHsz", "fmavP4Ny83CAmboSlDCWpQl3");
        AVOSCloud.setDebugLogEnabled(true);
        AVAnalytics.enableCrashReport(this, true);
    }

    public static String getUsername() {
        return username;
    }

    public static void setUsername(String username) {
        MyApp.username = username;
    }
}
