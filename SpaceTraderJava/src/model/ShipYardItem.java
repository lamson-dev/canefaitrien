package model;

import java.util.Random;
/**
 * This is to represent various ship yard item
 * @author Arian
 * @Date 11/08/12
 * @Version 1.0
 */
public class ShipYardItem {
	Equipment equipment;
	int available;
	int price;
	
	// Constructor
	public ShipYardItem(Equipment equipment) {
		this.equipment = equipment;
		available = new Random().nextInt(10);// Random quantity
		price = new Random().nextInt(10) * equipment.getBasePrice() + 50;// make sure this is never free
	}
	
	public int getQuantity() {
		return available;
	}
	
	public int getPrice() {
		return price;
	}
	
	public String getName() {
		return equipment.toString();
	}
	// Get the item back
	public Equipment getType() {
		return equipment;
	}
	public void setQuantity(int q) {
		available = q;
	}
}