package com.canefaitrien.spacetrader.presenters;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.canefaitrien.spacetrader.R;
import com.canefaitrien.spacetrader.RootActivity;
import com.canefaitrien.spacetrader.SpaceTrader;
import com.canefaitrien.spacetrader.interfaces.IMarketPlaceView;
import com.canefaitrien.spacetrader.models.Controller;
import com.canefaitrien.spacetrader.models.Marketplace;
import com.canefaitrien.spacetrader.models.TradeGood;

public class MarketPlacePresenter {

	private static final String TAG = "MarketPresenter";
	private IMarketPlaceView mView;
	private Marketplace mMarket;
	private Controller controller;

	public MarketPlacePresenter(IMarketPlaceView view) {
		mView = view;
		controller = SpaceTrader.getController();
	}

	public List<HashMap<String, String>> populateStock(
			List<HashMap<String, String>> list) {

		mMarket = controller.getLocation().getMarketplace1();
		TradeGood[] goods = TradeGood.values();

		list = new ArrayList<HashMap<String, String>>();

		for (int i = 0; i < goods.length; i++) {

			HashMap<String, String> temp = new HashMap<String, String>();
			temp.put("name", goods[i].toString());
			temp.put("price", String.valueOf(mMarket.getItemBuyPrices()[i]));
			temp.put("sellprice",
					String.valueOf(mMarket.getItemSellPrices()[i]));
			temp.put("owned",
					String.valueOf(controller.getShip().getCargo()[i]));
			temp.put("stock", String.valueOf(mMarket.getItemStock()[i]));

			list.add(temp);
		}
		return list;

	}

	public void displayMarket() {
		updateStockList(mView.getStockList());

		String[] from = new String[] { "name", "price", "sellprice", "owned",
				"stock" };
		int[] to = new int[] { R.id.good_name, R.id.good_price,
				R.id.good_sell_price, R.id.good_owned, R.id.good_stock };
		// SimpleAdapter adapter = new SimpleAdapter(mView.getContext(),
		// mView.getStockList(), R.layout.list_item_market, from, to);

		final List<HashMap<String, String>> entries = mView.getStockList();
		SimpleAdapter adapter = new SimpleAdapter(mView.getContext(), entries,
				R.layout.list_item_market, from, to) {
			@Override
			public View getView(int pos, View convertView, ViewGroup parent) {
				View v = convertView;
				if (v == null) {
					LayoutInflater vi = (LayoutInflater) mView
							.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
					v = vi.inflate(R.layout.list_item_market, null);
				}

				TextView tv;
				tv = (TextView) v.findViewById(R.id.good_name);
				tv.setText(entries.get(pos).get("name"));
				tv.setTypeface(RootActivity.appFont);
				tv = (TextView) v.findViewById(R.id.good_price);
				tv.setText(entries.get(pos).get("price"));
				tv.setTypeface(RootActivity.appFont);
				tv = (TextView) v.findViewById(R.id.good_sell_price);
				tv.setText(entries.get(pos).get("sellprice"));
				tv.setTypeface(RootActivity.appFont);
				tv = (TextView) v.findViewById(R.id.good_owned);
				tv.setText(entries.get(pos).get("owned"));
				tv.setTypeface(RootActivity.appFont);
				tv = (TextView) v.findViewById(R.id.good_stock);
				tv.setText(entries.get(pos).get("stock"));
				tv.setTypeface(RootActivity.appFont);

				// RootActivity.setAppFont(parent, RootActivity.appFont);
				return v;
			}

		};

		mView.setListAdapter(adapter);

	}

	public void buyItem(int pos) throws Exception {
		controller.buyGood(TradeGood.values()[pos]);
		updateStockList(mView.getStockList());
	}

	public void sellItem(int pos) throws Exception {
		controller.sellGood(TradeGood.values()[pos]);
		updateStockList(mView.getStockList());
	}

	public void updateStockList(List<HashMap<String, String>> list) {
		mView.setStockList(this.populateStock(list));
	}

	public void showOtherInfo() {
		mView.displayMoney(String.valueOf(controller.getMoney()));
		mView.displayCargo(mMarket.getId() + "/"
				+ controller.getLocation().getMarketId() + "/"
				+ controller.getLocation().getName());
	}

	// dynamically add stuff to android layout
	// public List<HashMap<String, String>> listStockItems(Context context,
	// LinearLayout content) {
	// dynamically add list views
	// for (int i = 0; i < view.length; i++) {
	// LinearLayout ll = new LinearLayout(context);
	// ll.setOrientation(LinearLayout.HORIZONTAL);
	// ll.setPadding(20, 10, 20, 10);
	// for (int j = 0; j < view[i].length; j++) {
	//
	// TextView tv = new TextView(context);
	// tv.setText(view[i][j]);
	// tv.setPadding(20, 5, 20, 5);
	// ll.addView(tv);
	//
	// }
	// content.addView(ll);
	// // JButton button = new JButton("Buy");
	// // button.addActionListener(new BuyListener(goods[i]));
	// // panel.add(button);
	// // button = new JButton("Sell");
	// // button.addActionListener(new SellListener(goods[i]));
	// // panel.add(button);
	// }
	//
	// LinearLayout ll = new LinearLayout(context);
	// ll.setOrientation(LinearLayout.HORIZONTAL);
	// ll.setPadding(20, 10, 20, 10);
	// TextView tv = new TextView(context);
	// tv.setText("Planet " + data.getLocation().getName());
	// tv.setPadding(20, 5, 20, 5);
	// ll.addView(tv);
	// content.addView(ll);
	//
	// ll = new LinearLayout(context);
	// ll.setOrientation(LinearLayout.HORIZONTAL);
	// ll.setPadding(20, 10, 20, 10);
	// tv = new TextView(context);
	// tv.setText("$" + data.getMoney());
	// tv.setPadding(20, 5, 20, 5);
	// ll.addView(tv);
	// content.addView(ll);
	// return ret;
	// }

	// public class Item {
	// private String name;
	// private int buyPrice;
	// private int owned;
	// private int stock;
	//
	// public Item(String name, int buyPrice, int owned, int Stock) {
	// setName(name);
	// setBuyPrice(buyPrice);
	// setOwned(owned);
	// setStock(stock);
	// }
	//
	// public String getName() {
	// return name;
	// }
	//
	// public void setName(String name) {
	// this.name = name;
	// }
	//
	// public int getBuyPrice() {
	// return buyPrice;
	// }
	//
	// public void setBuyPrice(int buyPrice) {
	// this.buyPrice = buyPrice;
	// }
	//
	// public int getOwned() {
	// return owned;
	// }
	//
	// public void setOwned(int owned) {
	// this.owned = owned;
	// }
	//
	// public int getStock() {
	// return stock;
	// }
	//
	// public void setStock(int stock) {
	// this.stock = stock;
	// }
	//
	// }
}
