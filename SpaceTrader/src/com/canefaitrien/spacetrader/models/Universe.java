/**
 * Class PlanetGenerator
 * Generate planet from a list of name 
 * with random coordinates within the area of the map
 * @author AN PHAM
 * Date 10/11/2012
 */

package com.canefaitrien.spacetrader.models;

import java.util.Random;

import com.canefaitrien.spacetrader.models.Planet.TechLevel;

public class Universe {
	
	// Instance variables
	private int width = 720;
	private int height = 1240;
	
	// Array of planet names
	private static final String planetNames[] = 
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
	private Planet[] planets = new Planet[totalPlanet];
	
	
	// Constructors
	public Universe() {
		generate();
	}
	
	public Universe(int width, int height) {
		this.width = width;
		this.height = height;
		generate();
	}
	
	// Initiate the universe with planet names and random coordinates 
	private void generate() {
		int x, y;
		TechLevel[] levels = Planet.TechLevel.values();
		Random rand = new Random();
		for (int i = 0; i<planetNames.length; i++){
			x = ((i+2)%width);
			y = (int)(rand.nextDouble()*height);
			planets[i] = new Planet(planetNames[i], x, y, levels[rand.nextInt(levels.length)]);
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
	public Planet[] getPlanets() {
		return planets;
	}
	// For testing purpose
	public String toString() {
		String ret = "";
		for (int i = 0; i< planets.length; i++) {
			ret += planets[i].toString();
		}
		return ret;
	}
	
}