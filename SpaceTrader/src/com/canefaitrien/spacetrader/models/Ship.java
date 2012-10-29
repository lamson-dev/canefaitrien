package com.canefaitrien.spacetrader.models;

import com.canefaitrien.spacetrader.exceptions.CargoHullFullException;
import com.canefaitrien.spacetrader.exceptions.NoTradeGoodException;

/**
 * Create Ship model
 * 
 * @author apham9
 * @date 10/10/2012
 */
public class Ship {
	
	private ShipType type;
	private int hullStrength;
	private int currentCargoHold;
	private int[] tradeGoods;
	
	// private GadgetType gadget;
	// etc...
	
	/**
	 * Constructor for new Ship
	 * 
	 */
	public Ship(ShipType type) {
		this.type = type;
		hullStrength = type.MAX_HULL_STRENGTH;
		tradeGoods = new int[TradeGood.values().length];
		currentCargoHold = 0;
	}
	
	/**
	 * Constructor for load Ship
	 * 
	 */
	public Ship(ShipType type, int hullStrength, int currentCargoHold, int[] tradeGoods) {
		this.type = type;
		this.hullStrength = hullStrength;
		this.currentCargoHold = currentCargoHold;
		this.tradeGoods = tradeGoods;
	}
	
	/**
	 * Adding a good
	 */
	public void addGood(TradeGood good) throws CargoHullFullException {
		if (currentCargoHold == type.MAX_CARGO_HOLD) {
			throw new CargoHullFullException("No more room in the cargo, captain!");
		} else {
			tradeGoods[good.ordinal()]++;
			currentCargoHold++;
		}
	}
	
	/**
	 * Removing a good
	 */
	public void removeGood(TradeGood good) throws NoTradeGoodException {
		if (tradeGoods[good.ordinal()] == 0) {
			throw new NoTradeGoodException("No such item in the cargo, captain!", good);
		} else {
			tradeGoods[good.ordinal()]--;
			currentCargoHold--;
		}
	}
	
	public ShipType getType() {
		return type;
	}
	
	public static void main (String arg[]) {
		Ship test = new Ship(ShipType.WASP);
		System.out.println(test.getType());
	}
}