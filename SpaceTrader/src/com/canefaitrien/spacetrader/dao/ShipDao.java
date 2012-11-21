// $codepro.audit.disable
package com.canefaitrien.spacetrader.dao;

import org.json.JSONException;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.util.Log;

import com.canefaitrien.spacetrader.models.Ship;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.DaoConfig;
import de.greenrobot.dao.Property;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table SHIP.
*/
public class ShipDao extends AbstractDao<Ship, Long> {

    public static final String TABLENAME = "SHIP";

    /**
     * Properties of entity Ship.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");

        public final static Property Type = new Property(1, String.class, "type", false, "TYPE");

        public final static Property HullStrength = new Property(2, Integer.class, "hullStrength", false, "HULL_STRENGTH");

        public final static Property CurrentCargoHold = new Property(3, Integer.class, "currentCargoHold", false, "CURRENT_CARGO_HOLD");

        public final static Property Cargo = new Property(4, String.class, "cargo", false, "CARGO");

        public final static Property Fuel = new Property(5, Integer.class, "fuel", false, "FUEL");

        public final static Property Weapons = new Property(6, String.class, "weapons", false, "WEAPONS");

        public final static Property Shields = new Property(7, String.class, "shields", false, "SHIELDS");

        public final static Property Gadgets = new Property(8, String.class, "gadgets", false, "GADGETS");
    };

    public ShipDao(DaoConfig config) {
        super(config);
    }
    
    public ShipDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "'SHIP' (" + //
                "'_id' INTEGER PRIMARY KEY AUTOINCREMENT ," + // 0: id
                "'TYPE' TEXT," + // 1: type
                "'HULL_STRENGTH' INTEGER," + // 2: hullStrength
                "'CURRENT_CARGO_HOLD' INTEGER," + // 3: currentCargoHold
                "'CARGO' TEXT," + // 4: cargo
                "'FUEL' INTEGER," + // 5: fuel
                "'WEAPONS' TEXT," + // 6: weapons
                "'SHIELDS' TEXT," + // 7: shields
                "'GADGETS' TEXT);"); // 8: gadgets
    }

    /** Drops the underlying database table. */
    public static void dropTable(SQLiteDatabase db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "'SHIP'";
        db.execSQL(sql);
    }

    /** @inheritdoc */
    @Override
    protected void bindValues(SQLiteStatement stmt, Ship entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String type = entity.getStringType();
        if (type != null) {
            stmt.bindString(2, type);
        }
 
        Integer hullStrength = entity.getHullStrength();
        if (hullStrength != null) {
            stmt.bindLong(3, hullStrength);
        }
 
        Integer currentCargoHold = entity.getCurrentCargoHold();
        if (currentCargoHold != null) {
            stmt.bindLong(4, currentCargoHold);
        }
 
        String cargo = entity.getStringCargo();
        if (cargo != null) {
            stmt.bindString(5, cargo);
        }
 
        Integer fuel = entity.getFuel();
        if (fuel != null) {
            stmt.bindLong(6, fuel);
        }
 
        String weapons = entity.getWeapons();
        if (weapons != null) {
            stmt.bindString(7, weapons);
        }
 
		String shields = entity.getShields();
        if (shields != null) {
            stmt.bindString(8, shields);
        }
 
        String gadgets = entity.getGadgets();
        if (gadgets != null) {
            stmt.bindString(9, gadgets);
        }
    }

    /** @inheritdoc */
    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    /** @inheritdoc */
    @Override
    public Ship readEntity(Cursor cursor, int offset) {
        Ship entity = null;
		try {
			entity = new Ship( //
			    cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
			    cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // type
			    cursor.isNull(offset + 2) ? null : cursor.getInt(offset + 2), // hullStrength
			    cursor.isNull(offset + 3) ? null : cursor.getInt(offset + 3), // currentCargoHold
			    cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4), // cargo
			    cursor.isNull(offset + 5) ? null : cursor.getInt(offset + 5), // fuel
			    cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6), // weapons
			    cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7), // shields
			    cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8) // gadgets
			);
		} catch (JSONException e) {
			e.printStackTrace();
			Log.e("ShipDao", e.getMessage());
		}
        return entity;
    }
     
    /** @inheritdoc */
    @Override
    public void readEntity(Cursor cursor, Ship entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setType(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setHullStrength(cursor.isNull(offset + 2) ? null : cursor.getInt(offset + 2));
        entity.setCurrentCargoHold(cursor.isNull(offset + 3) ? null : cursor.getInt(offset + 3));
        try {
			entity.setCargo(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
		} catch (JSONException e) {
			e.printStackTrace();
			Log.e("ShipDao", e.getMessage());
		}
        entity.setFuel(cursor.isNull(offset + 5) ? null : cursor.getInt(offset + 5));
        entity.setWeapons(cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6));
        entity.setShields(cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7));
        entity.setGadgets(cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8));
     }
    
    /** @inheritdoc */
    @Override
    protected Long updateKeyAfterInsert(Ship entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    /** @inheritdoc */
    @Override
    public Long getKey(Ship entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    /** @inheritdoc */
    @Override    
    protected boolean isEntityUpdateable() {
        return true;
    }
    
}
