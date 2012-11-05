package view;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Java class to run the java game
 * 
 * @author andrew
 *
 */
public class SpaceTrader {
	boolean mainMenuVisible = false;
	
	public static void main(String[] args) {
		JFrame frame = new JFrame("Space Trader");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.add(new MainMenuPanel(frame));
		
		frame.pack();
		frame.setVisible(true);
	}
}
