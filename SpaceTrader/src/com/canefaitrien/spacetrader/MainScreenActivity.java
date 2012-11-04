package com.canefaitrien.spacetrader;

import android.app.LocalActivityManager;
import android.app.TabActivity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.widget.SimpleCursorAdapter;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;
import android.widget.TextView;

import com.canefaitrien.spacetrader.models.Character;
import com.canefaitrien.spacetrader.models.GameData;
import com.canefaitrien.spacetrader.models.GameData.Difficulty;
import com.canefaitrien.spacetrader.models.Planet;
import com.canefaitrien.spacetrader.models.Ship;
import com.canefaitrien.spacetrader.models.Universe;
import com.canefaitrien.spacetrader.utils.DbAdapter;

@SuppressWarnings("deprecation")
public class MainScreenActivity extends TabActivity {

	// This is the Adapter being used to display the list's data
	SimpleCursorAdapter mAdapter;
	LocalActivityManager mlam;

	private static final String TAG = "MainScreen";
	LayoutInflater inflater;

	private Long mRowId;

	private DbAdapter mDbHelper;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_mainscreen);

		init(savedInstanceState);
		loadGame(savedInstanceState);

	}

	@SuppressWarnings("deprecation")
	private void init(Bundle savedInstanceState) {
		inflater = (LayoutInflater) getApplicationContext().getSystemService(
				Context.LAYOUT_INFLATER_SERVICE);

		// mlam = new LocalActivityManager(this, false);
		// mlam.dispatchCreate(savedInstanceState);

		TabHost tabhost = getTabHost();

		addMapTab(tabhost);
		addInfoTab(tabhost);
		addMarketTab(tabhost);
		addHubTab(tabhost);

		tabhost.setCurrentTab(1);

	}

	private void addMapTab(TabHost th) {
		TabSpec spec = th.newTabSpec("Map");
		// specs.setIndicator("Market",R.drawable.tab_market);
		spec.setIndicator("Map");
		Intent intent = new Intent(MainScreenActivity.this, MapActivity.class);
		spec.setContent(intent);
		th.addTab(spec);
	}

	private void addInfoTab(TabHost th) {
		TabSpec spec = th.newTabSpec("Info");
		spec.setIndicator("Info");
		Intent intent = new Intent(MainScreenActivity.this, InfoActivity.class);
		spec.setContent(intent);
		th.addTab(spec);

		// GameData data = SpaceTraderApplication.getData();
		// String info = data.getPlayer().toString();
		// ViewGroup parentView = (RelativeLayout)
		// findViewById(R.id.tab_info_content);
		//
		// inflater.inflate(R.layout.activity_info, parentView);
		// TextView tv = (TextView) findViewById(R.id.tv_info_content);
		// tv.setText(info);

	}

	private void addMarketTab(TabHost th) {

		TabSpec spec = th.newTabSpec("Market");
		// specs.setIndicator("Market",R.drawable.tab_market);
		spec.setIndicator("Market");
		Intent intent = new Intent(MainScreenActivity.this,
				MarketPlaceActivity.class);
		spec.setContent(intent);
		th.addTab(spec);
	}

	private void addHubTab(TabHost th) {
		TabSpec spec = th.newTabSpec("Hub");
		// specs.setIndicator("Market",R.drawable.tab_market);
		spec.setIndicator("Hub");
		Intent intent = new Intent(MainScreenActivity.this, HubActivity.class);
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

		populateData();

	}

	private void populateData() {

		if (mRowId == null)
			return;
		
		mDbHelper = new DbAdapter(this);
		mDbHelper.open();

		Cursor save = mDbHelper.fetchSave(mRowId);
		startManagingCursor(save);

		String name = save.getString(save
				.getColumnIndexOrThrow(DbAdapter.CHAR_KEY_NAME));
		// String level = save.getString(save
		// .getColumnIndexOrThrow(DbAdapter.CHAR_KEY_DIFFICULTY));
		// String money = save.getString(save
		// .getColumnIndexOrThrow(DbAdapter.CHAR_KEY_MONEY));

		int engineerPts = Integer.valueOf(save.getString(save
				.getColumnIndexOrThrow(DbAdapter.CHAR_KEY_ENGINEER_PTS)));
		int fighterPts = Integer.valueOf(save.getString(save
				.getColumnIndexOrThrow(DbAdapter.CHAR_KEY_FIGHTER_PTS)));
		int pilotPts = Integer.valueOf(save.getString(save
				.getColumnIndexOrThrow(DbAdapter.CHAR_KEY_PILOT_PTS)));
		int traderPts = Integer.valueOf(save.getString(save
				.getColumnIndexOrThrow(DbAdapter.CHAR_KEY_TRADER_PTS)));

		Character player = new Character(name, pilotPts, fighterPts, traderPts,
				engineerPts);

		Ship ship = null;
		Planet location = null;
		int money = 100;
		Universe universe = null;
		Difficulty difficulty = null;
		int turn = 1;

		GameData data = new GameData(player, ship, location, money, universe,
				difficulty, turn);
		SpaceTraderApplication.setData(data);

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
