// $codepro.audit.disable obsoleteModifierUsage
/**
 * interface for configuration screen
 */
package com.canefaitrien.spacetrader.interfaces;

import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

/**
 * 
 * @author Son Nguyen
 *
 * @version $Revision: 1.0 $
 */
public interface IConfigurationView {
	/**
	 * Method getBarPilot.
	 * @return SeekBar
	 */
	public SeekBar getBarPilot();

	/**
	 * Method setBarPilot.
	 * @param barPilot SeekBar
	 */
	public void setBarPilot(SeekBar barPilot);

	/**
	 * Method getBarFighter.
	 * @return SeekBar
	 */
	public SeekBar getBarFighter();

	/**
	 * Method setBarFighter.
	 * @param barFighter SeekBar
	 */
	public void setBarFighter(SeekBar barFighter);

	/**
	 * Method getBarTrader.
	 * @return SeekBar
	 */
	public SeekBar getBarTrader();

	/**
	 * Method setBarTrader.
	 * @param barTrader SeekBar
	 */
	public void setBarTrader(SeekBar barTrader);

	/**
	 * Method getBarEngineer.
	 * @return SeekBar
	 */
	public SeekBar getBarEngineer();

	/**
	 * Method setBarEngineer.
	 * @param barEngineer SeekBar
	 */
	public void setBarEngineer(SeekBar barEngineer);
	
	/**
	 * Method getEditName.
	 * @return EditText
	 */
	public EditText getEditName();
	
	/**
	 * Method setEditName.
	 * @param editName EditText
	 */
	public void setEditName(EditText editName);
	
	/**
	 * Method getTxtViewLevel.
	 * @return TextView
	 */
	public TextView getTxtViewLevel();
	
	/**
	 * Method setTxtViewLevel.
	 * @param level TextView
	 */
	public void setTxtViewLevel(TextView level);
}
