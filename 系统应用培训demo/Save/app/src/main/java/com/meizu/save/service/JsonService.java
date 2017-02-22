package com.meizu.save.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

import com.google.gson.Gson;
import com.meizu.save.bean.User;
import com.orhanobut.logger.Logger;

/**
 * Created by zhaoguofeng on 2017/1/10.
 */
public class JsonService extends Service {

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        User user = new Gson().fromJson(intent.getStringExtra("user"), User.class);
        Logger.i(user.toString());
        return super.onStartCommand(intent, flags, startId);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
