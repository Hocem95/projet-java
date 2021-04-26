package engine.entity;
import engine.map.Block;

public class Major extends Pawn{


	public Major(Block position) {
		super(position);
		rank=4;
		name="Major";
	}
	public boolean isInRange(Pawn pawn) {
		
		if (pawn.getPosition().getLine()==this.getPosition().getLine()) {
			if (pawn.getPosition().getColumn()==this.getPosition().getColumn()+1 ||
				pawn.getPosition().getColumn()==this.getPosition().getColumn()-1) {
				return true;
				
			}
			else {
				return false;
			}
		}
		else if (pawn.getPosition().getColumn()==this.getPosition().getColumn()) {
			if (pawn.getPosition().getLine()==this.getPosition().getLine()+1 ||
				pawn.getPosition().getLine()==this.getPosition().getLine()-1) {
				return true;
				
			}
			else {
				return false;
			}
		
		}
		return false;
	}
}