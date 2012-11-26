/**
 * Contains all the situations related to planets
 * 
 * @author Andrew Duda
 * @version 1.0
 */

package com.canefaitrien.spacetrader.models;

/**
 */
public enum Situation {
	/**
	 * Field LOTS_OF_WATER.
	 */
	LOTS_OF_WATER("Lots of Water"), /**
  * Field RICH_FAUNA.
  */
 RICH_FAUNA("Rich Fauna"), /**
  * Field RICH_SOIL.
  */
 RICH_SOIL(
			"Rich Soil"), /**
  * Field MINERAL_RICH.
  */
 MINERAL_RICH("Mineral_Rich"), /**
  * Field ARTISTIC.
  */
 ARTISTIC("Artistic"), /**
  * Field WARLIKE.
  */
 WARLIKE(
			"Warlike"), /**
  * Field LOTS_OF_HERBS.
  */
 LOTS_OF_HERBS("Lots of Herbs"), /**
  * Field NEVER.
  */
 NEVER("Never"), /**
  * Field WEIRD_MUSHROOMS.
  */
 WEIRD_MUSHROOMS(
			"Weird Mushrooms"), /**
  * Field DESERT.
  */
 DESERT("Desert"), /**
  * Field LIFELESS.
  */
 LIFELESS("Lifeless"), /**
  * Field POOR_SOIL.
  */
 POOR_SOIL(
			"Poor Soil"), /**
  * Field MINERAL_POOR.
  */
 MINERAL_POOR("Mineral Poor"), /**
  * Field DROUGHT.
  */
 DROUGHT("Drought"), /**
  * Field COLD.
  */
 COLD(
			"Cold"), /**
  * Field CROP_FAIL.
  */
 CROP_FAIL("Crop Fail"), /**
  * Field WAR.
  */
 WAR("War"), /**
  * Field BOREDOM.
  */
 BOREDOM("Boredom"), /**
  * Field PLAGUE.
  */
 PLAGUE(
			"Plague"), /**
  * Field LACK_OF_WORKERS.
  */
 LACK_OF_WORKERS("Lack of Workers");

	// Situation info
	/**
	 * Field name.
	 */
	public final String name; // Needs a name to print out multi-word situations

	/**
	 * Constructor for Situation
	 * 
	 * @param name
	 */
	public Situation(String name) {
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
	 * Method which creates a Situation from a String of the name
	 * 
	 * @param name
	
	 * @return Situation of the String */
	public static Situation fromString(String name) {
		if (name != null) {
			for (Situation s : Situation.values()) {
				if (name.equalsIgnoreCase(s.name)) {
					return s;
				}
			}
		}
		throw new IllegalArgumentException("No constant with name " + name
				+ " found");
	}
}