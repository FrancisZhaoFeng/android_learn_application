package com.meizu.service;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.IBinder;
import android.util.Log;

import com.meizu.appmemstart.R;
import com.meizu.common.Contants;
import com.meizu.dao.DBManager;
import com.meizu.domain.AppMemMapInfo;
import com.meizu.domain.PckInfo;
import com.meizu.reporte.HtmlOut;
import com.meizu.tools.GetMemInfo;
import com.meizu.tools.ShellUtils;

import java.util.ArrayList;
import java.util.List;

public class AppStartService extends Service {
    private String TAG = "AppStartService";
    private List<PckInfo> pckInfos;
    private PackageManager packageManager;
    private GetMemInfo getMemInfo;
    private DBManager dbManager;

    @Override
    public void onCreate() {
        // TODO Auto-generated method stub
        super.onCreate();

        this.notificationBar();
        getMemInfo = new GetMemInfo(this);
        packageManager = this.getPackageManager();
        dbManager = DBManager.getInstance(this);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        // TODO Auto-generated method stub
        pckInfos = intent.getParcelableArrayListExtra("mainPckInfos");
        if (pckInfos == null) {
            Log.e(TAG, "MainActivity传递的pckInfos是null的");
        } else {
            Log.i(TAG, "onStartCommand: "+Contants.USERHABITINFO.toString());
            new Thread(sendable).start();
        }
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        // TODO Auto-generated method stub
        super.onDestroy();
    }

    @Override
    public IBinder onBind(Intent arg0) {
        // TODO Auto-generated method stub
        return null;
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    @SuppressWarnings("deprecation")
    private void notificationBar() {
        NotificationManager mNotificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        Notification.Builder builder = new Notification.Builder(this)
                .setAutoCancel(true)
                .setContentTitle("AppMemStart通知....")
                .setSmallIcon(R.drawable.ic_menu_camera)
                .setWhen(System.currentTimeMillis())
                .setOngoing(true);
        Notification notify = builder.build();
        mNotificationManager.notify(1, notify);
    }


    Runnable sendable = new Runnable() {
        @Override
        public void run() {
            // TODO Auto-generated method stub
            List<AppMemMapInfo> appMemMapInfosReport = new ArrayList<>();
            for (PckInfo pckInfo : pckInfos) {
                Log.i(TAG, "正在测试包：" + pckInfo.getPackageName());
                int num = 1;
                try {
                    for (int i = 0; i < Contants.USERHABITINFO.getAppNum(); i++) {
                        startActivity(packageManager.getLaunchIntentForPackage(pckInfo.getPackageName()));
                        for (int j = 0; j < Contants.USERHABITINFO.getActivityNum(); j++) {
                            Log.i(TAG, "第" + (num++) + "次获取应用数据：" + pckInfo.getPackageName());
                            Thread.sleep(Contants.USERHABITINFO.getTimeNum() * 1000);
                            AppMemMapInfo appMemMapInfos = getMemInfo.getRunningAppProcessInfoByShell(pckInfo.getPackageName());
                            if (appMemMapInfos == null) {
                                Log.e(TAG, "包：" + pckInfo.getPackageName() + "，获取内存信息失败");
                            } else {
                                dbManager.insertAppMemInfo(appMemMapInfos);
                                appMemMapInfosReport.add(appMemMapInfos);
                            }
                        }
                        ShellUtils.execCommand("am force-stop " + pckInfo.getPackageName(), false);
                        Thread.sleep(3 * 1000);
                    }
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            HtmlOut htmlOut = new HtmlOut();
            htmlOut.creathtml(appMemMapInfosReport, Contants.HTML_PATH + Contants.HTML_NAME_CURRENT, Contants.USERHABITINFO.getMemData());
            htmlOut.openBrower(Contants.HTML_PATH + Contants.HTML_NAME_CURRENT, AppStartService.this);
            dbManager.selectAppMemInfoGetSize();
            dbManager.close("AppStartService");
            Log.i(TAG, "打开app，测试应用启动内存结束");
        }
    };
}