package com.example.androidparcelable;

import com.example.bean.Person;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {
	private Button btnParcelable;
	public static final String PAR_KEY = "com.example.bean.person";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		btnParcelable = (Button) this.findViewById(R.id.id_parcelable);
		btnParcelable.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Person person = new Person("francis_zhaogf", 23);
				Intent intent = new Intent(MainActivity.this, ShowActivity.class);
				intent.putExtra(PAR_KEY, person);
				startActivity(intent);
			}
		});
	}
}
