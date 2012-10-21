package com.canefaitrien.spacetrader.models;
/**
 * Create Trade Goods
 * @author apham9
 * @date 10/18/2012
 *
 */
public enum TradeGoods{
	
	/**
	 * Constructor format
	 * Name|MTLP|MTLU|TTP|BasePrice|IPL|Var|IE|CR|ER|MTL|MTH|name
	 */
	
//	Water(0, 0, 2, 30, 3, 4, IncreaseEvent.DROUGHT, DecreaseEvent.LOTSOFWATER, 
//			ExpensiveEvent.DESERT, 30, 50, "Water"),
//	Furs(0, 0, 0, 250, 10, 10, IncreaseEvent.COLD, DecreaseEvent.RICHFAUNA, 
//			ExpensiveEvent.LIFELESS, 230, 280, "Furs"),
//	Food(1, 0, 1, 100, 5, 5, IncreaseEvent.CROPFAIL, DecreaseEvent.RICHSOIL, 
//				ExpensiveEvent.POORSOIL, 90, 160, "Food"),
//	Ore(2, 2, 3, 350, 20, 10, IncreaseEvent.WAR, DecreaseEvent.MINERALRICH,
//				ExpensiveEvent.MINERALPOOR, 350, 420, "Ore"),
//	Games(3, 1, 6, 250, -10, 5, IncreaseEvent.BOREDOM, DecreaseEvent.ARTISTIC, 
//				ExpensiveEvent.NEVER, 160, 270, "Games"),
//	Firearms(3, 1, 5, 1250, -75, 100, IncreaseEvent.WAR, DecreaseEvent.WARLIKE,
//				ExpensiveEvent.NEVER, 600, 1100, "Firearms"),
//	Medicines(4, 1, 6, 650, -20, 10, IncreaseEvent.PLAGUE, DecreaseEvent.LOTSOFHERBS,
//				ExpensiveEvent.NEVER, 400, 700, "Medicines"),
//	Machines(4, 3, 5, 900, -30, 5, IncreaseEvent.LACKOFWORKERS, DecreaseEvent.NEVER,
//				ExpensiveEvent.NEVER, 600, 800, "Machines"),
//	Narcotics(5, 0, 5, 3500, -125, 150, IncreaseEvent.BOREDOM, DecreaseEvent.WEIRDMUSHROOMS,
//				ExpensiveEvent.NEVER, 2000, 3000, "Narcostics"),
//	Robots(6, 4, 7, 5000, -150, 100, IncreaseEvent.LACKOFWORKERS, DecreaseEvent.NEVER,
//				ExpensiveEvent.NEVER, 3500, 5000, "Robots")
	
	Water(0, 0, 2, 30, 3, 4, 30, 50, "Water"),
	Furs(0, 0, 0, 250, 10, 10, 230, 280, "Furs"),
	Food(1, 0, 1, 100, 5, 5,  90, 160, "Food"),
	Ore(2, 2, 3, 350, 20, 10, 350, 420, "Ore"),
	Games(3, 1, 6, 250, -10, 5, 160, 270, "Games"),
	Firearms(3, 1, 5, 1250, -75, 100, 600, 1100, "Firearms"),
	Medicines(4, 1, 6, 650, -20, 10, 400, 700, "Medicines"),
	Machines(4, 3, 5, 900, -30, 5, 600, 800, "Machines"),
	Narcotics(5, 0, 5, 3500, -125, 150, 2000, 3000, "Narcostics"),
	Robots(6, 4, 7, 5000, -150, 100, 3500, 5000, "Robots")
	;
	
	//private instance variables
	private int MTLP;
	private int MTLU;
	private int TTP;
	private int basePrice;
	private int IPL;
	private int var;
//	private IncreaseEvent IE;
//	private DecreaseEvent CR;
//	private ExpensiveEvent ER;
	private int MTL;
	private int MTH;
	private String name;
	
	/**
	 * Constructor
	 *  MTLP = Minimum Tech Level to Produce this resource (You can't buy on planets below this level)
	 *	MTLU = Minimum Tech Level to Use this resource (You can't sell on planets below this level)
     *	TTP = Tech Level which produces the most of this item
     *	IPL = Price increase per tech level
     *	Var = variance is the maximum percentage that the price can vary above or below the base
     *	IncreaseEvent IE when this even happens on a planet, the price may increase astronomically
     * 	DecreaseEvent CR = When this condition is present, the price of this resource is unusually low
     * 	ExpensiveEvent ER = When this condition is present, the resource is expensive
     *	MTL = Min price offered in space trade with random trader (not on a planet)
     *	MTH = Max price offered in space trade with random trader (not on a planet)
     *	name of goods
	 */
	
	TradeGoods(int MTLP, int MTLU, int TTP, int basePrice, int IPL, int var, 
			int MTL, int MTH, String name) {//IncreaseEvent IE, DecreaseEvent CR, ExpensiveEvent ER, int MTL, int MTH, String name) {
		this.MTLP = MTLP;
		this.MTLU = MTLU;
		this.TTP = TTP;
		this.basePrice = basePrice;
		this.IPL = IPL;
		this.var = var;
//		this.IE = IE;
//		this.CR = CR;
//		this.ER = ER;
		this.MTL = MTL;
		this.MTH = MTH;
		this.name = name;
	}

	public int getMTLP() {
		return MTLP;
	}

	public int getMTLU() {
		return MTLU;
	}

	public int getTTP() {
		return TTP;
	}

	public int getBasePrice() {
		return basePrice;
	}

	public int getIPL() {
		return IPL;
	}

	public int getVar() {
		return var;
	}

//	public IncreaseEvent getIE() {
//		return IE;
//	}
//
//	public DecreaseEvent getCR() {
//		return CR;
//	}
//
//	public ExpensiveEvent getER() {
//		return ER;
//	}

	public int getMTL() {
		return MTL;
	}

	public int getMTH() {
		return MTH;
	}

	public String getName() {
		return name;
	}

}