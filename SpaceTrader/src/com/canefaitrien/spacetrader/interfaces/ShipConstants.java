// $codepro.audit.disable obsoleteModifierUsage, fieldJavadoc, com.instantiations.assist.eclipse.analysis.audit.rule.effectivejava.useInterfacesOnlyToDefineTypes
/**
 * store ship constants
 */
package com.canefaitrien.spacetrader.interfaces;

/**
 * 
 * @author Son Nguyen
 * 
 * @version $Revision: 1.0 $
 */
public interface ShipConstants {

	// SHIP
	public static final int FLEA_PARSECS = 20;

	public static final int FLEA_WEAPON_SLOTS = 0;

	public static final int FLEA_SHIELD_SLOTS = 0;

	public static final int FLEA_GADGET_SLOTS = 0;

	public static final int FLEA_CARGO_CAP = 2;

	public static final int GNAT_PARSECS = 14;

	public static final int GNAT_WEAPON_SLOTS = 1;

	public static final int GNAT_SHIELD_SLOTS = 0;

	public static final int GNAT_GADGET_SLOTS = 1;

	public static final int GNAT_CARGO_CAP = 15;

	public static final int FIREFLY_PARSECS = 17;

	public static final int FIREFLY_WEAPON_SLOTS = 1;

	public static final int FIREFLY_SHIELD_SLOTS = 1;

	public static final int FIREFLY_GADGET_SLOTS = 1;

	public static final int FIREFLY_CARGO_CAP = 20;

	public static final int MOSQUITO_PARSECS = 13;

	public static final int MOSQUITO_WEAPON_SLOTS = 2;

	public static final int MOSQUITO_SHIELD_SLOTS = 1;

	public static final int MOSQUITO_GADGET_SLOTS = 1;

	public static final int MOSQUITO_CARGO_CAP = 20;

	public static final int BUMBLEBEE_PARSECS = 15;

	public static final int BUMBLEBEE_WEAPON_SLOTS = 1;

	public static final int BUMBLEBEE_SHIELD_SLOTS = 2;

	public static final int BUMBLEBEE_GADGET_SLOTS = 2;

	public static final int BUMBLEBEE_CARGO_CAP = 20;

	public static final int BEETLE_PARSECS = 14;

	public static final int BEETLE_WEAPON_SLOTS = 0;

	public static final int BEETLE_SHIELD_SLOTS = 1;

	public static final int BEETLE_GADGET_SLOTS = 1;

	public static final int BEETLE_CARGO_CAP = 50;

	public static final int HORNET_PARSECS = 16;

	public static final int HORNET_WEAPON_SLOTS = 3;

	public static final int HORNET_SHIELD_SLOTS = 2;

	public static final int HORNET_GADGET_SLOTS = 1;

	public static final int HORNET_CARGO_CAP = 20;

	public static final int GRASSHOPPER_PARSECS = 15;

	public static final int GRASSHOPPER_WEAPON_SLOTS = 2;

	public static final int GRASSHOPPER_SHIELD_SLOTS = 2;

	public static final int GRASSHOPPER_GADGET_SLOTS = 3;

	public static final int GRASSHOPPER_CARGO_CAP = 30;

	public static final int TERMITE_PARSECS = 13;

	public static final int TERMITE_WEAPON_SLOTS = 1;

	public static final int TERMITE_SHIELD_SLOTS = 3;

	public static final int TERMITE_GADGET_SLOTS = 2;

	public static final int TERMITE_CARGO_CAP = 60;

	public static final int WASP_PARSECS = 14;

	public static final int WASP_WEAPON_SLOTS = 3;

	public static final int WASP_SHIELD_SLOTS = 2;

	public static final int WASP_GADGET_SLOTS = 2;

	public static final int WASP_CARGO_CAP = 35;

	public static final int NORTH = 1;

	public static final int EAST = 2;

	public static final int WEST = 3;

	public static final int SOUTH = 4;

	// Distance covered by the caterpillar in one move
	public static final int STEP = 10;

	// Number of body elements added to the caterpillar when it grows
	// (after eating a good cabbage)
	public static final int GROWTH_SPURT = 5;

	// Thickness of the caterpillar
	public static final int CATERPILLAR_WIDTH = 6;

	// Number of good cabbages
	public static final int N_GOOD_CABBAGES = 10;

	public static final int N_SUPER_CABBAGES = 2;

	// Number of bad cabbages
	public static final int N_BAD_CABBAGES = 10;

	// Radius of a cabbage head
	public static final int CABBAGE_RADIUS = 10;

	// Size of the graphics window
	public static final int WINDOW_HEIGHT = 500;

	public static final int WINDOW_WIDTH = 500;

	// Period of the animation (in ms)
	public static final int ANIMATION_PERIOD = 60;
}