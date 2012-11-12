package com.canefaitrien.spacetrader.models;
/**
 * TradeGoods to be bought and sold durring the game
 * 
 * @author apham9
 * @version 1.0
 */

public enum TradeGood{
	
	/*
	 * Constructor format
	 * Name(minTechLevelProduce|minTechLevelUse|techLevelTopProduce|basePrice|increasePerTechLevel|Var|increaseEvent|decreaseEventCR|
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
	public final int MIN_TL_PRODUCE;
	public final int MIN_TL_USE;
	public final int TL_TOP_PRODUCE;
	public final int BASE_PRICE;
	public final int INCREASE_PER_TL;
	public final int VARIANCE;
	public final Situation INCREASE_SITUATION;
	public final Situation DECREASE_SITUATION;
	public final Situation EXPENSIVE_SITUATION;
	public final int MIN_TRADE_PRICE;
	public final int MAX_TRADE_PRICE;
	public final String NAME;
	
	/**
	 * Constructor for TradeGood
	 * 
	 * @param minTechLevelProduce Minimum Tech Level to Produce this resource (You can't buy on planets below this level)
	 * @param minTechLevelUse Minimum Tech Level to Use this resource (You can't sell on planets below this level)
     * @param techLevelTopProduce Tech Level which produces the most of this item
     * @param increasePerTechLevel Price increase per tech level
     * @param variance the maximum percentage that the price can vary above or below the base
     * @param increaseSituation when this even happens on a planet, the price may increase astronomically
     * @param decreaseSituation When this condition is present, the price of this resource is unusually low
     * @param expensiveSituation When this condition is present, the resource is expensive
     * @param minTradePrice Min price offered in space trade with random trader (not on a planet)
     * @param maxTradePrice Max price offered in space trade with random trader (not on a planet)
     * @param name name of goods
	 */
	
	private TradeGood(int minTechLevelProduce, int minTechLevelUse, int techLevelTopProduce, int basePrice, int increasePerTechLevel, int variance, 
			Situation increaseSituation, Situation decreaseSituation, Situation expensiveSituation, int minTradePrice, int maxTradePrice, String name) {
		MIN_TL_PRODUCE = minTechLevelProduce;
		MIN_TL_USE = minTechLevelUse;
		TL_TOP_PRODUCE = techLevelTopProduce;
		BASE_PRICE = basePrice;
		INCREASE_PER_TL = increasePerTechLevel;
		VARIANCE = variance;
		INCREASE_SITUATION = increaseSituation;
		DECREASE_SITUATION = decreaseSituation;
		EXPENSIVE_SITUATION = expensiveSituation;
		MIN_TRADE_PRICE = minTradePrice;
		MAX_TRADE_PRICE = maxTradePrice;
		NAME = name;
	}
	
	public String toString() {
		return NAME;
	}
}