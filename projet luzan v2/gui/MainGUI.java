package gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JFrame;

import config.GameConfiguration;
import engine.map.Map;
import engine.process.GameBuilder;
import engine.process.MobileElementManager;
import engine.entity.Pawn;

public class MainGUI extends JFrame implements Runnable {

	private static final long serialVersionUID = 1L;

	private EntryGUI mainMenu;
	
	private Map map;

	private final static Dimension preferredSize = new Dimension(GameConfiguration.WINDOW_WIDTH,
			GameConfiguration.WINDOW_HEIGHT);

	private MobileElementManager manager;

	private GameDisplay dashboard;
	
	private int lap_counter=0;

	public MainGUI(String title, EntryGUI mainMenu) {
		super(title);
		this.mainMenu = mainMenu;
		init();
	}
	
	public void reset() {
		this.mainMenu.openMainGUI();
		this.close(false);
	}
	
	private void init() {

		Container contentPane = getContentPane();
		contentPane.setLayout(new BorderLayout());
		
		map = GameBuilder.buildMap();
		manager = GameBuilder.buildInitMobile(map);
		
		initCenter();
		
		initBottom();
		
		initRight();
		
		dashboard.setBackground(Color.GRAY);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		pack();
		setPreferredSize(preferredSize);
		setResizable(false);
	}
	
	private void initCenter() {
		Container contentPane = getContentPane();
		
		dashboard = new GameDisplay(map, manager);
		dashboard.setPreferredSize(preferredSize);
		MouseControls mouseControls = new MouseControls();
		dashboard.addMouseListener(mouseControls);
		contentPane.add(dashboard, BorderLayout.CENTER);
	}
	
	public void initBottom() {
		Container contentPane = getContentPane();
		
		contentPane.add(new InformationZone(this), BorderLayout.SOUTH);
	}
	
	private void initRight() {
		Container contentPane = getContentPane();
		contentPane.add(new OperationZone(this), BorderLayout.EAST);
	}
	
	public void open() {
		setVisible(true);
	}
	
