package com.canefaitrien.spacetrader;

import android.app.Application;

import com.canefaitrien.spacetrader.models.Character;
import com.canefaitrien.spacetrader.models.Universe;

public class SpaceTraderApplication extends Application {
	private static Character character;
	private static Universe universe;

	public static Character getCharacter() {
		return character;
	}

	public static void setCharacter(Character charac) {
		character = charac;
	}

	public static Universe getUniverse() {
		return universe;
	}

	public static void setUniverse(Universe universe) {
		SpaceTraderApplication.universe = universe;
	}
}
