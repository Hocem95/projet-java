package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class InfoZone extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private MainGUI main;
	private JLabel pionsRestant;
	
	public InfoZone(MainGUI main) {
		this.main = main;
		init();
	}
	
	private void init() {
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		pionsRestant = new JLabel();
		pionsRestant.setText("<html><h1>header1 text</h1></html>");
		this.add(pionsRestant);
		pionsRestant = new JLabel();
		pionsRestant.setText("<html><h1>header1 text</h1></html>");
		this.add(pionsRestant);
		
		
		this.setPreferredSize(new Dimension(400,800));
		this.setMinimumSize(new Dimension(400,400));
		this.setMaximumSize(new Dimension(400,900));
	}
	

}
