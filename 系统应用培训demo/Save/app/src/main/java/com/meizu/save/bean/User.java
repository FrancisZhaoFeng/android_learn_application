package com.meizu.save.bean;

import org.litepal.annotation.Column;
import org.litepal.crud.DataSupport;

/**
 * 使用litepal需要继承DataSupport
 * Created by zhaoguofeng on 2017/1/10.
 */
public class User extends DataSupport {
    @Column(unique = true)
    private String name;
    private int age;
    private String email;

    public User() {
    }

    public User(String name, int age, String email) {
        this.age = age;
        this.email = email;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                '}';
    }
}
