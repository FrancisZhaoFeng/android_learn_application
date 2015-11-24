package com.example.android_phone_broadcase;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class PhoneBroadCast extends BroadcastReceiver {
	private final static String Tag = "PhoneBroadCast";

	@Override
	public void onReceive(Context context, Intent intent) {
		// TODO Auto-generated method stub
		executeThread().start();
	}

	private Thread executeThread() {
		Thread thread = new Thread(new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					Thread.sleep(10 * 1000);
					Log.e(Tag, "PhoneBroadCast");
					ShellUtils.execCommand("input swipe 540 1530 100 1530", false);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		return thread;
	}

}
