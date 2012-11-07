package other;
/**
 * Handling PoliceEncounter
 * @author An Pham
 * @Data 11/ 07/ 12
 * @Version 1.0
 */
import controller.Controller;
import model.TradeGood;

public class PoliceEncounter implements Encounter {
	
	private TradeGood[] illegalTradeGood;
	private Controller data;
	
	public PoliceEncounter(Controller data) {
		illegalTradeGood =  new TradeGood[2];
		illegalTradeGood[0] = TradeGood.NARCOTICS;
		illegalTradeGood[1] = TradeGood.FIREARMS;
		this.data = data;
	}

	public void encounter() {
		
	}
	
	public int checkGoods() {
		int[] goods = data.getShip().getCargo();
		if (goods[TradeGood.NARCOTICS.ordinal()] == 0 && goods[TradeGood.FIREARMS.ordinal()] == 0) 
			return data.getMoney();
		else
			data.setMoney(data.getMoney() * 8 / 10);
		return data.getMoney();
	}
}
