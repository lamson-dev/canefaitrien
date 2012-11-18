package com.canefaitrien.spacetrader;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;

import com.canefaitrien.spacetrader.dao.DaoMaster;
import com.canefaitrien.spacetrader.dao.DaoMaster.DevOpenHelper;
import com.canefaitrien.spacetrader.utils.MusicManager;

public abstract class RootActivity extends Activity {
	private static final String TAG = "Root";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

		// Make sure we're running on Honeycomb or higher to use ActionBar APIs
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
			// For the main activity, make sure the app icon in the action bar
			// does not behave as a button
			// ActionBar actionBar = getActionBar();
			// actionBar.setDisplayHomeAsUpEnabled(true);
			// // actionBar.setHomeButtonEnabled(false);
			// getActionBar().setDisplayHomeAsUpEnabled(true);
			// actionBar.hide();
		}
	}

}
