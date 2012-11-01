package view;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;


public class MainMenuPanel extends JPanel {
	
	private static final long serialVersionUID = 3701450891814698277L;
	
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
