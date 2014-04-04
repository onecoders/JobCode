package com.example.xmlrpcandroid;

import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.widget.TextView;
import de.timroes.axmlrpc.XMLRPCClient;
import de.timroes.axmlrpc.XMLRPCException;
import de.timroes.axmlrpc.XMLRPCServerException;

public class MainActivity extends Activity {

	private TextView test;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		test = (TextView) findViewById(R.id.test);
		new XMLTask().execute("http://58.241.60.41:8002/api");
	}

	class XMLTask extends AsyncTask<String, Void, String> {

		@Override
		protected String doInBackground(String... params) {
			return test(params[0]);
		}

		@Override
		protected void onPostExecute(String result) {
			super.onPostExecute(result);
			test.setText(result);
		}

	}

	private String test(String url) {
		try {
			XMLRPCClient client = new XMLRPCClient(new URL(url));
			HashMap<String, String> result = (HashMap<String, String>) client
					.call("query", "111", "liubin");
			System.out.println(result.size());
			Iterator it = result.entrySet().iterator();
			StringBuilder sb = new StringBuilder();
			while (it.hasNext()) {
				Map.Entry entry = (Map.Entry) it.next();
				Object key = entry.getKey();
				Object val = entry.getValue();
				sb.append("key:" + key + "-->value:" + val);
				System.out.println("key:" + key + "-->value:" + val);
			}
			return sb.toString();
		} catch (XMLRPCServerException ex) {
			// The server throw an error.
		} catch (XMLRPCException ex) {
			// An error occured in the client.
		} catch (Exception ex) {
			// Any other exception
		}
		return null;
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
