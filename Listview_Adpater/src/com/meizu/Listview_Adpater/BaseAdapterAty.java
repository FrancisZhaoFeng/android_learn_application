package com.meizu.Listview_Adpater;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import com.meizu.tools.MyAdapter;

public class BaseAdapterAty extends Activity {
	private ListView lv;
	private final static String Tag = "BaseAdapterAty";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_arrayadapter);
		lv = (ListView) this.findViewById(R.id.lv_array_a);

		MyAdapter myAdapter = new MyAdapter(this);
		lv.setAdapter(myAdapter);

		lv.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
				// TODO Auto-generated method stub
				Log.d(Tag, "你点击了ListView条目" + arg2);
			}
		});
	}
}
