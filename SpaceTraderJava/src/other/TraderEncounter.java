package other;
/**
 * @author An Pham
 * @Date 11/07/12
 * @Version 1.0
 */
import model.ShipType;
import controller.Controller;

public class TraderEncounter implements Encounter {

	private Controller data;
	private ShipType type = ShipType.getAShip();
	
	public TraderEncounter(Controller data) {
		this.data = data;
	}
	
	public void trade() {
		
	}

	@Override
	public void encounter() {
		// TODO Auto-generated method stub
		
	}
	/**
	 * @Return true if survive
	 * false otherwise
	 */
	public boolean traderBattle() {
		return ((data.getShip().getHullStrength() - type.getMaxHullStrength()) > 0);
	}
}
