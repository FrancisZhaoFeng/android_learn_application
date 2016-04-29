package com.meizu.apptest.beans;

import org.litepal.crud.DataSupport;

/**
 * Created by zhaoguofeng on 2016/3/18.
 */
public class UserHabitBean extends DataSupport {
    private int count;
    private int monkeyRunTime;
    private Boolean isNeedMonkey;
    private String filePath;

    public UserHabitBean(){

    }

    public UserHabitBean(int count, int monkeyRunTime, Boolean isNeedMonkey, String filePath) {
        this.count = count;
        this.monkeyRunTime = monkeyRunTime;
        this.isNeedMonkey = isNeedMonkey;
        this.filePath = filePath;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getMonkeyRunTime() {
        return monkeyRunTime;
    }

    public void setMonkeyRunTime(int monkeyRunTime) {
        this.monkeyRunTime = monkeyRunTime;
    }

    public Boolean getIsNeedMonkey() {
        return isNeedMonkey;
    }

    public void setIsNeedMonkey(Boolean isNeedMonkey) {
        this.isNeedMonkey = isNeedMonkey;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public String toString() {
        return "UserHabitBean{" +
                "count=" + count +
                ", monkeyRunTime=" + monkeyRunTime +
                ", isNeedMonkey=" + isNeedMonkey +
                ", filePath='" + filePath + '\'' +
                '}';
    }
}
