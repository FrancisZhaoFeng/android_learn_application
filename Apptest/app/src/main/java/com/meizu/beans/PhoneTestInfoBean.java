package com.meizu.beans;

import com.meizu.common.Constant;

import java.util.List;
import java.util.Map;

/**
 * Created by zhaoguofeng on 2016/3/17.
 */
public class PhoneTestInfoBean {

    String model = Constant.model;
    String Date = Constant.data;
    String version = Constant.version;
    int totalNum = 0;

    Map<String,List<ApkTestInfoBean>> allListMap;

    public PhoneTestInfoBean() {

    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public int getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(int totalNum) {
        this.totalNum = totalNum;
    }

    public Map<String, List<ApkTestInfoBean>> getAllListMap() {
        return allListMap;
    }

    public void setAllListMap(Map<String, List<ApkTestInfoBean>> allListMap) {
        this.allListMap = allListMap;
    }

    @Override
    public String toString() {
        return "PhoneTestInfoBean{" +
                ", totalNum=" + totalNum +
                '}';
    }
}
