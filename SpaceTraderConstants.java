/**
 * Interface that lists useful constants for the Space Trader game
 */

public interface SpaceTraderConstants {

	// SHIP
	public static final int SHIP_FLEA_PARSECS = 20;
	public static final int SHIP_FLEA_WEAPON_SLOTS = 0;
	public static final int SHIP_FLEA_SHIELD_SLOTS = 0;
	public static final int SHIP_FLEA_GADGET_SLOTS = 0;
	public static final int SHIP_FLEA_CARGO_HOLDS = 2;

	public static final int SHIP_GNAT_PARSECS = 14;
	public static final int SHIP_GNAT_WEAPON_SLOTS = 1;
	public static final int SHIP_GNAT_SHIELD_SLOTS = 0;
	public static final int SHIP_GNAT_GADGET_SLOTS = 1;
	public static final int SHIP_GNAT_CARGO_HOLDS = 15;

	public static final int SHIP_FIREFLY_PARSECS = 17;
	public static final int SHIP_FIREFLY_WEAPON_SLOTS = 1;
	public static final int SHIP_FIREFLY_SHIELD_SLOTS = 1;
	public static final int SHIP_FIREFLY_GADGET_SLOTS = 1;
	public static final int SHIP_FIREFLY_CARGO_HOLDS = 20;

	public static final int SHIP_MOSQUITO_PARSECS = 13;
	public static final int SHIP_MOSQUITO_WEAPON_SLOTS = 2;
	public static final int SHIP_MOSQUITO_SHIELD_SLOTS = 1;
	public static final int SHIP_MOSQUITO_GADGET_SLOTS = 1;
	public static final int SHIP_MOSQUITO_CARGO_HOLDS = 20;

	public static final int SHIP_BUMBLEBEE_PARSECS = 15;
	public static final int SHIP_BUMBLEBEE_WEAPON_SLOTS = 1;
	public static final int SHIP_BUMBLEBEE_SHIELD_SLOTS = 2;
	public static final int SHIP_BUMBLEBEE_GADGET_SLOTS = 2;
	public static final int SHIP_BUMBLEBEE_CARGO_HOLDS = 20;

	public static final int SHIP_BEETLE_PARSECS = 14;
	public static final int SHIP_BEETLE_WEAPON_SLOTS = 0;
	public static final int SHIP_BEETLE_SHIELD_SLOTS = 1;
	public static final int SHIP_BEETLE_GADGET_SLOTS = 1;
	public static final int SHIP_BEETLE_CARGO_HOLDS = 50;

	public static final int SHIP_HORNET_PARSECS = 16;
	public static final int SHIP_HORNET_WEAPON_SLOTS = 3;
	public static final int SHIP_HORNET_SHIELD_SLOTS = 2;
	public static final int SHIP_HORNET_GADGET_SLOTS = 1;
	public static final int SHIP_HORNET_CARGO_HOLDS = 20;

	public static final int SHIP_GRASSHOPPER_PARSECS = 15;
	public static final int SHIP_GRASSHOPPER_WEAPON_SLOTS = 2;
	public static final int SHIP_GRASSHOPPER_SHIELD_SLOTS = 2;
	public static final int SHIP_GRASSHOPPER_GADGET_SLOTS = 3;
	public static final int SHIP_GRASSHOPPER_CARGO_HOLDS = 30;

	public static final int SHIP_TERMITE_PARSECS = 13;
	public static final int SHIP_TERMITE_WEAPON_SLOTS = 1;
	public static final int SHIP_TERMITE_SHIELD_SLOTS = 3;
	public static final int SHIP_TERMITE_GADGET_SLOTS = 2;
	public static final int SHIP_TERMITE_CARGO_HOLDS = 60;

	public static final int SHIP_WASP_PARSECS = 14;
	public static final int SHIP_WASP_WEAPON_SLOTS = 3;
	public static final int SHIP_WASP_SHIELD_SLOTS = 2;
	public static final int SHIP_WASP_GADGET_SLOTS = 2;
	public static final int SHIP_WASP_CARGO_HOLDS = 35;


	// Possible directions for the motion of the caterpillar
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