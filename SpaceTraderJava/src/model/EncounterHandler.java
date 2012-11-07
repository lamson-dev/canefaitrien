package model;
import java.util.Random;

import other.PoliceEncounter;

/**
 * Encounter Handler
 * @author An Pham
 * @Date 11/05/12
 * @Version 1.0
 */
import controller.Controller;

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
		int currentMoney = data.getMoney();
		int bribeMoney = new Random().nextInt(currentMoney/10);
		if (amount < bribeMoney || amount > currentMoney) 
			return false;
		else
			data.setMoney(currentMoney - amount);
		return true;
	}
	
	public void attack(EncounterType type){
		switch (type) {
		case POLICE:
			break;
		case PIRATE:
			break;
		case TRADER:
			break;
		default:
			break;
		}
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
	public void fleeFromPirate(){
		
	}
	
}