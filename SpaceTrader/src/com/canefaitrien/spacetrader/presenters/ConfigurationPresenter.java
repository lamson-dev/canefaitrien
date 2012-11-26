// $codepro.audit.disable com.instantiations.assist.eclipse.analysis.audit.rule.effectivejava.alwaysOverridetoString.alwaysOverrideToString
/**
 * configuration presenter
 */
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

/**
 * 
 * @author Son Nguyen
 * @version $Revision: 1.0 $
 */
public class ConfigurationPresenter {

	/**
	 * Field TAG. (value is ""ConfigPresenter"")
	 */
	private static final String TAG = "ConfigPresenter";

	/**
	 * Field mView.
	 */
	@SuppressWarnings("unused")
	private final IConfigurationView mView;

	/**
	 * Constructor for ConfigurationPresenter.
	 * 
	 * @param view
	 *            IConfigurationView
	 */
	public ConfigurationPresenter(IConfigurationView view) {
		mView = view;
	}

	public void createNewGame(String name, int pilotPts, int fighterPts, // $codepro.audit.disable
																			// largeNumberOfParameters
			int traderPts, int engineerPts, String level) {

		Log.d(TAG, "" + pilotPts + " " + traderPts + " " + engineerPts + " "
				+ fighterPts);
		Log.d(TAG, level);

		final Person person = new Person(null, // id
				name, //
				pilotPts, fighterPts, //
				traderPts, engineerPts);

		final Controller ctrl = new Controller(person, Difficulty.valueOf(level));
		SpaceTrader.setController(ctrl);

	}

	/**
	 * Method storeNewGameData.
	 */
	public void storeNewGameData() {
		final Controller ctrl = SpaceTrader.getController();

		final DaoSession daoSession = SpaceTrader.daoSession;
		final PersonDao personDao = daoSession.getPersonDao();
		final PlanetDao planetDao = daoSession.getPlanetDao();
		final MarketplaceDao marketplaceDao = daoSession.getMarketplaceDao();
		final GameDataDao gameDataDao = daoSession.getGameDataDao();
		final ShipDao shipDao = daoSession.getShipDao();

		final Person person = ctrl.getPlayer();
		personDao.insert(person);
		Log.d(TAG, "Inserted new Person, ID: " + person.getId());

		final Ship ship = ctrl.getShip();
		shipDao.insert(ship);

		final GameData data = new GameData(null, person.getName(), //
				ctrl.getDifficulty().name(), //
				ctrl.getMoney(), //
				ctrl.getLocation().getName(), //
				ctrl.getTurn(), //
				new Date(0), //
				person.getId(), //
				ship.getId());

		gameDataDao.insert(data);
		Log.d(TAG, "Inserted new GameData, ID: " + data.getId());

		for (int i = 0; i < ctrl.getUniverse().length; i++) {
			Planet planet = ctrl.getUniverse()[i];

			Marketplace mk = planet.getMarketplace1();

			marketplaceDao.insert(mk);
			// Log.d(TAG, "Inserted new Marketplace, ID: " + mk.getId());

			planet.setMarketId(mk.getId());
			planet.setDataId(data.getId());

			planetDao.insert(planet);
			// Log.d(TAG, "Inserted new Planet, ID: " + p.getId());
			// Log.d(TAG, "Inserted new Planet, data-ID: " + p.getDataId());
			// Log.d(TAG, "Inserted new Planet, market-ID: " + p.getMarketId());
		}

		SpaceTrader.setData(data);
	}
}