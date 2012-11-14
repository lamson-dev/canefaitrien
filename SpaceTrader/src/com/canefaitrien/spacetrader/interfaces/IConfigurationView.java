package com.canefaitrien.spacetrader.interfaces;

import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

public interface IConfigurationView {
	public SeekBar getBarPilot();

	public void setBarPilot(SeekBar barPilot);

	public SeekBar getBarFighter();

	public void setBarFighter(SeekBar barFighter);

	public SeekBar getBarTrader();

	public void setBarTrader(SeekBar barTrader);

	public SeekBar getBarEngineer();

	public void setBarEngineer(SeekBar barEngineer);
	
	public EditText getEditName();
	
	public void setEditName(EditText editName);
	
	public TextView getTxtViewLevel();
	
	public void setTxtViewLevel(TextView level);
}
