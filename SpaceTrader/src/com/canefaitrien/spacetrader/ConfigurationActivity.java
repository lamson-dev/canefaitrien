package com.canefaitrien.spacetrader;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

import com.canefaitrien.spacetrader.constants.GameConstants;
import com.canefaitrien.spacetrader.models.Character;
import com.canefaitrien.spacetrader.models.GameData;
import com.canefaitrien.spacetrader.models.GameData.Difficulty;
import com.canefaitrien.spacetrader.models.Universe;
import com.canefaitrien.spacetrader.utils.AbstractActivity;
import com.canefaitrien.spacetrader.utils.DbAdapter;

public class ConfigurationActivity extends AbstractActivity implements
		GameConstants {

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
	public void startGame(View view) {

		boolean isGoodInput = true;

		DbAdapter mDbHelper = new DbAdapter(ConfigurationActivity.this);
		mDbHelper.open();

		EditText editName = (EditText) findViewById(R.id.edit_name);

		String message = "Hell yeahhh\n";

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

		AlertDialog.Builder popup = new AlertDialog.Builder(this);
		popup.setTitle("Heyyy!");
		popup.setMessage(message);

		popup.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				// dismiss the dialog
			}
		});
		popup.setCancelable(true);
		popup.create().show();

		if (!isGoodInput)
			return;

		// Do something in response to button
		// Intent intent = new Intent(this, DisplayDataActivity.class);

		Character charac = new Character(name, barPilot.getProgress(),
				barFighter.getProgress(), barTrader.getProgress(),
				barEngineer.getProgress());
		GameData data = new GameData(charac, new Universe(), difficulties[difficultyLevel]);

		SpaceTraderApplication.setData(data);

		long charId = mDbHelper.createCharacter(charac);
		
		mDbHelper.close();

		Intent intent = new Intent(ConfigurationActivity.this,
				MainScreenActivity.class);
		intent.putExtra(EXTRA_MESSAGE, SpaceTraderApplication.getData().getUniverse().toString());
		intent.putExtra(DbAdapter.CHAR_KEY_ROWID, charId);
		startActivity(intent);
	}
}
