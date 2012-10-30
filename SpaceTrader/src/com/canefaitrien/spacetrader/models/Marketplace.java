package com.canefaitrien.spacetrader.models;

import java.util.Random;

import com.canefaitrien.spacetrader.exceptions.CargoHullFullException;
import com.canefaitrien.spacetrader.exceptions.NoTradeGoodException;
import com.canefaitrien.spacetrader.exceptions.NotEnoughMoneyException;

/**
* Marketplace 
* An intermediate to generate the market on each planet
* In charge of keeping track of trade goods and perform sell/buy good
*/
public class Marketplace {
	
	
	private static final int STOCK_REFRESH_TIME = 5;			// Time to recreate market place, in turn
	private static final int MIN_NUM_GOODS = 5, VARIANCE = 5;
	private static TradeGood[] goods = TradeGood.values();
	private int lastDock;
	private int[] itemStock;
	private int[] itemBuyPrices;
	private int[] itemSellPrices;
	private TechLevel level;
	private Situation situation;
	private GameData gd;
	private static Random rand = new Random();
	
	public Marketplace(int lastDock, int[] itemStock, int[] itemBuyPrices, int[] itemSellPrices, TechLevel level, Situation situation) {
		this.lastDock = lastDock;
		this.itemStock = itemStock;
		this.itemBuyPrices = itemBuyPrices;
		this.itemSellPrices = itemSellPrices;
		this.level = level;
		this.situation = situation;
	}
	
	public Marketplace(int lastDock, TechLevel level, Situation situation) {
		this(lastDock, new int[goods.length], new int[goods.length], new int[goods.length], level, situation);
		updateStock();
	}
	
	/**
	 * 
	 */
	public void dock(int turnDocked) {
		if(turnDocked - lastDock > STOCK_REFRESH_TIME) {
			updateStock();
			lastDock = turnDocked;
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
	
	public String[] getBuyView() {
		String[] ret = new String[itemStock.length];
		int[] cargo = gd.getShip().getCargo();
		for(int i = 0; i < itemStock.length; i++) {
			ret[i] = goods[i].toString() + ": Price " + itemBuyPrices[i] + ", Available:" + itemStock[i] + ", In Cargo " + cargo[i];
		}
		return ret;
	}
	
	public String[] getSellView() {
		String[] ret = new String[itemStock.length];
		int[] cargo = gd.getShip().getCargo();
		for(int i = 0; i < itemStock.length; i++) {
			ret[i] = goods[i].toString() + ": Price " + itemSellPrices[i] + ", Available:" + itemStock[i] + ", In Cargo " + cargo[i];
		}
		return ret;
	}
	
	public String arrayToString(int[] array) {
		String ret = "[";
		for(int i : array) {
			ret += i + " ";
		}
		return ret + "]\n";
	}
	/**
	 * Extra method for selling and buying trade good
	 * Added by apham9 on October 29th, 2012
	 * 
	 */
//	public void buyGood(TradeGood good){
//		if (itemStock[good.ordinal()] == 0) {
//			// This is not in stock
//			// Throw exceptions
//		}
//		else {
//			itemStock[good.ordinal()]--;
//		}
//	}
//	public void sellGood(TradeGood good){
//			itemStock[good.ordinal()]++;
//	}
	
	public void buyGood(TradeGood good) throws NotEnoughMoneyException, CargoHullFullException, NoTradeGoodException {
		if(itemBuyPrices[good.ordinal()] > gd.getMoney()) {
			throw new NotEnoughMoneyException("We don't have enough money, captain!");
		} else if(itemStock[good.ordinal()] == 0) {
			throw new NoTradeGoodException("They don't have that good, captain!", good);
		} else {
			gd.getShip().addGood(good);// throw cargo full exception
			itemStock[good.ordinal()]--;
			gd.setMoney(gd.getMoney() - itemBuyPrices[good.ordinal()]);
		}
	}
	
	/**
	 * Sell a good
	 */
	public void sellGood(TradeGood good) throws NoTradeGoodException {
		if(itemSellPrices[good.ordinal()] == 0) {
			throw new NoTradeGoodException("They don't need that good, captain!", good);
		} else {
			gd.getShip().removeGood(good);
			itemStock[good.ordinal()]++;
			gd.setMoney(gd.getMoney() + itemBuyPrices[good.ordinal()]); // if exception is thrown, this line shouldn't execute
		}
	}
}
