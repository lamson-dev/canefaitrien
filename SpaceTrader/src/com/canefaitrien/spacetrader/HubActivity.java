package com.canefaitrien.spacetrader;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.canefaitrien.spacetrader.interfaces.IMainScreenView;
import com.canefaitrien.spacetrader.models.Ship;
import com.canefaitrien.spacetrader.presenters.MainScreenPresenter;

public class HubActivity extends Activity implements OnClickListener,
		IMainScreenView {

	MainScreenPresenter mPresenter;

	public HubActivity() {
		mPresenter = new MainScreenPresenter(this);
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_hub);
		
		Button saveGame = (Button) findViewById(R.id.btn_savegame);
		Button refill = (Button) findViewById(R.id.btn_refill);
		
		saveGame.setOnClickListener(this);
		refill.setOnClickListener(this);

	}

	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btn_savegame:
			mPresenter.saveData();
			break;
		case R.id.btn_refill:
			//note to subtract money
			Ship ship = SpaceTrader.getController().getShip();
			ship.setFuel(ship.getType().MAX_DISTANCE);//change this to not be distance
			break;
		}

	}

}
