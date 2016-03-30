package com.meizu.service;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.PowerManager;
import android.os.RemoteException;
import android.util.Log;

import com.meizu.apptest.R;
import com.meizu.beans.ApkTestInfoBean;
import com.meizu.beans.UserHabitBean;
import com.meizu.common.Constant;
import com.meizu.meizuuser.MeizuApi;
import com.meizu.report.HtmlOut;
import com.meizu.utils.ApkHandleUtil;
import com.meizu.utils.DBUtil;
import com.meizu.utils.FileUtil;
import com.meizu.utils.ShellUtils;

import org.litepal.LitePalApplication;
import org.litepal.crud.DataSupport;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by zhaoguofeng on 2016/3/17.
 */
public class TestService extends Service {
    Context mContext;
    private PowerManager pm;
    private PowerManager.WakeLock wl;

    private static MeizuApi meizuUser;
    private ServiceConnection conn = new ServiceConnection() {
        @Override
        synchronized public void onServiceConnected(ComponentName name, IBinder service) {
            meizuUser = MeizuApi.Stub.asInterface(service);
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            meizuUser = null;
        }
    };

    @Override
    public void onCreate() {
        super.onCreate();
        Log.e(Constant.TAG, "this is service onCreat");
        //动态注册屏幕状态改变监听器，注意：不能进行静态注册
        registerReceiver(screenOffOn, new IntentFilter(Intent.ACTION_SCREEN_ON));
        registerReceiver(screenOffOn, new IntentFilter(Intent.ACTION_SCREEN_OFF));
        pm = (PowerManager) getSystemService(Context.POWER_SERVICE);
        wl = pm.newWakeLock(PowerManager.ACQUIRE_CAUSES_WAKEUP | PowerManager.SCREEN_DIM_WAKE_LOCK, "bright");
        //初始化数据库和通知栏显示（前台服务）
        LitePalApplication.initialize(this);
        this.notificationBar();
    }

