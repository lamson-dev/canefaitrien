// $codepro.audit.disable largeNumberOfParameters
/**
 * Class for handling the amounts and prices of goods a Planet's marketplace can
 * have. Also handles buying and selling goods
 * 
 * @author Andrew Duda
 * @version 1.0
 */

package com.canefaitrien.spacetrader.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.json.JSONArray;
import org.json.JSONException;

import com.canefaitrien.spacetrader.interfaces.GameConstants;


/**
 * 
 * @author Son Nguyen
 *
 * @version $Revision: 1.0 $
 */
public class Marketplace implements GameConstants {

	/**
	 * Field GOODS.
	 */
	private static TradeGood[] GOODS = TradeGood.values();

	/**
	 * Field RAND.
	 */
	private static Random RAND = new Random();

	// Marketplace info
	/**
	 * Field lastDock.
	 */
	private int lastDock;

	/**
	 * Field itemStock.
	 */
	private int[] itemStock;

	/**
	 * Field itemBuyPrices.
	 */
	private int[] itemBuyPrices;

	/**
	 * Field itemSellPrices.
	 */
	private int[] itemSellPrices;

	/**
	 * Field level.
	 */
	private TechLevel level;

	/**
	 * Field situation.
	 */
	private Situation situation;

	/**
	 * Field id.
	 */
	private Long id;

	/**
	 * Constructor for Marketplace
	 */
	public Marketplace() { // $codepro.audit.disable emptyMethod
	}

	/**
	 * Constructor for Marketplace
	 * 
	 * @param id
	 */
	public Marketplace(Long id) {
		this.id = id;
	}

	/**
	 * Constructor for Marketplace
	 * 
	 * @param id
	 * @param lastDock
	 * @param itemStock
	 * @param itemBuyPrices
	 * @param itemSellPrices
	
	 * @throws JSONException */
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
	 * Constructor for Marketplace
	 * 
	 * @param lastDock
	 * @param level
	 * @param situation
	 */
	public Marketplace(int lastDock, TechLevel level, Situation situation) {
		this(lastDock, new int[GOODS.length], new int[GOODS.length],
				new int[GOODS.length], level, situation);
		updateStock();
	}

	/**
	 * Constructor for Marketplace
	 * 
	 * @param lastDock
	 * @param itemStock
	 * @param itemBuyPrices
	 * @param itemSellPrices
	 * @param level
	 * @param situation
	 */
	public Marketplace(int lastDock, int[] itemStock, int[] itemBuyPrices,
			int[] itemSellPrices, TechLevel level, Situation situation) {
		this.lastDock = lastDock;
		this.itemStock = itemStock.clone();
		this.itemBuyPrices = itemBuyPrices.clone();
		this.itemSellPrices = itemSellPrices.clone();
		this.level = level;
		this.situation = situation;
	}

	/**
	 * Dock method to be called by Planet upon traveling to that Planet
	 * 
	 * @param turnDocked
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
	public final void updateStock() {
		for (TradeGood good : GOODS) {
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
	 * Private method to get the buy price of a good
	 * 
	 * @param good
	
	 * @return int
	 */
	private int getBuyPrice(TradeGood good) {
		return getPrice(good, good.minTLProduce);
	}

	/**
	 * Private method to get the sell price of a good
	 * 
	 * @param good
	
	 * @return int
	 */
	private int getSellPrice(TradeGood good) {
		return getPrice(good, good.minTLUse);
		// 0.8 makes sell values less than buy values
	}

	/**
	 * Method to calculate the price of a good based on the TechLevel
	 * 
	 * @param good
	 * @param minTL
	
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
	 * Method for a Player to buy a good from Marketplace
	 * 
	 * @param good
	 * @param ship
	 * @param money

	 * @return int
	 * @throws Exception */
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
	 * Method for a Player to sell a good to the Marketplace
	 * 
	 * @param good
	 * @param ship
	 * @param money

	 * @return int
	 * @throws Exception */
	public int sellGood(TradeGood good, Ship ship, int money) throws Exception {
		if (itemSellPrices[good.ordinal()] == 0) {
			throw new Exception("They don't need that good, captain!");
		} else {
			ship.removeGood(good);
			itemStock[good.ordinal()]++;
			return money + itemSellPrices[good.ordinal()];
		}
	}

