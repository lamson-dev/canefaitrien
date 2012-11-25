/**
 * @author An Pham
 * @Date 11/07/12
 * @Version 1.0
 */

package com.canefaitrien.spacetrader.models;

import java.util.Random;

public class TraderEncounter implements Encounter {

	private Controller data;

	private ShipType type = ShipType.getAShip();

	private TradeGood[] goods = TradeGood.values();

	private static final int MIN_NUM_GOODS = 5, VARIANCE = 5;

	private static Random RAND = new Random();

	// Cargo hold info
	private int[] itemStock = new int[TradeGood.values().length];

	private int[] itemBuyPrices = new int[TradeGood.values().length];

	private int[] itemSellPrices = new int[TradeGood.values().length];

	private TechLevel level = TechLevel.HI_TECH;

	public TraderEncounter(Controller data) {
		this.data = data;
		for (TradeGood good : goods) {
			itemBuyPrices[good.ordinal()] = getBuyPrice(good);
			// situation modify
			itemSellPrices[good.ordinal()] = getSellPrice(good);

			if (itemBuyPrices[good.ordinal()] != 0) {
				itemStock[good.ordinal()] = RAND.nextInt(VARIANCE)
						+ MIN_NUM_GOODS;
			}
		}
	}

	/**
	 * @Return true if survive false otherwise
	 */
	public boolean canTraderBattle() {
		return ((data.getShip().getHullStrength() - type.maxHullStrength) > 0);
	}

	private int getBuyPrice(TradeGood good) {
		return getPrice(good, good.minTLProduce);
	}

	private int getSellPrice(TradeGood good) {
		return getPrice(good, good.minTLUse); // makes sell
																// values less
																// than buy
																// values
	}

	private int getPrice(TradeGood good, int minTL) {
		if (level.ordinal() >= minTL) {
			int temp = good.basePrice + good.increasePerTL
					* (level.ordinal() - good.minTLProduce); // price
			temp += RAND.nextBoolean() ? RAND.nextInt(good.variance) : -RAND
					.nextInt(good.variance); // price + variance
			return temp;
		} else {
			return 0;
		}
	}

	public String[] getBuyView(Ship ship) {
		String[] ret = new String[itemStock.length];
		int[] cargo = ship.getCargo();
		for (int i = 0; i < itemStock.length; i++) {
			ret[i] = goods[i].toString() + ": Price " + itemBuyPrices[i]
					+ ", Available:" + itemStock[i] + ", In Cargo " + cargo[i];
		}
		return ret;
	}

	public String[] getSellView(Ship ship) {
		String[] ret = new String[itemStock.length];
		int[] cargo = ship.getCargo();
		for (int i = 0; i < itemStock.length; i++) {
			ret[i] = goods[i].toString() + ": Price " + itemSellPrices[i]
					+ ", Available:" + itemStock[i] + ", In Cargo " + cargo[i];
		}
		return ret;
	}

	public String[][] getView(Ship ship) {
		String[][] ret = new String[itemStock.length][5];
		int[] cargo = ship.getCargo();
		for (int i = 0; i < ret.length; i++) {
			ret[i][0] = goods[i].toString();
			ret[i][1] = itemBuyPrices[i] + "";
			ret[i][2] = itemSellPrices[i] + "";
			ret[i][3] = itemStock[i] + "";
			ret[i][4] = cargo[i] + "";
		}
		return ret;
	}
	
	@Override
	public String toString() {
		return super.toString();
	}
}
