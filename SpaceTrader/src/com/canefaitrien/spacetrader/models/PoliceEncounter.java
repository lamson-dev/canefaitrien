/**
 * Handling PoliceEncounter
 */
package com.canefaitrien.spacetrader.models;

import java.util.Random;

/**
 * @author An Pham
 * @version $Revision: 1.0 $
 */
public class PoliceEncounter implements Encounter {

	private static final int THREE = 3;

	private static final int TEN = 10;

	private static final int TWO = 2;

	// HORNET(16, 300, 3, 1, 2, 20, 0, 0, "Hornet"),
	// 30 cargo/ 2 weapons, 2 shield, 3 gadget, 3 crew, 15/tank
	
	/**
	 * Decide the percentage of player's money will be taken away 
	 * 		if he is caught transporting illegal good. 
	 */
	private final int FINE_CONSTANT = 3;// 3 for 30%
	
	/**
	 * Field policeShip.
	 */
	private final Ship policeShip = new Ship(ShipType.HORNET);

	/**
	 * Field illegalTradeGood.
	 */
	private final TradeGood[] illegalTradeGood;

	/**
	 * Field data.
	 */
	private final Controller data;

	/**
	 * Constructor for PoliceEncounter.
	 * 
	 * @param data
	 *            Controller
	 */
	public PoliceEncounter(Controller data) {
		illegalTradeGood = new TradeGood[TWO];
		illegalTradeGood[0] = TradeGood.NARCOTICS;
		illegalTradeGood[1] = TradeGood.FIREARMS;
		this.data = data;
	}

	/**
	 * Check for illegal goods
	 * 
	 * 
	 * @return money after fines
	 */
	public int checkGoods() {
		final int[] goods = data.getShip().getCargo();
		if (goods[TradeGood.NARCOTICS.ordinal()] == 0
				&& goods[TradeGood.FIREARMS.ordinal()] == 0) {
			return data.getMoney();
		} else {
			data.setMoney((data.getMoney() << THREE) / TEN);
			goods[TradeGood.NARCOTICS.ordinal()] = 0;
			goods[TradeGood.FIREARMS.ordinal()] = 0;
		}
		return data.getMoney();
	}

	/**
	 * Method is called to bribe the police
	 * 
	 * @param amount
	 * 
	 * @return true upon successful, false otherwise
	 */
	public boolean canBribePolice(int amount) {
		final int currentMoney = data.getMoney();
		final int bribeMoney = new Random().nextInt(currentMoney / TEN);
		if (amount < bribeMoney || amount > currentMoney) {
			return false;
		} else {
			data.setMoney(currentMoney - amount);
		}
		return true;
	}

	/**
	 * 
	 * @return boolean
	 */
	public boolean canPoliceBattle() {
		return ((data.getShip().getHullStrength() - policeShip
				.getHullStrength()) > 0);
	}

	/**
	 * 
	 * @return boolean
	 */
	public boolean canPoliceFlee() {
		return ((data.getShip().getMaxSpeed() - policeShip.getMaxSpeed()) > 0);
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
