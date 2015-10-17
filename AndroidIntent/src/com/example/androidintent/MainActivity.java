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
				intent.putExtra("address", "�㶫�麣");
				startActivity(intent);
			}
		});

		btnContact.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();

				// // ������ϵ��ID��ʾ��ϵ����Ϣ
				// intent.setAction(Intent.ACTION_VIEW);
				// intent.setData(Uri.parse("content://contacts/people/5"));
				// // ��ʾ������壬���ڲ�������Ͻ�������ʾ����
				// intent.setAction(Intent.ACTION_DIAL);// ������ϵ��ID��ʾ�������
				// intent.setData(Uri.parse("tel://15913248728"));
				// // ������ϵ�˵�id�༭��ϵ��
				// intent.setAction(Intent.ACTION_EDIT);
				// intent.setData(Uri.parse("content://contacts/people/5"));
				// // ��ʾͨѶ¼��ϵ��
				// intent.setAction(Intent.ACTION_VIEW);
				// intent.setData(Uri.parse("content://contacts/people/"));
				// ����HomeScreen
				intent.setAction(Intent.ACTION_MAIN);
				intent.addCategory(intent.CATEGORY_HOME);

				startActivity(intent);
			}
		});

	}
}
