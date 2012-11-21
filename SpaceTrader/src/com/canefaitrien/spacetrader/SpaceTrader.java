// $codepro.audit.disable
package com.canefaitrien.spacetrader;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;

import com.canefaitrien.spacetrader.dao.DaoMaster;
import com.canefaitrien.spacetrader.dao.DaoSession;
import com.canefaitrien.spacetrader.models.Controller;
import com.canefaitrien.spacetrader.models.GameData;

/**
 * SpaceTrader application
 * 
 * @author Son, Andrew, An, Daniel
 * 
 */
public class SpaceTrader extends Application {
	private static Controller controller;

	private static GameData data;

	public static SQLiteDatabase db;

	public static DaoMaster daoMaster;

	public static DaoSession daoSession;

	public static void setData(GameData data) {
		SpaceTrader.data = data;
	}

	public static GameData getData() {
		return data;
	}

	public static Controller getController() {
		return controller;
	}

	public static void setController(Controller controller) {
		SpaceTrader.controller = controller;
	}

}
