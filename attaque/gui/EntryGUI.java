package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class EntryGUI extends JFrame implements ActionListener {
	
	private JButton pedagogique, normal, leave;
	private Thread gameThread;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public EntryGUI(){
		super("Menu principal du Luzhanqi");
		init();
	}
	
	private void init() {
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//permet de fermer la fen�tre mais pas toute les fen�tre (si il y'a plusieurs fen�tre ouverte)
		this.setSize(600, 400);//taille de la fen�tre au d�marrage
		this.setLocationRelativeTo(null);//centre automotiquement la fen�tre au centre de l'�cran
		
		JPanel contenance = (JPanel) this.getContentPane();//permet de manipuler l'int�rieur de la fen�tre.
		contenance.setLayout(null);//La jvm me laisse g�rer l'emplacement des bouttons.
		//Cr�ation des boutons
		pedagogique = new JButton ("Mode P�dagogique");
		normal = new JButton ("Mode Normal");
		leave = new JButton ("Quitter le jeu");
		//Emplacement des bouttons
		pedagogique.setBounds(200,60,160,30);
		normal.setBounds(200, 110, 160, 30);
		leave.setBounds(200, 210, 160, 30);
		//Ajout des bouttons sur la fen�tre
		contenance.add(pedagogique);
		contenance.add(normal);
		contenance.add(leave);
		
		createListener();
	}
	
	private void createListener() {
		this.leave.addActionListener(this);
		this.normal.addActionListener(this);
		this.pedagogique.addActionListener(this);
	}
	
	public void open() {
		this.setVisible(true);
	}
	
	public void close() {
		this.setVisible(false);
		dispose();
	}

	@Override
	public void actionPerformed(ActionEvent click) {
		if (click.getSource() == pedagogique) {
			openMainGUI();
			this.setVisible(false);
		} else if (click.getSource() == normal) {
			openMainGUI();
			this.setVisible(false);
		} else if (click.getSource() == leave) {
			this.close();
		}
		
	}
	
	public void openMainGUI() {
		closeMainGUI();
		MainGUI game = new MainGUI("Mode p�dagogique", this);
		game.open();
		Thread gameThread = new Thread(game);
		gameThread.start();
	}
	
	public void closeMainGUI() {
		if (this.gameThread != null) {
			this.gameThread.interrupt();
			this.gameThread = null;
		}
	}

}
