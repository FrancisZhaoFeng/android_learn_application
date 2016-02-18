package com.example.service;

import com.example.aidlservice.MyAIDLService;

import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

public class ClientMyAidlService extends Service {

	private String Tag = "clientMyAidlService";

	private MyAIDLService myAIDLService;
	private ServiceConnection aidlConnection = new ServiceConnection() {
		@Override
		public void onServiceDisconnected(ComponentName name) {
			// TODO Auto-generated method stub

		}

		@Override
		public void onServiceConnected(ComponentName name, IBinder service) {
			// TODO Auto-generated method stub
			myAIDLService = MyAIDLService.Stub.asInterface(service);
			try {
				int result = myAIDLService.plus(100, 25);
				String upperStr = myAIDLService.toUpperCase("hello world!");
				Log.e(Tag, "result is :" + result);
				Log.e(Tag, "upperStr is :" + upperStr);
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	};

	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		Log.e(Tag, "onCreate");
		super.onCreate();
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		// TODO Auto-generated method stub
		Log.e(Tag, "onStartCommand");
		Intent in = new Intent("com.example.aidlservice.MyAIDLService");
		bindService(in, aidlConnection, BIND_AUTO_CREATE);
		return super.onStartCommand(intent, flags, startId);
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

}
