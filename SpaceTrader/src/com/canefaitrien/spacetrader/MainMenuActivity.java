package com.canefaitrien.spacetrader;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

import com.canefaitrien.spacetrader.utils.MusicManager;

public class MainMenuActivity extends RootActivity implements OnClickListener {

	private static final String TAG = "MainMenu";
	private boolean continueMusic;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_mainmenu);
		init();
	}

	public void onClick(View v) {

		Intent intent = null;
		switch (v.getId()) {
		case R.id.btn_newgame:
			intent = new Intent(MainMenuActivity.this,
					ConfigurationActivity.class);
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
		// Typeface font = Typeface.createFromAsset(getAssets(),
		// "fonts/Street Corner.ttf");
		// TextView txt = (TextView) findViewById(R.id.txtview_app_name);
		// txt.setTypeface(font);

		setFont();

		Button btnNewGame = (Button) findViewById(R.id.btn_newgame);
		Button btnLoadGame = (Button) findViewById(R.id.btn_loadgame);
		Button btnDebug = (Button) findViewById(R.id.btn_debugmode);

		btnNewGame.setOnClickListener(this);
		btnLoadGame.setOnClickListener(this);
		btnDebug.setOnClickListener(this);

		// btnNewGame.setTypeface(font);
		// btnLoadGame.setTypeface(font);
		// btnDebug.setTypeface(font);
	}

	private void setFont() {
		ViewGroup activityViewGroup = (ViewGroup) findViewById(
				android.R.id.content).getRootView();
		setAppFont(activityViewGroup, appFont);
	}

	@Override
	protected void onStart() {
		super.onStart();
		Log.d(TAG, "onStart called.");
	}

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

//	@Override
//	protected void onDestroy() {
//		super.onDestroy();
//	}
}
