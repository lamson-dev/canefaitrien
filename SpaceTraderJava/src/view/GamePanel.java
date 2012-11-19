package view;

import javax.swing.JTabbedPane;
import controller.Controller;

public class GamePanel extends JTabbedPane {
	
	private static final long serialVersionUID = -3660935457643255856L;
	Controller data;
	
	public GamePanel(Controller data) {
		this.data = data;
		// tabs
		//JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.BOTTOM);
		MarketplacePanel mp = new MarketplacePanel(data);
		ShipYardPanel shipYardPanel = new ShipYardPanel(data);
		addTab("Universe", new UniversePanel(data, mp, shipYardPanel));
		addTab("Info", new InfoPanel(data));		
		addTab("Marketplace", mp);
		addTab("Options", new OptionsPanel(data));
		addTab("ShipYard", shipYardPanel);
	}
}
