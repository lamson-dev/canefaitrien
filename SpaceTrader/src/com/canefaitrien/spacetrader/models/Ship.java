package com.canefaitrien.spacetrader.models;
/**
 * Create Ship model
 * @author apham9
 * @date 10/10/2012
 *
 */
public class Ship {
	
	private ShipType type;
	private int hullStrength;
	private int[] numTradeGoods;
	
	// private GadgetType gadget;
	// etc...
	
	
	public Ship(ShipType type) {
		this.type = type;
		hullStrength = type.getMaxHullStrength();
		numTradeGoods = new int[TradeGood.values().length];
	}
	
	public ShipType getType() {
		return type;
	}
	
	public static void main (String arg[]) {
		Ship test = new Ship(ShipType.Wasp);
		System.out.println(test.getType());
	}
	/**
	 * Assuming there is room?
	 * 
	 */
	public void addGood(TradeGood good) {
		numTradeGoods[good.ordinal()]++;
		
	}
}