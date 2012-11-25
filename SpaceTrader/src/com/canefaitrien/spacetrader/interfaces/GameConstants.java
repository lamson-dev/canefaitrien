// $codepro.audit.disable obsoleteModifierUsage, fieldJavadoc, com.instantiations.assist.eclipse.analysis.audit.rule.effectivejava.useInterfacesOnlyToDefineTypes
/**
 * store game constants
 */
package com.canefaitrien.spacetrader.interfaces;

/**
 * 
 * @author Son Nguyen
 * 
 * @version $Revision: 1.0 $
 */
public interface GameConstants {
	public static final int MIN_DIFFICULTY_LEVEL = 0;

	public static final int MAX_DIFFICULTY_LEVEL = 2;

	public static final String LEVEL_EASY = "Easy";

	public static final String LEVEL_HARD = "Hard";

	public static final String LEVEL_MEDIUM = "Medium";

	public static final int NUM_MAX_SKILL_POINTS = 16;

	public static final int NUM_MAX_INITIAL_POINTS = 10;

	// Marketplace constants
	public static final int STOCK_REFRESH_TURNS = 5; // turns to recreate

	public static final int MIN_NUM_GOODS = 5, VARIANCE = 5; // for inventory
	// creation
}
