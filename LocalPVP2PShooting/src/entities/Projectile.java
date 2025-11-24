package entities;

import java.awt.Graphics;

public class Projectile extends Entity {
	private int speed;
	private int range;
	private int WorldX;
	private int WorldY;
	private int angleT;
	private int damage;
	private int explosionRange;
	private boolean killingTankIsPossible;
	private int width;
	private int height;

	public Projectile(String weapon, int X, int Y, int angleT) {
		switch (weapon) {
		case "MG":
			this.speed = 100;
			this.range = 50;
			this.explosionRange = 0;
			this.killingTankIsPossible = false;
			this.damage = 3;
			this.width=1;
			this.height=1;
			break;

		case "AP":
			this.speed = 80;
			this.range = 300;
			this.explosionRange = 0;
			this.killingTankIsPossible = true;
			this.damage = 20;
			this.width=1;
			this.height=2;
			break;

		case "HE":
			this.speed = 80;
			this.range = 300;
			this.explosionRange = 10;
			this.killingTankIsPossible = false;
			this.damage = 3;
			this.width=1;
			this.height=2;
			break;

		case "HEAT":
			this.speed = 80;
			this.range = 300;
			this.explosionRange = 0;
			this.killingTankIsPossible = true;
			this.damage = 100;
			this.width=1;
			this.height=2;
			break;

		}
		this.WorldX = X;
		this.WorldY = Y;
		this.angleT = angleT;
	}

	@Override
	public void updatePosition() {
		// TODO Auto-generated method stub

	}

	@Override
	public void draw(Graphics g, int screenX, int screenY) {
		// TODO Auto-generated method stub

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
		return "PROJECTILE";
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

}
