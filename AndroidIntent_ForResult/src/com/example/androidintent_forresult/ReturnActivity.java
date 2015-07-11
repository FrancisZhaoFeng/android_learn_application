package com.example.androidintent_forresult;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ReturnActivity extends Activity {
	private TextView tvExpression;
	private EditText edtTxtInput;
	private Button btnCommit;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.returnactivity);

		tvExpression = (TextView) this.findViewById(R.id.tv_return_expression);
		edtTxtInput = (EditText) this.findViewById(R.id.edtTxt_return_input);
		btnCommit = (Button) this.findViewById(R.id.btn_return_commit);

		Intent intent = getIntent();
		int num1 = intent.getIntExtra("num1", 0);
		int num2 = intent.getIntExtra("num2", 0);

		tvExpression.setText(num1 + "+" + num2 + "=" + "?");

		btnCommit.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.putExtra("num3", Integer.parseInt(edtTxtInput.getText().toString()));
				setResult(2, intent);
				finish();
			}
		});
	}
}
