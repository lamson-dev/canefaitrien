/**
 * Custom View of GalaxyMap Screen, draw planets
 */

package com.canefaitrien.spacetrader;

import java.util.Random;

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

	private Paint paint = new Paint();// normal paint

	private Paint wordPaint = new Paint();// for text

	private Paint planetPaint = new Paint();// for simple planets

	private Random rand = new Random();

	private Bitmap planetImage;

	private Rect dst;

	private boolean simplePlanets;

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
		wordPaint.setColor(Color.WHITE);
		wordPaint.setTextAlign(Align.CENTER);
	}

	/**
	 * Draw method called when created
	 */
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);

		int[] planetImgs = new int[] { R.drawable.planet_a_small,
				R.drawable.planet_b_small, R.drawable.planet_c_small,
				R.drawable.planet_d, R.drawable.planet_e, R.drawable.planet_f,
				R.drawable.planet_g, R.drawable.planet_h, R.drawable.planet_i,
				R.drawable.planet_j };

		for (int i = 0; i < planets.length; i++) {
			Planet planet = planets[i];
			if (simplePlanets) {
				planetPaint.setARGB(200, rand.nextInt(256), rand.nextInt(256),
						rand.nextInt(256));
				canvas.drawCircle(planets[i].getCoordinates().x,
						planets[i].getCoordinates().y, planets[i].getRadius(),
						planetPaint);
			} else {
				planetImage = BitmapFactory.decodeResource(getResources(),
						planetImgs[(int) planet.getType()]);
				// this is the rectangle that determines the scaled planet size
				dst = new Rect(planet.getXCoordinate() - planet.getRadius(),
						planet.getYCoordinate() - planet.getRadius(),
						planet.getXCoordinate() + planet.getRadius(),
						planet.getYCoordinate() + planet.getRadius());
				canvas.drawBitmap(planetImage, null, dst, paint);
				wordPaint.setAlpha(200);
				wordPaint.setTextSize(16);
				canvas.drawText(planets[i].getName(),
						planets[i].getCoordinates().x,
						planets[i].getCoordinates().y, wordPaint);
			}
		}
	}
}
