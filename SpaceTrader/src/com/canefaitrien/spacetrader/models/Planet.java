// $codepro.audit.disable transientFieldInNonSerializable, largeNumberOfParameters
/**
 * Class Planet Information holder for planet
 */

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
 * @author AN PHAM
 * @version 10/11/2012
 * 
 */
public class Planet {

	// Instance variables
	/**
	 * Field id.
	 */
	private Long id;

	/**
	 * Field name.
	 */
	private String name;

	/**
	 * Field radius.
	 */
	private int radius;

	/**
	 * Field coordinates.
	 */
	private Point coordinates;

	/**
	 * Field level.
	 */
	private TechLevel level;

	/**
	 * Field situation.
	 */
	private Situation situation;

	/**
	 * Field color.
	 */
	private int color;

	/**
	 * Field type.
	 */
	private int type;

	/**
	 * Field dataId.
	 */
	private long dataId;

	/**
	 * Field marketId.
	 */
	private Long marketId;

	/**
	 * Field rand.
	 */
	private Random rand = new Random();

	/** Used to resolve relations */
	private transient DaoSession daoSession;

	/** Used for active entity operations. */
	private transient PlanetDao myDao;

	/**
	 * Field marketplace.
	 */
	private Marketplace marketplace;

	/**
	 * Field marketplace__resolvedKey.
	 */
	private Long marketplace__resolvedKey;

	/**
	 * Constructor for Planet
	 */
	public Planet() { // $codepro.audit.disable emptyMethod
	}

	/**
	 * Constructor for Planet
	 * 
	 * @param id
	 */
	public Planet(Long id) {
		this.id = id;
	}

	/**
	 * Constructor for Planet
	 * 
	 * @param id
	 * @param name
	 * @param radius
	 * @param xCoordinate
	 * @param yCoordinate
	 * @param techLevel
	 * @param situation
	 * @param type
	 * @param color
	 * @param dataId
	 * @param marketId
	 */
	public Planet(Long id, String name, Integer radius, Integer xCoordinate,
			Integer yCoordinate, String techLevel, String situation,
			Integer type, Integer color, Long dataId, Long marketId) {
		this.id = id;
		this.name = name;
		this.radius = radius;
		this.coordinates = new Point(xCoordinate, yCoordinate);
		this.level = TechLevel.fromString(techLevel);
		this.situation = Situation.fromString(situation);
		this.type = type;
		this.color = color;
		this.dataId = dataId;
		this.marketId = marketId;
	}

	/**
	 * Constructor for Planet
	 * 
	 * @param name
	 * @param location
	 * @param level
	 * @param situation
	 */
	public Planet(String name, Point location, TechLevel level,
			Situation situation) {
		this(name, location, level, situation, new Marketplace(0, level,
				situation));
	}

	/**
	 * Sets values to equal ones generated in the universe also random creates a
	 * size and planet image
	 * 
	 * @param name
	 *            of planet
	 * @param location
	 *            player's current location
	 * @param level
	 *            the techlevel of the planet
	 * @param situation
	 *            the planet's current situation
	 * @param marketplace
	 *            create a marketplace with good values
	 */
	public Planet(String name, Point location, TechLevel level,
			Situation situation, Marketplace marketplace) {
		// randomly generate a radius, occasionally making a giant planet.
		if (new Random().nextDouble() < .98) {
			this.radius = rand.nextInt(15) + 15;// for now each planet
												// will
		} else {
			this.radius = rand.nextInt(15) + 60;
		}
		this.name = name;
		this.coordinates = location;
		this.level = level;
		this.situation = situation;
		this.marketplace = marketplace;
		this.color = Color.argb(255, rand.nextInt(256), rand.nextInt(256),
				rand.nextInt(256));
		// randomly pick a planet image number
		this.type = rand.nextInt(10);
	}

	/**
	 * Distance between planets
	 * 
	 * @param planet
	 *            to compare
	
	 * @return distance */
	public int distance(Planet planet) {
		return distance(planet.getCoordinates());
	}

	/**
	 * Distance between the planet and another point (like a click)
	 * 
	 * @param other
	 *            Point to compare
	
	 * @return distance */
	public int distance(Point other) { // $codepro.audit.disable
										// overloadedMethods
		int dx, dy;
		dx = coordinates.x - other.x;
		dy = coordinates.y - other.y;
		Long l = Math.round(Math.sqrt(dx * dx + dy * dy));
		return l.intValue();
	}

	/**
	 * Dock method to be called upon traveling
	 * 
	 * @param turn
	 */
	public void dock(int turn) {
		marketplace.dock(turn);
	}

	/**
	 * Method to check if a Planet was clicked on the screen
	 * 
	 * @param point
	 *            click location
	
	 * @return was clicked */
	public boolean isClicked(Point point) {
		if (point.x > coordinates.x - radius
				&& point.x < coordinates.x + radius
				&& point.y > coordinates.y - radius
				&& point.y < coordinates.y + radius) {
			return true;
		}
		return false;
	}

