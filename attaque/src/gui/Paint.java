package gui;

import java.awt.Color;
import java.awt.Graphics;
import java.util.List;

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
				if (!(columnIndex==1 || columnIndex==7))
				
				graphics.drawRect(block.getColumn()*blockSize+4, block.getLine()*blockSize+4, blockSize-8,blockSize-8);

				
				}
		}
	}

	
	
	public void paint(List<Pawn> pawns, Graphics graphics) {
		
		for (int index=0;index<pawns.size();index++) {
			
			Block position = pawns.get(index).getPosition();
			int blockSize = GameConfiguration.BLOCK_SIZE;

			int y = position.getLine();
			int x = position.getColumn();

			graphics.drawOval(x*blockSize+10, y*blockSize+10, blockSize-20,blockSize-20);
			
		}
	}


	
	public void paint(Camp camp, Graphics graphics) {
		Block position = camp.getPosition();
		int blockSize = GameConfiguration.BLOCK_SIZE;

		int y = position.getLine();
		int x = position.getColumn();

		graphics.setColor(Color.BLUE);
		graphics.drawRect(x*blockSize+8, y*blockSize+8, blockSize-16,blockSize-16);
	}
	public void paint(HQ hq, Graphics graphics) {
		Block position = hq.getPosition();
		int blockSize = GameConfiguration.BLOCK_SIZE;

		int y = position.getLine();
		int x = position.getColumn();

		graphics.setColor(Color.GREEN);
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
	
	public void paint(BrigadierGeneral bg, Graphics graphics) {
		Block position = bg.getPosition();
		int blockSize = GameConfiguration.BLOCK_SIZE;

		int y = position.getLine();
		int x = position.getColumn();
		graphics.setColor(Color.GREEN);
		graphics.drawString("BG", x*blockSize+20, y*blockSize+40);
		
	}
	
	public void paint(Captain captain, Graphics graphics) {
		Block position = captain.getPosition();
		int blockSize = GameConfiguration.BLOCK_SIZE;

		int y = position.getLine();
		int x = position.getColumn();
		graphics.setColor(Color.GREEN);
		graphics.drawString("CPT", x*blockSize+20, y*blockSize+40);
		
	}
	public void paint(Colonel colonel, Graphics graphics) {
		Block position = colonel.getPosition();
		int blockSize = GameConfiguration.BLOCK_SIZE;

		int y = position.getLine();
		int x = position.getColumn();
		graphics.setColor(Color.GREEN);
		graphics.drawString("CLN", x*blockSize+20, y*blockSize+40);
		
	}
	public void paint(Engineer engineer, Graphics graphics) {
		Block position = engineer.getPosition();
		int blockSize = GameConfiguration.BLOCK_SIZE;

		int y = position.getLine();
		int x = position.getColumn();
		graphics.setColor(Color.GREEN);
		graphics.drawString("ENG", x*blockSize+20, y*blockSize+40);
		
	}
	
	public void paint(General general, Graphics graphics) {
		Block position = general.getPosition();
		int blockSize = GameConfiguration.BLOCK_SIZE;

		int y = position.getLine();
		int x = position.getColumn();
		graphics.setColor(Color.GREEN);
		graphics.drawString("GNR", x*blockSize+20, y*blockSize+40);
		
	}
	
	public void paint(Lieutenant lieutenant, Graphics graphics) {
		Block position = lieutenant.getPosition();
		int blockSize = GameConfiguration.BLOCK_SIZE;

		int y = position.getLine();
		int x = position.getColumn();
		graphics.setColor(Color.GREEN);
		graphics.drawString("LT", x*blockSize+20, y*blockSize+40);
		
	}
	
	public void paint(Major major, Graphics graphics) {
		Block position = major.getPosition();
		int blockSize = GameConfiguration.BLOCK_SIZE;

		int y = position.getLine();
		int x = position.getColumn();
		graphics.setColor(Color.GREEN);
		graphics.drawString("MJR", x*blockSize+20, y*blockSize+40);
		
	}
	
	public void paint(MajorGeneral mg, Graphics graphics) {
		Block position = mg.getPosition();
		int blockSize = GameConfiguration.BLOCK_SIZE;

		int y = position.getLine();
		int x = position.getColumn();
		graphics.setColor(Color.GREEN);
		graphics.drawString("MG", x*blockSize+20, y*blockSize+40);
		
	}

	public void paint(Marshal marshal, Graphics graphics) {
		Block position = marshal.getPosition();
		int blockSize = GameConfiguration.BLOCK_SIZE;

		int y = position.getLine();
		int x = position.getColumn();
		graphics.setColor(Color.GREEN);
		graphics.drawString("MSL", x*blockSize+20, y*blockSize+40);
		
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
