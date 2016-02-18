package com.example.service;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

import com.example.androidloyout.MainActivity;
import com.meizu.meizuuser.MeizuApi;

public class AidlServeice extends Service {

	private static String Tag = "AidlServeice";
	MeizuApi meizuUser;

	private ServiceConnection conn = new ServiceConnection() {
		@Override
		synchronized public void onServiceConnected(ComponentName name, IBinder service) {
			meizuUser = MeizuApi.Stub.asInterface(service);
		}

		@Override
		public void onServiceDisconnected(ComponentName name) {
			meizuUser = null;
		}
	};

	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		Log.e(Tag, "onCreate");
		threadT.start();
		// bindService(new Intent("com.meizu.meizuuser.MeizuApi"), conn, Service.BIND_AUTO_CREATE);
		super.onCreate();
		// this.notificationBar();
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		// TODO Auto-generated method stub
		Log.e(Tag, "onStartCommand()");
		// threadDy.start();
		// threadT.start();
		// waitForMeizuAPI();

		return super.onStartCommand(intent, flags, startId);
	}

	Thread threadDy = new Thread(new Runnable() {
		@Override
		public void run() {
			waitForMeizuAPI();
		}
	});

	Thread threadT = new Thread(new Runnable() {

		@Override
		public void run() {
			// TODO Auto-generated method stub
			while (true) {
				if (meizuUser == null) {
					bindService(new Intent("com.meizu.meizuuser.MeizuApi"), conn, Service.BIND_AUTO_CREATE);
					waitForMeizuAPI();
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					Log.e(Tag, "threadT  meizuUser is null");
				} else {
					Log.e(Tag, "threadT  meizuUser not null");
					try {
						meizuUser.adbshell("input keyevent 26");
					} catch (RemoteException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
//					break;
				}
				Log.i(Tag, "threadT log");
			}
		}
	});

	@SuppressWarnings("static-access")
	private synchronized void waitForMeizuAPI() {
		while (true) {
			if (meizuUser == null) {
				try {
					threadT.sleep(100);
					// Log.e(Tag, "meizuUser == null");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			} else {
				break;
			}
		}
	}

	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
	}

	@Override
	public IBinder onBind(Intent arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("deprecation")
	private void notificationBar() {
		// 创建一个Notification对象，第二个参数：内容显示时间：大约2秒，地点：屏幕上方
		Notification notification = new Notification(android.R.drawable.alert_dark_frame, "通知yy到来", System.currentTimeMillis());
		Intent notificationIntent = new Intent(this, MainActivity.class);
		PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, notificationIntent, 0);
		// setLatestEventInfo 方法来为通知初始化布局和数据
		notification.setLatestEventInfo(this, "这是同事标题", "这是通知内容", pendingIntent);
		startForeground(1, notification);
	}

}
