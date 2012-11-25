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
	public static AlertDialog.Builder alertDialog;

	/**
	 * Field inflater.
	 */
	public static LayoutInflater inflater;

	/**
	 * Method popUp.
	 * @param context Context
	 * @param message String
	 */
	public static void popUp(Context context, String message) {
		alertDialog = new AlertDialog.Builder(context);
		alertDialog.setTitle("Heyyy!");
		alertDialog.setMessage(message);
		alertDialog.setPositiveButton("Ok",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) { // $codepro.audit.disable emptyMethod
						// dismiss the dialog
					}
				});
		alertDialog.setCancelable(true);
		alertDialog.create().show();
	}

	/**
	 * Method inflater.
	 * @param context Context
	 * @param idChild int
	 * @param parentView ViewGroup
	
	 * @return View */
	public static View inflater(Context context, int idChild,
			ViewGroup parentView) {
		inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

		// ViewGroup parentView = (RelativeLayout) findViewById(idParent);

		return inflater.inflate(idChild, parentView);
	}
}
