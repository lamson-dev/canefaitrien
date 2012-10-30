package models;

/**
 * Create Ship type
 * 
 * @author apham9
 * @date 10/10/2012
 */
public enum ShipType {
	// Gnat 
	// speed of 14 parsecs, 1 weapon, 1 gadget, 15 cargo hold
	GNAT(14, 100, 1, 1, 0, 15, 0, 0, "Gnat"),
	// Flea
	// small, few cargo holds, a weak hull and no equipment, 20 parsecs/tank, 
	// can be converted from a escape pod
	FLEA(17, 100, 1, 1, 1, 20, 0, 0, "Flea"),
	// Firefly
	// cheap, 1 of each equipment type slot, 17 parsecs/tank
	// 20 cargo hold
	FIREFLY(17, 200, 1, 1, 1, 20, 0, 0, "Firefly"),
	// Mosquito
	// 13 parsec/tank, strong hull, 2 weapon, 1 shield, 1 gadget, 15 cargo hold
	MOSQUITO(15, 300, 2, 1, 1, 15, 0, 0, "Mosquito"),
	// Bumblebee
	//20 cargo hold, hull = fifrefly, 2 shield, 2 gadget, mercernary available 15/tank
	BUMBLEBEE(15, 200, 0, 2, 2, 20, 0, 5, "Bumblebee"),
	// Beetle
	// weak hull no weapon, 1 shield, 1 gadget, 50 cargo, 14 parsec/tank
	BEETLE(14, 100, 0, 1, 1, 50, 0, 0, "Beetle"),
	// Hornet
	// Strong hull, 3 weapon, 2 shield, 1 gadget, 20 cargo, 16/tank
	HORNET(16, 300, 3, 1, 2, 20, 0, 0, "Hornet"),
	// Grasshopper
	// 30 cargo/ 2 weapons, 2 shield, 3 gadget, 3 crew, 15/tank
	GRASSHOPPER(15, 200, 2, 3, 2, 30, 3, 0, "Grasshopper"),
	// Termite
	// Strong hull, 3 shield, 2 gadgets, 3 crew, 60 cargo, 1 weapon, 13/tank
	TERMITE(13, 300, 1, 2, 3, 60, 3, 0, "Termite"),
	// Wasp
	// Utimalte private ship, strong hull, 3 weapons, 2 shield, 2 gadget, 3 crew, 14/tank, 35 cargo
	WASP(14, 300, 3, 2, 2, 35, 3, 0, "Wasp"),
	// Canefaitrien
	CANEFAITRIEN(1000, 3000, 300, 200, 200, 35000, 10, 10, "Canefaitrien") // Ultimate fighting, trading ship
	;
	
	public final int MAX_WEAPONS_SLOTS;
	public final int MAX_GADGETS_SLOTS;
	public final int MAX_SHIELDS_SLOTS;
	public final int MAX_DISTANCE;
	public final int MAX_CARGO_HOLD;
	public final int MAX_CREW;
	public final int MAX_MERCENARY;
	public final int MAX_HULL_STRENGTH;
	public final String NAME;
	
	ShipType (int maxDistance, int maxHullStrength, 
			int maxWeaponSlots, int maxGadgetSlots, int maxShieldSlots,
			int maxCargoHold, int maxCrewMembers, int maxMercernary, String name) {
		
		MAX_WEAPONS_SLOTS = maxWeaponSlots;
		MAX_GADGETS_SLOTS = maxGadgetSlots;
		MAX_SHIELDS_SLOTS = maxShieldSlots;
		MAX_DISTANCE = maxDistance;
		MAX_CARGO_HOLD = maxCargoHold;
		MAX_CREW = maxCrewMembers;
		MAX_MERCENARY = maxMercernary;
		MAX_HULL_STRENGTH = maxHullStrength;
		NAME = name;
	}
	
	public String toString() {
		return NAME;
	}
}