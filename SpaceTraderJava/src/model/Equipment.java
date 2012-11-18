package model;

/**
 * Interface equipment, is to be implemented with shield, gadget, and weapon
 * @author An Pham
 * @Date 11/17/12
 * @Version 1.0
 */
public interface Equipment {
	// Add equipment to ship
	public void addToShip(Ship s);
	public int getBasePrice();
}