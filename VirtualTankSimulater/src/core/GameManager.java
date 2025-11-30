package core;

import javax.swing.JPanel;

import entities.Tank;
import view.GameWindow;

public class GameManager {
	private static GameManager gameManager = new GameManager();
	private Tank tank;

	private GameManager() {
	}

	public static GameManager getInstance() {
		return gameManager;
	}

	public void makePlayer() {
		this.tank = new Tank();
	}

	public Tank getPlayer() {
		return tank;
	}

	public static void main(String[] args) {
		gameManager.makePlayer();
		JPanel mainPanel = UIManager.getInstance().getMainPanel();
		GameWindow gameWindow = new GameWindow(mainPanel);
		UIManager.getInstance().insertWindow(gameWindow);
		new Thread(new GameLoop()).start();
	}

}
