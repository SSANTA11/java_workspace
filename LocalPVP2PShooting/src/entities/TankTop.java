package entities;

import java.awt.Graphics;
import java.awt.event.KeyEvent;

import core.GameManager;

public class TankTop extends Entity {
	private int fireDelay;
	private int angleT;
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
			this.weapon = "HE";
			System.out.println("고폭탄 선택");
			fireDelay = 500;
			break;
		case KeyEvent.VK_4:
			this.weapon = "HEAT";
			System.out.println("대전차고폭탄 선택");
			fireDelay = 500;
			break;
		case KeyEvent.VK_C:
			long currentTime = System.currentTimeMillis();
			if (currentTime - lastFireTime > fireDelay) {
				fire();
				lastFireTime = currentTime;
				System.out.println("발사");
			}
			break;
		}
	}

	public void fire() {
		Player player = GameManager.getInstance().getMainPlayer();
		this.angleT = player.getAngleT();

		int centerX = player.getWorldX() + player.getBottomWidth() / 2;
		int centerY = player.getWorldY() + player.getBottomHeight() / 2;

		GameManager.getInstance().makeProjectile(weapon, centerX, centerY, angleT);
	}

	@Override
	public int getWidth() {
		return 0;
	}

	@Override
	public int getHeight() {
		return 0;
	}

	@Override
	public int getWorldX() {
		return 0;
	}

	@Override
	public int getWorldY() {
		return 0;
	}

	@Override
	public String getType() {
		return null;
	}

	@Override
	public int getHP() {
		return 0;
	}

	@Override
	public int getSpeed() {
		return 0;
	}

	@Override
	public void setPosition(int playerWorldX, int playerWorldY) {

	}

	@Override
	public int setHP(int HP) {
		return 0;
	}

	@Override
	public void updatePosition() {
	}

	@Override
	public void draw(Graphics g, int screenX, int screenY) {
	};

}