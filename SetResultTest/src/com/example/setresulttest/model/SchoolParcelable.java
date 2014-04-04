package com.example.setresulttest.model;

import android.os.Parcel;
import android.os.Parcelable;

public class SchoolParcelable extends School implements Parcelable {

	private AlipayInfoParcelable alipayInfo;

	public SchoolParcelable() {

	}

	public SchoolParcelable(Parcel source) {
		this.id = source.readInt();
		this.name = source.readString();
		this.icon = source.readString();
		this.alipayInfo = source.readParcelable(AlipayInfoParcelable.class
				.getClassLoader());
	}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeInt(this.id);
		dest.writeString(this.name);
		dest.writeString(this.icon);
		dest.writeParcelable(this.alipayInfo, flags);
	}

	public static final Parcelable.Creator<SchoolParcelable> CREATOR = new Creator<SchoolParcelable>() {

		@Override
		public SchoolParcelable createFromParcel(Parcel source) {
			return new SchoolParcelable(source);
		}

		@Override
		public SchoolParcelable[] newArray(int size) {
			return new SchoolParcelable[size];
		}

	};

	@Override
	public AlipayInfo getAlipayInfo() {
		return this.alipayInfo;
	}

	@Override
	public void setAlipayInfo(AlipayInfo alipayInfo) {
		if (alipayInfo instanceof AlipayInfoParcelable) {
			this.alipayInfo = (AlipayInfoParcelable) alipayInfo;
		}
	}

}
