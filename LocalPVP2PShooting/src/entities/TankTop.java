package entities;

import java.awt.Graphics;
import java.awt.event.KeyEvent;

import core.GameManager;

public class TankTop extends Entity {
	private int WorldX;
	private int WorldY;
	private int fireDelay;
	private int angleT;
	// 철갑탄(AP): 기본탄, 고폭탄(HE): 대인, 대전차고폭탄(HEAT): 대전차, 공축기관총(MG): 대인
	private String weapon = "MG";

	public void fireControl(int keyCode) {
		switch (keyCode) {
		case KeyEvent.VK_1:
			this.weapon = "MG";
			fireDelay = 5;
			break;
		case KeyEvent.VK_2:
			this.weapon = "AP";
			fireDelay = 10;
			break;
		case KeyEvent.VK_3:
			this.weapon = "HE";
			fireDelay = 10;
			break;
		case KeyEvent.VK_4:
			this.weapon = "HEAT";
			fireDelay = 10;
			break;
		}
	}

	public void fire() {
		this.angleT = GameManager.getInstance().getMainPlayer().getAngleT();
		switch (weapon) {
		case "MG":
			GameManager.getInstance().makeProjectile(weapon, WorldX, WorldY, angleT);
			break;
		case "AP":
			GameManager.getInstance().makeProjectile(weapon, WorldX, WorldY, angleT);
			break;
		case "HE":
			GameManager.getInstance().makeProjectile(weapon, WorldX, WorldY, angleT);
			break;
		case "HEAT":
			GameManager.getInstance().makeProjectile(weapon, WorldX, WorldY, angleT);
			break;

		}
	}

	@Override
	public int getWidth() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getHeight() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getWorldX() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getWorldY() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getHP() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getSpeed() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setPosition(int playerWorldX, int playerWorldY) {
		// TODO Auto-generated method stub

	}

	@Override
	public int setHP(int HP) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void updatePosition() {
	}// 해당 로직 플레이어 클래스에서 차체와 함께 위치

	@Override
	public void draw(Graphics g, int screenX, int screenY) {
		// TODO Auto-generated method stub

	};

}
