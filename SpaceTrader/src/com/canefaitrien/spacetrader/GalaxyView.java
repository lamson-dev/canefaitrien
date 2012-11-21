package com.canefaitrien.spacetrader;

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
import android.view.View;

import com.canefaitrien.spacetrader.models.Planet;
import com.canefaitrien.spacetrader.models.Ship;

/**
 * 
 * This class is the view for the galaxy map It draws onto the canvas
 * 
 * @author Daniel Xiao
 * 
 */
@SuppressLint("ViewConstructor")
public class GalaxyView extends View {
	private Paint paint = new Paint();// normal paint

	private Paint wordTest = new Paint(); // text paint

	private Bitmap ship_icon;

	private Canvas c;

	/**
	 * Constructor that sets up the paint for text and other set ups
	 * 
	 * @param context
	 *            takes in the application context
	 * @param planets
	 *            takes in an array of planets
	 */
	public GalaxyView(Context context) {
		super(context);
	}

	/**
	 * Method that is called when class is started draws the ship and the fuel
	 * radius
	 * 
	 * @param canvas
	 *            the canvas
	 */
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		wordTest.setColor(Color.WHITE);
		wordTest.setTextAlign(Align.CENTER);
		ship_icon = BitmapFactory.decodeResource(getResources(),
				R.drawable.ship_model_a_small);
		c = canvas;
		// draw ship
		Planet ship_location = SpaceTrader.getController().getLocation();
		c.drawBitmap(ship_icon,
				ship_location.getXCoordinate() - ship_icon.getWidth() / 2,
				ship_location.getYCoordinate() - ship_icon.getHeight() / 2,
				paint);

		// draws a circle to indicate travelable distance
		paint.setStyle(Paint.Style.STROKE);
		paint.setColor(Color.WHITE);
		Ship shippy = SpaceTrader.getController().getShip();
		int drawDist = (shippy.getFuel() < shippy.getType().MAX_DISTANCE) ? shippy
				.getFuel() * Ship.MPG
				: shippy.getType().MAX_DISTANCE * Ship.MPG;
		c.drawCircle(ship_location.getXCoordinate(),
				ship_location.getYCoordinate(), drawDist, paint);
		// fuel text
		Path circle = new Path();
		circle.addCircle(ship_location.getXCoordinate(),
				ship_location.getYCoordinate(), drawDist, Direction.CW);
		wordTest.setAlpha(254);
		wordTest.setTextSize(20);
		int added = (SpaceTrader.getController().getLocation().getXCoordinate() > shippy
				.getType().MAX_DISTANCE * Ship.MPG) ? 170 : 500;
		int range = (drawDist < 50) ? -50 : -10;
		c.drawTextOnPath("fuel: " + shippy.getFuel() + "/"
				+ shippy.getType().MAX_DISTANCE, circle, added, range, wordTest);
	}
}
