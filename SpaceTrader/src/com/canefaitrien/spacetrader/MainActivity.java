package com.canefaitrien.spacetrader;

import com.canefaitrien.spacetrader.utils.AbstractActivity;

import android.os.Bundle;
import android.view.Menu;

public class MainActivity extends AbstractActivity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}
}
