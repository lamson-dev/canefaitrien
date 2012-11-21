package com.canefaitrien.spacetrader.utils;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Tools {

	public static AlertDialog.Builder alertDialog;

	public static LayoutInflater inflater;

	public static void popUp(Context context, String message) {
		alertDialog = new AlertDialog.Builder(context);
		alertDialog.setTitle("Heyyy!");
		alertDialog.setMessage(message);
		alertDialog.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				// dismiss the dialog
			}
		});
		alertDialog.setCancelable(true);
		alertDialog.create().show();
	}

	public static View inflater(Context context, int idChild,
			ViewGroup parentView) {
		inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

		// ViewGroup parentView = (RelativeLayout) findViewById(idParent);

		return inflater.inflate(idChild, parentView);
	}
}
