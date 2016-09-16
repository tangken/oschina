package com.hnyd.oschina.base;

import android.annotation.TargetApi;
import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Build;
import android.view.Gravity;
import android.widget.Toast;

/**
 * Created by tangk on 2016/9/13.
 */

@SuppressWarnings("InflateParams")
public class BaseApplication extends Application {
    private static String PREF_NAME = "creativelocker.pref";
    private static String LAST_REFRESH_TIME = "last_refresh_time.pref";
    static Context _context;
    static Resources _resources;
    private static String lastToast = "";


    @Override
    public void onCreate() {
        super.onCreate();
        _context = getApplicationContext();
        _resources = getResources();
    }

    public static void showToast(String message) {
        showToast(message, Toast.LENGTH_LONG, 0, Gravity.BOTTOM);
    }

    public static synchronized BaseApplication context() {
        return (BaseApplication) _context;
    }
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static SharedPreferences getPreferences() {
        SharedPreferences pre = context().getSharedPreferences(PREF_NAME,
                Context.MODE_MULTI_PROCESS);
        return pre;
    }
}
