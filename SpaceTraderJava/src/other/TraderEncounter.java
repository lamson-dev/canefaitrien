package other;
/**
 * @author An Pham
 * @Date 11/07/12
 * @Version 1.0
 */
import java.util.Random;

import model.Ship;
import model.ShipType;
import model.TechLevel;
import model.TradeGood;
import controller.Controller;

public class TraderEncounter implements Encounter {

	private Controller data;
	private ShipType type = ShipType.getAShip();
	private TradeGood[] goods = TradeGood.values();
	private final int MIN_NUM_GOODS = 5, VARIANCE = 5;
	private static Random rand = new Random();

	// Cargo hold info
	private int[] itemStock;
	private int[] itemBuyPrices;
	private int[] itemSellPrices;
	private TechLevel level;
	
	public TraderEncounter(Controller data) {
		this.data = data;
		for (TradeGood good : goods) {
			itemBuyPrices[good.ordinal()] = getBuyPrice(good);
			// situation modify
			itemSellPrices[good.ordinal()] = getSellPrice(good);

			if (itemBuyPrices[good.ordinal()] != 0) {
				itemStock[good.ordinal()] = rand.nextInt(VARIANCE)
						+ MIN_NUM_GOODS;
			}
		}
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
	private int getBuyPrice(TradeGood good) {
		return getPrice(good, good.MIN_TL_PRODUCE);
	}

	private int getSellPrice(TradeGood good) {
		return (int)(0.9*getPrice(good, good.MIN_TL_USE)); // makes sell values less than buy values
	}

	private int getPrice(TradeGood good, int minTL) {
		if (level.ordinal() >= minTL) {
			int temp = good.BASE_PRICE + good.INCREASE_PER_TL
					* (level.ordinal() - good.MIN_TL_PRODUCE); // price
			temp += rand.nextBoolean() ? rand.nextInt(good.VARIANCE) : -rand
					.nextInt(good.VARIANCE); // price + variance
			return temp;
		} else {
			return 0;
		}
	}
	public String[] getBuyView(Ship ship) {
		String[] ret = new String[itemStock.length];
		int[] cargo = ship.getCargo();
		for (int i = 0; i < itemStock.length; i++) {
			ret[i] = goods[i].toString() + ": Price " + itemBuyPrices[i]
					+ ", Available:" + itemStock[i] + ", In Cargo " + cargo[i];
		}
		return ret;
	}

	public String[] getSellView(Ship ship) {
		String[] ret = new String[itemStock.length];
		int[] cargo = ship.getCargo();
		for (int i = 0; i < itemStock.length; i++) {
			ret[i] = goods[i].toString() + ": Price " + itemSellPrices[i]
					+ ", Available:" + itemStock[i] + ", In Cargo " + cargo[i];
		}
		return ret;
	}
	
	public String[][] getView(Ship ship) {
		String[][] ret = new String[itemStock.length][5];
		int[] cargo = ship.getCargo();
		for(int i = 0; i < ret.length; i++) {
			ret[i][0] = goods[i].toString();
			ret[i][1] = itemBuyPrices[i] + "";
			ret[i][2] = itemSellPrices[i] + "";
			ret[i][3] = itemStock[i] + "";
			ret[i][4] = cargo[i] + "";
		}
		return ret;
	}
}