	public void close(boolean openMain) {
		setVisible(false);
		if (openMain) {
			this.mainMenu.open();
		}
		dispose();
		this.mainMenu.closeMainGUI();
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
		private Boolean IsOnLineRailWay = false;
		private Boolean IsOnCornerRailWay = false;
		private Boolean IsOnColumnRailWay = false;

		private Pawn selectedPawn = null;
		private Pawn targetPawn = null;
		private int inBlockAllyPawn = 0;
		private int lap_counter=0;
		private Boolean autorisation_shot = false;

		@Override
		public void mouseClicked(MouseEvent e) {
			
			int x = e.getX();
			int y = e.getY();
			x = (int) Math.floor(x / GameConfiguration.BLOCK_SIZE);
			y = (int) Math.floor(y / GameConfiguration.BLOCK_SIZE);
			ArrayList<Pawn> pawnsAlly = (ArrayList<Pawn>) manager.getPawnsAlly();
			ArrayList<Pawn> pawnsEnemy = (ArrayList<Pawn>) manager.getPawnsEnemy();
			
			
			
			//premier click sous validation 
			
			if (selectedPawn == null ) {
				for (int i = 0; i < manager.getPawnsAlly().size(); i++) {

					int pawnsAllyX = pawnsAlly.get(i).getPosition().getColumn();
					int pawnsAllyY = pawnsAlly.get(i).getPosition().getLine();

					if (pawnsAllyX == x && pawnsAllyY == y) {
						selectedPawn = pawnsAlly.get(i);

						if ((pawnsAllyY == 1 && pawnsAllyX > 1 && pawnsAllyX < 7)
								|| (pawnsAllyY == 5 && pawnsAllyX < 1 && pawnsAllyX > 7 && pawnsAllyX != 4)
								|| (pawnsAllyY == 7 && pawnsAllyX > 1 && pawnsAllyX < 7 && pawnsAllyX != 4)
								|| (pawnsAllyY == 11 && pawnsAllyX > 1 && pawnsAllyX < 7)) {
							
							this.IsOnLineRailWay = true;
							System.out.println("en ligne");

						} else if ((pawnsAllyX == 2 && (pawnsAllyY == 1 ||  pawnsAllyY == 5))
								|| (pawnsAllyX == 2 && (pawnsAllyY == 7 ||  pawnsAllyY == 11))
								|| (pawnsAllyX == 6 && (pawnsAllyY == 1 || pawnsAllyY == 5)
								|| (pawnsAllyX == 6 && (pawnsAllyY == 7 || pawnsAllyY == 11)))) {
							this.IsOnCornerRailWay = true;
							System.out.println(this.IsOnCornerRailWay);

						} else if ((pawnsAllyX == 2 && pawnsAllyY != 1 && pawnsAllyY != 5 && pawnsAllyY != 7
								&& pawnsAllyY != 11)
								|| (pawnsAllyX == 6 && pawnsAllyY != 1 && pawnsAllyY != 5 && pawnsAllyY != 7
										&& pawnsAllyY != 11)) {
							this.IsOnColumnRailWay = true;
							System.out.println("en colonne");
						}
					}

				}

				for (int i = 0; i < manager.getPawnsEnemy().size(); i++) {

					int pawnsEnemyX = pawnsEnemy.get(i).getPosition().getColumn();
					int pawnsEnemyY = pawnsEnemy.get(i).getPosition().getLine();

					if (pawnsEnemyX == x && pawnsEnemyY == y) {
						targetPawn = pawnsEnemy.get(i);

					}

				}
			

			}
			// deuxieme click
			else if ((this.selectedPawn.getPosition().getColumn()==x && this.selectedPawn.getPosition().getLine() == y)) {
					this.selectedPawn=null;
				}
			else if (this.selectedPawn!=null ) {
				
			
				for (int i = 0; i < manager.getPawnsEnemy().size() - 1; i++) {

					int pawnsEnemyX = pawnsEnemy.get(i).getPosition().getColumn();
					int pawnsEnemyY = pawnsEnemy.get(i).getPosition().getLine();

					if (pawnsEnemyX == x && pawnsEnemyY == y) {
						targetPawn = pawnsEnemy.get(i);

					}
					
					

				}
				for (int i = 0; i < manager.getPawnsAlly().size(); i++) {

					int pawnsAllyX = pawnsAlly.get(i).getPosition().getColumn();
					int pawnsAllyY = pawnsAlly.get(i).getPosition().getLine();

					if (pawnsAllyX == x && pawnsAllyY == y) {
						selectedPawn = pawnsAlly.get(i);
						inBlockAllyPawn += 1;

					}
					if (pawnsAlly.get(i).getPosition().getLine()>4 && pawnsAlly.get(i).getIsAlreadyBuffed()==false) {
						pawnsAlly.get(i).setRank(pawnsAlly.get(i).getRank()+2);
						pawnsAlly.get(i).setIsAlreadyBuffed(true);
					}
					

					

				
				}
				if (selectedPawn.getName().equals("Boat") ) {
					if (this.selectedPawn.getPosition().getLine() < 13 && this.selectedPawn.getPosition().getLine() >=1  ) {
						if(x==0 && (this.selectedPawn.getPosition().getLine()==y-1)||(this.selectedPawn.getPosition().getLine()==y+1)) {
						selectedPawn.getPosition().setColumn(x);
						selectedPawn.getPosition().setLine(y);
						lap_counter++;
						}
					}
					
					 if (selectedPawn.getPosition().getColumn()==0 && x==2 && autorisation_shot==true
						&& y!=1 && y!=0 && y!=11 && y!=12){
					manager.boatShoot(selectedPawn, targetPawn);
					autorisation_shot=false;
					
					lap_counter++;
					}  
					
					selectedPawn=null;
					targetPawn=null;
					
					
				}
				
				

				else if ((this.IsOnColumnRailWay == true && this.selectedPawn.getPosition().getColumn() == 2
						&& this.selectedPawn.getPosition().getLine() < 12 && this.selectedPawn.getPosition().getLine() > 0)
						|| (this.IsOnColumnRailWay == true && this.selectedPawn.getPosition().getColumn() == 6
								&& this.selectedPawn.getPosition().getLine() < 12
								&& this.selectedPawn.getPosition().getLine() > 0)) {

					if (y<13 && y>-1 && x<7 && x>1 &&((x == 2 && this.selectedPawn.getPosition().getColumn() == 2|| x==3 && this.selectedPawn.getPosition().getColumn() == 2 )
							||( x == 6 && this.selectedPawn.getPosition().getColumn() == 6 || x==5 && this.selectedPawn.getPosition().getColumn() == 6) )) {
						if (targetPawn != null) {
							if (selectedPawn.isInRange(targetPawn)) {
								manager.confrontation(selectedPawn, targetPawn);
								selectedPawn = null;
								targetPawn = null;
								this.IsOnColumnRailWay = false;
								
								
							}
						}

						else {
							if (inBlockAllyPawn == 1) {

							} else {
								selectedPawn.getPosition().setColumn(x);
								selectedPawn.getPosition().setLine(y);
								System.out.println(selectedPawn.getPosition());
								
							}
						}
					}
					inBlockAllyPawn = 0;
					selectedPawn = null;
					this.IsOnColumnRailWay = false;
					lap_counter++;
					
					

				}
				
				else if ((this.IsOnCornerRailWay == true && this.selectedPawn.getPosition().getColumn() == 2
						&& this.selectedPawn.getPosition().getLine() < 12
						&& this.selectedPawn.getPosition().getLine() > 0)
						||(this.IsOnCornerRailWay == true && this.selectedPawn.getPosition().getColumn()>1
						&& this.selectedPawn.getPosition().getColumn()<7
						&& this.selectedPawn.getPosition().getLine()==5)					
						|| (this.IsOnCornerRailWay == true && this.selectedPawn.getPosition().getColumn() == 6
						&& this.selectedPawn.getPosition().getLine() < 12
						&& this.selectedPawn.getPosition().getLine() > 0) ) {
					
					if ( (x == 2 && this.selectedPawn.getPosition().getColumn() == 2
							|| y==5 && x<7 && x>1 || y==1 && x<7 && x>1 || y==7 && x<7 && x>1 || y==11 && x<7 && x>1
							|| x == 6 && this.selectedPawn.getPosition().getColumn() == 6  )
							|| x==3 && this.selectedPawn.getPosition().getColumn() == 2
							|| x==5 && this.selectedPawn.getPosition().getColumn() == 6) {
						if (targetPawn != null) {
							if (selectedPawn.isInRange(targetPawn)) {
								if (this.selectedPawn.getPosition().getLine()>4 && this.selectedPawn.getIsAlreadyBuffed()==false) {
									this.selectedPawn.setRank(this.selectedPawn.getRank()+2);
									this.selectedPawn.setIsAlreadyBuffed(true);
								}
								manager.confrontation(selectedPawn, targetPawn);
								selectedPawn = null;
								targetPawn = null;
								this.IsOnCornerRailWay = false;
								
								
							}
						}

						else {
							if (inBlockAllyPawn == 1) {

							} else {
								if (this.selectedPawn.getPosition().getLine()>4 && this.selectedPawn.getIsAlreadyBuffed()==false) {
									this.selectedPawn.setRank(this.selectedPawn.getRank()+2);
									this.selectedPawn.setIsAlreadyBuffed(true);
								}
								selectedPawn.getPosition().setColumn(x);
								selectedPawn.getPosition().setLine(y);
								System.out.println(this.selectedPawn.getRank());
								System.out.println(selectedPawn.getPosition());
								
							}
						}
					}
					inBlockAllyPawn = 0;
					selectedPawn = null;
					this.IsOnCornerRailWay = false;
					lap_counter++;
					
				}
				
				else if (this.IsOnLineRailWay==true && (this.selectedPawn.getPosition().getLine() ==1 &&  this.selectedPawn.getPosition().getColumn()>1 && this.selectedPawn.getPosition().getColumn()<7)
						||  (this.selectedPawn.getPosition().getLine() ==5 &&  this.selectedPawn.getPosition().getColumn()>1 && this.selectedPawn.getPosition().getColumn()<7)
						||  (this.selectedPawn.getPosition().getLine() ==7 &&  this.selectedPawn.getPosition().getColumn()>1 && this.selectedPawn.getPosition().getColumn()<7)
						||  (this.selectedPawn.getPosition().getLine() ==11 &&  this.selectedPawn.getPosition().getColumn()>1 && this.selectedPawn.getPosition().getColumn()<7)) {
						if (x<7 && x>1 && (y==1 &&  this.selectedPawn.getPosition().getLine() ==1
							|| y==5 &&  this.selectedPawn.getPosition().getLine() ==5
							|| y==7 && this.selectedPawn.getPosition().getLine() ==7
							|| y==11 &&  this.selectedPawn.getPosition().getLine() ==11
							|| y==0 &&  this.selectedPawn.getPosition().getLine() ==1 
							|| y==2 &&  this.selectedPawn.getPosition().getLine() ==1
							|| y==4 &&  this.selectedPawn.getPosition().getLine() ==5
							|| y==6 &&  (this.selectedPawn.getPosition().getLine() ==5 || this.selectedPawn.getPosition().getLine() ==7)
							|| y==8 &&  this.selectedPawn.getPosition().getLine() ==7
							|| y==10 &&  this.selectedPawn.getPosition().getLine() ==11
							|| y==12 &&  this.selectedPawn.getPosition().getLine() ==11)) {
							if (targetPawn != null) {
								if (selectedPawn.isInRange(targetPawn)) {
									manager.confrontation(selectedPawn, targetPawn);
									selectedPawn = null;
									targetPawn = null;
									this.IsOnLineRailWay = false;
								}
							}

							else {
								if (inBlockAllyPawn == 1) {

								} else {
									selectedPawn.getPosition().setColumn(x);
									selectedPawn.getPosition().setLine(y);
									System.out.println(selectedPawn.getPosition());
									
								}
							}
						}
						inBlockAllyPawn = 0;
						selectedPawn = null;
						this.IsOnLineRailWay = false;
						lap_counter++;
						
						
				}

				
				  else if (this.selectedPawn.getPosition().getColumn()==x &&
				  this.selectedPawn.getPosition().getLine()==y-1 ||
				  this.selectedPawn.getPosition().getColumn()==x+1 &&
				  this.selectedPawn.getPosition().getLine()==y-1 ||
				  this.selectedPawn.getPosition().getColumn()==x-1 &&
				  this.selectedPawn.getPosition().getLine()==y-1 ||
				  this.selectedPawn.getPosition().getColumn()==x-1 &&
				  this.selectedPawn.getPosition().getLine()==y ||
				  this.selectedPawn.getPosition().getColumn()==x-1 &&
				  this.selectedPawn.getPosition().getLine()==y+1 ||
				  this.selectedPawn.getPosition().getColumn()==x &&
				  this.selectedPawn.getPosition().getLine()==y+1 ||
				  this.selectedPawn.getPosition().getColumn()==x+1 &&
				  this.selectedPawn.getPosition().getLine()==y ||
				  this.selectedPawn.getPosition().getColumn()==x+1 &&
				  this.selectedPawn.getPosition().getLine()==y+1 ) {
				  
				  if (x<GameConfiguration.COLUMN_COUNT && y<GameConfiguration.LINE_COUNT &&
				x!=1 && x!=7) { if (targetPawn!=null) {
					if
				  (selectedPawn.isInRange(targetPawn)) { manager.confrontation(selectedPawn,
				  targetPawn); selectedPawn=null; targetPawn=null; dashboard.repaint(); } }
				  
				  else{ if (inBlockAllyPawn==1) {
				  
				  } else { selectedPawn.getPosition().setColumn(x);
				  selectedPawn.getPosition().setLine(y);
				  System.out.println(selectedPawn.getPosition());
				  
				  }
			} 
			}
				  inBlockAllyPawn=0; 
				  selectedPawn=null; 
				  lap_counter++;
				  
				  
				  }
				}
			if (this.lap_counter %5==0 && this.autorisation_shot==false && this.lap_counter!=0) {
				this.autorisation_shot=true;
			}

			System.out.println("tour numero : "+lap_counter);	
			
		}

		@Override
		public void mouseEntered(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}
	}
	
		

	

}
