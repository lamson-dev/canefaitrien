/**
 * Encounter Handler
 */

package com.canefaitrien.spacetrader.models;

/**
 *  * 
 * @author An Pham


 *
 * @version $Revision: 1.0 $
 */
public class EncounterHandler {
	/**
	 * Field data.
	 */
	private Controller data;

	/**
	 * Constructor for EncounterHandler.
	 * @param data Controller
	 */
	public EncounterHandler(Controller data) {
		this.data = data;
	}

	/**
	 * Method is called to bribe the police
	 * 
	 * @param amount
	
	 * @return true upon successful, false otherwise */
	public boolean canBribePolice(int amount) {
		PoliceEncounter police = new PoliceEncounter(data);
		return police.canBribePolice(amount);
	}

	/**
	 * This is a submission to police cargo check If there is no Firearm or
	 * narcotics nothing happen Otherwise, the play lose 20% of his money for
	 * the fine.\
	 * 
	
	 * @return true if okay false otherwise */
	public boolean canSubmitPolice() {
		PoliceEncounter police = new PoliceEncounter(data);
		int currentCredit = data.getMoney();
		if (currentCredit == police.checkGoods()) {
			return true;
		}

		return false;
	}

	/**
	 * Method canAttackPolice.
	 * @return boolean
	 */
	public boolean canAttackPolice() {
		PoliceEncounter police = new PoliceEncounter(data);
		return (police.canPoliceBattle());
	}

	/**
	 * Method canFleePolice.
	 * @return boolean
	 */
	public boolean canFleePolice() {
		PoliceEncounter police = new PoliceEncounter(data);
		return (police.canPoliceFlee());
	}

	/**
	 * Surrender to pirate All goods in the cargo will be taken
	 */
	public void canSurrenderToPirate() {
		PirateEncounter pirate = new PirateEncounter(data);
		pirate.takeGoods();
	}

	/**
	 * Try to flee from pirate
	 * 
	
	 * @return true if get away false otherwise */
	public boolean canFleePirate() {
		PirateEncounter pirate = new PirateEncounter(data);
		return (pirate.canPirateFlee());
	}

	/**
	 * Method canAttackPirate.
	 * @return boolean
	 */
	public boolean canAttackPirate() {
		PirateEncounter pirate = new PirateEncounter(data);
		return (pirate.canPirateFlee());
	}

	/**
	 * Method canAttackTrader.
	 * @return boolean
	 */
	public boolean canAttackTrader() {
		TraderEncounter trader = new TraderEncounter(data);
		return (trader.canTraderBattle());
	}

	/**
	 * Method toString.
	 * @return String
	 */
	@Override
	public String toString() {
		return super.toString();
	}
}