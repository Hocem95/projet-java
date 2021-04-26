package engine.process;

import java.util.ArrayList;
import java.util.List;

import engine.entity.*;
import engine.map.Map;


public class MobileElementManager {
	
	private Colonel colonel,colonelEnemy;
	private Bomb bomb,bombEnemy;
	private Captain captain,captainEnemy;
	private Boat boat,boatEnemy;
	private BrigadierGeneral bg,bgEnemy;
	private Engineer engineer,engineerEnemy;
	private Flag flag,flagEnemy;
	private General general,generalEnemy;
	private Lieutenant lieutenant,lieutenantEnemy;
	private Major major,majorEnemy;
	private MajorGeneral mg,mgEnemy;
	private Marshal marshal,marshalEnemy;
	private Mine mine,mineEnemy;
	private Map map;
	
	private HQ hq_1;
	private HQ hq_2;
	private HQ hq_3;
	private HQ hq_4;
	private Camp camp_1;
	private Camp camp_2;
	private Camp camp_3;
	private Camp camp_4;
	private Camp camp_5;
	private Camp camp_6;
	private Camp camp_7;
	private Camp camp_8;
	private Frontline frontline_1;
	private Frontline frontline_2;
	private Frontline frontline_3;

	
	
	
	
	private List<Pawn> pawns = new ArrayList<Pawn>();
	private List<Pawn> pawnsEnemy = new ArrayList<Pawn>();
	private List <Building> buildings = new ArrayList<Building>();
	
	
	public void confrontation(Pawn atkPawn, Pawn defPawn) {

				
				if (atkPawn.getRank()>defPawn.getRank()) {
					
					System.out.println("allié gagne");
					atkPawn.setPosition(defPawn.getPosition());					
					
					for(int index=0; index<pawnsEnemy.size();index++) {
						
						if (pawnsEnemy.get(index) == defPawn) {
							pawnsEnemy.remove(defPawn);
						
						}
						System.out.println(pawnsEnemy.get(index).getName());
					}
				}
				
				else if (atkPawn.getRank()<defPawn.getRank()) {
		
					System.out.println("ennemi gagne");
					for(int index=0; index<pawns.size();index++) {
						if (pawns.get(index) == atkPawn) {
							pawns.remove(atkPawn);
							
						}
					}					
				}
				
				else {
					System.out.println("personne gagne");
					pawns.remove(atkPawn);
					pawnsEnemy.remove(defPawn);
				}
				

		}
	public void boatShoot(Pawn boat, Pawn sidePawn) {
		
		int boatX=boat.getPosition().getColumn();
		int boatY=boat.getPosition().getLine();
		int sidePawnX=sidePawn.getPosition().getColumn();
		int sidePawnY=sidePawn.getPosition().getLine();
	
		
			if ((boatX == sidePawnX+2 || 
					boatX == sidePawnX-2) && (boatY == sidePawnY)) 
			{	
				pawnsEnemy.remove(sidePawn);
			}
	
		
	
	
}
	
	public void reset() {
		pawns.clear();
		pawnsEnemy.clear();
		buildings.clear();
		
		creatBuilding();
		createAllyTeam();
		createEnemyTeam();
	}
	