	/**
	 * Method toString.
	
	 * @return String */
	public String toString() {
		return "Planet " + name + " TL " + level + " Sit " + situation
				+ " at X = " + coordinates.x + " Y = " + coordinates.y
				+ " of radius " + radius + "\n";
	}

	/**
	 * Method getId.
	
	 * @return Long */
	public Long getId() {
		return id;
	}

	/**
	 * Method setId.
	 * @param id Long
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Method getName.
	
	 * @return String */
	public String getName() {
		return name;
	}

	/**
	 * Method setName.
	 * @param name String
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Method getRadius.
	
	 * @return Integer */
	public Integer getRadius() {
		return radius;
	}

	/**
	 * Method setRadius.
	 * @param radius Integer
	 */
	public void setRadius(Integer radius) {
		this.radius = radius;
	}

	/**
	 * Method getCoordinates.
	
	 * @return Point */
	public Point getCoordinates() {
		return coordinates;
	}

	/**
	 * Method setCoordinates.
	 * @param location Point
	 */
	public void setCoordinates(Point location) {
		this.coordinates = location;
	}

	/**
	 * Method getXCoordinate.
	
	 * @return Integer */
	public Integer getXCoordinate() {
		return coordinates.x;
	}

	/**
	 * Method setXCoordinate.
	 * @param xCoordinate Integer
	 */
	public void setXCoordinate(Integer xCoordinate) {
		this.coordinates.x = xCoordinate;
	}

	/**
	 * Method getYCoordinate.
	
	 * @return Integer */
	public Integer getYCoordinate() {
		return coordinates.y;
	}

	/**
	 * Method setYCoordinate.
	 * @param yCoordinate Integer
	 */
	public void setYCoordinate(Integer yCoordinate) {
		this.coordinates.y = yCoordinate;
	}

	/**
	 * Method getSituation.
	
	 * @return Situation */
	public Situation getSituation() {
		return situation;
	}

	/**
	 * Method getStringSituation.
	
	 * @return String */
	public String getStringSituation() {
		return situation.name;
	}

	/**
	 * Method setSituation.
	 * @param situation Situation
	 */
	public void setSituation(Situation situation) {
		this.situation = situation;
	}

	public void setSituation(String situation) { // $codepro.audit.disable
													// overloadedMethods
		this.situation = Situation.fromString(situation);
	}

	/**
	 * Method setTechLevel.
	 * @param techLevel String
	 */
	public void setTechLevel(String techLevel) {
		this.level = TechLevel.fromString(techLevel);
	}

	public void setTechLevel(TechLevel level) { // $codepro.audit.disable
												// overloadedMethods
		this.level = level;
	}

	/**
	 * Method getTechLevel.
	
	 * @return TechLevel */
	public TechLevel getTechLevel() {
		return level;
	}

	/**
	 * Method getStringTechLevel.
	
	 * @return String */
	public String getStringTechLevel() {
		return level.name;
	}

	/**
	 * Method getType.
	
	 * @return Integer */
	public Integer getType() {
		return type;
	}

	/**
	 * Method setType.
	 * @param type Integer
	 */
	public void setType(Integer type) {
		this.type = type;
	}

	/**
	 * Method getColor.
	
	 * @return Integer */
	public Integer getColor() {
		return color;
	}

	/**
	 * Method setColor.
	 * @param color Integer
	 */
	public void setColor(Integer color) {
		this.color = color;
	}

	/**
	 * Method getDataId.
	
	 * @return Long */
	public Long getDataId() {
		return dataId;
	}

	/**
	 * Method setDataId.
	 * @param dataId Long
	 */
	public void setDataId(Long dataId) {
		this.dataId = dataId;
	}

	/**
	 * Method getMarketId.
	
	 * @return Long */
	public Long getMarketId() {
		return marketId;
	}

	/**
	 * Method setMarketId.
	 * @param marketId Long
	 */
	public void setMarketId(Long marketId) {
		this.marketId = marketId;
	}

	/** called by internal mechanisms, do not call yourself. * @param daoSession DaoSession
	 * @param daoSession DaoSession
	 */
	public void __setDaoSession(DaoSession daoSession) { // $codepro.audit.disable
															// methodNamingConvention
															// -->
		this.daoSession = daoSession;
		myDao = daoSession != null ? daoSession.getPlanetDao() : null;
	}

	/**
	 * Method getMarketplace1.
	
	 * @return Marketplace */
	public Marketplace getMarketplace1() {
		return marketplace;
	}

	/** To-one relationship, resolved on first access. 
	 * @return Marketplace
	 */
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

	/**
	 * Method setMarketplace.
	 * @param marketplace Marketplace
	 */
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
