package com.canefaitrien.spacetrader;

import android.app.TabActivity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

import com.canefaitrien.spacetrader.models.Controller;
import com.canefaitrien.spacetrader.models.Controller.Difficulty;
import com.canefaitrien.spacetrader.models.Person;
import com.canefaitrien.spacetrader.models.Planet;
import com.canefaitrien.spacetrader.models.Ship;
import com.canefaitrien.spacetrader.models.Universe;
import com.canefaitrien.spacetrader.utils.DbAdapter;

@SuppressWarnings("deprecation")
public class MainScreenActivity extends TabActivity {

	private static final String TAG = "MainScreen";

	// This is the Adapter being used to display the list's data
	private DbAdapter mDbHelper;
	private Long mRowId;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_mainscreen);

		init(savedInstanceState);

		// need to put this method in presenter
		loadGame(savedInstanceState);

	}

	private void init(Bundle savedInstanceState) {

		mDbHelper = new DbAdapter(this);

		TabHost tabhost = getTabHost();

		addTab("Map", GalaxyMapActivity.class, tabhost);
		addTab("Info", InfoActivity.class, tabhost);
		addTab("Market", MarketPlaceActivity.class, tabhost);
		addTab("Hub", HubActivity.class, tabhost);
//		tabhost.setCurrentTab(3);
	}

	private void addTab(String tag, Class<?> c, TabHost th) {
		TabSpec spec = th.newTabSpec(tag);
		// specs.setIndicator("Market",R.drawable.tab_market);
		spec.setIndicator(tag);
		Intent intent = new Intent(MainScreenActivity.this, c);
		spec.setContent(intent);
		th.addTab(spec);
	}

	private void loadGame(Bundle savedInstanceState) {

		mRowId = (savedInstanceState == null) ? null
				: (Long) savedInstanceState
						.getSerializable(DbAdapter.CHAR_KEY_ROWID);

		if (mRowId == null) {

			Bundle extras = getIntent().getExtras();
			mRowId = extras != null ? extras.getLong(DbAdapter.CHAR_KEY_ROWID)
					: null;
		}

		// for LoadGame
		// populateData();

	}

	private void populateData() {

		if (mRowId == null)
			return;

		mDbHelper.open();

		Log.d(TAG, String.valueOf(mRowId));

		Cursor save = mDbHelper.fetchSave(mRowId);
		startManagingCursor(save);

		String name = save.getString(save
				.getColumnIndexOrThrow(DbAdapter.CHAR_KEY_NAME));
		// String level = save.getString(save
		// .getColumnIndexOrThrow(DbAdapter.CHAR_KEY_DIFFICULTY));
		// String money = save.getString(save
		// .getColumnIndexOrThrow(DbAdapter.CHAR_KEY_MONEY));

		Log.d(TAG, name);

		int engineerPts = Integer.valueOf(save.getString(save
				.getColumnIndexOrThrow(DbAdapter.CHAR_KEY_ENGINEER_PTS)));
		int fighterPts = Integer.valueOf(save.getString(save
				.getColumnIndexOrThrow(DbAdapter.CHAR_KEY_FIGHTER_PTS)));
		int pilotPts = Integer.valueOf(save.getString(save
				.getColumnIndexOrThrow(DbAdapter.CHAR_KEY_PILOT_PTS)));
		int traderPts = Integer.valueOf(save.getString(save
				.getColumnIndexOrThrow(DbAdapter.CHAR_KEY_TRADER_PTS)));

		Person player = new Person(name, pilotPts, fighterPts, traderPts,
				engineerPts);

		Ship ship = null;
		Planet location = null;
		int money = 100;
		//Universe universe = null;
		Planet[] universe = null;
		Difficulty difficulty = null;
		int turn = 1;

		Controller data = new Controller(player, ship, location, money,
				universe, difficulty, turn);
		SpaceTraderApplication.setData(data);

		mDbHelper.close();

	}
	// @Override
	// protected void onPause() {
	// super.onPause();
	// saveState();
	// }
	//
	// @Override
	// protected void onResume() {
	// super.onResume();
	// populateData();
	// }
	//
	// @Override
	// protected void onSaveInstanceState(Bundle outState) {
	// super.onSaveInstanceState(outState);
	// saveState();
	// outState.putSerializable(DbAdapter.CHAR_KEY_ROWID, mRowId);
	// }

	// private void saveState() {
	// String title = mTitleText.getText().toString();
	// String body = mBodyText.getText().toString();
	//
	// if (mRowId == null) {
	// long id = mDbHelper.createNote(title, body);
	// if (id > 0) {
	// mRowId = id;
	// }
	// } else {
	// mDbHelper.updateNote(mRowId, title, body);
	// }
	// }

	// @Override
	// protected void onStart() {
	// super.onStart();
	// Log.d(TAG, "onStart called.");
	// }
	//
	// @Override
	// protected void onPause() {
	// super.onPause();
	// Log.d(TAG, "onPause called.");
	// }
	//
	// @Override
	// protected void onResume() {
	// super.onResume();
	// Log.d(TAG, "onResume called.");
	// }
	//
	// @Override
	// protected void onStop() {
	// super.onStop();
	// Log.d(TAG, "onStop called.");
	// }
	//
	// @Override
	// protected void onRestart() {
	// super.onRestart();
	// Log.d(TAG, "onRestart called.");
	// }
	//
	// @Override
	// protected void onDestroy() {
	// super.onDestroy();
	// }
}
