package com.example.lightserver;

import com.example.lightsreen.ShellUtils;

import android.annotation.SuppressLint;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.PowerManager;
import android.os.SystemClock;
import android.util.Log;

public class LightServer extends Service {
	private static final String Tag = "LightServer";

	private PowerManager pm;
	private PowerManager.WakeLock wl;

	@SuppressWarnings("deprecation")
	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
		pm = (PowerManager) getSystemService(Context.POWER_SERVICE);
		wl = pm.newWakeLock(PowerManager.ACQUIRE_CAUSES_WAKEUP | PowerManager.SCREEN_DIM_WAKE_LOCK, "bright");
	}

	@Override
	public IBinder onBind(Intent arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		int number = intent.getIntExtra("number", 3);
		Log.d(Tag, "number:" + number);
		executeThread(number).start();
		return super.onStartCommand(intent, flags, startId);
	};

	private Thread executeThread(final int number) {
		Thread thread = new Thread(new Runnable() {
			@SuppressLint("Wakelock")
			@Override
			public void run() {
				// TODO Auto-generated method stub
				for (int i = 0; i < number; i++) {
					try {
						pm.goToSleep(SystemClock.uptimeMillis());
						Thread.sleep(2 * 60 * 1000);
						wl.acquire();
						wl.release();
						Thread.sleep(1000);
						ShellUtils.execCommand("input swipe 500 1300 500 100", false);
						Thread.sleep(2 * 60 * 1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});
		return thread;
	}

	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
	}

}
