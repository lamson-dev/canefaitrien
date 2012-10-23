/**
 * Class Planet
 * Information holder for planet
 * @author AN PHAM
 * @version 10/11/2012
 */

package com.canefaitrien.spacetrader.models;

public class Planet {
	// Instance variables
	private String name;
	private int x = 0;
	private int y = 0;
	private TechLevel level;
	
	public static enum TechLevel {PreAgricultural, Agricultural, Medieval, Renaissance, 
		EarlyIndustrial, Industrial, PostIndustrial, HiTech}
	
	// Constructor
	public Planet(String name) {
		this.name = name;
	}
	public Planet(String name, int x, int y, TechLevel level) {
		this.name = name;
		this.x = x;
		this.y = y;
		this.level = level;
	}
	
	// Accessor
	public String getName() {
		return name;
	}
	// Return coordinate x, y in an array[x,y]
	public int[] getCoordinate() {
		int[] ret = new int[2];
		ret[0] = x;
		ret[1] = y;
		return ret;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	// For testing purpose
	public String toString() {
		return "Planet "+name + " TL " + level+" at X = "+ x +" Y = "+ y +"\n";
	}
}