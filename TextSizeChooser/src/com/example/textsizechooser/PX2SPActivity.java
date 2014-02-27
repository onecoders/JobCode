package com.example.textsizechooser;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class PX2SPActivity extends Activity implements OnClickListener {

	private EditText edit_px;
	private TextView text_sp, text_show;
	private Button btn_convert;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.act_px2sp);
		edit_px = (EditText) findViewById(R.id.edit_px);
		text_sp = (TextView) findViewById(R.id.text_sp);
		text_show = (TextView) findViewById(R.id.text_show);
		btn_convert = (Button) findViewById(R.id.btn_convert);
		btn_convert.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		if (v.getId() == R.id.btn_convert) {
			String pxStr = edit_px.getText().toString().trim();
			if (TextUtils.isEmpty(pxStr)) {
				Toast.makeText(this, R.string.invalid_px_value,
						Toast.LENGTH_SHORT).show();
			} else {
				float pxValue = Float.valueOf(pxStr);
				int spValue = px2sp(pxValue);
				text_sp.setText("对应的值为：" + spValue + "sp");
				text_show.setTextSize(spValue);
			}
		}
	}

	public int px2sp(float pxValue) {
		final float fontScale = getResources().getDisplayMetrics().scaledDensity;
		return (int) (pxValue / fontScale + 0.5f);
	}

}
