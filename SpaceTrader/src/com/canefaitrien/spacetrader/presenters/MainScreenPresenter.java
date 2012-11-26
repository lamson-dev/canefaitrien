// $codepro.audit.disable com.instantiations.assist.eclipse.analysis.audit.rule.effectivejava.alwaysOverridetoString.alwaysOverrideToString
/**
 * mainscreen presenter
 */
package com.canefaitrien.spacetrader.presenters;

import java.util.Date;

import android.util.Log;

import com.canefaitrien.spacetrader.SpaceTrader;
import com.canefaitrien.spacetrader.dao.GameDataDao;
import com.canefaitrien.spacetrader.dao.MarketplaceDao;
import com.canefaitrien.spacetrader.dao.PersonDao;
import com.canefaitrien.spacetrader.dao.ShipDao;
import com.canefaitrien.spacetrader.interfaces.IMainScreenView;
import com.canefaitrien.spacetrader.models.Controller;
import com.canefaitrien.spacetrader.models.Controller.Difficulty;
import com.canefaitrien.spacetrader.models.GameData;
import com.canefaitrien.spacetrader.models.Person;
import com.canefaitrien.spacetrader.models.Planet;
import com.canefaitrien.spacetrader.models.Ship;

/**
 * @author Son Nguyen
 * @version $Revision: 1.0 $
 */
public class MainScreenPresenter {

	/**
	 * Field TAG.
	 * (value is ""MainScreenPresenter"")
	 */
	private static final String TAG = "MainScreenPresenter";

	/**
	 * Field mView.
	 */
	@SuppressWarnings("unused")
	private final IMainScreenView mView;

	/**
	 * Field gameDataDao.
	 */
	private GameDataDao gameDataDao;

	/**
	 * Field shipDao.
	 */
	private ShipDao shipDao;

	/**
	 * Field personDao.
	 */
	private PersonDao personDao;

	/**
	 * Field marketDao.
	 */
	private MarketplaceDao marketDao;

	/**
	 * Constructor for MainScreenPresenter.
	 * @param view IMainScreenView
	 */
	public MainScreenPresenter(IMainScreenView view) {
		mView = view;
	}

	/**
	 * Method populateData.
	 * @param rowId Long
	 */
	public void populateData(Long rowId) {

		if (rowId == null) {
			throw new IllegalArgumentException(
					"Can't populate data since rowId is null");
		}
		Log.d(TAG, "GameData ID is: " + String.valueOf(rowId));

		gameDataDao = SpaceTrader.daoSession.getGameDataDao();

		final GameData game = gameDataDao.loadByRowId(rowId);
		// Log.d(TAG, "loaded game " + game.getName());
		// Log.d(TAG, "loaded game " + game.getMoney());
		// Log.d(TAG, "current planet " + game.getStringCurrentPlanet());

		final Person player = game.getPerson();
		// Log.d(TAG, "loaded person" + player.getName());

		final Ship ship = game.getShip();
		// Log.d(TAG, "loaded ship" + ship.getStringType());
		final int money = game.getMoney();
		final int turn = game.getTurn();
		// Log.d(TAG, "loaded turn " + String.valueOf(turn));

		final Planet[] universe = game.getUniverse();

		final Planet currentPlanet = game.getCurrentPlanet();
		// Log.d(TAG, "loaded currentPlanet: " + currentPlanet.getName());
		// Log.d(TAG, "loaded difficulty " + game.getDifficulty());

		final Difficulty difficulty = Difficulty.valueOf(game.getDifficulty());

		final Controller ctrl = new Controller(player, ship, currentPlanet, money,
				universe, difficulty, turn);

		SpaceTrader.setController(ctrl);
		SpaceTrader.setData(game);

	}

	/**
	 * Method saveData.
	 */
	public void saveData() {

		personDao = SpaceTrader.daoSession.getPersonDao();
		shipDao = SpaceTrader.daoSession.getShipDao();
		marketDao = SpaceTrader.daoSession.getMarketplaceDao();

		final Controller ctrl = SpaceTrader.getController();
		final GameData data = SpaceTrader.getData();

		final Person person = ctrl.getPlayer();
		final Ship ship = ctrl.getShip();
		final Planet currentPlanet = ctrl.getLocation();
		final int money = ctrl.getMoney();
		Log.d(TAG, "money left: " + String.valueOf(money));
		final int turn = ctrl.getTurn();
		final Date date = new Date();

		data.setPerson(person);
		data.setShip(ship);
		data.setCurrentPlanet(currentPlanet);
		data.setDate(date);
		data.setMoney(money);
		data.setTurn(turn);
		data.update();

		personDao.update(person);
		shipDao.update(ship);

		// should do something so that
		// it only update the "modified" planets & marketplace
		// don't update the whole thing, too long
		final Planet[] universe = ctrl.getUniverse();
		for (Planet p : universe) {
			marketDao.update(p.getMarketplace1());
			p.update();
		}

	}

}
