package com.canefaitrien.spacetrader;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

import com.canefaitrien.spacetrader.constants.GameConstants;

public class ConfigurationActivity extends AbstractActivity implements
		GameConstants {

	private String name;
	private int difficultyLevel = MIN_DIFFICULTY_LEVEL;
	private int totalPts = NUM_MAX_SKILL_POINTS;
	private int usedPts = 0;

	private TextView txtViewRmPts;
	private SeekBar barPilot;
	private SeekBar barFighter;
	private SeekBar barTrader;
	private SeekBar barEngineer;

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
				if (difficultyLevel < MAX_DIFFICULTY_LEVEL)
					setDifficultyLevel(++difficultyLevel);
			}

		});

		btnMinus.setOnClickListener(new View.OnClickListener() {
			public void onClick(View view) {
				if (difficultyLevel > MIN_DIFFICULTY_LEVEL)
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
		switch (lvl) {
		case 1:
			level.setText(LEVEL_EASY);
			break;
		case 2:
			level.setText(LEVEL_MEDIUM);
			break;
		case 3:
			level.setText(LEVEL_HARD);
			break;
		}
	}

	/** Called when the user clicks the START button */
	public void startGame(View view) {

		EditText editName = (EditText) findViewById(R.id.edit_name);
		name = String.valueOf(editName.getText());

		Button btnStart = (Button) findViewById(R.id.btn_start);

		if (usedPts != totalPts)
			btnStart.setText("Allocate your points, dudeee!");
		else
			btnStart.setText(name);

		// Do something in response to button
		// Intent intent = new Intent(this, DisplayMessageActivity.class);
		// EditText editText = (EditText) findViewById(R.id.edit_message);
		// String message = editText.getText().toString();
		// intent.putExtra(EXTRA_MESSAGE,message);
		// startActivity(intent);
	}
}
