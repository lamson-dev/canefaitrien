package com.canefaitrien.spacetrader.dao;

import java.util.ArrayList;
import java.util.List;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.util.Log;

import com.canefaitrien.spacetrader.models.Marketplace;
import com.canefaitrien.spacetrader.models.Planet;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.DaoConfig;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.Query;
import de.greenrobot.dao.QueryBuilder;
import de.greenrobot.dao.SqlUtils;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/**
 * DAO for table PLANETS.
 */
public class PlanetDao extends AbstractDao<Planet, Long> {

	private static final String TAG = "PlanetDao";

	public static final String TABLENAME = "PLANETS";

	/**
	 * Properties of entity Planet.<br/>
	 * Can be used for QueryBuilder and for referencing column names.
	 */
	public static class Properties {
		public final static Property Id = new Property(0, Long.class, "id",
				true, "_id");
		public final static Property Name = new Property(1, String.class,
				"name", false, "NAME");
		public final static Property Size = new Property(2, Integer.class,
				"size", false, "SIZE");
		public final static Property XCoordinate = new Property(3,
				Integer.class, "xCoordinate", false, "X_COORDINATE");
		public final static Property YCoordinate = new Property(4,
				Integer.class, "yCoordinate", false, "Y_COORDINATE");
		public final static Property TechLevel = new Property(5, String.class,
				"techLevel", false, "TECH_LEVEL");
		public final static Property Situation = new Property(6, String.class,
				"situation", false, "SITUATION");
		public final static Property XOffset = new Property(7, Integer.class,
				"xOffset", false, "X_OFFSET");
		public final static Property YOffset = new Property(8, Integer.class,
				"yOffset", false, "Y_OFFSET");
		public final static Property DataId = new Property(9, Long.class,
				"dataId", false, "DATA_ID");
		public final static Property MarketId = new Property(10, Long.class,
				"marketId", false, "MARKET_ID");
	};

	private DaoSession daoSession;

	private Query<Planet> gameData_PlanetsQuery;

	public PlanetDao(DaoConfig config) {
		super(config);
	}

	public PlanetDao(DaoConfig config, DaoSession daoSession) {
		super(config, daoSession);
		this.daoSession = daoSession;
	}

