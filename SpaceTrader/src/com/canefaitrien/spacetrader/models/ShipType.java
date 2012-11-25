// $codepro.audit.disable largeNumberOfParameters
/**
 * Create Ship type
 * 
 * @author apham9
 * @date 10/10/2012
 */

package com.canefaitrien.spacetrader.models;

import java.util.Random;

/**
 */
public enum ShipType {
	// speed of 14 parsecs, 1 weapon, 1 gadget, 15 cargo hold
	/**
	 * Field GNAT.
	 */
	GNAT(14, 100, 1, 1, 0, 15, 0, 0, "Gnat"),
	// small, few cargo holds, a weak hull and no equipment, 20 parsecs/tank, 
	// can be converted from a escape pod
	/**
	 * Field FLEA.
	 */
	FLEA(17, 100, 1, 1, 1, 20, 0, 0, "Flea"),
	// cheap, 1 of each equipment type slot, 17 parsecs/tank
	// 20 cargo hold
	/**
	 * Field FIREFLY.
	 */
	FIREFLY(17, 200, 1, 1, 1, 20, 0, 0, "Firefly"),
	// 13 parsec/tank, strong hull, 2 weapon, 1 shield, 1 gadget, 15 cargo hold
	/**
	 * Field MOSQUITO.
	 */
	MOSQUITO(15, 300, 2, 1, 1, 15, 0, 0, "Mosquito"),
	//20 cargo hold, hull = fifrefly, 2 shield, 2 gadget, mercernary available 15/tank
	/**
	 * Field BUMBLEBEE.
	 */
	BUMBLEBEE(15, 200, 0, 2, 2, 20, 0, 5, "Bumblebee"),
	// weak hull no weapon, 1 shield, 1 gadget, 50 cargo, 14 parsec/tank
	/**
	 * Field BEETLE.
	 */
	BEETLE(14, 100, 0, 1, 1, 50, 0, 0, "Beetle"),
	// Strong hull, 3 weapon, 2 shield, 1 gadget, 20 cargo, 16/tank
	/**
	 * Field HORNET.
	 */
	HORNET(16, 300, 3, 1, 2, 20, 0, 0, "Hornet"),
	// 30 cargo/ 2 weapons, 2 shield, 3 gadget, 3 crew, 15/tank
	/**
	 * Field GRASSHOPPER.
	 */
	GRASSHOPPER(15, 200, 2, 3, 2, 30, 3, 0, "Grasshopper"),
	// Strong hull, 3 shield, 2 gadgets, 3 crew, 60 cargo, 1 weapon, 13/tank
	/**
	 * Field TERMITE.
	 */
	TERMITE(13, 300, 1, 2, 3, 60, 3, 0, "Termite"),
	// Utimalte private ship, strong hull, 3 weapons, 2 shield, 2 gadget, 3 crew, 14/tank, 35 cargo
	/**
	 * Field WASP.
	 */
	WASP(14, 300, 3, 2, 2, 35, 3, 0, "Wasp"),
	/**
	 * Field CANEFAITRIEN.
	 */
	CANEFAITRIEN(1000, 3000, 300, 200, 200, 35000, 10, 10, "Canefaitrien") // Ultimate fighting, trading ship
	/**
	 * Field maxWeaponSlots.
	 */
	;
	
	// ShipType info
	public final int maxWeaponSlots;

	/**
	 * Field maxGadgetSlots.
	 */
	public final int maxGadgetSlots;

	/**
	 * Field maxShieldSlots.
	 */
	public final int maxShieldSlots;

	/**
	 * Field maxDistance.
	 */
	public final int maxDistance;

	/**
	 * Field maxCargoHold.
	 */
	public final int maxCargoHold;

	/**
	 * Field maxCrew.
	 */
	public final int maxCrew;

	/**
	 * Field maxMercenary.
	 */
	public final int maxMercenary;

	/**
	 * Field maxHullStrength.
	 */
	public final int maxHullStrength;

	/**
	 * Field name.
	 */
	public final String name;
	
	/**
	 * Constructor for ShipType
	 * @param maxDistance
	 * @param maxHullStrength
	 * @param maxWeaponSlots
	 * @param maxGadgetSlots
	 * @param maxShieldSlots
	 * @param maxCargoHold
	 * @param maxCrewMembers
	 * @param maxMercernary
	 * @param name
	 */
	private ShipType (int maxDistance, int maxHullStrength, 
			int maxWeaponSlots, int maxGadgetSlots, int maxShieldSlots,
			int maxCargoHold, int maxCrewMembers, int maxMercernary, String name) {
		
		this.maxWeaponSlots = maxWeaponSlots;
		this.maxGadgetSlots = maxGadgetSlots;
		this.maxShieldSlots = maxShieldSlots;
		this.maxDistance = maxDistance;
		this.maxCargoHold = maxCargoHold;
		this.maxCrew = maxCrewMembers;
		this.maxMercenary = maxMercernary;
		this.maxHullStrength = maxHullStrength;
		this.name = name;
	}
	
	/**
	 * Method toString.
	 * @return String
	 */
	public String toString() {
		return name;
	}
	
	/**
	 * Method to get a random ShipType
	
	 * @return random ShipType */
	public static ShipType getAShip() {
		int pick = new Random().nextInt(ShipType.values().length);
	    return ShipType.values()[pick];
	}
}