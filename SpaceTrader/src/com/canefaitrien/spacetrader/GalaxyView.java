package com.canefaitrien.spacetrader;

import java.util.Random;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.util.Log;
import android.view.View;

import com.canefaitrien.spacetrader.R;
import com.canefaitrien.spacetrader.models.Planet;
import com.canefaitrien.spacetrader.models.Ship;
//Draws planets and creates a view
@SuppressLint("ViewConstructor")
public class GalaxyView extends View {

	
	private Planet[] planets;
	Paint paint = new Paint();// normal paint
	Paint wordTest = new Paint(); // text paint
	// for create planets
	Random randomColor = new Random();
	Paint planetColor = new Paint();
	//
	Bitmap ship_icon;
	float x, y;
	Canvas c;	
	
	public GalaxyView(Context context, Planet[] planets) {
		super(context);
		//
		this.planets = planets;
		wordTest.setColor(Color.WHITE);
		wordTest.setTextAlign(Align.CENTER);

		ship_icon = BitmapFactory.decodeResource(getResources(),
				R.drawable.ship_icon);
		x = 500;
		y = 500;
	}

	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		c = canvas;
		//planets = universe.getPlanets().clone();
		for (int i = 0; i < planets.length; i++) {

			planetColor.setARGB(200, randomColor.nextInt(256),randomColor.nextInt(256), randomColor.nextInt(256));
			//planetColor.setColor(planets[i].getColor());
			c.drawCircle(planets[i].getCoordinates().x,planets[i].getCoordinates().y, planets[i].getRadius(),planetColor);

			wordTest.setTextSize(planets[i].getRadius());
			c.drawText(planets[i].getName(), planets[i].getCoordinates().x, planets[i].getCoordinates().y, wordTest);
			
		}	
		Planet ship_location = SpaceTrader.getController().getLocation();
		c.drawBitmap(ship_icon, ship_location.getXCoordinate()-ship_icon.getWidth()/2, ship_location.getYCoordinate()-ship_icon.getHeight()/2, paint);			
		//draws a circle to indicate distance
		paint.setStyle(Paint.Style.STROKE);
		paint.setColor(Color.WHITE);
		//need to check which is higher: max dist or fuel
		c.drawCircle(ship_location.getXCoordinate(), ship_location.getYCoordinate(), SpaceTrader.getController().getShip().getFuel()*Ship.MPG*1, paint);
		}
	// getters and setters
	public Planet[] getPlanets() {
		return planets;
	}
	public void redraw(){
		onDraw(c);
		Log.d("Galaxy view", "redrawing");
	}
}
