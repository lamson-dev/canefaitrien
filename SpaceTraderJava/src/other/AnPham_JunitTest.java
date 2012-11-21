package other;
import model.Person;
import model.TradeGood;

import org.junit.Assert;
import org.junit.Test;

import controller.Controller;
import controller.Controller.Difficulty;

/**
 * Junit Testing for PoliceEncounter.takeGoods
 * @author An Pham
 * @Date 11/14/12
 * @Version 1.0
 * 
 */
public class AnPham_JunitTest {

	// Setting up the necessary data
	Controller data;
	// Initialization
	private void settingUp() {
		data = new Controller(new Person("Apham9", 0, 0, 0, 0), Difficulty.Easy);
	}


	// Assuming the Ship.addGood is functioning correctly, check to see if PoliceEncounter.checkGoods actually take care of illegal goods
	// Illegal Goods are fire arm and narcotics
	// When there is presence of illegal good, they will be taken, and the play will be charge the fine up to 20% of their current money. 

	// This will test the presence of fire arm only
	@Test(timeout = 2000)
	public void checkFireArm() {
		settingUp();
		try {
			data.getShip().addGood(TradeGood.GAMES);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			data.getShip().addGood(TradeGood.FIREARMS);
		} catch (Exception e) {
			e.printStackTrace();
		}

		int[] current = new int[TradeGood.values().length];

		for (int i = 0; i < current.length; i++) 
			current[i] = 0;

		current[TradeGood.GAMES.ordinal()] = 1;
		current[TradeGood.FIREARMS.ordinal()] = 1;

		Assert.assertArrayEquals("Fail adding good item to their correct locations", current, data.getShip().getCargo());

		int moneyAfterFine = data.getMoney() * 8 / 10;
		PoliceEncounter police = new PoliceEncounter(data);
		police.checkGoods();

		Assert.assertEquals("Fail to charge the fine", moneyAfterFine, data.getMoney());

		current[TradeGood.FIREARMS.ordinal()] = 0;

		Assert.assertArrayEquals("Fail to take illegal goods away", current, data.getShip().getCargo());
	}


	// This will test the presence of fire arm only
	@Test(timeout = 2000)
	public void checkNarcotics() {
		settingUp();
		try {
			data.getShip().addGood(TradeGood.WATER);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			data.getShip().addGood(TradeGood.NARCOTICS);
		} catch (Exception e) {
			e.printStackTrace();
		}

		int[] current = new int[TradeGood.values().length];

		for (int i = 0; i < current.length; i++) 
			current[i] = 0;

		current[TradeGood.WATER.ordinal()] = 1;
		current[TradeGood.NARCOTICS.ordinal()] = 1;

		Assert.assertArrayEquals("Fail adding good item to their correct locations", current, data.getShip().getCargo());

		int moneyAfterFine = data.getMoney() * 8 / 10;
		PoliceEncounter police = new PoliceEncounter(data);
		police.checkGoods();

		Assert.assertEquals("Fail to charge the fine", moneyAfterFine, data.getMoney());

		current[TradeGood.NARCOTICS.ordinal()] = 0;

		Assert.assertArrayEquals("Fail to take illegal goods away", current, data.getShip().getCargo());
		Assert.assertEquals("Fail to retain other legal trade goods", 1, (data.getShip().getCargo())[TradeGood.WATER.ordinal()]);
	}

	// This will test the presence of fire arm only
	@Test(timeout = 2000)
	public void checkFireArmAndNarcotics() {
		settingUp();
		try {
			data.getShip().addGood(TradeGood.FUR);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			data.getShip().addGood(TradeGood.NARCOTICS);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			data.getShip().addGood(TradeGood.FIREARMS);
		} catch (Exception e) {
			e.printStackTrace();
		}

		int[] current = new int[TradeGood.values().length];

		for (int i = 0; i < current.length; i++) 
			current[i] = 0;

		current[TradeGood.NARCOTICS.ordinal()] = 1;
		current[TradeGood.FIREARMS.ordinal()] = 1;
		current[TradeGood.FUR.ordinal()] = 1;

		Assert.assertArrayEquals("Fail adding good item to their correct locations", current, data.getShip().getCargo());

		int moneyAfterFine = data.getMoney() * 8 / 10;
		PoliceEncounter police = new PoliceEncounter(data);
		police.checkGoods();

		Assert.assertEquals("Fail to charge the fine", moneyAfterFine, data.getMoney());

		current[TradeGood.FIREARMS.ordinal()] = 0;
		current[TradeGood.NARCOTICS.ordinal()] = 0;

		Assert.assertArrayEquals("Fail to take illegal goods away", current, data.getShip().getCargo());
		Assert.assertEquals("Fail to retain other legal trade goods", 1, (data.getShip().getCargo())[TradeGood.FUR.ordinal()]);
	}
	
	// This will test the none presence of illegal trade good only
	@Test(timeout = 2000)
	public void checkNoIllegalTradeGood() {
		settingUp();
		try {
			data.getShip().addGood(TradeGood.FUR);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			data.getShip().addGood(TradeGood.FOOD);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			data.getShip().addGood(TradeGood.MACHINES);
		} catch (Exception e) {
			e.printStackTrace();
		}

		int[] current = new int[TradeGood.values().length];

		for (int i = 0; i < current.length; i++) 
			current[i] = 0;

		current[TradeGood.FUR.ordinal()] = 1;
		current[TradeGood.FOOD.ordinal()] = 1;
		current[TradeGood.MACHINES.ordinal()] = 1;

		Assert.assertArrayEquals("Fail adding good item to their correct locations", current, data.getShip().getCargo());

		int moneyAfterFine = data.getMoney();
		PoliceEncounter police = new PoliceEncounter(data);
		police.checkGoods();

		Assert.assertEquals("Fail to keep the money intact", moneyAfterFine, data.getMoney());

		Assert.assertEquals("Fail to retain other legal trade goods", 1, (data.getShip().getCargo())[TradeGood.FOOD.ordinal()]);
		Assert.assertEquals("Fail to retain other legal trade goods", 1, (data.getShip().getCargo())[TradeGood.FUR.ordinal()]);
		Assert.assertEquals("Fail to retain other legal trade goods", 1, (data.getShip().getCargo())[TradeGood.MACHINES.ordinal()]);
	}

}