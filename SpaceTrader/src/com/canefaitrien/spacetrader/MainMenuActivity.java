package com.canefaitrien.spacetrader;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.canefaitrien.spacetrader.utils.AbstractActivity;

public class MainMenuActivity extends AbstractActivity {

	private Button button;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_mainmenu);
		// addSound();
		addListenerNewGameButton();
		addListenerResumeButton();
		addListenerLoadGameButton();
		// addListenerLoadGameButton();
		TextView txt = (TextView) findViewById(R.id.txtview_app_name);
		Typeface font = Typeface.createFromAsset(getAssets(),
				"fonts/Street Corner.ttf");
		txt.setTypeface(font);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

	private void addListenerNewGameButton() {
		final Context context = this;

		button = (Button) findViewById(R.id.btn_newgame);

		button.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				Intent intent = new Intent(context, ConfigurationActivity.class);
				startActivity(intent);

			}
		});
	}

	private void addListenerResumeButton() {

		button = (Button) findViewById(R.id.btn_resume);
		button.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				Intent intent = new Intent(MainMenuActivity.this,
						MainScreenActivity.class);
				startActivity(intent);
			}
		});
	}

	private void addListenerLoadGameButton() {
		// TODO Auto-generated method stub
		button = (Button) findViewById(R.id.btn_loadgame);
		button.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				Intent intent = new Intent(MainMenuActivity.this,
						LoadGameActivity.class);
				startActivity(intent);
			}
		});
	}

	private void addSound() {
		MediaPlayer track = MediaPlayer.create(MainMenuActivity.this,
				R.raw.funny);
		track.start();
	}
}
