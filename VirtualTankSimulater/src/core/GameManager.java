package core;

import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;

import entities.Entity;
import entities.Projectile;
import entities.Tank;
import entities.Wall;
import view.GameWindow;

public class GameManager {
	private ArrayList<Entity> arr = new ArrayList<>();
	private final ArrayList<Projectile> projectiles = new ArrayList<>();
	private final ArrayList<Wall> walls = new ArrayList<>();
	private static GameManager gameManager = new GameManager();
	private Tank tank;

	private GameManager() {
	}

	public static GameManager getInstance() {
		return gameManager;
	}

	public void makePlayer() {
		this.tank = new Tank();
	}

	public Tank getPlayer() {
		return tank;
	}

	public void makeProjectile(String weapon, int X, int Y, double angleT) {
		Graphics g=UIManager.getInstance().getGamePanel().getGraphics();
		Projectile newProj = new Projectile(weapon, X, Y, angleT);
		arr.add(newProj);
		projectiles.add(newProj);
		System.out.println(arr.size() + "발사체 생성");
		newProj.draw(g, X, Y);
	}

	public void removeProjectile(Projectile proj) {
		arr.remove(proj);
		projectiles.remove(proj);
		System.out.println(
				"발사체가 탄착하여, 혹은 사거리를 다하여 제거되었습니다. 현재 entity 수: " + arr.size() + ", 필드 위 발사체 수: " + projectiles.size());
	}

	public ArrayList<Projectile> getProjList() {
		return projectiles;
	}

	public static void main(String[] args) {
		SourceManager sourceManager = SourceManager.getInstance();
		gameManager.makePlayer();
		JPanel mainPanel = UIManager.getInstance().getMainPanel();
		GameWindow gameWindow = new GameWindow(mainPanel);
		UIManager.getInstance().insertWindow(gameWindow);
		new Thread(new GameLoop()).start();
	}

}
