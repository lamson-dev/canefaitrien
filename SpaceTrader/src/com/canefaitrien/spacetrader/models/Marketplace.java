package com.canefaitrien.spacetrader.models;

import java.util.Random;

/**
* Marketplace 
* An intermediate to generate the market on each planet
* In charge of keeping track of trade goods and perform sell/buy good
*/
public class Marketplace {
	
	
	private static final int STOCK_REFRESH_TIME = 5;			// Time to recreate market place, in turn
	private static final int MIN_NUM_GOODS = 5, VARIANCE = 5;
	private static TradeGood[] goods = TradeGood.values();		// Array of all trade goods
	private int turnCreated;
	private int[] itemStock;
	private int[] itemBuyPrices;
	private int[] itemSellPrices;
	private TechLevel level;
	private Situation situation;
	private static Random rand = new Random();
	
	public Marketplace(int turnCreated, int[] itemStock, int[] itemBuyPrices, int[] itemSellPrices, TechLevel level, Situation situation) {
		this.turnCreated = turnCreated;
		this.itemStock = itemStock;
		this.itemBuyPrices = itemBuyPrices;
		this.itemSellPrices = itemSellPrices;
		this.level = level;
		this.situation = situation;
	}
	
	public Marketplace(int turnCreated, TechLevel level, Situation situation) {
		this(turnCreated, new int[goods.length], new int[goods.length], new int[goods.length], level, situation);
		updateStock();
	}
	
	/**
	 * 
	 */
	public void visit(int turnVisited) {
		if(turnVisited - turnCreated > STOCK_REFRESH_TIME) {
			updateStock();
		}
	}
	
	public void updateStock() {
	
		for(TradeGood good : goods) {
			itemBuyPrices[good.ordinal()] = getBuyPrice(good);
			// situation modify
			itemSellPrices[good.ordinal()] = getSellPrice(good);
			
			if(itemBuyPrices[good.ordinal()] != 0) {
					itemStock[good.ordinal()] = rand.nextInt(VARIANCE) + MIN_NUM_GOODS;
			}
		}
		
	}
	
	private int getBuyPrice(TradeGood good) {
		return getPrice(good, good.MIN_TL_PRODUCE);
	}
	
	private int getSellPrice(TradeGood good) {
		return getPrice(good, good.MIN_TL_USE);
	}
	
	private int getPrice(TradeGood good, int minTL) {
		if (level.ordinal() >= minTL) {
			int temp = good.BASE_PRICE + good.INCREASE_PER_TL*(level.ordinal() - good.MIN_TL_PRODUCE); // price
			temp += rand.nextBoolean() ? rand.nextInt(good.VARIANCE): -rand.nextInt(good.VARIANCE); // price + variance
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
	
	public String toString() {
		return "Item Goods " + arrayToString(itemStock) + "Item Buy" + arrayToString(itemBuyPrices) + "Item Sell " + arrayToString(itemSellPrices);
	}
	
	public String arrayToString(int[] array) {
		String ret = "[";
		for(int i : array) {
			ret += i + " ";
		}
		return ret + "\b]\n";
	}
	/**
	 * Extra method for selling and buying trade good
	 * Added by apham9 on October 29th, 2012
	 * 
	 */
	public void buyGood(TradeGood good){
		if (itemStock[good.ordinal()] == 0) {
			// This is not in stock
			// Throw exceptions
		}
		else {
			itemStock[good.ordinal()]--;
		}
	}
	public void sellGood(TradeGood good){
			itemStock[good.ordinal()]++;
	}
}
