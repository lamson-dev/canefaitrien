// $codepro.audit.disable com.instantiations.assist.eclipse.analysis.audit.rule.effectivejava.alwaysOverridetoString.alwaysOverrideToString
/**
 * Concrete View of Main Navigation Screen
 */

package com.canefaitrien.spacetrader;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

import com.canefaitrien.spacetrader.dao.GameDataDao;
import com.canefaitrien.spacetrader.interfaces.IMainScreenView;
import com.canefaitrien.spacetrader.presenters.MainScreenPresenter;
import com.canefaitrien.spacetrader.utils.MusicManager;

/**
 * @author Son Nguyen
 * @version $Revision: 1.0 $
 */
@SuppressWarnings("deprecation")
public class MainScreenActivity extends TabActivity implements IMainScreenView {

	/**
	 * Field TAG. (value is ""MainScreen"")
	 */
	private static final String TAG = "MainScreen";

	/**
	 * Field mPresenter.
	 */
	protected MainScreenPresenter mPresenter;

	/**
	 * Field mRowId.
	 */
	private long mRowId;

	/**
	 * Field continueMusic.
	 */
	private boolean continueMusic;

	/**
	 * constructor pass in this view for the presenter to use
	 */
	public MainScreenActivity() {
		mPresenter = new MainScreenPresenter(this);
	}

	/**
	 * Method onCreate.
	 * 
	 * @param savedInstanceState
	 *            Bundle
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_mainscreen);

		boolean isNewGame = getIntent().getExtras().getBoolean("New Game");

		// if not new game then load game
		if (isNewGame) {
			mRowId = SpaceTrader.getData().getId();
		} else {
			Bundle extras = getIntent().getExtras();
			mRowId = extras.getLong(GameDataDao.Properties.Id.columnName);
		}
		mPresenter.populateData(mRowId);
		init();
	}

	/**
	 * add tabs to mainscreen
	 */
	private void init() {

		TabHost tabhost = getTabHost();

		addTab("Map", GalaxyMapActivity.class, tabhost);
		addTab("Info", InfoActivity.class, tabhost);
		addTab("Market", MarketPlaceActivity.class, tabhost);
		addTab("Hub", HubActivity.class, tabhost);
		// tabhost.setCurrentTab(3);

		applyFont();

		// ActionBar
		// ActionBar actionbar = getActionBar();
		// actionbar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
		//
		// ActionBar.Tab PlayerTab = actionbar.newTab().setText("Fragment A");
		// ActionBar.Tab StationsTab = actionbar.newTab().setText("Fragment B");
		//
		// Fragment PlayerFragment = new AFragment();
		// Fragment StationsFragment = new BFragment();
		//
		// PlayerTab.setTabListener(new MyTabsListener(PlayerFragment));
		// StationsTab.setTabListener(new MyTabsListener(StationsFragment));
		//
		// actionbar.addTab(PlayerTab);
		// actionbar.addTab(StationsTab);

	}

	/**
	 * add tab to mainscreen
	 * 
	 * @param tag
	 *            tag for tab
	 * @param c
	 *            class that tab goes to
	 * @param th
	 *            tabhost
	 */
	private void addTab(String tag, Class<?> c, TabHost th) {
		TabSpec spec = th.newTabSpec(tag);
		// specs.setIndicator("Market",R.drawable.tab_market);
		spec.setIndicator(tag);
		Intent intent = new Intent(MainScreenActivity.this, c);
		spec.setContent(intent);
		th.addTab(spec);
	}

	/**
	 * recursively set font for all app
	 */
	private void applyFont() {
		ViewGroup activityViewGroup = (ViewGroup) findViewById(
				android.R.id.content).getRootView();
		RootActivity.setAppFont(activityViewGroup, RootActivity.appFont);
	}

	/**
	 * Method onCreateOptionsMenu.
	 * 
	 * @param menu
	 *            Menu
	 * 
	 * @return boolean
	 */
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.menu_mainscreen, menu);
		return true;
	}

	/**
	 * Method onMenuItemSelected.
	 * 
	 * @param featureId
	 *            int
	 * @param item
	 *            MenuItem
	 * 
	 * @return boolean *
	 * @see android.view.Window$Callback#onMenuItemSelected(int, MenuItem)
	 */
	@Override
	public boolean onMenuItemSelected(int featureId, MenuItem item) {
		switch (item.getItemId()) {
		case R.id.menu_save:
			mPresenter.saveData();
			return true;
		case R.id.menu_load:
			// do something, load main menu?
			return true;
		default:
			break;
		}

		return super.onMenuItemSelected(featureId, item);
	}

	/**
	 * Method onStart.
	 */
	@Override
	protected void onStart() {
		super.onStart();
		Log.d(TAG, "onStart called.");

		MusicManager.release();
	}

	/**
	 * Method onPause.
	 */
	@Override
	protected void onPause() {
		super.onPause();
		Log.d(TAG, "onPause called.");
		if (!continueMusic) {
			MusicManager.pause();
		}
	}

	/**
	 * Method onResume.
	 */
	@Override
	protected void onResume() {
		super.onResume();
		Log.d(TAG, "onResume called.");
		continueMusic = true;
		MusicManager.start(this, MusicManager.MUSIC_GAME);

		mPresenter.populateData(mRowId);
	}

	/**
	 * Method onStop.
	 */
	@Override
	protected void onStop() {
		super.onStop();
		Log.d(TAG, "onStop called.");
		MusicManager.release();
		// finish();
	}

	/**
	 * Method onRestart.
	 */
	@Override
	protected void onRestart() {
		super.onRestart();
		Log.d(TAG, "onRestart called.");
	}

	// @Override
	// protected void onDestroy() {
	// super.onDestroy();
	// }

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

}

// class MyTabsListener implements TabListener {
// public Fragment fragment;
//
// public MyTabsListener(Fragment fragment) {
// this.fragment = fragment;
// }
//
// public void onTabReselected(Tab tab, FragmentTransaction ft) {
// Toast.makeText(StartActivity.appContext, "Reselected!",
// Toast.LENGTH_LONG).show();
// }
//
// public void onTabSelected(Tab tab, FragmentTransaction ft) {
// ft.replace(R.id.fragment_container, fragment);
// }
//
// public void onTabUnselected(Tab tab, FragmentTransaction ft) {
// ft.remove(fragment);
// }
// }
