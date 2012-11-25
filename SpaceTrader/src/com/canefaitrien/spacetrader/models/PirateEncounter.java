/**
 * Pirate Encounter Handler
 * 
 * @author: An Pham
 * @Date 07/11/12
 * @Version 1.0
 */

package com.canefaitrien.spacetrader.models;

public class PirateEncounter implements Encounter {

	private Controller data;

	private ShipType type = ShipType.getAShip();

	public PirateEncounter(Controller data) {
		this.data = data;
	}

	public void takeGoods() {

		int[] cargo = data.getShip().getCargo();
		for (int i = 0; i < cargo.length; i++) {
			cargo[i] = 0;
		}
	}

	/**
	 * @Return true if get away false otherwise
	 */
	public boolean canPirateFlee() {
		return ((data.getShip().getMaxSpeed() - type.maxDistance) > 0);
	}

	/**
	 * @Return true if survive false otherwise
	 */
	public boolean canPirateBattle() {
		return ((data.getShip().getHullStrength() - type.maxHullStrength) > 0);
	}

	@Override
	public String toString() {
		return super.toString();
	}
}
