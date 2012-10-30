package com.canefaitrien.spacetrader;

import android.app.ActionBar.LayoutParams;
import android.app.ListActivity;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.support.v4.widget.SimpleCursorAdapter;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MarketPlaceActivity extends ListActivity implements
		LoaderManager.LoaderCallbacks<Cursor> {

	SimpleCursorAdapter mAdapter;
	// These are the Contacts rows that we will retrieve
	static final String[] PROJECTION = new String[] {
			ContactsContract.Data._ID, ContactsContract.Data.DISPLAY_NAME };

	// This is the select criteria
	static final String SELECTION = "((" + ContactsContract.Data.DISPLAY_NAME
			+ " NOTNULL) AND (" + ContactsContract.Data.DISPLAY_NAME
			+ " != '' ))";

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_marketplace);
		TextView textView = (TextView) findViewById(R.id.tv_market);

		// Create the text view
		// TextView textView = new TextView(this);
		textView.setTextSize(20);
		textView.setText("this THE market place");
		// Set the text view as the activity layout
		// setContentView(textView);

//		// Create a progress bar to display while the list loads
//		ProgressBar progressBar = new ProgressBar(this);
//		progressBar.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT,
//				LayoutParams.WRAP_CONTENT, Gravity.CENTER));
//		progressBar.setIndeterminate(true);
//		getListView().setEmptyView(progressBar);
//
//		// Must add the progress bar to the root of the layout
//		ViewGroup root = (ViewGroup) findViewById(android.R.id.content);
//		root.addView(progressBar);

		
		// For the cursor adapter, specify which columns go into which views
		String[] fromColumns = { ContactsContract.Data.DISPLAY_NAME };
		int[] toViews = { R.id.tv_data }; // The TextView in

		// Create an empty adapter we will use to display the loaded data.
		// We pass null for the cursor, then update it in onLoadFinished()
		mAdapter = new SimpleCursorAdapter(this, R.layout.activity_marketplace,
				null, fromColumns, toViews, 0);
		setListAdapter(mAdapter);

		// Prepare the loader. Either re-connect with an existing one,
		// or start a new one.
		// getLoaderManager().initLoader(0, null, this);

	}

	// Called when a new Loader needs to be created
	public Loader<Cursor> onCreateLoader(int id, Bundle args) {
		// Now create and return a CursorLoader that will take care of
		// creating a Cursor for the data being displayed.
		return new CursorLoader(this, ContactsContract.Data.CONTENT_URI,
				PROJECTION, SELECTION, null, null);
	}

	// Called when a previously created loader has finished loading
	public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
		// Swap the new cursor in. (The framework will take care of closing the
		// old cursor once we return.)
		mAdapter.swapCursor(data);
	}

	// Called when a previously created loader is reset, making the data
	// unavailable
	public void onLoaderReset(Loader<Cursor> loader) {
		// This is called when the last Cursor provided to onLoadFinished()
		// above is about to be closed. We need to make sure we are no
		// longer using it.
		mAdapter.swapCursor(null);
	}

	public void onListItemClick(ListView l, View v, int position, long id) {
		// Do something when a list item is clicked
	}

	// @Override
	// public boolean onOptionsItemSelected(MenuItem item) {
	// switch (item.getItemId()) {
	// case android.R.id.home:
	// NavUtils.navigateUpFromSameTask(this);
	// return true;
	// }
	// return super.onOptionsItemSelected(item);
	// }

}
