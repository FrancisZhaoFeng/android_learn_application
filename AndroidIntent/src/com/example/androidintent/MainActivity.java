package com.example.androidintent;

import tools.Contants;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.SearchManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {

	private Button btnNormal;
	private Button btnContact;
	private Button btnHome;
	private Button btnSearch;
	private Button btnStaticBroad;
	private Button btnDynamicBroad;
	private final static String Tag = "MainActivity";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.fragment_main);

		btnNormal = (Button) this.findViewById(R.id.btn_intent_normal);
		btnContact = (Button) this.findViewById(R.id.btn_intent_contact);
		btnHome = (Button) this.findViewById(R.id.btn_intent_home);
		btnSearch = (Button) this.findViewById(R.id.btn_intent_search);
		btnStaticBroad = (Button) this.findViewById(R.id.btn_broad_static);
		btnDynamicBroad = (Button) this.findViewById(R.id.btn_broad_dynamic);

		btnDynamicBroad.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.setAction(Contants.dbc);
				intent.putExtra("msg", "��̬ע��㲥");
				sendBroadcast(intent);
			}
		});

		btnStaticBroad.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.setAction(Contants.sbc);
				intent.putExtra("msg", "��̬ע��㲥");
				sendBroadcast(intent);
			}
		});

		btnNormal.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(MainActivity.this, OthereActivity.class);
				intent.putExtra("name", "francis_zhaogf");
				intent.putExtra("age", 22);
				intent.putExtra("address", "�㶫�麣");
				startActivity(intent);
			}
		});

		btnContact.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();

				// // ������ϵ��ID��ʾ��ϵ����Ϣ
				// intent.setAction(Intent.ACTION_VIEW);
				// intent.setData(Uri.parse("content://contacts/people/5"));
				// // ��ʾ������壬���ڲ�������Ͻ�������ʾ����
				// intent.setAction(Intent.ACTION_DIAL);// ������ϵ��ID��ʾ�������
				// intent.setData(Uri.parse("tel://15913248728"));
				// // ������ϵ�˵�id�༭��ϵ��
				// intent.setAction(Intent.ACTION_EDIT);
				// intent.setData(Uri.parse("content://contacts/people/5"));
				// ��ʾͨѶ¼��ϵ��
				intent.setAction(Intent.ACTION_VIEW);
				intent.setData(Uri.parse("content://contacts/people/"));

				startActivity(intent);
			}
		});

		btnHome.setOnClickListener(new View.OnClickListener() {

			@SuppressWarnings("static-access")
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();

				// ����HomeScreen
				intent.setAction(Intent.ACTION_MAIN);
				intent.addCategory(intent.CATEGORY_HOME);

				startActivity(intent);
			}
		});

		btnSearch.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();

				// intent.setAction(Intent.ACTION_SEARCH);
				intent.setAction(Intent.ACTION_WEB_SEARCH);
				intent.putExtra(SearchManager.QUERY, "zhaoguofeng");

				startActivity(intent);
			}
		});

		registerReceiver(new BroadcastReceiver() { // ��̬ע��㲥

					public void onReceive(Context context, Intent intent) {
						// TODO Auto-generated method stub
						String strMsg = intent.getStringExtra("msg");
						Log.d(Tag, "DynamicBroadcast:" + strMsg);
						Toast.makeText(context, "DynamicBroadcast:" + strMsg, Toast.LENGTH_SHORT).show();;
					}
				}, new IntentFilter(Contants.dbc));
	}
}
