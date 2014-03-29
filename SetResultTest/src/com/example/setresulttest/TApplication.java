package com.example.setresulttest;

import android.app.Application;

public class TApplication extends Application {

	@Override
	public void onCreate() {
		super.onCreate();
		F.init(getApplicationContext());
	}

}
