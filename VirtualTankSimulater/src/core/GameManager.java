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
	private ArrayList<Tank> tanks;
	private ArrayList<Projectile> projectiles;
	private ArrayList<Wall> walls;

	private GameManager() {
		this.entities = new ArrayList<Entity>();
		this.projectiles = new ArrayList<Projectile>();
		this.tanks = new ArrayList<Tank>();
		this.walls = new ArrayList<Wall>();
		this.makeWall();

	}

	public static GameManager getInstance() {
		return gameManager;
	}

	public void makePlayer() {
		this.tank = new Tank();
		this.entities.add(tank);
		this.tanks.add(tank);
	}

	public ArrayList<Projectile> getProjectiles() {
		return projectiles;
	}

	public Projectile makeProjectile(String weapon) {
		Projectile projectile = new Projectile(weapon);
		this.projectiles.add(projectile);
		this.entities.add(projectile);
		return projectile;
	}

	public void makeWall() {
		Wall wall = new Wall();
		walls.add(wall);
		entities.add(wall);
	}

	public void checkSuicideProjectile() {
		Iterator<Projectile> iterator = projectiles.iterator();
		while (iterator.hasNext()) {
			Projectile e = iterator.next();
			if (e.isSuicideFlag()) {
				System.out.println(e.getClass() + "삭제");
				iterator.remove();
			}
		}
	}

	public Tank getPlayer() {
		return tank;
	}

	public void removeEntities() {
		Iterator<Projectile> iterator = projectiles.iterator();
		while (iterator.hasNext()) {
			Projectile e = iterator.next();
			if (e.getHP() == 0) {
				System.out.println(e.getClass() + "삭제");
				iterator.remove();
			}
		}
	}

	public ArrayList<Entity> getEntities() {
		return entities;

	}

	public ArrayList<Wall> getWalls() {
		return walls;
	}

	public static void main(String[] args) {
		SourceManager sourceManager;
		gameManager.makePlayer();
		JPanel mainPanel = UIManager.getInstance().getMainPanel();
		GameWindow gameWindow = new GameWindow(mainPanel);
		UIManager.getInstance().insertWindow(gameWindow);
		new Thread(new GameLoop()).start();
	}
}
