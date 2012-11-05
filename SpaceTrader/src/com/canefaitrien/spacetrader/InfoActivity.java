package com.canefaitrien.spacetrader;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.canefaitrien.spacetrader.models.Controller;

public class InfoActivity extends Activity {

	private static final String TAG = "Info";

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_info);

		TextView tv = (TextView) findViewById(R.id.tv_info_content);
		tv.setTextSize(20);

		Controller data = SpaceTraderApplication.getData();

		Log.d(TAG, "loaded data");
		String info = data.getPlayer().toString();

		Log.d(TAG,"loaded info");
		
		tv.setText(info);
	}

}