	public void creatBuilding() {
		hq_1 = new HQ(map.getBlock(0, 3));
		hq_2 = new HQ(map.getBlock(0, 5));
		hq_3 = new HQ(map.getBlock(12, 3));
		hq_4 = new HQ(map.getBlock(12, 5));
		
		frontline_1 = new Frontline(map.getBlock(6, 2));
		frontline_2 = new Frontline(map.getBlock(6, 4));
		frontline_3 = new Frontline(map.getBlock(6, 6));
		
		camp_1 = new Camp(map.getBlock(2, 3));
		camp_2 = new Camp(map.getBlock(2, 5));
		camp_3 = new Camp(map.getBlock(4, 3));
		camp_4 = new Camp(map.getBlock(4, 5));
		camp_5 = new Camp(map.getBlock(8, 3));
		camp_6 = new Camp(map.getBlock(8, 5));
		camp_7 = new Camp(map.getBlock(10, 3));
		camp_8 = new Camp(map.getBlock(10, 5));

		buildings.add(hq_1);
		buildings.add(hq_2);		
		buildings.add(hq_3);
		buildings.add(hq_4);
		
		buildings.add(frontline_1);
		buildings.add(frontline_2);
		buildings.add(frontline_3);
		
		buildings.add(camp_1);
		buildings.add(camp_2);
		buildings.add(camp_3);
		buildings.add(camp_4);
		buildings.add(camp_5);
		buildings.add(camp_6);
		buildings.add(camp_7);
		buildings.add(camp_8);


	}
	
	
	
	
	public void createAllyTeam() {
		
		colonel = new Colonel(map.getBlock(0, 2));
		bomb = new Bomb(map.getBlock(0, 3));
		captain = new Captain(map.getBlock(0, 4));
		boat = new Boat(map.getBlock(12, 0));
		bg = new BrigadierGeneral(map.getBlock(0, 6));
		engineer = new Engineer(map.getBlock(1, 2));
		flag = new Flag(map.getBlock(1,3));
		general = new General(map.getBlock(1,4));
		lieutenant = new Lieutenant(map.getBlock(7, 3));
		major = new Major(map.getBlock(1, 6));
		mg = new MajorGeneral(map.getBlock(2, 2));
		marshal = new Marshal(map.getBlock(2, 3));
		mine = new Mine (map.getBlock(2, 4));
			
		pawns.add(colonel);
		pawns.add(bomb);
		pawns.add(captain);
		pawns.add(boat);
		pawns.add(bg);
		pawns.add(engineer);
		pawns.add(flag);
		pawns.add(general);
		pawns.add(lieutenant);
		pawns.add(major);
		pawns.add(mg);
		pawns.add(marshal);
		pawns.add(mine);

	}


	public void createEnemyTeam() {
		
		colonelEnemy = new Colonel(map.getBlock(12, 2));
		bombEnemy = new Bomb(map.getBlock(12, 3));
		captainEnemy = new Captain(map.getBlock(12, 4));
		boatEnemy = new Boat(map.getBlock(0, 8));
		bgEnemy = new BrigadierGeneral(map.getBlock(12, 6));
		engineerEnemy = new Engineer(map.getBlock(11, 2));
		flagEnemy = new Flag(map.getBlock(11,3));
		generalEnemy = new General(map.getBlock(11,4));
		lieutenantEnemy = new Lieutenant(map.getBlock(11, 5));
		majorEnemy = new Major(map.getBlock(11, 6));
		mgEnemy = new MajorGeneral(map.getBlock(10, 2));
		marshalEnemy = new Marshal(map.getBlock(8, 3));
		mineEnemy = new Mine (map.getBlock(10, 4));
		
		pawnsEnemy.add(colonelEnemy);

		pawnsEnemy.add(bombEnemy);
		pawnsEnemy.add(captainEnemy);

		pawnsEnemy.add(boatEnemy);
		pawnsEnemy.add(bgEnemy);

		pawnsEnemy.add(engineerEnemy);

		pawnsEnemy.add(flagEnemy);
		pawnsEnemy.add(generalEnemy);
		pawnsEnemy.add(lieutenantEnemy);

		pawnsEnemy.add(majorEnemy);

		pawnsEnemy.add(mgEnemy);

		pawnsEnemy.add(marshalEnemy);
		pawnsEnemy.add(mineEnemy);

	}
	
	public List<Pawn> getPawnsAlly(){
		
		return pawns;
	}


	public void addPawnAlly(Pawn pawn) {
		pawns.add(pawn);
	}
	
	public Map getMap() {
		return map;
	}


	public void setMap(Map map) {
		this.map = map;
	}


	public MobileElementManager(Map map) {
		this.map = map;
	}


	public List<Pawn> getPawnsEnemy() {
		return pawnsEnemy;
	}

	public void setPawnsEnemy(List<Pawn> pawnsEnemy) {
		this.pawnsEnemy = pawnsEnemy;
	}
	
	public void addPawnsEnemy(Pawn pawn)
	{
		pawnsEnemy.add(pawn);
	}

	public List <Building> getBuildings() {
		return buildings;
	}

	public void setBuildings(List <Building> buildings) {
		this.buildings = buildings;
	}
	
	public void addBuilding(Building building) {
		buildings.add(building);
	}
	public Colonel getColonel() {
		return colonel;
	}

