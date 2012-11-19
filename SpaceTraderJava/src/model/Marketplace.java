package model;

import java.util.Random;


/**
 * Class for handling the amounts and prices of goods a Planet's marketplace can have.  Also 
 * handles buying and selling goods
 * 
 * @author Andrew Duda
 * @version 1.0
 */
public class Marketplace {

	// Marketplace constants
	private static final int STOCK_REFRESH_TURNS = 5; // turns to recreate marketplace
	private static final int MIN_NUM_GOODS = 5, VARIANCE = 5; // for inventory creation
	public static enum MarketAction {BUY, SELL};
	private static TradeGood[] goods = TradeGood.values();
	private static Random rand = new Random();
	
	// Marketplace info
	private int lastDock;
	private int[] itemStock;
	private int[] itemBuyPrices;
	private int[] itemSellPrices;
	private TechLevel level;
	/**
	 * Marketplace constructor for loading
	 */
	public Marketplace(int lastDock, int[] itemStock, int[] itemBuyPrices,
			int[] itemSellPrices, TechLevel level, Situation situation) {
		this.lastDock = lastDock;
		this.itemStock = itemStock;
		this.itemBuyPrices = itemBuyPrices;
		this.itemSellPrices = itemSellPrices;
		this.level = level;
	}
	
	/**
	 * Marketplace constructor for new Marketplace
	 */
	public Marketplace(int lastDock, TechLevel level, Situation situation) {
		this(lastDock, new int[goods.length], new int[goods.length],
				new int[goods.length], level, situation);
		updateStock();
	}

	/**
	 * Dock method to be called by Planet upon traveling to that Planet
	 */
	public void dock(int turnDocked) {
		if (turnDocked - lastDock > STOCK_REFRESH_TURNS) {
			updateStock();
			lastDock = turnDocked;
		}
	}

	/**
	 * Updates the good prices and the amount of goods
	 */
	public void updateStock() {
		for (TradeGood good : goods) {
			itemBuyPrices[good.ordinal()] = getBuyPrice(good);
			// situation modify
			itemSellPrices[good.ordinal()] = getSellPrice(good);

			if (itemBuyPrices[good.ordinal()] != 0) {
				itemStock[good.ordinal()] = rand.nextInt(VARIANCE)
						+ MIN_NUM_GOODS;
			}
		}

	}
	
	private int getBuyPrice(TradeGood good) {
		return getPrice(good, good.MIN_TL_PRODUCE);
	}

	private int getSellPrice(TradeGood good) {
		return (int)(0.9*getPrice(good, good.MIN_TL_USE)); // makes sell values less than buy values
	}

	private int getPrice(TradeGood good, int minTL) {
		if (level.ordinal() >= minTL) {
			int temp = good.BASE_PRICE + good.INCREASE_PER_TL
					* (level.ordinal() - good.MIN_TL_PRODUCE); // price
			temp += rand.nextBoolean() ? rand.nextInt(good.VARIANCE) : -rand
					.nextInt(good.VARIANCE); // price + variance
			return temp;
		} else {
			return 0;
		}
	}

	public int[] getItemStock() {
		return itemStock;
	}

	public int[] getItemBuyPrices() {
		return itemBuyPrices;
	}

	public int[] getItemSellPrices() {
		return itemSellPrices;
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
		for(int i = 0; i < ret.length; i++) {
			ret[i][0] = goods[i].toString();
			ret[i][1] = itemBuyPrices[i] + "";
			ret[i][2] = itemSellPrices[i] + "";
			ret[i][3] = itemStock[i] + "";
			ret[i][4] = cargo[i] + "";
		}
		return ret;
	}

	public String arrayToString(int[] array) {
		String ret = "[";
		for (int i : array) {
			ret += i + " ";
		}
		return ret + "]\n";
	}

	/**
	 * Extra method for selling and buying trade good Added by apham9 on October
	 * 29th, 2012
	 * 
	 */
	// public void buyGood(TradeGood good){
	// if (itemStock[good.ordinal()] == 0) {
	// // This is not in stock
	// // Throw exceptions
	// }
	// else {
	// itemStock[good.ordinal()]--;
	// }
	// }
	// public void sellGood(TradeGood good){
	// itemStock[good.ordinal()]++;
	// }

	public int buyGood(TradeGood good, Ship ship, int money) throws Exception {
		if (itemBuyPrices[good.ordinal()] > money) {
			throw new Exception ("We don't have enough money, captain!");
		} else if (itemStock[good.ordinal()] == 0) {
			throw new Exception("They don't have that good, captain!");
		} else {
			ship.addGood(good);// throw cargo full exception
			itemStock[good.ordinal()]--;
			return money - itemBuyPrices[good.ordinal()];
		}
	}

	/**
	 * Sell a good 
	 */
	public int sellGood(TradeGood good, Ship ship, int money) throws Exception {
		if (itemSellPrices[good.ordinal()] == 0) {
			throw new Exception("They don't need that good, captain!");
		} else {
			ship.removeGood(good);
			itemStock[good.ordinal()]++;
			return money + itemSellPrices[good.ordinal()];
		}
	}
}
