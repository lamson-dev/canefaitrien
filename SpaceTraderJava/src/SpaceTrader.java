import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class SpaceTrader {
	boolean mainMenuVisible = false;
	
	public static void main(String[] args) {
		JFrame frame = new JFrame("Space Trader");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(600, 500));
		panel.add(new MainMenuPanel(panel));
		frame.add(panel);
		
		frame.pack();
		frame.setVisible(true);
	}
}
