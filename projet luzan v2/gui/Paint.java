package gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import config.GameConfiguration;
import engine.entity.*;
import engine.map.Block;
import engine.map.Map;

public class Paint {

	
	public void paint(Map map, Graphics graphics) {
		
		int blockSize = GameConfiguration.BLOCK_SIZE;
		Block[][] blocks = map.getBlocks();
		for (int lineIndex = 0; lineIndex < map.getLineCount(); lineIndex++) {
			for (int columnIndex = 0; columnIndex < map.getColumnCount(); columnIndex++) {
				Block block = blocks[lineIndex][columnIndex];
				if (!(columnIndex==1 || columnIndex==7)) {
					graphics.drawRect(columnIndex*blockSize+4, lineIndex*blockSize+4, blockSize-8,blockSize-8);
				}
				
				

				
				}
		}
	}

	
	
	public void paint(List<Pawn> pawns, Graphics graphics) {
		
		for (int index=0;index<pawns.size();index++) {
			
			Block position = pawns.get(index).getPosition();
			int blockSize = GameConfiguration.BLOCK_SIZE;

			int y = position.getLine();
			int x = position.getColumn();
			

		}
		
	
	}


	
	public void paint(Camp camp, Graphics graphics) {
		Block position = camp.getPosition();
		int blockSize = GameConfiguration.BLOCK_SIZE;

		int y = position.getLine();
		int x = position.getColumn();

		graphics.setColor(Color.BLUE);
		graphics.drawRect(x*blockSize+8, y*blockSize+8, blockSize-16,blockSize-16);
		System.out.println("B");
	}
	public void paint(HQ hq, Graphics graphics) {
		Block position = hq.getPosition();
		int blockSize = GameConfiguration.BLOCK_SIZE;

		int y = position.getLine();
		int x = position.getColumn();

		graphics.setColor(Color.RED);
		graphics.drawRect(x*blockSize+8, y*blockSize+8, blockSize-16,blockSize-16);
		
	}
	
	public void paint(Flag flag, Graphics graphics) {
		Block position = flag.getPosition();
		int blockSize = GameConfiguration.BLOCK_SIZE;

		int y = position.getLine();
		int x = position.getColumn();

		graphics.setColor(Color.GREEN);
		graphics.drawString("FLAG", x*blockSize+20, y*blockSize+40);
		

		
	}
	
	public void paint(Frontline frontline, Graphics graphics) {
		Block position = frontline.getPosition();
		int blockSize = GameConfiguration.BLOCK_SIZE;

		int y = position.getLine();
		int x = position.getColumn();

		graphics.setColor(Color.PINK);
		graphics.drawRect(x*blockSize+8, y*blockSize+8, blockSize-16,blockSize-16);
		
	}
	public void paint(Bomb bomb, Graphics graphics) {
		Block position = bomb.getPosition();
		int blockSize = GameConfiguration.BLOCK_SIZE;

		int y = position.getLine();
		int x = position.getColumn();
		graphics.setColor(Color.GREEN);
		graphics.drawString("BOMB", x*blockSize+20, y*blockSize+40);
		
	}
	public void paint(Boat boat, Graphics graphics) {
		Block position = boat.getPosition();
		int blockSize = GameConfiguration.BLOCK_SIZE;

		int y = position.getLine();
		int x = position.getColumn();
		graphics.setColor(Color.GREEN);
		graphics.drawString("BOAT", x*blockSize+20, y*blockSize+40);
		
	}
	
	public void paint(BrigadierGeneral bg, Graphics graphics,JPanel main) {
		Block position = bg.getPosition();
		int blockSize = GameConfiguration.BLOCK_SIZE;

		int y = position.getLine();
		int x = position.getColumn();
		try {
			Image pomme = ImageIO.read(new File("img/6_1.png"));
			graphics.drawImage(pomme, x*blockSize+8, y*blockSize+8, blockSize-16, blockSize-16, main);
		}
		catch(IOException exc) {
			exc.printStackTrace();
		}
	}
	
