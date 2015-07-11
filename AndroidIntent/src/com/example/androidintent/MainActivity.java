package com.example.androidintent;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

	private Button btn_Transmit;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.fragment_main);

		btn_Transmit = (Button) this.findViewById(R.id.intent_transmit);
		btn_Transmit.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(MainActivity.this, OthereActivity.class);
				intent.putExtra("name", "francis_zhaogf");
				intent.putExtra("age", 22);
				intent.putExtra("address", "¹ã¶«Öéº£");
				startActivity(intent);
			}
		});

	}
}
