// $codepro.audit.disable logExceptions
package com.canefaitrien.spacetrader.tests;

import java.util.Date;
import java.util.List;

import android.app.Application;
import android.graphics.Point;

import com.canefaitrien.spacetrader.dao.DaoMaster;
import com.canefaitrien.spacetrader.dao.DaoSession;
import com.canefaitrien.spacetrader.models.Controller;
import com.canefaitrien.spacetrader.models.Controller.Difficulty;
import com.canefaitrien.spacetrader.models.GameData;
import com.canefaitrien.spacetrader.models.Person;
import com.canefaitrien.spacetrader.models.Planet;
import com.canefaitrien.spacetrader.models.Situation;
import com.canefaitrien.spacetrader.models.TechLevel;

import de.greenrobot.dao.test.AbstractDaoSessionTest;

/**
 * test method getPlanets in GameData.java
 * 
 * @author Son Nguyen
 * 
 */

public class DataPlanetTest extends
		AbstractDaoSessionTest<Application, DaoMaster, DaoSession> {

	public DataPlanetTest() {
		super(DaoMaster.class);
	}

	private Controller ctrl;

	/**
	 * test One-To-Many Mapping relationship - One GameData to Many Planets
	 */
	public void testDataToPlanets() {

		Person player = new Person(null, "darnit", 5, 5, 5, 5);
		daoSession.insert(player);
		ctrl = new Controller(player, Difficulty.HARD);
		GameData data = new GameData(null, null, "Hard", 500, "Hello", 0,
				new Date(), player.getId(), ctrl.getShip().getId());
		daoSession.insert(ctrl.getShip());
		daoSession.insert(data);

		// insert many planets to PLANETS table
		addPlanetToData(data);

		List<Planet> planets = null;
		try {
			// get all planets of a specific data out
			planets = data.getPlanets();
		} catch (Exception e) {
			fail("this should not fail!");
		}

		// planets should not be null since it is added
		assertNotNull(planets);

		// number of planets got from the call should be equal to number of
		// planets added
		assertEquals(ctrl.getUniverse().length, planets.size());
	}

	/**
	 * test cached Planets
	 */
	public void testCachedPlanets() {
		Person player = new Person(null, "darnit", 5, 5, 5, 5);
		daoSession.insert(player);
		ctrl = new Controller(player, Difficulty.HARD);
		GameData data = new GameData(null, null, "Hard", 500, "Hello", 0,
				new Date(), ctrl.getPlayer().getId(), ctrl.getShip().getId());
		daoSession.insert(ctrl.getShip());
		daoSession.insert(data);

		// when planets are loaded for the first time, it is cached.
		// so when add more planets to the database
		// it should not modify the cached planets list

		// add planets to database
		addPlanetToData(data);
		// get list of planets out for the first time
		// this is cached
		List<Planet> planets = data.getPlanets();

		// add an extra planet to database
		Planet planet = new Planet("name", new Point(0, 0), TechLevel.HI_TECH,
				Situation.ARTISTIC);
		planet.setDataId(data.getId());
		daoSession.insert(planet);

		// get list of planets out, should be the cached list
		List<Planet> planets2 = data.getPlanets();

		// the two list must be the same;
		assertSame(planets, planets2);

		// reset cached list
		// retrieve the list one more time, now from database
		data.resetPlanets();
		List<Planet> planets3 = data.getPlanets();

		// the new list should have one more element
		assertEquals(planets.size() + 1, planets3.size());

	}

	/**
	 * when the is no daoSession, app doesn't connect to the database it should
	 * throw exception
	 */
	public void testNullDaoSession() {
		Person player = new Person(null, "darnit", 5, 5, 5, 5);
		daoSession.insert(player);

		ctrl = new Controller(player, Difficulty.HARD);
		GameData data = new GameData(null, null, "Hard", 500, "Hello", 0,
				new Date(), ctrl.getPlayer().getId(), ctrl.getShip().getId());

		// this will disconnect connection session
		// to the database
		daoSession = null;

		try {
			// list of planets can't be retrieved
			// since there is no connection
			@SuppressWarnings("unused")
			List<Planet> planets = data.getPlanets();
			fail("Should have thrown an exception for null daoSession, cannot retrieve data");
		} catch (Exception e) {
			assertTrue("Threw an exception like expected", true);
		}
	}

	/**
	 * insert planets object to table PLANETS in database
	 * 
	 * @param data
	 */
	private void addPlanetToData(GameData data) {
		for (int i = 0; i < ctrl.getUniverse().length; i++) {
			Planet planet = ctrl.getUniverse()[i];
			planet.setDataId(data.getId());
			daoSession.insert(planet);

		}
	}
}