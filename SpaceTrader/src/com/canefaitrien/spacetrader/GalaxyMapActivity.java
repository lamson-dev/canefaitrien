package com.canefaitrien.spacetrader;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.Point;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.LinearLayout;

import com.canefaitrien.spacetrader.models.Planet;
import com.canefaitrien.spacetrader.utils.AbstractActivity;

//This class should have the actions for clicking a planet
public class GalaxyMapActivity extends AbstractActivity implements OnTouchListener {

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
		galaxy = new GalaxyView(this, SpaceTrader.getController().getUniverse());
		galaxy.setOnTouchListener(this);

		setContentView(galaxy);
		galaxy.setBackgroundColor(Color.BLACK);

		// planet buttons
		//planets = galaxy.getPlanets().clone(); //Can't do this twice for some reason?
		Log.d("Galaxy", "Created Galaxy");

	}

	public Dialog onCreateDialog(Bundle savedInstanceState) {
	    AlertDialog.Builder builder = new AlertDialog.Builder(this);//getActivity());
	    builder.setTitle("Event");
	    String[] strs = new String[2];
	    strs[0] = "Option";
	    strs[1] = "hei";
	    builder.setItems(strs, new DialogInterface.OnClickListener() {
	               public void onClick(DialogInterface dialog, int which) {
	               // The 'which' argument contains the index position
	               // of the selected item
	           }
	    });
	    return builder.create();
	}
	
	public boolean onTouch(View v, MotionEvent e) {
		if (e.getAction() == MotionEvent.ACTION_DOWN) {
			Log.d("Galaxy", "ActionDown" +  (int)e.getRawX() + " " +  (int)e.getRawY());
			for(Planet p : SpaceTrader.getController().getUniverse()) {
				if(p.isClicked(new Point((int)e.getRawX(), (int)e.getRawY()))){
					Log.d("Galaxy", "clicked " +p.getName());
					// need some sort of popup to invoke move
				}
			}
			
		}
		return true;
	}

}
