package model;

import java.awt.Point;

/**
 * Class Planet
 * Information holder for planet
 * 
 * @author AN PHAM
 * @version 10/11/2012
 */

public class Planet {
	
	// Planet data
	private String name;
	private Point location;
	private TechLevel level;
	private Situation situation;
	private Marketplace marketplace;
	
	
	/**
	 * Constructor for loading Planet
	 */
	public Planet(String name, Point location, TechLevel level, Situation situation, Marketplace marketplace) {
		this.name = name;
		this.location = location;
		this.level = level;
		this.situation = situation;
		this.marketplace = marketplace;
	}
	
	/**
	 * Constructor for a new Planet
	 */
	
	public Planet(String name, Point location, TechLevel level, Situation situation) {
		this(name, location, level, situation, new Marketplace(0, level, situation));
	}
	
	/**
	 * Distance between planets
	 */
	public double distance(Planet planet) {
		return distance(planet.getLocation());
	}
	
	/**
	 * Distance between the planet and another point (like a click)
	 */
	public double distance(Point other) {
		int dx, dy;
		dx = location.x - other.x;
		dy = location.y - other.y;
		return Math.sqrt(dx*dx + dy*dy);
	}
	
	public void dock(int turn) {
		marketplace.dock(turn);
	}
	/**
	 * Getters and setters
	 */	
	public Point getLocation() {
		return location;
	}
	
	public void setLocation(Point location) {
		this.location = location;
	}
	public String getName() {
		return name;
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
		return "Planet " + name + " TL " + level + " Sit " + situation + " at X = " + location.x + " Y = " + location.y
				+ "\n";
	}
}



