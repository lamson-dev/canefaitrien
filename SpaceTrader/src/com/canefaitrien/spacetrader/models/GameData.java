// $codepro.audit.disable transientFieldInNonSerializable
/**
 * Entity mapped to table GAME_DATA.
 */

package com.canefaitrien.spacetrader.models;

import java.util.List;

import android.util.Log;

import com.canefaitrien.spacetrader.dao.DaoSession;
import com.canefaitrien.spacetrader.dao.GameDataDao;
import com.canefaitrien.spacetrader.dao.PersonDao;
import com.canefaitrien.spacetrader.dao.PlanetDao;
import com.canefaitrien.spacetrader.dao.ShipDao;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.DaoException;

/**
 * 
 * @author Son Nguyen
 *
 * @version $Revision: 1.0 $
 */
public class GameData {

	/**
	 * Field TAG.
	 * (value is ""GameData"")
	 */
	private static final String TAG = "GameData";

	/**
	 * Field id.
	 */
	private Long id;

	/**
	 * Field name.
	 */
	private String name;

	/**
	 * Field difficulty.
	 */
	private String difficulty;

	/**
	 * Field money.
	 */
	private Integer money;

	/**
	 * Field currentPlanet.
	 */
	private String currentPlanet;

	/**
	 * Field turn.
	 */
	private Integer turn;

	/**
	 * Field date.
	 */
	private java.util.Date date;

	/**
	 * Field personId.
	 */
	private Long personId;

	/**
	 * Field shipId.
	 */
	private Long shipId;

	/** Used to resolve relations */
	private transient DaoSession daoSession;

	/** Used for active entity operations. */
	private transient GameDataDao myDao;

	/**
	 * Field person.
	 */
	private Person person;

	/**
	 * Field person__resolvedKey.
	 */
	private Long person__resolvedKey;

	/**
	 * Field ship.
	 */
	private Ship ship;

	/**
	 * Field ship__resolvedKey.
	 */
	private Long ship__resolvedKey;

	/**
	 * Field planets.
	 */
	private List<Planet> planets;

	/**
	 * Constructor for GameData.
	 */
	public GameData() { // $codepro.audit.disable emptyMethod
	}

	/**
	 * Constructor for GameData.
	 * @param id Long
	 */
	public GameData(Long id) {
		this.id = id;
	}

	/**
	 * Constructor for GameData.
	 * @param id Long
	 * @param name String
	 * @param difficulty String
	 * @param money Integer
	 * @param currentPlanet String
	 * @param turn Integer
	 * @param date java.util.Date
	 * @param personId Long
	 * @param shipId Long
	 */
	public GameData(Long id, String name, String difficulty, Integer money,
			String currentPlanet, Integer turn, java.util.Date date,
			Long personId, Long shipId) {
		this.id = id;
		this.name = name;
		this.difficulty = difficulty;
		this.money = money;
		this.currentPlanet = currentPlanet;
		this.turn = turn;
		this.date = date;
		this.personId = personId;
		this.shipId = shipId;
	}