    //adb 发送命令：am startservice -n com.meizu.apptest/com.meizu.service.TestService --es path apptest --ei count 5 --ez isMonkey true --ei mTime 30
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.e(Constant.TAG, "this is service onStartCommand");
        setData(intent);//保存intent传过来的值
        init();//保存context；安装应用：meizuuser，静音工具，google框架；aidl绑定meizuuser
        apkThread.start();
//        testThread.start();
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        Log.e(Constant.TAG, "this is service onDestroy");
        destroy();
        super.onDestroy();
    }

    private void notificationBar() {
        NotificationManager mNotificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        Notification.Builder builder = new Notification.Builder(this).setAutoCancel(true).setContentTitle("3wApptest").setContentText("点点点，没效果啦...")
                .setSmallIcon(R.drawable.side_nav_bar).setWhen(System.currentTimeMillis()).setOngoing(true);
        Notification notify = builder.build();
        mNotificationManager.notify(1, notify);
    }

    private void setData(Intent intent) {
        //====================================//保存用户记录
        String path = intent.getStringExtra("path");
        path = path == null ? "apptest" : path;
        int count = intent.getIntExtra("count", 5);
        Boolean isMonkey = intent.getBooleanExtra("isMonkey", false);
        int mTime = intent.getIntExtra("mTime", 0);
        UserHabitBean userHabitBean = new UserHabitBean(count, mTime, isMonkey, Constant.sdcard + "/" + path + "/");
        userHabitBean.save();
    }

    private void init() {
        mContext = this;
        ApkHandleUtil.installApk(mContext);
        Intent aidlIntent = new Intent("com.meizu.meizuuser.MeizuApi").setPackage("com.meizu.meizuuser");
        bindService(aidlIntent, conn, BIND_AUTO_CREATE);
    }

    private void initialize() {
        //初始化变量：一批list，安装和卸载成功变量
        Constant.curTestApks = new ArrayList<>();
        Constant.installFinish = true;
        Constant.uninstallFinish = true;
        //新建文件夹：openFailLog，installFailLog
        for (int i = 0; i < Constant.failLog.length; i++) {
            String logPath = Constant.autotestPath + "/image/" + Constant.failLog[i];
            File file = new File(logPath);
            if (!file.exists()) {
                FileUtil.mkDirs(logPath);
            }
        }
        //等待meizuUser连接成功
        waitForMeizuAPI();
        //启动google安装器（并点击安装）；启动静音工具；
        ShellUtils.execCommand("am start -n com.howie.gserverinstall/com.howie.gserverinstall.ui.MainActivity", false);
        ShellUtils.execCommand("am startservice com.jacky.permanent/com.jacky.permanent.MyService", false);
        try {
            meizuUser.touchIdByIndex("com.howie.gserverinstall:id/btnInstall", 1, true, true, 5 * 1000);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        ShellUtils.execCommand("input keyevent 3", false);
    }

    BroadcastReceiver screenOffOn = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            // TODO Auto-generated method stub
            Log.e(Constant.TAG, "MyReceiver");
            if (intent.getAction().equals(Intent.ACTION_SCREEN_ON)) {
                Log.e(Constant.TAG, "Screen ON");
            } else if (intent.getAction().equals(Intent.ACTION_SCREEN_OFF)) {
                Log.e(Constant.TAG, "Screen OFF");
                wl.acquire();
                wl.release();
                ShellUtils.execCommand("input swipe 500 1300 500 100", false);
            }

        }
    };

    private synchronized void waitForMeizuAPI() {
        while (true) {
            if (meizuUser == null) {
                try {
                    apkThread.sleep(100);
                    Log.e(Constant.TAG, "meizuUser == null");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                break;
            }
        }
    }

    private void destroy() {
        //aidl解绑，关闭静音服务和本服务
        unbindService(conn);
        ShellUtils.execCommand("am force-stop com.jacky.permanent", false);
        ShellUtils.execCommand("am force-stop com.meizu.apptest", false);
    }

    /*
    等待安装和卸载应用完成，保证线性运行
     */
    private void waitIOFinish(String info) {
        while (!Constant.installFinish || !Constant.uninstallFinish) { //安装完一个才能安装下一个
            try {
                Thread.sleep(2 * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Log.e(Constant.TAG, "while " + info + " apk ===>installFinish:" + !Constant.installFinish + ",uninstallFinish:" + !Constant.uninstallFinish);//防止在循环中死掉，不知道原因
        }
    }

    Thread testThread = new Thread(new Runnable() {
        @Override
        public void run() {
            int i = 0;
            while (i < 100) {
                try {
                    testThread.sleep(2 * 1000);
                    Log.e(Constant.TAG, "testThread：" + (i++));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    });

    Thread apkThread = new Thread(new Runnable() {
        @Override
        public void run() {
            initialize();
            Constant.userHabitBean = DataSupport.findLast(UserHabitBean.class);//获取用户最新习惯数据
            FileUtil.getFileListAndInsert(Constant.userHabitBean.getFilePath(), mContext);//遍历 apk文件路径，并且读取apk信息和保存到数据库，花时间比较长
            List<ApkTestInfoBean> apkTestInfoBeanList = DBUtil.checkDBByStatus(Constant.status[4]);//将数据库中noTest的status过滤出来进行测试
            Collections.sort(apkTestInfoBeanList);//排序
            Log.e(Constant.TAG, "需要测试的apk个数：" + apkTestInfoBeanList.size() + "，" + Constant.userHabitBean.toString());
            //核心代码段
            int index = 0;
            while (apkTestInfoBeanList.size() > index * Constant.userHabitBean.getCount()) {
                //根据count值来执行一批的测试数量
                ShellUtils.execCommand("input keyevent 3", false);//回到桌面
                List<ApkTestInfoBean> apkCounts = apkTestInfoBeanList.subList(index * Constant.userHabitBean.getCount(), apkTestInfoBeanList.size() > (index + 1) * Constant.userHabitBean.getCount() ? (index + 1) * Constant.userHabitBean.getCount() : apkTestInfoBeanList.size());
                for (ApkTestInfoBean apkCount : apkCounts) {
                    waitIOFinish("install");
                    Constant.curTestApk = apkCount;//全局，便于反射类中访问
                    Constant.installFinish = false; //安装完一个才能安装下一个，会在反射类中修改状态
                    ApkHandleUtil.installApk(Constant.curTestApk, mContext);//安装apk，并且修改status状态
                    Constant.curTestApks.add(Constant.curTestApk);//保存当前安装的apk，测试和卸载时使用
                }
                for (ApkTestInfoBean apkCount : Constant.curTestApks) {
                    waitIOFinish("uninstall");
                    if (!apkCount.getStatus().equals(Constant.status[0])) {
                        Constant.curTestApk = apkCount;
                        Constant.uninstallFinish = false;
                        ApkHandleUtil.testApk(Constant.curTestApk, mContext);//测试apk，包括：通过activity打开apk，进行monkey
                        ApkHandleUtil.uninstallApk(Constant.curTestApk, mContext);//卸载apk，反射类中没有改变status状态（即：忽略卸载 是否成功）
                    }
                }
                index++;
                Constant.curTestApks.clear();
            }
            waitIOFinish("over");
            Log.e(Constant.TAG, "测试结束......");
            //打开报告
            HtmlOut htmlOut = new HtmlOut();
            htmlOut.creathtml();
            htmlOut.openBrower(Constant.autotestPath + Constant.reportName, mContext);
            stopSelf();
        }
    });

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

}
