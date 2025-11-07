package core;

import javax.swing.JPanel;
import entities.*;
import view.GamePanel;
import view.GameWindow;

public class GameManager {

	private static final GameManager instance = new GameManager();

	private GameWindow gameWindow;

	public void initialize(GameWindow gameWindow) {
		this.gameWindow = gameWindow;
	}

	private GameManager() {
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
			System.err.println("GameWindow 초기화 안됨");
		}
	}
}