	/** called by internal mechanisms, do not call yourself. 
	 * @param daoSession DaoSession
	 */
	public void __setDaoSession(DaoSession daoSession) { // $codepro.audit.disable methodNamingConvention -->
		this.daoSession = daoSession;
		myDao = daoSession != null ? daoSession.getGameDataDao() : null;
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
	 * Method getDifficulty.
	
	 * @return String */
	public String getDifficulty() {
		return difficulty;
	}

	/**
	 * Method setDifficulty.
	 * @param difficulty String
	 */
	public void setDifficulty(String difficulty) {
		this.difficulty = difficulty;
	}

	/**
	 * Method getMoney.
	
	 * @return Integer */
	public Integer getMoney() {
		return money;
	}

	/**
	 * Method setMoney.
	 * @param money Integer
	 */
	public void setMoney(Integer money) {
		this.money = money;
	}

	/**
	 * Method getStringCurrentPlanet.
	
	 * @return String */
	public String getStringCurrentPlanet() {
		return currentPlanet;
	}

	/**
	 * Method getCurrentPlanetIndex.
	
	 * @return int */
	public int getCurrentPlanetIndex() {
		for (Planet p : this.getPlanets()) {
			Log.d(TAG, p.getName());
			if (p.getName().equals(currentPlanet)) {
				return this.getPlanets().indexOf(p);
			}
		}
		return -1;
	}

	/**
	 * Method getCurrentPlanet.
	
	 * @return Planet */
	public Planet getCurrentPlanet() {
		return this.getPlanets().get(getCurrentPlanetIndex());
	}

	/**
	 * Method setCurrentPlanet.
	 * @param currentPlanet String
	 */
	public void setCurrentPlanet(String currentPlanet) {
		this.currentPlanet = currentPlanet;
	}

	public void setCurrentPlanet(Planet location) { // $codepro.audit.disable
													// overloadedMethods
		this.currentPlanet = location.getName();
	}

	/**
	 * Method getTurn.
	
	 * @return Integer */
	public Integer getTurn() {
		return turn;
	}

	/**
	 * Method setTurn.
	 * @param turn Integer
	 */
	public void setTurn(Integer turn) {
		this.turn = turn;
	}

	/**
	 * Method getDate.
	
	 * @return java.util.Date */
	public java.util.Date getDate() {
		return date;
	}

	/**
	 * Method setDate.
	 * @param date java.util.Date
	 */
	public void setDate(java.util.Date date) {
		this.date = date;
	}

	/**
	 * Method getPersonId.
	
	 * @return Long */
	public Long getPersonId() {
		return personId;
	}

	/**
	 * Method setPersonId.
	 * @param personId Long
	 */
	public void setPersonId(Long personId) {
		this.personId = personId;
	}

	/**
	 * Method getShipId.
	
	 * @return Long */
	public Long getShipId() {
		return shipId;
	}

	/**
	 * Method setShipId.
	 * @param shipId Long
	 */
	public void setShipId(Long shipId) {
		this.shipId = shipId;
	}

	/** To-one relationship, resolved on first access. 
	 * @return Person
	 */
	public Person getPerson() {
		if (person__resolvedKey == null
				|| !person__resolvedKey.equals(personId)) {
			if (daoSession == null) {
				throw new DaoException("Entity is detached from DAO context");
			}
			PersonDao targetDao = daoSession.getPersonDao();
			person = targetDao.load(personId);
			person__resolvedKey = personId;
		}
		return person;
	}

	/**
	 * Method setPerson.
	 * @param person Person
	 */
	public void setPerson(Person person) {
		this.person = person;
		personId = person == null ? null : person.getId();
		person__resolvedKey = personId;
	}

	/** To-one relationship, resolved on first access. 
	 * @return Ship
	 */
	public Ship getShip() {
		if (ship__resolvedKey == null || !ship__resolvedKey.equals(shipId)) {
			if (daoSession == null) {
				throw new DaoException("Entity is detached from DAO context");
			}
			ShipDao targetDao = daoSession.getShipDao();
			ship = targetDao.load(shipId);
			ship__resolvedKey = shipId;
		}
		return ship;
	}

	/**
	 * Method setShip.
	 * @param ship Ship
	 */
	public void setShip(Ship ship) {
		this.ship = ship;
		shipId = ship == null ? null : ship.getId();
		ship__resolvedKey = shipId;
	}

	/**
	 * To-many relationship, resolved on first access (and after reset). Changes
	 * to to-many relations are not persisted, make changes to the target
	 * entity.
	
	 * @return List<Planet> */
	public synchronized List<Planet> getPlanets() {
		if (planets == null) {
			if (daoSession == null) {
				throw new DaoException("Entity is detached from DAO context");
			}
			PlanetDao targetDao = daoSession.getPlanetDao();
			planets = targetDao._queryGameData_Planets(id);

			loadMarketplaceInAllPlanets();
		}
		return planets;
	}

	/**
	 * Method loadMarketplaceInAllPlanets.
	 */
	private void loadMarketplaceInAllPlanets() {
		for (Planet p : planets)
			p.getMarketplace();
	}

	/**
	 * Method getUniverse.
	
	 * @return Planet[] */
	public Planet[] getUniverse() {
		Planet[] universe = new Planet[this.getPlanets().size()];
		for (int i = 0; i < universe.length; i++) {
			universe[i] = planets.get(i);
		}
		return universe;
	}

	/**
	 * Resets a to-many relationship, making the next get call to query for a
	 * fresh result.
	 */
	public synchronized void resetPlanets() {
		planets = null;
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
	
	/**
	 * Method toString.
	
	 * @return String */
	@Override
	public String toString() {
		return super.toString();
	}
}
