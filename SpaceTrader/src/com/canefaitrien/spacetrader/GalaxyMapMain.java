package com.canefaitrien.spacetrader;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.LinearLayout;

import com.canefaitrien.spacetrader.models.Planet;

//This class should have the actions for clicking a planet
public class GalaxyMapMain extends Activity implements OnTouchListener {

	private GalaxyView galaxy;
	/*private Planet[] planets;
	private Button[] buttons;
	private Button button;*/
	float testx;
	//
	Thread ourThread = null;
	boolean isRunning = false;

	LinearLayout galaxyLayout;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		// draw planets, done
		galaxy = new GalaxyView(this, SpaceTraderApplication.getData()
				.getUniverse());
		galaxy.setOnTouchListener(this);

		setContentView(galaxy);
		galaxy.setBackgroundColor(Color.BLACK);

		// planet buttons
		//planets = galaxy.getPlanets().clone(); //Can't do this twice for some reason?
		Log.d("Galaxy", "Created Galaxy");

	}

	public boolean onTouch(View v, MotionEvent e) {
		// planets[0].setLocation(new Point(10,10));
		return true;
	}

}
