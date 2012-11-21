package com.canefaitrien.spacetrader;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.canefaitrien.spacetrader.dao.DaoMaster;
import com.canefaitrien.spacetrader.dao.DaoMaster.DevOpenHelper;

public class LauncherActivity extends Activity {
	private static final String TAG = "Launcher";
	
	/**
	 * open the database when application starts
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		// do something for app

		DevOpenHelper helper = new DaoMaster.DevOpenHelper(this,
				"spacetrader-db", null);
		SpaceTrader.db = helper.getWritableDatabase();
		SpaceTrader.daoMaster = new DaoMaster(SpaceTrader.db);
		SpaceTrader.daoSession = SpaceTrader.daoMaster.newSession();

		Intent intent = new Intent(LauncherActivity.this,
				MainMenuActivity.class);
		startActivity(intent);
		Log.d(TAG, "open database");
		finish();
	}
}
