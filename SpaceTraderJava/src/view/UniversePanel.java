package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

import model.Planet;

import controller.Controller;

public class UniversePanel extends JPanel {

	private static final long serialVersionUID = -2657666322078794773L;
	private Controller data;
	
	public UniversePanel(Controller data) {
		this.data = data;
		setPreferredSize(new Dimension(600, 500));
		setBackground(Color.white);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		for(Planet p : data.getUniverse().getPlanets()) {
			p.draw(g);
			
		}
	}
}
