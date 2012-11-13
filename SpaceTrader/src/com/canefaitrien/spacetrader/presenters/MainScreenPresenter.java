package com.canefaitrien.spacetrader.presenters;

import java.util.Date;

import android.util.Log;

import com.canefaitrien.spacetrader.SpaceTrader;
import com.canefaitrien.spacetrader.dao.GameDataDao;
import com.canefaitrien.spacetrader.dao.MarketplaceDao;
import com.canefaitrien.spacetrader.dao.PersonDao;
import com.canefaitrien.spacetrader.dao.PlanetDao;
import com.canefaitrien.spacetrader.dao.ShipDao;
import com.canefaitrien.spacetrader.interfaces.IMainScreenView;
import com.canefaitrien.spacetrader.models.Controller;
import com.canefaitrien.spacetrader.models.Controller.Difficulty;
import com.canefaitrien.spacetrader.models.GameData;
import com.canefaitrien.spacetrader.models.Marketplace;
import com.canefaitrien.spacetrader.models.Person;
import com.canefaitrien.spacetrader.models.Planet;
import com.canefaitrien.spacetrader.models.Ship;

public class MainScreenPresenter {

	private static final String TAG = "MainScreenPresenter";
	private IMainScreenView mView;
	private GameDataDao gameDataDao;
	private ShipDao shipDao;
	private PersonDao personDao;
	private MarketplaceDao marketDao;
	private PlanetDao planetDao;

	public MainScreenPresenter(IMainScreenView view) {
		mView = view;
	}

	public void populateData(Long rowId) {

		if (rowId == null)
			throw new IllegalArgumentException(
					"Can't populate data since rowId is null");
		Log.d(TAG, "GameData ID is: " + String.valueOf(rowId));

		gameDataDao = SpaceTrader.daoSession.getGameDataDao();

		GameData game = gameDataDao.loadByRowId(rowId);
		Log.d(TAG, "loaded game " + game.getName());
		Log.d(TAG, "loaded game " + game.getMoney());
		Log.d(TAG, "current planet" + game.getStringCurrentPlanet());

		Person player = game.getPerson();
		Log.d(TAG, "loaded person" + player.getName());

		Ship ship = game.getShip();
		Log.d(TAG, "loaded ship" + ship.getStringType());
		int money = game.getMoney();
		Log.d(TAG, "loaded money " + String.valueOf(money));
		int turn = game.getTurn();
		Log.d(TAG, "loaded turn " + String.valueOf(turn));

		Planet[] universe = game.getUniverse();

		Planet currentPlanet = game.getCurrentPlanet();
		Log.d(TAG, "loaded currentPlanet: " + currentPlanet.getName());

		Log.d(TAG, "loaded difficulty " + game.getDifficulty());
		Difficulty difficulty = Difficulty.valueOf(game.getDifficulty());

		Controller ctrl = new Controller(player, ship, currentPlanet, money,
				universe, difficulty, turn);

		SpaceTrader.setController(ctrl);
		SpaceTrader.setData(game);

	}

	public void saveData() {
		personDao = SpaceTrader.daoSession.getPersonDao();
		shipDao = SpaceTrader.daoSession.getShipDao();
		marketDao = SpaceTrader.daoSession.getMarketplaceDao();
		
		Controller ctrl = SpaceTrader.getController();
		GameData data = SpaceTrader.getData();
		
		Person person = ctrl.getPlayer();
		Ship ship = ctrl.getShip();
		Planet currentPlanet = ctrl.getLocation();
		int money = ctrl.getMoney();
		int turn = ctrl.getTurn();
		Date date = new Date();
		
		data.setPerson(person);
		data.setShip(ship);
		data.setCurrentPlanet(currentPlanet);
		data.setDate(date);
		data.setMoney(money);
		data.setTurn(turn);
		data.update();

		personDao.update(person);
		shipDao.update(ship);

		Planet[] universe = ctrl.getUniverse();
		for (Planet p : universe) {
			marketDao.update(p.getMarketplace1());
			p.update();
		}

	}
}
