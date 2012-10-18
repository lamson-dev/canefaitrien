public class Ship {
	
	private ShipType type;
	private int hullStrength;
	
	// private GadgetType gadget;
	// etc...
	
	
	public Ship(ShipType type) {
		this.type = type;
		hullStrength = type.getMaxHullStrength();
	}
	
	public ShipType getType() {
		return type;
	}
	
	public static void main (String arg[]) {
		Ship test = new Ship(ShipType.Wasp);
		System.out.println(test.getType());
	}
}