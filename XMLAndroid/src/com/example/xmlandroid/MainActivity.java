package com.example.xmlandroid;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Vector;

import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.widget.TextView;

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
			// config client
			XmlRpcClientConfigImpl config = new XmlRpcClientConfigImpl();
			config.setServerURL(new URL(url)); // should
												// be
												// modified
												// according
												// to
												// your
												// configuration
												// of
												// jsp
												// container
			// create a new XmlRpcClient object and bind above config object
			// with it
			XmlRpcClient client = new XmlRpcClient();
			client.setConfig(config);
			// create parameter list
			Vector<String> params = new Vector<String>();
			params.addElement("111");
			params.addElement("liubin");
			// execute XML-RPC call
			HashMap<String, String> result = (HashMap<String, String>) client
					.execute("query", params);
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
		} catch (MalformedURLException e) {
			System.out.println(e.toString());
		} catch (XmlRpcException e) {
			System.out.println(e.toString());
		} catch (IOException e) {
			e.printStackTrace();
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
