package model;

/**
 * Shield class
 * @author An Pham
 * @Date 11/17/12
 * @Version 1.0
 *
 */
public class Shield implements Equipment{
	//There are two types of shields: energy shields and reflective shields
	public enum ShieldType {
		// (Price | Strength | Name)
		ENERGY(200, 20, "PULSE_LASER"), 
		REFLECTIVE(300, 60, "BEAM_LASER");
		
		// Private instance variables
		private int basePrice;
		private String type;
		private int strength;
		
		// Constructor
		private ShieldType(int baseprice, int strength, String type) {
			this.basePrice = baseprice;
			this.strength = strength;
			this.type = type;
		}
		
		// Accessors
		public int getBasePrice() {
			return basePrice;
		}
		public String getType() {
			return type;
		}
		public int getStrength() {
			return strength;
		}
		
	};
	
	private ShieldType shieldType;
	
	public Shield(ShieldType type) {
		this.shieldType = type;
	}
	
	@Override
	public void addToShip(Ship s) {
		// TODO Auto-generated method stub
	}

	@Override
	public int getBasePrice() {
		return shieldType.getBasePrice();
	}
	public String toString() {
		return shieldType.toString();
	}
	public ShieldType getType() {
		return shieldType;
	}
}