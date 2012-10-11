package com.canefaitrien.spacetrader;

import android.app.Application;

public class SpaceTraderApplication extends Application {
	private static Character character;
	
	public static Character getCharacter() {
		return character;
	}
	
	public static void setCharacter(Character charac) {
		character = charac;
	}
}
