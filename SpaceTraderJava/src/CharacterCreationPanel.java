import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import models.GameData;
import models.GameData.Difficulty;
import models.Character;


public class CharacterCreationPanel extends JPanel {
	
	JPanel mainPanel;
	public CharacterCreationPanel(JPanel panel) {
		JButton button = new JButton("Go To Marketplace");
		this.mainPanel = panel;
		button.addActionListener(new ButtonListener());
		add(button);
	}
	
	private class ButtonListener implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			mainPanel.removeAll();
			mainPanel.add(new MarketplacePanel(new GameData(new Character("Bob", 0, 0, 0, 0), Difficulty.Easy)));
			mainPanel.revalidate();
		}
	}

}
