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

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.canefaitrien.spacetrader.dao.GameDataDao;
import com.canefaitrien.spacetrader.models.GameData;
import com.canefaitrien.spacetrader.utils.MusicManager;

public class LoadGameActivity extends ListActivity {

	private static final String TAG = "LoadGame";
	private static final int ACTIVITY_LOAD = 1;
	private static final int DELETE_ID = Menu.FIRST;

	private GameDataDao gameDataDao;
	private Cursor cursor;
	private boolean continueMusic;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_loadgame);
		gameDataDao = SpaceTrader.daoSession.getGameDataDao();

		fillData();
		registerForContextMenu(getListView());

		setFont();
	}

	private void fillData() {
		final String idCol = GameDataDao.Properties.Id.columnName;
		final String nameCol = GameDataDao.Properties.Name.columnName;
		final String dateCol = GameDataDao.Properties.Date.columnName;
		final String moneyCol = GameDataDao.Properties.Money.columnName;
		final String planetCol = GameDataDao.Properties.CurrentPlanet.columnName;

		cursor = SpaceTrader.db.query(gameDataDao.getTablename(),
				gameDataDao.getAllColumns(), null, null, null, null, null);

		String[] from = { idCol, nameCol, planetCol, moneyCol, dateCol };
		int[] to = { R.id.tv_entry_id, R.id.tv_entry_name,
				R.id.tv_entry_planet, R.id.tv_entry_money, R.id.tv_entry_date };

		// SimpleCursorAdapter adapter = new SimpleCursorAdapter(this,
		// R.layout.list_loadgame_data, cursor, from, to, 0);
		List<GameData> saves = gameDataDao.loadAll();
		final List<HashMap<String, String>> entries = new ArrayList<HashMap<String, String>>();

		for (GameData data : saves) {
			HashMap<String, String> entry = new HashMap<String, String>();
			entry.put(idCol, String.valueOf(data.getId()));
			entry.put(nameCol, data.getName());
			entry.put(planetCol, data.getCurrentPlanet().getName());
			entry.put(moneyCol, String.valueOf(data.getMoney()));
			entry.put(dateCol,
					DateFormat.getDateTimeInstance().format(data.getDate()));
			entries.add(entry);
		}

		SimpleAdapter adapter = new SimpleAdapter(LoadGameActivity.this,
				entries, R.layout.list_loadgame_data, from, to) {
			@Override
			public View getView(int pos, View convertView, ViewGroup parent) {
				View v = convertView;
				if (v == null) {
					LayoutInflater vi = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
					v = vi.inflate(R.layout.list_loadgame_data, null);
				}

				TextView tv;
				tv = (TextView) v.findViewById(R.id.tv_entry_id);
				tv.setText(entries.get(pos).get(idCol));
				tv = (TextView) v.findViewById(R.id.tv_entry_name);
				tv.setText(entries.get(pos).get(nameCol));
				tv = (TextView) v.findViewById(R.id.tv_entry_planet);
				tv.setText(entries.get(pos).get(planetCol));
				tv = (TextView) v.findViewById(R.id.tv_entry_money);
				tv.setText(entries.get(pos).get(moneyCol));
				tv = (TextView) v.findViewById(R.id.tv_entry_date);
				tv.setText(entries.get(pos).get(dateCol));

				RootActivity.setAppFont(parent, RootActivity.appFont);
				return v;
			}

		};
		setListAdapter(adapter);

	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {

		super.onListItemClick(l, v, position, id);
		Log.d(TAG, "clicked id: " + String.valueOf(id));
		Log.d(TAG, "position id: " + String.valueOf(position));
		Intent intent = new Intent(LoadGameActivity.this,
				MainScreenActivity.class);
		intent.putExtra(GameDataDao.Properties.Id.columnName, id + 1);
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
			Log.d(TAG, "Delete row ID: " + String.valueOf(info.id + 1));
			gameDataDao.deleteByKey(info.id + 1);
			Log.d(TAG, "Deleted game data, ID: " + info.id + 1);
			// TODO delete universe, planets/marketplaces/ship
			// cursor.requery();
			fillData();
			return true;
		}
		return super.onContextItemSelected(item);
	}

	private void setFont() {
		ViewGroup activityViewGroup = (ViewGroup) findViewById(
				android.R.id.content).getRootView();
		RootActivity.setAppFont(activityViewGroup, RootActivity.appFont);
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode,
			Intent intent) {
		super.onActivityResult(requestCode, resultCode, intent);
		// cursor.requery();
	}

	@Override
	protected void onStart() {
		super.onStart();
		Log.d(TAG, "onStart called.");
	}

	@Override
	public void onBackPressed() {
		super.onBackPressed();
		continueMusic = true;
	}

	@Override
	protected void onPause() {
		super.onPause();
		Log.d(TAG, "onPause called.");
		if (!continueMusic) {
			MusicManager.pause();
		}
	}

	@Override
	protected void onResume() {
		super.onResume();
		Log.d(TAG, "onResume called.");
		continueMusic = true;
		MusicManager.start(this, MusicManager.MUSIC_MENU);
	}

	@Override
	protected void onStop() {
		super.onStop();
		Log.d(TAG, "onStop called.");
		finish();
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
