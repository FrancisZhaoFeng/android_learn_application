package com.meizu.Listview_Adpater;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
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

		Log.d(Tap, "jinlail");
		lv = (ListView) this.findViewById(R.id.lv_array_a);// �õ�Listview���������
		lv.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, getData()));
	}

	private String[] getData() {
		String[] strData = new String[100];
		for (int i = 0; i < 100; i++) {
			strData[i] = "��-" + i + "-����";
		}
		return strData;
	}
}
