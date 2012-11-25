// $codepro.audit.disable com.instantiations.assist.eclipse.analysis.audit.rule.effectivejava.alwaysOverridetoString.alwaysOverrideToString
/**
 * Concrete View of Marketplace Screen
 */

package com.canefaitrien.spacetrader;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import android.app.ListActivity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.canefaitrien.spacetrader.interfaces.IMarketPlaceView;
import com.canefaitrien.spacetrader.presenters.MarketPlacePresenter;
import com.canefaitrien.spacetrader.utils.MusicManager;

/**
 * @author Son Nguyen
 * @version $Revision: 1.0 $
 */
public class MarketPlaceActivity extends ListActivity implements
		IMarketPlaceView, OnClickListener {

	/**
	 * Field TAG. (value is ""MarketPlace"")
	 */
	private static final String TAG = "MarketPlace";

	/**
	 * Field mPresenter.
	 */
	protected MarketPlacePresenter mPresenter;

	/**
	 * Field stockList.
	 */
	private List<Map<String, String>> stockList = new ArrayList<Map<String, String>>();

	/**
	 * Field itemPos.
	 */
	private int itemPos = 0;

	/**
	 * Field continueMusic.
	 */
	private boolean continueMusic;

	/**
	 * Field tempView.
	 */
	private View tempView;

	/**
	 * constructor pass in this view for the presenter to use
	 */
	public MarketPlaceActivity() {
		mPresenter = new MarketPlacePresenter(this);
	}

	/**
	 * Method onCreate.
	 * 
	 * @param savedInstanceState
	 *            Bundle
	 */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_marketplace);

		Button btnBuy = (Button) findViewById(R.id.btn_buy);
		Button btnSell = (Button) findViewById(R.id.btn_sell);
		btnBuy.setOnClickListener(this);
		btnSell.setOnClickListener(this);

		mPresenter.updateStockList(stockList);
		mPresenter.displayMarket();
		mPresenter.showOtherInfo();

		applyFont();

		// MarketAdapter adapter = new MarketAdapter(this,
		// R.layout.list_item_market, list);
	}

	/**
	 * display money on screen
	 * 
	 * @param valueOf
	 *            String
	 * 
	 * @see com.canefaitrien.spacetrader.interfaces.IMarketPlaceView#displayMoney(String)
	 */
	public void displayMoney(String valueOf) { // $codepro.audit.disable inconsistentUseOfOverride
		TextView tv = (TextView) findViewById(R.id.tv_money);
		tv.setText(valueOf);
	}

	/**
	 * display cargo on screen
	 * 
	 * @param valueOf
	 *            String
	 * 
	 * @see com.canefaitrien.spacetrader.interfaces.IMarketPlaceView#displayCargo(String)
	 */
	public void displayCargo(String valueOf) { // $codepro.audit.disable inconsistentUseOfOverride
		TextView tv = (TextView) findViewById(R.id.tv_cargo);
		tv.setText(valueOf);
	}

	/**
	 * Method getStockList.
	 * 
	 * @return List<Map<String,String>> * @see
	 *         com.canefaitrien.spacetrader.interfaces
	 *         .IMarketPlaceView#getStockList()
	 */
	public List<Map<String, String>> getStockList() { // $codepro.audit.disable inconsistentUseOfOverride
		return stockList;
	}

	/**
	 * Method setStockList.
	 * 
	 * @param stockList
	 *            List<Map<String,String>>
	 * 
	 * @see 
	 *      com.canefaitrien.spacetrader.interfaces.IMarketPlaceView#setStockList
	 *      (List<Map<String,String>>)
	 */
	public void setStockList(List<Map<String, String>> stockList) { // $codepro.audit.disable inconsistentUseOfOverride
		this.stockList = stockList;

	}

	/**
	 * Method onListItemClick.
	 * 
	 * @param l
	 *            ListView
	 * @param v
	 *            View
	 * @param position
	 *            int
	 * @param id
	 *            long
	 */
	@Override
	public void onListItemClick(ListView l, View v, int position, long id) {
		// Do something when a list item is clicked
		super.onListItemClick(l, v, position, id);

		l.setFocusable(true);
		l.setSelected(true);
		// CHANGE COLOR OF SELECTED ROW HERE
		v.setBackgroundColor(Color.rgb(0x28, 0x3C, 0x4F));

		// selectedId = (int) id;

		if (tempView != null) {
			// If row is already clicked then reset its color to default row
			// color
			tempView.setBackgroundColor(Color.TRANSPARENT);

		}
		tempView = v;

		// Toast.makeText(this, "You have chosen " +
		// TradeGood.values()[position],
		// Toast.LENGTH_SHORT).show();
		itemPos = position;

	}

	/**
	 * Method onClick.
	 * 
	 * @param v
	 *            View
	 * 
	 * @see android.view.View$OnClickListener#onClick(View)
	 */
	public void onClick(View v) { // $codepro.audit.disable inconsistentUseOfOverride

		switch (v.getId()) {
		case R.id.btn_buy:
			try {
				mPresenter.buyItem(itemPos);
			} catch (Exception e) {
				Log.e(TAG, e.toString());
				Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
			}
			break;
		case R.id.btn_sell:
			try {
				mPresenter.sellItem(itemPos);
			} catch (Exception e) {
				Log.e(TAG, e.toString());
				Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
			}
			break;
		default:
			break;
		}
		mPresenter.displayMarket();
		mPresenter.showOtherInfo();
	}

	/**
	 * Method setListAdapter.
	 * 
	 * @param adapter
	 *            ListAdapter
	 * 
	 * @see com.canefaitrien.spacetrader.interfaces.
	 * IMarketPlaceView#setListAdapter(ListAdapter)
	 */
	@Override
	public void setListAdapter(ListAdapter adapter) {
		super.setListAdapter(adapter);
		Log.d(TAG, "set list adapter");
	}

	/**
	 * Method getContext.
	 * 
	 * @return Context * @see
	 *         com.canefaitrien.spacetrader.interfaces.IMarketPlaceView
	 *         #getContext()
	 */
	public Context getContext() { // $codepro.audit.disable inconsistentUseOfOverride
		return MarketPlaceActivity.this;
	}

	/**
	 * Method getSystemService.
	 * 
	 * @param name
	 *            String
	 * 
	 * @return Object * @see
	 *         com.canefaitrien.spacetrader.interfaces.IMarketPlaceView
	 *         #getSystemService(String)
	 */
	@Override
	public Object getSystemService(String name) {
		return super.getSystemService(name);
	}

	/**
	 * Method applyFont.
	 */
	private void applyFont() {
		ViewGroup activityViewGroup = (ViewGroup) findViewById(
				android.R.id.content).getRootView();
		RootActivity.setAppFont(activityViewGroup, RootActivity.appFont);
	}

	/**
	 * Method onPause.
	 */
	@Override
	protected void onPause() {
		super.onPause();
		Log.d(TAG, "onPause called.");
		if (!continueMusic) {
			MusicManager.pause();
		}
	}

	/**
	 * Method onResume.
	 */
	@Override
	protected void onResume() {
		super.onResume();
		Log.d(TAG, "onResume called.");
		continueMusic = true;
		MusicManager.start(this, MusicManager.MUSIC_GAME);

		mPresenter.displayMarket();
		mPresenter.showOtherInfo();
	}

	/**
	 * Method onStart.
	 */
	@Override
	protected void onStart() {
		super.onStart();
		Log.d(TAG, "onStart called.");
	}

	/**
	 * Method onStop.
	 */
	@Override
	protected void onStop() {
		super.onStop();
		Log.d(TAG, "onStop called.");
		finish();
	}

	// @Override
	// protected void onDestroy() {
	// // mPresenter.saveData();
	// super.onDestroy();
	// }

	// public class MarketAdapter extends ArrayAdapter<Item> {
	// private List<Item> items;
	// private ItemViewHolder itemHolder;
	//
	// private class ItemViewHolder {
	// TextView name;
	// TextView price;
	// TextView owned;
	// TextView stock;
	// }
	//
	// public MarketAdapter(Context context, int tvResId, List<Item> list) {
	// super(context, tvResId, list);
	// this.items = list;
	// }
	//
	// @Override
	// public View getView(int pos, View convertView, ViewGroup parent) {
	// View v = convertView;
	// if (v == null) {
	// LayoutInflater vi = (LayoutInflater)
	// getSystemService(LAYOUT_INFLATER_SERVICE);
	// v = vi.inflate(R.layout.list_item_market, null);
	// itemHolder = new ItemViewHolder();
	// itemHolder.name = (TextView) v.findViewById(R.id.good_name);
	// itemHolder.price = (TextView) v.findViewById(R.id.good_price);
	// itemHolder.owned = (TextView) v.findViewById(R.id.good_owned);
	// itemHolder.stock = (TextView) v.findViewById(R.id.good_stock);
	// v.setTag(itemHolder);
	// } else
	// itemHolder = (ItemViewHolder) v.getTag();
	//
	// Item item = items.get(pos);
	//
	// if (item != null) {
	// itemHolder.name.setText(item.getName());
	// itemHolder.price.setText(item.getBuyPrice());
	// itemHolder.owned.setText(item.getOwned());
	// itemHolder.stock.setText(item.getStock());
	// }
	//
	// return v;
	// }
	// }

}
