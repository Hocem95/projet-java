package gui;

import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class InformationZone extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private MainGUI main;
	private JLabel timer, nbTour, pionsMort;
	
	public InformationZone(MainGUI main) {
		this.main = main;
		init();
	}
	
	private void init() {
		
		timer = new JLabel();
		timer.setText("<html><h1>Timer : </h1></html>");
		this.add(timer);
		
		nbTour = new JLabel();
		nbTour.setText("<html><h1>Nombre de tour : </h1></html>");
		this.add(nbTour);
		
		pionsMort = new JLabel();
		pionsMort.setText("<html><h1>Pions mort : </h1></html>");
		this.add(pionsMort);
		
		this.setPreferredSize(new Dimension(400,100));
		this.setMinimumSize(new Dimension(400,100));
		this.setMaximumSize(new Dimension(400,100));
	}
	

}
