package com.meizu.components.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.meizu.components.tools.Logger;

public class StaticBroadCast extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO Auto-generated method stub
        String msg = intent.getStringExtra("msg");
        Logger.i("StaticBroadcast:" + msg);
        Toast.makeText(context, "StaticBroadcast:" + msg, Toast.LENGTH_SHORT).show();
    }
}
