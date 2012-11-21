package com.canefaitrien.spacetrader.presenters;

import java.util.Date;

import android.util.Log;

import com.canefaitrien.spacetrader.SpaceTrader;
import com.canefaitrien.spacetrader.dao.DaoSession;
import com.canefaitrien.spacetrader.dao.GameDataDao;
import com.canefaitrien.spacetrader.dao.MarketplaceDao;
import com.canefaitrien.spacetrader.dao.PersonDao;
import com.canefaitrien.spacetrader.dao.PlanetDao;
import com.canefaitrien.spacetrader.dao.ShipDao;
import com.canefaitrien.spacetrader.interfaces.IConfigurationView;
import com.canefaitrien.spacetrader.models.Controller;
import com.canefaitrien.spacetrader.models.Controller.Difficulty;
import com.canefaitrien.spacetrader.models.GameData;
import com.canefaitrien.spacetrader.models.Marketplace;
import com.canefaitrien.spacetrader.models.Person;
import com.canefaitrien.spacetrader.models.Planet;
import com.canefaitrien.spacetrader.models.Ship;

public class ConfigurationPresenter {

	private static final String TAG = "ConfigPresenter";
	@SuppressWarnings("unused")
	private IConfigurationView mView;

	public ConfigurationPresenter(IConfigurationView view) {
		mView = view;
	}

	public void createNewGame(String name, int pilotPts, int fighterPts,
			int traderPts, int engineerPts, String level) {

		Log.d(TAG, "" + pilotPts + " " + traderPts + " " + engineerPts + " "
				+ fighterPts);
		Log.d(TAG, level);

		Person person = new Person(null,// id
				name,//
				pilotPts, fighterPts,//
				traderPts, engineerPts);

		Controller ctrl = new Controller(person, Difficulty.valueOf(level));
		SpaceTrader.setController(ctrl);

	}

	public void storeNewGameData() {
		Controller ctrl = SpaceTrader.getController();

		DaoSession daoSession = SpaceTrader.daoSession;
		PersonDao personDao = daoSession.getPersonDao();
		PlanetDao planetDao = daoSession.getPlanetDao();
		MarketplaceDao marketplaceDao = daoSession.getMarketplaceDao();
		GameDataDao gameDataDao = daoSession.getGameDataDao();
		ShipDao shipDao = daoSession.getShipDao();

		Person person = ctrl.getPlayer();
		personDao.insert(person);
		Log.d(TAG, "Inserted new Person, ID: " + person.getId());

		Ship ship = ctrl.getShip();
		shipDao.insert(ship);

		GameData data = new GameData(null, person.getName(), //
				ctrl.getDifficulty().name(), //
				ctrl.getMoney(), //
				ctrl.getLocation().getName(), //
				ctrl.getTurn(), //
				new Date(0), //
				person.getId(),//
				ship.getId());

		gameDataDao.insert(data);
		Log.d(TAG, "Inserted new GameData, ID: " + data.getId());

		for (int i = 0; i < ctrl.getUniverse().length; i++) {
			Planet p = ctrl.getUniverse()[i];

			Marketplace mk = p.getMarketplace1();

			marketplaceDao.insert(mk);
			// Log.d(TAG, "Inserted new Marketplace, ID: " + mk.getId());

			p.setMarketId(mk.getId());
			p.setDataId(data.getId());

			planetDao.insert(p);
			// Log.d(TAG, "Inserted new Planet, ID: " + p.getId());
			// Log.d(TAG, "Inserted new Planet, data-ID: " + p.getDataId());
			// Log.d(TAG, "Inserted new Planet, market-ID: " + p.getMarketId());
		}

		SpaceTrader.setData(data);
	}
}