package core;

import javax.swing.JPanel;

import entities.Tank;
import view.GameWindow;

public class GameManager {
	private static GameManager gameManager;
	private Tank tank = new Tank();

	private GameManager() {
	}

	public static GameManager getInstance() {
		if (gameManager == null) {
			gameManager = new GameManager();
		}
		return gameManager;
	}
	public Tank getTank() {
		return tank;
	}
	public static void main(String[] args) {
		GameManager.getInstance();
		JPanel mainPanel = UIManager.getInstance().getMainPanel();
		GameWindow gameWindow = new GameWindow(mainPanel);
		UIManager.getInstance().insertWindow(gameWindow);

	}

}
