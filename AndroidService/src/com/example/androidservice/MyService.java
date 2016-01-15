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

	// onCreate����ֻ����service��һ�α�������ʱ����ã���˵�����start Service��ť��ֻ��ִ��onStartCommand����
	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
		registerReceiver(mybroadcast, new IntentFilter(Intent.ACTION_SCREEN_ON));
	      registerReceiver(mybroadcast, new IntentFilter(Intent.ACTION_SCREEN_OFF));
		// this.notificationBar(); // ǰ̨service
		Log.e(Tag, "MyService executed Process is :" + Process.myPid());
	}

	// �͵İ汾��onStart����
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
			// Service��Thread֮��û���κι�ϵ,Thread�����ڿ���һ�����߳�,Service�����������߳����
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
		// ����һ��Notification���󣬵ڶ���������������ʾʱ�䣺��Լ2�룬�ص㣺��Ļ�Ϸ�
		Notification notification = new Notification(R.drawable.ic_launcher, "֪ͨyy����", System.currentTimeMillis());
		Intent notificationIntent = new Intent(this, MainActivity.class);
		PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, notificationIntent, 0);
		// setLatestEventInfo ������Ϊ֪ͨ��ʼ�����ֺ�����
		notification.setLatestEventInfo(this, "����ͬ�±���", "����֪ͨ����", pendingIntent);
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
