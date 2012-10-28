package com.canefaitrien.spacetrader.models;

/**
 * Create Trade Goods
 * @author apham9
 * @date 10/18/2012
 *
 */

public enum TradeGood{
	
	/*
	 * Constructor format
	 * Name(minTechLevelProduce|minTechLevelUse|techLevelTopProduce|basePrice|increasePerTechLevel|Var|increaseEvent|decreaseEventCR|
	 * 	expensiveEvent|minTradePrice|maxTradePrice|name)
	 */
	
	Water(0, 0, 2, 30, 3, 4, Situation.DROUGHT, Situation.LOTSOFWATER, 
			Situation.DESERT, 30, 50, "Water"),
			
	Furs(0, 0, 0, 250, 10, 10, Situation.COLD, Situation.RICHFAUNA, 
			Situation.LIFELESS, 230, 280, "Furs"),
			
	Food(1, 0, 1, 100, 5, 5, Situation.CROPFAIL, Situation.RICHSOIL, 
				Situation.POORSOIL, 90, 160, "Food"),
				
	Ore(2, 2, 3, 350, 20, 10, Situation.WAR, Situation.MINERALRICH,
				Situation.MINERALPOOR, 350, 420, "Ore"),
				
	Games(3, 1, 6, 250, -10, 5, Situation.BOREDOM, Situation.ARTISTIC, 
				Situation.NEVER, 160, 270, "Games"),
				
	Firearms(3, 1, 5, 1250, -75, 100, Situation.WAR, Situation.WARLIKE,
				Situation.NEVER, 600, 1100, "Firearms"),
				
	Medicines(4, 1, 6, 650, -20, 10, Situation.PLAGUE, Situation.LOTSOFHERBS,
				Situation.NEVER, 400, 700, "Medicines"),
				
	Machines(4, 3, 5, 900, -30, 5, Situation.LACKOFWORKERS, Situation.NEVER,
				Situation.NEVER, 600, 800, "Machines"),
				
	Narcotics(5, 0, 5, 3500, -125, 150, Situation.BOREDOM, Situation.WEIRDMUSHROOMS,
				Situation.NEVER, 2000, 3000, "Narcostics"),
				
	Robots(6, 4, 7, 5000, -150, 100, Situation.LACKOFWORKERS, Situation.NEVER,
				Situation.NEVER, 3500, 5000, "Robots")
	
	;
	
	//private instance variables
	public final int minTechLevelProduce;
	public final int minTechLevelUse;
	public final int techLevelTopProduce;
	public final int basePrice;
	public final int increasePerTechLevel;
	public final int variance;
	public final Situation increaseSituation;
	public final Situation decreaseSituation;
	public final Situation expensiveSituation;
	public final int minTradePrice;
	public final int maxTradePrice;
	public final String name;
	
	/**
	 * Constructor
	 *  minTechLevelProduce = Minimum Tech Level to Produce this resource (You can't buy on planets below this level)
	 *	minTechLevelUse = Minimum Tech Level to Use this resource (You can't sell on planets below this level)
     *	techLevelTopProduce = Tech Level which produces the most of this item
     *	increasePerTechLevel = Price increase per tech level
     *	Var = variance is the maximum percentage that the price can vary above or below the base
     *	Situation IE when this even happens on a planet, the price may increase astronomically
     * 	Situation CR = When this condition is present, the price of this resource is unusually low
     * 	Situation ER = When this condition is present, the resource is expensive
     *	minTradePrice = Min price offered in space trade with random trader (not on a planet)
     *	maxTradePrice = Max price offered in space trade with random trader (not on a planet)
     *	name of goods
	 */
	
	TradeGood(int minTechLevelProduce, int minTechLevelUse, int techLevelTopProduce, int basePrice, int increasePerTechLevel, int variance, 
			Situation increaseSituation, Situation decreaseSituation, Situation expensiveSituation, int minTradePrice, int maxTradePrice, String name) {
		this.minTechLevelProduce = minTechLevelProduce;
		this.minTechLevelUse = minTechLevelUse;
		this.techLevelTopProduce = techLevelTopProduce;
		this.basePrice = basePrice;
		this.increasePerTechLevel = increasePerTechLevel;
		this.variance = variance;
		this.increaseSituation = increaseSituation;
		this.decreaseSituation = decreaseSituation;
		this.expensiveSituation = expensiveSituation;
		this.minTradePrice = minTradePrice;
		this.maxTradePrice = maxTradePrice;
		this.name = name;
	}
}