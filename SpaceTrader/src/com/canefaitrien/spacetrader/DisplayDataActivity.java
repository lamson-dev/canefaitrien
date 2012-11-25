// $codepro.audit.disable com.instantiations.assist.eclipse.analysis.audit.rule.effectivejava.alwaysOverridetoString.alwaysOverrideToString
/**
 * Concrete View of Display Data Screen, for debugging
 */

package com.canefaitrien.spacetrader;

import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.canefaitrien.spacetrader.models.Marketplace;
import com.canefaitrien.spacetrader.models.Situation;
import com.canefaitrien.spacetrader.models.TechLevel;

/**
 * This Activity is for displaying information on the screen. Mainly for
 * debugging
 * 
 * @author Son Nguyen
 * 
 * @version $Revision: 1.0 $
 */
public class DisplayDataActivity extends RootActivity {

	// private boolean continueMusic;

	/**
	 * Method onCreate.
	 * @param savedInstanceState Bundle
	 */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		// Get the message from the intent
		// Intent intent = getIntent();
		// String message = intent
		// .getStringExtra(ConfigurationActivity.EXTRA_MESSAGE);

		setContentView(R.layout.activity_display_data);
		TextView textView = (TextView) findViewById(R.id.tv_data);

		// Create the text view
		// TextView textView = new TextView(this);
		textView.setTextSize(20);
		Marketplace mp = new Marketplace(0, TechLevel.HI_TECH,
				Situation.ARTISTIC);
		textView.setText(mp.toString());
		// Set the text view as the activity layout
		// setContentView(textView);

	}

	/**
	 * Method onCreateOptionsMenu.
	 * @param menu Menu
	 * @return boolean
	 */
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_display_data, menu);
		return true;
	}

	/**
	 * Method onOptionsItemSelected.
	 * @param item MenuItem
	 * @return boolean
	 */
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			NavUtils.navigateUpFromSameTask(this);
			return true;
		default:
			Log.d("DisplayActivity", "no idea which option was pressed");
		}
		return super.onOptionsItemSelected(item);
	}

}
