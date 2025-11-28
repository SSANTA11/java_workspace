package core;

import javax.swing.JPanel;

import view.GameWindow;

public class GameManager {
	private static GameManager gameManager;

	private GameManager() {
	}

	public static GameManager getInstance() {
		if (gameManager == null) {
			gameManager = new GameManager();
		}
		return gameManager;
	}

	public static void main(String[] args) {
		GameManager.getInstance();
		JPanel mainPanel = UIManager.getInstance().getMainPanel();
		GameWindow gw = new GameWindow(mainPanel);
		UIManager.getInstance().insertWindow(gw);

	}

}
