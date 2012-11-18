package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Ship class for holding info on the ship
 * 
 * @author apham9
 * @version 1.0
 */
public class Ship {
	
	// Ship info
	private ShipType type;
	private int hullStrength;
	private int currentCargoHold;
	private int[] cargo;
	private int fuel;
	private List<Weapon> weapons = new ArrayList<Weapon>();
//	private Shield[] shields;
//	private Gadget[] gadgets;
	
	public static final int MPG = 10;
	
	/**
	 * Constructor for new Ship
	 */
	public Ship(ShipType type) {
		this(type, type.MAX_HULL_STRENGTH, 0, new int[TradeGood.values().length], type.MAX_DISTANCE);
	}
	
	/**
	 * Constructor for load Ship
	 */
	public Ship(ShipType type, int hullStrength, int currentCargoHold, int[] cargo, int fuel) {
		this.type = type;
		this.hullStrength = hullStrength;
		this.currentCargoHold = currentCargoHold;
		this.cargo = cargo;
		this.fuel = fuel;
	}
	
	/**
	 * Adds a good to the cargo
	 * 
	 * @param good good to add to cargo
	 * @throws Exception if no room in cargo
	 */
	public void addGood(TradeGood good) throws Exception {
		if (currentCargoHold == type.MAX_CARGO_HOLD) {
			throw new Exception("No more room in the cargo, captain!");
		} else {
			cargo[good.ordinal()]++;
			currentCargoHold++;
		}
	}
	
	/**
	 * Removes a good from the cargo
	 * 
	 * @param good good to remove from cargo
	 * @throws Exception if no good in cargo
	 */
	public void removeGood(TradeGood good) throws Exception {
		if (cargo[good.ordinal()] == 0) {
			throw new Exception("No such item in the cargo, captain!");
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

	public int getFuel() {
		return fuel;
	}

	public void setFuel(int fuel) {
		this.fuel = fuel;
	}
	
	public int getHullStrength() {
		return hullStrength;
	}
	public int getMaxSpeed() {
		return type.getMaxSpeed();
	}
	
	// These are added by An Pham on 11/17/12 for extra credit on gadget and shields
	/**
	 * Adds a weapon to weapon slot
	 * 
	 * @param weapon to be added
	 * @throws Exception if no empty slot left
	 */
	public void addWeapon(Weapon weapon) throws Exception {
		if (weapons.size() == type.MAX_WEAPONS_SLOTS) {
			throw new Exception("No more weapon slot left, captain!");
		} else {
			weapons.add(weapon);
		}
	}
	/**
	 * this is used to transfer weapons to new ship. Do not call these functions elsewhere!
	 * @param list
	 */
	public void setWeapons(List<Weapon> list) {
		this.weapons = list;
	}

	public List<Weapon> getWeaponList() {
		return weapons;
	}
	
	public boolean checkWeaponExistence(Equipment w) {
		for(int i = 0; i<weapons.size(); i++) {
			if(weapons.get(i).equals(w))
				return true;
		}
		return false;
	}
}