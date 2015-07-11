package com.example.androidfragment;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.Display;

@SuppressLint("CommitTransaction")
public class MainActivity extends Activity {

	@SuppressLint("CommitTransaction")
	@SuppressWarnings("deprecation")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		Display display = getWindowManager().getDefaultDisplay();
		FragmentTransaction  fragmentTransaction= getFragmentManager().beginTransaction();
		if(display.getWidth() < display.getHeight()){
			Fragment1 fragment1 = new Fragment1();
			fragmentTransaction.replace(R.id.ll_mainactivity_layout, fragment1).commit();
		}else{
			Fragment1 fragment1 = new Fragment1();
			Fragment2 fragment2 = new Fragment2();
			fragmentTransaction.replace(R.id.ll_mainactivity_layout, fragment2).commit();
			fragmentTransaction.add(R.id.ll_fragment2_layout, fragment1);
		}
	}
}
