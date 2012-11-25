// $codepro.audit.disable obsoleteModifierUsage
/**
 * interface for marketplace view
 */
package com.canefaitrien.spacetrader.interfaces;

import java.util.List;
import java.util.Map;

import android.content.Context;
import android.widget.ListAdapter;

/**
 * 
 * @author Son Nguyen
 *
 * @version $Revision: 1.0 $
 */
public interface IMarketPlaceView {
	/**
	 * Method setStockList.
	 * @param list List<Map<String,String>>
	 */
	public void setStockList(List<Map<String, String>> list);

	/**
	 * Method getStockList.
	 * @return List<Map<String,String>>
	 */
	public List<Map<String, String>> getStockList();

	/**
	 * Method displayMoney.
	 * @param valueOf String
	 */
	public void displayMoney(String valueOf);

	/**
	 * Method displayCargo.
	 * @param valueOf String
	 */
	public void displayCargo(String valueOf);

	/**
	 * Method setListAdapter.
	 * @param adapter ListAdapter
	 */
	public void setListAdapter(ListAdapter adapter);

	/**
	 * Method getContext.
	 * @return Context
	 */
	public Context getContext();

	/**
	 * Method getSystemService.
	 * @param layoutInflaterService String
	 * @return Object
	 */
	public Object getSystemService(String layoutInflaterService);
}
