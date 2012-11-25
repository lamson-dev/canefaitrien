/**
 * Contains all the situations related to planets
 * 
 * @author Andrew Duda
 * @version 1.0
 */

package com.canefaitrien.spacetrader.models;

public enum Situation {
	LOTS_OF_WATER("Lots of Water"), RICH_FAUNA("Rich Fauna"), RICH_SOIL(
			"Rich Soil"), MINERAL_RICH("Mineral_Rich"), ARTISTIC("Artistic"), WARLIKE(
			"Warlike"), LOTS_OF_HERBS("Lots of Herbs"), NEVER("Never"), WEIRD_MUSHROOMS(
			"Weird Mushrooms"), DESERT("Desert"), LIFELESS("Lifeless"), POOR_SOIL(
			"Poor Soil"), MINERAL_POOR("Mineral Poor"), DROUGHT("Drought"), COLD(
			"Cold"), CROP_FAIL("Crop Fail"), WAR("War"), BOREDOM("Boredom"), PLAGUE(
			"Plague"), LACK_OF_WORKERS("Lack of Workers");

	// Situation info
	public final String name; // Needs a name to print out multi-word situations

	/**
	 * Constructor for Situation
	 * 
	 * @param name
	 */
	private Situation(String name) {
		this.name = name;
	}

	public String toString() {
		return name;
	}

	/**
	 * Method which creates a Situation from a String of the name
	 * 
	 * @param name
	 * @return Situation of the String
	 */
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