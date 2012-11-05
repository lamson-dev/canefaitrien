package com.canefaitrien.spacetrader.models;

import android.graphics.Point;

/**
 * Class Planet Information holder for planet
 * 
 * @author AN PHAM
 * @version 10/11/2012
 */

// Planet data
public class Planet {
	// Instance variables
	private String name;
	private int size;
	private Point coordinates;
	private TechLevel level;
	private Situation situation;
	private Marketplace marketplace;
	// Daniel doing testing
	public int xOffset, yOffset;

	/**
	 * Constructor for loading Planet
	 */
	/**
	 * Constructor for loading Planet
	 */
	public Planet(String name, Point location, TechLevel level,
			Situation situation, Marketplace marketplace) {

		this.size = (int) (Math.random() * 13) + 10;// for now each planet will
		// randomly generate a size
		// (radius)
		this.name = name;
		this.coordinates = location;
		this.level = level;
		this.situation = situation;
		this.marketplace = marketplace;
		// daniel doing testing
		xOffset = 0;
		yOffset = 0;
	}

	/**
	 * Constructor for a new Planet
	 */
	public Planet(String name, Point location, TechLevel level,
			Situation situation) {
		this(name, location, level, situation, new Marketplace(0, level,
				situation));
	}

	/**
	 * Distance between planets
	 */
	public int distance(Planet planet) {
		return distance(planet.getCoordinates());
	}

	/**
	 * Distance between the planet and another point (like a click)
	 */
	public int distance(Point other) {
		int dx, dy;
		dx = coordinates.x - other.x;
		dy = coordinates.y - other.y;
		return (int) Math.sqrt(dx * dx + dy * dy);
	}

	public void dock(int turn) {
		marketplace.dock(turn);
	}

	/**
	 * Getters and setters
	 */
	public Point getCoordinates() {
		return coordinates;
	}

	public void setCoordinates(Point location) {
		this.coordinates = location;
	}

	public String getName() {
		return name;
	}

	public int getSize() {
		return size;
	}

	public Situation getSituation() {
		return situation;
	}

	public void setSituation(Situation situation) {
		this.situation = situation;
	}

	public Marketplace getMarketplace() {
		return marketplace;
	}

	// For testing purpose
	public String toString() {
		return "Planet " + name + " TL " + level + " Sit " + situation
				+ " at X = " + coordinates.x + " Y = " + coordinates.y + " of Size "
				+ size + "\n";
	}
}
