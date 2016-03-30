package com.meizu.common;

import android.os.Environment;

import com.meizu.beans.ApkTestInfoBean;
import com.meizu.beans.UserHabitBean;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by zhaoguofeng on 2016/3/17.
 */
public class Constant {
    public static String TAG = "apptestlogcat";
    public static String autotestPath = Environment.getExternalStorageDirectory().toString() + "/AutoTest";
    public static String reportName = "/Report.html";
    public static String model = android.os.Build.DEVICE;
    public static String data = getTime();
    public static String version = android.os.Build.VERSION.INCREMENTAL;
    public static String sdcard = Environment.getExternalStorageDirectory().toString();
    public static UserHabitBean userHabitBean;
    public static List<ApkTestInfoBean> curTestApks = new ArrayList<>();
    public static ApkTestInfoBean curTestApk;
    public static boolean installFinish = true;
    public static boolean monkeyFinlish = true;
    public static boolean uninstallFinish = true;
    public static boolean stop = false;
    public static String status[] = {"installFail", "openFail", "analysisFail", "success", "noTest"};
    public static String failLog[] = {"installFailLog", "openFailLog"};
    public static String[] runcommand = {"cat /proc/version", "cat /proc/cpuinfo", "cat /proc/meminfo", "cat /proc/last_kmsg", "cat /proc/reset_reason", "cat /data/anr/traces.txt",
            "cat /data/ril.log", "cat /data/ril_miss.log", "cat /data/ril_sn.log", "cat /cache/recovery/last_install", "cat /cache/recovery/last_log", "getprop", "ps",
            "logcat -v threadtime -d", "logcat -v threadtime -b radio -d", "logcat -v threadtime -b events -d", "dmesg", "dumpsys power", "dumpsys alarm", "dumpsys battery",
            "dumpsys batteryinfo", "dumpsys cpuinfo", "dumpsys meminfo", "dumpsys netpolicy", "dumpsys netstats --full --uid", "dumpsys SurfaceFlinger", "dumpsys wifi",
            "dumpsys activity broadcasts", "dumpsys batterystats", "ps -t", "cat /sys/devices/platform/soc-audio.0/reg_program", "cat /sys/fs/pstore/console-ramoops",
            "cat /sys/fs/pstore/dmesg-ramoops-0", "cat /sys/fs/pstore/dmesg-ramoops-1", "cat /sys/fs/pstore/ftrace-ramoops",
            "cat /sys/class/charger_class/charger_device/dump_reg", "ping -c 2 61.147.106.32", "ping -c 2 "};

    public static String getTime() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss ");
        Date curDate = new Date(System.currentTimeMillis());// 获取当前时间
        String date = formatter.format(curDate);
        return date;
    }
}
