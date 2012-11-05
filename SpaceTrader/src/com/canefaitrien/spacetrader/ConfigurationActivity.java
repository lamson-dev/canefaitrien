package com.canefaitrien.spacetrader;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;

import com.canefaitrien.spacetrader.constants.GameConstants;
import com.canefaitrien.spacetrader.models.Controller;
import com.canefaitrien.spacetrader.models.Controller.Difficulty;
import com.canefaitrien.spacetrader.models.Person;
import com.canefaitrien.spacetrader.utils.AbstractActivity;
import com.canefaitrien.spacetrader.utils.DbAdapter;
import com.canefaitrien.spacetrader.utils.Tools;

public class ConfigurationActivity extends AbstractActivity implements
		GameConstants, OnClickListener, OnSeekBarChangeListener {

	private static final String TAG = "Configuration";

	private String name;
	private SeekBar barPilot;
	private SeekBar barFighter;
	private SeekBar barTrader;
	private SeekBar barEngineer;
	private int difficultyLevel = 0;
	private Difficulty[] difficulties = Difficulty.values();

	private int totalPts = NUM_MAX_SKILL_POINTS;
	private int usedPts = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_config);
		init();
	}

	private void init() {

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

	private void setDifficultyLevel(int lvl) {
		TextView level = (TextView) findViewById(R.id.txtview_level);
		level.setText(difficulties[lvl].toString());
	}

	public final static String EXTRA_MESSAGE = "com.canefaitrient.spacetrader.MESSAGE";

	/** Called when the user clicks the START button */
	public void startGame() {

		boolean isGoodInput = true;
		name = ((EditText) findViewById(R.id.edit_name)).getText().toString();

		String message = "";

		if (name.equals("")) {
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

		long charId = createCharacter();

		Intent intent = new Intent(ConfigurationActivity.this,
				MainScreenActivity.class);
		intent.putExtra(DbAdapter.CHAR_KEY_ROWID, charId);
		startActivity(intent);

	}

	private long createCharacter() {
		DbAdapter mDbHelper = new DbAdapter(ConfigurationActivity.this);
		mDbHelper.open();

		Person charac = new Person(name, barPilot.getProgress(),
				barFighter.getProgress(), barTrader.getProgress(),
				barEngineer.getProgress());

		Controller data = new Controller(charac, difficulties[difficultyLevel]);

		SpaceTraderApplication.setData(data);

		long charId = mDbHelper.createCharacter(charac);

		mDbHelper.close();
		return charId;

	}

	public void onClick(View v) {

		switch (v.getId()) {
		case R.id.btn_start:
			startGame();
			break;
		case R.id.btn_plus:
			if (difficultyLevel < difficulties.length - 1)
				setDifficultyLevel(++difficultyLevel);
			break;
		case R.id.btn_minus:
			if (difficultyLevel > 0)
				setDifficultyLevel(--difficultyLevel);
			break;
		}

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

	// @Override
	// protected void onStart() {
	// super.onStart();
	// Log.d(TAG, "onStart called.");
	// }
	//
	// @Override
	// protected void onPause() {
	// super.onPause();
	// Log.d(TAG, "onPause called.");
	// }
	//
	// @Override
	// protected void onResume() {
	// super.onResume();
	// Log.d(TAG, "onResume called.");
	// }
	//
	// @Override
	// protected void onStop() {
	// super.onStop();
	// Log.d(TAG, "onStop called.");
	// }
	//
	// @Override
	// protected void onRestart() {
	// super.onRestart();
	// Log.d(TAG, "onRestart called.");
	// }
	//
	// @Override
	// protected void onDestroy() {
	// super.onDestroy();
	// }

}
