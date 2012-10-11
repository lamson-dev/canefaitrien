package com.canefaitrien.spacetrader.models;

public class Character {

	private String name;
	private int pilotPts;
	private int fighterPts;
	private int traderPts;
	private int engineerPts;
	private Ship ship;
	private int difficulty;
	
	public Character(String name, int pilotPts, int fighterPts, int traderPts,
			int engineerPts, int difficulty) {
		this.name = name;
		this.pilotPts = pilotPts;
		this.fighterPts = fighterPts;
		this.traderPts = traderPts;
		this.engineerPts = engineerPts;
		ship = new Ship(ShipType.Gnat);
		this.difficulty = difficulty;
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
	
	public String toString() {
		return "Name: " + name + "Engineer: " + engineerPts + "Pilot: " + pilotPts + "Trader: " + traderPts + "Fighter: " + fighterPts + "Difficulty: " + difficulty;
	}

}
