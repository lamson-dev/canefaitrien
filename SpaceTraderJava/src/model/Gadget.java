package model;

/**
 * Shield class
 * @author An Pham
 * @Date 11/17/12
 * @Version 1.0
 *
 */
public class Gadget implements Equipment{
	// There are five types of gadgets available.
	// For a beginning trader, the most interesting gadget is probably 5 extra cargo bays. These are fairly cheap and allow you to carry more cargo, 
	// so you probably earn them back quickly. If there is more than one gadget slot on your ship, you can even install more than one of this gadget, 
	// increasing your cargo bays even more. A navigating system helps you piloting your ship. An auto-repair system helps your engineering functions. 
	// A targeting system helps you handle your weaponry. A cloaking device is perhaps the most interesting gadget a trader can buy. 
	// It is very expensive, but it allows you to travel through space undetected, as long as you don't attack.
	public enum GadgetType {
		// (Price | Name)
		FIVE_EXTRA(20, "FIVE_EXTRA"), 
		NAVIGATE(30, "NAVIGATE"),
		AUTOREPAIR(40, "AUTOREPAIR"),
		TARGET(50, "TARGET"),
		CLOAK_DEVICE(80, "CLOAK_DEVICE");
		
		// Private instance variables
		private int basePrice;
		private String type;
		
		// Constructor
		private GadgetType(int baseprice, String type) {
			this.basePrice = baseprice;
			this.type = type;
		}
		
		// Accessors
		public int getBasePrice() {
			return basePrice;
		}
		public String getType() {
			return type;
		}
		
	};
	
	private GadgetType gadgetType;
	
	public Gadget(GadgetType type) {
		this.gadgetType = type;
	}
	
	@Override
	public void addToShip(Ship s) {
		// TODO Auto-generated method stub
	}

	@Override
	public int getBasePrice() {
		return gadgetType.getBasePrice();
	}
	public String toString() {
		return gadgetType.toString();
	}

	public GadgetType getType() {
		return gadgetType;
	}
}