package com.canefaitrien.spacetrader;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.canefaitrien.spacetrader.interfaces.IMainScreenView;
import com.canefaitrien.spacetrader.models.Ship;
import com.canefaitrien.spacetrader.presenters.MainScreenPresenter;
import com.canefaitrien.spacetrader.utils.MusicManager;

public class HubActivity extends Activity implements OnClickListener,
		IMainScreenView {

	private static final String TAG = "Hub";

	MainScreenPresenter mPresenter;

	private boolean continueMusic;

	public HubActivity() {
		mPresenter = new MainScreenPresenter(this);
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_hub);

		Button saveGame = (Button) findViewById(R.id.btn_savegame);
		Button refill = (Button) findViewById(R.id.btn_refill);

		saveGame.setOnClickListener(this);
		refill.setOnClickListener(this);

	}

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

//	@Override
//	public void onBackPressed() {
//		super.onBackPressed();
//		continueMusic = true;
//	}

	@Override
	protected void onPause() {
		super.onPause();
		Log.d(TAG, "onPause called.");
		if (!continueMusic) {
			MusicManager.pause();
		}
	}

	@Override
	protected void onResume() {
		super.onResume();
		Log.d(TAG, "onResume called.");
		continueMusic = true;
		MusicManager.start(this, MusicManager.MUSIC_GAME);
	}
}
