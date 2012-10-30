package models;

import exceptions.CargoHullFullException;
import exceptions.NoTradeGoodException;

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
	private int[] cargo;
	
	// private GadgetType gadget;
	// etc...
	
	/**
	 * Constructor for new Ship
	 * 
	 */
	public Ship(ShipType type) {
		this.type = type;
		hullStrength = type.MAX_HULL_STRENGTH;
		cargo = new int[TradeGood.values().length];
		currentCargoHold = 0;
	}
	
	/**
	 * Constructor for load Ship
	 * 
	 */
	public Ship(ShipType type, int hullStrength, int currentCargoHold, int[] cargo) {
		this.type = type;
		this.hullStrength = hullStrength;
		this.currentCargoHold = currentCargoHold;
		this.cargo = cargo;
	}
	
	/**
	 * Adding a good
	 */
	public void addGood(TradeGood good) throws CargoHullFullException {
		if (currentCargoHold == type.MAX_CARGO_HOLD) {
			throw new CargoHullFullException("No more room in the cargo, captain!");
		} else {
			cargo[good.ordinal()]++;
			currentCargoHold++;
		}
	}
	
	/**
	 * Removing a good
	 */
	public void removeGood(TradeGood good) throws NoTradeGoodException {
		if (cargo[good.ordinal()] == 0) {
			throw new NoTradeGoodException("No such item in the cargo, captain!", good);
		} else {
			cargo[good.ordinal()]--;
			currentCargoHold--;
		}
	}
	
	public ShipType getType() {
		return type;
	}
	
	public int[] getCargo() {
		return cargo;
	}
	
	public static void main (String arg[]) {
		Ship test = new Ship(ShipType.WASP);
		System.out.println(test.getType());
	}
}