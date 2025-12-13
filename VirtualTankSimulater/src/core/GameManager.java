package core;

import java.util.concurrent.CopyOnWriteArrayList;

import javax.swing.JPanel;

import entities.Entity;
import entities.Projectile;
import entities.Tank;
import entities.Turret;
import entities.Wall;
import view.GameWindow;

public class GameManager {
	private static GameManager gameManager = new GameManager();
	private Tank tank;
	private CopyOnWriteArrayList<Entity> entities;

	private GameManager() {
		this.entities = new CopyOnWriteArrayList<Entity>();

	}

	public static GameManager getInstance() {
		return gameManager;
	}

	public void makePlayer() {
		this.tank = new Tank();
		this.entities.add(tank);
	}

	public Projectile makeProjectile(String weapon, double worldX, double worldY, double radian, int bulletStart) {
		Projectile projectile = new Projectile(weapon, worldX, worldY, radian, bulletStart);
		this.entities.add(projectile);
		return projectile;
	}

	public void makeWall(int wallWorldX, int wallWorldY) {
		Wall wall = new Wall(wallWorldX, wallWorldY);
		entities.add(wall);
	}

	public void makeTurret(int turretWorldX, int turretWorldY) {
		Turret turret = new Turret(turretWorldX, turretWorldY);
		entities.add(turret);
	}

	public Tank getPlayer() {
		return tank;
	}

	public void removeEntities() {
		entities.removeIf(e -> {
			if (e.isDead()) {
				System.out.println(e.getClass() + "삭제");
				return true;
			}
			return false;
		});
	}

	public void checkEntityLife() {
		for (Entity e : entities) {
			if (e.isDead())
				continue;
			if (e.getHP() <= 0) {
				e.destroy();
			}
		}
	}

	public void loadMapEntities() {
		char[][] mapData = MapManager.getInstance().getMapData();
		final int TILE_SIZE = MapManager.getInstance().getTILE_SIZE();
		final int TILES = MapManager.getInstance().getTILES();

		for (int y = 0; y < TILES; y++) {
			for (int x = 0; x < TILES; x++) {

				int pixelX = x * TILE_SIZE + TILE_SIZE / 2;
				int pixelY = y * TILE_SIZE + TILE_SIZE / 2;

				switch (mapData[y][x]) {
				case 'w':
					this.makeWall(pixelX, pixelY);
					break;
				case 't':
					this.makeTurret(pixelX, pixelY);
					break;
				}
			}
		}
	}

	public CopyOnWriteArrayList<Entity> getEntities() {
		return entities;

	}

	public static void main(String[] args) {
		MapManager.getInstance().initalize();
		gameManager.makePlayer();
		gameManager.loadMapEntities();

		JPanel mainPanel = UIManager.getInstance().getMainPanel();
		GameWindow gameWindow = new GameWindow(mainPanel);
		UIManager.getInstance().insertWindow(gameWindow);
		new Thread(new GameLoop()).start();
	}
}
