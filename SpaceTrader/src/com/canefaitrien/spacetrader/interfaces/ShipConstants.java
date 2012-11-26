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

	public static final int FLEA_CARGO_CAP = 2;

	public static final int GNAT_PARSECS = 14;

	public static final int GNAT_CARGO_CAP = 15;

	public static final int FIREFLY_PARSECS = 17;

	public static final int FIREFLY_CARGO_CAP = 20;

	public static final int MOSQUITO_PARSECS = 13;

	public static final int MOSQUITO_CARGO_CAP = 20;

	public static final int BUMBLEBEE_PARSECS = 15;

	public static final int BUMBLEBEE_CARGO_CAP = 20;

	public static final int BEETLE_PARSECS = 14;

	public static final int BEETLE_CARGO_CAP = 50;

	public static final int HORNET_PARSECS = 16;

	public static final int HORNET_CARGO_CAP = 20;

	public static final int GRASSHOPPER_PARSECS = 15;

	public static final int GRASSHOPPER_CARGO_CAP = 30;

	public static final int TERMITE_PARSECS = 13;

	public static final int TERMITE_CARGO_CAP = 60;

	public static final int WASP_PARSECS = 14;

	public static final int WASP_CARGO_CAP = 35;

	/**
	 * Field GNAT_MERCENARY. (value is 0)
	 */
	/**
	 * Field GNAT_CREW. (value is 0)
	 */
	/**
	 * Field GNAT_CARGO_HOLD. (value is 15)
	 */
	/**
	 * Field GNAT_SHIELD_SLOTS. (value is 0)
	 */
	/**
	 * Field GNAT_GADGET_SLOTS. (value is 1)
	 */
	/**
	 * Field GNAT_WEAPON_SLOTS. (value is 1)
	 */
	/**
	 * Field GNAT_HULL_STRENGTH. (value is 100)
	 */
	/**
	 * Field GNAT_DISTANCE. (value is 14)
	 */
	;

	// Ship constants fill out and move to ShipConstants.java
	public static final int GNAT_DISTANCE = 14, GNAT_HULL_STRENGTH = 100,
			GNAT_WEAPON_SLOTS = 1, GNAT_GADGET_SLOTS = 1,
			GNAT_SHIELD_SLOTS = 0, GNAT_CARGO_HOLD = 15, GNAT_CREW = 0,
			GNAT_MERCENARY = 0;// 14, 100, 1, 1, 0, 15, 0, 0, "Gnat"),

	/**
	 * Field FLEA_MERCENARY. (value is 0)
	 */
	/**
	 * Field FLEA_CREW. (value is 0)
	 */
	/**
	 * Field FLEA_CARGO_HOLD. (value is 20)
	 */
	/**
	 * Field FLEA_SHIELD_SLOTS. (value is 1)
	 */
	/**
	 * Field FLEA_GADGET_SLOTS. (value is 1)
	 */
	/**
	 * Field FLEA_WEAPON_SLOTS. (value is 1)
	 */
	/**
	 * Field FLEA_HULL_STRENGTH. (value is 100)
	 */
	/**
	 * Field FLEA_DISTANCE. (value is 17)
	 */
	public static final int FLEA_DISTANCE = 17, FLEA_HULL_STRENGTH = 100,
			FLEA_WEAPON_SLOTS = 1, FLEA_GADGET_SLOTS = 1,
			FLEA_SHIELD_SLOTS = 1, FLEA_CARGO_HOLD = 20, FLEA_CREW = 0,
			FLEA_MERCENARY = 0;
	// 17, 100, 1, 1, 1, 20, 0, 0, "Flea"),

	/**
	 * Field FIREFLY_MERCENARY. (value is 0)
	 */
	/**
	 * Field FIREFLY_CREW. (value is 0)
	 */
	/**
	 * Field FIREFLY_CARGO_HOLD. (value is 20)
	 */
	/**
	 * Field FIREFLY_SHIELD_SLOTS. (value is 1)
	 */
	/**
	 * Field FIREFLY_GADGET_SLOTS. (value is 1)
	 */
	/**
	 * Field FIREFLY_WEAPON_SLOTS. (value is 1)
	 */
	/**
	 * Field FIREFLY_HULL_STRENGTH. (value is 200)
	 */
	/**
	 * Field FIREFLY_DISTANCE. (value is 17)
	 */
	public static final int FIREFLY_DISTANCE = 17, FIREFLY_HULL_STRENGTH = 200,
			FIREFLY_WEAPON_SLOTS = 1, FIREFLY_GADGET_SLOTS = 1,
			FIREFLY_SHIELD_SLOTS = 1, FIREFLY_CARGO_HOLD = 20,
			FIREFLY_CREW = 0, FIREFLY_MERCENARY = 0;// 17, 200, 1, 1, 1, 20, 0,
													// 0, "Firefly"),

	/**
	 * Field MOSQUITO_MERCENARY. (value is 0)
	 */
	/**
	 * Field MOSQUITO_CREW. (value is 0)
	 */
	/**
	 * Field MOSQUITO_CARGO_HOLD. (value is 15)
	 */
	/**
	 * Field MOSQUITO_SHIELD_SLOTS. (value is 1)
	 */
	/**
	 * Field MOSQUITO_GADGET_SLOTS. (value is 1)
	 */
	/**
	 * Field MOSQUITO_WEAPON_SLOTS. (value is 2)
	 */
	/**
	 * Field MOSQUITO_HULL_STRENGTH. (value is 300)
	 */
	/**
	 * Field MOSQUITO_DISTANCE. (value is 15)
	 */
	public static final int MOSQUITO_DISTANCE = 15,
			MOSQUITO_HULL_STRENGTH = 300, MOSQUITO_WEAPON_SLOTS = 2,
			MOSQUITO_GADGET_SLOTS = 1, MOSQUITO_SHIELD_SLOTS = 1,
			MOSQUITO_CARGO_HOLD = 15, MOSQUITO_CREW = 0,
			MOSQUITO_MERCENARY = 0;// 15, 300, 2, 1, 1, 15, 0, 0, "Mosquito"),

	/**
	 * Field BUMBLEBEE_MERCENARY. (value is 5)
	 */
	/**
	 * Field BUMBLEBEE_CREW. (value is 0)
	 */
	/**
	 * Field BUMBLEBEE_CARGO_HOLD. (value is 20)
	 */
	/**
	 * Field BUMBLEBEE_SHIELD_SLOTS. (value is 2)
	 */
	/**
	 * Field BUMBLEBEE_GADGET_SLOTS. (value is 2)
	 */
	/**
	 * Field BUMBLEBEE_WEAPON_SLOTS. (value is 0)
	 */
	/**
	 * Field BUMBLEBEE_HULL_STRENGTH. (value is 200)
	 */
	/**
	 * Field BUMBLEBEE_DISTANCE. (value is 15)
	 */
	public static final int BUMBLEBEE_DISTANCE = 15,
			BUMBLEBEE_HULL_STRENGTH = 200, BUMBLEBEE_WEAPON_SLOTS = 0,
			BUMBLEBEE_GADGET_SLOTS = 2, BUMBLEBEE_SHIELD_SLOTS = 2,
			BUMBLEBEE_CARGO_HOLD = 20, BUMBLEBEE_CREW = 0,
			BUMBLEBEE_MERCENARY = 5;// 15, 200, 0, 2, 2, 20, 0, 5, "Bumblebee"),

	/**
	 * Field BEETLE_MERCENARY. (value is 0)
	 */
	/**
	 * Field BEETLE_CREW. (value is 0)
	 */
	/**
	 * Field BEETLE_CARGO_HOLD. (value is 50)
	 */
	/**
	 * Field BEETLE_SHIELD_SLOTS. (value is 1)
	 */
	/**
	 * Field BEETLE_GADGET_SLOTS. (value is 1)
	 */
	/**
	 * Field BEETLE_WEAPON_SLOTS. (value is 0)
	 */
	/**
	 * Field BEETLE_HULL_STRENGTH. (value is 100)
	 */
	/**
	 * Field BEETLE_DISTANCE. (value is 14)
	 */
	public static final int BEETLE_DISTANCE = 14, BEETLE_HULL_STRENGTH = 100,
			BEETLE_WEAPON_SLOTS = 0, BEETLE_GADGET_SLOTS = 1,
			BEETLE_SHIELD_SLOTS = 1, BEETLE_CARGO_HOLD = 50, BEETLE_CREW = 0,
			BEETLE_MERCENARY = 0;// 14, 100, 0, 1, 1, 50, 0, 0, "Beetle"),

	/**
	 * Field HORNET_MERCENARY. (value is 0)
	 */
	/**
	 * Field HORNET_CREW. (value is 0)
	 */
	/**
	 * Field HORNET_CARGO_HOLD. (value is 20)
	 */
	/**
	 * Field HORNET_SHIELD_SLOTS. (value is 2)
	 */
	/**
	 * Field HORNET_GADGET_SLOTS. (value is 1)
	 */
	/**
	 * Field HORNET_WEAPON_SLOTS. (value is 3)
	 */
	/**
	 * Field HORNET_HULL_STRENGTH. (value is 300)
	 */
	/**
	 * Field HORNET_DISTANCE. (value is 16)
	 */
	public static final int HORNET_DISTANCE = 16, HORNET_HULL_STRENGTH = 300,
			HORNET_WEAPON_SLOTS = 3, HORNET_GADGET_SLOTS = 1,
			HORNET_SHIELD_SLOTS = 2, HORNET_CARGO_HOLD = 20, HORNET_CREW = 0,
			HORNET_MERCENARY = 0;// 16, 300, 3, 1, 2, 20, 0, 0, "Hornet"),

	/**
	 * Field GRASSHOPPER_MERCENARY. (value is 0)
	 */
	/**
	 * Field GRASSHOPPER_CREW. (value is 3)
	 */
	/**
	 * Field GRASSHOPPER_CARGO_HOLD. (value is 30)
	 */
	/**
	 * Field GRASSHOPPER_SHIELD_SLOTS. (value is 2)
	 */
	/**
	 * Field GRASSHOPPER_GADGET_SLOTS. (value is 3)
	 */
	/**
	 * Field GRASSHOPPER_WEAPON_SLOTS. (value is 2)
	 */
	/**
	 * Field GRASSHOPPER_HULL_STRENGTH. (value is 200)
	 */
	/**
	 * Field GRASSHOPPER_DISTANCE. (value is 15)
	 */
	public static final int GRASSHOPPER_DISTANCE = 15,
			GRASSHOPPER_HULL_STRENGTH = 200, GRASSHOPPER_WEAPON_SLOTS = 2,
			GRASSHOPPER_GADGET_SLOTS = 3, GRASSHOPPER_SHIELD_SLOTS = 2,
			GRASSHOPPER_CARGO_HOLD = 30, GRASSHOPPER_CREW = 3,
			GRASSHOPPER_MERCENARY = 0;// 15, 200, 2, 3, 2, 30, 3, 0,
										// "Grasshopper")

	/**
	 * Field TERMITE_MERCENARY. (value is 0)
	 */
	/**
	 * Field TERMITE_CREW. (value is 3)
	 */
	/**
	 * Field TERMITE_CARGO_HOLD. (value is 60)
	 */
	/**
	 * Field TERMITE_SHIELD_SLOTS. (value is 3)
	 */
	/**
	 * Field TERMITE_GADGET_SLOTS. (value is 2)
	 */
	/**
	 * Field TERMITE_WEAPON_SLOTS. (value is 1)
	 */
	/**
	 * Field TERMITE_HULL_STRENGTH. (value is 300)
	 */
	/**
	 * Field TERMITE_DISTANCE. (value is 13)
	 */
	public static final int TERMITE_DISTANCE = 13, TERMITE_HULL_STRENGTH = 300,
			TERMITE_WEAPON_SLOTS = 1, TERMITE_GADGET_SLOTS = 2,
			TERMITE_SHIELD_SLOTS = 3, TERMITE_CARGO_HOLD = 60,
			TERMITE_CREW = 3, TERMITE_MERCENARY = 0;// 13, 300, 1, 2, 3, 60, 3,
													// 0, "Termite"),

	/**
	 * Field WASP_MERCENARY. (value is 0)
	 */
	/**
	 * Field WASP_CREW. (value is 3)
	 */
	/**
	 * Field WASP_CARGO_HOLD. (value is 35)
	 */
	/**
	 * Field WASP_SHIELD_SLOTS. (value is 2)
	 */
	/**
	 * Field WASP_GADGET_SLOTS. (value is 2)
	 */
	/**
	 * Field WASP_WEAPON_SLOTS. (value is 3)
	 */
	/**
	 * Field WASP_HULL_STRENGTH. (value is 300)
	 */
	/**
	 * Field WASP_DISTANCE. (value is 14)
	 */
	public static final int WASP_DISTANCE = 14, WASP_HULL_STRENGTH = 300,
			WASP_WEAPON_SLOTS = 3, WASP_GADGET_SLOTS = 2,
			WASP_SHIELD_SLOTS = 2, WASP_CARGO_HOLD = 35, WASP_CREW = 3,
			WASP_MERCENARY = 0;// 14, 300, 3, 2, 2, 35, 3, 0, "Wasp")
}