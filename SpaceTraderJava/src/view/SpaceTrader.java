package view;



import javax.swing.JFrame;


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
