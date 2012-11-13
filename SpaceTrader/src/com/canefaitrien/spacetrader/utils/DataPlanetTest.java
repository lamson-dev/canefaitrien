package com.canefaitrien.spacetrader.utils;

import java.util.Date;
import java.util.List;

import android.app.Application;

import com.canefaitrien.spacetrader.dao.DaoMaster;
import com.canefaitrien.spacetrader.dao.DaoSession;
import com.canefaitrien.spacetrader.models.Controller;
import com.canefaitrien.spacetrader.models.Controller.Difficulty;
import com.canefaitrien.spacetrader.models.GameData;
import com.canefaitrien.spacetrader.models.Person;
import com.canefaitrien.spacetrader.models.Planet;
import com.canefaitrien.spacetrader.models.Ship;

import de.greenrobot.dao.test.AbstractDaoSessionTest;

public class DataPlanetTest extends
		AbstractDaoSessionTest<Application, DaoMaster, DaoSession> {

	public DataPlanetTest() {
		super(DaoMaster.class);
	}

	Controller data;

	public void testDataToPlanets() {

		Person player = new Person(null, "darnit", 5, 5, 5, 5);
		daoSession.insert(player);
		
		Ship ship = new Ship();
		daoSession.insert(ship);
		GameData game = new GameData(null, null, "Hard", 500, "Hello", 0,
				new Date(), player.getId(), ship.getId());

		data = new Controller(player, Difficulty.Hard);

		daoSession.insert(game);

		addPlanetToData(game);

		List<Planet> planets = game.getPlanets();
		assertEquals(2, planets.size());
	}

	private void addPlanetToData(GameData game) {

		// for (Planet p : data.getUniverse()) {
		for (int i = 0; i < 10; i++) {
			Planet p = data.getUniverse()[i];

			// Marketplace mk = p.getMarketplace1();// p.getMarketplace1();
			// marketplaceDao.insert(mk);

			// p.setMarketId(mk.getId());
			p.setDataId(game.getId());
			daoSession.insert(p);

		}
	}

	// public void testOrderToCustomer() {
	// Customer customer = new Customer(null, "greenrobot");
	// daoSession.insert(customer);
	//
	// Order order = addOrderToCustomer(customer);
	// Customer customer2 = order.getCustomer();
	//
	// assertSame(customer, customer2);
	// }

	// public void testUpdateBirectional() {
	// Customer customer = new Customer(null, "greenrobot");
	// daoSession.insert(customer);
	//
	// addOrderToCustomer(customer);
	// List<Order> orders = customer.getOrders();
	//
	// Order newOrder = new Order();
	// newOrder.setCustomer(customer);
	// daoSession.insert(newOrder);
	// orders.add(newOrder);
	// assertEquals(2, orders.size());
	//
	// customer.resetOrders();
	// List<Order> orders2 = customer.getOrders();
	// assertEquals(orders.size(), orders2.size());
	// }

}
