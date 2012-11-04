package com.canefaitrien.spacetrader;

import android.app.ListActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.canefaitrien.spacetrader.models.GameData;

public class MarketPlaceActivity extends ListActivity {

	private final String TAG = "MarketPlace";

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		// setContentView(R.layout.activity_marketplace);
		// TextView textView = (TextView) findViewById(R.id.tv_market);
		// textView.setTextSize(20);
		// textView.setText("this THE market place");

		// String[] myStringArray = new String[] { "a", "b", "c" };
//		GameData data = SpaceTraderApplication.getData();
//		Log.d(TAG, SpaceTraderApplication.getData().toString());
//		if (data.getLocation() == null) {
//			Log.d(TAG, "planet is nulll");
//		}
//		Log.d(TAG, SpaceTraderApplication.getData().getLocation().toString());
//		Log.d(TAG, SpaceTraderApplication.getData().getLocation()
//				.getMarketplace().toString());
//		// Log.d(TAG,
//		// SpaceTraderApplication.getData().getLocation().getMarketplace().getBuyView()[0]);
//
//		String[] myStringArray = data.getLocation().getMarketplace()
//				.getBuyView(data.getShip());
//
//		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
//				android.R.layout.simple_list_item_1, myStringArray);
//		setListAdapter(adapter);
		// ListView listView = (ListView) findViewById(R.id.lv_market);
		// listView.setAdapter(adapter);

	}

	public void onListItemClick(ListView l, View v, int position, long id) {
		// Do something when a list item is clicked
		super.onListItemClick(l, v, position, id);
		Log.d(TAG, position + " " + id);
	}

}
