package com.canefaitrien.spacetrader;

import com.canefaitrien.spacetrader.models.Planet;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Paint.Align;
import android.view.View;

/**
 * This class draws the planets made so it doesn't have to be expensively
 * redrawn everytime
 * 
 * @author Daniel Xiao
 * 
 */
@SuppressLint("ViewConstructor")
public class PlanetsView extends View {

	private Planet[] planets;
	private Paint wordTest = new Paint();
	private Bitmap planetImage;
	private Paint paint = new Paint();// normal paint
	private Rect dst;

	/**
	 * Constructor that sets up the paint for text and other set ups
	 * 
	 * @param context
	 *            takes in the application context
	 * @param planets
	 *            takes in an array of planets
	 */
	public PlanetsView(Context context, Planet[] planets) {
		super(context);
		//
		this.planets = planets;
		wordTest.setColor(Color.WHITE);
		wordTest.setTextAlign(Align.CENTER);
	}

	/**
	 * Draw method called when created
	 */
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);

		for (int i = 0; i < planets.length; i++) {
			Planet planet = planets[i];
			// planetColor.setARGB(200,
			// randomColor.nextInt(256),randomColor.nextInt(256),randomColor.nextInt(256));
			// c.drawCircle(planets[i].getCoordinates().x,planets[i].getCoordinates().y,planets[i].getRadius(),planetColor);
			switch (planet.getType()) {
			case 0:
				planetImage = BitmapFactory.decodeResource(getResources(),
						R.drawable.planet_a);
				break;
			case 1:
				planetImage = BitmapFactory.decodeResource(getResources(),
						R.drawable.planet_b);
				break;
			case 2:
				planetImage = BitmapFactory.decodeResource(getResources(),
						R.drawable.planet_c);
				break;
			case 3:
				planetImage = BitmapFactory.decodeResource(getResources(),
						R.drawable.planet_a);
				break;
			}
			// this is the rectangle that determines the scaled planet size
			dst = new Rect(planet.getXCoordinate() - planet.getRadius(),
					planet.getYCoordinate() - planet.getRadius(),
					planet.getXCoordinate() + planet.getRadius(),
					planet.getYCoordinate() + planet.getRadius());
			canvas.drawBitmap(planetImage, null, dst, paint);
			wordTest.setAlpha(125);
			wordTest.setTextSize(16);
			canvas.drawText(planets[i].getName(),
					planets[i].getCoordinates().x,
					planets[i].getCoordinates().y, wordTest);
		}
	}
}
