package com.example.androidsqlite;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.database.Cursor;
import android.database.CursorWrapper;
import android.os.Bundle;
import android.support.v4.widget.SimpleCursorAdapter;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class MainActivity extends Activity {
	private DBManager dbMgr;
	private ListView listView;
	private static final String Tag = "MainActivity";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		listView = (ListView) this.findViewById(R.id.lv_sql_list);
		dbMgr = new DBManager(this);
	}

	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		dbMgr.closeDB();
	}

	public void add(View view) {
		ArrayList<Person> persons = new ArrayList<Person>();
		Person person1 = new Person("Ella", 22, "lively girl");
		Person person2 = new Person("Jenny", 22, "beautiful girl");
		Person person3 = new Person("Jessica", 23, "sexy girl");
		Person person4 = new Person("Kelly", 23, "hot baby");
		Person person5 = new Person("Jane", 25, "a pretty woman");

		persons.add(person1);
		persons.add(person2);
		persons.add(person3);
		persons.add(person4);
		persons.add(person5);

		dbMgr.add(persons);
	}

	public void update(View view) {
		Person person = new Person();
		person.setName("Jane");
		person.setAge(30);
		dbMgr.updateAge(person);
	}

	public void delete(View view) {
		Person person = new Person();
		person.setAge(30);
		dbMgr.deleteOldPerson(person);
	}

	public void query(View view) {
		List<Person> persons = dbMgr.query();
		ArrayList<Map<String, String>> list = new ArrayList<Map<String, String>>();
		for (Person person : persons) {
			HashMap<String, String> hashMap = new HashMap<String, String>();
			hashMap.put("name", person.getName());
			hashMap.put("info", person.getAge() + " years old," + person.getInfo());
			list.add(hashMap);
		}
		SimpleAdapter simpleAdapter = new SimpleAdapter(this, list, android.R.layout.simple_list_item_2, new String[] { "name", "info" }, new int[] {
				android.R.id.text1, android.R.id.text2 });
		listView.setAdapter(simpleAdapter);
	}

	@SuppressWarnings("deprecation")
	public void queryTheCursor(View view) {
		Cursor c = dbMgr.queryTheCursor();
		startManagingCursor(c); // 托付给activity根据自己的生命周期去管理Cursor的生命周期
		Log.e(Tag, "mark1,row num:" + c.getCount());
		CursorWrapper cursorWrapper = new CursorWrapper(c) {
			public String getString(int columnIndex) {
				if (getColumnName(columnIndex).equals("info")) {
					int age = getInt(getColumnIndex("age"));
					return age + " years old," + super.getString(R.id.lv_sql_list);
				}
				return super.getString(columnIndex);
			};
		};
		Log.e(Tag, "mark2");
		SimpleCursorAdapter adapter = new SimpleCursorAdapter(this, android.R.layout.simple_list_item_2, cursorWrapper, new String[] { "name", "info" }, new int[] {
				android.R.id.text1, android.R.id.text2 });
		ListView listView = (ListView) this.findViewById(R.id.lv_sql_list);
		Log.e(Tag, "mark3");
		listView.setAdapter(adapter);
	}

}
