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

	int blockSize = GameConfiguration.BLOCK_SIZE;


	
	public void paint(Map map,List<Pawn>pawns,List<Pawn>pawnsEnemy, Graphics graphics) {


		int blockSize = GameConfiguration.BLOCK_SIZE;
		graphics.setColor(Color.BLUE);
		
		for (int index=0;index<pawns.size();index++) {	
			graphics.drawRect(pawns.get(index).getPosition().getColumn()*blockSize+11, 
					pawns.get(index).getPosition().getLine()*blockSize+11, blockSize-22,blockSize-22);

		}

		graphics.setColor(Color.RED);
		for (int index=0;index<pawnsEnemy.size();index++) {
			graphics.drawRect(pawnsEnemy.get(index).getPosition().getColumn()*blockSize+11, 
					pawnsEnemy.get(index).getPosition().getLine()*blockSize+11, blockSize-22,blockSize-22);

		}

		for (int lineIndex = 0; lineIndex < map.getLineCount(); lineIndex++) {
			for (int columnIndex = 0; columnIndex < map.getColumnCount(); columnIndex++) {

				if (columnIndex!=1 && columnIndex!=7) {


					graphics.setColor(Color.GRAY);


					graphics.drawRect(columnIndex*blockSize, lineIndex*blockSize, blockSize,blockSize);

					graphics.setColor(Color.BLACK);


					if (columnIndex>2 && columnIndex<8) {
						if (lineIndex!=6) {


							graphics.drawLine((columnIndex-1)*blockSize+blockSize/2, (lineIndex)*blockSize+blockSize/2, 
									columnIndex*blockSize+blockSize/2, lineIndex*blockSize+blockSize/2);
						}

						if (lineIndex==7 || lineIndex==5 || lineIndex==1 ||lineIndex==11) {
							graphics.drawLine((columnIndex-1)*blockSize+blockSize/2, 5+(lineIndex)*blockSize+blockSize/2, 
									columnIndex*blockSize+blockSize/2, 5+lineIndex*blockSize+blockSize/2);
						}


						if (lineIndex>1 && lineIndex<=11 && lineIndex!=6 && lineIndex!=7){


							if (
									( ((lineIndex!=2 && lineIndex!=4) && (lineIndex!=6 && lineIndex!=8 && lineIndex!=10)) || 
											(columnIndex!=4 && columnIndex!=6)) 

									&&

									( ((lineIndex!=3 && lineIndex!=5) && (lineIndex!=7 && lineIndex!=9 && lineIndex!=11))|| (
											columnIndex!=3 && columnIndex!=5))

									) {

								graphics.drawLine((columnIndex-1)*blockSize+blockSize/2, (lineIndex-1)*blockSize+blockSize/2, 	
										columnIndex*blockSize+blockSize/2, lineIndex*blockSize+blockSize/2);
							}

						}

						if (lineIndex>=1 && lineIndex<=10 && lineIndex!=5 && lineIndex!=6) {

							if (
									( ((lineIndex!=1 && lineIndex!=3)&& (lineIndex!=7 && lineIndex!=9 )) || 
											(columnIndex!=3 && columnIndex!=5))

									&&

									(
											((lineIndex!=2 && lineIndex!=4) &&(lineIndex!=8 && lineIndex!=10 )) || 

											(columnIndex!=4 && columnIndex!=6))

									) {

								graphics.drawLine((columnIndex-1)*blockSize+blockSize/2, (lineIndex+1)*blockSize+blockSize/2, 
										columnIndex*blockSize+blockSize/2, lineIndex*blockSize+blockSize/2);	
							}

						}


						if (lineIndex<12) {

							if((lineIndex!=5&& lineIndex!=6) || (columnIndex!=3 && columnIndex!=5)){

								graphics.drawLine((columnIndex)*blockSize+blockSize/2, (lineIndex+1)*blockSize+blockSize/2, 
										columnIndex*blockSize+blockSize/2, lineIndex*blockSize+blockSize/2);

								if ((lineIndex!=0 && lineIndex!=11) ) {
									if (columnIndex==6) {
										graphics.drawLine(-5+(columnIndex)*blockSize+blockSize/2, +(lineIndex+1)*blockSize+blockSize/2, 
												-5+columnIndex*blockSize+blockSize/2, lineIndex*blockSize+blockSize/2);
									}

									else if ((columnIndex==4 && lineIndex==6)) {
										graphics.drawLine(-5+(columnIndex)*blockSize+blockSize/2, -135+(lineIndex+1)*blockSize+blockSize/2, 
												-5+columnIndex*blockSize+blockSize/2, 70+lineIndex*blockSize+blockSize/2);
										graphics.drawLine(5+(columnIndex)*blockSize+blockSize/2, -135+(lineIndex+1)*blockSize+blockSize/2, 
												5+columnIndex*blockSize+blockSize/2, 70+lineIndex*blockSize+blockSize/2);
									}
								}


							}

						}										
					}


					else {	
						if (lineIndex<12 ) {
							if (columnIndex!=0 && columnIndex!=8 && (lineIndex!=0 && lineIndex!=11)) {

								graphics.drawLine(5+(columnIndex)*blockSize+blockSize/2, ((lineIndex+1)*blockSize+blockSize/2)-blockSize/2, 
										5+columnIndex*blockSize+blockSize/2, lineIndex*blockSize+blockSize/2);
							}

							graphics.drawLine((columnIndex)*blockSize+blockSize/2, ((lineIndex+1)*blockSize+blockSize/2)-blockSize/2, 
									columnIndex*blockSize+blockSize/2, lineIndex*blockSize+blockSize/2);

						}

						if (lineIndex>0) {

							if (columnIndex!=0&&columnIndex!=8 && (lineIndex!=1 && lineIndex!=12)) {
								graphics.drawLine(5+(columnIndex)*blockSize+blockSize/2, ((lineIndex-1)*blockSize+blockSize/2)+blockSize/2, 
										5+columnIndex*blockSize+blockSize/2, lineIndex*blockSize+blockSize/2);
							}
							graphics.drawLine((columnIndex)*blockSize+blockSize/2, ((lineIndex-1)*blockSize+blockSize/2)+blockSize/2, 
									columnIndex*blockSize+blockSize/2, lineIndex*blockSize+blockSize/2);
						}	
					}

				}

				if (columnIndex>1 && columnIndex<7){

					if (lineIndex==0) {

						graphics.drawLine((columnIndex+1)*blockSize, (lineIndex)*blockSize, 
								columnIndex*blockSize, lineIndex*blockSize);
						graphics.drawLine((columnIndex+1)*blockSize, (lineIndex)*blockSize, 
								columnIndex*blockSize, lineIndex*blockSize);
					}
					if (lineIndex==12) {
						graphics.drawLine(((columnIndex+1)*blockSize), 70+((lineIndex)*blockSize), 
								(columnIndex*blockSize), 70+(lineIndex*blockSize));
					}

				}

				if (columnIndex==2 || columnIndex==7) {

					graphics.drawLine((columnIndex)*blockSize, (lineIndex+1)*blockSize, 
							columnIndex*blockSize, lineIndex*blockSize);		
				}
			}
		}	
	}


	public void paint(Camp camp, Graphics graphics) {
		
		Block position = camp.getPosition();

		int y = position.getLine();
		int x = position.getColumn();

		graphics.setColor(Color.CYAN);
		graphics.drawRect(x*blockSize+8, y*blockSize+8, blockSize-16,blockSize-16);
		
	}

	public void paint(HQ hq, Graphics graphics) {
		Block position = hq.getPosition();

		int y = position.getLine();
		int x = position.getColumn();

		graphics.setColor(Color.RED);
		graphics.drawRect(x*blockSize+8, y*blockSize+8, blockSize-16,blockSize-16);
		
	}
	
	public void paint(Flag flag, Graphics graphics) {
		Block position = flag.getPosition();

		int y = position.getLine();
		int x = position.getColumn();

		graphics.setColor(Color.GREEN);
		graphics.drawString("FLAG", x*blockSize+20, y*blockSize+40);
		

		
	}
	
	public void paint(Frontline frontline, Graphics graphics) {
		Block position = frontline.getPosition();

		int y = position.getLine();
		int x = position.getColumn();

		graphics.setColor(Color.PINK);
		graphics.drawRect(x*blockSize+8, y*blockSize+8, blockSize-16,blockSize-16);
		
	}
	public void paint(Bomb bomb, Graphics graphics) {
		Block position = bomb.getPosition();

		int y = position.getLine();
		int x = position.getColumn();
		graphics.setColor(Color.GREEN);
		graphics.drawString("BOMB", x*blockSize+20, y*blockSize+40);
		
	}
	public void paint(Boat boat, Graphics graphics) {
		Block position = boat.getPosition();

		int y = position.getLine();
		int x = position.getColumn();
		graphics.setColor(Color.GREEN);
		graphics.drawString("BOAT", x*blockSize+20, y*blockSize+40);
		
	}
	
	public void paint(BrigadierGeneral bg, Graphics graphics,JPanel main) {
		Block position = bg.getPosition();

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

		int y = position.getLine();
		int x = position.getColumn();
		try {
			Image pomme = ImageIO.read(new File("img/3_1.png"));
			graphics.drawImage(pomme, x*blockSize+12, y*blockSize+12, blockSize-24, blockSize-24, main);
		}
		catch(IOException exc) {
			exc.printStackTrace();
		}	
	}
	public void paint(Colonel colonel, Graphics graphics,JPanel main) {
		Block position = colonel.getPosition();

		int y = position.getLine();
		int x = position.getColumn();
		try {
			Image pomme = ImageIO.read(new File("img/5_1.png"));
			graphics.drawImage(pomme, x*blockSize+12, y*blockSize+12, blockSize-24, blockSize-24, main);
		}
		catch(IOException exc) {
			exc.printStackTrace();
		}
	}
	public void paint(Engineer engineer, Graphics graphics,JPanel main) {
		Block position = engineer.getPosition();

		int y = position.getLine();
		int x = position.getColumn();
		try {
			Image pomme = ImageIO.read(new File("img/1_1.png"));
			graphics.drawImage(pomme, x*blockSize+12, y*blockSize+12, blockSize-24, blockSize-24, main);
		}
		catch(IOException exc) {
			exc.printStackTrace();
		}
		
	}
	
	public void paint(General general, Graphics graphics,JPanel main) {
		Block position = general.getPosition();

		int y = position.getLine();
		int x = position.getColumn();
		try {
			Image pomme = ImageIO.read(new File("img/8_1.png"));
			graphics.drawImage(pomme, x*blockSize+12, y*blockSize+12, blockSize-24, blockSize-24, main);
		}
		catch(IOException exc) {
			exc.printStackTrace();
		}
	}
	
	public void paint(Lieutenant lieutenant, Graphics graphics,JPanel main) {
		Block position = lieutenant.getPosition();

		int y = position.getLine();
		int x = position.getColumn();
		try {
			Image pomme = ImageIO.read(new File("img/2_1.png"));
			graphics.drawImage(pomme, x*blockSize+12, y*blockSize+12, blockSize-24, blockSize-24, main);
		}
		catch(IOException exc) {
			exc.printStackTrace();
		}
		
	}
	
	public void paint(Major major, Graphics graphics,JPanel main) {
		Block position = major.getPosition();

		int y = position.getLine();
		int x = position.getColumn();
		try {
			Image pomme = ImageIO.read(new File("img/4_1.png"));
			graphics.drawImage(pomme, x*blockSize+12, y*blockSize+12, blockSize-24, blockSize-24, main);
		}
		catch(IOException exc) {
			exc.printStackTrace();
		}
	}
	
	public void paint(MajorGeneral mg, Graphics graphics,JPanel main) {
		Block position = mg.getPosition();

		int y = position.getLine();
		int x = position.getColumn();
		try {
			Image pomme = ImageIO.read(new File("img/7_1.png"));
			graphics.drawImage(pomme, x*blockSize+12, y*blockSize+12, blockSize-24, blockSize-24, main);
		}
		catch(IOException exc) {
			exc.printStackTrace();
		}

		
	}

	public void paint(Marshal marshal, Graphics graphics,JPanel main) {
		Block position = marshal.getPosition();

		int y = position.getLine();
		int x = position.getColumn();
		try {
			Image pomme = ImageIO.read(new File("img/9_1.png"));
			graphics.drawImage(pomme, x*blockSize+12, y*blockSize+12, blockSize-24, blockSize-24, main);
		}
		catch(IOException exc) {
			exc.printStackTrace();
		}

		
	}
	
	public void paint(Mine mine, Graphics graphics) {
		Block position = mine.getPosition();

		int y = position.getLine();
		int x = position.getColumn();
		
		graphics.setColor(Color.GREEN);
		graphics.drawString("MINE", x*blockSize+20, y*blockSize+40);
		
	}
	
	
}
