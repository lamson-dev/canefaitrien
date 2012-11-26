// $codepro.audit.disable largeNumberOfParameters
/**
 * 
 */
package com.canefaitrien.spacetrader.models;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;

/**
 * Ship class for holding info on the ship
 * 
 * @author apham9
 * @version 1.0
 */
public class Ship {

	// Ship info
	/**
	 * Field id.
	 */
	private Long id;

	/**
	 * Field weapons.
	 */
	private String weapons;

	/**
	 * Field shields.
	 */
	private String shields;

	/**
	 * Field gadgets.
	 */
	private String gadgets;

	/**
	 * Field type.
	 */
	private ShipType type;

	/**
	 * Field hullStrength.
	 */
	private int hullStrength;

	/**
	 * Field currentCargoHold.
	 */
	private int currentCargoHold;

	/**
	 * Field cargo.
	 */
	private int[] cargo;

	/**
	 * Field fuel.
	 */
	private int fuel;
	// private Weapons[] weapons;
	// private Shield[] shields;
	// private Gadget[] gadgets;

	/**
	 * Field MPG. (value is 15)
	 */
	public static final int MPG = 15;

	/**
	 * Constructor for Ship
	 */
	public Ship() { // $codepro.audit.disable emptyMethod
	}

	/**
	 * Constructor for Ship
	 * 
	 * @param id
	 */
	public Ship(Long id) {
		this.id = id;
	}

	/**
	 * Constructor for Ship
	 * 
	 * @param id
	 * @param type
	 * @param hullStrength
	 * @param currentCargoHold
	 * @param cargo
	 * @param fuel
	 * @param weapons
	 * @param shields
	 * @param gadgets
	 * 
	 * @throws JSONException
	 */
	public Ship(Long id, String type, Integer hullStrength,
			Integer currentCargoHold, String cargo, Integer fuel,
			String weapons, String shields, String gadgets)
			throws JSONException {
		this.id = id;
		this.type = ShipType.valueOf(type.toUpperCase());
		this.hullStrength = hullStrength;
		this.currentCargoHold = currentCargoHold;
		this.setCargo(cargo);
		this.fuel = fuel;
		// this.weapons = weapons;
		// this.shields = shields;
		// this.gadgets = gadgets;
	}

	/**
	 * Constructor for Ship
	 * 
	 * @param type
	 */
	public Ship(ShipType type) {
		this(type, type.maxHullStrength, 0, new int[TradeGood.values().length],
				type.maxDistance);
	}

	/**
	 * Constructor for Ship
	 * 
	 * @param type
	 * @param hullStrength
	 * @param currentCargoHold
	 * @param cargo
	 * @param fuel
	 */
	public Ship(ShipType type, int hullStrength, int currentCargoHold,
			int[] cargo, int fuel) {
		this.type = type;
		this.hullStrength = hullStrength;
		this.currentCargoHold = currentCargoHold;
		this.cargo = cargo.clone();
		this.fuel = fuel;
	}

	/**
	 * Adds a good to the cargo
	 * 
	 * @param good
	 *            good to add to cargo
	 * 
	 * @throws Exception
	 *             if no room in cargo
	 */
	public void addGood(TradeGood good) throws Exception {
		if (currentCargoHold == type.maxCargoHold) {
			throw new Exception("No more room in the cargo, captain!");
		} else {
			cargo[good.ordinal()]++;
			currentCargoHold++;
		}
	}

	/**
	 * Removes a good from the cargo
	 * 
	 * @param good
	 *            good to remove from cargo
	 * 
	 * @throws Exception
	 *             if no good in cargo
	 */
	public void removeGood(TradeGood good) throws Exception {
		if (cargo[good.ordinal()] == 0) {
			throw new Exception("No such item in the cargo, captain!");
		} else {
			cargo[good.ordinal()]--;
			currentCargoHold--;
		}
	}

	/**
	 * Method getStringCargo.
	 * 
	 * @return String
	 */
	public String getStringCargo() {
		final List<Integer> list = new ArrayList<Integer>();
		for (int item : this.getCargo())
			list.add(item);
		final JSONArray json = new JSONArray(list);
		return json.toString();
	}

	/**
	 * Method setCargo.
	 * 
	 * @param cargo
	 *            String
	 * @throws JSONException
	 */
	public final void setCargo(String cargo) throws JSONException {
		final JSONArray jsonArray = new JSONArray(cargo);
		final int[] cargoArray = new int[TradeGood.values().length];
		for (int i = 0; i < jsonArray.length(); i++) {
			cargoArray[i] = jsonArray.getInt(i);
		}
		this.cargo = cargoArray;
	}

	/**
	 * Method getType.
	 * 
	 * @return ShipType
	 */
	public ShipType getType() {
		return type;
	}

	/**
	 * Method getCargo.
	 * 
	 * @return int[]
	 */
	public int[] getCargo() {
		return cargo;
	}

	/**
	 * Method getId.
	 * 
	 * @return Long
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Method setId.
	 * 
	 * @param id
	 *            Long
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Method getStringType.
	 * 
	 * @return String
	 */
	public String getStringType() {
		return type.name;
	}

	/**
	 * Method setType.
	 * 
	 * @param type
	 *            String
	 */
	public void setType(String type) {
		this.type = ShipType.valueOf(type.toUpperCase());
	}

	/**
	 * Method getHullStrength.
	 * 
	 * @return Integer
	 */
	public Integer getHullStrength() {
		return hullStrength;
	}

	/**
	 * Method setHullStrength.
	 * 
	 * @param hullStrength
	 *            Integer
	 */
	public void setHullStrength(Integer hullStrength) {
		this.hullStrength = hullStrength;
	}

	/**
	 * Method getCurrentCargoHold.
	 * 
	 * @return Integer
	 */
	public Integer getCurrentCargoHold() {
		return currentCargoHold;
	}

	/**
	 * Method setCurrentCargoHold.
	 * 
	 * @param currentCargoHold
	 *            Integer
	 */
	public void setCurrentCargoHold(Integer currentCargoHold) {
		this.currentCargoHold = currentCargoHold;
	}

	/**
	 * Method getFuel.
	 * 
	 * @return Integer
	 */
	public Integer getFuel() {
		return fuel;
	}

	/**
	 * Method setFuel.
	 * 
	 * @param fuel
	 *            Integer
	 */
	public void setFuel(Integer fuel) {
		this.fuel = fuel;
	}

	/**
	 * Method getWeapons.
	 * 
	 * @return String
	 */
	public String getWeapons() {
		return weapons;
	}

	/**
	 * Method setWeapons.
	 * 
	 * @param weapons
	 *            String
	 */
	public void setWeapons(String weapons) {
		this.weapons = weapons;
	}

	/**
	 * Method getShields.
	 * 
	 * @return String
	 */
	public String getShields() {
		return shields;
	}

	/**
	 * Method setShields.
	 * 
	 * @param shields
	 *            String
	 */
	public void setShields(String shields) {
		this.shields = shields;
	}

	/**
	 * Method getGadgets.
	 * 
	 * @return String
	 */
	public String getGadgets() {
		return gadgets;
	}

	/**
	 * Method setGadgets.
	 * 
	 * @param gadgets
	 *            String
	 */
	public void setGadgets(String gadgets) {
		this.gadgets = gadgets;
	}

	/**
	 * Method getMaxSpeed.
	 * 
	 * @return int
	 */
	public int getMaxSpeed() {
		return type.maxDistance;
	}

	/**
	 * Method toString.
	 * 
	 * @return String
	 */
	@Override
	public String toString() {
		return super.toString();
	}
}