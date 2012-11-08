package view;
/**
 * Travel Panel
 * @author An Pham
 * @Date 11/04/12
 * @version 1.0
 */
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import model.EncounterHandler;
import model.EncounterType;
import controller.Controller;

public class TravelPanel extends JPanel {

	private static final long serialVersionUID = -4315002591794574841L;
	
	private Controller data;
	private MarketplacePanel mp;
	JPanel panel = new JPanel(new BorderLayout());
	JButton resetBtn = new JButton("Reset");
	EncounterHandler encounter;
	
	public TravelPanel(Controller data, MarketplacePanel mp) {

		this.data = data;
		this.mp = mp;
		encounter = new EncounterHandler(data);

		panel.setLayout(new GridLayout(11, 7));
		setPreferredSize(new Dimension(600, 400));
		JButton travelButton = new JButton("Travel");
		panel.add(travelButton);
		travelButton.addActionListener(new TravelButtonListener());
		resetBtn.addActionListener(new TravelButtonListener());
		add(panel);
	}
	private class TravelButtonListener implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			EncounterType encounter = EncounterType.getEncounterType();
			System.out.println(encounter);
			switch (encounter) {
			case POLICE:
				JLabel police = new JLabel("Police Encounter");
				JButton bribeButton = new JButton("Bribe");
				bribeButton.addActionListener(new bribeButtonListener());
				JButton attackPoliceButton = new JButton("Attack");
				attackPoliceButton.addActionListener(new attackPoliceButtonListener());
				
				JButton fleePoliceButton = new JButton("Flee");
				JButton submitButton = new JButton("Submit");
				submitButton.addActionListener(new submitButtonListener());
				panel.removeAll();
				panel.add(police);
				panel.add(bribeButton, BorderLayout.PAGE_END);
				panel.add(attackPoliceButton, BorderLayout.PAGE_END);
				panel.add(fleePoliceButton, BorderLayout.PAGE_END);
				panel.add(submitButton, BorderLayout.PAGE_END);
				panel.add(resetBtn);
				
				revalidate();
				
				break;
			case PIRATE:
				JLabel pirate = new JLabel("Pirate Encounter");
				JButton attackPirateButton = new JButton("Attack");
				JButton fleePirateButton = new JButton("Flee");
				JButton surrenderButton = new JButton("Surrender");
				panel.removeAll();
				panel.add(pirate);
				panel.add(attackPirateButton, BorderLayout.PAGE_END);
				panel.add(fleePirateButton, BorderLayout.PAGE_END);
				panel.add(surrenderButton, BorderLayout.PAGE_END);
				panel.add(resetBtn);
				
				revalidate();
				break;
			case TRADER:
				JLabel trader= new JLabel("Trader Encounter");
				JButton attackTraderButton = new JButton("Attack");
				JButton ignoreButton = new JButton("Ignore");
				JButton tradeButton = new JButton("Trade");
				panel.removeAll();
				panel.add(trader);
				panel.add(attackTraderButton, BorderLayout.PAGE_END);
				panel.add(ignoreButton, BorderLayout.PAGE_END);
				panel.add(tradeButton, BorderLayout.PAGE_END);
				panel.add(resetBtn);
				
				revalidate();
				break;
			default:
				break;
			}
		}
		private class bribeButtonListener implements ActionListener {

			@Override
			public void actionPerformed(ActionEvent e) {
				JFrame bribeFrame = new JFrame("Bad Bribe Money");
				String text;
				boolean isNumber = false;
				int bribeAmount = 0;
				do {
					text = JOptionPane.showInputDialog(bribeFrame, "How much do you decide to bribe?");
					try  
					{  
						bribeAmount = Integer.parseInt( text );  
						isNumber = true;  
					}  
					catch( Exception ex)  
					{  
						isNumber = false;  
					}  
					
					boolean success = encounter.bribePolice(bribeAmount);
					if (success) {	
						JOptionPane.showMessageDialog(bribeFrame, 
								"Bribe Successful!. Your money now is " + data.getMoney());
						break;
					}
					else {
						JOptionPane.showMessageDialog(bribeFrame, 
								"Bribe Failed!. Your money now is " + data.getMoney());
						continue;
					}

				}while (isNumber == true);	
				
				mp.changeMarketplace();
				mp.repaint();
			}
			
		}
		private class submitButtonListener implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent e) {
				int currentCredit = data.getMoney();
				if (encounter.submitPolice()) 
					JOptionPane.showMessageDialog(
							panel, "Sorry for wasting your time! You are free to go.");
				else
					JOptionPane.showMessageDialog(
							panel, "You have illegal goods in your cargo. A fine of "+ (currentCredit-data.getMoney())+
									" has been charged to your bank account.\n");
				
				mp.changeMarketplace();
				mp.repaint();
			}
			
		}
		private class attackPoliceButtonListener implements ActionListener {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (encounter.attackPolice()) 
					JOptionPane.showMessageDialog(
							panel, "Congratulation, you have destroyed a police ship");
				else
					JOptionPane.showMessageDialog(
						panel, "Sorry Game Over.");
				mp.changeMarketplace();
				mp.repaint();
			}
			
		}
	}
}