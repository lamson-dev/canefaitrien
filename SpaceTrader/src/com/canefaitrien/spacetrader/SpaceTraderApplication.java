package com.canefaitrien.spacetrader;

import android.app.Application;

public class SpaceTraderApplication extends Application {
	public Character character;
	
	public Character getCharacter() {
		return character;
	}
	
	public void setCharacter(Character character) {
		this.character = character;
	}
}
