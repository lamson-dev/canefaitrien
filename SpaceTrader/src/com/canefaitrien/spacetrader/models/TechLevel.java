package model;

/**
 * TechLevel enum for Planets
 * 
 * @author Andrew Duda
 * @version 1.0
 */
public enum TechLevel {
	PRE_AGRICULTURAL("PreAgricultural"), AGRICULTURAL("Agricultural"), MEDIEVAL("Medieval"), RENAISSANCE("Renaissance"),
	EARLY_INDUSTRIAL("Early Industrial"), INDUSTRIAL("Industrial"), POST_INDUSTRIAL("Post Industrial"), HI_TECH("HiTech");
	
	// TechLevel info
	public final String NAME; // Needs a name to print out multi-word situations
	
	/**
	 * Constructor for TechLevel 
	 */
	private TechLevel(String name) {
		NAME = name;
	}
	
	public String toString() {
		return NAME;
	}
}