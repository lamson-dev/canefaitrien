// $codepro.audit.disable com.instantiations.assist.eclipse.analysis.audit.rule.effectivejava.alwaysOverridetoString.alwaysOverrideToString
/**
 * Custom View of Info Screen
 */

package com.canefaitrien.spacetrader;

import android.content.Context;
import android.graphics.Paint;
import android.view.View;

/**
 * @author Daniel
 * @version $Revision: 1.0 $
 */
public class InfoView extends View {
	/**
	 * Field paint.
	 */
	@SuppressWarnings("unused")
	private final Paint paint = new Paint();// normal paint // $codepro.audit.disable unusedField

	/**
	 * Constructor for InfoView.
	 * @param context Context
	 */
	public InfoView(Context context) {
		super(context);
	}

//	/**
//	 * Draw method called when created
//	 */
//	protected void onDraw(Canvas canvas) {
//		super.onDraw(canvas);
//
//	}
}
