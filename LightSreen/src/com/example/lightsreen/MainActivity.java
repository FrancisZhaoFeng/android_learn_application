package com.example.lightsreen;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.lightserver.LightServer;

public class MainActivity extends Activity {
	private Button btnLin;
	private EditText edtInput;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		btnLin = (Button) this.findViewById(R.id.btn_msg);
		edtInput = (EditText) this.findViewById(R.id.edt_input_num);
		btnLin.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				String numStr = edtInput.getText().toString();
				int number = 0;
				if (!numStr.equals("") && numStr != null) {
					onBackPressed();
					number = Integer.parseInt(numStr);
					Intent intent = new Intent(MainActivity.this, LightServer.class);
					intent.putExtra("number", number);
					startService(intent);
				} else {
					Toast.makeText(MainActivity.this, "执行次数不能为空", Toast.LENGTH_LONG).show();
				}
			}
		});
	}

	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		super.onBackPressed();
	}
}
