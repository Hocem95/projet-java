package engine.entity;
import engine.map.Block;

public class Captain extends Pawn{

	
	public Captain(Block position) {
		
		super(position);
		rank=3;
		name="Captain";
	}		public boolean isInRange(Pawn pawn) {
		
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