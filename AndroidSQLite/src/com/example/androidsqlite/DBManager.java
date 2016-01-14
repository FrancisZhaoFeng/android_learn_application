/**
 * 
 */
package com.example.androidsqlite;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

/**
 * @author zhaoguofeng
 * 
 */
public class DBManager {
	private DBHelper helper;
	private SQLiteDatabase db;

	/**
	 * 
	 */
	public DBManager(Context context) {
		// TODO Auto-generated constructor stub
		helper = new DBHelper(context);
		db = helper.getWritableDatabase();
	}

	public void add(List<Person> persons) {
		// TODO Auto-generated method stub
		db.beginTransaction();
		Log.e("df", "1");
		try {
			for (Person person : persons)
				db.execSQL("insert into person values(null,?,?,?)", new Object[] { person.getName(), person.getAge(), person.getInfo() });
			Log.e("df", "2");
			db.setTransactionSuccessful();
		} finally {
			db.endTransaction();
			// TODO: handle exception
		}
	}

	public void updateAge(Person person) {
		ContentValues cv = new ContentValues();
		cv.put("age", person.getAge());
		db.update("person", cv, "name=?", new String[] { person.getName() });
	}

	public void deleteOldPerson(Person person) {
		db.delete("person", "age >?", new String[] { String.valueOf(person.getAge()) });
	}

	public List<Person> query() {
		ArrayList<Person> persons = new ArrayList<Person>();
		Cursor c = queryTheCursor();
		while (c.moveToNext()) {
			Person person = new Person();
			person.setId(c.getInt(c.getColumnIndex("_id")));
			person.setName(c.getString(c.getColumnIndex("name")));
			person.setAge(c.getInt(c.getColumnIndex("age")));
			person.setInfo(c.getString(c.getColumnIndex("info")));
			persons.add(person);
		}
		c.close();
		return persons;
	}

	public Cursor queryTheCursor() {
		Cursor c = db.rawQuery("select * from person", null);
		return c;
	}

	public void closeDB() {
		db.close();
	}

}
