package com.canefaitrien.spacetrader;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;

import com.canefaitrien.spacetrader.interfaces.GameConstants;
import com.canefaitrien.spacetrader.interfaces.IConfigurationView;
import com.canefaitrien.spacetrader.models.Controller.Difficulty;
import com.canefaitrien.spacetrader.presenters.ConfigurationPresenter;
import com.canefaitrien.spacetrader.utils.MusicManager;
import com.canefaitrien.spacetrader.utils.Tools;

public class ConfigurationActivity extends RootActivity implements
		GameConstants, OnClickListener, OnSeekBarChangeListener,
		IConfigurationView {

	private static final String TAG = "Configuration";

	private EditText editName;
	private TextView tvLevel;
	private SeekBar barPilot;
	private SeekBar barFighter;
	private SeekBar barTrader;
	private SeekBar barEngineer;
	private int level = 0;
	private Difficulty[] difficulties = Difficulty.values();

	private int totalPts = NUM_MAX_SKILL_POINTS;
	private int usedPts = 0;

	ConfigurationPresenter mPresenter;

	private ProgressDialog progressDialog;

	boolean continueMusic;

	public ConfigurationActivity() {
		mPresenter = new ConfigurationPresenter(this);
		continueMusic = true;
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_config);
		init();
	}

	private void init() {

		// InputMethodManager imm = (InputMethodManager)
		// getSystemService(Context.INPUT_METHOD_SERVICE);
		// imm.hideSoftInputFromWindow(getEditName().getWindowToken(), 0);
		// getWindow().setSoftInputMode(
		// WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
		ViewGroup activityViewGroup = (ViewGroup) findViewById(
				android.R.id.content).getRootView();
		setAppFont(activityViewGroup, appFont);

		Button btnPlus = (Button) findViewById(R.id.btn_plus);
		Button btnMinus = (Button) findViewById(R.id.btn_minus);
		Button btnStart = (Button) findViewById(R.id.btn_start);
		btnStart.setOnClickListener(this);
		btnPlus.setOnClickListener(this);
		btnMinus.setOnClickListener(this);

		barPilot = (SeekBar) findViewById(R.id.bar_pilot);
		barFighter = (SeekBar) findViewById(R.id.bar_fighter);
		barTrader = (SeekBar) findViewById(R.id.bar_trader);
		barEngineer = (SeekBar) findViewById(R.id.bar_engineer);

		barPilot.setMax(NUM_MAX_INITIAL_POINTS);
		barFighter.setMax(NUM_MAX_INITIAL_POINTS);
		barTrader.setMax(NUM_MAX_INITIAL_POINTS);
		barEngineer.setMax(NUM_MAX_INITIAL_POINTS);

		barPilot.setOnSeekBarChangeListener(this);
		barFighter.setOnSeekBarChangeListener(this);
		barTrader.setOnSeekBarChangeListener(this);
		barEngineer.setOnSeekBarChangeListener(this);

		setRemainingPts(totalPts);
	}

	private void setRemainingPts(int pts) {
		TextView rmPts = (TextView) findViewById(R.id.txtview_rm_pt);
		rmPts.setText(String.valueOf(pts));
	}

	public final static String EXTRA_MESSAGE = "com.canefaitrient.spacetrader.MESSAGE";

	/** Called when the user clicks the START button */
	public void startGame() {

		boolean isGoodInput = true;
		String editName = ((EditText) findViewById(R.id.edit_name)).getText()
				.toString();

		String message = "";

		if (editName.equals("")) {
			isGoodInput = false;
			message += "What's your name?\n";
		}

		if (usedPts != totalPts) {
			isGoodInput = false;
			message += "Allocate your points, dudeee!";
		}

		if (!isGoodInput) {
			Tools.popUp(this, message);
			return;
		}

		// start the progress dialog
		// progressDialog = ProgressDialog.show(ConfigurationActivity.this,
		// "New Game", "Creating the Universe");

		mPresenter.createNewGame();
		mPresenter.storeNewGameData();

		// new Thread(new Runnable() {
		//
		// public void run() {
		//
		// mPresenter.storeNewGameData();
		//
		// try {
		// Thread.sleep(10000);
		// } catch (Exception e) {
		// Log.e(TAG, e.getMessage());
		// }
		//
		// // dismiss the progress dialog
		// progressDialog.dismiss();
		//
		// }
		// }).start();

		Intent intent = new Intent(ConfigurationActivity.this,
				MainScreenActivity.class);
		intent.putExtra("New Game", true);
		startActivity(intent);
	}

	public void onClick(View v) {

		switch (v.getId()) {
		case R.id.btn_start:
			startGame();
			break;
		case R.id.btn_plus:
			if (level < difficulties.length - 1)
				setDifficultyLevel(++level);
			break;
		case R.id.btn_minus:
			if (level > 0)
				setDifficultyLevel(--level);
			break;
		}

	}

	private void setDifficultyLevel(int lvl) {
		TextView level = (TextView) findViewById(R.id.txtview_level);
		level.setText(difficulties[lvl].toString());
	}

	public void onProgressChanged(SeekBar seekBar, int progress,
			boolean fromUser) {

		int rmPts = totalPts - usedPts - progress;
		TextView pt = null;

		switch (seekBar.getId()) {
		case R.id.bar_pilot:
			pt = (TextView) findViewById(R.id.pt_pilot);
			break;
		case R.id.bar_fighter:
			pt = (TextView) findViewById(R.id.pt_fighter);
			break;
		case R.id.bar_trader:
			pt = (TextView) findViewById(R.id.pt_trader);
			break;
		case R.id.bar_engineer:
			pt = (TextView) findViewById(R.id.pt_engineer);
			break;
		}

		if (rmPts >= 0) {
			pt.setText(String.valueOf(progress));
			setRemainingPts(rmPts);
		} else
			seekBar.setProgress(totalPts - usedPts);

	}

	public void onStartTrackingTouch(SeekBar seekBar) {
		usedPts -= seekBar.getProgress();

	}

	public void onStopTrackingTouch(SeekBar seekBar) {
		usedPts += seekBar.getProgress();

	}

	public SeekBar getBarPilot() {
		return (SeekBar) findViewById(R.id.bar_pilot);
	}

	public void setBarPilot(SeekBar barPilot) {
		this.barPilot = barPilot;
	}

	public SeekBar getBarFighter() {
		return (SeekBar) findViewById(R.id.bar_fighter);
	}

	public void setBarFighter(SeekBar barFighter) {
		this.barFighter = barFighter;
	}

	public SeekBar getBarTrader() {
		return (SeekBar) findViewById(R.id.bar_trader);
	}

	public void setBarTrader(SeekBar barTrader) {
		this.barTrader = barTrader;
	}

	public SeekBar getBarEngineer() {
		return (SeekBar) findViewById(R.id.bar_engineer);
	}

	public void setBarEngineer(SeekBar barEngineer) {
		this.barEngineer = barEngineer;
	}

	public EditText getEditName() {
		editName = (EditText) findViewById(R.id.edit_name);
		return editName;
	}

	public void setEditName(EditText editName) {
		this.editName = editName;
	}

	public TextView getTxtViewLevel() {
		tvLevel = (TextView) this.findViewById(R.id.txtview_level);
		return tvLevel;
	}

	public void setTxtViewLevel(TextView level) {
		this.tvLevel = level;

	}

	@Override
	public void onBackPressed() {
		super.onBackPressed();
		continueMusic = true;
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
		continueMusic = true;
		MusicManager.start(this, MusicManager.MUSIC_MENU);

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
		finish();
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
