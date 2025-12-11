package core;

import java.awt.Graphics;
import java.awt.event.KeyEvent;

import entities.Projectile;

public class Weapons {
	private static Weapons weapons = new Weapons();

	private Weapons() {
	}

	private int fireDelay;
	private String weapon = "MG";
	private long lastFireTime = 0;

	public void fireControl(int keyCode) {
		switch (keyCode) {
		case KeyEvent.VK_1:
			this.weapon = "MG";
			System.out.println("공축기관총 선택");
			fireDelay = 100;
			break;
		case KeyEvent.VK_2:
			this.weapon = "AP";
			System.out.println("철갑탄 선택");
			fireDelay = 500;
			break;
		case KeyEvent.VK_3:
			this.weapon = "HEAT";
			System.out.println("대전차고폭탄 선택");
			fireDelay = 600;
			break;
		case KeyEvent.VK_C:
			long start = System.currentTimeMillis();
			if (start - lastFireTime > fireDelay) {
				fire();
				lastFireTime = start;
				System.out.println("발사");
			}
			break;
		}
	}

	public void fire() {
		Projectile projectile = GameManager.getInstance().makeProjectile(weapon);
		Graphics g = UIManager.getInstance().getGamePanel().getGraphics();
		projectile.draw(g);
	}

	public static Weapons getInstance() {
		return weapons;
	}
}
