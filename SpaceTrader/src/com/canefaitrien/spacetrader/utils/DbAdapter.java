/*
 * Copyright (C) 2008 Google Inc.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package com.canefaitrien.spacetrader.utils;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.canefaitrien.spacetrader.models.Character;

/**
 * Simple notes database access helper class. Defines the basic CRUD operations
 * for the notepad example, and gives the ability to list all notes as well as
 * retrieve or modify a specific note.
 * 
 * This has been improved from the first version of this tutorial through the
 * addition of better error handling and also using returning a Cursor instead
 * of using a collection of inner classes (which is less scalable and not
 * recommended).
 */
public class DbAdapter {

	public static final String CHAR_KEY_ROWID = "_id";
	public static final String CHAR_KEY_NAME = "name";
	public static final String CHAR_KEY_DIFFICULTY = "difficulty";
	public static final String CHAR_KEY_MONEY = "money";
	public static final String CHAR_KEY_ENGINEER_PTS = "engineer_pts";
	public static final String CHAR_KEY_PILOT_PTS = "pilot_pts";
	public static final String CHAR_KEY_TRADER_PTS = "trader_pts";
	public static final String CHAR_KEY_FIGHTER_PTS = "fighter_pts";
	public static final String CHAR_KEY_DATE = "date";

	private static final String TAG = "DbAdapter";
	private DatabaseHelper mDbHelper;
	private SQLiteDatabase mDb;
	private final Context mContext;

	private static final String DB_NAME = "spacetrader";
	private static final String TABLE_CHARACTER = "character";
	private static final int DB_VERSION = 2;

	/**
	 * Database creation sql statement
	 */

	private static final String DB_CREATE_CHAR = "CREATE TABLE "
			+ TABLE_CHARACTER + "(" 
			+ CHAR_KEY_ROWID + " INTEGER PRIMARY KEY AUTOINCREMENT, " 
//			+ CHAR_KEY_DIFFICULTY + " INTEGER, " 
			+ CHAR_KEY_NAME + " TEXT NOT NULL, "
//			+ CHAR_KEY_MONEY + " INTEGER, " 
			+ CHAR_KEY_PILOT_PTS + " INTEGER, "
			+ CHAR_KEY_TRADER_PTS + " INTEGER, " 
			+ CHAR_KEY_FIGHTER_PTS + " INTEGER, " 
			+ CHAR_KEY_ENGINEER_PTS + " INTEGER);";
//			+ CHAR_KEY_DATE + " TEXT NOT NULL);";

	private static class DatabaseHelper extends SQLiteOpenHelper {

		DatabaseHelper(Context context) {
			super(context, DB_NAME, null, DB_VERSION);
		}

