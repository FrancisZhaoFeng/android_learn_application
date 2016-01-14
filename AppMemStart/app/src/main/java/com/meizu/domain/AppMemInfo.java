package com.meizu.domain;

import android.os.Debug;

import java.io.Serializable;

public class AppMemInfo implements Serializable, Comparable<AppMemInfo> {
	private String TAG = "AppMemInfo";
	/**
	 *
	 */
	private static final long serialVersionUID = 597713317308012983L;
	private String packageName;

	private int native_Heap;
	private int dalvik_Heap;
	private int dalvik_Other;
	private int stack;
	private int other_Dev;
	private int so_Mmap;
	private int jar_Mmap;
	private int apk_Mmap;
	private int ttf_Mmap;
	private int dex_Mmap;
	private int oat_Mmap;
	private int art_Mmap;
	private int other_Mmap;
	private int unknown;
	private int total;

	private  int views;
	private  int viewRootImple;
	private  int appContexts;
	private  int Activities;
	private  int assets;
	private  int assetManagers;
	private  int locak_Binders;
	private  int proxy_Binders;
	private  int parcel_Memory;
	private  int parcel_Count;
	private  int death_Recipients;
	private  int openssl_Sockets;

	private int other;
	private int pid;


	public AppMemInfo() {
		// TODO Auto-generated constructor stub
	}

	public AppMemInfo(Debug.MemoryInfo memoryInfo, int pid, String packageName) {
		this.native_Heap = memoryInfo.nativePss;
		this.dalvik_Heap = memoryInfo.dalvikPss;
		this.total = memoryInfo.getTotalPss();
		this.other = memoryInfo.otherPss;
		this.pid = pid;
		this.packageName = packageName;
	}

	public AppMemInfo(int native_Heap, int dalvik_Heap, int total, int other, int pid, String packageName) {
		// TODO Auto-generated constructor stub
		this.native_Heap = native_Heap;
		this.dalvik_Heap = dalvik_Heap;
		this.total = total;
		this.other = other;
		this.pid = pid;
		this.packageName = packageName;
	}

	public AppMemInfo(int native_Heap, int dalvik_Heap, int dalvik_Other, int stack, int other_Dev, int so_Mmap, int jar_Mmap, int apk_Mmap, int ttf_Mmap, int dex_Mmap,
					  int oat_Mmap, int art_Mmap, int other_Mmap, int unknown, int total, int pid, String packageName) {
		super();
		this.native_Heap = native_Heap;
		this.dalvik_Heap = dalvik_Heap;
		this.dalvik_Other = dalvik_Other;
		this.stack = stack;
		this.other_Dev = other_Dev;
		this.so_Mmap = so_Mmap;
		this.jar_Mmap = jar_Mmap;
		this.apk_Mmap = apk_Mmap;
		this.ttf_Mmap = ttf_Mmap;
		this.dex_Mmap = dex_Mmap;
		this.oat_Mmap = oat_Mmap;
		this.art_Mmap = art_Mmap;
		this.other_Mmap = other_Mmap;
		this.unknown = unknown;
		this.total = total;
		this.pid = pid;
		this.packageName = packageName;
	}



	public void reset() {
		this.native_Heap = 0;
		this.dalvik_Heap = 0;
		this.total = 0;
		this.other = 0;
	}

	public int getNative_Heap() {
		return native_Heap;
	}

	public int getDalvik_Heap() {
		return dalvik_Heap;
	}

	public int getTotal() {
		return total;
	}

	public int getOther() {
		return other;
	}

	public void setNative_Heap(int native_Heap) {
		this.native_Heap = native_Heap;
	}

