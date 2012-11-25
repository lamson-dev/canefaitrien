// $codepro.audit.disable largeNumberOfParameters
/**
 * Controller class which allows interaction between the Model and the View
 * 
 */
package com.canefaitrien.spacetrader.models;

import android.util.Log;

/**
 * 
 * @author Andrew
 * @version 1.0
 */
public class Controller {

	/**
	 * Field TAG.
	 * (value is ""Controller"")
	 */
	private static final String TAG = "Controller";

	// Controller constants
	/**
	 */
	public static enum Difficulty {
		/**
		 * Field EASY.
		 */
		EASY, /**
  * Field MEDIUM.
  */
 MEDIUM, /**
  * Field HARD.
  */
 HARD
	};

	/**
	 * Field STARTING_MONEY.
	 * (value is 500)
	 */
	private static final int STARTING_MONEY = 500;

	// Controller info
	/**
	 * Field player.
	 */
	private Person player;

	/**
	 * Field ship.
	 */
	private Ship ship;

	/**
	 * Field currentPlanet.
	 */
	private Planet currentPlanet;

	/**
	 * Field money.
	 */
	private int money;

	/**
	 * Field universe.
	 */
	private Planet[] universe;

	/**
	 * Field difficulty.
	 */
	private Difficulty difficulty;

	/**
	 * Field turn.
	 */
	private int turn;

	/**
	 * Constructor for Controller
	 * 
	 * @param player
	 * @param ship
	 * @param currentPlanet
	 * @param money
	 * @param universe
	 * @param difficulty
	 * @param turn
	 */
	public Controller(Person player, Ship ship, Planet currentPlanet,
			int money, Planet[] universe, Difficulty difficulty, int turn) {
		this.player = player;
		this.ship = ship;
		this.currentPlanet = currentPlanet;
		this.money = money;
		this.universe = universe.clone(); // will probably break the code
		this.difficulty = difficulty;
		this.turn = turn;
	}

	/**
	 * Constructor for Controller
	 * 
	 * @param player
	 * @param difficulty
	 */
	public Controller(Person player, Difficulty difficulty) {
		this(player, new Ship(ShipType.GNAT), null, STARTING_MONEY, Universe
				.generate(), difficulty, 0);
		// Planet must be set after this() because the universe has to be
		// created before we can set the first location
		currentPlanet = universe[0];
	}

	/**
	 * Player buys a good to be called from the view
	 * 
	 * @param good
	 *            Good to be bought by player
	
	 * @throws Exception
	 *             if not able to buy, get the reason using .getMessage() */
	public void buyGood(TradeGood good) throws Exception {
		money = currentPlanet.getMarketplace().buyGood(good, ship, money);
	}

	/**
	 * Player sells a good to be called by the view
	 * 
	 * @param good
	 *            Good to be sold
	
	 * @throws Exception
	 *             if not able to sell, get the reason using .getMessage() */
	public void sellGood(TradeGood good) throws Exception {
		money = currentPlanet.getMarketplace().sellGood(good, ship, money);
	}

	/**
	 * Move the player to a new Planet
	 * 
	 * @param destination
	 *            new target location
	
	 * @throws Exception
	 *             if not able to move, get the reason using .getMessage() */
	public void move(Planet destination) throws Exception {
		if (currentPlanet.distance(destination) > ship.getType().maxDistance
				* Ship.MPG) { // if planet is too far will need to change the
								// max distance constants to be more reasonable
			throw new Exception("That planet is too far, captain!");
		} else if (currentPlanet.distance(destination) > ship.getFuel()
				* Ship.MPG) { // if not enough fuel
			throw new Exception("We don't have enough fuel, captain!");

		} else {
			ship.setFuel(ship.getFuel() - currentPlanet.distance(destination)
					/ Ship.MPG);
			currentPlanet = destination;
			Log.d(TAG, currentPlanet.getName() + "/" + destination.getName());
			currentPlanet.dock(++turn); // update turn and dock to update
										// marketplace
		}
	}

	/**
	 * Method getPlayer.
	 * @return Person
	 */
	public Person getPlayer() {
		return player;
	}

	/**
	 * Method getShip.
	 * @return Ship
	 */
	public Ship getShip() {
		return ship;
	}

	/**
	 * Method getLocation.
	 * @return Planet
	 */
	public Planet getLocation() {
		return currentPlanet;
	}

	/**
	 * Method getUniverse.
	 * @return Planet[]
	 */
	public Planet[] getUniverse() {
		return universe;
	}

	/**
	 * Method getMoney.
	 * @return int
	 */
	public int getMoney() {
		return money;
	}

	/**
	 * Method getDifficulty.
	 * @return Difficulty
	 */
	public Difficulty getDifficulty() {
		return difficulty;
	}

	/**
	 * Method getTurn.
	 * @return int
	 */
	public int getTurn() {
		return turn;
	}

	/**
	 * Method setMoney.
	 * @param money int
	 */
	public void setMoney(int money) {
		this.money = money;
	}

	/**
	 * Method toString.
	 * @return String
	 */
	@Override
	public String toString() {
		return super.toString();
	}
}
