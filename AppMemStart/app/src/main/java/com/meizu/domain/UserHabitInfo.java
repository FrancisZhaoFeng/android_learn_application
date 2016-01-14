package com.meizu.domain;

import java.io.Serializable;
import java.util.List;

/**
 * Created by zhaoguofeng on 2016/1/12.
 */
public class UserHabitInfo implements Serializable{
    private int appNum;
    private int activityNum;
    private int timeNum;
    private List<String> memData;
    private List<String> appData; //保存包名

    public UserHabitInfo(int appNum, int activityNum ,int timeNum, List<String> memData, List<String> appData) {
        this.appNum = appNum;
        this.activityNum = activityNum;
        this.timeNum = timeNum;
        this.memData = memData;
        this.appData = appData;
    }

    public int getAppNum() {
        return appNum;
    }

    public void setAppNum(int appNum) {
        this.appNum = appNum;
    }

    public int getActivityNum() {
        return activityNum;
    }

    public void setActivityNum(int activityNum) {
        this.activityNum = activityNum;
    }

    public List<String> getMemData() {
        return memData;
    }

    public void setMemData(List<String> memData) {
        this.memData = memData;
    }

    public int getTimeNum() {
        return timeNum;
    }

    public void setTimeNum(int timeNum) {
        this.timeNum = timeNum;
    }

    public List<String> getAppData() {
        return appData;
    }

    public void setAppData(List<String> appData) {
        this.appData = appData;
    }

    @Override
    public String toString() {
        return "UserHabitInfo{" +
                "appNum=" + appNum +
                ", activityNum=" + activityNum +
                ", timeNum=" + timeNum +
                ", memData=" + memData +
                ", exeAppData=" + appData +
                '}';
    }
}