	public void setDalvik_Heap(int dalvik_Heap) {
		this.dalvik_Heap = dalvik_Heap;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public void setOther(int other) {
		this.other = other;
	}

	public int getPid() {
		return pid;
	}

	public String getPackageName() {
		return packageName;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}


	public int getDalvik_Other() {
		return dalvik_Other;
	}

	public int getStack() {
		return stack;
	}

	public int getOther_Dev() {
		return other_Dev;
	}

	public int getSo_Mmap() {
		return so_Mmap;
	}

	public int getJar_Mmap() {
		return jar_Mmap;
	}

	public int getApk_Mmap() {
		return apk_Mmap;
	}

	public int getTtf_Mmap() {
		return ttf_Mmap;
	}

	public int getDex_Mmap() {
		return dex_Mmap;
	}

	public int getOat_Mmap() {
		return oat_Mmap;
	}

	public int getArt_Mmap() {
		return art_Mmap;
	}

	public int getOther_Mmap() {
		return other_Mmap;
	}

	public int getUnknown() {
		return unknown;
	}

	public void setDalvik_Other(int dalvik_Other) {
		this.dalvik_Other = dalvik_Other;
	}

	public void setStack(int stack) {
		this.stack = stack;
	}

	public void setOther_Dev(int other_Dev) {
		this.other_Dev = other_Dev;
	}

	public void setSo_Mmap(int so_Mmap) {
		this.so_Mmap = so_Mmap;
	}

	public void setJar_Mmap(int jar_Mmap) {
		this.jar_Mmap = jar_Mmap;
	}

	public void setApk_Mmap(int apk_Mmap) {
		this.apk_Mmap = apk_Mmap;
	}

	public void setTtf_Mmap(int ttf_Mmap) {
		this.ttf_Mmap = ttf_Mmap;
	}

	public void setDex_Mmap(int dex_Mmap) {
		this.dex_Mmap = dex_Mmap;
	}

	public void setOat_Mmap(int oat_Mmap) {
		this.oat_Mmap = oat_Mmap;
	}

	public void setArt_Mmap(int art_Mmap) {
		this.art_Mmap = art_Mmap;
	}

	public void setOther_Mmap(int other_Mmap) {
		this.other_Mmap = other_Mmap;
	}

	public void setUnknown(int unknown) {
		this.unknown = unknown;
	}

	public int getViews() {
		return views;
	}

	public void setViews(int views) {
		this.views = views;
	}

	public int getViewRootImple() {
		return viewRootImple;
	}

	public void setViewRootImple(int viewRootImple) {
		this.viewRootImple = viewRootImple;
	}

	public int getAppContexts() {
		return appContexts;
	}

	public void setAppContexts(int appContexts) {
		this.appContexts = appContexts;
	}

	public int getActivities() {
		return Activities;
	}

	public void setActivities(int activities) {
		Activities = activities;
	}

	public int getAssets() {
		return assets;
	}

	public void setAssets(int assets) {
		this.assets = assets;
	}

	public int getAssetManagers() {
		return assetManagers;
	}

	public void setAssetManagers(int assetManagers) {
		this.assetManagers = assetManagers;
	}

	public int getLocak_Binders() {
		return locak_Binders;
	}

	public void setLocak_Binders(int locak_Binders) {
		this.locak_Binders = locak_Binders;
	}

	public int getProxy_Binders() {
		return proxy_Binders;
	}

	public void setProxy_Binders(int proxy_Binders) {
		this.proxy_Binders = proxy_Binders;
	}

	public int getParcel_Memory() {
		return parcel_Memory;
	}

	public void setParcel_Memory(int parcel_Memory) {
		this.parcel_Memory = parcel_Memory;
	}

	public int getParcel_Count() {
		return parcel_Count;
	}

	public void setParcel_Count(int parcel_Count) {
		this.parcel_Count = parcel_Count;
	}

	public int getDeath_Recipients() {
		return death_Recipients;
	}

	public void setDeath_Recipients(int death_Recipients) {
		this.death_Recipients = death_Recipients;
	}

	public int getOpenssl_Sockets() {
		return openssl_Sockets;
	}

	public void setOpenssl_Sockets(int openssl_Sockets) {
		this.openssl_Sockets = openssl_Sockets;
	}

	public String toStringSimple() {
		return "AppMeminfo [packageName=" + packageName + ", native_Heap=" + native_Heap + ", dalvik_Heap=" + dalvik_Heap + ", total=" + total + ", pid="
				+ pid + ", other=" + other + "]";
	}

	@Override
	public String toString() {
		return "AppMemInfo{" +
				"packageName='" + packageName + '\'' +
				", native_Heap=" + native_Heap +
				", dalvik_Heap=" + dalvik_Heap +
				", dalvik_Other=" + dalvik_Other +
				", stack=" + stack +
				", other_Dev=" + other_Dev +
				", so_Mmap=" + so_Mmap +
				", jar_Mmap=" + jar_Mmap +
				", apk_Mmap=" + apk_Mmap +
				", ttf_Mmap=" + ttf_Mmap +
				", dex_Mmap=" + dex_Mmap +
				", oat_Mmap=" + oat_Mmap +
				", art_Mmap=" + art_Mmap +
				", other_Mmap=" + other_Mmap +
				", unknown=" + unknown +
				", total=" + total +
				", views=" + views +
				", viewRootImple=" + viewRootImple +
				", appContexts=" + appContexts +
				", Activities=" + Activities +
				", assets=" + assets +
				", assetManagers=" + assetManagers +
				", locak_Binders=" + locak_Binders +
				", proxy_Binders=" + proxy_Binders +
				", parcel_Memory=" + parcel_Memory +
				", parcel_Count=" + parcel_Count +
				", death_Recipients=" + death_Recipients +
				", openssl_Sockets=" + openssl_Sockets +
				'}';
	}

	@Override
	public int compareTo(AppMemInfo appMemInfo) {
		// TODO Auto-generated method stub
		return this.getPackageName().compareTo(appMemInfo.getPackageName());
	}
}
