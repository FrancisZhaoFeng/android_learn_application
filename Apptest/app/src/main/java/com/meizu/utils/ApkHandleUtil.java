package com.meizu.utils;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.IPackageDeleteObserver;
import android.content.pm.IPackageInstallObserver;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.util.Log;

import com.meizu.beans.ApkTestInfoBean;
import com.meizu.common.Constant;
import com.meizu.service.MonkeyTestService;

import java.io.File;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhaoguofeng on 2016/3/17.
 */
public class ApkHandleUtil {
    final static Object mLock = new Object();

    public static void installApk(ApkTestInfoBean apkTestInfoBean, Context context) {
        Log.e(Constant.TAG, "installApk:" + apkTestInfoBean.toString());
        if (apkTestInfoBean.getPackageName().contains("com.meizu.media.")) {//系统应用安装失败，且导致程序假死
            apkTestInfoBean.setStatus(Constant.status[0]);
            Constant.installFinish = true;
            DBUtil.saveStatus(Constant.curTestApk);//数据库中保存安装状态
            return;
        }
        Uri packageUri = getPackageUri(Constant.userHabitBean.getFilePath() + apkTestInfoBean.getFileName());
        int installFlags = 0;
        try {
            PackageInfo pi = context.getPackageManager().getPackageInfo(apkTestInfoBean.getPackageName(), PackageManager.GET_UNINSTALLED_PACKAGES);
            if (pi != null) {
                // 表示安装时以更新方式安装，即app不存在时安装，否则进行卸载再安装
                // 导致问题：低版本apk不能安装时会导致程序一直在等待apk安装成功，导致程序死掉
                installFlags |= 0x00000002;
            }
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        MyPakcageInstallObserver installObserver = new MyPakcageInstallObserver();

        try {
            Class clazz = context.getClassLoader().loadClass("android.content.pm.PackageManager");
            Method method = clazz.getDeclaredMethod("installPackage", Uri.class, IPackageInstallObserver.class, int.class, String.class);
            method.invoke(context.getPackageManager(), packageUri, installObserver, installFlags, apkTestInfoBean.getPackageName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void testApk(ApkTestInfoBean apkTestInfoBean, Context context) {
        Log.e(Constant.TAG, "testApk:" + apkTestInfoBean.getFileName());
        PackageManager pm = context.getPackageManager();
        Intent apkIntent = pm.getLaunchIntentForPackage(apkTestInfoBean.getPackageName());
        boolean bOpen = false;
        if (apkIntent != null) {
            context.startActivity(apkIntent);
            sleep(1000);
            if (bOpen = hasOpen(apkTestInfoBean.getPackageName(), context)) {
                Log.e(Constant.TAG, "monkeyApk:" + apkTestInfoBean.getFileName());
                if (Constant.userHabitBean.getIsNeedMonkey()) {
                    Intent monkey = new Intent(context, MonkeyTestService.class);
                    monkey.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    monkey.putExtra("pkgName", apkTestInfoBean.getPackageName());
                    context.startService(monkey);
                    sleep(Constant.userHabitBean.getMonkeyRunTime() * 1000);
                    killedMonkeyTest();
                    context.stopService(monkey);
                    sleep(5 * 1000);  //
                }
                apkTestInfoBean.setStatus(Constant.status[3]);
            }
        }
        if (!bOpen) {
            apkTestInfoBean.setStatus(Constant.status[1]);
            FileUtil.grabIOLog(Constant.failLog[1], apkTestInfoBean);
        }
    }

    public static void uninstallApk(ApkTestInfoBean apkTestInfoBean, Context context) {
        Log.e(Constant.TAG, "uninstallApk:" + apkTestInfoBean.getFileName());
        PackageManager pm = context.getPackageManager();
        int installFlags = 0;
        try {
            PackageInfo pi = pm.getPackageInfo(apkTestInfoBean.getPackageName(), PackageManager.GET_UNINSTALLED_PACKAGES);
            if (pi != null) {
                installFlags |= 0x00000002;
            }
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        IPackageDeleteObserver deleteObserver = new MyPackageDeleteObserver();

        try {
            Class clazz = context.getClassLoader().loadClass("android.content.pm.PackageManager");
            Method method = clazz.getDeclaredMethod("deletePackage", String.class, IPackageDeleteObserver.class, int.class);
            method.invoke(pm, apkTestInfoBean.getPackageName(), deleteObserver, installFlags);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class MyPakcageInstallObserver extends IPackageInstallObserver.Stub {
        @Override
        public void packageInstalled(String packageName, int returnCode) {
            if (returnCode == 1) {
                Log.e(Constant.TAG, "MyPakcageInstallObserver：1，" + packageName);
            } else {
                Log.e(Constant.TAG, "MyPakcageInstallObserver：2，" + packageName);
                Constant.curTestApk.setStatus(Constant.status[0]);
                FileUtil.grabIOLog(Constant.failLog[0], Constant.curTestApk);
            }
            DBUtil.saveStatus(Constant.curTestApk);//数据库中保存安装状态
            Constant.installFinish = true;
        }
    }

    static class MyPackageDeleteObserver extends IPackageDeleteObserver.Stub {
        @Override
        public void packageDeleted(String packageName, int returnCode) {
            if (returnCode == 1) {
                Log.e(Constant.TAG, "MyPackageDeleteObserver：1，" + packageName);
            } else {
                Log.e(Constant.TAG, "MyPackageDeleteObserver：2，" + packageName);
            }
            DBUtil.saveStatus(Constant.curTestApk);//数据库中保存安装状态
            Constant.uninstallFinish = true;
        }
    }

    private static Uri getPackageUri(String apkFile) {
        File file = new File(apkFile);
        return Uri.fromFile(file);
    }

    public static boolean hasOpen(String pkgName, Context context) {
        List<String> pkgNameList = new ArrayList<>();
        pkgNameList.add(pkgName);
        if (pkgName.contains("lock") || pkgName.contains("input")) {
            pkgNameList.add("com.android.settings");
        }
        int bFirst = 0;
        boolean hasOpen = false;
        ActivityManager activityManager = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        // 判断1分钟内能否将应用打开（300*200 = 60 * 1000）
        for (int i = 0; i < 100; i++) {
            List<ActivityManager.RunningTaskInfo> rti = activityManager.getRunningTasks(1);
            String activityStr = rti.get(0).topActivity.getPackageName();
            for (String strPkgName : pkgNameList) {//输入法，锁 等apk 有些会跳到设置应用
                hasOpen = activityStr.contains(strPkgName);
                if (hasOpen)
                    break;
            }
            if (hasOpen) {
                if (bFirst < 5) {//判断activity打开是否15秒
                    Log.e(Constant.TAG, "包名：" + pkgName + ",界面：" + activityStr);
                    bFirst++;
                    sleep(1000);
                } else {
                    break;
                }
            }
            sleep(200);
        }
        return hasOpen;
    }

    public static void sleep(int times) {
        long startTimeMillis = System.currentTimeMillis();
        synchronized (mLock) {
            while (true) {
                if ((System.currentTimeMillis() - startTimeMillis) >= times) {
                    mLock.notify();
                    break;
                }
                try {
                    mLock.wait(times);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void killedMonkeyTest() {
        String a[] = ShellUtils.execCommand("ps", false, true).split("\n");
        for (int i = 0; i < a.length; i++) {
            if (a[i].contains("com.android.commands.monkey")) {
                int pid = Integer.valueOf(a[i].split(" ")[4]);
                ShellUtils.execCommand(" kill " + pid, false, true);
                Log.e(Constant.TAG, "kill monkey:" + pid);
                sleep(500);
                break;
            }
        }
    }

    public static boolean installApk(Context context) {
        File files[] = FileUtil.getAssetFile(context);
        String pName[] = {"com.meizu.meizuuser", "com.jacky.permanent", "com.howie.gserverinstall"};
        PackageManager pManager = context.getPackageManager();
        List<PackageInfo> appList = pManager.getInstalledPackages(0);
        int index = 0;
        for (File file : files) {
            boolean isinstall = false;
            for (int i = 0; i < appList.size(); i++) {
                PackageInfo pak = appList.get(i);
                String mPak = pak.packageName;
                if (mPak.contains(pName[index])) {
                    isinstall = true;
                    break;
                }
            }
            index++;
            if (!isinstall) {
                ShellUtils.execCommand("pm install " + file.getPath(), false);
                Log.e(Constant.TAG, "pm install " + file.getPath());
            }
        }
        return true;
    }
}
