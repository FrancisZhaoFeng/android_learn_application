package com.meizu.save.util;

import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.meizu.save.activity.AppContext;
import com.orhanobut.logger.Logger;

/**
 * Created by zhaoguofeng on 2017/1/10.
 */
public class SharePreferenceUtil {

    /**
     * @param type
     * 用于指定SharePreference文件的名称，如果文件不存在则会创建一个，SharePreference文件都是存放在/data/data/<package name>/shared_prefs/目录下。
     * @param obj
     * 用于指定操作模式，主要有两种模式：MODE_PRIVATE和MODE_MULTI_PROCESS，前者是默认操作模式，和传入0效果是一样的，表示只有当前的应用才可以对这个文件进行读写操作；后者一般用于会有多个进程中对同一个SharePreference文件进行读写操作
     */
    public static void saveObjectSharedPreferences(String type, Object obj) {
        String data = new Gson().toJson(obj);
        SharedPreferences sp = AppContext.getInstance().getSharedPreferences(type, AppContext.getInstance().MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString(type, data);
        editor.commit();
        Logger.i("通过SharedPreferences记录type：" + type + ",data：" + data);
    }

    /**
     * 获取持久化并设置初始化
     *
     * @return
     */
    public static String getObjectSharedPreferences(String type) {
        SharedPreferences sp = AppContext.getInstance().getSharedPreferences(type, AppContext.getInstance().MODE_PRIVATE);
        //两个参数对应需要提取的key和默认value，若key值为null或读取不到，则获取默认值，当读取值为""时，不视为null
        String data = sp.getString(type, "");
        return data;
    }
}
