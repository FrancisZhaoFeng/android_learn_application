package com.meizu.apptest.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import com.meizu.apptest.utils.ShellUtils;


public class MonkeyTestService extends Service {

	static String TAG = "MonkeyTestService";
	static String pkgName = "";

	@Override
	public void onCreate() {
		super.onCreate();
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		try {
			pkgName = intent.getStringExtra("pkgName");
			new Thread(test).start();
		} catch (Exception e) {
			e.printStackTrace();
		}
		flags = START_STICKY;
		return super.onStartCommand(intent, flags, startId);
	}

	Runnable test = new Runnable() {
		@Override
		public void run() {
			try {
				startMonkeyTest(pkgName);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	};

	private void startMonkeyTest(String pck) {
		String cmd = "monkey -p " + pck + " --pct-touch 50  --pct-motion 15  --pct-anyevent 5  --pct-majornav 12  --pct-trackball 1  --pct-nav 0  --pct-syskeys 15  --pct-appswitch 2  --throttle 500  -s  0  -v  500";
		Log.i(TAG, "执行monkey命令：" + cmd);
		ShellUtils.execCommand(cmd, false);

	}

	@Override
	public IBinder onBind(Intent intent) {
		return null;
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
	}

}
