/**
 * Encounter Handler
 * 
 * @author An Pham
 * @Date 11/05/12
 * @Version 1.0
 */

package com.canefaitrien.spacetrader.models;

public class EncounterHandler {
	private Controller data;

	public EncounterHandler(Controller data) {
		this.data = data;
	}

	/**
	 * Method is called to bribe the police
	 * 
	 * @param amount
	 * @return true upon successful, false otherwise
	 */
	public boolean canBribePolice(int amount) {
		PoliceEncounter police = new PoliceEncounter(data);
		return police.canBribePolice(amount);
	}

	/**
	 * This is a submission to police cargo check If there is no Firearm or
	 * narcotics nothing happen Otherwise, the play lose 20% of his money for
	 * the fine.\
	 * 
	 * @return true if okay false otherwise
	 */
	public boolean canSubmitPolice() {
		PoliceEncounter police = new PoliceEncounter(data);
		int currentCredit = data.getMoney();
		if (currentCredit == police.checkGoods()) {
			return true;
		}

		return false;
	}

	public boolean canAttackPolice() {
		PoliceEncounter police = new PoliceEncounter(data);
		return (police.canPoliceBattle());
	}

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
	 * @return true if get away false otherwise
	 */
	public boolean canFleePirate() {
		PirateEncounter pirate = new PirateEncounter(data);
		return (pirate.canPirateFlee());
	}

	public boolean canAttackPirate() {
		PirateEncounter pirate = new PirateEncounter(data);
		return (pirate.canPirateFlee());
	}

	public boolean canAttackTrader() {
		TraderEncounter trader = new TraderEncounter(data);
		return (trader.canTraderBattle());
	}
	
	@Override
	public String toString() {
		return super.toString();
	}
}