package my.project.weather;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.TextView;
import android.widget.Toast;
import cn.com.weather.api.Weather;
import cn.com.weather.api.WeatherAsyncTask;
import cn.com.weather.constants.Constants.Language;

public class MainActivity extends Activity {

	private TextView text_weather;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		text_weather = (TextView) findViewById(R.id.text_weather);
		Language language = Language.ZH_CN;
		new WeatherAsyncTask(this) {

			@Override
			protected void onPostExecute(Weather arg0) {
				if (arg0 != null) {
					text_weather.setText(arg0.getWeatherText().toString());
				} else {
					Toast.makeText(MainActivity.this, "获取失败...",
							Toast.LENGTH_SHORT).show();
				}
			}
		}.execute("101010100", language);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
