package com.meizu.domain;

import com.meizu.common.Contants;

import java.io.Serializable;
import java.util.Map;

/**
 * Created by zhaoguofeng on 2016/1/12.
 */
public class AppMemMapInfo implements Serializable, Comparable<AppMemMapInfo>{
    private String packageName;
    private Map<String,Integer> mapData;

    public AppMemMapInfo(){

    }

    public AppMemMapInfo(String packageName, Map<String, Integer> mapData) {
        this.packageName = packageName;
        this.mapData = mapData;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public Map<String, Integer> getMapData() {
        return mapData;
    }

    public void setMapData(Map<String, Integer> mapData) {
        this.mapData = mapData;
    }

    @Override
    public String toString() {
        return "AppMemMapInfo{" +
                "packageName='" + packageName + '\'' +
                ", Native Heap=" + mapData.get(Contants.dumpElement[0]) +
                ", Dalvik Heap=" + mapData.get(Contants.dumpElement[1]) +
                ", TOTAL=" + mapData.get(Contants.dumpElement[16]) +
                '}';
    }

    @Override
    public int compareTo(AppMemMapInfo appMemMapInfo) {
        // TODO Auto-generated method stub
        return this.getPackageName().compareTo(appMemMapInfo.getPackageName());
    }
}
