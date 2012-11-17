package other;
import model.Person;
import model.TradeGood;

import org.junit.Assert;
import org.junit.Test;

import controller.Controller;
import controller.Controller.Difficulty;

/**
 * Junit Testing for Ship.addGood and PirateEncounter.takeGoods to see if they are working correctly together
 * @author An Pham
 * @Date 11/14/12
 * @Version 1.0
 * 
 */
public class AnPham_JunitTest {

	// Setting up the necessary data
	Controller data;
	private void settingUp() {
		data = new Controller(new Person("Apham9", 0, 0, 0, 0), Difficulty.Easy);
	}
	
	
	// Check Ship.addGood functioning to make sure it works before checking PirateEncounter.takeGoods
	@Test(timeout = 2000)
	public void CheckAddGoodMethod() {
		settingUp();
		try {
			data.getShip().addGood(TradeGood.GAMES);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			data.getShip().addGood(TradeGood.FIREARMS);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		int[] current = new int[TradeGood.values().length];
		for (int i = 0; i < current.length; i++) 
			current[i] = 0;
		
		current[TradeGood.GAMES.ordinal()] = 1;
		current[TradeGood.FIREARMS.ordinal()] = 1;
		
		Assert.assertArrayEquals("Fail adding good item to their correct locations", current, data.getShip().getCargo());
		
		
	}
	
	
	// Assuming the Ship.addGood is functioning correctly, check to see if PirateEncounter.takeGoods actually take all goods in the cargo
	@Test(timeout = 2000)
	public void CheckPirateTakeGoodsMethod() {
		settingUp();
		try {
			data.getShip().addGood(TradeGood.GAMES);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			data.getShip().addGood(TradeGood.FIREARMS);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		int[] current = new int[TradeGood.values().length];
		for (int i = 0; i < current.length; i++) 
			current[i] = 0;
		
		PirateEncounter pirate = new PirateEncounter(data);
		pirate.takeGoods();
		
		Assert.assertArrayEquals("Fail to take all the goods from cargo hold", current, data.getShip().getCargo());
		
		
	}
	
}