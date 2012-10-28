package com.canefaitrien.spacetrader.models;

/*
 * 
 * 
 */

public class Character {
	
	// Character info
	private static final int STARTING_MONEY = 1000;
	private String name;
	private int pilotPts, fighterPts, traderPts, engineerPts;
	private int difficulty;
	private int money;

	
	// Game info (maybe put in a new class)
	private static enum Difficulty {EASY, MEDIUM, HARD}
	private Ship ship;
	private Universe universe;
	private String date;
	/* 
	 * Constructor for loading
	 * 
	 */
	public Character(String name, int pilotPts, int fighterPts, int traderPts,
			int engineerPts, int money, int difficulty, Ship ship, Universe universe) {
		this.name = name;
		this.pilotPts = pilotPts;
		this.fighterPts = fighterPts;
		this.traderPts = traderPts;
		this.engineerPts = engineerPts;
		this.money = money;
		this.difficulty = difficulty;
		setDate("today");
		this.ship = ship;
		this.universe = universe;
	}
	
	/* 
	 * Constructor for new game
	 * 
	 */
	public Character(String name, int pilotPts, int fighterPts, int traderPts,
			int engineerPts, int difficulty) {
		this(name, pilotPts, fighterPts, traderPts, engineerPts, difficulty, STARTING_MONEY, new Ship(ShipType.Gnat), new Universe());
	}
	
	public String getName() {
		return name;
	}

	public int getPilotPts() {
		return pilotPts;
	}

	public int getFighterPts() {
		return fighterPts;
	}

	public int getTraderPts() {
		return traderPts;
	}

	public int getEngineerPts() {
		return engineerPts;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPilotPts(int pilotPts) {
		this.pilotPts = pilotPts;
	}

	public void setFighterPts(int fighterPts) {
		this.fighterPts = fighterPts;
	}

	public void setTraderPts(int traderPts) {
		this.traderPts = traderPts;
	}

	public void setEngineerPts(int engineerPts) {
		this.engineerPts = engineerPts;
	}

	public Universe getUniverse() {
		return universe;
	}

	public void setUniverse(Universe universe) {
		this.universe = universe;
	}
	
	public void addGood(TradeGood good) {
		ship.addGood(good);
	}

	public String toString() {
		return "Name: " + name + "\nPilot: " + pilotPts + "\nTrader: "
				+ traderPts + "\nFighter: " + fighterPts + "\nEngineer: "
				+ engineerPts + "\nDifficulty: " + difficulty;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public int getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(int difficulty) {
		this.difficulty = difficulty;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
}
