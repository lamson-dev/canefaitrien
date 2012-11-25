// $codepro.audit.disable obsoleteModifierUsage
/**
 * interface for game model
 */
package com.canefaitrien.spacetrader.interfaces;

import com.canefaitrien.spacetrader.models.Person;
import com.canefaitrien.spacetrader.models.Planet;
import com.canefaitrien.spacetrader.models.Ship;
import com.canefaitrien.spacetrader.models.TradeGood;
import com.canefaitrien.spacetrader.models.Universe;
import com.canefaitrien.spacetrader.models.Controller.Difficulty;

/**
 * 
 * @author Son Nguyen
 *
 * @version $Revision: 1.0 $
 */
public interface IGameModel {

	/**
	 * Method buyGood.
	 * @param good TradeGood
	 * @throws Exception
	 */
	public void buyGood(TradeGood good) throws Exception;

	/**
	 * Method sellGood.
	 * @param good TradeGood
	 * @throws Exception
	 */
	public void sellGood(TradeGood good) throws Exception;

	/**
	 * Method move.
	 * @param destination Planet
	 * @throws Exception
	 */
	public void move(Planet destination) throws Exception;

	/**
	 * Method getPlayer.
	 * @return Person
	 */
	public Person getPlayer();

	/**
	 * Method getShip.
	 * @return Ship
	 */
	public Ship getShip();

	/**
	 * Method getLocation.
	 * @return Planet
	 */
	public Planet getLocation();

	/**
	 * Method getUniverse.
	 * @return Universe
	 */
	public Universe getUniverse();

	/**
	 * Method getMoney.
	 * @return int
	 */
	public int getMoney();

	/**
	 * Method getDifficulty.
	 * @return Difficulty
	 */
	public Difficulty getDifficulty();

	/**
	 * Method getTurn.
	 * @return int
	 */
	public int getTurn();
}
