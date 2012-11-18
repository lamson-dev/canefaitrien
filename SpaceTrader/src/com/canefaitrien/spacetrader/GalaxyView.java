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
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.Rect;
import android.view.View;

import com.canefaitrien.spacetrader.models.Planet;
import com.canefaitrien.spacetrader.models.Ship;

<<<<<<< HEAD
/**
 * 
 * This class is the view for the galaxy map It draws onto the canvas
 * 
 * @author Daniel Xiao
 * 
 */
@SuppressLint("ViewConstructor")
public class GalaxyView extends View {
=======
//Draws planets and creates a view
@SuppressLint("ViewConstructor")
public class GalaxyView extends View {

>>>>>>> 10120ef862176b786fae659d28a3e0eec7c32ef8
	private Planet[] planets;
	Paint paint = new Paint();// normal paint
	Paint wordTest = new Paint(); // text paint
	// for create planets
	Random randomColor = new Random();
	Paint planetColor = new Paint();
	//
	Bitmap ship_icon;
<<<<<<< HEAD
	Bitmap planetImage;
	Canvas c;
	Boolean firstDraw;

	/**
	 * Constructor that sets up the paint for text and other set ups
	 * 
	 * @param context
	 *            takes in the application context
	 * @param planets
	 *            takes in an array of planets
	 */
=======
	float x, y;
	Canvas c;

>>>>>>> 10120ef862176b786fae659d28a3e0eec7c32ef8
	public GalaxyView(Context context, Planet[] planets) {
		super(context);
		//
		this.planets = planets;
		wordTest.setColor(Color.WHITE);
		wordTest.setTextAlign(Align.CENTER);
		firstDraw = false;

		ship_icon = BitmapFactory.decodeResource(getResources(),
				R.drawable.ship_icon);
	}

	/**
	 * Method that is called when class is started Basically draws planets and
	 * the ship and the fuel radius
	 * 
	 * @param canvas
	 *            the canvas
	 */
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		c = canvas;
<<<<<<< HEAD
		/**
		 * Expensive planet drawing
		 */
		if(!firstDraw){
			for (int i = 0; i < planets.length; i++) {
				Planet planet = planets[i];
				//planetColor.setARGB(200, randomColor.nextInt(256),randomColor.nextInt(256), randomColor.nextInt(256));
				//c.drawCircle(planets[i].getCoordinates().x,planets[i].getCoordinates().y, planets[i].getRadius(),planetColor);
				switch(planet.getImageType()){
				case 0:
					planetImage = BitmapFactory.decodeResource(getResources(),R.drawable.planet_a); break;
				case 1:
					planetImage = BitmapFactory.decodeResource(getResources(),R.drawable.planet_b); break;
				}
				//this is the rectangle that determines the scaled planet size
				Rect dst = new Rect(planet.getXCoordinate()-planet.getRadius(),planet.getYCoordinate()-planet.getRadius(),
						planet.getXCoordinate()+planet.getRadius(),planet.getYCoordinate()+planet.getRadius());
				c.drawBitmap(planetImage, null, dst, paint);
				wordTest.setAlpha(125);
				wordTest.setTextSize(16);
				c.drawText(planets[i].getName(), planets[i].getCoordinates().x,planets[i].getCoordinates().y, wordTest);
			}
			//firstDraw = true; //doesn't do anything now because it'll just not draw the planets
		}
		// draw ship
		Planet ship_location = SpaceTrader.getController().getLocation(); 
=======
		// planets = universe.getPlanets().clone();
		for (int i = 0; i < planets.length; i++) {

			planetColor.setARGB(200, randomColor.nextInt(256),
					randomColor.nextInt(256), randomColor.nextInt(256));
			// planetColor.setColor(planets[i].getColor());
			c.drawCircle(planets[i].getCoordinates().x,
					planets[i].getCoordinates().y, planets[i].getRadius(),
					planetColor);

			wordTest.setTextSize(planets[i].getRadius());
			wordTest.setTypeface(RootActivity.appFont);
			c.drawText(planets[i].getName(), planets[i].getCoordinates().x,
					planets[i].getCoordinates().y, wordTest);

		}
		Planet ship_location = SpaceTrader.getController().getLocation();
>>>>>>> 10120ef862176b786fae659d28a3e0eec7c32ef8
		c.drawBitmap(ship_icon,
				ship_location.getXCoordinate() - ship_icon.getWidth() / 2,
				ship_location.getYCoordinate() - ship_icon.getHeight() / 2,
				paint);
<<<<<<< HEAD
		paint.setStyle(Paint.Style.STROKE);
		paint.setColor(Color.WHITE);
		// draws a circle to indicate travelable distance
		Ship shippy = SpaceTrader.getController().getShip();
		int drawDist = (shippy.getFuel()<shippy.getType().MAX_DISTANCE) ? shippy.getFuel()*Ship.MPG:shippy.getType().MAX_DISTANCE*Ship.MPG;
		c.drawCircle(ship_location.getXCoordinate(),ship_location.getYCoordinate(), drawDist, paint);
		//fuel text
		Path circle = new Path();
		circle.addCircle(ship_location.getXCoordinate(), ship_location.getYCoordinate(), drawDist, Direction.CW);
		wordTest.setAlpha(254);
		wordTest.setTextSize(20);
		int added = (SpaceTrader.getController().getLocation().getXCoordinate()>shippy.getType().MAX_DISTANCE*Ship.MPG) ? 170 : 500;
		c.drawTextOnPath("fuel: "+shippy.getFuel()+"/"+shippy.getType().MAX_DISTANCE, circle, added, -10, wordTest);
=======
		// draws a circle to indicate distance
		paint.setStyle(Paint.Style.STROKE);
		paint.setColor(Color.WHITE);
		// need to check which is higher: max dist or fuel
		c.drawCircle(ship_location.getXCoordinate(),
				ship_location.getYCoordinate(), SpaceTrader.getController()
						.getShip().getFuel()
						* Ship.MPG * 1, paint);
	}

	// getters and setters
	public Planet[] getPlanets() {
		return planets;
	}

	public void redraw() {
		onDraw(c);
		Log.d("Galaxy view", "redrawing");
>>>>>>> 10120ef862176b786fae659d28a3e0eec7c32ef8
	}
}
