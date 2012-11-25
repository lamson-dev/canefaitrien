/**
 * TechLevel enum for Planets
 * 
 * @author Andrew Duda
 * @version 1.0
 */

package com.canefaitrien.spacetrader.models;

public enum TechLevel {
	PRE_AGRICULTURAL("PreAgricultural"), AGRICULTURAL("Agricultural"), MEDIEVAL(
			"Medieval"), RENAISSANCE("Renaissance"), EARLY_INDUSTRIAL(
			"Early Industrial"), INDUSTRIAL("Industrial"), POST_INDUSTRIAL(
			"Post Industrial"), HI_TECH("HiTech");

	// TechLevel info
	public final String name; // Needs a name to print out multi-word situations

	/**
	 * Constructor for TechLevel
	 * 
	 * @param name
	 */
	private TechLevel(String name) {
		this.name = name;
	}

	public String toString() {
		return name;
	}

	/**
	 * Method which creates a TechLevel from a String of the name
	 * 
	 * @param name
	 * @return TechLevel of the String
	 */
	public static TechLevel fromString(String name) {
		if (name != null) {
			for (TechLevel level : TechLevel.values()) {
				if (name.equalsIgnoreCase(level.name)) {
					return level;
				}
			}
		}
		throw new IllegalArgumentException("No constant with name " + name
				+ " found");
	}
}