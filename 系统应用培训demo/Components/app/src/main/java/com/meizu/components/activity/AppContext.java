package com.meizu.components.activity;


import android.app.Application;

import com.meizu.components.tools.Logger;

/**
 * Created by zhaoguofeng on 2016/6/22.
 */
public class AppContext  extends Application {
    private static AppContext instance;

    public static AppContext getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        // TODO Auto-generated method stub
        super.onCreate();
        instance = this;
        Logger.init("components");
//        Logger.i("AppContext create");
    }
}
