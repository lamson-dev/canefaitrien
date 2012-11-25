/**
 * Pirate Encounter Handler
 * 
 */

package com.canefaitrien.spacetrader.models;

/**
 * 
 * @author An Pham
 * @version $Revision: 1.0 $
 */
public class PirateEncounter implements Encounter {

	/**
	 * Field data.
	 */
	private Controller data;

	/**
	 * Field type.
	 */
	private ShipType type = ShipType.getAShip();

	/**
	 * Constructor for PirateEncounter.
	 * 
	 * @param data
	 *            Controller
	 */
	public PirateEncounter(Controller data) {
		this.data = data;
	}

	/**
	 * Method takeGoods.
	 */
	public void takeGoods() {

		int[] cargo = data.getShip().getCargo();
		for (int i = 0; i < cargo.length; i++) {
			cargo[i] = 0;
		}
	}

	/**
	 * 
	 * @return boolean
	 */
	public boolean canPirateFlee() {
		return ((data.getShip().getMaxSpeed() - type.maxDistance) > 0);
	}

	/**
	 * 
	 * @return boolean
	 */
	public boolean canPirateBattle() {
		return ((data.getShip().getHullStrength() - type.maxHullStrength) > 0);
	}

	/**
	 * Method toString.
	 * 
	 * @return String
	 */
	@Override
	public String toString() {
		return super.toString();
	}
}
