// $codepro.audit.disable com.instantiations.assist.eclipse.analysis.audit.rule.effectivejava.alwaysOverridetoString.alwaysOverrideToString
/**
 * Concrete View of GalaxyMap Screen
 */

package com.canefaitrien.spacetrader;

import android.app.ActionBar.LayoutParams;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Point;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.canefaitrien.spacetrader.models.EncounterType;
import com.canefaitrien.spacetrader.models.PirateEncounter;
import com.canefaitrien.spacetrader.models.Planet;
import com.canefaitrien.spacetrader.models.PoliceEncounter;
import com.canefaitrien.spacetrader.models.Ship;
import com.canefaitrien.spacetrader.models.TraderEncounter;
import com.canefaitrien.spacetrader.utils.MusicManager;

/**
 * This class handles the actions on the Galaxy menu
 * 
 * 
 * @author Daniel Xiao
 * 
 * @version $Revision: 1.0 $
 */
public class GalaxyMapActivity extends RootActivity implements OnTouchListener {

	/**
	 * Field TAG. (value is ""GalaxyActivity"")
	 */
	private static final String TAG = "GalaxyActivity";

	/**
	 * Field TEN. (value is 10)
	 */
	/**
	 * Field THREE. (value is 3)
	 */
	/**
	 * Field TWO. (value is 2)
	 */
	/**
	 * Field ONE. (value is 1)
	 */
	/**
	 * Field ZERO. (value is 0)
	 */
	protected static final int ZERO = 0, ONE = 1, TWO = 2, THREE = 3, TEN = 10;

	/**
	 * Field galaxy.
	 */
	private ShipLocationView galaxy;

	/**
	 * Field planetsView.
	 */
	private PlanetsView planetsView;

	/**
	 * Displays the galaxy canvas and draws it on Creates a listener for screen
	 * pressing
	 */
	private boolean continueMusic;

