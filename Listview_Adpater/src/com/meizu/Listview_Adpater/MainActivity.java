package com.meizu.Listview_Adpater;

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
				startActivity(intent);
			}
		});
	}
}
