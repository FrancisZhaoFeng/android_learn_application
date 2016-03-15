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
		LitePalApplication.initialize(this); // 初始化litepal
		SQLiteDatabase db = Connector.getDatabase(); //操作下数据库，令新建表、升级表 被执行
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
				news.save(); // save()方法返回的是一个布尔值，用于表示存储成功还是失败
				// news.saveThrows();//存储失败的话就抛出异常
			}
			break;
		case R.id.btn_delete:
			// DataSupport.delete(News.class, deleteId);// 删除表中id为1的数据
			DataSupport.deleteAll(News.class);// 删除表中的所有数据
			// DataSupport.deleteAll(News.class, "commentCount > ? and commentCount < ?", "" + minId, "" + maxId);删除表示commentCount大于6小于9的数据
			break;
		case R.id.btn_update:
			// 含有ContentValues
			// ContentValues values = new ContentValues();
			// values.put("title", "update is ContentValues Title");
			// DataSupport.update(News.class, values, mId); // 更新id为5的数据
			// DataSupport.updateAll(News.class, values, "commentCount>?", "" + minId);// 满足commentCount大于6的更新
			// DataSupport.updateAll(News.class, values);// 不含conditions 既更新表中的所有数据
			// 不含ContentValues
			News news = new News();
			news.setTitle("update not ContentValues Title");
			// news.update(mId); // 更新id为5 的数据
			// news.updateAll("commentCount>?", "" + minId);// 满足commentCount大于6的更新
			news.updateAll();// 不含conditions 既更新表中的所有数据
			break;
		case R.id.btn_check:
			List<News> listNews = new ArrayList<News>(); // isEager表示是否需要激进查询，设置成true就表示激进查询，这样就会把关联表中的数据一起查询出来了。
			// News tNews = DataSupport.find(News.class, mId);// 查看表中id为5的数据
			// listNews.add(tNews);
			// News fristNews = DataSupport.findFirst(News.class);// 查看表中的第一条数据
			// listNews.add(fristNews);
			// News lastNews = DataSupport.findLast(News.class);// 查看表中最后一条数据
			// listNews.add(lastNews);
			// listNews = DataSupport.findAll(News.class, mId, minId, maxId);// //查看表中id为5,6,9的数据
			listNews = DataSupport.findAll(News.class);// 查看表中的所有数据
			// listNews = DataSupport.where("commentCount >= ?", "" + minId).find(News.class);// 查看符合conditions的所有数据
			// listNews = DataSupport.select("title").where("commentCount > ?", "" + minId).find(News.class);// 查看符合conditions的所有数据的title列
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
