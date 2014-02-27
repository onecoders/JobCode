package com.example.textsizechooser;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener {

	private TextView showText, showSize;
	private Button reduce, crease, little_reduce, little_crease;
	private float text_size = 50.0f;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		showText = (TextView) findViewById(R.id.show_text);
		showSize = (TextView) findViewById(R.id.show_size);
		reduce = (Button) findViewById(R.id.reduce_btn);
		reduce.setOnClickListener(this);
		little_reduce = (Button) findViewById(R.id.little_reduce_btn);
		little_reduce.setOnClickListener(this);
		crease = (Button) findViewById(R.id.crease_btn);
		crease.setOnClickListener(this);
		little_crease = (Button) findViewById(R.id.little_crease_btn);
		little_crease.setOnClickListener(this);
		update(text_size);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		if (item.getItemId() == R.id.action_settings) {
			startActivity(new Intent(this, PX2SPActivity.class));
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onClick(View v) {
		int id = v.getId();
		switch (v.getId()) {
		case R.id.reduce_btn:
		case R.id.little_reduce_btn:
			if (text_size <= 12) {
				Toast.makeText(this, R.string.min_text_size_hint,
						Toast.LENGTH_SHORT).show();
				return;
			}
			text_size = text_size - (id == R.id.reduce_btn ? 1 : 0.1f);
			update(text_size);
			break;
		case R.id.crease_btn:
		case R.id.little_crease_btn:
			if (text_size >= 50) {
				Toast.makeText(this, R.string.max_text_size_hint,
						Toast.LENGTH_SHORT).show();
				return;
			}
			text_size = text_size + (id == R.id.crease_btn ? 1 : 0.1f);
			update(text_size);
			break;
		default:
			break;
		}
	}

	private void update(float size) {
		showText.setTextSize(size);
		showSize.setText("当前text size为：" + size + " sp");
	}

}
