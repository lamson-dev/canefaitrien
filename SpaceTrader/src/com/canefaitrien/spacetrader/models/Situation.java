package model;

/**
 * Contains all the situations related to planets
 * 
 * @author Andrew Duda
 * @version 1.0
 */
public enum Situation {
	LOTS_OF_WATER("Lots of Water"), RICH_FAUNA("Rich Fauna"), RICH_SOIL("Rich Soil"), MINERAL_RICH("Mineral_Rich"), 
	ARTISTIC("Artistic"), WARLIKE("Warlike"), LOTS_OF_HERBS("Lots of Herbs"), NEVER("Never"), WEIRD_MUSHROOMS("Weird Mushrooms"), 
	DESERT("Desert"), LIFELESS("Lifeless"), POOR_SOIL("Poor Soil"), MINERAL_POOR("Mineral Poor"), DROUGHT("Drought"),
	COLD("Cold"), CROP_FAIL("Crop Fail"), WAR("War"), BOREDOM("Boredom"), PLAGUE("Plague"), LACK_OF_WORKERS("Lack of Workers");
	
	// Situation info
	public final String NAME; // Needs a name to print out multi-word situations
	
	/**
	 * Constructor for Situation 
	 */
	private Situation(String name) {
		NAME = name;
	}
	
	public String toString() {
		return NAME;
	}
}