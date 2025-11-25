package entities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import core.GameManager;

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
			this.speed = 15;
			this.range = 50;
			this.explosionRange = 0;
			this.killingTankIsPossible = false;
			this.damage = 3;
			this.width = 4;
			this.height = 4;
			break;

		case "AP":
			this.speed = 12;
			this.range = 300;
			this.explosionRange = 0;
			this.killingTankIsPossible = true;
			this.damage = 20;
			this.width = 6;
			this.height = 8;
			break;

		case "HE":
			this.speed = 12;
			this.range = 300;
			this.explosionRange = 10;
			this.killingTankIsPossible = false;
			this.damage = 3;
			this.width = 6;
			this.height = 8;
			break;

		case "HEAT":
			this.speed = 12;
			this.range = 300;
			this.explosionRange = 0;
			this.killingTankIsPossible = true;
			this.damage = 100;
			this.width = 6;
			this.height = 8;
			break;

		default:
			this.speed = 10;
			this.range = 100;
			this.width = 5;
			this.height = 5;
			break;
		}
		this.WorldX = X;
		this.WorldY = Y;
		this.angleT = angleT;
	}

	@Override
	public void updatePosition() {
		double radians = Math.toRadians(angleT);
		this.WorldX += (int) Math.round(this.speed * Math.cos(radians));
		this.WorldY += (int) Math.round(this.speed * Math.sin(radians));
		this.range--;
		if (this.range <= 0) {
			GameManager.getInstance().removeProjectile(this);
		}
	}

	@Override
	public void draw(Graphics g, int screenX, int screenY) {
		Graphics2D g2 = (Graphics2D) g.create();
		
		g2.setColor(Color.YELLOW);
		g2.rotate(Math.toRadians(angleT), screenX + width / 2, screenY + height / 2);
		g2.fillRect(screenX, screenY, width, height);
		
		g2.dispose();
	}

	@Override
	public int getWidth() {
		return this.width;
	}

	@Override
	public int getHeight() {
		return this.height;
	}

	@Override
	public int getWorldX() {
		return this.WorldX;
	}

	@Override
	public int getWorldY() {
		return this.WorldY;
	}

	@Override
	public String getType() {
		return "PROJECTILE";
	}

	@Override
	public int getHP() {
		return 0;
	}

	@Override
	public int getSpeed() {
		return speed;
	}

	@Override
	public void setPosition(int playerWorldX, int playerWorldY) {
	}

	@Override
	public int setHP(int HP) {
		return 0;
	}

}