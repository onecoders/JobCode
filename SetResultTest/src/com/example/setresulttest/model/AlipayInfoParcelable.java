package com.example.setresulttest.model;

import android.os.Parcel;
import android.os.Parcelable;

public class AlipayInfoParcelable extends AlipayInfo implements Parcelable {

	public AlipayInfoParcelable() {
		// default constructor
	}

	public AlipayInfoParcelable(String partnerId, String sellerAccount,
			String privateKey) {
		this.partnerId = partnerId;
		this.sellerAccount = sellerAccount;
		this.privateKey = privateKey;
	}

	public AlipayInfoParcelable(Parcel source) {
		String[] data = new String[3];
		source.readStringArray(data);
		this.partnerId = data[0];
		this.sellerAccount = data[1];
		this.privateKey = data[2];
	}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		String[] data = new String[] { partnerId, sellerAccount, privateKey };
		dest.writeStringArray(data);
	}

	public static final Parcelable.Creator<AlipayInfoParcelable> CREATOR = new Creator<AlipayInfoParcelable>() {

		@Override
		public AlipayInfoParcelable createFromParcel(Parcel source) {
			return new AlipayInfoParcelable(source);
		}

		@Override
		public AlipayInfoParcelable[] newArray(int size) {
			return new AlipayInfoParcelable[size];
		}

	};

}
