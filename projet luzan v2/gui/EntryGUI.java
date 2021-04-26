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
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//permet de fermer la fenêtre mais pas toute les fenêtre (si il y'a plusieurs fenêtre ouverte)
		this.setSize(600, 400);//taille de la fenêtre au démarrage
		this.setLocationRelativeTo(null);//centre automotiquement la fenêtre au centre de l'écran
		
		JPanel contenance = (JPanel) this.getContentPane();//permet de manipuler l'intérieur de la fenêtre.
		contenance.setLayout(null);//La jvm me laisse gérer l'emplacement des bouttons.
		//Création des boutons
		pedagogique = new JButton ("Mode Pédagogique");
		normal = new JButton ("Mode Normal");
		leave = new JButton ("Quitter le jeu");
		//Emplacement des bouttons
		pedagogique.setBounds(200,60,160,30);
		normal.setBounds(200, 110, 160, 30);
		leave.setBounds(200, 210, 160, 30);
		//Ajout des bouttons sur la fenêtre
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
		MainGUI game = new MainGUI("Mode pédagogique", this);
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
