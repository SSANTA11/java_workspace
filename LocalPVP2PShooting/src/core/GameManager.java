package core;

import java.util.ArrayList;

import entities.*;
import view.GamePanel;
import view.GameWindow;
import view.OptionPanel;
import view.TitlePanel;

public class GameManager {
	private ArrayList<Entity> arr = new ArrayList<>();
	private final ArrayList<Projectile> projectiles = new ArrayList<>();
	private final ArrayList<Wall> walls = new ArrayList<>();
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

	public Player getMainPlayer() {
		return (Player) arr.get(0);
	}

	public MapManager getMapManager() {
		return mapManager;
	}

	public Camera getCamera() {
		return camera;
	}

	public ArrayList<Entity> getList() {
		return arr;
	}

	public void makePlayer() {
		arr.add(new Player(camera, MapManager.MAP_WIDTH, MapManager.MAP_HEIGHT));
		System.out.println(arr.size() + "플레이어 생성");
	}

	public void removeEntity(Entity E) {
		arr.remove(E);
		System.out.println("entity가 제거되었습니다. 현재 entity 수: " + arr.size());
	}

	public void makeProjectile(String weapon, int X, int Y, int angleT) {
		Projectile newProj = new Projectile(weapon, X, Y, angleT);
		arr.add(newProj);
		projectiles.add(newProj);
		System.out.println(arr.size() + "발사체 생성");
	}

	public void removeProjectile(Projectile proj) {
		arr.remove(proj);
		projectiles.remove(proj);
		System.out.println(
				"발사체가 탄착하여, 혹은 사거리를 다하여 제거되었습니다. 현재 entity 수: " + arr.size() + ", 필드 위 발사체 수: " + projectiles.size());
	}

	public Entity getEntity(int index) {
		return arr.get(index);
	}

	public ArrayList<Projectile> getProjList() {
		return projectiles;
	}

	public void initialize() {
		this.makePlayer();
	}

	public void HPhandeler(Entity E, int damage) {
		int HP = E.getHP();
		HP -= damage;
		E.setHP(HP);
	}

	public void updateGame() {
		if (arr.isEmpty()) {
			System.err.println("캐릭터가 없는뎁숑");
			return;
		}
		Player MAINPLAYER = (Player) arr.get(0);
		MAINPLAYER.updatePosition();
	}

	public static void main(String[] args) {
		GameManager manager = GameManager.getInstance();
		manager.initialize();

		TitlePanel titlePanel = new TitlePanel();
		GamePanel gamePanel = new GamePanel();
		OptionPanel optionPanel = new OptionPanel();

		GameWindow gameWindow = new GameWindow(titlePanel, gamePanel, optionPanel);
		manager.getCamera().setWindow(gameWindow);
		new Thread(new GameLoop(manager, gameWindow.gamePanel)).start();
	}
}