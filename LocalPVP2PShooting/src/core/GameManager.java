package core;

import java.util.ArrayList;

import entities.*;
import view.GameWindow;

public class GameManager {
	private ArrayList<Player> arr = new ArrayList<>();
	private static final GameManager instance = new GameManager();
	private GameWindow gameWindow;

	private GameManager() {
	}

	public static GameManager getInstance() {
		return instance;
	}

	public void makePlayer() {
		arr.add(new Player());
		System.out.println(arr.size() + "번째 플레이어 생성");
	}

	public Player getPlayer(int index) {
		return arr.get(index);
	}

	public void removePlayer(int index) {
		arr.remove(index);
		System.out.println("플레이어가 제거되었습니다. 현재 플레이어 수: " + arr.size());
	}

	public void initialize(GameWindow gameWindow) {
		this.gameWindow = gameWindow;
	}

	public void applyDamage(Entity e) {
	}

	public void handleHP(Entity e) {

	}

	public void updateGame() {
		Player MAINPLAYER = arr.get(0);
		MAINPLAYER.updatePosition();
		gameWindow.getGamePanel().repaint();
	}

	public void changePanel(String panelName) {
		if (gameWindow != null) {
			gameWindow.changePanel(panelName);
		} else {
			System.err.println("GameManager가 GameWindow로 초기화되지 않았습니다!");
		}
	}
}