	/**
	 * Method getStringItemStock.
	 * @return String
	 */
	public String getStringItemStock() {
		List<Integer> list = new ArrayList<Integer>();
		for (int item : this.getItemStock())
			list.add(item);
		JSONArray json = new JSONArray(list);
		return json.toString();
	}

	/**
	 * Method setItemStock.
	 * @param itemStock String
	 * @throws JSONException
	 */
	public final void setItemStock(String itemStock) throws JSONException {
		JSONArray jsonArray = new JSONArray(itemStock);
		int[] stock = new int[GOODS.length];
		for (int i = 0; i < jsonArray.length(); i++) {
			stock[i] = jsonArray.getInt(i);
		}
		this.itemStock = stock;
	}

	/**
	 * Method getStringItemBuyPrices.
	 * @return String
	 */
	public String getStringItemBuyPrices() {
		List<Integer> list = new ArrayList<Integer>();
		for (int item : this.getItemBuyPrices())
			list.add(item);
		JSONArray json = new JSONArray(list);
		return json.toString();
	}

	/**
	 * Method setItemBuyPrices.
	 * @param itemBuyPrices String
	 * @throws JSONException
	 */
	public final void setItemBuyPrices(String itemBuyPrices)
			throws JSONException {
		JSONArray jsonArray = new JSONArray(itemBuyPrices);
		int[] buyPrices = new int[GOODS.length];
		for (int i = 0; i < jsonArray.length(); i++) {
			buyPrices[i] = jsonArray.getInt(i);
		}
		this.itemBuyPrices = buyPrices;
	}

	/**
	 * Method getStringItemSellPrices.
	 * @return String
	 */
	public String getStringItemSellPrices() {
		List<Integer> list = new ArrayList<Integer>();
		for (int item : this.getItemSellPrices())
			list.add(item);
		JSONArray json = new JSONArray(list);
		return json.toString();
	}

	/**
	 * Method setItemSellPrices.
	 * @param itemSellPrices String
	 * @throws JSONException
	 */
	public final void setItemSellPrices(String itemSellPrices)
			throws JSONException {
		JSONArray jsonArray = new JSONArray(itemSellPrices);
		int[] sellPrices = new int[GOODS.length];
		for (int i = 0; i < jsonArray.length(); i++) {
			sellPrices[i] = jsonArray.getInt(i);
		}
		this.itemSellPrices = sellPrices;
	}

	/**
	 * Method getSituation.
	 * @return Situation
	 */
	public Situation getSituation() {
		return situation;
	}

	/**
	 * Method setSituation.
	 * @param situation Situation
	 */
	public void setSituation(Situation situation) {
		this.situation = situation;
	}

	/**
	 * Method getItemStock.
	 * @return int[]
	 */
	public int[] getItemStock() {
		return itemStock;
	}

	/**
	 * Method getItemBuyPrices.
	 * @return int[]
	 */
	public int[] getItemBuyPrices() {
		return itemBuyPrices;
	}

	/**
	 * Method getItemSellPrices.
	 * @return int[]
	 */
	public int[] getItemSellPrices() {
		return itemSellPrices;
	}

	/**
	 * Method getId.
	 * @return Long
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Method setId.
	 * @param id Long
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Method getLastDock.
	 * @return Integer
	 */
	public Integer getLastDock() {
		return lastDock;
	}

	/**
	 * Method setLastDock.
	 * @param lastDock Integer
	 */
	public void setLastDock(Integer lastDock) {
		this.lastDock = lastDock;
	}

	/**
	 * Method arrayToString.
	 * @param array int[]
	 * @return String
	 */
	public String arrayToString(int[] array) {
		StringBuffer ret = new StringBuffer("[");
		for (int i : array) {
			ret.append(i + " ");
		}
		return ret.toString() + "]\n";
	}
	
	/**
	 * Method toString.
	 * @return String
	 */
	@Override
	public String toString() {
		return super.toString();
	}
}
