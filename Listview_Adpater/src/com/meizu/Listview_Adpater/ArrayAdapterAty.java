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
		lv = (ListView) this.findViewById(R.id.lv_array_a);// �õ�Listview���������
		// lv.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, strData));
		// lv.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_checked, strData)); //��
		// lv.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_multiple_choice, strData)); //����
		lv.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_single_choice, strData)); // Բ��
		lv.setChoiceMode(ListView.CHOICE_MODE_SINGLE); // ֻ��ѡһ����
		// lv.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);// ��ѡ����
	}
}
