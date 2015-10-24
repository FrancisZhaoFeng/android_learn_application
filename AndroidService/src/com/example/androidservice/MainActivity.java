package com.example.androidservice;

import com.example.aidlservice.MyAIDLService;

import android.app.Activity;
import android.app.Fragment;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Process;
import android.os.RemoteException;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class MainActivity extends Activity {
	public static final String Tag = "MainActivity";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		if (savedInstanceState == null) {
			getFragmentManager().beginTransaction().add(R.id.container, new PlaceholderFragment()).commit();
		}
		Log.e(Tag, "onActivityCreated executed Process is :" + Process.myPid());
	}

	/**
	 * A placeholder fragment containing a simple view.
	 * Fragment执行顺序：onAttach(建立关联是调用);onCreate(加载布局是调用);onActivityCreate(activity中的onCreate执行完后调用);
	 * onDestroyView(布局被移除调用);onDetach(解除关联时调用)
	 */
	public static class PlaceholderFragment extends Fragment implements View.OnClickListener {
		private Button btn_startService;
		private Button btn_stopService;
		private Button btn_bindService;
		private Button btn_unbindService;
		private Button btn_aidlBindService;
		private Button btn_aidlUnbindService;
		
		private MyService.MyBinder myBinder;
		private MyAIDLService myAIDLService;
		//没有remote的activity与service之间的联系
		private ServiceConnection connection = new ServiceConnection() {
			//方法onServiceDisconnected 和 onServiceConnected是activity 与service建立关联和解除关联时候调用
			@Override
			public void onServiceDisconnected(ComponentName name) {
				// TODO Auto-generated method stub
				
			}
			
			//通过向下转型得到myBinder实例，似的activity和service之间紧密联系，可在activity中调用myBinder中的public方法
			@Override
			public void onServiceConnected(ComponentName name, IBinder service) {
				// TODO Auto-generated method stub
				myBinder =(com.example.androidservice.MyService.MyBinder) service;
				myBinder.startDownload();
			}
		};
		//有remote的activity与service之间的联系,通过aidl联系
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
					Log.d(Tag, "result is :"+result);
					Log.d(Tag, "upperStr is :"+upperStr);
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
			btn_startService = (Button) getActivity().findViewById(R.id.btn_service_startservice);
			btn_stopService = (Button) getActivity().findViewById(R.id.btn_service_stopservice);
			btn_bindService = (Button) getActivity().findViewById(R.id.btn_service_bindservice);
			btn_unbindService = (Button) getActivity().findViewById(R.id.btn_service_unbindservice);
			btn_aidlBindService = (Button) getActivity().findViewById(R.id.btn_service_aidlbindservice);
			btn_aidlUnbindService = (Button) getActivity().findViewById(R.id.btn_service_aidlunbindservice);
			btn_startService.setOnClickListener(this);
			btn_stopService.setOnClickListener(this);
			btn_bindService.setOnClickListener(this);
			btn_unbindService.setOnClickListener(this);
			btn_aidlBindService.setOnClickListener(this);
			btn_aidlUnbindService.setOnClickListener(this);
		}

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			switch (v.getId()) {
			case R.id.btn_service_startservice:
				Intent startIntent = new Intent(getActivity(), MyService.class);
				getActivity().startService(startIntent);
				break;
			case R.id.btn_service_stopservice:
				Intent stopIntent = new Intent(getActivity(), MyService.class);
				getActivity().stopService(stopIntent);
				break;
			case R.id.btn_service_bindservice:
				Intent bindIntent = new Intent(getActivity(), MyService.class);
				getActivity().bindService(bindIntent, connection, BIND_AUTO_CREATE);
				break;
			case R.id.btn_service_unbindservice:
				getActivity().unbindService(connection);
				break;
			case R.id.btn_service_aidlbindservice:
				Intent aidlBindIntent = new Intent(getActivity(), AIDLService.class);
				getActivity().bindService(aidlBindIntent, aidlConnection, BIND_AUTO_CREATE);
				break;
			case R.id.btn_service_aidlunbindservice:
				getActivity().unbindService(aidlConnection);
				break;
			default:
				break;
			}
		}

	}

}
