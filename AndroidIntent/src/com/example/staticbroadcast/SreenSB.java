package com.example.staticbroadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class SreenSB extends BroadcastReceiver{
	private final static String TAG="SreenSB";

	@Override
	public void onReceive(Context context, Intent intent) {
		// TODO Auto-generated method stub
		Log.e(TAG, "SreenSB:" );
		Toast.makeText(context, "StaticBroadcast:", Toast.LENGTH_SHORT).show();;
	}

}
