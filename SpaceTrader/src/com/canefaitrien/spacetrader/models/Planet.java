/**
 * Class Planet
 * Information holder for planet
 * @author AN PHAM
 * Date 10/11/2012
 */

package com.canefaitrien.spacetrader.models;

public class Planet {
	// Instance variables
	private String name;
	private int X = 0;
	private int Y = 0;
	
	// Constructor
	public Planet(String name) {
		this.name = name;
	}
	public Planet(String name, int x, int y) {
		this.name = name;
		this.X = x;
		this.Y = y;
	}
	
	// Accessor
	public String getName() {
		return name;
	}
	// Return coordinate x, y in an array[x,y]
	public int[] getCoordinate() {
		int[] ret = new int[2];
		ret[0] = X;
		ret[1] = Y;
		return ret;
	}
	public int getX() {
		return X;
	}
	public int getY() {
		return Y;
	}
	// For testing purpose
	public String dump() {
		return "Planet "+name+" at X = "+X+" Y = "+Y+"\n";
	}
}