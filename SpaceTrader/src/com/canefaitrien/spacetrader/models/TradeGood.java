// $codepro.audit.disable largeNumberOfParameters, numericLiterals
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
	
	// TradeGood info
		/**
		 * Water Trade Good
		 */
		public static final int
		WATER_MIN_TECH_LEVEL_PRODUCE = 0, 
		WATER_MIN_TECH_LEVEL_USE = 0, 
		WATER_TOP_TECH_LEVEL_PRODUCE = 2, 
		WATER_BASE_PRICE = 30, 
		WATER_INCREASE_PER_TECH_LEVEL = 3, 
		WATER_VARIANCE = 4, 
		WATER_MIN_PRICE = 30, 
		WATER_MAX_PRICE = 50;
		
		public static final Situation
		WATER_PRICE_INCREASE_SITUATION = Situation.DROUGHT,
		WATER_PRICE_DECREASE_SITUATION = Situation.LOTS_OF_WATER,
		WATER_EXPENSIVE_SITUATION = Situation.DESERT;
		
		public static final String
		WATER_NAME = "Water"; 
		//WATER(0, 0, 2, 30, 3, 4, Situation.DROUGHT, Situation.LOTS_OF_WATER, 
		//Situation.DESERT, 30, 50, "Water")
		
		/**
		 * Fur Trade Good
		 */
		public static final int
		FUR_MIN_TECH_LEVEL_PRODUCE = 0, 
		FUR_MIN_TECH_LEVEL_USE = 0, 
		FUR_TOP_TECH_LEVEL_PRODUCE = 0, 
		FUR_BASE_PRICE = 250, 
		FUR_INCREASE_PER_TECH_LEVEL = 10, 
		FUR_VARIANCE = 10, 
		FUR_MIN_PRICE = 230, 
		FUR_MAX_PRICE = 280;
		
		public static final Situation
		FUR_PRICE_INCREASE_SITUATION = Situation.COLD,
		FUR_PRICE_DECREASE_SITUATION = Situation.RICH_FAUNA,
		FUR_EXPENSIVE_SITUATION = Situation.LIFELESS;
		
		public static final String
		FUR_NAME = "Fur"; 
		//FUR(0, 0, 0, 250, 10, 10, Situation.COLD, Situation.RICH_FAUNA, 
		// Situation.LIFELESS, 230, 280, "Fur"),
		
		/**
		 * Food Trade Good
		 */
		public static final int
		FOOD_MIN_TECH_LEVEL_PRODUCE = 1, 
		FOOD_MIN_TECH_LEVEL_USE = 0, 
		FOOD_TOP_TECH_LEVEL_PRODUCE = 1, 
		FOOD_BASE_PRICE = 100, 
		FOOD_INCREASE_PER_TECH_LEVEL = 5, 
		FOOD_VARIANCE = 5, 
		FOOD_MIN_PRICE = 90, 
		FOOD_MAX_PRICE = 160;
		
		public static final Situation
		FOOD_PRICE_INCREASE_SITUATION = Situation.CROP_FAIL,
		FOOD_PRICE_DECREASE_SITUATION = Situation.RICH_SOIL,
		FOOD_EXPENSIVE_SITUATION = Situation.POOR_SOIL;
		
		public static final String
		FOOD_NAME = "Food"; 
		//FOOD(1, 0, 1, 100, 5, 5, Situation.CROP_FAIL, Situation.RICH_SOIL, 
		//Situation.POOR_SOIL, 90, 160, "Food"),
		
		/**
		 * Ore Trade Good
		 */
		public static final int
		ORE_MIN_TECH_LEVEL_PRODUCE = 1, 
		ORE_MIN_TECH_LEVEL_USE = 0, 
		ORE_TOP_TECH_LEVEL_PRODUCE = 1, 
		ORE_BASE_PRICE = 100, 
		ORE_INCREASE_PER_TECH_LEVEL = 5, 
		ORE_VARIANCE = 5, 
		ORE_MIN_PRICE = 90, 
		ORE_MAX_PRICE = 160;
		
		public static final Situation
		ORE_PRICE_INCREASE_SITUATION = Situation.CROP_FAIL,
		ORE_PRICE_DECREASE_SITUATION = Situation.RICH_SOIL,
		ORE_EXPENSIVE_SITUATION = Situation.POOR_SOIL;
		
		public static final String
		ORE_NAME = "Ore"; 
		//ORE(2, 2, 3, 350, 20, 10, Situation.WAR, Situation.MINERAL_RICH,
		//Situation.MINERAL_POOR, 350, 420, "Ore"),
		
		/**
		 * Game Trade Good
		 */
		public static final int
		GAMES_MIN_TECH_LEVEL_PRODUCE = 3, 
		GAMES_MIN_TECH_LEVEL_USE = 1, 
		GAMES_TOP_TECH_LEVEL_PRODUCE = 6, 
		GAMES_BASE_PRICE = 250, 
		GAMES_INCREASE_PER_TECH_LEVEL = -10, 
		GAMES_VARIANCE = 5, 
		GAMES_MIN_PRICE = 160, 
		GAMES_MAX_PRICE = 270;
		
		public static final Situation
		GAMES_PRICE_INCREASE_SITUATION = Situation.BOREDOM,
		GAMES_PRICE_DECREASE_SITUATION = Situation.ARTISTIC,
		GAMES_EXPENSIVE_SITUATION = Situation.NEVER;
		
		public static final String
		GAMES_NAME = "Games"; 
		//GAMES(3, 1, 6, 250, -10, 5, Situation.BGAMESDOM, Situation.ARTISTIC, 
		// Situation.NEVER, 160, 270, "Games"),
		
		/**
		 * Fire Arms Trade Good
		 */
		public static final int
		FIREARMS_MIN_TECH_LEVEL_PRODUCE = 3, 
		FIREARMS_MIN_TECH_LEVEL_USE = 1, 
		FIREARMS_TOP_TECH_LEVEL_PRODUCE = 5, 
		FIREARMS_BASE_PRICE = 1250, 
		FIREARMS_INCREASE_PER_TECH_LEVEL = -75, 
		FIREARMS_VARIANCE = 100, 
		FIREARMS_MIN_PRICE = 600, 
		FIREARMS_MAX_PRICE = 1100;
		
		public static final Situation
		FIREARMS_PRICE_INCREASE_SITUATION = Situation.WAR,
		FIREARMS_PRICE_DECREASE_SITUATION = Situation.WARLIKE,
		FIREARMS_EXPENSIVE_SITUATION = Situation.NEVER;
		
		public static final String
		FIREARMS_NAME = "Fire Arms"; 
		//FIREARMS(3, 1, 5, 1250, -75, 100, Situation.WAR, Situation.WARLIKE,
		//Situation.NEVER, 600, 1100, "Firearms"),
		
		/**
		 * Medicine Trade Good
		 */
		public static final int
		MEDICINE_MIN_TECH_LEVEL_PRODUCE = 4, 
		MEDICINE_MIN_TECH_LEVEL_USE = 1, 
		MEDICINE_TOP_TECH_LEVEL_PRODUCE = 6, 
		MEDICINE_BASE_PRICE = 650, 
		MEDICINE_INCREASE_PER_TECH_LEVEL = -20, 
		MEDICINE_VARIANCE = 10, 
		MEDICINE_MIN_PRICE = 400, 
		MEDICINE_MAX_PRICE = 700;
		
		public static final Situation
		MEDICINE_PRICE_INCREASE_SITUATION = Situation.PLAGUE,
		MEDICINE_PRICE_DECREASE_SITUATION = Situation.LOTS_OF_HERBS,
		MEDICINE_EXPENSIVE_SITUATION = Situation.NEVER;
		
		public static final String
		MEDICINE_NAME = "Medicine"; 
		//MEDICINE(4, 1, 6, 650, -20, 10, Situation.PLAGUE, Situation.LOTS_OF_HERBS,
		//Situation.NEVER, 400, 700, "Medicine"),
		
		/**
		 * Machines Trade Good
		 */
		public static final int
		MACHINES_MIN_TECH_LEVEL_PRODUCE = 4, 
		MACHINES_MIN_TECH_LEVEL_USE = 3, 
		MACHINES_TOP_TECH_LEVEL_PRODUCE = 5, 
		MACHINES_BASE_PRICE = 900, 
		MACHINES_INCREASE_PER_TECH_LEVEL = -30, 
		MACHINES_VARIANCE = 5, 
		MACHINES_MIN_PRICE = 600, 
		MACHINES_MAX_PRICE = 800;
		
		public static final Situation
		MACHINES_PRICE_INCREASE_SITUATION = Situation.LACK_OF_WORKERS,
		MACHINES_PRICE_DECREASE_SITUATION = Situation.NEVER,
		MACHINES_EXPENSIVE_SITUATION = Situation.NEVER;
		
		public static final String
		MACHINES_NAME = "Machines"; 
		//MACHINES(4, 3, 5, 900, -30, 5, Situation.LACK_OF_WORKERS, Situation.NEVER,
		//Situation.NEVER, 600, 800, "Machines"),
		
		/**
		 * Narcotics Trade Good
		 */
		public static final int
		NARCOTICS_MIN_TECH_LEVEL_PRODUCE = 5, 
		NARCOTICS_MIN_TECH_LEVEL_USE = 0, 
		NARCOTICS_TOP_TECH_LEVEL_PRODUCE = 5, 
		NARCOTICS_BASE_PRICE = 3500,
		NARCOTICS_INCREASE_PER_TECH_LEVEL = -120, 
		NARCOTICS_VARIANCE = 150, 
		NARCOTICS_MIN_PRICE = 2000, 
		NARCOTICS_MAX_PRICE = 3000;
		
		public static final Situation
		NARCOTICS_PRICE_INCREASE_SITUATION = Situation.BOREDOM,
		NARCOTICS_PRICE_DECREASE_SITUATION = Situation.WEIRD_MUSHROOMS,
		NARCOTICS_EXPENSIVE_SITUATION = Situation.NEVER;
		
		public static final String
		NARCOTICS_NAME = "Narcotics"; 
		//NARCOTICS(5, 0, 5, 3500, -125, 150, Situation.BOREDOM, Situation.WEIRD_MUSHROOMS,
		//Situation.NEVER, 2000, 3000, "Narcotics"),
		
		/**
		 * Robotics Trade Good
		 */
		public static final int
		ROBOTICS_MIN_TECH_LEVEL_PRODUCE = 6, 
		ROBOTICS_MIN_TECH_LEVEL_USE = 4, 
		ROBOTICS_TOP_TECH_LEVEL_PRODUCE = 7, 
		ROBOTICS_BASE_PRICE = 5000,
		ROBOTICS_INCREASE_PER_TECH_LEVEL = -150, 
		ROBOTICS_VARIANCE = 100, 
		ROBOTICS_MIN_PRICE = 3500, 
		ROBOTICS_MAX_PRICE = 5000;
		
		public static final Situation
		ROBOTICS_PRICE_INCREASE_SITUATION = Situation.LACK_OF_WORKERS,
		ROBOTICS_PRICE_DECREASE_SITUATION = Situation.NEVER,
		ROBOTICS_EXPENSIVE_SITUATION = Situation.NEVER;
		
		public static final String
		ROBOTICS_NAME = "Robotics"; 
		//ROBOTICS(6, 4, 7, 5000, -150, 100, Situation.LACK_OF_WORKERS, Situation.NEVER,
		// Situation.NEVER, 3500, 5000, "Robots")
	
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