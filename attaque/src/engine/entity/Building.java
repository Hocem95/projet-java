package engine.entity;

import engine.map.Block;

public abstract class Building {

	protected String name;
	
	private Block position;
	
	public Building(Block position) {
		this.position = position;
	}
	
	public Block getPosition() {
		return position;
	}
	
	 public String getName() {
		 return name;
	 }
	

}

	
	

