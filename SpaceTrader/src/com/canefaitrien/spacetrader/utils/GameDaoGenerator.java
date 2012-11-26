// $codepro.audit.disable com.instantiations.assist.eclipse.analysis.audit.rule.effectivejava.alwaysOverridetoString.alwaysOverrideToString
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
import de.greenrobot.daogenerator.ToOne;

/**
 * Generates entities and DAOs for the example project DaoExample.
 * 
 * Run it as a Java application (not Android).
 * 
 * @author Markus
 * @version 2.0
 */
public class GameDaoGenerator {

	/**
	 * Method main.
	 * @param args String[]
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		// Schema schema = new Schema(3, "de.greenrobot.daoexample");
		// addNote(schema);
		// addCustomerOrder(schema);
		// addGameData(schema);
		// new DaoGenerator().generateAll(schema, "../DaoExample/src-gen");

		Schema schema = new Schema(3, ""); // $codepro.audit.disable
											// numericLiterals

		addGameData(schema);

		String path = "../../../../Dropbox/programming/github/canefaitrien/SpaceTrader/src-gen"; // $codepro.audit.disable
																									// lineLength
		new DaoGenerator().generateAll(schema, path);

	}

	/**
	 * Method addGameData.
	 * @param schema Schema
	 */
	private static void addGameData(Schema schema) {
		// data
		final Entity data = schema.addEntity("GameData");
		data.addIdProperty().autoincrement().primaryKey();
		data.addStringProperty("name");
		data.addStringProperty("difficulty");
		data.addIntProperty("money");
		data.addStringProperty("currentPlanet");
		data.addIntProperty("turn");
		data.addDateProperty("date");

		// person
		final Entity person = schema.addEntity("Person");
		person.addIdProperty().autoincrement().primaryKey();
		person.addStringProperty("name");
		person.addIntProperty("pilotPts");
		person.addIntProperty("fighterPts");
		person.addIntProperty("traderPts");
		person.addIntProperty("engineerPts");
		final Property personId = data.addLongProperty("personId").getProperty();
		final ToOne dataToPerson = data.addToOne(person, personId);
		dataToPerson.setName("person");

		// ship
		final Entity ship = schema.addEntity("Ship");
		ship.addIdProperty().autoincrement().primaryKey();
		ship.addStringProperty("type");
		ship.addIntProperty("hullStrength");
		ship.addIntProperty("currentCargoHold");
		ship.addStringProperty("cargo");
		ship.addIntProperty("fuel");
		ship.addStringProperty("weapons");
		ship.addStringProperty("shields");
		ship.addStringProperty("gadgets");
		final Property shipId = data.addLongProperty("shipId").getProperty();
		final ToOne dataToShip = data.addToOne(ship, shipId);
		dataToShip.setName("ship");

		// planets
		final Entity planet = schema.addEntity("Planet");
		planet.setTableName("PLANETS"); // "ORDER" is a reserved keyword
		planet.addIdProperty().autoincrement();
		planet.addStringProperty("name");
		planet.addIntProperty("size");
		planet.addIntProperty("xCoordinate");
		planet.addIntProperty("yCoordinate");
		planet.addStringProperty("techLevel");
		planet.addStringProperty("situation");
		// for Daniel testing
		planet.addIntProperty("xOffset");
		planet.addIntProperty("yOffset");
		final Property dataId = planet.addLongProperty("dataId").getProperty();
		final ToMany dataToPlanets = data.addToMany(planet, dataId);
		dataToPlanets.setName("planets");

		// market
		final Entity market = schema.addEntity("Marketplace");
		market.addIdProperty().autoincrement().primaryKey();
		market.addIntProperty("lastDock");
		market.addStringProperty("itemStock");
		market.addStringProperty("itemBuyPrices"); // JSON data
		market.addStringProperty("itemSellPrices");
		final Property marketId = planet.addLongProperty("marketId").getProperty();
		final ToOne planetToMarket = planet.addToOne(market, marketId);
		planetToMarket.setName("marketplace");
	}

}
