package com.canefaitrien.spacetrader;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;
import android.widget.TextView;

import com.canefaitrien.spacetrader.models.Character;
import com.canefaitrien.spacetrader.models.GameData;
import com.canefaitrien.spacetrader.models.Planet;
import com.canefaitrien.spacetrader.models.Ship;
import com.canefaitrien.spacetrader.models.Universe;
import com.canefaitrien.spacetrader.models.GameData.Difficulty;
import com.canefaitrien.spacetrader.utils.AbstractActivity;
import com.canefaitrien.spacetrader.utils.DbAdapter;

public class MainScreenActivity extends AbstractActivity {

	LayoutInflater inflater;
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

		init();
		loadGame(savedInstanceState);

		setHubTab();
		setInfoTab();

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

	private void init() {
		inflater = (LayoutInflater) getApplicationContext().getSystemService(
				Context.LAYOUT_INFLATER_SERVICE);

		TabHost th = (TabHost) findViewById(R.id.tabhost);
		th.setup();
		TabSpec specs = th.newTabSpec("tag1");
		specs.setContent(R.id.tab_map);
		specs.setIndicator("Map");
		th.addTab(specs);

		specs = th.newTabSpec("tag2");
		specs.setContent(R.id.tab_info);
		specs.setIndicator("Info");
		th.addTab(specs);

		specs = th.newTabSpec("tag3");
		specs.setContent(R.id.tab_market);
		specs.setIndicator("Market");
		th.addTab(specs);

		specs = th.newTabSpec("tag4");
		specs.setContent(R.id.tab_hub);
		specs.setIndicator("Hub");
		th.addTab(specs);
	}

	private void setInfoTab() {
		GameData data = SpaceTraderApplication.getData();
		String info = data.getPlayer().toString();
		ViewGroup parentView = (RelativeLayout) findViewById(R.id.tab_info_content);

		inflater.inflate(R.layout.content_info, parentView);
		TextView tv = (TextView) findViewById(R.id.tv_info_content);
		tv.setText(info);

	}

	private void setHubTab() {
		ViewGroup parentView = (RelativeLayout) findViewById(R.id.tab_hub_content);
		inflater.inflate(R.layout.content_hub, parentView);
	}

	private void setMapTab() {

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
