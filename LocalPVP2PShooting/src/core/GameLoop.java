package core;

import entities.Player;
import view.GamePanel;

public class GameLoop implements Runnable {
	Player player = Player.getInstance();
	GamePanel gamePanel;
	final int FPS = 60;
	final long DELAY = 1000 / 60;

	public GameLoop(GamePanel gamePanel) {
		this.gamePanel = gamePanel;
	}

	@Override
	public void run() {
		while (true) {
				player.updatePosition();
				gamePanel.repaint();
			try {
				Thread.sleep(DELAY);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}
}
