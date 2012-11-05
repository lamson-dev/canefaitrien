package model;
/**
 * Encounter Type
 * @author An Pham
 * @Date 11/04/12
 * @version 1.0
 */
import java.util.Random;

public enum EncounterType {
	
	TRADER,
	POLICE,
	PIRATE,
	NOTHING;
	
	EncounterType(){}
	
	public static EncounterType getEncounterType() {
		int pick = new Random().nextInt(EncounterType.values().length);
	    return EncounterType.values()[pick];
	}
}