package com.example.staticbroadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class CustomSB extends BroadcastReceiver {
	private final static String Tag = "CustomSB";

	public void onReceive(Context context, Intent intent) {
		// TODO Auto-generated method stub
		String strMsg = intent.getStringExtra("msg");
		Log.e(Tag, "StaticBroadcast:" + strMsg);
		Toast.makeText(context, "StaticBroadcast:" + strMsg, Toast.LENGTH_SHORT).show();;
	}
}
