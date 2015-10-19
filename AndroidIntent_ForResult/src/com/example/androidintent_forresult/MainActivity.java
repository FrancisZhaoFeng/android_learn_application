package com.example.androidintent_forresult;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {

	private EditText edtTxtNum1;
	private EditText edtTxtNum2;
	private EditText edtTxtNum3;
	private Button btnCommit;
	private final static String Tag = "MainActivity";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.fragment_main);

		edtTxtNum1 = (EditText) this.findViewById(R.id.editxt_forreturn_num1);
		edtTxtNum2 = (EditText) this.findViewById(R.id.editxt_forreturn_num2);
		edtTxtNum3 = (EditText) this.findViewById(R.id.editxt_forreturn_num3);
		btnCommit = (Button) this.findViewById(R.id.btn_forreturn_commit);
		btnCommit.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(MainActivity.this, ReturnActivity.class);
				intent.putExtra("num1", Integer.parseInt(edtTxtNum1.getText().toString()));
				intent.putExtra("num2", Integer.parseInt(edtTxtNum2.getText().toString()));
				startActivityForResult(intent, 1);
			}
		});
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		if (resultCode == 2) {
			if (requestCode == 1) {
				edtTxtNum3.setText(String.valueOf(data.getIntExtra("num3", 0)));
			}
		}
	}
}
