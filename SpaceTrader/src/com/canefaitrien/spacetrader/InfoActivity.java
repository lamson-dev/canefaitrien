package com.canefaitrien.spacetrader;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.canefaitrien.spacetrader.models.Controller;
import com.canefaitrien.spacetrader.models.GameData;
import com.canefaitrien.spacetrader.utils.AbstractActivity;

public class InfoActivity extends AbstractActivity {

	private static final String TAG = "Info";
	private Controller data;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_info);

		data = SpaceTrader.getController();
		Log.d(TAG, "loaded data");

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

		currentPlanet.setText("Current planet: "
				+ data.getLocation().getName());
		money.setText("Money: $" + String.valueOf(data.getMoney()));
	}

	@Override
	protected void onPause() {
		Log.d(TAG, "onPause called.");
		super.onPause();
	}

	@Override
	protected void onResume() {
		Log.d(TAG, "onResume called.");
		super.onResume();
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
