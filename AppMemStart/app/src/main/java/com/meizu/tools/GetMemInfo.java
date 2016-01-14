package com.meizu.tools;

import android.app.ActivityManager;
import android.content.Context;

import com.meizu.common.Contants;
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

    public static AppMemMapInfo getRunningAppProcessInfoByShell(String packageName) {
        Map<String, Integer> mapData = new HashMap<>();
        AppMemMapInfo appMemMapinfo;
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
//                    Log.i(TAG, "getRunningAppProcessInfoByShell " + element + "：" + mapData.get(element));
                    break;
                }
            }
        }
        appMemMapinfo = new AppMemMapInfo(packageName, mapData);
        return appMemMapinfo;
    }
}
