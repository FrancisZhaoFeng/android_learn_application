package com.example.androidloyout;

import java.util.Random;

import android.app.Activity;
import android.app.Fragment;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.aidlservice.MyAIDLService;
import com.example.service.AidlServeice;
import com.example.service.ClientMyAidlService;

public class MainActivity extends Activity {
	public static String Tag = "MainActivity";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Log.e(Tag, "onCreate");
		
		Intent intent = new Intent(MainActivity.this, AidlServeice.class);
		startService(intent);
		super.onBackPressed();

		// Intent intent = new Intent(MainActivity.this,ClientMyAidlService.class);
		// startService(intent);
		// if (savedInstanceState == null) {
		// getFragmentManager().beginTransaction().add(R.id.container, new PlaceholderFragment()).commit();
		// }
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {

		private Button btn_bindService;
		private Button btn_unBindService;
		private Button btn_executeAIDL;
		// 有remote的activity与service之间的联系,通过aidl联系
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
					Log.d(Tag, "result is :" + result);
					Log.d(Tag, "upperStr is :" + upperStr);
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_main, container, false);
			return rootView;
		}

		@Override
		public void onActivityCreated(Bundle savedInstanceState) {
			// TODO Auto-generated method stub
			super.onActivityCreated(savedInstanceState);
			btn_bindService = (Button) getActivity().findViewById(R.id.btn_test_aidlbingservice);
			btn_unBindService = (Button) getActivity().findViewById(R.id.btn_test_unaidlbingservice);
			btn_executeAIDL = (Button) getActivity().findViewById(R.id.btn_test_execute);
			btn_bindService.setOnClickListener(new View.OnClickListener() {

				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					Log.d(Tag, "dfdf");
					Intent intent = new Intent("com.example.aidlservice.MyAIDLService");
					getActivity().bindService(intent, aidlConnection, BIND_AUTO_CREATE);
				}
			});
			btn_unBindService.setOnClickListener(new View.OnClickListener() {

				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					getActivity().unbindService(aidlConnection);
				}
			});
			btn_executeAIDL.setOnClickListener(new View.OnClickListener() {

				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stubs
					try {
						int a = new Random().nextInt(100), b = new Random().nextInt(100);
						Log.d(Tag, a + "+" + b + "=" + myAIDLService.plus(a, b));
					} catch (RemoteException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			});
		}
	}

}
