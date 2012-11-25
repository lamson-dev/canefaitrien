// $codepro.audit.disable com.instantiations.assist.eclipse.analysis.audit.rule.effectivejava.alwaysOverridetoString.alwaysOverrideToString
/**
 * utilities tools for application
 */
package com.canefaitrien.spacetrader.utils;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * @author Son Nguyen
 * @version $Revision: 1.0 $
 */
public class Tools {

	/**
	 * Field alertDialog.
	 */
	public static AlertDialog.Builder ALERT_DIALOG;

	/**
	 * Field inflater.
	 */
	public static LayoutInflater INFLATOR;

	/**
	 * Method popUp.
	 * @param context Context
	 * @param message String
	 */
	public static void popUp(Context context, String message) {
		ALERT_DIALOG = new AlertDialog.Builder(context);
		ALERT_DIALOG.setTitle("Heyyy!");
		ALERT_DIALOG.setMessage(message);
		ALERT_DIALOG.setPositiveButton("Ok",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) { // $codepro.audit.disable emptyMethod
						// dismiss the dialog
					}
				});
		ALERT_DIALOG.setCancelable(true);
		ALERT_DIALOG.create().show();
	}

	/**
	 * Method inflater.
	 * @param context Context
	 * @param idChild int
	 * @param parentView ViewGroup
	
	 * @return View */
	public static View inflater(Context context, int idChild,
			ViewGroup parentView) {
		INFLATOR = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

		// ViewGroup parentView = (RelativeLayout) findViewById(idParent);

		return INFLATOR.inflate(idChild, parentView);
	}
}
