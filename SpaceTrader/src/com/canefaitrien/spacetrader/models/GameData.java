package com.canefaitrien.spacetrader.models;

import com.canefaitrien.spacetrader.exceptions.*;

/**
 * 
 * 
 */

public class GameData {
	
	// Game info
	public static enum Difficulty {Easy, Medium, Hard};
	private static final int STARTING_MONEY = 100;
	private Character player;
	private Ship ship;
	private Planet location;
	private int money;
	
	private Universe universe;
	private Difficulty difficulty;
	private int turn;
	
	/** 
	 * Constructor for loading
	 */
	public GameData(Character player, Ship ship, Planet location, int money, Universe universe, Difficulty difficulty, int turn) {
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
	public GameData(Character player, Universe universe, Difficulty difficulty) {
		this(player, new Ship(ShipType.GNAT), universe.getPlanets()[0], STARTING_MONEY, universe, difficulty, 0);
	}
	
	/**
	 * Buy a good
	 */
	public void buyGood(TradeGood good, int price) throws NotEnoughMoneyException, CargoHullFullException {
		if(price > money) {
			throw new NotEnoughMoneyException("We don't have enough money, captain!");
		} else {
			ship.addGood(good);
			money -= price; // if exception is thrown, this line shouldn't execute
		}	
	}
	
	/**
	 * Sell a good
	 */
	public void sellGood(TradeGood good, int price) throws NoTradeGoodException {
		ship.removeGood(good);
		money += price; // if exception is thrown, this line shouldn't execute
	}

	public Character getPlayer() {
		return player;
	}
	
	public Ship getShip() {
		return ship;
	}
	
	public Planet getLocation() {
		return location;
	}
	public Universe getUniverse() {
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
}
