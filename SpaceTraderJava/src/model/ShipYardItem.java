package model;

import java.util.Random;

public class ShipYardItem {
	Equipment equipment;
	int available;
	int price;
	
	public ShipYardItem(Equipment equipment) {
		this.equipment = equipment;
		available = new Random().nextInt(10);
		price = new Random().nextInt(10) * equipment.getBasePrice();
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
}