package com.example.androidintent;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

	private Button btnNormal;
	private Button btnContact;
	private Button btnHome;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.fragment_main);

		btnNormal = (Button) this.findViewById(R.id.btn_intent_normal);
		btnContact = (Button) this.findViewById(R.id.btn_intent_contact);
		

		btnNormal.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(MainActivity.this, OthereActivity.class);
				intent.putExtra("name", "francis_zhaogf");
				intent.putExtra("age", 22);
				intent.putExtra("address", "广东珠海");
				startActivity(intent);
			}
		});

		btnContact.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();

				// // 根据联系人ID显示联系人信息
				// intent.setAction(Intent.ACTION_VIEW);
				// intent.setData(Uri.parse("content://contacts/people/5"));
				// // 显示拨号面板，并在拨号面板上将号码显示出来
				// intent.setAction(Intent.ACTION_DIAL);// 根据联系人ID显示拨号面板
				// intent.setData(Uri.parse("tel://15913248728"));
				// // 根据联系人的id编辑联系人
				// intent.setAction(Intent.ACTION_EDIT);
				// intent.setData(Uri.parse("content://contacts/people/5"));
				// // 显示通讯录联系人
				// intent.setAction(Intent.ACTION_VIEW);
				// intent.setData(Uri.parse("content://contacts/people/"));
				// 启动HomeScreen
				intent.setAction(Intent.ACTION_MAIN);
				intent.addCategory(intent.CATEGORY_HOME);

				startActivity(intent);
			}
		});

	}
}
