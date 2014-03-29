package com.example.setresulttest.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.example.setresulttest.F;
import com.example.setresulttest.F.RequestCode;
import com.example.setresulttest.R;
import com.example.setresulttest.model.School;
import com.example.setresulttest.model.SchoolJson;
import com.example.setresulttest.model.SchoolSerializable;

public class MainActivity extends Activity implements OnClickListener {

	private Button go2JsonActivity, go2SerializableActivity,
			go2ParcelableActivity;
	private TextView detail;
	private School school;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		init();
	}

	private void init() {
		findView();
		setListener();
	}

	private void findView() {
		go2JsonActivity = (Button) findViewById(R.id.go2JsonActivity);
		go2SerializableActivity = (Button) findViewById(R.id.go2SerializableActivity);
		go2ParcelableActivity = (Button) findViewById(R.id.go2ParcelableActivity);
		detail = (TextView) findViewById(R.id.detail);
	}

	private void setListener() {
		go2JsonActivity.setOnClickListener(this);
		go2SerializableActivity.setOnClickListener(this);
		go2ParcelableActivity.setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		if (resultCode == RESULT_OK) {
			switch (requestCode) {
			case RequestCode.ACT_JSON:
				school = F.fromJson(data.getStringExtra(F.KEY_SCHOOL),
						SchoolJson.class);
				detail.setText(school.toString());
				break;
			case RequestCode.ACT_SERIALIZABLE:
				SchoolSerializable schoolSerializable = (SchoolSerializable) data
						.getSerializableExtra(F.KEY_SCHOOL);
				detail.setText(schoolSerializable.toString());
				break;
			case RequestCode.ACT_PARCELABLE:
				school = data.getParcelableExtra(F.KEY_SCHOOL);
				detail.setText(school.toString());
				break;
			default:
				break;
			}
		}
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.go2JsonActivity:
			switchActivityForResult(RequestCode.ACT_JSON);
			break;
		case R.id.go2SerializableActivity:
			switchActivityForResult(RequestCode.ACT_SERIALIZABLE);
			break;
		case R.id.go2ParcelableActivity:
			switchActivityForResult(RequestCode.ACT_PARCELABLE);
			break;
		default:
			break;
		}
	}

	private void switchActivityForResult(int requestCode) {
		Intent intent = new Intent(this, SecondActivity.class);
		intent.putExtra(F.REQUEST_CODE, requestCode);
		startActivityForResult(intent, requestCode);
	}

}
