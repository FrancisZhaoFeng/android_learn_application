package com.meizu.components.service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;

import com.meizu.components.tools.Logger;

/**
 * Created by zhaoguofeng on 2016/12/21.
 */
public class MyService extends Service {

    //这里定义吧一个Binder类，用在onBind()有方法里，这样Activity那边可以获取到
    private MyBinder mBinder = new MyBinder();

    @Override
    public void onCreate() {
        super.onCreate();
        Logger.i("MyService onCreat");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Logger.i("MyService onStartCommand");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Logger.i("MyService onDestroy");
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Logger.i("MyService onBind");
        return mBinder;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Logger.i("MyService onUnbind");
        return super.onUnbind(intent);
    }

    public String getData(){
        return "data from service";
    }

    public class MyBinder extends Binder {
        public MyService getService() {
            return MyService.this;
        }
    }
}
