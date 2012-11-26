/**
 * TechLevel enum for Planets
 * 
 * @author Andrew Duda
 * @version 1.0
 */

package com.canefaitrien.spacetrader.models;

/**
 */
public enum TechLevel {
	/**
	 * Field PRE_AGRICULTURAL.
	 */
	PRE_AGRICULTURAL("PreAgricultural"), /**
  * Field AGRICULTURAL.
  */
 AGRICULTURAL("Agricultural"), /**
  * Field MEDIEVAL.
  */
 MEDIEVAL(
			"Medieval"), /**
  * Field RENAISSANCE.
  */
 RENAISSANCE("Renaissance"), /**
  * Field EARLY_INDUSTRIAL.
  */
 EARLY_INDUSTRIAL(
			"Early Industrial"), /**
  * Field INDUSTRIAL.
  */
 INDUSTRIAL("Industrial"), /**
  * Field POST_INDUSTRIAL.
  */
 POST_INDUSTRIAL(
			"Post Industrial"), /**
  * Field HI_TECH.
  */
 HI_TECH("HiTech");

	// TechLevel info
	/**
	 * Field name.
	 */
	public final String name; // Needs a name to print out multi-word situations

	/**
	 * Constructor for TechLevel
	 * 
	 * @param name
	 */
	public TechLevel(String name) {
		this.name = name;
	}

	/**
	 * Method toString.
	 * @return String
	 */
	public String toString() {
		return name;
	}

	/**
	 * Method which creates a TechLevel from a String of the name
	 * 
	 * @param name
	
	 * @return TechLevel of the String */
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