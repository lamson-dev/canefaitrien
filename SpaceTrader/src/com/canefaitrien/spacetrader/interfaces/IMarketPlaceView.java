package com.canefaitrien.spacetrader.interfaces;

import java.util.HashMap;
import java.util.List;

import android.content.Context;
import android.widget.ListAdapter;

public interface IMarketPlaceView {
	public void setStockList(List<HashMap<String, String>> listStockItems);

	public List<HashMap<String, String>> getStockList();

	public void displayMoney(String valueOf);

	public void displayCargo(String valueOf);

	public void setListAdapter(ListAdapter adapter);

	public Context getContext();

	public Object getSystemService(String layoutInflaterService);
}
