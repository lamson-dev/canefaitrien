package view;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import model.ShipType;
import model.ShipYard;
import model.ShipYardItem;
import model.Weapon;

import controller.Controller;

/**
 * Class for displaying the ship yard
 * 
 * @author An Pham
 * @version 1.0
 * @Date 11/17/12
 */

public class ShipYardPanel extends JPanel {

	private static final long serialVersionUID = -455183452223286075L;
	
	private Controller data;
	JLabel[][] labels;
	JLabel nameLabel, moneyLabel;
	JPanel panel = new JPanel();
	ShipYard shipYard;
	
	// 
	public ShipYardPanel(Controller data) {
		
		this.data = data;
		shipYard = new ShipYard(data);
		setup();
	}
	
	public void setup() {
		panel.removeAll();
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
		revalidate();
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
			JButton upgradeWeaponBtn = new JButton("Upgrade Weapon");
			upgradeWeaponBtn.addActionListener(new upgradeWeaponBtnListener());
			panel.add(upgradeWeaponBtn);
			JButton upgradeShieldBtn = new JButton("Upgrade Shield");
			upgradeShieldBtn.addActionListener(new upgradeShieldBtnListener());
			panel.add(upgradeShieldBtn);
			JButton upgradeGadgetBtn = new JButton("Upgrade Gadget");
			upgradeGadgetBtn.addActionListener(new upgradeGadgetBtnListener());
			panel.add(upgradeGadgetBtn);
			
			JButton cancelBtn = new JButton("Go Back");
			cancelBtn.addActionListener(new cancelBtnListener());

			panel.add(cancelBtn);
			
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
		
		JButton cancelBtn = new JButton("Go Back");
		cancelBtn.addActionListener(new cancelBtnListener());

		panel.add(cancelBtn);
		revalidate();
	}
	
	public class cancelBtnListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			setup();
		}
		
	}
	public class upgradeWeaponBtnListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			panel.removeAll();
			panel.setLayout(new GridLayout(0, 4));
			nameLabel = new JLabel("Ship " + data.getShip().getType());
			panel.add(nameLabel);
			JLabel playerLabel = new JLabel( data.getPlayer().getName());
			panel.add(playerLabel);
			moneyLabel = new JLabel("$" + data.getMoney());
			panel.add(moneyLabel);
			JLabel nothing = new JLabel("_");
			panel.add(nothing);
			List<Weapon> weaponsOnShip = data.getShip().getWeaponList();
			for(int i = 0; i<weaponsOnShip.size(); i++) {
				JLabel tempLbl = new JLabel(weaponsOnShip.get(i).toString());
				panel.add(tempLbl);
			}
			
			List<ShipYardItem> shipYardItems = shipYard.getShipYard();
			for (int i = 0; i<shipYardItems.size(); i++) {
				JLabel nameLbl = new JLabel(shipYardItems.get(i).getName().toString());
				panel.add(nameLbl);
				JLabel priceLbl = new JLabel("Price :"+shipYardItems.get(i).getPrice());
				panel.add(priceLbl);
				JLabel numberLbl = new JLabel("Available :" + shipYardItems.get(i).getQuantity());
				panel.add(numberLbl);
				JButton buyWeaponBtn = new JButton("Buy Weapon");
				buyWeaponBtn.addActionListener(new buyWeaponBtnListener(shipYardItems.get(i)));
				panel.add(buyWeaponBtn);
				
			}
			JButton cancelBtn = new JButton("Go Back");
			cancelBtn.addActionListener(new cancelBtnListener());

			panel.add(cancelBtn);
			revalidate();
		}
		
	}
	public class buyWeaponBtnListener implements ActionListener {
		
		private ShipYardItem item;
		private JFrame frame;
		public buyWeaponBtnListener(ShipYardItem item) {
			this.item = item;
		}

		@Override
		public void actionPerformed(ActionEvent arg0) {
			if (!data.getShip().checkWeaponExistence(item.getType())) {
				if (item.getPrice()>= data.getMoney()) {
					JOptionPane.showMessageDialog(frame,
							"Not enough money captain",
							"Warning",
							JOptionPane.WARNING_MESSAGE);
				}
				else {
					try {
						data.getShip().addWeapon((Weapon) item.getType());
						data.setMoney(data.getMoney() - item.getPrice());
						
						JOptionPane.showMessageDialog(frame,
								"Upgrade successful! your money now is "+data.getMoney(),
								"Warning",
								JOptionPane.WARNING_MESSAGE);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} 
					
				}
			}
			else {
				JOptionPane.showMessageDialog(frame,
					    "You have already had this",
					    "Warning",
					    JOptionPane.WARNING_MESSAGE);
			}
		}
		
	}
	public class upgradeGadgetBtnListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			setup();
		}
		
	}
	public class upgradeShieldBtnListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			setup();
		}
		
	}
}
