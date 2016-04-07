package com.meizu.service;

import android.app.Service;
import android.content.Intent;
import android.os.Environment;
import android.os.IBinder;
import android.util.Log;

import com.meizu.common.Constant;
import com.meizu.utils.ShellUtils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.Date;


public class LogcatService extends Service {

    Thread tt;
    String filename = "";
    Boolean logRun = true;
    Boolean proessRun = true;
    Boolean serviceRun = true;
    String pathStr = Environment.getExternalStorageDirectory().getPath();

    String[] runcommand = {"cat /proc/version", "cat /proc/cpuinfo", "cat /proc/meminfo", "cat /proc/last_kmsg", "cat /proc/reset_reason",
            "cat /data/anr/traces.txt", "cat /data/ril.log", "cat /data/ril_miss.log", "cat /data/ril_sn.log", "cat /cache/recovery/last_install",
            "cat /cache/recovery/last_log", "getprop", "ps", "logcat -v threadtime -d", "logcat -v threadtime -b radio -d",
            "logcat -v threadtime -b events -d", "dmesg", "dumpsys power", "dumpsys alarm", "dumpsys battery", "dumpsys batteryinfo",
            "dumpsys cpuinfo", "dumpsys meminfo", "dumpsys netpolicy", "dumpsys netstats --full --uid", "dumpsys SurfaceFlinger",
            "dumpsys wifi", "dumpsys activity broadcasts", "dumpsys batterystats", "ps -t", "cat /sys/devices/platform/soc-audio.0/reg_program",
            "cat /sys/fs/pstore/console-ramoops", "cat /sys/fs/pstore/dmesg-ramoops-0", "cat /sys/fs/pstore/dmesg-ramoops-1",
            "cat /sys/fs/pstore/ftrace-ramoops", "cat /sys/class/charger_class/charger_device/dump_reg", "ping -c 2 61.147.106.32", "ping -c 2 "};

    @Override
    public void onCreate() {
        super.onCreate();
        Log.i(Constant.TAG, "LogcatService onCreate()");
        ShellUtils.execCommand("logcat -c", false, true);
        tt = new Thread(stop);
        tt.start();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i(Constant.TAG, "LogcatService onStartCommand()");
        return super.onStartCommand(intent, flags, startId);
    }

    Runnable stop = new Runnable() {
        @Override
        public void run() {
            Log.i(Constant.TAG, "LogcatService Runnable()");
            Process mLogcatProc = null;
            BufferedReader reader = null;
            try {
                mLogcatProc = Runtime.getRuntime().exec("logcat -s ANRManager AndroidRuntime ActivityManager");
                reader = new BufferedReader(new InputStreamReader(mLogcatProc.getInputStream()));
                String line;
                while (proessRun) {
                    if ((line = reader.readLine()) == null)
                        continue;
                    if (line.contains(": Process: ")) {
                        Log.i(Constant.TAG, "process：" + line);
                        if (!line.contains("com.meizu.apptest") && !reader.readLine().contains("is package not installed")) {
                            String str = line.substring(line.indexOf(": Process: ") + 11);
                            str = str.substring(0, str.indexOf(", PID:"));
                            filename = "Crash_" + str + "_" + new SimpleDateFormat("yyyyMMddmmss").format(new Date());
                            CatchApplocationError();
                        }
                    } else if (line.contains(": ANR in ")) {
                        Log.i(Constant.TAG, "ANR in：" + line);
                        if (!line.contains("com.meizu.apptest")) {
                            String str = line.substring(line.indexOf(": ANR in ") + 9);
                            if (str.contains(" (")) {
                                str = str.substring(0, str.indexOf(" ("));
                            } else if (str.contains(", time")) {
                                str = str.substring(0, str.indexOf(", time"));
                            }
                            filename = "NotRespond_" + str + "_" + new SimpleDateFormat("yyyyMMddmmss").format(new Date());
                            CatchApplocationError();
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    if (reader != null)
                        reader.close();
                } catch (Exception e) {
                }
            }
        }
    };


    public void CatchApplocationError() {
        if (logRun) {
            logRun = false;
            sleep(500);
            logcat();
            logRun = true;
        }
    }

    private void logcat() {
        File file = new File(pathStr + "/AutoTest/image");
        if (!file.exists()) {
            file.mkdirs();
        }
        String filePath1 = "  -f " + pathStr + "/AutoTest/image/" + filename + ".txt";
        String filePath2 = "  >> " + pathStr + "/AutoTest/image/" + filename + ".txt";
        savefirst();
        String cmdstr = "";
        for (int i = 0; i < runcommand.length; i++) {
            if (runcommand[i].contains("logcat")) {
                savefile(runcommand[i]);
                cmdstr = runcommand[i] + filePath1;
                ShellUtils.execCommand(cmdstr, false, true);
            } else {
                savefile(runcommand[i]);
                cmdstr = runcommand[i] + filePath2;
                ShellUtils.execCommand(cmdstr, false, true);
            }
        }
    }

    private void savefirst() {
        BufferedWriter out = null;
        try {
            out = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream(pathStr + "/AutoTest/image/" + filename + ".txt", true)));
            out.write("***********************************************\r\n");
            out.write("\r\n");
            out.write("commands that this app will run :\r\n");
            for (int i = 0; i < runcommand.length; i++) {
                out.write(runcommand[i] + "\r\n");
            }
            out.write("\r\n");
            out.write("***********************************************\r\n");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (out != null)
                    out.close();
            } catch (Exception e) {
            }
        }
    }

    private void savefile(String runcommand) {
        BufferedWriter out = null;
        try {
            out = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream(pathStr + "/AutoTest/image/" + filename + ".txt", true)));
            out.write("\r\n");
            out.write("\r\n");
            out.write("\r\n");
            out.write("************************" + runcommand + "************************\r\n");
            out.write("\r\n");
            out.write("\r\n");
            out.write("\r\n");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (out != null)
                    out.close();
            } catch (Exception e) {
            }
        }
    }


    private final static Object mLock = new Object();

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


    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        serviceRun = false;
        proessRun = false;
    }

}
