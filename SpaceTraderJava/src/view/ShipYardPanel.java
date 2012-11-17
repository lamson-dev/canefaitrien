package view;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import model.Ship;
import model.ShipType;
import model.ShipYard;

import controller.Controller;

/**
 * Class for displaying the ship yard
 * 
 * @author An Pham (modified MarketPlace written by Andrew Duda)
 * @version 1.0
 * @Date 11/17/12
 */

public class ShipYardPanel extends JPanel {

	private static final long serialVersionUID = -455183452223286075L;
	
	private Controller data;
	JLabel[][] labels;
	JLabel nameLabel, moneyLabel;
	JPanel panel = new JPanel();
	
	public ShipYardPanel(Controller data) {
		this.data = data;
		
		panel.setLayout(new GridLayout(0, 3));
		setPreferredSize(new Dimension(600, 400));
		nameLabel = new JLabel("Ship " + data.getShip().getType());
		panel.add(nameLabel);
		JLabel playerLabel = new JLabel( data.getPlayer().getName());
		panel.add(playerLabel);
		moneyLabel = new JLabel("$" + data.getMoney());
		panel.add(moneyLabel);
		JButton upgradeBtn = new JButton("Upgrade");
		upgradeBtn.addActionListener(new upgradeBtnListener());
		panel.add(upgradeBtn);
		JButton newBtn = new JButton("New Ship");
		newBtn.addActionListener(new newBtnListener());
		panel.add(newBtn);
		add(panel);
	}
	
	public class upgradeBtnListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			panel.removeAll();
			nameLabel = new JLabel("Ship " + data.getShip().getType());
			panel.add(nameLabel);
			JLabel playerLabel = new JLabel( data.getPlayer().getName());
			panel.add(playerLabel);
			moneyLabel = new JLabel("$" + data.getMoney());
			panel.add(moneyLabel);
			JButton weaponBtn = new JButton("Upgrade Weapon");
			weaponBtn.addActionListener(new upgradeBtnListener());
			panel.add(weaponBtn);
			JButton shieldBtn = new JButton("Upgrade Shield");
			shieldBtn.addActionListener(new newBtnListener());
			panel.add(shieldBtn);
			JButton gadgetBtn = new JButton("Upgrade Gadget");
			gadgetBtn.addActionListener(new newBtnListener());
			panel.add(gadgetBtn);
			revalidate();
		}
		
	}
	public class newBtnListener implements ActionListener {

		JFrame frame;

		@Override
		public void actionPerformed(ActionEvent arg0) {
			JOptionPane.showMessageDialog(frame,
				    "You will lose all good in your cargo if you purchase a new ship!",
				    "Warning",
				    JOptionPane.WARNING_MESSAGE);
			
			setUpBuyShipView(panel);
		}
		
	}
	
	public class buyShipBtnListener implements ActionListener {
		
		ShipType type;
		JFrame frame;
		
		public buyShipBtnListener(ShipType type) {
			this.type = type;
		}

		@Override
		public void actionPerformed(ActionEvent arg0) {
			if (data.getMoney() < type.MAX_DISTANCE * 100) {
				JOptionPane.showMessageDialog(frame,
					    "Not enough money captain",
					    "Warning",
					    JOptionPane.WARNING_MESSAGE);
			}
			else {
				if (data.getShip().getType() == type) {
					JOptionPane.showMessageDialog(frame,
						    "You have already in this ship",
						    "Warning",
						    JOptionPane.WARNING_MESSAGE);
				}
				else {
					ShipYard shipYard = new ShipYard(data);
					shipYard.buyShip(type);

					JOptionPane.showMessageDialog(frame,
							"Ship Transferred. You are now using" + type,
							"Ship Transfer",
							JOptionPane.WARNING_MESSAGE);

					setUpBuyShipView(panel);
				}
			}
			
		}
		
	}
	
	// Set up the yard view
	public void setUpBuyShipView(JPanel panel) {
		panel.removeAll();
		panel.setLayout(new GridLayout(0, 3));
		//setPreferredSize(new Dimension(600, 400));
		nameLabel = new JLabel("Ship " + data.getShip().getType());
		panel.add(nameLabel);
		JLabel playerLabel = new JLabel( data.getPlayer().getName());
		panel.add(playerLabel);
		moneyLabel = new JLabel("$" + data.getMoney());
		panel.add(moneyLabel);
		
		
		ShipType[] shipTypes = ShipType.values();
		int[] shipPrice = new int[shipTypes.length];
		for (int i = 0; i<shipPrice.length; i++) 
			shipPrice[i] = shipTypes[i].MAX_DISTANCE * 100; // Price is calculated base on the max distance of each ship type
		
		for (int i = 0; i<shipPrice.length; i++) {
			panel.add(new JLabel(shipTypes[i].toString()));
			panel.add(new JLabel(""+shipPrice[i]));
			JButton buyBtn = new JButton("Buy");
			buyBtn.addActionListener(new buyShipBtnListener(shipTypes[i]));
			panel.add(buyBtn);
		}
		revalidate();
	}
}
