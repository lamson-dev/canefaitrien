package com.canefaitrien.spacetrader.presenters;

import java.util.List;

import android.database.Cursor;
import android.util.Log;

import com.canefaitrien.spacetrader.Controller;
import com.canefaitrien.spacetrader.Controller.Difficulty;
import com.canefaitrien.spacetrader.SpaceTrader;
import com.canefaitrien.spacetrader.dao.GameDataDao;
import com.canefaitrien.spacetrader.dao.MarketplaceDao;
import com.canefaitrien.spacetrader.dao.PersonDao;
import com.canefaitrien.spacetrader.dao.PlanetDao;
import com.canefaitrien.spacetrader.interfaces.IMainScreenView;
import com.canefaitrien.spacetrader.models.GameData;
import com.canefaitrien.spacetrader.models.Person;
import com.canefaitrien.spacetrader.models.Planet;
import com.canefaitrien.spacetrader.models.Ship;

public class MainScreenPresenter {

	private static final String TAG = "MainScreenPresenter";
	private IMainScreenView mView;
	private GameDataDao gameDataDao;
	private PlanetDao planetDao;
	private PersonDao personDao;
	private MarketplaceDao marketplaceDao;

	private Cursor cursor;

	public MainScreenPresenter(IMainScreenView view) {
		mView = view;
	}

	public void populateData(Long mRowId) {

		if (mRowId == null)
			return;
		Log.d(TAG, "GameData ID is: " + String.valueOf(mRowId));

		gameDataDao = SpaceTrader.daoSession.getGameDataDao();
		planetDao = SpaceTrader.daoSession.getPlanetDao();
		personDao = SpaceTrader.daoSession.getPersonDao();
		marketplaceDao = SpaceTrader.daoSession.getMarketplaceDao();

		cursor = SpaceTrader.db.query(gameDataDao.getTablename(),
				gameDataDao.getAllColumns(), null, null, null, null, null);

		GameData game = gameDataDao.loadByRowId(mRowId);
		Log.d(TAG, "loaded game " + String.valueOf(game.getId()));
		Log.d(TAG, "loaded game " + game.getDifficulty());
		Log.d(TAG, "loaded game " + game.getName());
		Log.d(TAG, "loaded game " + game.getStringCurrentPlanet());
		Log.d(TAG, "loaded game " + game.getMoney());

		Person player = game.getPerson();
		Log.d(TAG, "loaded person" + player.toString());

		Ship ship = null;

		Log.d(TAG, "problematic");
		List<Planet> p = game.getPlanets();
		Log.d(TAG, String.valueOf(p.size()));
		// List<Planet> planets = game.getPlanets();
		// Log.d(TAG, "you got here?");
		// Log.d(TAG, String.valueOf(planets.size()));

		// Planet[] universe = game.getUniverse();
		// Log.d(TAG, "loaded universe  " + game.getPlanets().size());

		// Planet currentPlanet = universe[game.getCurrentPlanetIndex()];
		// Log.d(TAG, "loaded currentPlanet  " + game.getPlanets().size());
		// Log.d(TAG, "loaded curPlanet location " +
		// game.getCurrentPlanetIndex());

		int money = game.getMoney();
		Log.d(TAG, "loaded money " + String.valueOf(money));

		Log.d(TAG, "loaded difficulty " + game.getDifficulty());
		Difficulty difficulty = Difficulty.valueOf(game.getDifficulty());
		int turn = game.getTurn();
		Log.d(TAG, "loaded turn " + String.valueOf(turn));

		// Controller data = new Controller(player, ship, currentPlanet, money,
		// universe, difficulty, turn);
		Controller ctrl = new Controller(player, ship, null, money, null,
				difficulty, turn);

		SpaceTrader.setController(ctrl);

		cursor.close();

	}
}
