package com.example.androidservice;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;

public class OtherActivity extends Activity {
	private Button btn;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.other_activity);
		btn = (Button) this.findViewById(R.id.btn);
		
	}
}
