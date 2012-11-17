package model;

import java.util.Random;

import controller.Controller;


/**
 * Class for handling the amounts and prices of gadget a planet can have.  Also 
 * handles buying and selling gadget
 * 
 * @author An Pham
 * @version 1.0
 * @Date 11/17/12
 */
public class ShipYard {

	
	private Controller data;
	
	/**
	 * constructor
	 */
	
	
	/**
	 * new ShipYard
	 */

	public ShipYard(Controller data) {
		this.data = data;
	}
	

	public void buyShip(ShipType type) {
		// Take all goods
		int[] cargo = data.getShip().getCargo();
		for (int i = 0; i < cargo.length; i++)
			cargo[i] = 0;

		Ship newShip = new Ship(type);
		newShip.setWeapons(data.getShip().getWeaponList());

		data.setShip(newShip);
	}

}
