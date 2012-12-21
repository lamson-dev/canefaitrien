// $codepro.audit.disable com.instantiations.assist.eclipse.analysis.audit.rule.effectivejava.alwaysOverridetoString.alwaysOverrideToString
/**
 * Concrete View of MainMenu Screen
 */

package com.canefaitrien.spacetrader;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

import com.canefaitrien.spacetrader.utils.MusicManager;

/**
 * @author Son Nguyen
 * @version $Revision: 1.0 $
 */
public class MainMenuActivity extends RootActivity implements OnClickListener {

	/**
	 * Field TAG. (value is ""MainMenu"")
	 */
	private static final String TAG = "MainMenu";

	/**
	 * Field continueMusic.
	 */
	private boolean continueMusic;

	/**
	 * Method onCreate.
	 * 
	 * @param savedInstanceState
	 *            Bundle
	 */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_mainmenu);
		init();
	}

	/**
	 * Method onClick.
	 * 
	 * @param v
	 *            View
	 * 
	 * @see android.view.View$OnClickListener#onClick(View)
	 */
	public void onClick(View v) { // $codepro.audit.disable
									// inconsistentUseOfOverride

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
		default:
			break;
		}
		startActivity(intent);

	}

	/**
	 * Method init.
	 */
	private void init() {
		// Typeface font = Typeface.createFromAsset(getAssets(),
		// "fonts/Street Corner.ttf");
		// TextView txt = (TextView) findViewById(R.id.txtview_app_name);
		// txt.setTypeface(font);

		applyFont();

		final Button btnNewGame = (Button) findViewById(R.id.btn_newgame);
		final Button btnLoadGame = (Button) findViewById(R.id.btn_loadgame);
		final Button btnDebug = (Button) findViewById(R.id.btn_debugmode);

		btnNewGame.setOnClickListener(this);
		btnLoadGame.setOnClickListener(this);
		btnDebug.setOnClickListener(this);

		// btnNewGame.setTypeface(font);
		// btnLoadGame.setTypeface(font);
		// btnDebug.setTypeface(font);
	}

	/**
	 * recursively set font for all textview
	 */
	public void applyFont() {
		final ViewGroup activityViewGroup = (ViewGroup) findViewById(
				android.R.id.content).getRootView();
		setAppFont(activityViewGroup, appFont);
	}

	/**
	 * Method onStart.
	 */
	@Override
	protected void onStart() {
		super.onStart();
		Log.d(TAG, "onStart called.");
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
		continueMusic = false;
		MusicManager.start(this, MusicManager.MUSIC_MENU);
	}

	/**
	 * Method onStop.
	 */
	@Override
	protected void onStop() {
		super.onStop();
		Log.d(TAG, "onStop called.");
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
}
