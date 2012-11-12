package com.canefaitrien.spacetrader.models;


import java.util.ArrayList;
import java.util.List;

import android.util.Log;

import com.canefaitrien.spacetrader.dao.DaoSession;
import com.canefaitrien.spacetrader.dao.GameDataDao;
import com.canefaitrien.spacetrader.dao.PersonDao;
import com.canefaitrien.spacetrader.dao.PlanetDao;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.DaoException;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT. Enable "keep" sections if you want to edit. 
/**
 * Entity mapped to table GAME_DATA.
 */
public class GameData {

	private static final String TAG = "GameData";
	
    private Long id;
    private String name;
    private String difficulty;
    private Integer money;
    private String currentPlanet;
    private Integer turn;
    private java.util.Date date;
    private Long personId;

    /** Used to resolve relations */
    private transient DaoSession daoSession;

    /** Used for active entity operations. */
    private transient GameDataDao myDao;

    private Person person;
    private Long person__resolvedKey;

    private List<Planet> planets;

    public GameData() {
    }

    public GameData(Long id) {
        this.id = id;
    }

    public GameData(Long id, String name, String difficulty, Integer money, String currentPlanet, Integer turn, java.util.Date date, Long personId) {
        this.id = id;
        this.name = name;
        this.difficulty = difficulty;
        this.money = money;
        this.currentPlanet = currentPlanet;
        this.turn = turn;
        this.date = date;
        this.personId = personId;
    }

    /** called by internal mechanisms, do not call yourself. */
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getGameDataDao() : null;
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

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

    public String getStringCurrentPlanet() {
        return currentPlanet;
    }
    
	public Planet getCurrentPlanet() {
		int location = getPlanets().indexOf(currentPlanet);
		return getPlanets().get(location);
	}

	public int getCurrentPlanetIndex() {
		return getPlanets().indexOf(currentPlanet);
	}
	
    public void setCurrentPlanet(String currentPlanet) {
        this.currentPlanet = currentPlanet;
    }

    public Integer getTurn() {
        return turn;
    }

    public void setTurn(Integer turn) {
        this.turn = turn;
    }

    public java.util.Date getDate() {
        return date;
    }

    public void setDate(java.util.Date date) {
        this.date = date;
    }

    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }

    /** To-one relationship, resolved on first access. */
    public Person getPerson() {
        if (person__resolvedKey == null || !person__resolvedKey.equals(personId)) {
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            PersonDao targetDao = daoSession.getPersonDao();
            person = targetDao.load(personId);
            person__resolvedKey = personId;
        }
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
        personId = person == null ? null : person.getId();
        person__resolvedKey = personId;
    }

    /** To-many relationship, resolved on first access (and after reset). Changes to to-many relations are not persisted, make changes to the target entity. */
    public synchronized List<Planet> getPlanets() {
        if (planets == null) {
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            PlanetDao targetDao = daoSession.getPlanetDao();
            planets = targetDao._queryGameData_Planets(id);
            if (planets==null) {
            	Log.d("GameData", "fucking null planets");
            }
            
            if (planets instanceof ArrayList) 
            	Log.d("GameData", "planets is arraylist");
            
        }
        return planets;
    }

	public Planet[] getUniverse() {
		Planet[] universe;
		Log.d("GameData", "broke after planets.size()");
		universe = new Planet[this.getPlanets().size()];
		Log.d("GameData", "broke before getPlanets()");
		for (int i = 0; i < universe.length; i++)
			universe[i] = planets.get(i);
		
		return universe;

	}
	
    /** Resets a to-many relationship, making the next get call to query for a fresh result. */
    public synchronized void resetPlanets() {
        planets = null;
    }

    /** Convenient call for {@link AbstractDao#delete(Object)}. Entity must attached to an entity context. */
    public void delete() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }    
        myDao.delete(this);
    }

    /** Convenient call for {@link AbstractDao#update(Object)}. Entity must attached to an entity context. */
    public void update() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }    
        myDao.update(this);
    }

    /** Convenient call for {@link AbstractDao#refresh(Object)}. Entity must attached to an entity context. */
    public void refresh() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }    
        myDao.refresh(this);
    }

}
