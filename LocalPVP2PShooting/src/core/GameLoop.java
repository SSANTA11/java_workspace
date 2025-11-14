package core;

import view.GamePanel;

public class GameLoop implements Runnable {

	private final GameManager gameManager;
	private final GamePanel gamePanel;

	private static final int TARGET_FPS = 120;
	private static final long TARGET_TIME = 1000 / TARGET_FPS;
	private volatile boolean running = true;

	public GameLoop(GameManager manager, GamePanel panel) {
		this.gameManager = manager;
		this.gamePanel = panel;
	}

	@Override
	public void run() {
		long startTime;
		long timeUsed;
		long sleepTime;

		System.out.println("스레드 실행 중 ");
		while (running) {
			startTime = System.currentTimeMillis();

			gameManager.updateGame();
			gamePanel.repaint();

			timeUsed = System.currentTimeMillis() - startTime;
			sleepTime = TARGET_TIME - timeUsed;

			if (sleepTime > 0) {
				try {
					Thread.sleep(sleepTime);
				} catch (InterruptedException e) {
					Thread.currentThread().interrupt();
					System.err.println("GameLoop 스레드 종료됨.");
				}
			}

		}
	}

	public void stopLoop() {
		this.running = false;
	}
}