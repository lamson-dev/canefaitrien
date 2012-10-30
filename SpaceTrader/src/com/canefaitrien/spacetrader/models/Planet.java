
package com.canefaitrien.spacetrader.models;

import android.graphics.Point;

/**
 * Class Planet
 * Information holder for planet
 * 
 * @author AN PHAM
 * @version 10/11/2012
 */

public class Planet {
	// Instance variables
	private String name;
	private Point location;
	private TechLevel level;
	private Situation situation;
	private Marketplace marketplace;
	
	
	/**
	 * Costructor for planet
	 */
	public Planet(String name, int x, int y, TechLevel level, Situation situation, Marketplace marketplace) {
		this.name = name;
		location = new Point(x, y);
		this.level = level;
		this.situation = situation;
		this.marketplace = marketplace;
	}
	
	public Planet(String name, int x, int y, TechLevel level, Situation situation) {
		this(name, x, y, level, situation, new Marketplace(0, level, situation));
	}
	
	/**
	 * Distance between planets
	 */
	public double distance(Planet planet) {
		int dx, dy;
		Point other = planet.getLocation();
		dx = location.x - other.x;
		dy = location.y - other.y;
		return Math.sqrt(dx*dx + dy*dy);
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



