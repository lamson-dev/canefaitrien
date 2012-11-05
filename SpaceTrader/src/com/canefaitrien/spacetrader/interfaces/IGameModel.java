package com.canefaitrien.spacetrader.interfaces;

import com.canefaitrien.spacetrader.models.Controller.Difficulty;
import com.canefaitrien.spacetrader.models.Person;
import com.canefaitrien.spacetrader.models.Planet;
import com.canefaitrien.spacetrader.models.Ship;
import com.canefaitrien.spacetrader.models.TradeGood;
import com.canefaitrien.spacetrader.models.Universe;

public interface IGameModel {

	public void buyGood(TradeGood good) throws Exception;

	public void sellGood(TradeGood good) throws Exception;

	public void move(Planet destination) throws Exception;

	public Person getPlayer();

	public Ship getShip();

	public Planet getLocation();

	public Universe getUniverse();

	public int getMoney();

	public Difficulty getDifficulty();

	public int getTurn();
}
