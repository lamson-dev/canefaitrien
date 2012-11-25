// $codepro.audit.disable largeNumberOfParameters
/**
 * Person class for holding info on the Person
 * 
 * @author Andrew Duda
 * @version 1.0
 */

package com.canefaitrien.spacetrader.models;

/**
 * 
 * @author Son Nguyen
 *
 * @version $Revision: 1.0 $
 */
public class Person {

	/**
	 * Field id.
	 */
	private Long id;

	/** Not-null value. */
	private String name;

	/**
	 * Field pilotPts.
	 */
	private int pilotPts;

	/**
	 * Field fighterPts.
	 */
	private int fighterPts;

	/**
	 * Field traderPts.
	 */
	private int traderPts;

	/**
	 * Field engineerPts.
	 */
	private int engineerPts;

	/**
	 * Constructor for Person
	 */
	public Person() { // $codepro.audit.disable emptyMethod
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

	/**
	 * Method getId.
	 * @return Long
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Method setId.
	 * @param id Long
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Method toString.
	 * @return String
	 */
	public String toString() {
		return "Name: " + name + 
				"\nPilot:    " + pilotPts + 
				"\nFighter:  " + fighterPts + 
				"\nTrader:   " + traderPts + 
				"\nEngineer: " + engineerPts;
	}

	/**
	 * Method getName.
	 * @return String
	 */
	public String getName() {
		return name;
	}

	/**
	 * Method setName.
	 * @param name String
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Method getPilotPts.
	 * @return int
	 */
	public int getPilotPts() {
		return pilotPts;
	}

	/**
	 * Method setPilotPts.
	 * @param pilotPts int
	 */
	public void setPilotPts(int pilotPts) {
		this.pilotPts = pilotPts;
	}

	/**
	 * Method getFighterPts.
	 * @return int
	 */
	public int getFighterPts() {
		return fighterPts;
	}

	/**
	 * Method setFighterPts.
	 * @param fighterPts int
	 */
	public void setFighterPts(int fighterPts) {
		this.fighterPts = fighterPts;
	}

	/**
	 * Method getTraderPts.
	 * @return int
	 */
	public int getTraderPts() {
		return traderPts;
	}

	/**
	 * Method setTraderPts.
	 * @param traderPts int
	 */
	public void setTraderPts(int traderPts) {
		this.traderPts = traderPts;
	}

	/**
	 * Method getEngineerPts.
	 * @return int
	 */
	public int getEngineerPts() {
		return engineerPts;
	}

	/**
	 * Method setEngineerPts.
	 * @param engineerPts int
	 */
	public void setEngineerPts(int engineerPts) {
		this.engineerPts = engineerPts;
	}

}
