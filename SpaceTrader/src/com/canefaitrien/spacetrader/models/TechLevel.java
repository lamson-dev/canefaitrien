package com.canefaitrien.spacetrader.models;

public enum TechLevel {
	// rarity ranges from 1-5, with 0 being not buy / sellable
	// Rarity: 					w, fu,fo,o, g, fi,me,ma,n, r
	PreAgricultural(new int[] {3, 3, 0, 0, 0, 0, 0, 0, 0, 0}, 
					new int[] {0, 0, 1, 0, 0, 0, 0, 0, 0, 0}),
					
	Agricultural(	new int[] {4, 4, 5, 0, 0, 0, 0, 0, 0, 0}, 
					new int[] {1, 1, 1, 0, 5, 2, 4, 0, 2, 0}),
					
	Medieval(		new int[] {3, 3, 3, 3, 0, 0, 0, 0, 0, 0}, 
					new int[] {3, 3, 3, 3, 3, 3, 3, 0, 3, 0}),
					
	Renaissance(	new int[] {1, 1, 1, 5, 5, 4, 0, 0, 0, 0}, 
					new int[] {2, 2, 2, 1, 1, 1, 2, 2, 2, 0}),
					
	EarlyIndustrial(new int[] {0, 0, 0, 0, 1, 1, 5, 3, 0, 0}, 
					new int[] {3, 3, 3, 3, 3, 3, 3, 5, 3, 0}),
					
	Industrial(		new int[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, 
					new int[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}),
					
	PostIndustrial(	new int[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, 
					new int[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}),
					
	HiTech(			new int[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, 
					new int[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0});
	
	private int[] goodAvailability;
	private int[] goodInterests;
	
	private TechLevel(int[] goodAvailability, int[] goodInterests) {
		this.goodAvailability = goodAvailability;
		this.goodInterests = goodInterests;
	}
	
	public int getGoodAvailability(TradeGoods good) {
		return goodAvailability[good.ordinal()];
	}
	
	public int getGoodInterests(TradeGoods good) {
		return goodInterests[good.ordinal()];
	}
}
