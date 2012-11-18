package com.canefaitrien.spacetrader;

import android.os.Bundle;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.TextView;

import com.canefaitrien.spacetrader.models.Controller;
import com.canefaitrien.spacetrader.utils.MusicManager;

public class InfoActivity extends RootActivity {

	private static final String TAG = "Info";
	private Controller data;
	private boolean continueMusic;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_info);

		data = SpaceTrader.getController();
		Log.d(TAG, "loaded data");
		setFont();
		populateData();
	}

	private void populateData() {
		TextView nameView = (TextView) findViewById(R.id.textView1);
		TextView pilotPts = (TextView) findViewById(R.id.textView6);
		TextView fighterPts = (TextView) findViewById(R.id.textView7);
		TextView traderPts = (TextView) findViewById(R.id.textView8);
		TextView engineerPts = (TextView) findViewById(R.id.textView9);

		nameView.setText("" + data.getPlayer().getName());
		pilotPts.setText("" + data.getPlayer().getPilotPts());
		fighterPts.setText("" + data.getPlayer().getFighterPts());
		traderPts.setText("" + data.getPlayer().getTraderPts());
		engineerPts.setText("" + data.getPlayer().getEngineerPts());

		TextView currentPlanet = (TextView) findViewById(R.id.textView10);
		TextView money = (TextView) findViewById(R.id.textView11);

		currentPlanet
				.setText("Current planet: " + data.getLocation().getName());
		money.setText("Money: $" + String.valueOf(data.getMoney()));
	}

	private void setFont() {
		ViewGroup activityViewGroup = (ViewGroup) findViewById(
				android.R.id.content).getRootView();
		setAppFont(activityViewGroup, appFont);
	}

	// @Override
	// public void onBackPressed() {
	// super.onBackPressed();
	// continueMusic = true;
	// }

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

		populateData();
	}

	@Override
	protected void onStart() {
		super.onStart();
		Log.d(TAG, "onStart called.");
	}

	@Override
	protected void onStop() {
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
		super.onDestroy();
	}

}
