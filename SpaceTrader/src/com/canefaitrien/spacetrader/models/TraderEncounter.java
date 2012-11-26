/**
 */

package com.canefaitrien.spacetrader.models;

import java.util.Random;

/**
 * 
 * @author An Pham
 * @version $Revision: 1.0 $
 */
public class TraderEncounter implements Encounter {

	/**
	 * Field data.
	 */
	private final Controller data;

	/**
	 * Field type.
	 */
	private final ShipType type = ShipType.getAShip();

	/**
	 * Field goods.
	 */
	private final TradeGood[] goods = TradeGood.values();

	/**
	 * Field VARIANCE. (value is 5)
	 */
	/**
	 * Field MIN_NUM_GOODS. (value is 5)
	 */
	private static final int MIN_NUM_GOODS = 5, VARIANCE = 5;

	/**
	 * Field RAND.
	 */
	private static final Random RAND = new Random();

	// Cargo hold info
	/**
	 * Field itemStock.
	 */
	private final int[] itemStock = new int[TradeGood.values().length];

	/**
	 * Field itemBuyPrices.
	 */
	private final int[] itemBuyPrices = new int[TradeGood.values().length];

	/**
	 * Field itemSellPrices.
	 */
	private final int[] itemSellPrices = new int[TradeGood.values().length];

	/**
	 * Field level.
	 */
	private final TechLevel level = TechLevel.HI_TECH;

	/**
	 * Constructor for TraderEncounter.
	 * 
	 * @param data
	 *            Controller
	 */
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
	 * 
	 * @return boolean
	 */
	public boolean canTraderBattle() {
		return ((data.getShip().getHullStrength() - type.maxHullStrength) > 0);
	}

	/**
	 * Method getBuyPrice.
	 * 
	 * @param good
	 *            TradeGood
	 * @return int
	 */
	private int getBuyPrice(TradeGood good) {
		return getPrice(good, good.minTLProduce);
	}

	/**
	 * Method getSellPrice.
	 * 
	 * @param good
	 *            TradeGood
	 * @return int
	 */
	private int getSellPrice(TradeGood good) {
		return getPrice(good, good.minTLUse); // makes sell
												// values less
												// than buy
												// values
	}

	/**
	 * Method getPrice.
	 * 
	 * @param good
	 *            TradeGood
	 * @param minTL
	 *            int
	 * @return int
	 */
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

	/**
	 * Method getBuyView.
	 * 
	 * @param ship
	 *            Ship
	 * @return String[]
	 */
	public String[] getBuyView(Ship ship) {
		final String[] ret = new String[itemStock.length];
		final int[] cargo = ship.getCargo();
		for (int i = 0; i < itemStock.length; i++) {
			ret[i] = goods[i].toString() + ": Price " + itemBuyPrices[i]
					+ ", Available:" + itemStock[i] + ", In Cargo " + cargo[i];
		}
		return ret;
	}

	/**
	 * Method getSellView.
	 * 
	 * @param ship
	 *            Ship
	 * @return String[]
	 */
	public String[] getSellView(Ship ship) {
		final String[] ret = new String[itemStock.length];
		final int[] cargo = ship.getCargo();
		for (int i = 0; i < itemStock.length; i++) {
			ret[i] = goods[i].toString() + ": Price " + itemSellPrices[i]
					+ ", Available:" + itemStock[i] + ", In Cargo " + cargo[i];
		}
		return ret;
	}

	/**
	 * Method getView.
	 * 
	 * @param ship
	 *            Ship
	 * @return String[][]
	 */
	public String[][] getView(Ship ship) {
		final String[][] ret = new String[itemStock.length][5];
		final int[] cargo = ship.getCargo();
		for (int i = 0; i < ret.length; i++) {
			ret[i][0] = goods[i].toString();
			ret[i][1] = itemBuyPrices[i] + "";
			ret[i][2] = itemSellPrices[i] + "";
			ret[i][3] = itemStock[i] + "";
			ret[i][4] = cargo[i] + "";
		}
		return ret;
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
