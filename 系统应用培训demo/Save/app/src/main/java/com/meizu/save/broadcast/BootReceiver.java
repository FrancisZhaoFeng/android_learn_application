package com.meizu.save.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.google.gson.Gson;
import com.meizu.save.bean.User;
import com.meizu.save.util.SharePreferenceUtil;
import com.orhanobut.logger.Logger;

/**
 * 用来接收系统重启广播
 */
public class BootReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Logger.i("接收到开机广播");
        String data = SharePreferenceUtil.getObjectSharedPreferences(User.class.toString());
        if (!data.equals("")) {
            User user = new Gson().fromJson(data, User.class);
            Logger.i("重启后获取的信息是：" + user.toString());
        }else{
            Logger.i("重启后获取的信息为空");
        }
    }
}
