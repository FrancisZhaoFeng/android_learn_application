package com.meizu.components.common;

import android.os.Environment;

import java.io.File;


public class Constant {
    public static String TAG = "components";

    //文件路径相关
    public final static String SD_PATH = Environment.getExternalStorageDirectory().getPath() + File.separator;
    //日志
    public static String USERPATH_WRITELOG = SD_PATH + "component.log";
    //广播相关
    public final static String DYNAMIC_BC = "com.meizu.components.dynamicbroadcast";
    public final static String STATIC_BC = "com.meizu.components.staticbroadcast";


}
