package com.canefaitrien.spacetrader.models;

/**
* Contains all the situations related to planets
*
*/
public enum Situation {
	LOTS_OF_WATER("Lots of Water"), RICH_FAUNA("Rich Fauna"), RICH_SOIL("Rich Soil"), MINERAL_RICH("Mineral_Rich"), 
	ARTISTIC("Artistic"), WARLIKE("Warlike"), LOTS_OF_HERBS("Lots of Herbs"), NEVER("Never"), WEIRD_MUSHROOMS("Weird Mushrooms"), 
	DESERT("Desert"), LIFELESS("Lifeless"), POOR_SOIL("Poor Soil"), MINERAL_POOR("Mineral Poor"), DROUGHT("Drought"),
	COLD("Cold"), CROP_FAIL("Crop Fail"), WAR("War"), BOREDOM("Boredom"), PLAGUE("Plague"), LACK_OF_WORKERS("Lack of Workers");
	
	private String name;
	
	private Situation(String name) {
		this.name = name;
	}
	
	public String toString() {
		return name;
	}
}