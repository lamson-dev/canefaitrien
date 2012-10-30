package models;

public enum TechLevel {
	PRE_AGRICULTURAL("PreAgricultural"), AGRICULTURAL("Agricultural"), MEDIEVAL("Medieval"), RENAISSANCE("Renaissance"),
	EARLY_INDUSTRIAL("Early Industrial"), INDUSTRIAL("Industrial"), POST_INDUSTRIAL("Post Industrial"), HI_TECH("HiTech");
	
	private String name;
	
	private TechLevel(String name) {
		this.name = name;
	}
	
	public String toString() {
		return name;
	}
}