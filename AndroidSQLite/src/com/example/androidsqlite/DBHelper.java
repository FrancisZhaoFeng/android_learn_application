package com.example.androidsqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
	private static final String DATABASE_NAME = "androidsqlite.db";
	private static final int DATABASE_VERSIN = 1;
	private String c_table;

	public DBHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSIN);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		c_table = "create table if not exists person (_id integer primary key autoincrement,name varchar,age integer,info text)";
		db.execSQL(c_table);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		db.execSQL("alter table person add column other string");
	}

}
