package com.canefaitrien.spacetrader.models;

public enum ShipType {
	// Gnat 
	// speed of 14 parsecs, 1 weapon, 1 gadget, 15 cargo hold
	Gnat(14, 100, 1, 1, 0, 15, 0, 0, "Gnat"),
	// Flea
	// small, few cargo holds, a weak hull and no equipment, 20 parsecs/tank, 
	// can be converted from a escape pod
	Flea(17, 100, 1, 1, 1, 20, 0, 0, "Flea"),
	// Firefly
	// cheap, 1 of each equipment type slot, 17 parsecs/tank
	// 20 cargo hold
	Firefly(17, 200, 1, 1, 1, 20, 0, 0, "Firefly"),
	// Mosquito
	// 13 parsec/tank, strong hull, 2 weapon, 1 shield, 1 gadget, 15 cargo hold
	Mosquito(15, 300, 2, 1, 1, 15, 0, 0, "Mosquito"),
	// Bumblebee
	//20 cargo hold, hull = fifrefly, 2 shield, 2 gadget, mercernary available 15/tank
	Bumblebee(15, 200, 0, 2, 2, 20, 0, 5, "Bumblebee"),
	// Beetle
	// weak hull no weapon, 1 shield, 1 gadget, 50 cargo, 14 parsec/tank
	Beetle(14, 100, 0, 1, 1, 50, 0, 0, "Beetle"),
	// Hornet
	// Strong hull, 3 weapon, 2 shield, 1 gadget, 20 cargo, 16/tank
	Hornet(16, 300, 3, 1, 2, 20, 0, 0, "Hornet"),
	// Grasshopper
	// 30 cargo/ 2 weapons, 2 shield, 3 gadget, 3 crew, 15/tank
	Grasshopper(15, 200, 2, 3, 2, 30, 3, 0, "Grasshopper"),
	// Termite
	// Strong hull, 3 shield, 2 gadgets, 3 crew, 60 cargo, 1 weapon, 13/tank
	Termite(13, 300, 1, 2, 3, 60, 3, 0, "Termite"),
	// Wasp
	// Utimalte private ship, strong hull, 3 weapons, 2 shield, 2 gadget, 3 crew, 14/tank, 35 cargo
	Wasp(14, 300, 3, 2, 2, 35, 3, 0, "Wasp"),
	// Canefaitrien
	Canefaitrien(1000, 3000, 300, 200, 200, 35000, 10, 10, "Canefaitrien") // Ultimate fighting, trading ship
	;
	

	private int maxWeaponSlots;
	private int maxGadgetSlots;
	private int maxShieldSlots;
	private int maxDistance;
	private int maxCargoHold;
	private int maxCrew;
	private int maxMercernary;
	private int maxHullStrength;
	private String type;
	
	
	ShipType (	int maxDistance, int maxHullStrength,
				int maxWeaponSlots, int maxGadgetSlots, int maxShieldSlots,
				int maxCargoHold,
				int maxCrewMembers, int maxMercernary, String type) {
		
		this.maxDistance = maxDistance;
		this.maxWeaponSlots = maxWeaponSlots;
		this.maxGadgetSlots = maxGadgetSlots;
		this.maxCrew = maxCrewMembers;
		this.maxCargoHold = maxCargoHold;
		this.maxHullStrength = maxHullStrength;
		this.maxMercernary = maxMercernary;
		this.maxShieldSlots = maxShieldSlots;
		this.type = type;
	}
	


	public int getMaxWeaponSlots() {
		return maxWeaponSlots;
	}

	public int getMaxGadetSlots() {
		return maxGadgetSlots;
	}
	
	public int getMaxHullStrength() {
		return maxHullStrength;
	}
	
	public int getMaxDistance() {
		return maxDistance;
	}
	
	public int getMaxCrew() {
		return maxCrew;
	}

	public int getMaxMercernary() {
		return maxMercernary;
	}
	
	public int getMaxCargoHold() {
		return maxCargoHold;
	}
	
	public int getMaxShieldSlots() {
		return maxShieldSlots;
	}
	
	public String getType() {
		return type;		
	}

}