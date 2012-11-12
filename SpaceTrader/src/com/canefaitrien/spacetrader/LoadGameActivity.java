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
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import com.canefaitrien.spacetrader.R;
import com.canefaitrien.spacetrader.dao.DaoMaster;
import com.canefaitrien.spacetrader.dao.DaoMaster.DevOpenHelper;
import com.canefaitrien.spacetrader.dao.DaoSession;
import com.canefaitrien.spacetrader.dao.GameDataDao;
import com.canefaitrien.spacetrader.utils.DbAdapter;

public class LoadGameActivity extends ListActivity {

	private static final String TAG = "LoadGame";
	private static final int ACTIVITY_LOAD = 1;
	private static final int DELETE_ID = Menu.FIRST;

	private GameDataDao gameDataDao;
	private Cursor cursor;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_loadgame);

		gameDataDao = SpaceTrader.daoSession.getGameDataDao();

		fillData();

		registerForContextMenu(getListView());
	}

	private void fillData() {
		String idCol = GameDataDao.Properties.Id.columnName;
		String nameCol = GameDataDao.Properties.Name.columnName;
		String dateCol = GameDataDao.Properties.Date.columnName;

		cursor = SpaceTrader.db.query(gameDataDao.getTablename(),
				gameDataDao.getAllColumns(), null, null, null, null, null);

		String[] from = { idCol, nameCol, dateCol };
		int[] to = { R.id.tv_entry_id, R.id.tv_entry_name, R.id.tv_entry_date };

		SimpleCursorAdapter adapter = new SimpleCursorAdapter(this,
				R.layout.list_loadgame_data, cursor, from, to, 0);

		setListAdapter(adapter);
	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		super.onListItemClick(l, v, position, id);

		Intent intent = new Intent(LoadGameActivity.this,
				MainScreenActivity.class);
		intent.putExtra(GameDataDao.Properties.Id.columnName, id);
		intent.putExtra("New Game", false);
		startActivityForResult(intent, ACTIVITY_LOAD);
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
			Log.d(TAG, "Delete row ID: " + String.valueOf(info.id));
			gameDataDao.deleteByKey(info.id);
			Log.d(TAG, "Deleted game data, ID: " + info.id);
			cursor.requery();
			fillData();
			return true;
		}
		return super.onContextItemSelected(item);
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode,
			Intent intent) {
		super.onActivityResult(requestCode, resultCode, intent);
		cursor.requery();
	}
	@Override
	protected void onStart() {
		super.onStart();
		Log.d(TAG, "onStart called.");
	}

	@Override
	protected void onPause() {
		super.onPause();
		Log.d(TAG, "onPause called.");
	}

	@Override
	protected void onResume() {
		super.onResume();
		Log.d(TAG, "onResume called.");
	}

	@Override
	protected void onStop() {
		super.onStop();
		Log.d(TAG, "onStop called.");
	}

	@Override
	protected void onRestart() {
		super.onRestart();
		Log.d(TAG, "onRestart called.");
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
	}

}
