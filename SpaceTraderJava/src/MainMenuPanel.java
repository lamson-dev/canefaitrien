import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import models.GameData;
import models.GameData.Difficulty;
import models.Character;


public class MainMenuPanel extends JPanel {
	
	JPanel mainPanel;
	public MainMenuPanel(JPanel panel) {
		JButton button = new JButton("New Game");
		this.mainPanel = panel;
		button.addActionListener(new ButtonListener());
		add(button);
	}
	
	private class ButtonListener implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			mainPanel.removeAll();
			mainPanel.add(new CharacterCreationPanel(mainPanel));
			mainPanel.revalidate();
		}
	}

}
