package com.canefaitrien.spacetrader.interfaces;

import java.util.HashMap;
import java.util.List;

public interface IMarketPlaceView {
	public void setStockList(List<HashMap<String, String>> listStockItems);

	public List getStockList();

	public void displayMoney(String valueOf);

	public void displayCargo(String valueOf);
}
