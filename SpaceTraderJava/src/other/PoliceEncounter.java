package other;
/**
 * Handling PoliceEncounter
 * @author An Pham
 * @Data 11/ 07/ 12
 * @Version 1.0
 */
import java.util.Random;

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
	
	/**
	 * Check for illegal goods
	 * @return money after fines
	 */
	public int checkGoods() {
		int[] goods = data.getShip().getCargo();
		if (goods[TradeGood.NARCOTICS.ordinal()] == 0 && goods[TradeGood.FIREARMS.ordinal()] == 0) 
			return data.getMoney();
		else
			data.setMoney(data.getMoney() * 8 / 10);
		return data.getMoney();
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
}
