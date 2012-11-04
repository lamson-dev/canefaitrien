package com.canefaitrien.spacetrader;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

import com.canefaitrien.spacetrader.constants.GameConstants;
import com.canefaitrien.spacetrader.models.Character;
import com.canefaitrien.spacetrader.models.GameData;
import com.canefaitrien.spacetrader.models.GameData.Difficulty;
import com.canefaitrien.spacetrader.utils.AbstractActivity;
import com.canefaitrien.spacetrader.utils.DbAdapter;
import com.canefaitrien.spacetrader.utils.Tools;

public class ConfigurationActivity extends AbstractActivity implements
		GameConstants, OnClickListener {

	private static final String TAG = "Configuration";
	private String name;
	private int difficultyLevel = 0;
	private int totalPts = NUM_MAX_SKILL_POINTS;
	private int usedPts = 0;

	private TextView txtViewRmPts;
	private SeekBar barPilot;
	private SeekBar barFighter;
	private SeekBar barTrader;
	private SeekBar barEngineer;
	private Difficulty[] difficulties = Difficulty.values();

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

		btnPlus.setOnClickListener(new View.OnClickListener() {
			public void onClick(View view) {
				if (difficultyLevel < difficulties.length - 1)
					setDifficultyLevel(++difficultyLevel);
			}

		});

		btnMinus.setOnClickListener(new View.OnClickListener() {
			public void onClick(View view) {
				if (difficultyLevel > 0)
					setDifficultyLevel(--difficultyLevel);
			}
		});

		txtViewRmPts = (TextView) findViewById(R.id.txtview_rm_pt);
		txtViewRmPts.setText(String.valueOf(totalPts));

		barPilot = (SeekBar) findViewById(R.id.bar_pilot);
		barFighter = (SeekBar) findViewById(R.id.bar_fighter);
		barTrader = (SeekBar) findViewById(R.id.bar_trader);
		barEngineer = (SeekBar) findViewById(R.id.bar_engineer);

		barPilot.setMax(NUM_MAX_INITIAL_POINTS);
		barFighter.setMax(NUM_MAX_INITIAL_POINTS);
		barTrader.setMax(NUM_MAX_INITIAL_POINTS);
		barEngineer.setMax(NUM_MAX_INITIAL_POINTS);

		barPilot.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
			public void onProgressChanged(SeekBar seekBar, int progress,
					boolean fromUser) {
				TextView ptPilot = (TextView) findViewById(R.id.pt_pilot);

				int rmPts = totalPts - usedPts - progress;
				if (rmPts >= 0) {
					ptPilot.setText(String.valueOf(progress));
					setRemainingPts(rmPts);
				} else
					barPilot.setProgress(totalPts - usedPts);
			}

			public void onStartTrackingTouch(SeekBar seekBar) {
				usedPts -= seekBar.getProgress();
			}

			public void onStopTrackingTouch(SeekBar seekBar) {
				usedPts += seekBar.getProgress();
			}

		});

		barFighter
				.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
					public void onProgressChanged(SeekBar seekBar,
							int progress, boolean fromUser) {
						TextView ptFighter = (TextView) findViewById(R.id.pt_fighter);

						int rmPts = totalPts - usedPts - progress;
						if (rmPts >= 0) {
							ptFighter.setText(String.valueOf(progress));
							setRemainingPts(rmPts);
						} else
							barFighter.setProgress(totalPts - usedPts);
					}

					public void onStartTrackingTouch(SeekBar seekBar) {
						usedPts -= seekBar.getProgress();
					}

					public void onStopTrackingTouch(SeekBar seekBar) {
						usedPts += seekBar.getProgress();
					}

				});

		barTrader
				.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
					public void onProgressChanged(SeekBar seekBar,
							int progress, boolean fromUser) {
						TextView ptTrader = (TextView) findViewById(R.id.pt_trader);

						int rmPts = totalPts - usedPts - progress;
						if (rmPts >= 0) {
							ptTrader.setText(String.valueOf(progress));
							setRemainingPts(rmPts);
						} else
							barTrader.setProgress(totalPts - usedPts);
					}

					public void onStartTrackingTouch(SeekBar seekBar) {
						usedPts -= seekBar.getProgress();
					}

					public void onStopTrackingTouch(SeekBar seekBar) {
						usedPts += seekBar.getProgress();
					}

				});

		barEngineer
				.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
					public void onProgressChanged(SeekBar seekBar,
							int progress, boolean fromUser) {
						TextView ptEngineer = (TextView) findViewById(R.id.pt_engineer);

						int rmPts = totalPts - usedPts - progress;
						if (rmPts >= 0) {
							ptEngineer.setText(String.valueOf(progress));
							setRemainingPts(rmPts);
						} else
							barEngineer.setProgress(totalPts - usedPts);
					}

					public void onStartTrackingTouch(SeekBar seekBar) {
						usedPts -= seekBar.getProgress();
					}

					public void onStopTrackingTouch(SeekBar seekBar) {
						usedPts += seekBar.getProgress();
					}

				});
	}

	private void setRemainingPts(int pts) {
		txtViewRmPts.setText(String.valueOf(pts));
	}

	private void setDifficultyLevel(int lvl) {
		TextView level = (TextView) findViewById(R.id.txtview_level);
		level.setText(difficulties[lvl].toString());
	}

	public final static String EXTRA_MESSAGE = "com.canefaitrient.spacetrader.MESSAGE";

	/** Called when the user clicks the START button */
	public void startGame() {

		boolean isGoodInput = true;
		EditText editName = (EditText) findViewById(R.id.edit_name);
		String message = "";

		name = editName.getText().toString();
		if (name.equals("")) {
			isGoodInput = false;
			message += "What's your name?\n";
		}

		if (usedPts != totalPts) {
			isGoodInput = false;
			message += "Allocate your points, dudeee!";
		}

		// intent.putExtra(EXTRA_MESSAGE, message);

		if (!isGoodInput) {
			Tools.popUp(this, message);
			return;
		}

		long charId = createCharacter();

		// Log.d(TAG,
		// SpaceTraderApplication.getData().getLocation().toString());
		// Log.d(TAG,
		// SpaceTraderApplication.getData().getLocation().getMarketplace().toString());
		// Log.d(TAG,
		// SpaceTraderApplication.getData().getLocation().getMarketplace().getBuyView()[0]);

		Intent intent = new Intent(ConfigurationActivity.this,
				MainScreenActivity.class);
		intent.putExtra(EXTRA_MESSAGE, SpaceTraderApplication.getData()
				.getUniverse().toString());
		intent.putExtra(DbAdapter.CHAR_KEY_ROWID, charId);
		startActivity(intent);

	}

	private long createCharacter() {
		DbAdapter mDbHelper = new DbAdapter(ConfigurationActivity.this);
		mDbHelper.open();

		Character charac = new Character(name, barPilot.getProgress(),
				barFighter.getProgress(), barTrader.getProgress(),
				barEngineer.getProgress());

		GameData data = new GameData(charac, difficulties[difficultyLevel]);

		SpaceTraderApplication.setData(data);

		long charId = mDbHelper.createCharacter(charac);

		mDbHelper.close();
		return charId;

	}

	public void onClick(View v) {
		// TODO Auto-generated method stub

		switch (v.getId()) {
		case R.id.btn_start:
			startGame();
			break;
		}

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
