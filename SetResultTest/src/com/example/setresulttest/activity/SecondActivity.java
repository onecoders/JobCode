package com.example.setresulttest.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.example.setresulttest.F;
import com.example.setresulttest.R;
import com.example.setresulttest.model.AlipayInfo;
import com.example.setresulttest.model.AlipayInfoJson;
import com.example.setresulttest.model.AlipayInfoParcelable;
import com.example.setresulttest.model.AlipayInfoSerializable;
import com.example.setresulttest.model.Keys;
import com.example.setresulttest.model.School;
import com.example.setresulttest.model.SchoolJson;
import com.example.setresulttest.model.SchoolParcelable;
import com.example.setresulttest.model.SchoolSerializable;

public class SecondActivity extends Activity implements OnClickListener {

	private TextView title;
	private Button back;
	private int requestCode;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.act_second);
		init();
	}

	private void init() {
		String[] titles = getResources().getStringArray(R.array.activity_title);
		requestCode = getIntent().getIntExtra(F.REQUEST_CODE, 0);
		title = (TextView) findViewById(R.id.title);
		title.setText(titles[requestCode]);
		back = (Button) findViewById(R.id.back);
		back.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		if (v.getId() == R.id.back) {
			Intent intent = new Intent();
			if (requestCode == F.RequestCode.ACT_JSON
					|| requestCode == F.RequestCode.ACT_PARCELABLE) {
				School school = initSchool();
				if (school instanceof SchoolJson) {
					intent.putExtra(F.KEY_SCHOOL, F.toJson(school));
				} else if (school instanceof SchoolParcelable) {
					intent.putExtra(F.KEY_SCHOOL, (SchoolParcelable) school);
				}
			} else {
				SchoolSerializable school = initSchoolSerializable();
				intent.putExtra(F.KEY_SCHOOL, school);
			}
			setResult(RESULT_OK, intent);
			finish();
		}
	}

	private School initSchool() {
		AlipayInfo alipayInfo = new AlipayInfoJson();
		School school = new SchoolJson();
		String flag = "Json";
		if (requestCode == F.RequestCode.ACT_PARCELABLE) {
			alipayInfo = new AlipayInfoParcelable();
			school = new SchoolParcelable();
			flag = "Parcelable";
		}
		alipayInfo.setPartnerId(Keys.DEFAULT_PARTNER);
		alipayInfo.setSellerAccount(Keys.DEFAULT_SELLER);
		alipayInfo.setPrivateKey(Keys.PRIVATE);
		school.setId(101025);
		school.setName(flag + "学校");
		school.setIcon(flag + "图片");
		school.setAlipayInfo(alipayInfo);
		return school;
	}

	private SchoolSerializable initSchoolSerializable() {
		AlipayInfoSerializable alipayInfo = new AlipayInfoSerializable();
		SchoolSerializable school = new SchoolSerializable();
		String flag = "Serializable";
		alipayInfo.setPartnerId(Keys.DEFAULT_PARTNER);
		alipayInfo.setSellerAccount(Keys.DEFAULT_SELLER);
		alipayInfo.setPrivateKey(Keys.PRIVATE);
		school.setId(101025);
		school.setName(flag + "学校");
		school.setIcon(flag + "图片");
		school.setAlipayInfo(alipayInfo);
		return school;
	}
}
