package com.canefaitrien.spacetrader.models;

import java.util.Random;

import android.graphics.Point;

/**
 * Class PlanetGenerator
 * Generate planet from a list of name 
 * with random coordinates within the area of the map
 * 
 * @author AN PHAM
 * @date 10/11/2012
 */

public class Universe {
	
	// Constants
	public static final int WIDTH = 2000, HEIGHT = 2000, BORDER = 10, MIN_DISTANCE = 10;
	public static final int TOTAL_PLANETS = 100;
	// Array of planet names
	private static final String PLANET_NAMES[] = 
			{ "Acamar","Adahn","Aldea","Andevian","Antedi","Balosnee","Baratas","Brax",		
			"Bretel","Calondia","Campor","Capelle",	"Carzon","Castor","Cestus","Cheron",
			"Courteney","Daled","Damast","Davlos","Deneb","Deneva","Devidia","Draylon",
			"Drema","Endor","Esmee","Exo","Ferris","Festen","Fourmi","Frolix","Gemulon",
			"Guinifer","Hades","Hamlet","Helena","Hulst","Iodine","Iralius","Janus",	
			"Japori","Jarada","Jason","Kaylon","Khefka","Kira","Klaatu","Klaestron",
			"Korma","Kravat","Krios","Laertes","Largo","Lave","Ligon","Lowry","Magrat",	
			"Malcoria","Melina","Mentar","Merik","Mintaka","Montor","Mordan","Myrthe",	
			"Nelvana","Nix","Nyle","Odet","Og","Omega","Omphalos",	"Orias","Othello",	
			"Parade","Penthara","Picard","Pollux","Quator","Rakhar","Ran","Regulas",
			"Relva","Rhymus","Rochani","Rubicum","Rutia","Sarpeidon","Sefalla","Seltrice",
			"Sigma","Sol","Somari","Stakoron","Styris","Talani","Tamus","Tantalos",
			"Tanuga","Tarchannen","Terosa","Thera",	"Titan","Torin","Triacus","Turkana",
			"Tyrus","Umberlee",	"Utopia",	"Vadera","Vagra","Vandor","Ventax","Xenon",
			"Xerxes","Yew","Yojimbo","Zalkon","Zuul" };
	
	// Instance variable
	private Planet[] planets = new Planet[TOTAL_PLANETS];
	private Random rand = new Random();
	
	/**
	 * Constructors
	 */
	public Universe() {
		generate();
	}
	
	public Universe(Planet[] planets) {
		this.planets = planets;
	}
	
	/**
	 * Shuffles planet names to create random planets
	 */
	private void shuffle(String[] planets) {
		int ind1, ind2;
		String temp;
		for(int i = 0; i < 1000; i++) {
			ind1 = rand.nextInt(PLANET_NAMES.length);
			ind2 = rand.nextInt(PLANET_NAMES.length);
			temp = planets[ind1];
			planets[ind1] = planets[ind2];
			planets[ind2] = temp;
		}
	}
	
	/**
	 * Generates all of the planets in the universe.
	 * 
	 */
	private void generate() {
		int x, y;
		TechLevel[] levels = TechLevel.values();
		Situation[] situations = Situation.values();
		shuffle(PLANET_NAMES);
		
		for (int i = 0; i < TOTAL_PLANETS; i++) {
			x = rand.nextInt(WIDTH - 2*BORDER) + BORDER;
			y = rand.nextInt(HEIGHT - 2*BORDER) + BORDER;
			planets[i] = new Planet(PLANET_NAMES[i], x, y, levels[rand.nextInt(levels.length)], situations[rand.nextInt(situations.length)]);
		}
		
		validate();
	}
	
	/**
	 * Checks to make sure no planets are too close, and moves them if they are
	 * 
	 */
	public void validate() {
		boolean isChecking = true, movedPlanet;
		Planet current;
		
		while(isChecking) {
			movedPlanet = false;
			
			for(int i = 0; i < planets.length; i++) {
				current = planets[i];
				
				// compare current planet distance to all other planets
				for(int j = i + 1; j < planets.length; j++) {
					
					// if too close, create new location
					if (current.distance(planets[j]) < MIN_DISTANCE) {
						current.setLocation(new Point(rand.nextInt(WIDTH - 2*BORDER) + BORDER, rand.nextInt(HEIGHT - 2*BORDER) + BORDER));
						movedPlanet = true;
						break;
					}
				}
				// if a planet was moved, start over (I know it's not efficient)
				if(movedPlanet) {
					break;
				}
			}
			//if not planet was moved, then it is valid!
			if(!movedPlanet) {
				isChecking = false;
			}
		}
		
	}
	
	// Accessors
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
	
	public static void main(String[] agrs) {
		Universe un = new Universe();
		System.out.println(un.toString());
	}
	
}