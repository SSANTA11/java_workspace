package core;

public class GameLoop implements Runnable {

	private GameManager manager = GameManager.getInstance();
	private boolean running = true;

	public GameLoop(GameManager manager) {
	}

	@Override
	public void run() {
		while (running) {
			manager.updateGame();
			try { Thread.sleep(16); } 
			catch (InterruptedException e) {}
		}
	}

}