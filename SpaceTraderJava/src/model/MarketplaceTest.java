// $codepro.audit.disable logExceptions
package model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class MarketplaceTest {

	Marketplace mrktplc;
	Ship ship;
	int money;
	
	/**
	 * Creates a marketplace with 
	 */
	@Before
	public void setup() {
		mrktplc = new Marketplace(0, new int[]{5, 8, 6, 0, 0, 0, 0, 0, 0, 0}, new int[]{32, 257, 102, 0, 0, 0, 0, 0, 0, 0}, new int[]{29, 232, 92, 0, 243, 1204, 639, 0, 3555, 0}, TechLevel.AGRICULTURAL, Situation.ARTISTIC);
		ship = new Ship(ShipType.MOSQUITO, 10, 10, new int[]{0, 1, 2, 3, 4, 0, 0, 0, 0, 0}, 10);
		money = 500;
	}
	
	/**
	 * Tests buying in-stock goods with enough money, which should pass
	 */
	@Test
	public void testBuyGood() {
		try{
			money = mrktplc.buyGood(TradeGood.WATER, ship, money);
			assertTrue("bought 1 water", ship.getCargo()[0] == 1);
			money = mrktplc.buyGood(TradeGood.WATER, ship, money);
			assertTrue("bought 2 waters", ship.getCargo()[0] == 2);
			money = mrktplc.buyGood(TradeGood.WATER, ship, money);
			assertTrue("bought 3 waters", ship.getCargo()[0] == 3);
			money = mrktplc.buyGood(TradeGood.FUR, ship, money);
			assertTrue("bought 1 fur", ship.getCargo()[1] == 2);
			money = mrktplc.buyGood(TradeGood.FOOD, ship, money);
			assertTrue("bought 1 food", ship.getCargo()[2] == 3);
		} catch(Exception e) { // $codepro.audit.disable logExceptions
			fail("Shouldn't fail");
		}
	}
	
	/**
	 * Tests buying without enough money
	 */
	@Test
	public void testBuyGoodFundsCheck() {
		try{
			money = mrktplc.buyGood(TradeGood.FUR, ship, money);
			money = mrktplc.buyGood(TradeGood.FUR, ship, money);
			fail("Should have thrown an exception for trying to buy without enough money");
		} catch(Exception e) {
			assertTrue("Threw an exception like expected", true);
		}
	}
	
	/**
	 * Tests buying an item that is out of stock
	 */
	@Test
	public void testBuyGoodOutOfStock() {
		try{
			money = mrktplc.buyGood(TradeGood.GAMES, ship, money);
			fail("Should have thrown an exception for trying to buy a good that is not in the marketplace");
		} catch(Exception e) {
			assertTrue("Threw an exception like expected", true);
		}
	}
	
}