	/** Creates the underlying database table. */
	public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
		String constraint = ifNotExists ? "IF NOT EXISTS " : "";
		db.execSQL("CREATE TABLE " + constraint + "'PLANETS' (" + //
				"'_id' INTEGER PRIMARY KEY AUTOINCREMENT ," + // 0: id
				"'NAME' TEXT," + // 1: name
				"'SIZE' INTEGER," + // 2: size
				"'X_COORDINATE' INTEGER," + // 3: xCoordinate
				"'Y_COORDINATE' INTEGER," + // 4: yCoordinate
				"'TECH_LEVEL' TEXT," + // 5: techLevel
				"'SITUATION' TEXT," + // 6: situation
				"'X_OFFSET' INTEGER," + // 7: xOffset
				"'Y_OFFSET' INTEGER," + // 8: yOffset
				"'DATA_ID' INTEGER," + // 9: dataId
				"'MARKET_ID' INTEGER);"); // 10: marketId
	}

	/** Drops the underlying database table. */
	public static void dropTable(SQLiteDatabase db, boolean ifExists) {
		String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "")
				+ "'PLANETS'";
		db.execSQL(sql);
	}

	/** @inheritdoc */
	@Override
	protected void bindValues(SQLiteStatement stmt, Planet entity) {
		stmt.clearBindings();

		Long id = entity.getId();
		if (id != null) {
			stmt.bindLong(1, id);
		}

		String name = entity.getName();
		if (name != null) {
			stmt.bindString(2, name);
		}

		Integer size = entity.getRadius();
		if (size != null) {
			stmt.bindLong(3, size);
		}

		Integer xCoordinate = entity.getXCoordinate();
		if (xCoordinate != null) {
			stmt.bindLong(4, xCoordinate);
		}

		Integer yCoordinate = entity.getYCoordinate();
		if (yCoordinate != null) {
			stmt.bindLong(5, yCoordinate);
		}

		String techLevel = entity.getStringTechLevel();
		if (techLevel != null) {
			stmt.bindString(6, techLevel);
		}

		String situation = entity.getStringSituation();
		if (situation != null) {
			stmt.bindString(7, situation);
		}

		Integer xOffset = entity.getXOffset();
		if (xOffset != null) {
			stmt.bindLong(8, xOffset);
		}

		Integer yOffset = entity.getYOffset();
		if (yOffset != null) {
			stmt.bindLong(9, yOffset);
		}

		Long dataId = entity.getDataId();
		if (dataId != null) {
			stmt.bindLong(10, dataId);
		}

		Long marketId = entity.getMarketId();
		if (marketId != null) {
			stmt.bindLong(11, marketId);
		}
	}

	@Override
	protected void attachEntity(Planet entity) {
		super.attachEntity(entity);
		entity.__setDaoSession(daoSession);
	}

	/** @inheritdoc */
	@Override
	public Long readKey(Cursor cursor, int offset) {
		return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
	}

	/** @inheritdoc */
	@Override
	public Planet readEntity(Cursor cursor, int offset) {
		Planet entity = new Planet(
				//
				cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
				cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // name
				cursor.isNull(offset + 2) ? null : cursor.getInt(offset + 2), // size
				cursor.isNull(offset + 3) ? null : cursor.getInt(offset + 3), // xCoordinate
				cursor.isNull(offset + 4) ? null : cursor.getInt(offset + 4), // yCoordinate
				cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5), // techLevel
				cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6), // situation
				cursor.isNull(offset + 7) ? null : cursor.getInt(offset + 7), // xOffset
				cursor.isNull(offset + 8) ? null : cursor.getInt(offset + 8), // yOffset
				cursor.isNull(offset + 9) ? null : cursor.getLong(offset + 9), // dataId
				cursor.isNull(offset + 10) ? null : cursor.getLong(offset + 10) // marketId
		);
		return entity;
	}

	/** @inheritdoc */
	@Override
	public void readEntity(Cursor cursor, Planet entity, int offset) {
		entity.setId(cursor.isNull(offset + 0) ? null : cursor
				.getLong(offset + 0));
		entity.setName(cursor.isNull(offset + 1) ? null : cursor
				.getString(offset + 1));
		entity.setRadius(cursor.isNull(offset + 2) ? null : cursor
				.getInt(offset + 2));
		entity.setXCoordinate(cursor.isNull(offset + 3) ? null : cursor
				.getInt(offset + 3));
		entity.setYCoordinate(cursor.isNull(offset + 4) ? null : cursor
				.getInt(offset + 4));
		entity.setTechLevel(cursor.isNull(offset + 5) ? null : cursor
				.getString(offset + 5));
		entity.setSituation(cursor.isNull(offset + 6) ? null : cursor
				.getString(offset + 6));
		entity.setXOffset(cursor.isNull(offset + 7) ? null : cursor
				.getInt(offset + 7));
		entity.setYOffset(cursor.isNull(offset + 8) ? null : cursor
				.getInt(offset + 8));
		entity.setDataId(cursor.isNull(offset + 9) ? null : cursor
				.getLong(offset + 9));
		entity.setMarketId(cursor.isNull(offset + 10) ? null : cursor
				.getLong(offset + 10));
	}

	/** @inheritdoc */
	@Override
	protected Long updateKeyAfterInsert(Planet entity, long rowId) {
		entity.setId(rowId);
		return rowId;
	}

	/** @inheritdoc */
	@Override
	public Long getKey(Planet entity) {
		if (entity != null) {
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

	/**
	 * Internal query to resolve the "planets" to-many relationship of GameData.
	 */
	public synchronized List<Planet> _queryGameData_Planets(Long dataId) {
		Log.d("PlanetDao", "data ID is: " + String.valueOf(dataId));
		if (gameData_PlanetsQuery == null) {
			QueryBuilder<Planet> queryBuilder = queryBuilder();
			queryBuilder.where(Properties.DataId.eq(dataId));
			gameData_PlanetsQuery = queryBuilder.build();

		} else {
			gameData_PlanetsQuery.setParameter(0, dataId);
		}
		return gameData_PlanetsQuery.list();
	}

	private String selectDeep;

	protected String getSelectDeep() {
		if (selectDeep == null) {
			StringBuilder builder = new StringBuilder("SELECT ");
			SqlUtils.appendColumns(builder, "T", getAllColumns());
			builder.append(',');
			SqlUtils.appendColumns(builder, "T0", daoSession
					.getMarketplaceDao().getAllColumns());
			builder.append(" FROM PLANETS T");
			builder.append(" LEFT JOIN MARKETPLACE T0 ON T.'MARKET_ID'=T0.'_id'");
			builder.append(' ');
			selectDeep = builder.toString();
		}
		return selectDeep;
	}

	protected Planet loadCurrentDeep(Cursor cursor, boolean lock) {
		Planet entity = loadCurrent(cursor, 0, lock);
		int offset = getAllColumns().length;

		Marketplace marketplace = loadCurrentOther(
				daoSession.getMarketplaceDao(), cursor, offset);
		entity.setMarketplace(marketplace);

		return entity;
	}

	public Planet loadDeep(Long key) {
		assertSinglePk();
		if (key == null) {
			return null;
		}

		StringBuilder builder = new StringBuilder(getSelectDeep());
		builder.append("WHERE ");
		SqlUtils.appendColumnsEqValue(builder, "T", getPkColumns());
		String sql = builder.toString();

		String[] keyArray = new String[] { key.toString() };
		Cursor cursor = db.rawQuery(sql, keyArray);

		try {
			boolean available = cursor.moveToFirst();
			if (!available) {
				return null;
			} else if (!cursor.isLast()) {
				throw new IllegalStateException(
						"Expected unique result, but count was "
								+ cursor.getCount());
			}
			return loadCurrentDeep(cursor, true);
		} finally {
			cursor.close();
		}
	}

	/**
	 * Reads all available rows from the given cursor and returns a list of new
	 * ImageTO objects.
	 */
	public List<Planet> loadAllDeepFromCursor(Cursor cursor) {
		int count = cursor.getCount();
		List<Planet> list = new ArrayList<Planet>(count);

		if (cursor.moveToFirst()) {
			if (identityScope != null) {
				identityScope.lock();
				identityScope.reserveRoom(count);
			}
			try {
				do {
					list.add(loadCurrentDeep(cursor, false));
				} while (cursor.moveToNext());
			} finally {
				if (identityScope != null) {
					identityScope.unlock();
				}
			}
		}
		return list;
	}

	protected List<Planet> loadDeepAllAndCloseCursor(Cursor cursor) {
		try {
			return loadAllDeepFromCursor(cursor);
		} finally {
			cursor.close();
		}
	}

	/** A raw-style query where you can pass any WHERE clause and arguments. */
	public List<Planet> queryDeep(String where, String... selectionArg) {
		Cursor cursor = db.rawQuery(getSelectDeep() + where, selectionArg);
		return loadDeepAllAndCloseCursor(cursor);
	}

}
