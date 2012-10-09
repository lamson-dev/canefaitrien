public enum ShipType {
	// Gnat 
	// speed of 14 parsecs, 1 weapon, 1 gadget, 15 cargo hold
	Gnat,
	// Flea
	// small, few cargo holds, a weak hull and no equipment, 20 parsecs/tank, 
	// can be converted from a escape pod
	Flea,
	// Firefly
	// cheap, 1 of each equipment type slot, 17 parsecs/tank
	// 20 cargo hold
	Firefly,
	// Mosquito
	// 13 parsec/tank, strong hull, 2 weapon, 1 shield, 1 gadget, 15 cargo hold
	Mosquito,
	// Bumblebee
	//20 cargo hold, hull = fifrefly, 2 shield, 2 gadget, mercernary available 15/tank
	Bumblebee,
	// Beetle
	// weak hull no weapon, 1 shield, 1 gadget, 50 cargo, 14 parsec/tank
	Beetle,
	// Hornet
	// Strong hull, 3 weapon, 2 shield, 1 gadget, 20 cargo, 16/tank
	Hornet,
	// Grasshopper
	// 30 cargo/ 2 weapons, 2 shield, 3 gadget, 3 crew, 15/tank
	Grasshopper,
	// Termite
	// Strong hull, 3 shield, 2 gadgets, 3 crew, 60 cargo, 1 weapon, 13/tank
	Termite,
	// Wasp
	// Utimalte private ship, strong hull, 3 weapons, 2 shield, 2 gadget, 3 crew, 14/tank, 35 cargo
	Wasp(14, 300, 3, 2, 2, 35, 3, 0),
	// Canefaitrien
	Canefaitrien // Ultimate fighting, trading ship
	;
	

	private int maxWeaponSlots;
	private int maxGadgetSlots;
	private int maxShieldSlots;
	private int maxDistance;
	private int maxCargoHold;
	private int maxCrew;
	private int maxMercernary;
	private int maxHullStrength;
	
	ShipType() {	
	}
	
	ShipType (	int maxDistance, int maxHullStrength,
				int maxWeaponSlots, int maxGadgetSlots, int maxShieldSlots,
				int maxCargoHold,
				int maxCrewMembers, int maxMercernary) {
		
		this.maxDistance = maxDistance;
		this.maxWeaponSlots = maxWeaponSlots;
		this.maxGadgetSlots = maxGadgetSlots;
		this.maxCrew = maxCrewMembers;
		this.maxCargoHold = maxCargoHold;
		this.maxHullStrength = maxHullStrength;
		this.maxMercernary = maxMercernary;
		this.maxShieldSlots = maxShieldSlots;
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
		switch (this) {

		case Gnat:
			return "Gnat";
		case Wasp:
			return "Wasp";
		case Beetle:
			return "Wasp";
		case Bumblebee:
			return "Wasp";
		case Canefaitrien:
			return "Wasp";
		case Firefly:
			return "Wasp";
		case Flea:
			return "Wasp";
		case Grasshopper:
			return "Wasp";
		case Hornet:
			return "Wasp";
		case Mosquito:
			return "Wasp";
		case Termite:
			return "Wasp";
		default:
			return "Canefaitrien";
		}
		
	}

}