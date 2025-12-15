package core;

import java.util.concurrent.CopyOnWriteArrayList;

import entities.Entity;
import view.GamePanel;

public class GameLoop implements Runnable {
	private static GameLoop gameLoop = new GameLoop();
	private volatile boolean flag = true;
	private final int TARGET_FPS = 120;
	private final int TARGET_TIME = 1000 / TARGET_FPS;
	private GamePanel gamePanel;
	private GameManager gameManager;
	private CameraViewLogic cameraViewLogic;

	private GameLoop() {
		this.gamePanel = UIManager.getInstance().getGamePanel();
		this.cameraViewLogic = CameraViewLogic.getInstance();
		this.gameManager = GameManager.getInstance();
	}

	public void stopGameLoop() {
		this.flag = false;
		System.out.println("스레드 실행 중, 반복문 정지");
	}

	public void startGameLoop() {
		System.out.println("스레드 실행 중, 반복문 실행");
		this.flag = true;
	}

	public static GameLoop getInstance() {
		return gameLoop;
	}

	@Override
	public void run() {
		System.out.println("스레드 실행 중 ");
		long startTime;
		long timeUsed;
		long sleepTime;

		while (true) {
			if (flag) {
				startTime = System.currentTimeMillis();

				CopyOnWriteArrayList<Entity> entities = gameManager.getEntities();
				for (Entity e : entities) {
					e.update();
				}
				cameraViewLogic.updateViewPort();
				gameManager.checkEntityLife();
				gameManager.removeEntities();
				CollisionManager.getInstance().isCollision();
				gamePanel.repaint();

				timeUsed = System.currentTimeMillis() - startTime;
				sleepTime = TARGET_TIME - timeUsed;

				if (sleepTime > 0) {
					try {
						Thread.sleep(Math.max(0, sleepTime));
					} catch (InterruptedException e1) {
						System.out.println(e1);
					}

				}
			}
		}
	}

}
