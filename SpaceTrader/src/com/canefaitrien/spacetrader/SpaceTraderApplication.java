package com.canefaitrien.spacetrader;

import android.app.Application;

import com.canefaitrien.spacetrader.models.Controller;

public class SpaceTraderApplication extends Application {
	private static Controller data;
	public static String testString;


	public static void setData(Controller data) {
		SpaceTraderApplication.data = data;
	}
	
	public static Controller getData() {
		return data;
	}
	
	public static void storeTest(String s) {
		SpaceTraderApplication.testString = s;
	}
}