	public void setColonel(Colonel colonel) {
		this.colonel = colonel;
	}

	public Bomb getBomb() {
		return bomb;
	}

	public void setBomb(Bomb bomb) {
		this.bomb = bomb;
	}

	public Captain getCaptain() {
		return captain;
	}

	public void setCaptain(Captain captain) {
		this.captain = captain;
	}

	public Boat getBoat() {
		return boat;
	}

	public void setBoat(Boat boat) {
		this.boat = boat;
	}

	public BrigadierGeneral getBg() {
		return bg;
	}

	public void setBg(BrigadierGeneral bg) {
		this.bg = bg;
	}

	public Engineer getEngineer() {
		return engineer;
	}

	public void setEngineer(Engineer engineer) {
		this.engineer = engineer;
	}

	public Flag getFlag() {
		return flag;
	}

	public void setFlag(Flag flag) {
		this.flag = flag;
	}

	public General getGeneral() {
		return general;
	}

	public void setGeneral(General general) {
		this.general = general;
	}

	public Lieutenant getLieutenant() {
		return lieutenant;
	}

	public void setLieutenant(Lieutenant lieutenant) {
		this.lieutenant = lieutenant;
	}

	public Major getMajor() {
		return major;
	}

	public void setMajor(Major major) {
		this.major = major;
	}

	public MajorGeneral getMg() {
		return mg;
	}

	public void setMg(MajorGeneral mg) {
		this.mg = mg;
	}

	public Marshal getMarshal() {
		return marshal;
	}

	public void setMarshal(Marshal marshal) {
		this.marshal = marshal;
	}

	public Mine getMine() {
		return mine;
	}

	public void setMine(Mine mine) {
		this.mine = mine;
	}
	public Colonel getColonelEnemy() {
		return colonelEnemy;
	}

	public void setColonelEnemy(Colonel colonelEnemy) {
		this.colonelEnemy = colonelEnemy;
	}

	public Bomb getBombEnemy() {
		return bombEnemy;
	}

	public void setBombEnemy(Bomb bombEnemy) {
		this.bombEnemy = bombEnemy;
	}

	public Captain getCaptainEnemy() {
		return captainEnemy;
	}

	public void setCaptainEnemy(Captain captainEnemy) {
		this.captainEnemy = captainEnemy;
	}

	public Boat getBoatEnemy() {
		return boatEnemy;
	}

	public void setBoatEnemy(Boat boatEnemy) {
		this.boatEnemy = boatEnemy;
	}

	public BrigadierGeneral getBgEnemy() {
		return bgEnemy;
	}

	public void setBgEnemy(BrigadierGeneral bgEnemy) {
		this.bgEnemy = bgEnemy;
	}

	public Engineer getEngineerEnemy() {
		return engineerEnemy;
	}

	public void setEngineerEnemy(Engineer engineerEnemy) {
		this.engineerEnemy = engineerEnemy;
	}

	public Flag getFlagEnemy() {
		return flagEnemy;
	}

	public void setFlagEnemy(Flag flagEnemy) {
		this.flagEnemy = flagEnemy;
	}

	public General getGeneralEnemy() {
		return generalEnemy;
	}

	public void setGeneralEnemy(General generalEnemy) {
		this.generalEnemy = generalEnemy;
	}

	public Lieutenant getLieutenantEnemy() {
		return lieutenantEnemy;
	}

	public void setLieutenantEnemy(Lieutenant lieutenantEnemy) {
		this.lieutenantEnemy = lieutenantEnemy;
	}

	public Major getMajorEnemy() {
		return majorEnemy;
	}

	public void setMajorEnemy(Major majorEnemy) {
		this.majorEnemy = majorEnemy;
	}

	public MajorGeneral getMgEnemy() {
		return mgEnemy;
	}

	public void setMgEnemy(MajorGeneral mgEnemy) {
		this.mgEnemy = mgEnemy;
	}

	public Marshal getMarshalEnemy() {
		return marshalEnemy;
	}

	public void setMarshalEnemy(Marshal marshalEnemy) {
		this.marshalEnemy = marshalEnemy;
	}

	public Mine getMineEnemy() {
		return mineEnemy;
	}

	public void setMineEnemy(Mine mineEnemy) {
		this.mineEnemy = mineEnemy;
	}
	
}


