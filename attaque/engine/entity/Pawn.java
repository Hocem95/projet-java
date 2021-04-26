package engine.entity;

import engine.map.Block;

abstract public class Pawn {
	
	private Block position;
	
	protected int rank;
	protected String name;
	protected Boolean isAlreadyBuffed=false;
	
	public Pawn(Block position) {
		this.position = position;
		
	}
	
	public Block getPosition() {
		return position;
	}
	
	public void setPosition(Block position) {
		if (position==null) {
			Block block = new Block();
			this.position=block;
		}
			
		this.position = position;
	}

	public int getRank() {
		return rank;
	}
	public void setRank(int pawnrank) {
		this.rank=pawnrank;
		
	}

	public String getName() {
		return name;
	}
	
	public abstract boolean isInRange(Pawn pawn);
	
	public Boolean getIsAlreadyBuffed () {
		return this.isAlreadyBuffed;
		
	}

 public void setIsAlreadyBuffed (Boolean buff) {
	 this.isAlreadyBuffed=buff;
 }
}
