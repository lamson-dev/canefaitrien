package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import model.Person;
import controller.Controller;
import controller.Controller.Difficulty;

public class MainMenuPanel extends JPanel {
	
	private static final long serialVersionUID = 3701450891814698277L;
	
	JFrame frame;
	public MainMenuPanel(JFrame frame) {
		JButton button = new JButton("New Game");
		this.frame = frame;
		button.addActionListener(new NewGameListener(this));
		add(button);
	}
	
	private class NewGameListener implements ActionListener {
		
		private JPanel panel;
		public NewGameListener(JPanel panel) {
			this.panel = panel;
		}
		public void actionPerformed(ActionEvent e) {
			frame.remove(panel);
			//mainPanel.add(new CharacterCreationPanel(mainPanel));
			frame.add(new GamePanel(new Controller(new Person("Bob", 0, 0, 0, 0), Difficulty.Easy)));
			frame.revalidate();
			frame.pack();
		}
	}

}
