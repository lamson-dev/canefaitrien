package com.canefaitrien.spacetrader.models;

import java.util.Random;

import android.graphics.Color;
import android.graphics.Point;

import com.canefaitrien.spacetrader.dao.DaoSession;
import com.canefaitrien.spacetrader.dao.MarketplaceDao;
import com.canefaitrien.spacetrader.dao.PlanetDao;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.DaoException;

/**
 * Class Planet Information holder for planet
 * 
 * @author AN PHAM
 * @version 10/11/2012
 */

// Planet data
public class Planet {

	// Instance variables
	private Long id;
	private String name;
	private int radius;
	private Point coordinates;
	private TechLevel level;
	private Situation situation;
	private int planetColor;
	private int imgType;

	private long dataId;
	private Long marketId;
	
	Random randomColor = new Random();

	/** Used to resolve relations */
	private transient DaoSession daoSession;

	/** Used for active entity operations. */
	private transient PlanetDao myDao;

	private Marketplace marketplace;
	private Long marketplace__resolvedKey;

	public Planet() {
	}

	public Planet(Long id) {
		this.id = id;
	}

	/**
	 * Constructor for loading Planet
	 */
	public Planet(Long id, String name, Integer radius, Integer xCoordinate,
			Integer yCoordinate, String techLevel, String situation,
			Integer xOffset, Integer yOffset, long dataId, Long marketId) {
		this.id = id;
		this.name = name;
		this.radius = radius;
		this.coordinates = new Point(xCoordinate, yCoordinate);
		this.level = TechLevel.fromString(techLevel);
		this.situation = Situation.fromString(situation);
		this.dataId = dataId;
		this.marketId = marketId;
		this.planetColor = Color.argb(255, randomColor.nextInt(256), randomColor.nextInt(256), randomColor.nextInt(256));
	}

	/**
	 * Constructor for a new Planet
	 */
	public Planet(String name, Point location, TechLevel level,
			Situation situation) {
		this(name, location, level, situation, new Marketplace(0, level,
				situation));
	}
	/**
	 * Sets values to equal ones generated in the universe
	 * also random creates a size and planet image
	 * 
	 * @param name  of planet
	 * @param location player's current location
	 * @param level the techlevel of the planet
	 * @param situation the planet's current situation
	 * @param marketplace create a marketplace with good values
	 */
	public Planet(String name, Point location, TechLevel level,
			Situation situation, Marketplace marketplace) {
		// randomly generate a radius, occasionally making a giant planet.
		if(new Random().nextDouble()<.98){
			this.radius = (int) (Math.random() * 15) + 15;// for now each planet will
		}else{
			this.radius = (int) (Math.random() * 15) + 60;;
		}
		this.name = name;
		this.coordinates = location;
		this.level = level;
		this.situation = situation;
		this.marketplace = marketplace;
		//randomly pick a planet image number
		int imageNumber = randomColor.nextInt(2);
		switch(imageNumber){
		case 0:
			imgType = 0; break;
		case 1:
			imgType = 1; break;
		}
		
		
	}

	/**
	 * Distance between planets
	 */
	public int distance(Planet planet) {
		return distance(planet.getCoordinates());
	}

	/**
	 * Distance between the planet and another point (like a click)
	 */
	public int distance(Point other) {
		int dx, dy;
		dx = coordinates.x - other.x;
		dy = coordinates.y - other.y;
		return (int) Math.sqrt(dx * dx + dy * dy);
	}

	public void dock(int turn) {
		marketplace.dock(turn);
	}

	// For testing purpose
	public String toString() {
		return "Planet " + name + " TL " + level + " Sit " + situation
				+ " at X = " + coordinates.x + " Y = " + coordinates.y
				+ " of radius " + radius + "\n";
	}

	public boolean isClicked(Point point) {
		// so it looks like android doesn't have that rectangle thing
		// This is assuming radius is the diameter. Correct this if I'm wrong
		if (point.x > coordinates.x - radius && point.x < coordinates.x + radius
				&& point.y > coordinates.y - radius && point.y < coordinates.y + radius) {
			return true;
		}
		return false;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getRadius() {
		return radius;
	}

	public void setRadius(Integer radius) {
		this.radius = radius;
	}

	public Point getCoordinates() {
		return coordinates;
	}

	public void setCoordinates(Point location) {
		this.coordinates = location;
	}

	public Integer getXCoordinate() {
		return coordinates.x;
	}

	public void setXCoordinate(Integer xCoordinate) {
		this.coordinates.x = xCoordinate;
	}

	public Integer getYCoordinate() {
		return coordinates.y;
	}

	public void setYCoordinate(Integer yCoordinate) {
		this.coordinates.y = yCoordinate;
	}

	public Situation getSituation() {
		return situation;
	}

	public String getStringSituation() {
		return situation.NAME;
	}
	
	public int getImageType(){
		return imgType;
	}

	public void setSituation(Situation situation) {
		this.situation = situation;
	}

	public void setSituation(String situation) {
		this.situation = Situation.fromString(situation);
	}

	public void setTechLevel(String techLevel) {
		this.level = TechLevel.fromString(techLevel);
	}

	public void setTechLevel(TechLevel level) {
		this.level = level;
	}

	public TechLevel getTechLevel() {
		return level;
	}

	public String getStringTechLevel() {
		return level.NAME;
	}

	public Long getDataId() {
		return dataId;
	}

	public void setDataId(Long dataId) {
		this.dataId = dataId;
	}

	public Long getMarketId() {
		return marketId;
	}
	public int getColor(){
		return planetColor;
	}

	public void setMarketId(Long marketId) {
		this.marketId = marketId;
	}

	/** called by internal mechanisms, do not call yourself. */
	public void __setDaoSession(DaoSession daoSession) {
		this.daoSession = daoSession;
		myDao = daoSession != null ? daoSession.getPlanetDao() : null;
	}

	public Marketplace getMarketplace1() {
		return marketplace;
	}

	/** To-one relationship, resolved on first access. */
	public Marketplace getMarketplace() {
		if (marketplace__resolvedKey == null
				|| !marketplace__resolvedKey.equals(marketId)) {
			if (daoSession == null) {
				throw new DaoException(
						"Marketplace is detached from DAO context");
			}
			MarketplaceDao targetDao = daoSession.getMarketplaceDao();
			marketplace = targetDao.load(marketId);
			marketplace__resolvedKey = marketId;
		}
		return marketplace;
	}

	public void setMarketplace(Marketplace marketplace) {
		this.marketplace = marketplace;
		marketId = marketplace == null ? null : marketplace.getId();
		marketplace__resolvedKey = marketId;
	}

	/**
	 * Convenient call for {@link AbstractDao#delete(Object)}. Entity must
	 * attached to an entity context.
	 */
	public void delete() {
		if (myDao == null) {
			throw new DaoException("Entity is detached from DAO context");
		}
		myDao.delete(this);
	}

	/**
	 * Convenient call for {@link AbstractDao#update(Object)}. Entity must
	 * attached to an entity context.
	 */
	public void update() {
		if (myDao == null) {
			throw new DaoException("Entity is detached from DAO context");
		}
		myDao.update(this);
	}

	/**
	 * Convenient call for {@link AbstractDao#refresh(Object)}. Entity must
	 * attached to an entity context.
	 */
	public void refresh() {
		if (myDao == null) {
			throw new DaoException("Entity is detached from DAO context");
		}
		myDao.refresh(this);
	}
}
