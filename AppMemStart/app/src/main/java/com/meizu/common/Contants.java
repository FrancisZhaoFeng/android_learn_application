package com.meizu.common;

import android.os.Environment;

import com.meizu.domain.UserHabitInfo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Contants {
	public static String HTML_PATH = Environment.getExternalStorageDirectory().toString() + "/AutoTest";
	public static String HTML_NAME_ALL = "/all_AppMemStartReport.html";
	public static String HTML_NAME_CURRENT = "/current_AppMemStartReport.html";
	public static final String DATABASE_NAME = "appmemstart.db";
	public static final String TABLE_NAME_APP = "appMemInfo";
	public static final String TABLE_NAME_USER = "userHabitInfo";
	public static UserHabitInfo USERHABITINFO;
	public static final int DATABASE_VERSION = 1;
	public static String[] dumpElement = new String[]{
			"Native Heap","Dalvik Heap","TOTAL","Dalvik Other","Stack","Cursor","Ashmem","Other dev",
			".so mmap",".jar mmap",".apk mmap",".ttf mmap",".dex mmap",".oat mmap",".art mmap","Other mmap",
			"Unknown",
			"Views:","ViewRootImpl:",
			"AppContexts:","Activities:",
			"Assets:","AssetManagers:",
			"Local Binders:","Proxy Binders:",
			"Parcel memory:","Parcel count:",
			"Death Recipients:","OpenSSL Sockets:"};

	public static String getTime(){
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss ");
		Date curDate = new Date(System.currentTimeMillis());// 获取当前时间
		String date = formatter.format(curDate);
		return date;
	}
}
