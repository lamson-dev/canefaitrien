/**
 * Class PlanetGenerator
 * Generate planet from a list of name 
 * with random coordinates within the area of the map
 * @author AN PHAM
 * Date 10/11/2012
 */

package com.canefaitrien.spacetrader.models;

public class PlanetGenerator {
	
	// Instance variables
	private int width = 150;
	private int height = 100;
	
	// Array of planet names
	private String planetNames[] = 
			{"Acamar","Adahn","Aldea","Andevian","Antedi","Balosnee","Baratas","Brax",		
			"Bretel","Calondia","Campor","Capelle",	"Carzon","Castor",	"Cestus","Cheron",
			"Courteney","Daled","Damast","Davlos","Deneb","Deneva","Devidia","Draylon",
			"Drema","Endor","Esmee","Exo","Ferris","Festen","Fourmi","Frolix","Gemulon",
			"Guinifer",	"Hades","Hamlet","Helena","Hulst","Iodine","Iralius","Janus",	
			"Japori","Jarada","Jason",	"Kaylon","Khefka","Kira","Klaatu","Klaestron",
			"Korma","Kravat","Krios","Laertes",	"Largo","Lave",	"Ligon","Lowry","Magrat",	
			"Malcoria","Melina","Mentar",	"Merik","Mintaka","Montor",	"Mordan","Myrthe",	
			"Nelvana","Nix","Nyle","Odet","Og","Omega","Omphalos",	"Orias","Othello",	
			"Parade","Penthara","Picard","Pollux","Quator","Rakhar","Ran","Regulas",
			"Relva","Rhymus","Rochani","Rubicum","Rutia","Sarpeidon","Sefalla","Seltrice",
			"Sigma","Sol","Somari","Stakoron","Styris","Talani","Tamus","Tantalos",
			"Tanuga","Tarchannen","Terosa","Thera",	"Titan","Torin","Triacus","Turkana",
			"Tyrus","Umberlee",	"Utopia",	"Vadera","Vagra","Vandor","Ventax","Xenon",
			"Xerxes","Yew","Yojimbo","Zalkon","Zuul"};
	
	private int totalPlanet = planetNames.length;
	private Planet[] universe = new Planet[totalPlanet];
	
	
	// Constructors
	public PlanetGenerator() {
		width = 150;
		height = 100;
		generate();
	}
	
	public PlanetGenerator(int width, int height) {
		this.width = width;
		this.height = height;
		generate();
		dump();
	}
	
	// Initiate the universe with planet names and random coordinates 
	private void generate() {
		int x, y;
		for (int i = 0; i<planetNames.length; i++){
			x = ((i+2)%width);
			y = (int)(Math.random()*height);
			universe[i] = new Planet(planetNames[i], x, y);
		}
	}
	
	// Accessors
	public int getWidth() {
		return width;
	}
	public int getHeight() {
		return height;
	}
	public int getTotalPlanet() {
		return totalPlanet;
	}
	public Planet[] getUniverse() {
		return universe;
	}
	// For testing purpose
	public String dump() {
		String ret = "";
		for (int i = 0; i< universe.length; i++) {
			ret += universe[i].dump();
		}
		return ret;
	}
	
}