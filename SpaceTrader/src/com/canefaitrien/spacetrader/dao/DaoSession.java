package com.canefaitrien.spacetrader.dao;

import java.util.Map;

import android.database.sqlite.SQLiteDatabase;

import com.canefaitrien.spacetrader.models.GameData;
import com.canefaitrien.spacetrader.models.Marketplace;
import com.canefaitrien.spacetrader.models.Person;
import com.canefaitrien.spacetrader.models.Planet;
import com.canefaitrien.spacetrader.models.Ship;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.AbstractDaoSession;
import de.greenrobot.dao.DaoConfig;
import de.greenrobot.dao.IdentityScopeType;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see de.greenrobot.dao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig gameDataDaoConfig;
    private final DaoConfig personDaoConfig;
    private final DaoConfig shipDaoConfig;
    private final DaoConfig planetDaoConfig;
    private final DaoConfig marketplaceDaoConfig;

    private final GameDataDao gameDataDao;
    private final PersonDao personDao;
    private final ShipDao shipDao;
    private final PlanetDao planetDao;
    private final MarketplaceDao marketplaceDao;

    public DaoSession(SQLiteDatabase db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        gameDataDaoConfig = daoConfigMap.get(GameDataDao.class).clone();
        gameDataDaoConfig.initIdentityScope(type);

        personDaoConfig = daoConfigMap.get(PersonDao.class).clone();
        personDaoConfig.initIdentityScope(type);

        shipDaoConfig = daoConfigMap.get(ShipDao.class).clone();
        shipDaoConfig.initIdentityScope(type);

        planetDaoConfig = daoConfigMap.get(PlanetDao.class).clone();
        planetDaoConfig.initIdentityScope(type);

        marketplaceDaoConfig = daoConfigMap.get(MarketplaceDao.class).clone();
        marketplaceDaoConfig.initIdentityScope(type);

        gameDataDao = new GameDataDao(gameDataDaoConfig, this);
        personDao = new PersonDao(personDaoConfig, this);
        shipDao = new ShipDao(shipDaoConfig, this);
        planetDao = new PlanetDao(planetDaoConfig, this);
        marketplaceDao = new MarketplaceDao(marketplaceDaoConfig, this);

        registerDao(GameData.class, gameDataDao);
        registerDao(Person.class, personDao);
        registerDao(Ship.class, shipDao);
        registerDao(Planet.class, planetDao);
        registerDao(Marketplace.class, marketplaceDao);
    }
    
    public void clear() {
        gameDataDaoConfig.getIdentityScope().clear();
        personDaoConfig.getIdentityScope().clear();
        shipDaoConfig.getIdentityScope().clear();
        planetDaoConfig.getIdentityScope().clear();
        marketplaceDaoConfig.getIdentityScope().clear();
    }

    public GameDataDao getGameDataDao() {
        return gameDataDao;
    }

    public PersonDao getPersonDao() {
        return personDao;
    }

    public ShipDao getShipDao() {
        return shipDao;
    }

    public PlanetDao getPlanetDao() {
        return planetDao;
    }

    public MarketplaceDao getMarketplaceDao() {
        return marketplaceDao;
    }

}
