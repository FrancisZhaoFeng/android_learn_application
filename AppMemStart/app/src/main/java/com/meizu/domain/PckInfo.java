package com.meizu.domain;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;

public class PckInfo implements Parcelable {
	private String packageName;
	private String desktopName;
	private String versionName;
	private Drawable icon;
	private Intent intent;

	public PckInfo() {
		// TODO Auto-generated constructor stub
	}

	public PckInfo(Parcel parcel) {
		packageName = parcel.readString();
		desktopName = parcel.readString();
		versionName = parcel.readString();
	}

	public PckInfo(String packageName, String desktopName, String versionName, Intent intent) {
		this.packageName = packageName;
		this.desktopName = desktopName;
		this.versionName = versionName;
		this.intent = intent;
	}

	public PckInfo(String packageName, String desktopName, String versionName, Drawable icon, Intent intent) {
		super();
		this.packageName = packageName;
		this.desktopName = desktopName;
		this.versionName = versionName;
		this.icon = icon;
		this.intent = intent;
	}

	public String getPackageName() {
		return packageName;
	}

	public String getDesktopName() {
		return desktopName;
	}

	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}

	public void setDesktopName(String desktopName) {
		this.desktopName = desktopName;
	}

	public String getVersionName() {
		return versionName;
	}

	public Drawable getIcon() {
		return icon;
	}

	public void setVersionName(String versionName) {
		this.versionName = versionName;
	}

	public void setIcon(Drawable icon) {
		this.icon = icon;
	}

	public Intent getIntent() {
		return intent;
	}

	public void setIntent(Intent intent) {
		this.intent = intent;
	}

	@Override
	public String toString() {
		return "PaInfo [packageName=" + packageName + ", desktopName=" + desktopName + ", versionName=" + versionName + "]";
	}

	@Override
	public int describeContents() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void writeToParcel(Parcel parcel, int flag) {
		// TODO Auto-generated method stub
		parcel.writeString(packageName);
		parcel.writeString(desktopName);
		parcel.writeString(versionName);
	}

	public static final Creator<PckInfo> CREATOR = new Creator<PckInfo>() {
		@Override
		public PckInfo createFromParcel(Parcel parcel) {
			return new PckInfo(parcel);
		}

		@Override
		public PckInfo[] newArray(int size) {
			return new PckInfo[size];
		}
	};
}
