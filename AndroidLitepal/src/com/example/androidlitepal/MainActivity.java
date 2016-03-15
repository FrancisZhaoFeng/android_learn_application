package com.example.androidlitepal;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.litepal.LitePalApplication;
import org.litepal.crud.DataSupport;
import org.litepal.tablemanager.Connector;

import com.example.beans.News;

import android.app.Activity;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity implements OnClickListener {

	String TAG = "MainActivity";
	Button btnSave;
	Button btnDelete;
	Button btnUpdate;
	Button btnCheck;
	int mId = 5;
	int minId = 6;
	int maxId = 9;
	int deleteId = 1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		LitePalApplication.initialize(this); // ��ʼ��litepal
		SQLiteDatabase db = Connector.getDatabase(); //���������ݿ⣬���½��������� ��ִ��
		btnSave = (Button) findViewById(R.id.btn_save);
		btnDelete = (Button) findViewById(R.id.btn_delete);
		btnUpdate = (Button) findViewById(R.id.btn_update);
		btnCheck = (Button) findViewById(R.id.btn_check);
		btnSave.setOnClickListener(this);
		btnDelete.setOnClickListener(this);
		btnUpdate.setOnClickListener(this);
		btnCheck.setOnClickListener(this);
	}

	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.btn_save:
			for (int i = 0; i < 10; i++) {
				News news = new News("title" + i, "content" + 1, new Date(), i + 1);
				news.save(); // save()�������ص���һ������ֵ�����ڱ�ʾ�洢�ɹ�����ʧ��
				// news.saveThrows();//�洢ʧ�ܵĻ����׳��쳣
			}
			break;
		case R.id.btn_delete:
			// DataSupport.delete(News.class, deleteId);// ɾ������idΪ1������
			DataSupport.deleteAll(News.class);// ɾ�����е���������
			// DataSupport.deleteAll(News.class, "commentCount > ? and commentCount < ?", "" + minId, "" + maxId);ɾ����ʾcommentCount����6С��9������
			break;
		case R.id.btn_update:
			// ����ContentValues
			// ContentValues values = new ContentValues();
			// values.put("title", "update is ContentValues Title");
			// DataSupport.update(News.class, values, mId); // ����idΪ5������
			// DataSupport.updateAll(News.class, values, "commentCount>?", "" + minId);// ����commentCount����6�ĸ���
			// DataSupport.updateAll(News.class, values);// ����conditions �ȸ��±��е���������
			// ����ContentValues
			News news = new News();
			news.setTitle("update not ContentValues Title");
			// news.update(mId); // ����idΪ5 ������
			// news.updateAll("commentCount>?", "" + minId);// ����commentCount����6�ĸ���
			news.updateAll();// ����conditions �ȸ��±��е���������
			break;
		case R.id.btn_check:
			List<News> listNews = new ArrayList<News>(); // isEager��ʾ�Ƿ���Ҫ������ѯ�����ó�true�ͱ�ʾ������ѯ�������ͻ�ѹ������е�����һ���ѯ�����ˡ�
			// News tNews = DataSupport.find(News.class, mId);// �鿴����idΪ5������
			// listNews.add(tNews);
			// News fristNews = DataSupport.findFirst(News.class);// �鿴���еĵ�һ������
			// listNews.add(fristNews);
			// News lastNews = DataSupport.findLast(News.class);// �鿴�������һ������
			// listNews.add(lastNews);
			// listNews = DataSupport.findAll(News.class, mId, minId, maxId);// //�鿴����idΪ5,6,9������
			listNews = DataSupport.findAll(News.class);// �鿴���е���������
			// listNews = DataSupport.where("commentCount >= ?", "" + minId).find(News.class);// �鿴����conditions����������
			// listNews = DataSupport.select("title").where("commentCount > ?", "" + minId).find(News.class);// �鿴����conditions���������ݵ�title��
			if (listNews == null || listNews.size() == 0)
				break;
			for (News tempNews : listNews) {
				Log.e(TAG, tempNews.toString());
			}
			break;
		default:
			break;
		}
	}

}
