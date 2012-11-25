package com.canefaitrien.spacetrader.models;

/**
 * Encounter Type
 * @author An Pham
 * @Date 11/04/12
 * @version 1.0
 */
import java.util.Random;

public enum EncounterType {

	TRADER, POLICE, PIRATE, NOTHING;

	public static EncounterType getEncounterType() {
		if (new Random().nextDouble() > .65) {
			int pick = new Random().nextInt(EncounterType.values().length - 1);
			return EncounterType.values()[pick];
		} else {
			return EncounterType.NOTHING;
		}
	}
}