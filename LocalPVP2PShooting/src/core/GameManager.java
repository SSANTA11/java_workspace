package core;

import javax.swing.JPanel; // ⭐ 불필요한 import 제거
import entities.*;
import view.GamePanel;
import view.GameWindow;

public class GameManager {

	private static final GameManager instance = new GameManager();

	private GameWindow gameWindow;

	private GameManager() {
	}

	public static GameManager getInstance() {
		return instance;
	}

	public void initialize(GameWindow gamWindow) {
		this.gameWindow = gameWindow;
	}

	public void destroyEntity(Entity e) {

	};

	public void applyDamage(Entity e) {

	};

	public void handleHP(Entity e) {

	};

	// ⭐ 화면 전환 로직 메서드 이름과 인자를 통일합니다.
	public void changePanel(String panelName) {
		// ⭐ GameWindow 객체를 통해 화면 전환 메서드를 호출합니다.
		if (gameWindow != null) {
			gameWindow.changePanel(panelName);
		} else {
			// 디버깅 용: 초기화가 안된 경우 오류 알림
			System.err.println("GameManager가 GameWindow로 초기화되지 않았습니다!");
		}
	}
}