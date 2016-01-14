package com.meizu.Listview_Adpater;

import java.util.ArrayList;
import java.util.HashMap;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class SimpleAdapterAty extends Activity {
	private ListView lv;
	private final static String Tag = "SimpleAdapterAty";

	@SuppressWarnings("unchecked")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_arrayadapter);

		lv = (ListView) this.findViewById(R.id.lv_array_a);
		// 定义一个动态数据
		Intent intent = this.getIntent();
		ArrayList<HashMap<String, Object>> listItem = (ArrayList<HashMap<String, Object>>) intent.getSerializableExtra("listView");
		// 动态数组中的数据源的键对应到定义布局的View中
		String[] fromS = { "itemImage", "itemTitle", "itemDetail" };
		int[] toS = { R.id.img_simple_pic, R.id.id_simple_title, R.id.id_simple_detail };
		// 需要绑定的数据
		SimpleAdapter simpleAdapter = new SimpleAdapter(this, listItem, R.layout.activity_simpleadapter, fromS, toS);
		lv.setAdapter(simpleAdapter);// 为ListView绑定适配器

		lv.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
				// TODO Auto-generated method stub
				setTitle("你点击，第" + arg2 + "行，arg3:" + arg3);
			}
		});
	}

	private ArrayList<HashMap<String, Object>> getListData() {
		Log.d(Tag, "getListData()");
		ArrayList<HashMap<String, Object>> listItem = new ArrayList<HashMap<String, Object>>();
		for (int i = 0; i < 10000; i++) {
			HashMap<String, Object> hashMap = new HashMap<String, Object>();
			hashMap.put("itemImage", R.drawable.ic_launcher);
			hashMap.put("itemTitle", "第" + i + "行");
			hashMap.put("itemDetail", "第" + i + "详细内容");
			listItem.add(hashMap);
		}
		return listItem;
	}
}
