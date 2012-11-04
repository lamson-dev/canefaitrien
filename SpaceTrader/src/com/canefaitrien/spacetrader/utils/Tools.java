package com.canefaitrien.spacetrader.utils;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

public class Tools {

	static AlertDialog.Builder popup;

	public static void popUp(Context context, String message) {
		popup = new AlertDialog.Builder(context);
		popup.setTitle("Heyyy!");
		popup.setMessage(message);
		popup.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				// dismiss the dialog
			}
		});
		popup.setCancelable(true);
		popup.create().show();
	}
}
