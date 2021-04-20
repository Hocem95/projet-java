package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JFrame;


import config.GameConfiguration;
import engine.map.Block;
import engine.map.Map;
import engine.process.GameBuilder;
import engine.process.MobileElementManager;
import engine.entity.Pawn;


public class MainGUI extends JFrame implements Runnable {

	private static final long serialVersionUID = 1L;

	private Map map;

	private final static Dimension preferredSize = new Dimension(GameConfiguration.WINDOW_WIDTH, GameConfiguration.WINDOW_HEIGHT);

	private MobileElementManager manager;

	private GameDisplay dashboard;
	

	public MainGUI(String title) {
		super(title);
		init();
	}

	private void init() {

		Container contentPane = getContentPane();
		contentPane.setLayout(new BorderLayout());

		map = GameBuilder.buildMap();
		manager = GameBuilder.buildInitMobile(map);
		dashboard = new GameDisplay(map, manager);
		dashboard.setPreferredSize(preferredSize);
		MouseControls mouseControls = new MouseControls();
		dashboard.addMouseListener(mouseControls);
		contentPane.add(dashboard, BorderLayout.CENTER);
		
	    dashboard.setBackground(Color.GRAY); 
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		pack();
		setVisible(true);
		setPreferredSize(preferredSize);
		setResizable(false);
	}

	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(GameConfiguration.GAME_SPEED);
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}

			dashboard.repaint();
		}
	}
	
	public class MouseControls implements MouseListener {
		
		
		private Pawn selectedPawn = null;
		private Pawn targetPawn = null;
		private int inBlockAllyPawn = 0;

		
		@Override
		public void mouseClicked(MouseEvent e) {
		}
	
		
		
		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			int x = e.getX();
			int y = e.getY();
			x=(int) Math.floor(x/GameConfiguration.BLOCK_SIZE);
			y=(int) Math.floor(y/GameConfiguration.BLOCK_SIZE);
			ArrayList<Pawn> pawnsAlly = (ArrayList<Pawn>) manager.getPawnsAlly();
			ArrayList<Pawn> pawnsEnemy = (ArrayList<Pawn>) manager.getPawnsEnemy();
			if(selectedPawn==null) {
			for(int i=0;i< manager.getPawnsAlly().size();i++) {
					
				int pawnsAllyX = pawnsAlly.get(i).getPosition().getColumn();
				int pawnsAllyY = pawnsAlly.get(i).getPosition().getLine();
				
						if (pawnsAllyX==x && pawnsAllyY==y) {
								selectedPawn = pawnsAlly.get(i);
	
						
						}

				}
			
			for(int i=0;i< manager.getPawnsEnemy().size();i++) {
				
				int pawnsEnemyX = pawnsEnemy.get(i).getPosition().getColumn();
				int pawnsEnemyY = pawnsEnemy.get(i).getPosition().getLine();
	
				
					if (pawnsEnemyX==x && pawnsEnemyY==y) {
							targetPawn = pawnsEnemy.get(i);

					}

				}
		

		}
	}
					
		

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			int x = e.getX();
			int y = e.getY();
			
			x=(int) Math.floor(x/GameConfiguration.BLOCK_SIZE);
			y=(int) Math.floor(y/GameConfiguration.BLOCK_SIZE);
			
			ArrayList<Pawn> pawnsAlly = (ArrayList<Pawn>) manager.getPawnsAlly();
			ArrayList<Pawn> pawnsEnemy = (ArrayList<Pawn>) manager.getPawnsEnemy();
			
			for(int i=0;i< manager.getPawnsEnemy().size()-1;i++) {
	
				int pawnsEnemyX = pawnsEnemy.get(i).getPosition().getColumn();
				int pawnsEnemyY = pawnsEnemy.get(i).getPosition().getLine();
				
				
					if (pawnsEnemyX==x && pawnsEnemyY==y) {
							targetPawn = pawnsEnemy.get(i);

					}

				}
			for(int i=0;i< manager.getPawnsAlly().size();i++) {
				
				int pawnsAllyX = pawnsAlly.get(i).getPosition().getColumn();
				int pawnsAllyY = pawnsAlly.get(i).getPosition().getLine();
				
						if (pawnsAllyX==x && pawnsAllyY==y) {
								selectedPawn = pawnsAlly.get(i);
								inBlockAllyPawn+=1;
	
						
						}

				}
			
	
			if (this.selectedPawn.getPosition().getColumn()==x && this.selectedPawn.getPosition().getLine()==y-1
					 || this.selectedPawn.getPosition().getColumn()==x+1 && this.selectedPawn.getPosition().getLine()==y-1 
					 || this.selectedPawn.getPosition().getColumn()==x-1 && this.selectedPawn.getPosition().getLine()==y-1 
					 || this.selectedPawn.getPosition().getColumn()==x-1 && this.selectedPawn.getPosition().getLine()==y 
					 || this.selectedPawn.getPosition().getColumn()==x-1 && this.selectedPawn.getPosition().getLine()==y+1 
					 || this.selectedPawn.getPosition().getColumn()==x && this.selectedPawn.getPosition().getLine()==y+1 
					 || this.selectedPawn.getPosition().getColumn()==x+1 && this.selectedPawn.getPosition().getLine()==y 
					 || this.selectedPawn.getPosition().getColumn()==x+1 && this.selectedPawn.getPosition().getLine()==y+1 ) {
			
				if  (x<GameConfiguration.COLUMN_COUNT && y<GameConfiguration.LINE_COUNT && x!=1 && x!=7) {													
					if (targetPawn!=null) {	
						if (selectedPawn.isInRange(targetPawn)) {
							manager.confrontation(selectedPawn, targetPawn);
							selectedPawn=null;
							targetPawn=null;
							dashboard.repaint();
						}			
					}
				
				else{
					if (inBlockAllyPawn==1) {
						
					}
					else {
						selectedPawn.getPosition().setColumn(x);
						selectedPawn.getPosition().setLine(y);
						System.out.println(selectedPawn.getPosition());
						dashboard.repaint();
					}
				}
			}
		inBlockAllyPawn=0;				
		selectedPawn=null;
		dashboard.repaint();	
	
			}
		}	
	} 
}