		@Override
		public void onCreate(SQLiteDatabase db) {
			db.execSQL(DB_CREATE_CHAR);
			// db.execSQL(DB_CREATE_STATS);
		}

		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
			Log.w(TAG, "Upgrading database from version " + oldVersion + " to "
					+ newVersion + ", which will destroy all old data");
			db.execSQL("DROP TABLE IF EXISTS " + TABLE_CHARACTER);
			onCreate(db);
		}
	}

	/**
	 * Constructor - takes the context to allow the database to be
	 * opened/created
	 * 
	 * @param context
	 *            the Context within which to work
	 */
	public DbAdapter(Context context) {
		this.mContext = context;
	}

	/**
	 * Open the spacetrader database. If it cannot be opened, try to create a new
	 * instance of the database. If it cannot be created, throw an exception to
	 * signal the failure
	 * 
	 * @return this (self reference, allowing this to be chained in an
	 *         initialization call)
	 * @throws SQLException
	 *             if the database could be neither opened or created
	 */
	public DbAdapter open() throws SQLException {
		mDbHelper = new DatabaseHelper(mContext);
		mDb = mDbHelper.getWritableDatabase();
		return this;
	}

	public void close() {
		mDbHelper.close();
	}

	/**
	 * Create a character using the info provided. If the character is
	 * successfully created return the new rowId for that character, otherwise return
	 * a -1 to indicate failure.
	 * 
	 * @param c
	 *            the character
	 * @return rowId or -1 if failed
	 */
	public long createCharacter(Character c) {
		ContentValues initialValues = new ContentValues();
		
		initialValues.put(CHAR_KEY_NAME, c.getName());
//		initialValues.put(CHAR_KEY_DIFFICULTY, c.getDifficulty());
//		initialValues.put(CHAR_KEY_MONEY, c.getMoney());
		initialValues.put(CHAR_KEY_PILOT_PTS, c.getPilotPts());
		initialValues.put(CHAR_KEY_TRADER_PTS, c.getTraderPts());
		initialValues.put(CHAR_KEY_FIGHTER_PTS, c.getFighterPts());
		initialValues.put(CHAR_KEY_ENGINEER_PTS, c.getEngineerPts());
//		initialValues.put(CHAR_KEY_DATE, c.getDate());

		return mDb.insert(TABLE_CHARACTER, null, initialValues);
	}

	/**
	 * Delete the character with the given rowId
	 * 
	 * @param rowId
	 *            id of note to delete
	 * @return true if deleted, false otherwise
	 */
	public boolean deleteCharacter(long rowId) {
		return mDb.delete(TABLE_CHARACTER, CHAR_KEY_ROWID + "=" + rowId, null) > 0;
	}

	/**
	 * Return a Cursor over the list of all characters in the database
	 * 
	 * @return Cursor over all notes
	 */
	public Cursor fetchAllSaves() {

//		String[] columns = new String[] { CHAR_KEY_ROWID, CHAR_KEY_DIFFICULTY,
//				CHAR_KEY_NAME, CHAR_KEY_MONEY, CHAR_KEY_DATE };
			String[] columns = new String[] { CHAR_KEY_ROWID, 
//					CHAR_KEY_DIFFICULTY,
					CHAR_KEY_NAME, 
//					CHAR_KEY_MONEY,
					CHAR_KEY_PILOT_PTS,
					CHAR_KEY_FIGHTER_PTS,
					CHAR_KEY_ENGINEER_PTS,
					CHAR_KEY_TRADER_PTS};
//					CHAR_KEY_DATE };

		return mDb
				.query(TABLE_CHARACTER, columns, null, null, null, null, null);
	}

	/**
	 * Return a Cursor positioned at the character that matches the given rowId
	 * 
	 * @param rowId
	 *            id of note to retrieve
	 * @return Cursor positioned to matching note, if found
	 * @throws SQLException
	 *             if note could not be found/retrieved
	 */
	public Cursor fetchSave(long rowId) throws SQLException {
		String[] columns = new String[] { CHAR_KEY_ROWID, 
//				CHAR_KEY_DIFFICULTY,
				CHAR_KEY_NAME, 
//				CHAR_KEY_MONEY,
				CHAR_KEY_PILOT_PTS,
				CHAR_KEY_FIGHTER_PTS,
				CHAR_KEY_ENGINEER_PTS,
				CHAR_KEY_TRADER_PTS};
//				CHAR_KEY_DATE };

		Cursor mCursor = mDb.query(true, TABLE_CHARACTER, columns,
				CHAR_KEY_ROWID + "=" + rowId, null, null, null, null, null);

		if (mCursor != null) {
			mCursor.moveToFirst();
		}
		return mCursor;

	}

	/**
	 * Update the character using the details provided. The character to be updated is
	 * specified using the rowId, and it is altered to use the 
	 * values passed in
	 * 
	 * @param rowId
	 *            id of character to update
	 *            
	 * @param c
	 * 			updated character
	 * @return true if the note was successfully updated, false otherwise
	 */
	public boolean updateCharacter(long rowId, Character c) {
		ContentValues cv = new ContentValues();
		cv.put(CHAR_KEY_NAME, c.getName());
//		cv.put(CHAR_KEY_DIFFICULTY, c.getDifficulty());
//		cv.put(CHAR_KEY_MONEY, c.getMoney());
		cv.put(CHAR_KEY_PILOT_PTS, c.getPilotPts());
		cv.put(CHAR_KEY_TRADER_PTS, c.getTraderPts());
		cv.put(CHAR_KEY_FIGHTER_PTS, c.getFighterPts());
		cv.put(CHAR_KEY_ENGINEER_PTS, c.getEngineerPts());
//		cv.put(CHAR_KEY_DATE, c.getDate());

		return mDb.update(TABLE_CHARACTER, cv, CHAR_KEY_ROWID + "=" + rowId,
				null) > 0;
	}

}
