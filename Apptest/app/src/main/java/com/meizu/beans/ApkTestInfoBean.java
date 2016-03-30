package com.meizu.beans;

import org.litepal.annotation.Column;
import org.litepal.crud.DataSupport;

/**
 * Created by zhaoguofeng on 2016/3/17.
 */
public class ApkTestInfoBean extends DataSupport implements Comparable<ApkTestInfoBean> {
    @Column(unique = true)
    private int sn;
    @Column(unique = true)
    private String packageName;
    private String apkVersion;
    private String fileName;
    private String status;

    public ApkTestInfoBean() {

    }

    public ApkTestInfoBean(int sn, String packageName, String apkVersion, String fileName) {
        this.fileName = fileName;
        this.sn = sn;
        this.packageName = packageName;
        this.apkVersion = apkVersion;
    }

    public ApkTestInfoBean(int sn, String packageName, String apkVersion, String fileName, String status) {
        this.sn = sn;
        this.packageName = packageName;
        this.apkVersion = apkVersion;
        this.fileName = fileName;
        this.status = status;
    }

    public Integer getSn() {
        return sn;
    }

    public void setSn(int sn) {
        this.sn = sn;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public String getApkVersion() {
        return apkVersion;
    }

    public void setApkVersion(String apkVersion) {
        this.apkVersion = apkVersion;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getStatus() {
        return status;
    }

    public ApkTestInfoBean setStatus(String status) {
        this.status = status;
        return this;
    }

    @Override
    public String toString() {
        return "ApkTestInfoBean{" +
                "sn='" + sn + '\'' +
                ", packageName='" + packageName + '\'' +
                ", apkVersion='" + apkVersion + '\'' +
                ", fileName='" + fileName + '\'' +
                ", status='" + status + '\'' +
                '}';
    }

    @Override
    public int compareTo(ApkTestInfoBean arg0) {
        // TODO Auto-generated method stub
        return this.getSn().compareTo(arg0.getSn());
    }

}
