package com.example.androidsqlite;

public class Person {
	private int id;
	private String name;
	private int age;
	private String info;

	public Person() {
		// TODO Auto-generated constructor stub
	}

	public Person(String name, int age, String info) {
		// TODO Auto-generated constructor stub
		this.name = name;
		this.age = age;
		this.info = info;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public String getInfo() {
		return info;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setInfo(String info) {
		this.info = info;
	}

}
