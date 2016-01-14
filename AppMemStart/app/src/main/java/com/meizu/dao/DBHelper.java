/**
 * 
 */
package com.meizu.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.meizu.common.Contants;

/**
 * @author zhaoguofeng
 * 
 */
public class DBHelper extends SQLiteOpenHelper {
	String TAG = "DBHelper";
	private static DBHelper dbHelper=null;

	public DBHelper(Context context) {
		super(context, Contants.DATABASE_NAME, null, Contants.DATABASE_VERSION);
		// TODO Auto-generated constructor stub
	}

	public static SQLiteDatabase getInstance(Context context){
		if (dbHelper == null){
			dbHelper = new DBHelper(context);
		}
		return dbHelper.getWritableDatabase();
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		String c_tableApp  = "create table if not exists "+Contants.TABLE_NAME_APP+"(id integer primary key autoincrement,packagNname varchar,classTableData text)";
		String c_tableUser = "create table if not exists "+Contants.TABLE_NAME_USER+"(id integer primary key autoincrement,classTableData text)";
		db.execSQL(c_tableApp);
		db.execSQL(c_tableUser);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		// db.execSQL("alter table appMemInfo add column other string");

	}



}
