package com.canefaitrien.spacetrader.models;

public class Character {

	private String name;
	private int pilotPts;
	private int fighterPts;
	private int traderPts;
	private int engineerPts;
	private int difficulty;
	private Ship ship;
	private Universe universe;
	
	public Character(String name, int pilotPts, int fighterPts, int traderPts,
			int engineerPts, int difficulty) {
		this.name = name;
		this.pilotPts = pilotPts;
		this.fighterPts = fighterPts;
		this.traderPts = traderPts;
		this.engineerPts = engineerPts;
		this.difficulty = difficulty;
		ship = new Ship(ShipType.Gnat);
		universe = new Universe();
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

	public String toString() {
		return "Name: " + name + "\nPilot: " + pilotPts + "\nTrader: " + traderPts + "\nFighter: "
				+ fighterPts + "\nEngineer: " + engineerPts + "\nDifficulty: " + difficulty;
	}

}
