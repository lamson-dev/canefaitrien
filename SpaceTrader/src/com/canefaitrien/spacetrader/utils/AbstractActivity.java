package com.canefaitrien.spacetrader.utils;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.os.Bundle;

public abstract class AbstractActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

		// Make sure we're running on Honeycomb or higher to use ActionBar APIs
		// if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
		// For the main activity, make sure the app icon in the action bar
		// does not behave as a button
		// ActionBar actionBar = getActionBar();
		// actionBar.setDisplayHomeAsUpEnabled(true);
		// actionBar.setHomeButtonEnabled(false);
		// getActionBar().setDisplayHomeAsUpEnabled(true);
		// }
	}
}
