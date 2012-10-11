/**
 * For testing planetgenerator
 * @author ARIAN PHAM
 *
 */

package com.canefaitrien.spacetrader.models;

public class Tester {
	public static void main (String[] arg) {
		PlanetGenerator plan = new PlanetGenerator(150, 200);
		Planet p = new Planet("chicken", 10, 23);
		System.out.println(p.dump());
		System.out.println(plan.dump());
	}
}