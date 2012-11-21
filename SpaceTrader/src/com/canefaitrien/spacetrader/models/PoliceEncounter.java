package com.canefaitrien.spacetrader.models;

/**
 * Handling PoliceEncounter
 * @author An Pham
 * @Data 11/ 07/ 12
 * @Version 1.0
 */
import java.util.Random;

public class PoliceEncounter implements Encounter {

	// HORNET(16, 300, 3, 1, 2, 20, 0, 0, "Hornet"),
	// 30 cargo/ 2 weapons, 2 shield, 3 gadget, 3 crew, 15/tank
	private Ship policeShip = new Ship(ShipType.HORNET);

	private TradeGood[] illegalTradeGood;

	private Controller data;

	public PoliceEncounter(Controller data) {
		illegalTradeGood = new TradeGood[2];
		illegalTradeGood[0] = TradeGood.NARCOTICS;
		illegalTradeGood[1] = TradeGood.FIREARMS;
		this.data = data;
	}

	public void encounter() {

	}

	/**
	 * Check for illegal goods
	 * 
	 * @return money after fines
	 */
	public int checkGoods() {
		int[] goods = data.getShip().getCargo();
		if (goods[TradeGood.NARCOTICS.ordinal()] == 0
				&& goods[TradeGood.FIREARMS.ordinal()] == 0) {
			return data.getMoney();
		} else {
			data.setMoney(data.getMoney() * 8 / 10);
			goods[TradeGood.NARCOTICS.ordinal()] = 0;
			goods[TradeGood.FIREARMS.ordinal()] = 0;
		}
		return data.getMoney();
	}

	/**
	 * Method is called to bribe the police
	 * 
	 * @param amount
	 * @return true upon successful, false otherwise
	 */
	public boolean bribePolice(int amount) {
		int currentMoney = data.getMoney();
		int bribeMoney = new Random().nextInt(currentMoney / 10);
		if (amount < bribeMoney || amount > currentMoney) {
			return false;
		} else
			data.setMoney(currentMoney - amount);
		return true;
	}

	/**
	 * @Return true if survive false otherwise
	 */
	public boolean policeBattle() {
		return ((data.getShip().getHullStrength() - policeShip
				.getHullStrength()) > 0);
	}

	/**
	 * @Return true if get away false otherwise
	 */
	public boolean policeFlee() {
		return ((data.getShip().getMaxSpeed() - policeShip.getMaxSpeed()) > 0);
	}
}
