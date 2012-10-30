import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import models.Character;
import models.GameData;
import models.TradeGood;
import models.GameData.Difficulty;


public class MarketplacePanel extends JPanel {

	private GameData data;
	JLabel[][] labels;
	JLabel nameLabel, moneyLabel;
	public MarketplacePanel(GameData data) {
		this.data = data;
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(11, 7));
		setPreferredSize(new Dimension(600, 500));
		
		String[][] view = data.getLocation().getMarketplace().getView(data.getShip());
		labels = new JLabel[view.length][view[0].length];
		TradeGood[] goods = TradeGood.values();
		
		panel.add(new JLabel("Trade Good"));
		panel.add(new JLabel("Buy Price"));
		panel.add(new JLabel("Sell Price"));
		panel.add(new JLabel("Available"));
		panel.add(new JLabel("Owned"));
		panel.add(new JLabel("Buy"));
		panel.add(new JLabel("Sell"));
		for(int i = 0; i < view.length; i++) {
			for(int j = 0; j < view[i].length; j++) {
				labels[i][j] = new JLabel(view[i][j]);
				panel.add(labels[i][j]);
			}
			JButton button = new JButton("Buy");
			button.addActionListener(new BuyListener(goods[i]));
			panel.add(button);
			button = new JButton("Sell");
			button.addActionListener(new SellListener(goods[i]));
			panel.add(button);
		}
		add(new JLabel("Planet " + data.getLocation().getName()));
		add(new JLabel(data.getPlayer().getName()));
		moneyLabel = new JLabel("$" + data.getMoney());
		add(moneyLabel);
		add(panel);
	}
	
	public void updateGoods() {
		String[][] view = data.getLocation().getMarketplace().getView(data.getShip());
		for(int i = 0; i < view.length; i++) {
			for(int j = 0; j < view[i].length; j++) {
				labels[i][j].setText(view[i][j]);
			}
		}
		moneyLabel.setText("$" + data.getMoney());
	}
	
	private class BuyListener implements ActionListener {
		
		TradeGood good;
		
		public BuyListener(TradeGood good) {
			this.good = good;
		}
		
		public void actionPerformed(ActionEvent e) {
			try {
				data.setMoney(data.getLocation().getMarketplace().buyGood(good, data.getShip(), data.getMoney()));
				updateGoods();
			} catch (Exception ex) {
				
			}
		}
	}

	private class SellListener implements ActionListener {
	
	TradeGood good;
	
	public SellListener(TradeGood good) {
		this.good = good;
	}
	
	public void actionPerformed(ActionEvent e) {
		try {
			data.setMoney(data.getLocation().getMarketplace().sellGood(good, data.getShip(), data.getMoney()));
			updateGoods();
		} catch (Exception ex) {
			
		}
	}
}
}
