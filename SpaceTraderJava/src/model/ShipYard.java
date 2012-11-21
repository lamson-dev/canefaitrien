// $codepro.audit.disable unnecessaryImport
package model;

import java.util.ArrayList;
import java.util.List;

import model.Gadget.GadgetType;
import model.Shield.ShieldType;
import model.Weapon.WeaponType;
import controller.Controller;

/**
 * Class for handling the amounts and prices of gadget a planet can have. Also
 * handles buying and selling gadget
 * 
 * @author An Pham
 * @version 1.0
 * @Date 11/17/12
 */
public class ShipYard {

	private Controller data;
	private List<ShipYardItem> items;

	/**
	 * constructor
	 */

	/**
	 * new ShipYard
	 */

	public ShipYard(Controller data) {
		this.data = data;
		setup();
	}

	/**
	 * Setting up, create new shipyard items.
	 */
	public void setup() {
		items = new ArrayList<ShipYardItem>();

		WeaponType[] weapons = WeaponType.values();
		for (int i = 0; i < weapons.length; i++) {
			items.add(new ShipYardItem(new Weapon(weapons[i])));
		}
		GadgetType[] gadgets = GadgetType.values();
		for (int i = 0; i < gadgets.length; i++) {
			items.add(new ShipYardItem(new Gadget(gadgets[i])));
		}
		ShieldType[] shields = ShieldType.values();
		for (int i = 0; i < shields.length; i++) {
			items.add(new ShipYardItem(new Shield(shields[i])));
		}
	}

	/**
	 * Buy new Ship
	 * 
	 * @param type
	 */
	public void buyShip(ShipType type, int price) {
		// Take all goods
		int[] cargo = data.getShip().getCargo();
		for (int i = 0; i < cargo.length; i++)
			cargo[i] = 0;

		Ship newShip = new Ship(type);
		// Transfer weapon
		newShip.setWeapons(data.getShip().getWeaponList());
		// Transfer gadget
		newShip.setGadgets(data.getShip().getGadgetList());
		// Transfer shield
		newShip.setShields(data.getShip().getShieldList());
		data.setMoney(data.getMoney() - price);
		data.setShip(newShip);
	}

	public List<ShipYardItem> getShipYard() {
		return items;
	}

}
