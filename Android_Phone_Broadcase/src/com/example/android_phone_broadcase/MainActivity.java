package com.example.android_phone_broadcase;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {
	private final static String Tag = "MainActivity";
	private Button btnTest;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		btnTest = (Button) this.findViewById(R.id.btn_phone_text);
		btnTest.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Log.d(Tag, "mark");
				// ShellUtils.execCommand("input keyevent 3", false);
			}
		});
	}
}
