package com.example.androidparcelable;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.bean.Person;

public class ShowActivity extends Activity {
	private TextView tvName;
	private TextView tvAge;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_show);
		tvName = (TextView) this.findViewById(R.id.id_name);
		tvAge = (TextView) this.findViewById(R.id.id_age);
		Person person = this.getIntent().getParcelableExtra(MainActivity.PAR_KEY);
		Log.e("df", person.getName() + "==" + person.getAge());
		tvName.setText(person.getName());
		tvAge.setText(person.getAge() + "");
	}
}
