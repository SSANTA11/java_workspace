package core;

<<<<<<< HEAD
import javax.swing.JPanel;
=======
import javax.swing.JPanel; // ⭐ 불필요한 import 제거
>>>>>>> f183d83cef6e891962a6f13ab6eff94f2df77719
import entities.*;
import view.GamePanel;
import view.GameWindow;

public class GameManager {

	private static final GameManager instance = new GameManager();

	private GameWindow gameWindow;

<<<<<<< HEAD
	public void initialize(GameWindow gameWindow) {
		this.gameWindow = gameWindow;
	}

=======
>>>>>>> f183d83cef6e891962a6f13ab6eff94f2df77719
	private GameManager() {
	}

	public static GameManager getInstance() {
		return instance;
	}

<<<<<<< HEAD
=======
	public void initialize(GameWindow gamWindow) {
		this.gameWindow = gameWindow;
	}
>>>>>>> f183d83cef6e891962a6f13ab6eff94f2df77719

	public void destroyEntity(Entity e) {

	};

	public void applyDamage(Entity e) {

	};

	public void handleHP(Entity e) {

	};

<<<<<<< HEAD
	public void changePanel(String panelName) {
		if (gameWindow != null) {
			gameWindow.changePanel(panelName);
		} else {
			System.err.println("GameWindow 초기화 안됨");
=======
	// ⭐ 화면 전환 로직 메서드 이름과 인자를 통일합니다.
	public void changePanel(String panelName) {
		// ⭐ GameWindow 객체를 통해 화면 전환 메서드를 호출합니다.
		if (gameWindow != null) {
			gameWindow.changePanel(panelName);
		} else {
			// 디버깅 용: 초기화가 안된 경우 오류 알림
			System.err.println("GameManager가 GameWindow로 초기화되지 않았습니다!");
>>>>>>> f183d83cef6e891962a6f13ab6eff94f2df77719
		}
	}
}