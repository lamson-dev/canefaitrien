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
	private Long id;
	// private String type;
	// private Integer hullStrength;
	// private Integer currentCargoHold;
	// private String cargo;
	// private Integer fuel;
	private String weapons;
	private String shields;
	private String gadgets;
	private ShipType type;
	private int hullStrength;
	private int currentCargoHold;
	private int[] cargo;
	private int fuel;
	// private Weapons[] weapons;
	// private Shield[] shields;
	// private Gadget[] gadgets;

	public static final int MPG = 5;

	public Ship() {
	}

	public Ship(Long id) {
		this.id = id;
	}

	/**
	 * Constructor for load Ship
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
	 * Constructor for new Ship
	 */
	public Ship(ShipType type) {
		this(type, type.MAX_HULL_STRENGTH, 0,
				new int[TradeGood.values().length], type.MAX_DISTANCE);
	}

	public Ship(ShipType type, int hullStrength, int currentCargoHold,
			int[] cargo, int fuel) {
		this.type = type;
		this.hullStrength = hullStrength;
		this.currentCargoHold = currentCargoHold;
		this.cargo = cargo;
		this.fuel = fuel;
	}

	/**
	 * Adds a good to the cargo
	 * 
	 * @param good
	 *            good to add to cargo
	 * @throws Exception
	 *             if no room in cargo
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
	 * @param good
	 *            good to remove from cargo
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

	public ShipType getType() {
		return type;
	}

	public int[] getCargo() {
		return cargo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStringType() {
		return type.NAME;
	}

	public void setType(String type) {
		this.type = ShipType.valueOf(type.toUpperCase());
	}

	public Integer getHullStrength() {
		return hullStrength;
	}

	public void setHullStrength(Integer hullStrength) {
		this.hullStrength = hullStrength;
	}

	public Integer getCurrentCargoHold() {
		return currentCargoHold;
	}

	public void setCurrentCargoHold(Integer currentCargoHold) {
		this.currentCargoHold = currentCargoHold;
	}

	public String getStringCargo() {
		List<Integer> list = new ArrayList<Integer>();
		for (int item : this.getCargo())
			list.add(item);
		JSONArray json = new JSONArray(list);
		return json.toString();
	}

	public void setCargo(String cargo) throws JSONException {
		JSONArray jsonArray = new JSONArray(cargo);
		if (jsonArray != null) {
			int[] cargoArray = new int[TradeGood.values().length];
			for (int i = 0; i < jsonArray.length(); i++) {
				cargoArray[i] = jsonArray.getInt(i);
			}
			this.cargo = cargoArray;
		}
	}

	public Integer getFuel() {
		return fuel;
	}

	public void setFuel(Integer fuel) {
		this.fuel = fuel;
	}

	public String getCargoView() {
		String ret = "";
		TradeGood[] goods = TradeGood.values();
		for (int i = 0; i < cargo.length; i++) {
			ret += goods[i].toString() + ": " + cargo[i];
		}
		return ret;
	}

	public String getWeapons() {
		return weapons;
	}

	public void setWeapons(String weapons) {
		this.weapons = weapons;
	}

	public String getShields() {
		return shields;
	}

	public void setShields(String shields) {
		this.shields = shields;
	}

	public String getGadgets() {
		return gadgets;
	}

	public void setGadgets(String gadgets) {
		this.gadgets = gadgets;
	}
	public int getMaxSpeed() {
		return type.MAX_DISTANCE;
	}

}