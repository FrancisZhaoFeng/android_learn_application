package com.example.androidintent;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class StaticBroadcast extends BroadcastReceiver {
	private final static String Tag = "StaticBroadcast";

	@SuppressLint("ShowToast")
	@Override
	public void onReceive(Context context, Intent intent) {
		// TODO Auto-generated method stub
		String strMsg = intent.getStringExtra("msg");
		Log.d(Tag, "StaticBroadcast:" + strMsg);
		Toast.makeText(context, "StaticBroadcast:" + strMsg, Toast.LENGTH_SHORT).show();;
	}
}
