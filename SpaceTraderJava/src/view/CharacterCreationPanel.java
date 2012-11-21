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
	Controller controller = new Controller(new Person("Bob", 0, 0, 0, 0), Difficulty.Easy);// This is added by An Pham on 11/04/12
	JPanel mainPanel;
	public CharacterCreationPanel(JPanel panel) {
		JButton button = new JButton("Start");
		this.mainPanel = panel;
		button.addActionListener(new ButtonListener());
		add(button);
		JButton travelButton = new JButton("Travel");// This is added by An Pham on 11/04/12
		travelButton.addActionListener(new TravelButtonListener());// This is added by An Pham on 11/04/12
		add(travelButton);// This is added by An Pham on 11/04/12
	}
	
	private class ButtonListener implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			mainPanel.removeAll();
			mainPanel.add(new GamePanel(new Controller(new Person("Bob", 0, 0, 0, 0), Difficulty.Easy)));
			mainPanel.revalidate();
		}
	}
	
	// Below is added by An Pham on 11/04/12
	private class TravelButtonListener implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			try {
				controller.move(controller.getUniverse()[0]);
			} catch(Exception ex) {
				ex.printStackTrace();
			}
		}
	}

}
