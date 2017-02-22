package com.meizu.testlogger.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.meizu.testlogger.tools.Logger;

/**
 * Created by zhaoguofeng on 2017/1/5.
 */
public class CameraBc extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Logger.e("接收到拍照广播："+intent.getAction());
    }
}
