package com.canefaitrien.spacetrader.models;

/**
 * 
 * 
 */

public class GameData {
	
	// Game info
	public enum Difficulty {Easy, Medium, Hard};
	private static final int STARTING_MONEY = 500;
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
	public GameData(Character player, Difficulty difficulty) {
		this(player, new Ship(ShipType.GNAT), null, STARTING_MONEY, new Universe(), difficulty, 0);
		location = universe.getPlanets()[0];
	}
	
	/**
	 * Buy a good
	 */
//	public void buyGood(TradeGood good, int price) throws NotEnoughMoneyException, CargoHullFullException, NoTradeGoodException {
//		if(price > money) {
//			throw new NotEnoughMoneyException("We don't have enough money, captain!");
//		} else if(location.getMarketplace().getItemStock()[good.ordinal()] == 0) {
//			throw new NoTradeGoodException("They don't have that good, captain!", good);
//		} else {
//			ship.addGood(good);
//			location.getMarketplace().buyGood(good);
//			money -= price; // if exception is thrown, this line shouldn't execute
//		}	
//	}
//	
//	/**
//	 * Sell a good
//	 */
//	public void sellGood(TradeGood good, int price) throws NoTradeGoodException {
//		if(location.getMarketplace().getItemSellPrices()[good.ordinal()] == 0) {
//			throw new NoTradeGoodException("", good);
//		} else {
//			ship.removeGood(good);
//			location.getMarketplace().sellGood(good);
//			money += price; // if exception is thrown, this line shouldn't execute
//		}
//	}

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
	
	public void setMoney(int money) {
		this.money = money;
	}
}
