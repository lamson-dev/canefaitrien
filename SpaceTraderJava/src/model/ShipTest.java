package model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ShipTest {
	Ship ship;
	@Before
	public void setup() {
		ship = new Ship(ShipType.MOSQUITO, 10, 10, new int[]{0, 1, 2, 3, 4, 0, 0, 0, 0, 0}, 10);
	}
	@Test
	public void testAddGood() {
		try{
			ship.addGood(TradeGood.FOOD);
			ship.addGood(TradeGood.NARCOTICS);
			ship.addGood(TradeGood.ROBOTICS);
			ship.addGood(TradeGood.FIREARMS);
			ship.addGood(TradeGood.GAMES);
		} catch(Exception e) {
			fail("Shouldn't fail");
		}
	}

	@Test
	public void testAddGoodLimit() {
		try{
			ship.addGood(TradeGood.FOOD);
			ship.addGood(TradeGood.NARCOTICS);
			ship.addGood(TradeGood.ROBOTICS);
			ship.addGood(TradeGood.FIREARMS);
			ship.addGood(TradeGood.GAMES);
			ship.addGood(TradeGood.FOOD);
			fail("Should have thrown an exception");
		} catch(Exception e) {
			
		}
	}

}
