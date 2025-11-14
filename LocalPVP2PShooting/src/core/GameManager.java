package core;

import java.util.ArrayList;

import entities.*;
import view.Camera;

public class GameManager {
	private ArrayList<Player> arr = new ArrayList<>();
	private static final GameManager instance = new GameManager();

	private final MapManager mapManager;
	private final Camera camera;

	private GameManager() {

		this.mapManager = new MapManager();
		this.camera = new Camera();

	}

	public static GameManager getInstance() {
		return instance;
	}

	public MapManager getMapManager() {
		return mapManager;
	}

	public Camera getCamera() {
		return camera;
	}

	public void makePlayer() {
		arr.add(new Player(camera, MapManager.MAP_WIDTH, MapManager.MAP_HEIGHT));
		System.out.println(arr.size() + "번째 플레이어 생성");
	}

	public Player getPlayer(int index) {
		return arr.get(index);
	}

	public void removePlayer(int index) {
		arr.remove(index);
		System.out.println("플레이어가 제거되었습니다. 현재 플레이어 수: " + arr.size());
	}

	public void initialize() {
		this.makePlayer();
	}

	public void updateGame() {
		synchronized (arr) {
			if (arr.isEmpty()) {
				return;
			}
			Player MAINPLAYER = arr.get(0);
			MAINPLAYER.updatePosition();

			// 📢 매 업데이트마다 카메라 위치를 갱신합니다. (GamePanel의 repaint 전에 실행)
			// Camera.updateCamera()는 이제 GamePanel에서 화면 크기와 함께 호출되어야 합니다.
			// 여기서는 플레이어 위치만 카메라에 전달합니다.
			camera.updatePlayerPosition(MAINPLAYER.getX(), MAINPLAYER.getY());
		}
	}
}