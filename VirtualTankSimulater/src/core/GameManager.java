package core;

import java.util.concurrent.CopyOnWriteArrayList;

import javax.swing.JPanel;

import entities.Entity;
import entities.Projectile;
import entities.Tank;
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

	public Projectile makeProjectile(String weapon) {
		Projectile projectile = new Projectile(weapon);
		this.entities.add(projectile);
		return projectile;
	}

	public void makeWall() {
		Wall wall = new Wall();
		entities.add(wall);
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

	public CopyOnWriteArrayList<Entity> getEntities() {
		return entities;

	}

	public static void main(String[] args) {
		SourceManager sourceManager;
		gameManager.makePlayer();
		gameManager.makeWall();
		JPanel mainPanel = UIManager.getInstance().getMainPanel();
		GameWindow gameWindow = new GameWindow(mainPanel);
		UIManager.getInstance().insertWindow(gameWindow);
		new Thread(new GameLoop()).start();
	}
}
