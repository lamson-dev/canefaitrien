package model;

import java.util.Random;

import controller.Controller;


/**
 * Class for handling the amounts and prices of gadget a planet can have.  Also 
 * handles buying and selling gadget
 * 
 * @author An Pham (modified MarketPlace written by Andrew Duda)
 * @version 1.0
 * @Date 11/17/12
 */
public class ShipYard {

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
	private Situation situation;
	private Controller data;
	
	/**
	 * constructor
	 */
	public ShipYard(int lastDock, int[] itemStock, int[] itemBuyPrices,
			int[] itemSellPrices, TechLevel level, Situation situation) {
		this.lastDock = lastDock;
		this.itemStock = itemStock;
		this.itemBuyPrices = itemBuyPrices;
		this.itemSellPrices = itemSellPrices;
		this.level = level;
		this.situation = situation;
	}
	
	/**
	 * new ShipYard
	 */
	public ShipYard(int lastDock, TechLevel level, Situation situation) {
		this(lastDock, new int[goods.length], new int[goods.length],
				new int[goods.length], level, situation);
		updateStock();
	}

	public ShipYard(Controller data) {
		this.data = data;
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