	/**
	 * Method onCreate.
	 * 
	 * @param savedInstanceState
	 *            Bundle
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {

		final FrameLayout main = new FrameLayout(this);
		main.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, // $codepro.audit.disable
																			// staticMemberAccess
				LayoutParams.MATCH_PARENT)); // $codepro.audit.disable
												// staticMemberAccess
		//
		super.onCreate(savedInstanceState);
		Log.d("Galaxy", "Created Galaxy");
		// draw planets
		galaxy = new ShipLocationView(this);
		planetsView = new PlanetsView(this, SpaceTrader.getController()
				.getUniverse());
		galaxy.setOnTouchListener(this);
		setContentView(main);
		main.setBackgroundResource(R.drawable.starfield_a);
		main.addView(planetsView);
		main.addView(galaxy);

	}

	/**
	 * Creates popup menus for when a planet is clicked on
	 * 
	 * @param planet
	 *            Takes in the planet clicked on.
	 */
	public void onCreateDialog(Planet planet) { // $codepro.audit.disable
												// overloadedMethods
		final Planet thePlanet = planet;
		final AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setTitle("" + planet.getName());
		final Planet location = SpaceTrader.getController().getLocation();
		builder.setMessage("Tech Level: " + planet.getStringTechLevel()
				+ "\nSituation: " + planet.getStringSituation()
				+ "\nFuel needed to travel: " + planet.distance(location)
				/ Ship.MPG + "/"
				+ SpaceTrader.getController().getShip().getFuel());
		builder.setPositiveButton("Close",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {
						// do nothing
						Log.i(TAG, "user pressed close");
					}

				});
		if (!planet.equals(location)) {
			builder.setNegativeButton("Travel",
					new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							try {
								SpaceTrader.getController().move(thePlanet);
								galaxy.invalidate();
								Log.d("Galaxy",
										"traveling to " + thePlanet.getName());
								//
								listDialog();
							} catch (Exception e) {
								Toast.makeText(getApplicationContext(),
										"" + e.getMessage(), Toast.LENGTH_SHORT)
										.show();
								e.printStackTrace();
							}
						}
					});
		}
		final AlertDialog alert = builder.create();
		alert.show();
	}

	/**
	 * Creates a dialog for when an encounter appears
	 */
	public void listDialog() {
		final AlertDialog.Builder builder = new AlertDialog.Builder(this);

		final EncounterType encounter = EncounterType.getEncounterType();
		builder.setTitle("Encounter: " + encounter.name());
		String[] strs;

		switch (encounter) {// handle encounters
		case PIRATE:
			strs = new String[] { "Attack", "Flee", "Surrender" };
			final PirateEncounter pirate = new PirateEncounter(
					SpaceTrader.getController());
			builder.setItems(strs, new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog, int which) {
					switch (which) {
					case ZERO:
						if (pirate.canPirateBattle()) {
							Toast.makeText(getApplicationContext(),
									"There was a battlz", Toast.LENGTH_SHORT)
									.show();
						}
						break;
					case ONE:
						Toast.makeText(getApplicationContext(),
								"Escaped Pirate", Toast.LENGTH_SHORT).show();
						if (pirate.canPirateFlee()) {
							Toast.makeText(getApplicationContext(),
									"You got away", Toast.LENGTH_SHORT).show();
						}
						break;
					case TWO:
						pirate.takeGoods();
						break;
					default:
						break;
					}
				}
			});
			break;
		case POLICE:
			strs = new String[] { "Attack", "Bribe 10%", "Comply", "Flee" };
			final PoliceEncounter police = new PoliceEncounter(
					SpaceTrader.getController());
			builder.setItems(strs, new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog, int which) {
					switch (which) {
					case ZERO:
						if (police.canPoliceBattle()) {
							Toast.makeText(getApplicationContext(),
									"There was a battle", Toast.LENGTH_SHORT)
									.show();
						}
						break;
					case ONE:
						if (police.canBribePolice(SpaceTrader.getController()
								.getMoney() / TEN)) {
							Toast.makeText(getApplicationContext(),
									"Bribe successful", Toast.LENGTH_SHORT)
									.show();
						}
						break;
					case TWO:
						if (police.checkGoods() == 0) {
							Toast.makeText(getApplicationContext(),
									"No goods taken", Toast.LENGTH_SHORT)
									.show();
						}
						break;
					case THREE:
						if (police.canPoliceFlee()) {
							Toast.makeText(getApplicationContext(), "Escaped",
									Toast.LENGTH_SHORT).show();
						}
						break;
					default:
						break;
					}
				}
			});
			break;
		case TRADER:
			strs = new String[] { "Attack", "Trade", "Flee" };
			final TraderEncounter trader = new TraderEncounter(
					SpaceTrader.getController());
			builder.setItems(strs, new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog, int which) {
					switch (which) {
					case ZERO:
						if (trader.canTraderBattle()) {
							Toast.makeText(getApplicationContext(),
									"There was a battle", Toast.LENGTH_SHORT)
									.show();
						}
						break;
					case ONE:
						break;
					case TWO:
						Toast.makeText(getApplicationContext(), "Left Trader",
								Toast.LENGTH_SHORT).show();
						break;
					default:
						break;
					}
				}
			});
			break;
		case NOTHING:
			break;
		default:
			break;
		}
		if (encounter != EncounterType.NOTHING) {// no encounter
			final AlertDialog alert = builder.create();
			alert.show();
		}
	}

	/**
	 * Checks entire screen when pressed and sees if a planet contains those
	 * coordinates
	 * 
	 * @param v
	 *            View
	 * @param e
	 *            MotionEvent
	 * 
	 * @return returns true when the view is touched * @see
	 *         android.view.View$OnTouchListener#onTouch(View, MotionEvent) * @see
	 *         android.view.View$OnTouchListener#onTouch(View, MotionEvent)
	 */
	public boolean onTouch(View v, MotionEvent e) { // $codepro.audit.disable
													// inconsistentUseOfOverride
		if (e.getAction() == MotionEvent.ACTION_DOWN) {
			Log.d("Galaxy",
					"ActionDown" + (int) e.getRawX() + " " + (int) e.getRawY()); // $codepro.audit.disable
																					// lossOfPrecisionInCast
			for (Planet p : SpaceTrader.getController().getUniverse()) {
				if (p.isClicked(new Point((int) e.getRawX(), (int) e.getRawY()))) { // $codepro.audit.disable
																					// lossOfPrecisionInCast
					// if(p!=SpaceTrader.getController().getLocation()){//is
					// this the planet we're on
					Log.d("Galaxy", "clicked " + p.getName());
					// passes the planet clicked on
					onCreateDialog(p);
					// }
				}
			}
		}
		return true;
	}

	/**
	 * Method onPause.
	 */
	@Override
	protected void onPause() {
		super.onPause();
		Log.d(TAG, "onPause called.");
		if (!continueMusic) {
			MusicManager.pause();
		}
	}

	/**
	 * Method onResume.
	 */
	@Override
	protected void onResume() {
		super.onResume();
		Log.d(TAG, "onResume called.");
		continueMusic = true;
		MusicManager.start(this, MusicManager.MUSIC_GAME);

		galaxy.invalidate();
	}

	/**
	 * Method onStart.
	 */
	@Override
	protected void onStart() {
		super.onStart();
		Log.d(TAG, "onStart called.");
	}

	/**
	 * Method onStop.
	 */
	@Override
	protected void onStop() {
		super.onStop();
		Log.d(TAG, "onStop called.");
		// finish();
	}

	/**
	 * Method onRestart.
	 */
	@Override
	protected void onRestart() {
		super.onRestart();
		Log.d(TAG, "onRestart called.");
	}

	// @Override
	// protected void onDestroy() {
	// super.onDestroy();
	// }
}
