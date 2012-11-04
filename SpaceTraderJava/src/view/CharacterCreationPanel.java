package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import controller.Controller;
import controller.Controller.Difficulty;

import model.Person;


public class CharacterCreationPanel extends JPanel {
	
	private static final long serialVersionUID = 1227113222169913502L;
	
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
			mainPanel.add(new GamePanel(new Controller(new Person("Bob", 0, 0, 0, 0), Difficulty.Easy)));
			mainPanel.revalidate();
		}
	}

}
