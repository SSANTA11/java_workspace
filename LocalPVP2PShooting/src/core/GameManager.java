package core;

import entities.*;
import view.GameWindow;

public class GameManager {

	private static final GameManager instance = new GameManager();
	private GameWindow gameWindow;

	private GameManager() {
	}

	public void initialize(GameWindow gameWindow) {
		this.gameWindow = gameWindow;
		Player.getInstance().initialize(this);
	}

	public static GameManager getInstance() {
		return instance;
	}

	public void destroyEntity(Entity e) {

	};

	public void applyDamage(Entity e) {

	};

	public void handleHP(Entity e) {

	};

	public void changePanel(String panelName) {
		if (gameWindow != null) {
			gameWindow.changePanel(panelName);
		} else {
			System.err.println("GameManager가 GameWindow로 초기화되지 않았습니다!");
		}
	}
}