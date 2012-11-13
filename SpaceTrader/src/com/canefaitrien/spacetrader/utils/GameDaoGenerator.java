/*
 * Copyright (C) 2011 Markus Junginger, greenrobot (http://greenrobot.de)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.canefaitrien.spacetrader.utils;

import de.greenrobot.daogenerator.DaoGenerator;
import de.greenrobot.daogenerator.Entity;
import de.greenrobot.daogenerator.Property;
import de.greenrobot.daogenerator.Schema;
import de.greenrobot.daogenerator.ToMany;

/**
 * Generates entities and DAOs for the example project DaoExample.
 * 
 * Run it as a Java application (not Android).
 * 
 * @author Markus
 */
public class GameDaoGenerator {

	public static void main(String[] args) throws Exception {
		Schema schema = new Schema(3, "com.canefaitrien.spacetrader");

		// addPerson(schema);

		// addGameData(schema);
		new DaoGenerator().generateAll(schema, "../SpaceTrader/src-gen");

	}

	private static void addGameData(Schema schema) {
		Entity data = schema.addEntity("GameData");
		data.addIdProperty().autoincrement().primaryKey();
		data.addDateProperty("date");

		// person
		Entity person = schema.addEntity("Person");
		person.addIdProperty().autoincrement().primaryKey();
		person.addStringProperty("name").notNull();
		person.addIntProperty("pilot_pts").notNull();
		person.addIntProperty("fighter_pts").notNull();
		person.addIntProperty("trader_pts").notNull();
		person.addIntProperty("engineer_pts").notNull();
		person.addStringProperty("name").notNull();
		Property dataId = person.addLongProperty("data_id").notNull()
				.getProperty();
		person.addToOne(data, dataId);

		// universe
		Entity universe = schema.addEntity("Universe");
		universe.addIdProperty();
		universe.addStringProperty("name").notNull();
		dataId = universe.addLongProperty("data_id").notNull().getProperty();
		universe.addToOne(data, dataId);

		// planets
		Entity planet = schema.addEntity("Planet");
		planet.setTableName("PLANETS"); // "ORDER" is a reserved keyword
		planet.addIdProperty();
		planet.addIntProperty("size");
		planet.addDoubleProperty("x_coordinate");
		planet.addDoubleProperty("y_coordinate");
		planet.addStringProperty("tech_level");
		planet.addStringProperty("situtation");
		// for testing
		planet.addIntProperty("x_offset");
		planet.addIntProperty("y_offset");
		Property universeId = planet.addLongProperty("universe_id").notNull()
				.getProperty();
		planet.addToOne(universe, universeId);

		ToMany universeToPlanets = universe.addToMany(planet, universeId);
		universeToPlanets.setName("planets");

		// market
		Entity market = schema.addEntity("MarketPlace");
		market.addIdProperty().autoincrement();
		market.addIntProperty("last_dock");
		market.addStringProperty("item_stock");
		market.addStringProperty("item_buy_prices"); // JSON data
		market.addStringProperty("item_sell_prices");
		Property planetId = market.addLongProperty("planet_id").notNull()
				.getProperty();
		market.addToOne(planet, planetId);
	}

	private static void addPerson(Schema schema) {
		Entity person = schema.addEntity("Person1");
		person.addIdProperty().autoincrement().primaryKey();
		person.addStringProperty("name").notNull();
		person.addIntProperty("pilot_pts").notNull();
		person.addIntProperty("fighter_pts").notNull();
		person.addIntProperty("trader_pts").notNull();
		person.addIntProperty("engineer_pts").notNull();
	}

	@SuppressWarnings("unused")
	private static void addMarketPlace(Schema schema) {
		Entity market = schema.addEntity("MarketPlace");
		market.addIdProperty().autoincrement();
		market.addLongProperty("planet_id");
		market.addIntProperty("last_dock");
		market.addStringProperty("item_stock");
		market.addStringProperty("item_buy_prices"); // JSON data
		market.addStringProperty("item_sell_prices");
		market.addStringProperty("tech_level");
		market.addStringProperty("situation");

	}

	// private static void addNote(Schema schema) {
	// Entity note = schema.addEntity("Note");
	// note.addIdProperty();
	// note.addStringProperty("text").notNull();
	// note.addStringProperty("comment");
	// note.addDateProperty("date");
	// }
	//
	// private static void addCustomerOrder(Schema schema) {
	// Entity customer = schema.addEntity("Customer");
	// customer.addIdProperty();
	// customer.addStringProperty("name").notNull();
	//
	// Entity order = schema.addEntity("Order");
	// order.setTableName("ORDERS"); // "ORDER" is a reserved keyword
	// order.addIdProperty();
	// Property orderDate = order.addDateProperty("date").getProperty();
	// Property customerId = order.addLongProperty("customerId").notNull()
	// .getProperty();
	// order.addToOne(customer, customerId);
	//
	// ToMany customerToOrders = customer.addToMany(order, customerId);
	// customerToOrders.setName("orders");
	// customerToOrders.orderAsc(orderDate);
	// }

}
