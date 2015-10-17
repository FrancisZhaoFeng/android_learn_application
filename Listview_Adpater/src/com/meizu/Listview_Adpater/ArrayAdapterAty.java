package com.meizu.Listview_Adpater;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ArrayAdapterAty extends Activity {
	private ListView lv;
	private final static String Tap = "ArrayAdapterAty";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_arrayadapter);

		Intent intent = this.getIntent();
		String[] strData = intent.getStringArrayExtra("strData");
		lv = (ListView) this.findViewById(R.id.lv_array_a);// 得到Listview对象的引用
		// lv.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, strData));
		// lv.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_checked, strData)); //打钩
		// lv.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_multiple_choice, strData)); //方形
		lv.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_single_choice, strData)); // 圆点
		lv.setChoiceMode(ListView.CHOICE_MODE_SINGLE); // 只能选一个项
		// lv.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);// 可选多项
	}
}
