package com.canefaitrien.spacetrader.models;

import java.util.Random;

import android.graphics.Point;

/**
 * Universe class to generate planets from a list of names with random
 * coordinates within the area of the map
 * 
 * @author AN PHAM
 * @version
 */

public class Universe {
	
	// Universe constants
	public static final int WIDTH = 720, HEIGHT = 1280, SHUFFLE_AMT = 1000;
	public static final int BORDER = 10; // Min distance from edge of screen
	public static final int MIN_DISTANCE = 48; // Min distance planet must be from another planet
	public static final int TOTAL_PLANETS = 50; // Total planets to create
	private static Random rand = new Random();
	
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
	
	/**
	 * Shuffles planet names to create random planets
	 */
	private static void shuffle(String[] planets) {
		int ind1, ind2;
		String temp;
		for(int i = 0; i < SHUFFLE_AMT; i++) {
			ind1 = rand.nextInt(PLANET_NAMES.length);
			ind2 = rand.nextInt(PLANET_NAMES.length);
			temp = planets[ind1];
			planets[ind1] = planets[ind2];
			planets[ind2] = temp;
		}
	}
	
	/**
	 * Generates all of the planets in the universe
	 */
	public static Planet[] generate() {
		Planet[] planets = new Planet[TOTAL_PLANETS];
		int x, y;
		TechLevel[] levels = TechLevel.values();
		Situation[] situations = Situation.values();
		// shuffles the planet names
		shuffle(PLANET_NAMES);
		// creates planets with random coordinates
		for (int i = 0; i < TOTAL_PLANETS; i++) {
			x = rand.nextInt(WIDTH - 2*BORDER) + BORDER;
			y = rand.nextInt(HEIGHT - 2*BORDER) + BORDER;
			planets[i] = new Planet(PLANET_NAMES[i], new Point(x, y), levels[rand.nextInt(levels.length)], 
					situations[rand.nextInt(situations.length)]);
		}
		// moves planets that are too close to each other
		validate(planets);
		return planets;
	}
	
	/**
	 * Checks to make sure no planets are too close, and moves them if they are
	 */
	public static void validate(Planet[] planets) {
		boolean isChecking = true, movedPlanet;
		Planet current;
		
		while(isChecking) {
			movedPlanet = false;
			// goes through all planets
			for(int i = 0; i < planets.length; i++) {
				current = planets[i];
				// compare current planet distance to all other planets
				for(int j = i + 1; j < planets.length; j++) {
					// if too close, create new location
					if (current.distance(planets[j]) < MIN_DISTANCE) {
						current.setCoordinates(new Point(rand.nextInt(WIDTH - 2*BORDER) + BORDER, rand.nextInt(HEIGHT - 2*BORDER) + BORDER));
						movedPlanet = true;
						break;
					}
				}
				// if a planet was moved, start over (I know it's not efficient)
				if(movedPlanet) {
					break;
				}
			}
			//if no planet was moved, then universe is valid!
			if(!movedPlanet) {
				isChecking = false;
			}
		}
	}
	
	// Accessors
	
	public static String toString(Planet[] planets) {
		String ret = "";
		for (int i = 0; i< planets.length; i++) {
			ret += planets[i].toString();
		}
		return ret;
	}
}