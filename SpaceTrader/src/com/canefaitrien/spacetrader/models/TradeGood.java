// $codepro.audit.disable largeNumberOfParameters
/**
 * TradeGoods to be bought and sold durring the game
 * 
 * @author apham9
 * @version 1.0
 */

package com.canefaitrien.spacetrader.models;

/**
 */
public enum TradeGood{
	
	/*
	 * Constructor format
	 * Name(minTechLevelProduce|minTechLevelUse|techLevelTopProduce
	 * |basePrice|increasePerTechLevel|Var|increaseEvent|decreaseEventCR|
	 * 	expensiveEvent|minTradePrice|maxTradePrice|name)
	 */
	/**
	 * Field WATER.
	 */
	WATER(0, 0, 2, 30, 3, 4, Situation.DROUGHT, Situation.LOTS_OF_WATER, 
			Situation.DESERT, 30, 50, "Water"),
			
	/**
	 * Field FUR.
	 */
	FUR(0, 0, 0, 250, 10, 10, Situation.COLD, Situation.RICH_FAUNA, 
			Situation.LIFELESS, 230, 280, "Fur"),
			
	/**
	 * Field FOOD.
	 */
	FOOD(1, 0, 1, 100, 5, 5, Situation.CROP_FAIL, Situation.RICH_SOIL, 
				Situation.POOR_SOIL, 90, 160, "Food"),
				
	/**
	 * Field ORE.
	 */
	ORE(2, 2, 3, 350, 20, 10, Situation.WAR, Situation.MINERAL_RICH,
				Situation.MINERAL_POOR, 350, 420, "Ore"),
				
	/**
	 * Field GAMES.
	 */
	GAMES(3, 1, 6, 250, -10, 5, Situation.BOREDOM, Situation.ARTISTIC, 
				Situation.NEVER, 160, 270, "Games"),
				
	/**
	 * Field FIREARMS.
	 */
	FIREARMS(3, 1, 5, 1250, -75, 100, Situation.WAR, Situation.WARLIKE,
				Situation.NEVER, 600, 1100, "Firearms"),
				
	/**
	 * Field MEDICINE.
	 */
	MEDICINE(4, 1, 6, 650, -20, 10, Situation.PLAGUE, Situation.LOTS_OF_HERBS,
				Situation.NEVER, 400, 700, "Medicine"),
				
	/**
	 * Field MACHINES.
	 */
	MACHINES(4, 3, 5, 900, -30, 5, Situation.LACK_OF_WORKERS, Situation.NEVER,
				Situation.NEVER, 600, 800, "Machines"),
				
	/**
	 * Field NARCOTICS.
	 */
	NARCOTICS(5, 0, 5, 3500, -125, 150, Situation.BOREDOM, Situation.WEIRD_MUSHROOMS,
				Situation.NEVER, 2000, 3000, "Narcotics"),
				
	/**
	 * Field ROBOTICS.
	 */
	ROBOTICS(6, 4, 7, 5000, -150, 100, Situation.LACK_OF_WORKERS, Situation.NEVER,
				Situation.NEVER, 3500, 5000, "Robots")
	
	;
	
	// TradeGood info
	/**
	 * Field minTLProduce.
	 */
	public final int minTLProduce;

	/**
	 * Field minTLUse.
	 */
	public final int minTLUse;

	/**
	 * Field tLTopProduce.
	 */
	public final int tLTopProduce;

	/**
	 * Field basePrice.
	 */
	public final int basePrice;

	/**
	 * Field increasePerTL.
	 */
	public final int increasePerTL;

	/**
	 * Field variance.
	 */
	public final int variance;

	/**
	 * Field increaseSituation.
	 */
	public final Situation increaseSituation;

	/**
	 * Field decreaseSituation.
	 */
	public final Situation decreaseSituation;

	/**
	 * Field expensiveSituation.
	 */
	public final Situation expensiveSituation;

	/**
	 * Field minTradePrice.
	 */
	public final int minTradePrice;

	/**
	 * Field maxTradePrice.
	 */
	public final int maxTradePrice;

	/**
	 * Field name.
	 */
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
	 * @param basePrice int
	 */
	
	public TradeGood(int minTechLevelProduce, int minTechLevelUse, 
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
	
	/**
	 * Method toString.
	 * @return String
	 */
	public String toString() {
		return name;
	}
}