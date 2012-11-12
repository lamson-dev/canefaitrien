package com.canefaitrien.spacetrader;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import com.canefaitrien.spacetrader.models.Controller;

public class InfoActivity extends Activity {

	private static final String TAG = "Info";

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_info2);

		//TextView tv = (TextView) findViewById(R.id.tv_info_content);
		//tv.setTextSize(20);

		Controller data = SpaceTraderApplication.getData();
		Log.d(TAG, "loaded data");
		//String info = data.getPlayer().toString() + "\n\n" + data.getShip().getCargoView();
		
		
		TextView nameView = (TextView) findViewById(R.id.textView1);
		TextView pilotPts = (TextView) findViewById(R.id.textView6);
		TextView fighterPts = (TextView) findViewById(R.id.textView7);
		TextView traderPts = (TextView) findViewById(R.id.textView8);
		TextView engineerPts = (TextView) findViewById(R.id.textView9);
		
		nameView.setText("" + data.getPlayer().getName());
		pilotPts.setText("" + data.getPlayer().getPilotPts());
		fighterPts.setText("" + data.getPlayer().getFighterPts());
		traderPts.setText("" + data.getPlayer().getTraderPts());
		engineerPts.setText("" + data.getPlayer().getEngineerPts());

		
		

		Log.d(TAG,"loaded info");
		
		//tv.setText(info);
	}

}
