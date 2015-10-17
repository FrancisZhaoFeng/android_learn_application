package com.meizu.Listview_Adpater;

import java.util.ArrayList;
import java.util.HashMap;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {
	private Button btnArray;
	private Button btnSimple;
	private Button btnBase;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		btnArray = (Button) this.findViewById(R.id.btn_main_arrayadapter);
		btnSimple = (Button) this.findViewById(R.id.btn_main_simpleadapter);
		btnBase = (Button) this.findViewById(R.id.btn_main_baseadapter);

		btnArray.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(MainActivity.this, ArrayAdapterAty.class);
				intent.putExtra("strData", getArrayData());
				startActivity(intent);
			}
		});

		btnSimple.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(MainActivity.this, SimpleAdapterAty.class);
				intent.putExtra("listView", getListData());
				startActivity(intent);
			}
		});

		btnBase.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(MainActivity.this, BaseAdapterAty.class);
				intent.putExtra("listView", getListData());
				startActivity(intent);
			}
		});
	}

	private String[] getArrayData() {
		String[] strData = new String[100];
		for (int i = 0; i < 100; i++) {
			strData[i] = "第-" + i + "-数据";
		}
		return strData;
	}

	private ArrayList<HashMap<String, Object>> getListData() {
		ArrayList<HashMap<String, Object>> listItem = new ArrayList<HashMap<String, Object>>();
		for (int i = 0; i < 1000; i++) {
			HashMap<String, Object> hashMap = new HashMap<String, Object>();
			hashMap.put("itemImage", R.drawable.ic_launcher);
			hashMap.put("itemTitle", "第" + i + "行");
			hashMap.put("itemDetail", "第" + i + "详细内容");
			listItem.add(hashMap);
		}
		return listItem;
	}
}
