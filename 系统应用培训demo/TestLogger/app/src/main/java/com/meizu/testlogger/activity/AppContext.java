package com.meizu.testlogger.activity;


import android.app.Application;


/**
 * Created by zhaoguofeng on 2016/6/22.
 */
public class AppContext extends Application {
    private static AppContext instance;

    public static AppContext getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        // TODO Auto-generated method stub
        super.onCreate();
        instance = this;
//        Logger.init("testlogger");
//        Logger.i("AppContext create");
    }
}
