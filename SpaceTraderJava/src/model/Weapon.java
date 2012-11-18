package model;
/**
 * Weapon class
 * @author An Pham
 * @Date 11/17/12
 * @Version 1.0
 *
 */
public class Weapon implements Equipment{
	//There are three types of lasers: pulse lasers, beam lasers and military lasers
	public enum WeaponType {
		// (BasePrice | Damage
		PULSE_LASER(200, 20, "PULSE_LASER"), 
		BEAM_LASER(600, 60, "BEAM_LASER"), 
		MILITARY_LASER(2000, 200,"MILITARY_LASER");
		
		// Private instance variables
		private int basePrice;
		private String type;
		private int damage;
		
		// Constructor
		private WeaponType(int baseprice, int damage, String type) {
			this.basePrice = baseprice;
			this.damage = damage;
			this.type = type;
		}
		
		// Accessors
		public int getBasePrice() {
			return basePrice;
		}
		public String getType() {
			return type;
		}
		public int getDamage() {
			return damage;
		}
		
	};
	
	private WeaponType weaponType;
	
	public Weapon(WeaponType type) {
		this.weaponType = type;
	}
	
	@Override
	public void addToShip(Ship s) {
		// TODO Auto-generated method stub
	}

	@Override
	public int getBasePrice() {
		return weaponType.getBasePrice();
	}
	public String toString() {
		return weaponType.toString();
	}
}