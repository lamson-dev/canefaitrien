// $codepro.audit.disable com.instantiations.assist.eclipse.analysis.audit.rule.effectivejava.alwaysOverridetoString.alwaysOverrideToString
/**
 * Concrete View of Hub Screen
 */

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

/**
 * @author Son Nguyen
 * @version $Revision: 1.0 $
 */
public class HubActivity extends RootActivity implements OnClickListener,
		IMainScreenView {

	/**
	 * Field TAG. (value is ""Hub"")
	 */
	private static final String TAG = "Hub";

	/**
	 * Field mPresenter.
	 */
	private MainScreenPresenter mPresenter;

	/**
	 * Field continueMusic.
	 */
	private boolean continueMusic;

	/**
	 * Construtor for HubActivity, pass in this View to the Presenter
	 */
	public HubActivity() {
		mPresenter = new MainScreenPresenter(this);
	}

	/**
	 * called when activity is created
	 * 
	 * @param savedInstanceState
	 *            Bundle
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
	 * 
	 * @param v
	 *            View
	 * 
	 * @see android.view.View$OnClickListener#onClick(View)
	 */
	public void onClick(View v) { // $codepro.audit.disable inconsistentUseOfOverride
		switch (v.getId()) {
		case R.id.btn_savegame:
			mPresenter.saveData();
			break;
		case R.id.btn_refill:
			// note to subtract money
			Ship ship = SpaceTrader.getController().getShip();
			ship.setFuel(ship.getType().maxDistance);// change this to not be
														// distance
			break;
		default:
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
