package com.meizu.save.activity;


import android.app.Application;

import com.orhanobut.logger.Logger;

import org.litepal.LitePal;


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
        Logger.init("save");
        LitePal.initialize(this); //初始化litepal
    }
}
