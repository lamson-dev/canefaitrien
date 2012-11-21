package com.canefaitrien.spacetrader;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

import com.canefaitrien.spacetrader.interfaces.IMainScreenView;
import com.canefaitrien.spacetrader.models.Ship;
import com.canefaitrien.spacetrader.presenters.MainScreenPresenter;
import com.canefaitrien.spacetrader.utils.MusicManager;

public class HubActivity extends RootActivity implements OnClickListener,
		IMainScreenView {

	private static final String TAG = "Hub";

	private MainScreenPresenter mPresenter;

	private boolean continueMusic;

	/**
	 * Construtor for HubActivity, pass in this View to the Presenter
	 */
	public HubActivity() {
		mPresenter = new MainScreenPresenter(this);
	}

	/**
	 * called when activity is created
	 */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_hub);

		Button saveGame = (Button) findViewById(R.id.btn_savegame);
		Button refill = (Button) findViewById(R.id.btn_refill);

		saveGame.setOnClickListener(this);
		refill.setOnClickListener(this);

		applyFont();

	}

	/**
	 * OnClick events for all Buttons
	 */
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btn_savegame:
			mPresenter.saveData();
			break;
		case R.id.btn_refill:
			// note to subtract money
			Ship ship = SpaceTrader.getController().getShip();
			ship.setFuel(ship.getType().MAX_DISTANCE);// change this to not be
														// distance
			break;
		}

	}

	/**
	 * Recursively set font for every TextView in the activity
	 */
	public void applyFont() {
		ViewGroup activityViewGroup = (ViewGroup) findViewById(
				android.R.id.content).getRootView();
		setAppFont(activityViewGroup, appFont);
	}

	/**
	 * pause music when activity is paused
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
	 * resume/start music without disruption
	 */
	@Override
	protected void onResume() {
		super.onResume();
		Log.d(TAG, "onResume called.");
		continueMusic = true;
		MusicManager.start(this, MusicManager.MUSIC_GAME);
	}
}
