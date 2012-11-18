package com.canefaitrien.spacetrader.utils;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Tools {

	static AlertDialog.Builder popup;
	static LayoutInflater inflater;

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

	public static View inflater(Context context, int idChild,
			ViewGroup parentView) {
		inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

		// ViewGroup parentView = (RelativeLayout) findViewById(idParent);

		return inflater.inflate(idChild, parentView);
	}
}
