// $codepro.audit.disable
package com.canefaitrien.spacetrader;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.graphics.Typeface;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class RootActivity extends Activity {

	public static Typeface appFont; // $codepro.audit.disable
									// initializeStaticFields

	/**
	 * an abstract class that extends activity, where we can set some of the
	 * configuration for the app, like theme and stuff
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

		// Make sure we're running on Honeycomb or higher to use ActionBar APIs
		// if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
		// For the main activity, make sure the app icon in the action bar
		// does not behave as a button
		// ActionBar actionBar = getActionBar();
		// actionBar.setDisplayHomeAsUpEnabled(true);
		// // actionBar.setHomeButtonEnabled(false);
		// getActionBar().setDisplayHomeAsUpEnabled(true);
		// actionBar.hide();
		// }

		appFont = Typeface.createFromAsset(getAssets(),
				"fonts/Street Corner.ttf");
	}

	/**
	 * Recursively sets a {@link Typeface} to all {@link TextView}s in a
	 * {@link ViewGroup}.
	 */
	public static final void setAppFont(ViewGroup mContainer, Typeface mFont) {
		if (mContainer == null || mFont == null) {
			return;
		}
		final int mCount = mContainer.getChildCount();

		// Loop through all of the children.
		for (int i = 0; i < mCount; ++i) {
			final View mChild = mContainer.getChildAt(i);
			if (mChild instanceof TextView) {
				// Set the font if it is a TextView.
				((TextView) mChild).setTypeface(mFont);
			} else if (mChild instanceof ViewGroup) {
				// Recursively attempt another ViewGroup.
				setAppFont((ViewGroup) mChild, mFont);
			}
		}
	}
}
