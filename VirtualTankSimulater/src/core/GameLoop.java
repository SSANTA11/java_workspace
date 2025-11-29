package core;

public class GameLoop implements Runnable {
	private static GameLoop gameLoop;
	private volatile boolean flag = true;
	private final int TARGET_FPS = 60;
	private final int TARGET_TIME = 1000 / TARGET_FPS;

	private GameLoop() {

	}

	public static GameLoop getInstance() {
		if (gameLoop == null) {
			gameLoop = new GameLoop();
		}
		return gameLoop;
	}

	public void stopGameLoop() {
		this.flag = false;
		System.out.println("스레드 실행 중, 반복문 정지");
	}

	public void startGameLoop() {
		System.out.println("스레드 실행 중, 반복문 실행");
		this.flag = true;
	}

	@Override
	public void run() {
		System.out.println("스레드 실행 중 ");
		long startTime;
		long timeUsed;
		long sleepTime;

		while (flag) {
			startTime = System.currentTimeMillis();
			// 로직
			timeUsed = System.currentTimeMillis() - startTime;
			sleepTime = TARGET_TIME - timeUsed;

			if (sleepTime > 0) {
				try {
					Thread.sleep(Math.max(0, sleepTime));
				} catch (InterruptedException e) {
					System.err.println("GameLoop 스레드 종료됨.");
				}
			}

		}
	}

}
