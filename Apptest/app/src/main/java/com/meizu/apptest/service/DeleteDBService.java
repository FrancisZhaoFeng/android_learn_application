package com.meizu.apptest.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

import com.meizu.apptest.beans.ApkTestInfoBean;
import com.meizu.apptest.common.Constant;

import org.litepal.LitePalApplication;
import org.litepal.crud.DataSupport;

/**
 * Created by zhaoguofeng on 2016/4/29.
 */
public class DeleteDBService extends Service{
    @Override
    public void onCreate() {
        //初始化数据库和通知栏显示（前台服务）
        LitePalApplication.initialize(this);
        super.onCreate();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
   // am startservice -n com.meizu.apptest/.service.DeleteDBService
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        DataSupport.deleteAll(ApkTestInfoBean.class);
        Log.e(Constant.TAG,"清除数据库内容 成功");
        Toast.makeText(this, "清除数据库内容 成功", Toast.LENGTH_SHORT).show();
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
