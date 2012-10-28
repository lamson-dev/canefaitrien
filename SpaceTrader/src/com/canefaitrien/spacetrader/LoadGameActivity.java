/*
 * Copyright (C) 2008 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.canefaitrien.spacetrader;

import android.app.ListActivity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import com.canefaitrien.spacetrader.utils.DbAdapter;

public class LoadGameActivity extends ListActivity {
	private static final int ACTIVITY_LOAD = 1;

	private static final int DELETE_ID = Menu.FIRST;

	private DbAdapter mDbHelper;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_loadgame);

		mDbHelper = new DbAdapter(this);
		mDbHelper.open();

		fillData();
		registerForContextMenu(getListView());
	}

	private void fillData() {
		// Get all of the rows from the database and create the item list
		Cursor c = mDbHelper.fetchAllSaves();
		startManagingCursor(c);

		// Create an array to specify the fields we want to display in the list
		// (only TITLE)
		String[] from = new String[] { DbAdapter.CHAR_KEY_ROWID,
				DbAdapter.CHAR_KEY_DIFFICULTY, DbAdapter.CHAR_KEY_NAME,
				DbAdapter.CHAR_KEY_MONEY, DbAdapter.CHAR_KEY_DATE };

		// and an array of the fields we want to bind those fields to (in this
		// case just text1)
		int[] to = new int[] { R.id.tv_entry_id, R.id.tv_entry_difficulty,
				R.id.tv_entry_name, R.id.tv_entry_money, R.id.tv_entry_date };

		// Now create a simple cursor adapter and set it to display
		SimpleCursorAdapter saves = new SimpleCursorAdapter(this,
				R.layout.activity_loadgame_data, c, from, to, 0);
		setListAdapter(saves);

		// int iRow = c.getColumnIndex(DbAdapter.CHAR_KEY_ROWID);
		// int iName = c.getColumnIndex(DbAdapter.CHAR_KEY_NAME);
		// int iDate = c.getColumnIndex(DbAdapter.CHAR_KEY_DATE);
		//
		// for (c.moveToFirst(); !c.isAfterLast(); c.moveToNext()) {
		// result += c.getString(iRow) + " " + c.getString(iName) + " " +
		// c.getString(iDate) + "\n";
		// }

	}

	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {
		super.onCreateContextMenu(menu, v, menuInfo);
		menu.add(0, DELETE_ID, 0, R.string.delete_save);
	}

	@Override
	public boolean onContextItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case DELETE_ID:
			AdapterContextMenuInfo info = (AdapterContextMenuInfo) item
					.getMenuInfo();
			mDbHelper.deleteCharacter(info.id);
			fillData();
			return true;
		}
		return super.onContextItemSelected(item);
	}

	private void loadGame(long rowId) {
		Intent intent = new Intent(LoadGameActivity.this,
				MainScreenActivity.class);
		intent.putExtra(DbAdapter.CHAR_KEY_ROWID, rowId);
		startActivityForResult(intent, ACTIVITY_LOAD);
	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		super.onListItemClick(l, v, position, id);
		loadGame(id);
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode,
			Intent intent) {
		super.onActivityResult(requestCode, resultCode, intent);
		fillData();
	}
}
