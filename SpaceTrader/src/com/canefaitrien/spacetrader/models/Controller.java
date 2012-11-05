package com.canefaitrien.spacetrader.models;


import com.canefaitrien.spacetrader.interfaces.IGameModel;

/**
 * Controller class which allows interaction between the Model and the View
 * 
 * @author Andrew
 * @version 1.0
 */

public class Controller {
	
	// Controller constants
	public static enum Difficulty {Easy, Medium, Hard};
	private static final int STARTING_MONEY = 500;
	
	// Controller info
	private Person player;
	private Ship ship;
	private Planet location;
	private int money; // might want to move this into Person? although it is easier to operate on in here
	
	private Planet[] universe;
	private Difficulty difficulty;
	private int turn;
	
	/** 
	 * Constructor for loading game data
	 */
	public Controller(Person player, Ship ship, Planet location, int money, Planet[] universe, Difficulty difficulty, int turn) {
		this.player = player;
		this.ship = ship;
		this.location = location;
		this.money = money;
		this.universe = universe;
		this.difficulty = difficulty;
		this.turn = turn;
	}
	
	/** 
	 * Constructor for new game
	 */
	public Controller(Person player, Difficulty difficulty) {
		this(player, new Ship(ShipType.GNAT), null, STARTING_MONEY, Universe.generate(), difficulty, 0);
		// Planet must be set after this() because the universe has to be created before we can set the first location
		location = universe[0];
	}
	
	/**
	 * Player buys a good to be called from the view
	 * 
	 * @param good Good to be bought by player
	 * @throws Exception if not able to buy, get the reason using .getMessage()
	 */
	public void buyGood(TradeGood good) throws Exception {
		money = location.getMarketplace().buyGood(good, ship, money);
	}
	
	/**
	 * Player sells a good to be called by the view
	 * 
	 * @param good Good to be sold
	 * @throws Exception if not able to sell, get the reason using .getMessage()
	 */
	public void sellGood(TradeGood good) throws Exception {
		money = location.getMarketplace().sellGood(good, ship, money);
	}
	
	/**
	 * Move the player to a new Planet
	 * 
	 * @param destination new target location
	 * @throws Exception if not able to move, get the reason using .getMessage()
	 */
	public void move(Planet destination) throws Exception {
		if(location.distance(destination) > ship.getType().MAX_DISTANCE*Ship.MPG) { // if planet is too far      will need to change the max distance constants to be more reasonable
			throw new Exception("That planet is too far, captain!");
		} else if(location.distance(destination) > ship.getFuel()*Ship.MPG) { // if not enough fuel
			throw new Exception("We don't have enough fuel, captain!");
		} else {
			ship.setFuel(ship.getFuel() - location.distance(destination)/Ship.MPG);
			location = destination;
			location.dock(++turn); // update turn and dock to update marketplace
		}
	}
	
	public Person getPlayer() {
		return player;
	}
	
	public Ship getShip() {
		return ship;
	}
	
	public Planet getLocation() {
		return location;
	}
	public Planet[] getUniverse() {
		return universe;
	}

	public int getMoney() {
		return money;
	}

	public Difficulty getDifficulty() {
		return difficulty;
	}
	
	public int getTurn() {
		return turn;
	}

	// This is added by An Pham on 05/11/12
	// This method should only be called from EncounterHandler
	// Do not call this method elsewhere.
	public void setMoney(int money){
		this.money = money;
	}
}

