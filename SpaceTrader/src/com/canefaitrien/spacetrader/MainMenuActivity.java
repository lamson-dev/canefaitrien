package com.canefaitrien.spacetrader;

import android.content.Intent;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.canefaitrien.spacetrader.dao.DaoMaster;
import com.canefaitrien.spacetrader.dao.DaoMaster.DevOpenHelper;
import com.canefaitrien.spacetrader.utils.AbstractActivity;
import com.canefaitrien.spacetrader.utils.MusicManager;

public class MainMenuActivity extends AbstractActivity implements
		OnClickListener {

	private static final String TAG = "MainMenu";
	MediaPlayer track; // background music
	private boolean continueMusic;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_mainmenu);
		init();

		SpaceTrader.track = MediaPlayer.create(MainMenuActivity.this,
				R.raw.silbruch);
		SpaceTrader.track.setLooping(true);
		SpaceTrader.track.start();

		DevOpenHelper helper = new DaoMaster.DevOpenHelper(this,
				"spacetrader-db", null);
		SpaceTrader.db = helper.getWritableDatabase();
		SpaceTrader.daoMaster = new DaoMaster(SpaceTrader.db);
		SpaceTrader.daoSession = SpaceTrader.daoMaster.newSession();
	}

	public void onClick(View v) {

		Intent intent = null;
		switch (v.getId()) {
		case R.id.btn_newgame:
			intent = new Intent(MainMenuActivity.this,
					ConfigurationActivity.class);
			startActivity(intent);
			break;
		case R.id.btn_loadgame:
			intent = new Intent(MainMenuActivity.this, LoadGameActivity.class);
			break;
		case R.id.btn_debugmode:
			intent = new Intent(MainMenuActivity.this, GalaxyMapActivity.class);
			break;
		}
		startActivity(intent);

	}

	private void init() {
		Typeface font = Typeface.createFromAsset(getAssets(),
				"fonts/Street Corner.ttf");

		TextView txt = (TextView) findViewById(R.id.txtview_app_name);
		txt.setTypeface(font);

		Button btnNewGame = (Button) findViewById(R.id.btn_newgame);
		Button btnLoadGame = (Button) findViewById(R.id.btn_loadgame);
		Button btnDebug = (Button) findViewById(R.id.btn_debugmode);

		btnNewGame.setOnClickListener(this);
		btnLoadGame.setOnClickListener(this);
		btnDebug.setOnClickListener(this);

		btnNewGame.setTypeface(font);
		btnLoadGame.setTypeface(font);
		btnDebug.setTypeface(font);
	}

	// To use this, each activity must have a boolean field called continueMusic
	// or whatever you want to call it. For any activity that isn't the root
	// activity (launcher), override onKeyDown and set continueMusic to true if
	// the key is the "back" key. Also set continueMusic to true when launching
	// any activities in which you want to keep playing this music in with no
	// interruption.

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
		continueMusic = false;
		MusicManager.start(this, MusicManager.MUSIC_MENU);
	}

	protected void onStart() {
		super.onStart();
		Log.d(TAG, "onStart called.");
	}

	protected void onStop() {
		super.onStop();
		Log.d(TAG, "onStop called.");
	}

	protected void onRestart() {
		super.onRestart();
		Log.d(TAG, "onRestart called.");
	}

	protected void onDestroy() {
		super.onDestroy();
	}
}
