package com.canefaitrien.spacetrader.interfaces;


import java.util.List;
import java.util.Map;

import android.content.Context;
import android.widget.ListAdapter;

public interface IMarketPlaceView {
	public void setStockList(List<Map<String, String>> list);

	public List<Map<String, String>> getStockList();

	public void displayMoney(String valueOf);

	public void displayCargo(String valueOf);

	public void setListAdapter(ListAdapter adapter);

	public Context getContext();

	public Object getSystemService(String layoutInflaterService);
}
