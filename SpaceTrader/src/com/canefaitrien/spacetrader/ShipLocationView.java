// $codepro.audit.disable com.instantiations.assist.eclipse.analysis.audit.rule.effectivejava.alwaysOverridetoString.alwaysOverrideToString
/**
 * Custom View of GalaxyMap Screen, draw ship and ship's fuel level
 */

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
 * @version $Revision: 1.0 $
 */
@SuppressLint("ViewConstructor")
public class ShipLocationView extends View {
	/**
	 * Field paint.
	 */
	private Paint paint = new Paint();// normal paint

	/**
	 * Field wordTest.
	 */
	private Paint wordTest = new Paint(); // text paint

	/**
	 * Field ship_icon.
	 */
	private Bitmap ship_icon;

	/**
	 * Field c.
	 */
	private Canvas c;

	/**
	 * Constructor that sets up the paint for text and other set ups
	 * 
	 * @param context
	 *            takes in the application context
	
	 */
	public ShipLocationView(Context context) {
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
				ship_location.getXCoordinate() - ship_icon.getWidth() >> 1, // divides by 2
				ship_location.getYCoordinate() - ship_icon.getHeight() >> 1, // divides by 2
				paint);

		// draws a circle to indicate travelable distance
		paint.setStyle(Paint.Style.STROKE);
		paint.setColor(Color.WHITE);
		Ship shippy = SpaceTrader.getController().getShip();
		int drawDist = (shippy.getFuel() < shippy.getType().maxDistance) ? shippy
				.getFuel() * Ship.MPG
				: shippy.getType().maxDistance * Ship.MPG;
		c.drawCircle(ship_location.getXCoordinate(),
				ship_location.getYCoordinate(), drawDist, paint);
		// fuel text
		Path circle = new Path();
		circle.addCircle(ship_location.getXCoordinate(),
				ship_location.getYCoordinate(), drawDist, Direction.CW);
		wordTest.setAlpha(254);
		wordTest.setTextSize(20);
		int added = (SpaceTrader.getController().getLocation().getXCoordinate() > shippy
				.getType().maxDistance * Ship.MPG) ? 170 : 500;
		int range = (drawDist < 50) ? -50 : -10;
		c.drawTextOnPath("fuel: " + shippy.getFuel() + "/"
				+ shippy.getType().maxDistance, circle, added, range, wordTest);
	}
}
