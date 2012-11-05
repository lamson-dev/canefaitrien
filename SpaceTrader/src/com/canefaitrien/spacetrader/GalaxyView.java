package com.canefaitrien.spacetrader;

import java.util.Random;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.view.View;

import com.canefaitrien.spacetrader.models.Planet;
import com.canefaitrien.spacetrader.models.Universe;

//Draws planets and creates a view
public class GalaxyView extends View {

	
	private Planet[] planets = Universe.generate();// note this is creating a new universe every time
	Paint paint = new Paint();// normal paint
	Paint wordTest = new Paint(); // text paint
	// for create planets
	Random randomColor = new Random();
	Paint planetColor = new Paint();
	//
	Bitmap planetIcon;
	float x, y;
	Canvas c;
	//
	Thread ourThread = null;
	boolean isRunning = false;
	
	public GalaxyView(Context context) {
		super(context);
		//
		wordTest.setColor(Color.WHITE);
		wordTest.setTextAlign(Align.CENTER);

		planetIcon = BitmapFactory.decodeResource(getResources(),
				R.drawable.planet_button_test);
		x = 500;
		y = 500;
	}

	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		c = canvas;
		//planets = universe.getPlanets().clone();
		for (int i = 1; i < planets.length; i++) {

			planetColor.setARGB(200, randomColor.nextInt(256),
					randomColor.nextInt(256), randomColor.nextInt(256));
			canvas.drawCircle(planets[i].getCoordinates().x,
					planets[i].getCoordinates().y, planets[i].getSize(),
					planetColor);

			wordTest.setTextSize(planets[i].getSize());
			canvas.drawText(planets[i].getName(), planets[i].getCoordinates().x, planets[i].getCoordinates().y, wordTest);
			
		}	
		//c.drawBitmap(planetIcon, x, y, paint);			
		//invalidate();
		}
	// getters and setters
	public Planet[] getPlanets() {
		return planets;
	}

}
