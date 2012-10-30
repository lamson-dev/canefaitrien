package com.canefaitrien.spacetrader;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.canefaitrien.spacetrader.models.GameData;
import com.canefaitrien.spacetrader.models.Marketplace;
import com.canefaitrien.spacetrader.models.Planet;
import com.canefaitrien.spacetrader.utils.AbstractActivity;

public class MarketPlaceActivity extends AbstractActivity {

	private final String TAG = "MarketPlace";

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_marketplace);
		// TextView textView = (TextView) findViewById(R.id.tv_market);
		// textView.setTextSize(20);
		// textView.setText("this THE market place");

		String[] myStringArray = new String[] { "a", "b", "c" };
		GameData data = SpaceTraderApplication.getData();
		Log.d(TAG, "data loaded");
		Planet p = data.getLocation();
		Log.d(TAG, "planet loaded");
		Marketplace mp = p.getMarketplace();
//		Log.d(TAG, "market loaded");
//		Log.d(TAG, mp.getBuyView().toString());

//		String[] myStringArray = data.getLocation().getMarketplace()
//				.getBuyView();

		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, myStringArray);

		ListView listView = (ListView) findViewById(R.id.lv_market);
		listView.setAdapter(adapter);

	}

	public void onListItemClick(ListView l, View v, int position, long id) {
		// Do something when a list item is clicked
	}

}
