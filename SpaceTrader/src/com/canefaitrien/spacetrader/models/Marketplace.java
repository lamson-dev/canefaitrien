package com.canefaitrien.spacetrader.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.json.JSONArray;
import org.json.JSONException;

import com.canefaitrien.spacetrader.interfaces.GameConstants;

/**
 * Class for handling the amounts and prices of goods a Planet's marketplace can
 * have. Also handles buying and selling goods
 * 
 * @author Andrew Duda
 * @version 1.0
 */
public class Marketplace implements GameConstants {

	public static enum MarketAction {
		BUY, SELL
	};

	private static TradeGood[] goods = TradeGood.values();
	private static Random rand = new Random();

	// Marketplace info
	private int lastDock;
	private int[] itemStock;
	private int[] itemBuyPrices;
	private int[] itemSellPrices;
	private TechLevel level;
	private Situation situation;

	private Long id;

	// private Integer lastDock;
	// private String itemStock;
	// private String itemBuyPrices;
	// private String itemSellPrices;

	public Marketplace() {
	}

	public Marketplace(Long id) {
		this.id = id;
	}

	/**
	 * Marketplace constructor for loading
	 */
	public Marketplace(Long id, Integer lastDock, String itemStock,
			String itemBuyPrices, String itemSellPrices) throws JSONException {
		this.id = id;
		this.lastDock = lastDock;
		this.setItemStock(itemStock);
		this.setItemBuyPrices(itemBuyPrices);
		this.setItemSellPrices(itemSellPrices);

		// planets set techlevel + situation
	}

	/**
	 * Marketplace constructor for new Marketplace
	 */
	public Marketplace(int lastDock, TechLevel level, Situation situation) {
		this(lastDock, new int[goods.length], new int[goods.length],
				new int[goods.length], level, situation);
		updateStock();
	}

	public Marketplace(int lastDock, int[] itemStock, int[] itemBuyPrices,
			int[] itemSellPrices, TechLevel level, Situation situation) {
		this.lastDock = lastDock;
		this.itemStock = itemStock;
		this.itemBuyPrices = itemBuyPrices;
		this.itemSellPrices = itemSellPrices;
		this.level = level;
		this.setSituation(situation);
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
		return (int) (0.9 * getPrice(good, good.MIN_TL_USE)); // makes sell
																// values less
																// than buy
																// values
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
		for (int i = 0; i < ret.length; i++) {
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

	public int buyGood(TradeGood good, Ship ship, int money) throws Exception {
		if (itemBuyPrices[good.ordinal()] > money) {
			throw new Exception("We don't have enough money, captain!");
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getLastDock() {
		return lastDock;
	}

	public void setLastDock(Integer lastDock) {
		this.lastDock = lastDock;
	}

	public String getStringItemStock() {
		List<Integer> list = new ArrayList<Integer>();
		for (int item : this.getItemStock())
			list.add(item);
		JSONArray json = new JSONArray(list);
		return json.toString();
	}

	public void setItemStock(String itemStock) throws JSONException {
		JSONArray jsonArray = new JSONArray(itemStock);
		if (jsonArray != null) {
			int[] stock = new int[goods.length];
			for (int i = 0; i < jsonArray.length(); i++) {
				stock[i] = jsonArray.getInt(i);
			}
			this.itemStock = stock;
		}
	}

	public String getStringItemBuyPrices() {
		List<Integer> list = new ArrayList<Integer>();
		for (int item : this.getItemBuyPrices())
			list.add(item);
		JSONArray json = new JSONArray(list);
		return json.toString();
	}

	public void setItemBuyPrices(String itemBuyPrices) throws JSONException {
		JSONArray jsonArray = new JSONArray(itemBuyPrices);
		if (jsonArray != null) {
			int[] buyPrices = new int[goods.length];
			for (int i = 0; i < jsonArray.length(); i++) {
				buyPrices[i] = jsonArray.getInt(i);
			}
			this.itemBuyPrices = buyPrices;
		}
	}

	public String getStringItemSellPrices() {
		List<Integer> list = new ArrayList<Integer>();
		for (int item : this.getItemSellPrices())
			list.add(item);
		JSONArray json = new JSONArray(list);
		return json.toString();
	}

	public void setItemSellPrices(String itemSellPrices) throws JSONException {
		JSONArray jsonArray = new JSONArray(itemSellPrices);
		if (jsonArray != null) {
			int[] sellPrices = new int[goods.length];
			for (int i = 0; i < jsonArray.length(); i++) {
				sellPrices[i] = jsonArray.getInt(i);
			}
			this.itemSellPrices = sellPrices;
		}
	}

	public Situation getSituation() {
		return situation;
	}

	public void setSituation(Situation situation) {
		this.situation = situation;
	}

}
