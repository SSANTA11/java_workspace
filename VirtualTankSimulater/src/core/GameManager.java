package core;

import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JPanel;

import entities.Entity;
import entities.Projectile;
import entities.Tank;
import entities.Wall;
import view.GameWindow;

public class GameManager {
	private static GameManager gameManager = new GameManager();
	private Tank tank;
	private ArrayList<Entity> entities;

	private GameManager() {
		this.entities = new ArrayList<Entity>();

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

	public void checkSuicideProjectile() {
		Iterator<Entity> iterator = entities.iterator();
		while (iterator.hasNext()) {
			Entity e = iterator.next();
			if (e.isDead()) {
				System.out.println(e.getClass() + "삭제");
				iterator.remove();
			}
		}
	}

	public Tank getPlayer() {
		return tank;
	}

	public void removeEntities() {
		Iterator<Entity> iterator = entities.iterator();
		while (iterator.hasNext()) {
			Entity e = iterator.next();
			if (e.isDead()) {
				System.out.println(e.getClass() + "삭제");
				iterator.remove();
			}
		}
	}

	public ArrayList<Entity> getEntities() {
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
