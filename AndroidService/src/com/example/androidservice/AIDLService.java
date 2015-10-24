package com.example.androidservice;

import com.example.aidlservice.MyAIDLService;
import com.example.aidlservice.MyAIDLService.Stub;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.Process;
import android.util.Log;

public class AIDLService extends Service {

	private String Tag = "AIDLService";

	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		Log.e(Tag, "process is :" + Process.myPid());
		super.onCreate();
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		// TODO Auto-generated method stub
		Log.e(Tag, "execute onStartCommand()");
		return super.onStartCommand(intent, flags, startId);
	}
	
	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		Log.d(Tag, "onDestroy() executed");
	}

	@Override
	public IBinder onBind(Intent arg0) {
		// TODO Auto-generated method stub
		return aidlBinder;
	}

	MyAIDLService.Stub aidlBinder = new Stub() {

		@Override
		public String toUpperCase(String str) {
			// TODO Auto-generated method stub
			return str.toUpperCase();
		}

		@Override
		public int plus(int a, int b) {
			// TODO Auto-generated method stub
			return a + b;
		}
	};

}
