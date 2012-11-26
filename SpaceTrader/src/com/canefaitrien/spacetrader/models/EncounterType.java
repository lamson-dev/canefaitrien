/**
 * Encounter Type
 * @author An Pham
 * @Date 11/04/12
 * @version 1.0
 */

package com.canefaitrien.spacetrader.models;

import java.util.Random;

/**
 */
public enum EncounterType {

	/**
	 * Field TRADER.
	 */
	TRADER, /**
	 * Field POLICE.
	 */
	POLICE, /**
	 * Field PIRATE.
	 */
	PIRATE, /**
	 * Field NOTHING.
	 */
	NOTHING;

	
	private static final double ENCOUNTER_RATE = .65;

	/**
	 * Method getEncounterType.
	 * 
	 * @return EncounterType
	 */
	public static EncounterType getEncounterType() {
		if (new Random().nextDouble() > ENCOUNTER_RATE) {
			final int pick = new Random()
					.nextInt(EncounterType.values().length - 1);
			return EncounterType.values()[pick];
		} else {
			return EncounterType.NOTHING;
		}
	}
}