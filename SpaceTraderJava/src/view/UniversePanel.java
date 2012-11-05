package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import model.Planet;
import model.Ship;

import controller.Controller;

public class UniversePanel extends JPanel {

	private static final long serialVersionUID = -2657666322078794773L;
	private Controller data;
	
	public UniversePanel(Controller data) {
		this.data = data;
		setPreferredSize(new Dimension(600, 500));
		setBackground(Color.black);
		addMouseListener(new PlanetListener());
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.gray);
		for(Planet p : data.getUniverse().getPlanets()) {
			p.draw(g);
		}
		g.setColor(Color.white);
		data.getLocation().drawMain(g, data.getShip().getFuel()*Ship.MPG);
		
	}
	
	private class PlanetListener extends MouseAdapter {
		
		public void mouseClicked(MouseEvent e) {
			for(Planet p : data.getUniverse().getPlanets()) {
				if(p.getRectangle().contains(e.getPoint())) {
					System.out.println(p.getLocation().x + " " + p.getLocation().y);
					switch(JOptionPane.showConfirmDialog(null, p.distance(data.getLocation()) + " light years away.", "Planet " + p.getName(), JOptionPane.YES_NO_OPTION)) {
						case JOptionPane.YES_OPTION:
							//travel
							try {
								data.move(p);
								repaint();
							} catch(Exception ex) {
								JOptionPane.showMessageDialog(null, ex.getMessage());
							}
							
							break;
					}
				}
			}
		}
	}
}
