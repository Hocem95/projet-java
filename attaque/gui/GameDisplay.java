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
	public Paint painting = new Paint();

	public GameDisplay(Map map, MobileElementManager manager) {
		this.map = map;
		this.manager = manager;
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		List<Pawn> pawnsAlly = manager.getPawnsAlly();

		List<Pawn> pawnsEnemy = manager.getPawnsEnemy();
		
		painting.paint(map,pawnsAlly, pawnsEnemy,g);
		
		Camp camp_1 = manager.getCamp_1();
		painting.paint(camp_1, g);
		Camp camp_2 = manager.getCamp_2();	
		painting.paint(camp_2, g);

		Camp camp_3 = manager.getCamp_3();	
		painting.paint(camp_3, g);

		Camp camp_4 = manager.getCamp_4();	
		painting.paint(camp_4, g);

		Camp camp_5 = manager.getCamp_5();	
		painting.paint(camp_5, g);
		Camp camp_6 = manager.getCamp_6();	
		painting.paint(camp_6, g);

		Camp camp_7 = manager.getCamp_7();	
		painting.paint(camp_7, g);

		Camp camp_8 = manager.getCamp_8();	
		painting.paint(camp_8, g);
		
		 HQ hq_1 = manager.getHq_1();	
		 painting.paint(hq_1, g);
		 HQ hq_2 = manager.getHq_2();
		 painting.paint(hq_2, g);
		 HQ hq_3 = manager.getHq_3();
		 painting.paint(hq_3, g);
		 HQ hq_4 = manager.getHq_4();
		 painting.paint(hq_4, g);
		
		 Frontline frontline_1 = manager.getFrontline_1();
		 painting.paint(frontline_1, g);
		 Frontline frontline_2 = manager.getFrontline_2();
		 painting.paint(frontline_2, g);
		 Frontline frontline_3 = manager.getFrontline_3();
		 painting.paint(frontline_3, g);
		 
		for (int index=0;index<pawnsAlly.size();index++) {
			if(pawnsAlly.get(index).getName()=="Boat") {		
				Boat boat = manager.getBoat();
				painting.paint(boat, g);
			}
			if(pawnsAlly.get(index).getName()=="Marshal") {		
				Marshal marshal = manager.getMarshal();
				painting.paint(marshal, g,this);
			}
			
			if(pawnsAlly.get(index).getName()=="Lieutenant") {		
				Lieutenant lieutenant = manager.getLieutenant();
				painting.paint(lieutenant, g,this);
			}
			if(pawnsAlly.get(index).getName()=="BrigadierGeneral") {		
				BrigadierGeneral bg = manager.getBg();
				painting.paint(bg, g,this);
			}
			if(pawnsAlly.get(index).getName()=="Captain") {		
				Captain captain = manager.getCaptain();
				painting.paint(captain, g,this);
			}
			if(pawnsAlly.get(index).getName()=="Engineer") {		
				Engineer engineer = manager.getEngineer();
				painting.paint(engineer, g,this);
			}
			if(pawnsAlly.get(index).getName()=="Flag") {		
				Flag flag = manager.getFlag();
				painting.paint(flag, g);
			}
			if(pawnsAlly.get(index).getName()=="General") {		
				General general = manager.getGeneral();
				painting.paint(general, g,this);
			}
			if(pawnsAlly.get(index).getName()=="Major") {		
				Major major = manager.getMajor();
				painting.paint(major, g,this);
			}
			if(pawnsAlly.get(index).getName()=="MajorGeneral") {		
				MajorGeneral mg = manager.getMg();
				painting.paint(mg, g,this);
			}
			if(pawnsAlly.get(index).getName()=="Mine") {		
				Mine mine = manager.getMine();
				painting.paint(mine, g);
			}
			if(pawnsAlly.get(index).getName()=="Colonel") {		
				Colonel colonel = manager.getColonel();
				painting.paint(colonel, g,this);
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
				painting.paint(marshal, g,this);
			}
			
			if(pawnsEnemy.get(index).getName()=="Lieutenant") {		
				Lieutenant lieutenant = manager.getLieutenantEnemy();
				painting.paint(lieutenant, g,this);
			}
			if(pawnsEnemy.get(index).getName()=="BrigadierGeneral") {		
				BrigadierGeneral bg = manager.getBgEnemy();
				painting.paint(bg, g,this);
			}
			if(pawnsEnemy.get(index).getName()=="Captain") {		
				Captain captain = manager.getCaptainEnemy();
				painting.paint(captain, g,this);
			}
			if(pawnsEnemy.get(index).getName()=="Engineer") {		
				Engineer engineer = manager.getEngineerEnemy();
				painting.paint(engineer, g,this);
			}
			if(pawnsEnemy.get(index).getName()=="Flag") {		
				Flag flag = manager.getFlagEnemy();
				painting.paint(flag, g);
			}
			if(pawnsEnemy.get(index).getName()=="General") {		
				General general = manager.getGeneralEnemy();
				painting.paint(general, g,this);
			}
			if(pawnsEnemy.get(index).getName()=="Major") {		
				Major major = manager.getMajorEnemy();
				painting.paint(major, g,this);
			}
			if(pawnsEnemy.get(index).getName()=="MajorGeneral") {		
				MajorGeneral mg = manager.getMgEnemy();
				painting.paint(mg, g,this);
			}
			if(pawnsEnemy.get(index).getName()=="Mine") {		
				Mine mine = manager.getMineEnemy();
				painting.paint(mine, g);
			}
			if(pawnsEnemy.get(index).getName()=="Colonel") {		
				Colonel colonel = manager.getColonelEnemy();
				painting.paint(colonel, g,this);
			}
			if(pawnsEnemy.get(index).getName()=="Bomb") {		
				Bomb bomb = manager.getBombEnemy();
				painting.paint(bomb, g);
			}
		}
		

	}
	
	
}
