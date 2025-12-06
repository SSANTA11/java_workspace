package entities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import core.CameraViewLogic;
import core.GameManager;

public class Projectile extends Entity {
	private double worldX, worldY;

	private int speed;
	private int range;
	private double angleT; // 발사 각도
	private int damage;
	private int explosionRange;
	private int width, height;
	private int HP = 1;
	private boolean dead = false;

	public Projectile(String weapon) {
		switch (weapon) {
		case "MG":
			this.speed = 20;
			this.range = 60;
			this.explosionRange = 0;
			this.damage = 3;
			this.width = 4;
			this.height = 4;
			break;
		case "AP":
			this.speed = 30;
			this.range = 100;
			this.explosionRange = 0;
			this.damage = 20;
			this.width = 6;
			this.height = 8;
			break;
		case "HEAT":
			this.speed = 25;
			this.range = 80;
			this.explosionRange = 300;
			this.damage = 100;
			this.width = 6;
			this.height = 8;
			break;
		}

		Tank player = GameManager.getInstance().getPlayer();

		this.angleT = Math.toRadians(player.getPlayerAngle());

		this.worldX = player.getCenterX() + speed * Math.cos(angleT) * 4;
		this.worldY = player.getCenterY() + speed * Math.sin(angleT) * 4;
	}

	@Override
	public void update() {
		if (!isDead()) {
			worldX += speed * Math.cos(angleT);
			worldY += speed * Math.sin(angleT);

			range--;
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

			g.setColor(Color.RED);
			g.fillRect(screenX, screenY, width, height);

			if (range < 2 && explosionRange > 0) {
				g.drawOval(screenX - explosionRange / 2, screenY - explosionRange / 2, explosionRange, explosionRange);
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
	public void setHp(int damage) {
		this.HP -= damage;
	}

	@Override
	public int getHP() {
		return HP;
	}

	@Override
	public void destroy() {
		if (HP <= 0)
			this.dead = true;
	}
}