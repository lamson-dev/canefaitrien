/**
 * TradeGoods to be bought and sold durring the game
 * 
 * @author apham9
 * @version 1.0
 */

package com.canefaitrien.spacetrader.models;

public enum TradeGood{
	
	/*
	 * Constructor format
	 * Name(minTechLevelProduce|minTechLevelUse|techLevelTopProduce
	 * |basePrice|increasePerTechLevel|Var|increaseEvent|decreaseEventCR|
	 * 	expensiveEvent|minTradePrice|maxTradePrice|name)
	 */
	WATER(0, 0, 2, 30, 3, 4, Situation.DROUGHT, Situation.LOTS_OF_WATER, 
			Situation.DESERT, 30, 50, "Water"),
			
	FUR(0, 0, 0, 250, 10, 10, Situation.COLD, Situation.RICH_FAUNA, 
			Situation.LIFELESS, 230, 280, "Fur"),
			
	FOOD(1, 0, 1, 100, 5, 5, Situation.CROP_FAIL, Situation.RICH_SOIL, 
				Situation.POOR_SOIL, 90, 160, "Food"),
				
	ORE(2, 2, 3, 350, 20, 10, Situation.WAR, Situation.MINERAL_RICH,
				Situation.MINERAL_POOR, 350, 420, "Ore"),
				
	GAMES(3, 1, 6, 250, -10, 5, Situation.BOREDOM, Situation.ARTISTIC, 
				Situation.NEVER, 160, 270, "Games"),
				
	FIREARMS(3, 1, 5, 1250, -75, 100, Situation.WAR, Situation.WARLIKE,
				Situation.NEVER, 600, 1100, "Firearms"),
				
	MEDICINE(4, 1, 6, 650, -20, 10, Situation.PLAGUE, Situation.LOTS_OF_HERBS,
				Situation.NEVER, 400, 700, "Medicine"),
				
	MACHINES(4, 3, 5, 900, -30, 5, Situation.LACK_OF_WORKERS, Situation.NEVER,
				Situation.NEVER, 600, 800, "Machines"),
				
	NARCOTICS(5, 0, 5, 3500, -125, 150, Situation.BOREDOM, Situation.WEIRD_MUSHROOMS,
				Situation.NEVER, 2000, 3000, "Narcotics"),
				
	ROBOTICS(6, 4, 7, 5000, -150, 100, Situation.LACK_OF_WORKERS, Situation.NEVER,
				Situation.NEVER, 3500, 5000, "Robots")
	
	;
	
	// TradeGood info
	public final int minTLProduce;

	public final int minTLUse;

	public final int tLTopProduce;

	public final int basePrice;

	public final int increasePerTL;

	public final int variance;

	public final Situation increaseSituation;

	public final Situation decreaseSituation;

	public final Situation expensiveSituation;

	public final int minTradePrice;

	public final int maxTradePrice;

	public final String name;
	
	/**
	 * Constructor for TradeGood
	 * 
	 * @param minTechLevelProduce 
	 * @param minTechLevelUse 
     * @param techLevelTopProduce 
     * @param increasePerTechLevel 
     * @param variance 
     * @param increaseSituation 
     * @param decreaseSituation 
     * @param expensiveSituation 
     * @param minTradePrice 
     * @param maxTradePrice 
     * @param name name of goods
	 */
	
	private TradeGood(int minTechLevelProduce, int minTechLevelUse, 
			int techLevelTopProduce, int basePrice, 
			int increasePerTechLevel, int variance, 
			Situation increaseSituation, Situation decreaseSituation, 
			Situation expensiveSituation, int minTradePrice,
			int maxTradePrice, String name) {
		this.minTLProduce = minTechLevelProduce;
		this.minTLUse = minTechLevelUse;
		this.tLTopProduce = techLevelTopProduce;
		this.basePrice = basePrice;
		this.increasePerTL = increasePerTechLevel;
		this.variance = variance;
		this.increaseSituation = increaseSituation;
		this.decreaseSituation = decreaseSituation;
		this.expensiveSituation = expensiveSituation;
		this.minTradePrice = minTradePrice;
		this.maxTradePrice = maxTradePrice;
		this.name = name;
	}
	
	public String toString() {
		return name;
	}
}