package entities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import core.CameraViewLogic;
import core.ExploManager;

public class Projectile implements Entity {
	private double worldX, worldY;

	private int speed;
	private int range;
	private double radian;
	private int damage;
	private int explosionRange;
	private int width, height;
	private int HP = 1;
	private boolean dead = false;
	private Color color;

	public Projectile(String weapon, double worldX, double WorldY, double radian, int bulletStart, Color color) {
		switch (weapon) {
		case "MG":
			this.speed = 10;
			this.range = 60;
			this.explosionRange = 0;
			this.damage = 10;
			this.width = 4;
			this.height = 4;
			break;
		case "AP":
			this.speed = 5;
			this.range = 100;
			this.explosionRange = 0;
			this.damage = 20;
			this.width = 6;
			this.height = 8;
			break;
		case "HEAT":
			this.speed = 10;
			this.range = 80;
			this.explosionRange = 300;
			this.damage = 100;
			this.width = 6;
			this.height = 8;
			break;
		case "ENEMY_HEAT":
			this.speed = 5;
			this.range = 100;
			this.explosionRange = 200;
			this.damage = 100;
			this.width = 6;
			this.height = 8;
			break;
		case "ENEMY_MG":
			this.speed = 8;
			this.range = 60;
			this.explosionRange = 0;
			this.damage = 3;
			this.width = 4;
			this.height = 4;
			break;
		}

		this.radian = radian;
		this.worldX = worldX + speed * Math.cos(radian) * bulletStart;
		this.worldY = WorldY + speed * Math.sin(radian) * bulletStart;
		this.color = color;
	}

	@Override
	public void update() {
		if (!isDead()) {
			worldX += speed * Math.cos(radian);
			worldY += speed * Math.sin(radian);

			range--;
			if (range < 2 && explosionRange > 0 || HP < 0) {
				ExploManager.getInstance().damageByExplo(worldX, worldY, explosionRange, damage);
			}
			if (range < 0) {
				this.dead = true;
			}
		}
	}

	@Override
	public void draw(Graphics g) {
		if (!isDead()) {
			int screenX = (int) (worldX - CameraViewLogic.getInstance().getViewPortworldX());
			int screenY = (int) (worldY - CameraViewLogic.getInstance().getViewPortworldY());

			g.setColor(color);
			g.fillOval(screenX, screenY, width, height);

			if (range < 2 && explosionRange > 0 || HP < 0) {
				g.fillOval(screenX - explosionRange / 2, screenY - explosionRange / 2, explosionRange, explosionRange);
			}
		}
	}

	@Override
	public Rectangle getBound() {
		return new Rectangle((int) worldX, (int) worldY, width, height);
	}

	@Override
	public boolean isDead() {
		return dead;
	}

	@Override
	public int getDamage() {
		return damage;
	}

	@Override
	public void takeDamage(int damage) {
		this.HP -= damage;
	}

	@Override
	public int getHP() {
		return HP;
	}

	@Override
	public void destroy() {
		this.dead = true;
	}

	@Override
	public double getCenterX() {
		return worldX;
	}

	@Override
	public double getCenterY() {
		return worldY;
	}

	@Override
	public void setPosition() {
		// TODO Auto-generated method stub

	}
}