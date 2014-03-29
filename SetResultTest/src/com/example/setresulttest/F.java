package com.example.setresulttest;

import android.content.Context;

import com.google.gson.Gson;

public class F {

	public static final String KEY_SCHOOL = "key_school";

	public static final String REQUEST_CODE = "request_code";

	public static class RequestCode {

		public static final int ACT_JSON = 0;

		public static final int ACT_SERIALIZABLE = 1;

		public static final int ACT_PARCELABLE = 2;

	}

	private static Gson mGson;

	public static void init(Context context) {
		mGson = new Gson();
	}

	public static String toJson(Object src) {
		return mGson.toJson(src);
	}

	public static <T> T fromJson(String json, Class<T> classOfT) {
		return mGson.fromJson(json, classOfT);
	}

}
