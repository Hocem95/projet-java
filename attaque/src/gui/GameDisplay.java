package gui;

import java.awt.Color;
import java.awt.Graphics;

import java.util.List;

import javax.swing.JPanel;


import engine.entity.*;
import engine.map.Block;
import engine.map.Map;

import engine.process.MobileElementManager;

public class GameDisplay extends JPanel {

	private static final long serialVersionUID = 1L;

	private Map map;
	private MobileElementManager manager;
	private Paint painting = new Paint();

	public GameDisplay(Map map, MobileElementManager manager) {
		this.map = map;
		this.manager = manager;
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		painting.paint(map, g);
		List<Pawn> pawnsAlly = manager.getPawnsAlly();
		g.setColor(Color.BLUE);
		painting.paint(pawnsAlly, g);
		
		List<Pawn> pawnsEnemy = manager.getPawnsEnemy();
		g.setColor(Color.RED);
		painting.paint(pawnsEnemy, g);
		
		for (int index=0;index<pawnsAlly.size();index++) {
			if(pawnsAlly.get(index).getName()=="Boat") {		
				Boat boat = manager.getBoat();
				painting.paint(boat, g);
			}
			if(pawnsAlly.get(index).getName()=="Marshal") {		
				Marshal marshal = manager.getMarshal();
				painting.paint(marshal, g);
			}
			
			if(pawnsAlly.get(index).getName()=="Lieutenant") {		
				Lieutenant lieutenant = manager.getLieutenant();
				painting.paint(lieutenant, g);
			}
			if(pawnsAlly.get(index).getName()=="BrigadierGeneral") {		
				BrigadierGeneral bg = manager.getBg();
				painting.paint(bg, g);
			}
			if(pawnsAlly.get(index).getName()=="Captain") {		
				Captain captain = manager.getCaptain();
				painting.paint(captain, g);
			}
			if(pawnsAlly.get(index).getName()=="Engineer") {		
				Engineer engineer = manager.getEngineer();
				painting.paint(engineer, g);
			}
			if(pawnsAlly.get(index).getName()=="Flag") {		
				Flag flag = manager.getFlag();
				painting.paint(flag, g);
			}
			if(pawnsAlly.get(index).getName()=="General") {		
				General general = manager.getGeneral();
				painting.paint(general, g);
			}
			if(pawnsAlly.get(index).getName()=="Major") {		
				Major major = manager.getMajor();
				painting.paint(major, g);
			}
			if(pawnsAlly.get(index).getName()=="MajorGeneral") {		
				MajorGeneral mg = manager.getMg();
				painting.paint(mg, g);
			}
			if(pawnsAlly.get(index).getName()=="Mine") {		
				Mine mine = manager.getMine();
				painting.paint(mine, g);
			}
			if(pawnsAlly.get(index).getName()=="Colonel") {		
				Colonel colonel = manager.getColonel();
				painting.paint(colonel, g);
			}
			if(pawnsAlly.get(index).getName()=="Bomb") {		
				Bomb bomb = manager.getBomb();
				painting.paint(bomb, g);
			}
		}
		for (int index=0; index<pawnsEnemy.size();index++) {
			if(pawnsEnemy.get(index).getName()=="Boat") {		
				Boat boat = manager.getBoatEnemy();
				painting.paint(boat, g);
			}
			if(pawnsEnemy.get(index).getName()=="Marshal") {		
				Marshal marshal = manager.getMarshalEnemy();
				painting.paint(marshal, g);
			}
			
			if(pawnsEnemy.get(index).getName()=="Lieutenant") {		
				Lieutenant lieutenant = manager.getLieutenantEnemy();
				painting.paint(lieutenant, g);
			}
			if(pawnsEnemy.get(index).getName()=="BrigadierGeneral") {		
				BrigadierGeneral bg = manager.getBgEnemy();
				painting.paint(bg, g);
			}
			if(pawnsEnemy.get(index).getName()=="Captain") {		
				Captain captain = manager.getCaptainEnemy();
				painting.paint(captain, g);
			}
			if(pawnsEnemy.get(index).getName()=="Engineer") {		
				Engineer engineer = manager.getEngineerEnemy();
				painting.paint(engineer, g);
			}
			if(pawnsEnemy.get(index).getName()=="Flag") {		
				Flag flag = manager.getFlagEnemy();
				painting.paint(flag, g);
			}
			if(pawnsEnemy.get(index).getName()=="General") {		
				General general = manager.getGeneralEnemy();
				painting.paint(general, g);
			}
			if(pawnsEnemy.get(index).getName()=="Major") {		
				Major major = manager.getMajorEnemy();
				painting.paint(major, g);
			}
			if(pawnsEnemy.get(index).getName()=="MajorGeneral") {		
				MajorGeneral mg = manager.getMgEnemy();
				painting.paint(mg, g);
			}
			if(pawnsEnemy.get(index).getName()=="Mine") {		
				Mine mine = manager.getMineEnemy();
				painting.paint(mine, g);
			}
			if(pawnsEnemy.get(index).getName()=="Colonel") {		
				Colonel colonel = manager.getColonelEnemy();
				painting.paint(colonel, g);
			}
			if(pawnsEnemy.get(index).getName()=="Bomb") {		
				Bomb bomb = manager.getBombEnemy();
				painting.paint(bomb, g);
			}
		}

	}
}
