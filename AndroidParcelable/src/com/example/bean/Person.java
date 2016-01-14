package com.example.bean;

import android.os.Parcel;
import android.os.Parcelable;

public class Person implements Parcelable {
	private String name;
	private int age;

	public Person(String name, int age) {
		// TODO Auto-generated constructor stub
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public int describeContents() {
		// TODO Auto-generated method stub
		return 0;
	}

	public Person(Parcel parcel) {
		// TODO Auto-generated constructor stub
		name = parcel.readString();
		age = parcel.readInt();
	}

	// 写数据进行保存
	@Override
	public void writeToParcel(Parcel parcel, int flag) {
		// TODO Auto-generated method stub
		parcel.writeString(name);
		parcel.writeInt(age);
	}

	public static final Parcelable.Creator<Person> CREATOR = new Parcelable.Creator<Person>() {

		@Override
		public Person createFromParcel(Parcel source) {
			// TODO Auto-generated method stub
			return new Person(source);
		}

		@Override
		public Person[] newArray(int size) {
			// TODO Auto-generated method stub
			return new Person[size];
		}
	};

}
