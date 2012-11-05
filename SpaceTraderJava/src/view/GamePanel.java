package view;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import controller.Controller;

public class GamePanel extends JPanel {
	
	private static final long serialVersionUID = -3660935457643255856L;
	Controller data;
	
	public GamePanel(Controller data) {
		this.data = data;
		// tabs
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.BOTTOM);
		
		tabbedPane.addTab("Universe", new UniversePanel(data));
		tabbedPane.addTab("Info", new InfoPanel(data));		
		tabbedPane.addTab("Marketplace", new MarketplacePanel(data));
		tabbedPane.addTab("Options", new OptionsPanel(data));
		add(tabbedPane);
	}
}
