package core;

import java.awt.Color;
import java.awt.event.KeyEvent;

public class Weapons {
	private static Weapons weapons = new Weapons();

	private int fireDelay;
	private String weapon = "MG";
	private long lastFireTime = 0;

	private Weapons() {
	}

	public void fireControl(int keyCode) {
		switch (keyCode) {
		case KeyEvent.VK_1:
			this.weapon = "MG";
			System.out.println("공축기관총 선택");
			fireDelay = 400;
			break;
		case KeyEvent.VK_2:
			this.weapon = "AP";
			System.out.println("철갑탄 선택");
			fireDelay = 1000;
			break;
		case KeyEvent.VK_3:
			this.weapon = "HEAT";
			System.out.println("대전차고폭탄 선택");
			fireDelay = 1000;
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
		GameManager.getInstance().makeProjectile(weapon, GameManager.getInstance().getPlayer().getCenterX(),
				GameManager.getInstance().getPlayer().getCenterY(), GameManager.getInstance().getPlayer().getRadianT(),
				10, Color.black);
	}

	public static Weapons getInstance() {
		return weapons;
	}
}
