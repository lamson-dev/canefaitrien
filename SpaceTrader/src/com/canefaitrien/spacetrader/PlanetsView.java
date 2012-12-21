// $codepro.audit.disable com.instantiations.assist.eclipse.analysis.audit.rule.effectivejava.alwaysOverridetoString.alwaysOverrideToString
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
 * @version $Revision: 1.0 $
 */
@SuppressLint("ViewConstructor")
public class PlanetsView extends View {

	/**
	 * Field planets.
	 */
	private final Planet[] planets;

	/**
	 * Field paint.
	 */
	private final Paint paint = new Paint();// normal paint

	/**
	 * Field wordPaint.
	 */
	private final Paint wordPaint = new Paint();// for text

	/**
	 * Field planetPaint.
	 */
	private final Paint planetPaint = new Paint();// for simple planets

	/**
	 * Field rand.
	 */
	private final Random rand = new Random();

	/**
	 * Field planetImage.
	 */
	private Bitmap planetImage;

	/**
	 * Field dst.
	 */
	private Rect dst;

	/**
	 * Field simplePlanets.
	 */
	private boolean simplePlanets; // $codepro.audit.disable
									// com.instantiations.assist.eclipse.analysis.unassignedField

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
		this.planets = planets; // $codepro.audit.disable
								// com.instantiations.assist.eclipse.arrayIsStoredWithoutCopying
		wordPaint.setColor(Color.WHITE);
		wordPaint.setTextAlign(Align.CENTER);
	}

	private static final int ALPHA = 200;

	private static final int COLOR = 256;

	private static final int TEXT_SIZE = 16;

	/**
	 * Draw method called when created
	 * 
	 * @param canvas
	 *            Canvas
	 */
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);

		final int[] planetImgs = new int[] { R.drawable.planet_a_small,
				R.drawable.planet_b_small, R.drawable.planet_c_small,
				R.drawable.planet_d, R.drawable.planet_e, R.drawable.planet_f,
				R.drawable.planet_g, R.drawable.planet_h, R.drawable.planet_i,
				R.drawable.planet_j };

		for (int i = 0; i < planets.length; i++) {
			Planet planet = planets[i];
			if (simplePlanets) {
				planetPaint.setARGB(ALPHA, rand.nextInt(COLOR),
						rand.nextInt(COLOR), rand.nextInt(COLOR));
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
				wordPaint.setAlpha(ALPHA);
				wordPaint.setTextSize(TEXT_SIZE);
				canvas.drawText(planets[i].getName(),
						planets[i].getCoordinates().x,
						planets[i].getCoordinates().y, wordPaint);
			}
		}
	}
}
