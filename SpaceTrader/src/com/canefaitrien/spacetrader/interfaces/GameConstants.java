package com.canefaitrien.spacetrader.interfaces;

public interface GameConstants {
	public final int MIN_DIFFICULTY_LEVEL = 0;
	public final int MAX_DIFFICULTY_LEVEL = 2;
	public final String LEVEL_EASY = "Easy";
	public final String LEVEL_HARD = "Hard";
	public final String LEVEL_MEDIUM = "Medium";

	public static final int NUM_MAX_SKILL_POINTS = 16;
	public static final int NUM_MAX_INITIAL_POINTS = 10;

	// Marketplace constants
	public static final int STOCK_REFRESH_TURNS = 5; // turns to recreate
														// marketplace
	public static final int MIN_NUM_GOODS = 5, VARIANCE = 5; // for inventory
																// creation
}
