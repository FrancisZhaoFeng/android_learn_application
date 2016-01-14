package com.meizu.tools;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Debug;
import android.util.Log;

import com.meizu.common.Contants;
import com.meizu.domain.AppMemInfo;
import com.meizu.domain.AppMemMapInfo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import eu.chainfire.libsuperuser.Shell;

public class GetMemInfo {
    private static String TAG = "GetMemInfo";
    private ActivityManager mActivityManager;

    public GetMemInfo(Context context) {
        // TODO Auto-generated constructor stub
        mActivityManager = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
    }

    // 获得系统进程信息 API21开始getRunningAppProcesses只返回应用本身的进程信息
    public AppMemInfo getRunningAppProcessInfo(String pName) {
        // ProcessInfo Model类 用来保存所有进程信息
        AppMemInfo appMeminfo = null;

        // 通过调用ActivityManager的getRunningAppProcesses()方法获得系统里所有正在运行的进程
        List<ActivityManager.RunningAppProcessInfo> appProcessList = mActivityManager.getRunningAppProcesses(); //API21开始getRunningAppProcesses只返回应用本身的进程信息
        for (ActivityManager.RunningAppProcessInfo appProcessInfo : appProcessList) {
            String processName = appProcessInfo.processName;
            Log.i(TAG, processName);
        }
        for (ActivityManager.RunningAppProcessInfo appProcessInfo : appProcessList) {
            String processName = appProcessInfo.processName;// 进程名，默认是包名或者由属性android：process=""指定
            Log.e(TAG, processName);
            if (pName.equals(processName)) {
                int pid = appProcessInfo.pid;// 进程ID号 uid:用户ID 类似于Linux的权限不同，ID也就不同 比如 root等
                int[] myMemoir = new int[]{pid};// 获得该进程占用的内存
                Debug.MemoryInfo[] memoryInfo = mActivityManager.getProcessMemoryInfo(myMemoir);// 此MemoryInfo位于android.os.Debug.MemoryInfo包中，用来统计进程的内存信息
                appMeminfo = new AppMemInfo(memoryInfo[0], pid, processName);
                Log.i(TAG, appMeminfo.toString());
                break;
            }
        }
        return appMeminfo;
    }

    public AppMemInfo getRunningAppProcessInfoBySuperUser(String packageName) {
        AppMemInfo appMeminfo = null;
        List<GetRunningApp.Process> processes = GetRunningApp.getRunningProcesses();
        for (GetRunningApp.Process process : processes) {
            String processName = process.getPackageName();
            if (packageName.equals(processName)) {
                int pid = process.pid;// 进程ID号 uid:用户ID 类似于Linux的权限不同，ID也就不同 比如 root等
                int[] myMemoir = new int[]{pid};// 获得该进程占用的内存
                Debug.MemoryInfo[] memoryInfo = mActivityManager.getProcessMemoryInfo(myMemoir);// 此MemoryInfo位于android.os.Debug.MemoryInfo包中，用来统计进程的内存信息
                appMeminfo = new AppMemInfo(memoryInfo[0], pid, processName);
//				Log.i(TAG, appMeminfo.toString());
                break;
            }
        }
        return appMeminfo;
    }

    public static AppMemMapInfo getRunningAppProcessInfoByShell(String packageName) {
        Map<String, Integer> mapData = new HashMap<>();
        AppMemMapInfo appMemMapinfo = null;
        String commend = "dumpsys meminfo " + packageName;
        List<String> dumpsysMems = Shell.SH.run(commend);
        for (int i = 0; i < Contants.dumpElement.length; i++) {
            String element = Contants.dumpElement[i];
            for (int j = 0; j < dumpsysMems.size(); j++) {
                String line = dumpsysMems.get(j);
                if (line.contains(element)) {
                    String ele = line.split(element)[1].trim();
                    if (ele.contains(" "))
                        ele = ele.split(" ")[0];
                    mapData.put(element, Integer.valueOf(ele));
                    Log.i(TAG, "getRunningAppProcessInfoByShell " + element + "：" + mapData.get(element));
                    break;
                }
            }
        }
        appMemMapinfo = new AppMemMapInfo(packageName, mapData);
        return appMemMapinfo;
    }
}
