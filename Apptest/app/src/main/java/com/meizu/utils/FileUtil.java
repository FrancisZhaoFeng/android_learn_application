package com.meizu.utils;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.net.Uri;
import android.util.Log;

import com.meizu.beans.ApkTestInfoBean;
import com.meizu.common.Constant;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by zhaoguofeng on 2016/3/17.
 */
public class FileUtil {

    public static File[] getAssetFile(Context context) {
        File files[] = {null, null};
        AssetManager asset = context.getAssets();
        String sysVersion = android.os.Build.DISPLAY;
        mkDirs(Constant.autotestPath);

        String fileName[] = {"PermanentSerivice_prd.apk", "google.apk"};
        for (int i = 0; i < fileName.length; i++) {
            if (sysVersion.contains("eng") && fileName[i].contains("_prd")) {
                fileName[i] = fileName[i].replace("_prd", "_eng");
            }
            try {
                InputStream is = asset.open(fileName[i]);
                files[i] = new File(Constant.autotestPath, fileName[i]);
                files[i].createNewFile();
                FileOutputStream fOut = new FileOutputStream(files[i]);
                byte[] buffer = new byte[1024];
                int len;
                while ((len = is.read(buffer)) != -1) {
                    fOut.write(buffer, 0, len);
                }
                fOut.flush();
                is.close();
                fOut.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return files;
    }

    public static boolean deleteFile(String file) {
        File apk = new File(file);
        Log.i(Constant.TAG, "删除apk：" + file);
        if (apk.exists())
            return apk.delete();
        return true;
    }

    public static void mkDirs(String sdPath) {
        File file = new File(sdPath);
        if (!file.exists()) {
            file.mkdirs();
        }
    }

    public static void getFileListAndInsert(String apkPath, Context context) {
        File file = new File(apkPath);
        String fileNames[] = file.list();
        if (!file.exists() || fileNames == null) {//判断文件夹是否存在 和 文件夹中是否有apk
            Log.i(Constant.TAG, "!file.exists() || fileNames == null");
            return;
        }
        List<ApkTestInfoBean> apkTestInfoBeanList = new ArrayList<>();
        PackageManager pm = context.getPackageManager();
        for (String fileName : fileNames) {
            if (!fileName.contains(".apk")) continue;
            ApkTestInfoBean apkTestInfoBean = fileNameToApkBean(fileName);  //拆分apk名字
            PackageInfo info = pm.getPackageArchiveInfo(apkPath + fileName, PackageManager.GET_ACTIVITIES);
            if (info != null) {
                apkTestInfoBean.setStatus(Constant.status[4]);
                apkTestInfoBean.setPackageName(info.applicationInfo.packageName);
            } else {
                apkTestInfoBean.setStatus(Constant.status[2]);
            }
            apkTestInfoBeanList.add(apkTestInfoBean);
        }
        Collections.sort(apkTestInfoBeanList);
        for (ApkTestInfoBean apkTestInfoBean : apkTestInfoBeanList) {
            apkTestInfoBean.save();
        }
    }

    private static ApkTestInfoBean fileNameToApkBean(String name) {
        int sn = Integer.parseInt(name.substring(0, name.indexOf("_")));
        String packName = name.substring(name.indexOf("_") + 1, name.lastIndexOf("_v"));
        String apkVersion = name.substring(name.lastIndexOf("_v") + 1, name.length() - 4);
        return new ApkTestInfoBean(sn, packName, apkVersion, name);
    }

    public static void grabIOLog(String type, ApkTestInfoBean apkTestInfoBean) {
        String filePath1 = "  -f " + Constant.autotestPath + "/image/" + type + "/" + apkTestInfoBean.getFileName() + ".txt";
        String filePath2 = "  >> " + Constant.autotestPath + "/image/" + type + "/" + apkTestInfoBean.getFileName() + ".txt";
        savefile(true, "", type, apkTestInfoBean);
        String cmdstr = "";
        for (int i = 0; i < Constant.runcommand.length; i++) {
            if (Constant.runcommand[i].contains("logcat")) {
                savefile(false, Constant.runcommand[i], type, apkTestInfoBean);
                cmdstr = Constant.runcommand[i] + filePath1;
                ShellUtils.execCommand(cmdstr, false, true);
            } else {
                savefile(false, Constant.runcommand[i], type, apkTestInfoBean);
                cmdstr = Constant.runcommand[i] + filePath2;
                ShellUtils.execCommand(cmdstr, false, true);
            }
        }
    }

    private static void savefile(boolean first, String runcommand, String type, ApkTestInfoBean apkTestInfoBean) {
        BufferedWriter out = null;
        try {
            out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(Constant.autotestPath + "/image/" + type + "/" + apkTestInfoBean.getFileName() + ".txt", true)));
            if (first) {
                out.write("***********************************************\r\n");
                out.write("\r\n");
                out.write("commands that this app will run :\r\n");
                for (int i = 0; i < Constant.runcommand.length; i++) {
                    out.write(Constant.runcommand[i] + "\r\n");
                }
                out.write("\r\n");
                out.write("***********************************************\r\n");
            } else {
                out.write("\r\n");
                out.write("\r\n");
                out.write("\r\n");
                out.write("************************" + runcommand + "************************\r\n");
                out.write("\r\n");
                out.write("\r\n");
                out.write("\r\n");
            }
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

}
