package com.canefaitrien.spacetrader;

import com.canefaitrien.spacetrader.utils.AbstractActivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.text.method.ScrollingMovementMethod;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class DisplayDataActivity extends AbstractActivity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		// Get the message from the intent
		Intent intent = getIntent();
		String message = intent
				.getStringExtra(ConfigurationActivity.EXTRA_MESSAGE);

		setContentView(R.layout.activity_display_data);
		TextView textView = (TextView) findViewById(R.id.tv_data);

		// Create the text view
		// TextView textView = new TextView(this);
		textView.setTextSize(20);
		textView.setText(SpaceTraderApplication.testString);
		// Set the text view as the activity layout
		// setContentView(textView);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_display_data, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			NavUtils.navigateUpFromSameTask(this);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

}
