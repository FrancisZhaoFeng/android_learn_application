package com.example.androidintent;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class OthereActivity extends Activity {
	
	private TextView txtMsg ;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.otheractivity);
		txtMsg = (TextView)this.findViewById(R.id.id_txt_msg);
		
		Intent intent = getIntent();
		String strName = intent.getStringExtra("name");
		int iAge = intent.getIntExtra("age", -1);
		String strAddress = intent.getStringExtra("address");
		
		txtMsg.setText(strName+"\n"+iAge+"\n"+strAddress);
	}
}
