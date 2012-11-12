package com.canefaitrien.spacetrader;

import java.util.Date;
import java.util.List;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;

import com.canefaitrien.spacetrader.Controller.Difficulty;
import com.canefaitrien.spacetrader.dao.GameDataDao;
import com.canefaitrien.spacetrader.dao.MarketplaceDao;
import com.canefaitrien.spacetrader.dao.PersonDao;
import com.canefaitrien.spacetrader.dao.PlanetDao;
import com.canefaitrien.spacetrader.interfaces.GameConstants;
import com.canefaitrien.spacetrader.models.GameData;
import com.canefaitrien.spacetrader.models.Marketplace;
import com.canefaitrien.spacetrader.models.Person;
import com.canefaitrien.spacetrader.models.Planet;
import com.canefaitrien.spacetrader.utils.AbstractActivity;
import com.canefaitrien.spacetrader.utils.Tools;

public class ConfigurationActivity extends AbstractActivity implements
		GameConstants, OnClickListener, OnSeekBarChangeListener {

	private static final String TAG = "Configuration";

	private String name;
	private SeekBar barPilot;
	private SeekBar barFighter;
	private SeekBar barTrader;
	private SeekBar barEngineer;
	private int level = 0;
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

	private PersonDao personDao;
	private PlanetDao planetDao;
	private GameDataDao gameDataDao;
	private Cursor cursor;

	private MarketplaceDao marketplaceDao;

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

		personDao = SpaceTrader.daoSession.getPersonDao();
		planetDao = SpaceTrader.daoSession.getPlanetDao();
		marketplaceDao = SpaceTrader.daoSession.getMarketplaceDao();
		gameDataDao = SpaceTrader.daoSession.getGameDataDao();

		Person person = new Person(null, name, barPilot.getProgress(),
				barFighter.getProgress(), barTrader.getProgress(),
				barEngineer.getProgress());
		personDao.insert(person);
		Log.d(TAG, "Inserted new Person, ID: " + person.getId());

		Controller ctrl = new Controller(person, difficulties[level]);
		GameData data = new GameData(null, name, ctrl.getDifficulty().name(),
				ctrl.getMoney(), ctrl.getLocation().getName(), 0, new Date(),
				person.getId());
		gameDataDao.insert(data);
		Log.d(TAG, "Inserted new GameData, ID: " + data.getId());

		// for (Planet p : ctrl.getUniverse()) {
		for (int i = 0; i < 10; i++) {
			Planet p = ctrl.getUniverse()[i];

			Marketplace mk = p.getMarketplace1();// p.getMarketplace1();

			marketplaceDao.insert(mk);
			Log.d(TAG, "Inserted new Marketplace, ID: " + mk.getId());
			Log.d(TAG, mk.getStringItemStock());
			Log.d(TAG, mk.getStringItemBuyPrices());

			p.setMarketId(mk.getId());
			p.setDataId(data.getId());
			planetDao.insert(p);
			
			Log.d(TAG, "Inserted new Planet, ID: " + p.getId());
			Log.d(TAG, "Inserted new Planet, data-ID: " + p.getDataId());
			Log.d(TAG, "Inserted new Planet, market-ID: " + p.getMarketId());
		}
		
		Log.d(TAG, "problematic");
		List<Planet> p = data.getPlanets();
		Log.d(TAG, String.valueOf(p.size()));
		
		GameData game = gameDataDao.loadByRowId(data.getId());
		Log.d(TAG, "loaded game");
		
		Log.d(TAG, "problematic");
		List<Planet> planets = game.getPlanets();
		Log.d(TAG, String.valueOf(planets.size()));
		
		SpaceTrader.setController(ctrl);
		SpaceTrader.setData(data);
		
		Log.d(TAG, "problematic");
		planets = SpaceTrader.getData().getPlanets();
		Log.d(TAG, String.valueOf(planets.size()));

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

	@Override
	protected void onStart() {
		super.onStart();
		Log.d(TAG, "onStart called.");
	}

	@Override
	protected void onPause() {
		super.onPause();
		Log.d(TAG, "onPause called.");
	}

	@Override
	protected void onResume() {
		super.onResume();
		Log.d(TAG, "onResume called.");
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

	@Override
	protected void onDestroy() {
		super.onDestroy();
	}

}
