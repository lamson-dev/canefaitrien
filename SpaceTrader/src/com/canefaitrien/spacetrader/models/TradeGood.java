// $codepro.audit.disable largeNumberOfParameters, numericLiterals
/**
 * TradeGoods to be bought and sold during the game
 * 
 * @author apham9
 * @version 1.0
 */

package com.canefaitrien.spacetrader.models;

/**
 */
public enum TradeGood implements TradeGoodConstants{
			
	/*
	 * Constructor format
	 * Name(minTechLevelProduce|minTechLevelUse|techLevelTopProduce
	 * |basePrice|increasePerTechLevel|Var|increaseEvent|decreaseEventCR|
	 * 	expensiveEvent|minTradePrice|maxTradePrice|name)
	 */
	/**
	 * Field WATER.
	 */
	WATER(WATER_MIN_TECH_LEVEL_PRODUCE, WATER_MIN_TECH_LEVEL_USE, WATER_TOP_TECH_LEVEL_PRODUCE, WATER_BASE_PRICE, 
			WATER_INCREASE_PER_TECH_LEVEL, WATER_VARIANCE, WATER_PRICE_INCREASE_SITUATION, WATER_PRICE_DECREASE_SITUATION, 
			WATER_EXPENSIVE_SITUATION, WATER_MIN_PRICE, WATER_MAX_PRICE, WATER_NAME),
			
	/**
	 * Field FUR.
	 */
	FUR(FUR_MIN_TECH_LEVEL_PRODUCE, FUR_MIN_TECH_LEVEL_USE, FUR_TOP_TECH_LEVEL_PRODUCE, FUR_BASE_PRICE, 
			FUR_INCREASE_PER_TECH_LEVEL, FUR_VARIANCE, FUR_PRICE_INCREASE_SITUATION, FUR_PRICE_DECREASE_SITUATION, 
			FUR_EXPENSIVE_SITUATION, FUR_MIN_PRICE, FUR_MAX_PRICE, FUR_NAME),
			
	/**
	 * Field FOOD.
	*/
	FOOD(FOOD_MIN_TECH_LEVEL_PRODUCE, FOOD_MIN_TECH_LEVEL_USE, FOOD_TOP_TECH_LEVEL_PRODUCE, FOOD_BASE_PRICE, 
			FOOD_INCREASE_PER_TECH_LEVEL, FOOD_VARIANCE, FOOD_PRICE_INCREASE_SITUATION, FOOD_PRICE_DECREASE_SITUATION, 
			FOOD_EXPENSIVE_SITUATION, FOOD_MIN_PRICE, FOOD_MAX_PRICE, FOOD_NAME),
				
	/**
	 * Field ORE.
	*/
	ORE(ORE_MIN_TECH_LEVEL_PRODUCE, ORE_MIN_TECH_LEVEL_USE, ORE_TOP_TECH_LEVEL_PRODUCE, ORE_BASE_PRICE, 
			ORE_INCREASE_PER_TECH_LEVEL, ORE_VARIANCE, ORE_PRICE_INCREASE_SITUATION, ORE_PRICE_DECREASE_SITUATION, 
			ORE_EXPENSIVE_SITUATION, ORE_MIN_PRICE, ORE_MAX_PRICE, ORE_NAME),
				
	/**
	 * Field GAMES.
	*/
	GAMES(GAMES_MIN_TECH_LEVEL_PRODUCE, GAMES_MIN_TECH_LEVEL_USE, GAMES_TOP_TECH_LEVEL_PRODUCE, GAMES_BASE_PRICE, 
			GAMES_INCREASE_PER_TECH_LEVEL, GAMES_VARIANCE, GAMES_PRICE_INCREASE_SITUATION, GAMES_PRICE_DECREASE_SITUATION, 
			GAMES_EXPENSIVE_SITUATION, GAMES_MIN_PRICE, GAMES_MAX_PRICE, GAMES_NAME),
				
	/**
	 * Field FIREARMS.
	*/
	FIREARMS(FIREARMS_MIN_TECH_LEVEL_PRODUCE, FIREARMS_MIN_TECH_LEVEL_USE, FIREARMS_TOP_TECH_LEVEL_PRODUCE, FIREARMS_BASE_PRICE, 
			FIREARMS_INCREASE_PER_TECH_LEVEL, FIREARMS_VARIANCE, FIREARMS_PRICE_INCREASE_SITUATION, FIREARMS_PRICE_DECREASE_SITUATION, 
			FIREARMS_EXPENSIVE_SITUATION, FIREARMS_MIN_PRICE, FIREARMS_MAX_PRICE, FIREARMS_NAME),
				
	/**
	 * Field MEDICINE.
	*/
	MEDICINE(MEDICINE_MIN_TECH_LEVEL_PRODUCE, MEDICINE_MIN_TECH_LEVEL_USE, MEDICINE_TOP_TECH_LEVEL_PRODUCE, MEDICINE_BASE_PRICE, 
			MEDICINE_INCREASE_PER_TECH_LEVEL, MEDICINE_VARIANCE, MEDICINE_PRICE_INCREASE_SITUATION, MEDICINE_PRICE_DECREASE_SITUATION, 
			MEDICINE_EXPENSIVE_SITUATION, MEDICINE_MIN_PRICE, MEDICINE_MAX_PRICE, MEDICINE_NAME),
				
	/**
	 * Field MACHINES.
	*/
	MACHINES(MACHINES_MIN_TECH_LEVEL_PRODUCE, MACHINES_MIN_TECH_LEVEL_USE, MACHINES_TOP_TECH_LEVEL_PRODUCE, MACHINES_BASE_PRICE, 
			MACHINES_INCREASE_PER_TECH_LEVEL, MACHINES_VARIANCE, MACHINES_PRICE_INCREASE_SITUATION, MACHINES_PRICE_DECREASE_SITUATION, 
			MACHINES_EXPENSIVE_SITUATION, MACHINES_MIN_PRICE, MACHINES_MAX_PRICE, MACHINES_NAME),
				
	/**
	 * Field NARCOTICS.
	*/
	NARCOTICS(NARCOTICS_MIN_TECH_LEVEL_PRODUCE, NARCOTICS_MIN_TECH_LEVEL_USE, NARCOTICS_TOP_TECH_LEVEL_PRODUCE, NARCOTICS_BASE_PRICE, 
			NARCOTICS_INCREASE_PER_TECH_LEVEL, NARCOTICS_VARIANCE, NARCOTICS_PRICE_INCREASE_SITUATION, NARCOTICS_PRICE_DECREASE_SITUATION, 
			NARCOTICS_EXPENSIVE_SITUATION, NARCOTICS_MIN_PRICE, NARCOTICS_MAX_PRICE, NARCOTICS_NAME),
				
	/**
	 * Field ROBOTICS.
	*/
	ROBOTICS(ROBOTICS_MIN_TECH_LEVEL_PRODUCE, ROBOTICS_MIN_TECH_LEVEL_USE, ROBOTICS_TOP_TECH_LEVEL_PRODUCE, ROBOTICS_BASE_PRICE, 
			ROBOTICS_INCREASE_PER_TECH_LEVEL, ROBOTICS_VARIANCE, ROBOTICS_PRICE_INCREASE_SITUATION, ROBOTICS_PRICE_DECREASE_SITUATION, 
			ROBOTICS_EXPENSIVE_SITUATION, ROBOTICS_MIN_PRICE, ROBOTICS_MAX_PRICE, ROBOTICS_NAME);
	
	
	
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