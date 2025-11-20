package core;

import java.util.ArrayList;

import entities.*;
import view.Camera;

public class GameManager {
	private ArrayList<Entity> arr = new ArrayList<>();
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

	public Entity getPlayer(int index) {
		return arr.get(index);
	}

	public void removePlayer(int index) {
		arr.remove(index);
		System.out.println("entity가 제거되었습니다. 현재 entity 수: " + arr.size());
	}

	public void initialize() {
		this.makePlayer();
	}

	public void updateGame() {
//		synchronized (arr) {
			if (arr.isEmpty()) {
				System.err.println("캐릭터가 없는뎁숑");
				return;
			}
//		}
			Player MAINPLAYER = (Player)arr.get(0);
			MAINPLAYER.updatePosition();
		}
}