package com.canefaitrien.spacetrader;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.Point;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.canefaitrien.spacetrader.models.Encounter;
import com.canefaitrien.spacetrader.models.EncounterType;
import com.canefaitrien.spacetrader.models.PirateEncounter;
import com.canefaitrien.spacetrader.models.Planet;
import com.canefaitrien.spacetrader.models.PoliceEncounter;
import com.canefaitrien.spacetrader.models.Ship;
import com.canefaitrien.spacetrader.models.TraderEncounter;
import com.canefaitrien.spacetrader.utils.AbstractActivity;

//This class should have the actions for clicking a planet
public class GalaxyMapActivity extends AbstractActivity implements OnTouchListener {

	private GalaxyView galaxy;

	LinearLayout galaxyLayout;
	Button button;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Log.d("Galaxy", "Created Galaxy");
		galaxyLayout = (LinearLayout) findViewById(R.id.galaxy_layout);
		// draw planets
		galaxy = new GalaxyView(this,SpaceTrader.getController().getUniverse());
		galaxy.setBackgroundColor(Color.BLACK);
		galaxy.setOnTouchListener(this);

		
		setContentView(galaxy);
		//setContentView(galaxyLayout);
		
		//galaxyLayout.addView(galaxy);
		
		//button = new Button(this);
		//galaxyLayout.addView(button);
		

	}
	public void onCreateDialog(Planet planet) {
		final Planet p = planet;
	    AlertDialog.Builder builder = new AlertDialog.Builder(this);//getActivity());
	    builder.setTitle(""+planet.getName());
	    //Change this to display actual fuel needed when necessary
	    Planet location = SpaceTrader.getController().getLocation();
	    builder.setMessage("Tech Level: "+location.getStringTechLevel()+"\nFuel needed to travel: "+location.distance(p)/Ship.MPG+"/"+SpaceTrader.getController().getShip().getFuel());
	    builder.setPositiveButton("Cancel", new DialogInterface.OnClickListener(){
	    	 public void onClick(DialogInterface dialog, int which) {
	    		 //do nothing
	           }
	    	 
	    });
	    builder.setNegativeButton("Travel", new DialogInterface.OnClickListener(){
	    	public void onClick(DialogInterface dialog, int which) {
	    		 try {
					SpaceTrader.getController().move(p);
					galaxy.invalidate();
					Log.d("Galaxy", "traveling to "+p.getName());
					//
					listDialog();
					} catch (Exception e) {
						Toast.makeText(getApplicationContext(), "" +e.getMessage(),Toast.LENGTH_SHORT).show();
						e.printStackTrace();
					}
	           }
	    });
	    AlertDialog alert = builder.create();
	    alert.show();
	}
	
	public void listDialog() {
	    AlertDialog.Builder builder = new AlertDialog.Builder(this);

		EncounterType encounter = EncounterType.getEncounterType();
	    builder.setTitle("Encounter: "+encounter.name());
	    String[] strs;
	    
		switch(encounter){//handle encounters
		case PIRATE:
			strs = new String[]{"Attack","Flee","Surrender"};
			final PirateEncounter pirate = new PirateEncounter(SpaceTrader.getController());
		    builder.setItems(strs, new DialogInterface.OnClickListener() {
		               public void onClick(DialogInterface dialog, int which) {
			               switch(which){
			               case 0:
			            	  pirate.pirateBattle(); break;
			               case 1:
				           		Toast.makeText(getApplicationContext(), "Escaped Pirate",Toast.LENGTH_SHORT).show();
			            	   pirate.pirateFlee(); break;
			               case 2:
			            	   pirate.takeGoods(); break;
			               }
		           }
		    }); break;
		case POLICE:
			strs = new String[]{"Attack","Bribe 10%","Comply","Flee"};
			final PoliceEncounter police = new PoliceEncounter(SpaceTrader.getController());
		    builder.setItems(strs, new DialogInterface.OnClickListener() {
		               public void onClick(DialogInterface dialog, int which) {
			               switch(which){
			               case 0:
			            	  police.policeBattle(); break;
			               case 1:
			            	   police.bribePolice((int)((float)SpaceTrader.getController().getMoney()*.1)); break;
			               case 2:
			            	   police.checkGoods(); break;
			               case 3:
				           		Toast.makeText(getApplicationContext(), "Escaped Police",Toast.LENGTH_SHORT).show();
			            	   police.policeFlee(); break;
			               }
		           }
		    }); break;
		case TRADER:
			strs = new String[]{"Attack", "Trade", "Flee"};
			final TraderEncounter trader = new TraderEncounter(SpaceTrader.getController());
		    builder.setItems(strs, new DialogInterface.OnClickListener() {
		               public void onClick(DialogInterface dialog, int which) {
			               switch(which){
			               case 0:
			            	  trader.traderBattle(); break;
			               case 1:
			            	  break;
			               case 2:
				           		Toast.makeText(getApplicationContext(), "Left Trader",Toast.LENGTH_SHORT).show();
			            	  break;
			               }
		           }
		    }); break;
		case NOTHING:
			break;
		}
	    if(encounter!=EncounterType.NOTHING){
		    AlertDialog alert = builder.create();
		    alert.show();
	    }
	}
	
	public boolean onTouch(View v, MotionEvent e) {
		if (e.getAction() == MotionEvent.ACTION_DOWN) {
			Log.d("Galaxy", "ActionDown" +  (int)e.getRawX() + " " +  (int)e.getRawY());
			for(Planet p : SpaceTrader.getController().getUniverse()) {
				if(p.isClicked(new Point((int)e.getRawX(), (int)e.getRawY()))){
					if(p!=SpaceTrader.getController().getLocation()){
						Log.d("Galaxy", "clicked " +p.getName());
						// need some sort of popup to invoke move
						onCreateDialog(p);
					}
				}
			}

		}
		return true;
	}
}
