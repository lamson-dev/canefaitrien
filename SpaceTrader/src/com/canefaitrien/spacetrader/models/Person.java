package com.canefaitrien.spacetrader.models;

/**
 * Person class for holding info on the Person
 * 
 * @author Andrew Duda
 * @version 1.0
 */
public class Person {

	private Long id;

	/** Not-null value. */
	private String name;

	private int pilotPts;

	private int fighterPts;

	private int traderPts;

	private int engineerPts;

	/**
	 * Constructor for Person
	 */
	public Person() {
	}

	/**
	 * Constructor for Person
	 * @param id
	 */
	public Person(Long id) {
		this.id = id;
	}

	/**
	 * Constructor for Person
	 * @param id
	 * @param name
	 * @param pilotPts
	 * @param fighterPts
	 * @param traderPts
	 * @param engineerPts
	 */
	public Person(Long id, String name, int pilotPts, int fighterPts,
			int traderPts, int engineerPts) {
		this.id = id;
		this.name = name;
		this.pilotPts = pilotPts;
		this.fighterPts = fighterPts;
		this.traderPts = traderPts;
		this.engineerPts = engineerPts;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String toString() {
		return "Name: " + name + 
				"\nPilot:    " + pilotPts + 
				"\nFighter:  " + fighterPts + 
				"\nTrader:   " + traderPts + 
				"\nEngineer: " + engineerPts;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPilotPts() {
		return pilotPts;
	}

	public void setPilotPts(int pilotPts) {
		this.pilotPts = pilotPts;
	}

	public int getFighterPts() {
		return fighterPts;
	}

	public void setFighterPts(int fighterPts) {
		this.fighterPts = fighterPts;
	}

	public int getTraderPts() {
		return traderPts;
	}

	public void setTraderPts(int traderPts) {
		this.traderPts = traderPts;
	}

	public int getEngineerPts() {
		return engineerPts;
	}

	public void setEngineerPts(int engineerPts) {
		this.engineerPts = engineerPts;
	}

}
