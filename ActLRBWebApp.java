package com.guangdian.smartclient.phone;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ab.activity.AbActivity;
import com.ab.util.AbMd5;
import com.guangdian.smartclient.constant.BaseConfig;
import com.guangdian.smartclient.myview.HTML5WebView;

/**
 * web app activity
 * 
 */

public class ActLRBWebApp extends AbActivity implements OnClickListener {

	private HTML5WebView mWebView;
	private LinearLayout webViewContainer;

	private String url;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_lrb_web_app);
		init();
	}

	private void init() {
		setTitleBar();
		initUrl();
		initHTML5WebView();
		loadUrl();
	}

	private void setTitleBar() {
		View actionbar = findViewById(R.id.lrb_web_titlebar);
		Button titlebar_left = (Button) actionbar
				.findViewById(R.id.titlebar_left);
		titlebar_left.setOnClickListener(this);
		titlebar_left.setVisibility(View.VISIBLE);
		TextView titlebar_name = (TextView) actionbar
				.findViewById(R.id.titlebar_name);
		titlebar_name.setText(R.string.web_app_lanrenbang_title);
		titlebar_name.setVisibility(View.VISIBLE);
	}

	public void onClick(View v) {
		if (v.getId() == R.id.titlebar_left) {
			finish();
		}
	}

	private void initUrl() {
		url = "http://lanren.taocz.com/www/index.html";
		boolean isLogin = BaseConfig.gdLogin != null;
		String openId = isLogin ? BaseConfig.gdLogin.getMobile() : "1";
		String validation = isLogin ? AbMd5.MD5(openId + "lanren.taocz.com")
				.toLowerCase() : "1";
		url += "?openId=" + openId;
		url += "&validation=" + validation;
	}

	private void initHTML5WebView() {
		mWebView = new HTML5WebView(this);
		webViewContainer = (LinearLayout) findViewById(R.id.webview_container);
		webViewContainer.addView(mWebView.getLayout(), new LayoutParams(
				LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
	}

	private void loadUrl() {
		mWebView.loadUrl(url);
	}

	@Override
	public void onStop() {
		super.onStop();
		mWebView.stopLoading();
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_BACK) {
			if (mWebView.inCustomView()) {
				mWebView.hideCustomView();
				return true;
			}
		}
		return super.onKeyDown(keyCode, event);
	}

}
