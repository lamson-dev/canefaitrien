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
import javax.swing.JLabel;
import javax.swing.JPanel;
import model.EncounterType;


import controller.Controller;

public class TravelPanel extends JPanel {

	private static final long serialVersionUID = -4315002591794574841L;
	
	private Controller data;
	JPanel panel = new JPanel(new BorderLayout());
	JButton resetBtn = new JButton("Reset");
	
	public TravelPanel(Controller data) {

		this.data = data;
		

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
				JButton attackPoliceButton = new JButton("Attack");
				JButton fleePoliceButton = new JButton("Flee");
				JButton submitButton = new JButton("Submit");
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
	}
}