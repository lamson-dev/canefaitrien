package model;
import java.util.Random;

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
	public void submitPolice() {
		
	}
	public void fleeFromPirate(){
		
	}
	
}