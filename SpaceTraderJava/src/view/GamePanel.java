package view;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingUtilities;

import controller.Controller;

public class GamePanel extends JTabbedPane {
	
	private static final long serialVersionUID = -3660935457643255856L;
	Controller data;
	
	public GamePanel(Controller data) {
		this.data = data;
		// tabs
		//JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.BOTTOM);
		MarketplacePanel mp = new MarketplacePanel(data);
		addTab("Universe", new UniversePanel(data, mp));
		addTab("Info", new InfoPanel(data));		
		addTab("Marketplace", mp);
		addTab("Options", new OptionsPanel(data));
		addTab("Travel", new TravelPanel(data));
	}
}
