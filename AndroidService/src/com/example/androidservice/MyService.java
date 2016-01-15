package com.example.androidservice;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Binder;
import android.os.IBinder;
import android.os.Process;
import android.util.Log;

public class MyService extends Service {
	private static final String Tag = "MyService";
	private MyBinder mBinder = new MyBinder();

	// onCreate方法只会在service第一次被创建的时候调用，因此点击多次start Service按钮，只会执行onStartCommand方法
	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
		registerReceiver(mybroadcast, new IntentFilter(Intent.ACTION_SCREEN_ON));
	      registerReceiver(mybroadcast, new IntentFilter(Intent.ACTION_SCREEN_OFF));
		// this.notificationBar(); // 前台service
		Log.e(Tag, "MyService executed Process is :" + Process.myPid());
	}

	// 就的版本用onStart方法
	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		// TODO Auto-generated method stub
		Log.d(Tag, "onStartCommand() executed");
		executeThread("onStartCommand()").start();
		return super.onStartCommand(intent, flags, startId);
	}

	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		Log.d(Tag, "onDestroy() executed");
	}

	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		return mBinder;
	}

	class MyBinder extends Binder {
		public void startDownload() {
			// Service和Thread之间没有任何关系,Thread是用于开启一个子线程,Service是运行在主线程里的
			executeThread("startDownload()").start();
		}
	}

	private Thread executeThread(final String str) {
		Thread thread = new Thread(new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				Log.d(Tag, "onStartCommand() executed");
				for (long i = 0; i < 15; i++) {
					try {
						Thread.sleep(2 * 1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					Log.d(Tag, str + " thread:" + i);
				}
			}
		});
		return thread;
	}

	@SuppressWarnings("deprecation")
	private void notificationBar() {
		// 创建一个Notification对象，第二个参数：内容显示时间：大约2秒，地点：屏幕上方
		Notification notification = new Notification(R.drawable.ic_launcher, "通知yy到来", System.currentTimeMillis());
		Intent notificationIntent = new Intent(this, MainActivity.class);
		PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, notificationIntent, 0);
		// setLatestEventInfo 方法来为通知初始化布局和数据
		notification.setLatestEventInfo(this, "这是同事标题", "这是通知内容", pendingIntent);
		startForeground(1, notification);
	}
	
	BroadcastReceiver mybroadcast = new BroadcastReceiver() {

        //When Event is published, onReceive method is called
        @Override
        public void onReceive(Context context, Intent intent) {
            // TODO Auto-generated method stub
                Log.i("[BroadcastReceiver]", "MyReceiver");

                if(intent.getAction().equals(Intent.ACTION_SCREEN_ON)){
                    Log.i("[BroadcastReceiver]", "Screen ON");
                }
                else if(intent.getAction().equals(Intent.ACTION_SCREEN_OFF)){
                    Log.i("[BroadcastReceiver]", "Screen OFF");
                }

        }
    };
}
