package com.meizu.tools;

import android.app.ActivityManager;
import android.content.Context;

import com.meizu.common.Contants;
import com.meizu.domain.AppMemMapInfo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


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
        if (packageName.equals("com.android.providers.downloads.ui"))
            packageName = "android.process.media";
        String commend = "dumpsys meminfo " + packageName;
//        List<String> dumpsysMems = Shell.SH.run(commend);
        List<String> dumpsysMems = ShellUtils.execCommand(commend,false);
        for (int i = 0; i < Contants.dumpElement.length; i++) {
            String element = Contants.dumpElement[i];
            for (int j = 0; j < dumpsysMems.size(); j++) {
                String line = dumpsysMems.get(j);
                if (line.contains(element)&&!(element.equals("GL mtrack")&&line.contains("EGL"))) {
                    String ele = line.split(element)[1].trim();
                    if (ele.contains(" "))
                        ele = ele.split(" ")[0];
                    int curValue = Integer.valueOf(ele);
                    mapData.put(element, curValue);
                    if(element.equals("EGL mtrack")||element.equals("GL mtrack")){//根据耀华要求，tatol值需要减去EGL mtrack和GL mtrack的值
                        mapData.put("TOTAL",mapData.get("TOTAL")-curValue);
                    }
//                    Log.i(TAG, "getRunningAppProcessInfoByShell " + element + "：" + mapData.get(element));
                    break;
                }
            }
        }
        appMemMapinfo = new AppMemMapInfo(packageName, mapData);
        return appMemMapinfo;
    }
}
