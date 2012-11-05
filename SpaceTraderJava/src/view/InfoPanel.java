package view;

import java.awt.Dimension;

import javax.swing.JPanel;

import controller.Controller;

public class InfoPanel extends JPanel {

	private Controller data;
	
	public InfoPanel(Controller data) {
		this.data = data;
		setPreferredSize(new Dimension(600, 500));
	}
}
