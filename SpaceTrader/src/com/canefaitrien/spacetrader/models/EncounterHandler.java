package com.canefaitrien.spacetrader.models;


/**
 * Encounter Handler
 * @author An Pham
 * @Date 11/05/12
 * @Version 1.0
 */


public class EncounterHandler {
	private Controller data;
	
	public EncounterHandler(Controller data) {
		this.data = data;
	}

	public void fleeFromPolice(){
		
	}
	
	/**
	 * Method is called to bribe the police
	 * @param amount
	 * @return true upon successful, false otherwise
	 */
	public boolean bribePolice(int amount) {
		PoliceEncounter police = new PoliceEncounter(data);
		return police.bribePolice(amount);
	}

	/**
	 * This is a submission to police cargo check
	 * If there is no Firearm or narcotics nothing happen
	 * Otherwise, the play lose 20% of his money for the fine.\
	 * @return true if okay
	 * 			false otherwise
	 */
	public boolean submitPolice() {
		PoliceEncounter police = new PoliceEncounter(data);
		int currentCredit = data.getMoney();
		if (currentCredit == police.checkGoods()) 
			return true;
		return false;
	}
	
	public boolean attackPolice() {
		PoliceEncounter police = new PoliceEncounter(data);
		return (police.policeBattle());
	}

	public boolean fleePolice() {
		PoliceEncounter police = new PoliceEncounter(data);
		return (police.policeFlee());
	}

	/**
	 * Surrender to pirate
	 * All goods in the cargo will be taken
	 */
	public void surrenderToPirate(){
		PirateEncounter pirate = new PirateEncounter(data);
		pirate.takeGoods();
	}

	/**
	 * Try to flee from pirate
	 * @return true if get away
	 * false otherwise
	 */
	public boolean fleePirate() {
		PirateEncounter pirate = new PirateEncounter(data);
		return (pirate.pirateFlee());
	}

	public boolean attackPirate() {
		PirateEncounter pirate = new PirateEncounter(data);
		return (pirate.pirateFlee());
	}

	public boolean attackTrader() {
		TraderEncounter trader = new TraderEncounter(data);
		return (trader.traderBattle());
	}
}