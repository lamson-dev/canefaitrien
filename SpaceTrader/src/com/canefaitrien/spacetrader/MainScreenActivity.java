package com.canefaitrien.spacetrader;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

import com.canefaitrien.spacetrader.dao.GameDataDao;
import com.canefaitrien.spacetrader.interfaces.IMainScreenView;
import com.canefaitrien.spacetrader.presenters.MainScreenPresenter;

@SuppressWarnings("deprecation")
public class MainScreenActivity extends TabActivity implements IMainScreenView {

	private static final String TAG = "MainScreen";
	MainScreenPresenter mPresenter;

	private Long mRowId;

	public MainScreenActivity() {
		mPresenter = new MainScreenPresenter(this);
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_mainscreen);

		if (!getIntent().getExtras().getBoolean("New Game"))
			loadGame(savedInstanceState);
		
		init();
		
	}

	private void init() {

		TabHost tabhost = getTabHost();

		addTab("Map", GalaxyMapActivity.class, tabhost);
		addTab("Info", InfoActivity.class, tabhost);
		addTab("Market", MarketPlaceActivity.class, tabhost);
		addTab("Hub", HubActivity.class, tabhost);
		tabhost.setCurrentTab(3);
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

		// mRowId = (savedInstanceState == null) ? null
		// : (Long) savedInstanceState
		// .getSerializable(GameDataDao.Properties.Id.columnName);
		//
		// if (mRowId == null) {
		//
		// Bundle extras = getIntent().getExtras();
		// mRowId = extras != null ? extras
		// .getLong(GameDataDao.Properties.Id.columnName) : null;
		// }

		Bundle extras = getIntent().getExtras();
		mRowId = extras.getLong(GameDataDao.Properties.Id.columnName);

		mPresenter.populateData(mRowId);

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

	@Override
	protected void onStart() {
		super.onStart();
		Log.d(TAG, "onStart called.");
	}

	@Override
	protected void onPause() {
		super.onPause();
		Log.d(TAG, "onPause called.");
	}

	@Override
	protected void onResume() {
		super.onResume();
		Log.d(TAG, "onResume called.");
	}

	@Override
	protected void onStop() {
		SpaceTrader.getData().update();
		super.onStop();
		Log.d(TAG, "onStop called.");
	}

	@Override
	protected void onRestart() {
		super.onRestart();
		Log.d(TAG, "onRestart called.");
	}

	@Override
	protected void onDestroy() {
		SpaceTrader.getData().update();
		super.onDestroy();
	}
}
