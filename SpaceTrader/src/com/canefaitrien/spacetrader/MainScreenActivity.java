package com.canefaitrien.spacetrader;

import android.app.AlertDialog;
import android.app.LocalActivityManager;
import android.content.Context;
import android.content.DialogInterface;
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
import com.canefaitrien.spacetrader.utils.AbstractActivity;
import com.canefaitrien.spacetrader.utils.DbAdapter;

public class MainScreenActivity extends AbstractActivity {

	// This is the Adapter being used to display the list's data
	SimpleCursorAdapter mAdapter;
	@SuppressWarnings("deprecation")
	LocalActivityManager mlam;

	private static final String TAG = "MainScreen";
	LayoutInflater inflater;

	TabHost th;
	TabSpec specs;
	private Long mRowId;

	private DbAdapter mDbHelper;

	AlertDialog.Builder popup;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_mainscreen);

		mDbHelper = new DbAdapter(this);
		mDbHelper.open();

		popup = new AlertDialog.Builder(this);
		popup.setTitle("Heyyyy!");
		popup.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				// dismiss the dialog
			}
		});

		popup.setCancelable(true);

		init(savedInstanceState);
		loadGame(savedInstanceState);

		setMapTab();
		setInfoTab();
		setMarketTab();
		setHubTab();

		th.setCurrentTab(1);

	}

	@SuppressWarnings("deprecation")
	private void init(Bundle savedInstanceState) {
		inflater = (LayoutInflater) getApplicationContext().getSystemService(
				Context.LAYOUT_INFLATER_SERVICE);

		mlam = new LocalActivityManager(this, false);
		mlam.dispatchCreate(savedInstanceState);
		th = (TabHost) findViewById(R.id.tabhost);
		th.setup(mlam);
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

	@SuppressWarnings("deprecation")
	private void populateData() {
		if (mRowId == null)
			return;

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

	private void setMapTab() {
		specs = th.newTabSpec("tag1");
		specs.setContent(R.id.tab_map);
		specs.setIndicator("Map");
		th.addTab(specs);
	}

	private void setInfoTab() {
		specs = th.newTabSpec("tag2");
		specs.setContent(R.id.tab_info);
		specs.setIndicator("Info");
		th.addTab(specs);

		GameData data = SpaceTraderApplication.getData();
		String info = data.getPlayer().toString();
		ViewGroup parentView = (RelativeLayout) findViewById(R.id.tab_info_content);

		inflater.inflate(R.layout.content_info, parentView);
		TextView tv = (TextView) findViewById(R.id.tv_info_content);
		tv.setText(info);

	}

	private void setMarketTab() {
		Intent intentMarket = new Intent(MainScreenActivity.this,
				MarketPlaceActivity.class);
		specs = th.newTabSpec("tag3");
		// specs.setIndicator("",R.drawable.tab_market);
		specs.setIndicator("Market");
		specs.setContent(intentMarket);
		// specs.setContent(R.id.tab_market);
		th.addTab(specs);
	}

	private void setHubTab() {
		ViewGroup parentView = (RelativeLayout) findViewById(R.id.tab_hub_content);
		inflater.inflate(R.layout.content_hub, parentView);

		specs = th.newTabSpec("tag4");
		specs.setContent(R.id.tab_hub);
		specs.setIndicator("Hub");
		th.addTab(specs);
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

	private void saveState() {
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
	}
}