	public void paint(Captain captain, Graphics graphics,JPanel main) {
		Block position = captain.getPosition();
		int blockSize = GameConfiguration.BLOCK_SIZE;

		int y = position.getLine();
		int x = position.getColumn();
		try {
			Image pomme = ImageIO.read(new File("img/3_1.png"));
			graphics.drawImage(pomme, x*blockSize+8, y*blockSize+8, blockSize-16, blockSize-16, main);
		}
		catch(IOException exc) {
			exc.printStackTrace();
		}	
	}
	public void paint(Colonel colonel, Graphics graphics,JPanel main) {
		Block position = colonel.getPosition();
		int blockSize = GameConfiguration.BLOCK_SIZE;

		int y = position.getLine();
		int x = position.getColumn();
		try {
			Image pomme = ImageIO.read(new File("img/5_1.png"));
			graphics.drawImage(pomme, x*blockSize+8, y*blockSize+8, blockSize-16, blockSize-16, main);
		}
		catch(IOException exc) {
			exc.printStackTrace();
		}
	}
	public void paint(Engineer engineer, Graphics graphics,JPanel main) {
		Block position = engineer.getPosition();
		int blockSize = GameConfiguration.BLOCK_SIZE;

		int y = position.getLine();
		int x = position.getColumn();
		try {
			Image pomme = ImageIO.read(new File("img/1_1.png"));
			graphics.drawImage(pomme, x*blockSize+8, y*blockSize+8, blockSize-16, blockSize-16, main);
		}
		catch(IOException exc) {
			exc.printStackTrace();
		}
		
	}
	
	public void paint(General general, Graphics graphics,JPanel main) {
		Block position = general.getPosition();
		int blockSize = GameConfiguration.BLOCK_SIZE;

		int y = position.getLine();
		int x = position.getColumn();
		try {
			Image pomme = ImageIO.read(new File("img/8_1.png"));
			graphics.drawImage(pomme, x*blockSize+8, y*blockSize+8, blockSize-16, blockSize-16, main);
		}
		catch(IOException exc) {
			exc.printStackTrace();
		}
	}
	
	public void paint(Lieutenant lieutenant, Graphics graphics,JPanel main) {
		Block position = lieutenant.getPosition();
		int blockSize = GameConfiguration.BLOCK_SIZE;

		int y = position.getLine();
		int x = position.getColumn();
		try {
			Image pomme = ImageIO.read(new File("img/2_1.png"));
			graphics.drawImage(pomme, x*blockSize+8, y*blockSize+8, blockSize-16, blockSize-16, main);
		}
		catch(IOException exc) {
			exc.printStackTrace();
		}
		
	}
	
	public void paint(Major major, Graphics graphics,JPanel main) {
		Block position = major.getPosition();
		int blockSize = GameConfiguration.BLOCK_SIZE;

		int y = position.getLine();
		int x = position.getColumn();
		try {
			Image pomme = ImageIO.read(new File("img/4_1.png"));
			graphics.drawImage(pomme, x*blockSize+8, y*blockSize+8, blockSize-16, blockSize-16, main);
		}
		catch(IOException exc) {
			exc.printStackTrace();
		}
	}
	
	public void paint(MajorGeneral mg, Graphics graphics,JPanel main) {
		Block position = mg.getPosition();
		int blockSize = GameConfiguration.BLOCK_SIZE;

		int y = position.getLine();
		int x = position.getColumn();
		try {
			Image pomme = ImageIO.read(new File("img/7_1.png"));
			graphics.drawImage(pomme, x*blockSize+8, y*blockSize+8, blockSize-16, blockSize-16, main);
		}
		catch(IOException exc) {
			exc.printStackTrace();
		}

		
	}

	public void paint(Marshal marshal, Graphics graphics,JPanel main) {
		Block position = marshal.getPosition();
		int blockSize = GameConfiguration.BLOCK_SIZE;

		int y = position.getLine();
		int x = position.getColumn();
		try {
			Image pomme = ImageIO.read(new File("img/9_1.png"));
			graphics.drawImage(pomme, x*blockSize+8, y*blockSize+8, blockSize-16, blockSize-16, main);
		}
		catch(IOException exc) {
			exc.printStackTrace();
		}

		
	}
	
	public void paint(Mine mine, Graphics graphics) {
		Block position = mine.getPosition();
		int blockSize = GameConfiguration.BLOCK_SIZE;

		int y = position.getLine();
		int x = position.getColumn();
		
		graphics.setColor(Color.GREEN);
		graphics.drawString("MINE", x*blockSize+20, y*blockSize+40);
		
	}
	
	
}
