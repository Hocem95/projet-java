package engine.process;


import config.GameConfiguration;
import engine.map.Map;

public class GameBuilder {

	public static Map buildMap() {
		return new Map(GameConfiguration.LINE_COUNT, GameConfiguration.COLUMN_COUNT);
	}

	public static MobileElementManager buildInitMobile(Map map) {
		MobileElementManager manager = new MobileElementManager(map);
		
		
		manager.createAllyTeam();
		manager.createEnemyTeam();

		return manager;
	}

}