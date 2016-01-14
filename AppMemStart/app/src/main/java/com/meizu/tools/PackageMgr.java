package com.meizu.tools;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.graphics.drawable.Drawable;
import android.util.Log;

import com.meizu.domain.PckInfo;

import java.util.List;

public class PackageMgr {
    private String Tag = "PackageMgr";
    private PackageManager packageManager;

    public PackageMgr(Context context) {
        // TODO Auto-generated constructor stub
        packageManager = context.getPackageManager();// 获取packagemanager
    }

    public void getPackageName(List<PckInfo> packageInfos) {
        List<PackageInfo> pInfos = packageManager.getInstalledPackages(0);// 获取所有已安装程序的包信息
        if (pInfos != null) {
            int num = 0;
            for (PackageInfo pInfo : pInfos) {
                String pName = pInfo.packageName;
                Intent intent = packageManager.getLaunchIntentForPackage(pName);
                if (intent != null && !pName.contains("com.meizu.appmemstart") && !pName.contains("com.meizu.flyme.laun")) {
                    try {
                        ApplicationInfo appInfo = packageManager.getApplicationInfo(pName, PackageManager.GET_UNINSTALLED_PACKAGES);
                        String destopName = (String) packageManager.getApplicationLabel(appInfo);
                        String versionName = pInfo.versionName;
                        Drawable icon = packageManager.getApplicationIcon(appInfo);
                        PckInfo pckInfo = new PckInfo(pName, destopName, versionName, icon, intent);
                        packageInfos.add(pckInfo);
//                        Log.i(Tag + num, pckInfo.toString());
                        num++;
                    } catch (NameNotFoundException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            }
            Log.i(Tag, "已安裝並且intent有效的包数：" + num);
        }
    }

    public boolean checkActivity(String packageName) {
        if (packageName == null || "".equals(packageName)) {
            return false;
        }
        try {
            packageManager.getApplicationInfo(packageName, PackageManager.GET_UNINSTALLED_PACKAGES);
            return true;
        } catch (NameNotFoundException e) {
            // TODO Auto-generated catch block
            return false;
        }

    }
}
