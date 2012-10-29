package com.canefaitrien.spacetrader.models;

/**
 * 
 * 
 */

public class Character {

	private String name;
	private int pilotPts, fighterPts, traderPts, engineerPts;

	/**
	 * Constructor for loading
	 */
	public Character(String name, int pilotPts, int fighterPts, int traderPts,
			int engineerPts) {
		this.name = name;
		this.pilotPts = pilotPts;
		this.fighterPts = fighterPts;
		this.traderPts = traderPts;
		this.engineerPts = engineerPts;
	}

	public String toString() {
		return "Name: " + name + "\nPilot: " + pilotPts + "\nFighter: "
				+ fighterPts + "\nTrader: " + traderPts + "\nEngineer: "
				+ engineerPts;
	}

	/**
	 * getters and setters
	 */
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
}
