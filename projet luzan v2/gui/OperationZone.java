package gui;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

public class OperationZone extends JPanel implements ActionListener {
	
	private static final long serialVersionUID = 1L;

	private MainGUI main;
	private JButton restart, leave, nextTurn;
	
	public OperationZone(MainGUI main) {
		this.main = main;
		init();
	}
	
	private void init() {
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.add(new JPanel());
		this.add(new JPanel());
		this.add(new JPanel());

		this.restart = new JButton("Recommencer");
		this.add(this.restart);
		
		this.leave = new JButton("Quitter la partie");
		this.add(this.leave);
		
		this.nextTurn = new JButton("Passer son tour");
		this.add(this.nextTurn);
		
		this.add(new InfoZone(this.main));
		
		this.setPreferredSize(new Dimension(400,800));
		this.setMinimumSize(new Dimension(400,400));
		this.setMaximumSize(new Dimension(400,900));
		
		this.createListener();
	}
	
	private void createListener() {
		this.restart.addActionListener(this);
		this.leave.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent click) {
		if (click.getSource() == this.restart) {
			main.reset();
		} else if (click.getSource() == this.leave) {
			main.close(true);
		} else if (click.getSource() == this.nextTurn) {
			System.out.println("Next turn");
		}
	}
}
