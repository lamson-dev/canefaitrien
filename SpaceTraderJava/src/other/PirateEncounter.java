package other;
import java.util.Random;

import model.EncounterType;
import model.ShipType;
/**
 * Pirate Encounter Handler
 * @author: An Pham
 * @Date 07/11/12
 * @Version 1.0
 */
import controller.Controller;

public class PirateEncounter implements Encounter {

	private Controller data;
	private ShipType type = ShipType.getAShip();
	
	
	public PirateEncounter(Controller data){
		this.data = data;
	}
	
	public void takeGoods() {
		
		int[] cargo = data.getShip().getCargo();
		for (int i = 0; i < cargo.length; i++)
			cargo[i] = 0;
	}

	@Override
	public void encounter() {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * @Return true if get away
	 * false otherwise
	 */
	public boolean pirateFlee() {
		return ((data.getShip().getMaxSpeed() - type.getMaxSpeed()) > 0);
	}

}
