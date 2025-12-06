package entities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import core.GameManager;

public class Projectile extends Entity {
	private int speed;
	private int range;
	private double angleT;
	private int damage;
	private int explosionRange;
	private int width;
	private int height;
	private int HP = 1;
	private double playerAngle;
	private boolean dead = false;
	private int projectileScreenX;
	private int projectileScreenY;

	public Projectile(String weapon) {
		switch (weapon) {
		case "MG":
			this.speed = 50;
			this.range = 10;
			this.explosionRange = 0;
			this.damage = 3;
			this.width = 4;
			this.height = 4;
			break;

		case "AP":
			this.speed = 30;
			this.range = 50;
			this.explosionRange = 0;
			this.damage = 20;
			this.width = 6;
			this.height = 8;
			break;

		case "HEAT":
			this.speed = 30;
			this.range = 50;
			this.explosionRange = 300;
			this.damage = 100;
			this.width = 6;
			this.height = 8;
			break;
		}

		this.playerAngle = GameManager.getInstance().getPlayer().getPlayerAngle();
		this.projectileScreenX = (int) GameManager.getInstance().getPlayer().getCenterX();
		this.projectileScreenY = (int) GameManager.getInstance().getPlayer().getCenterY();
	}

	public void update() {
		if (!isDead()) {

			projectileScreenX += speed * Math.cos(angleT);
			projectileScreenY += speed * Math.sin(angleT);
			range--;
			if (range < 0) {
				this.dead = true;
			}
//		else if(만일 충돌했다면){
//			
//		}
		}
	}

	@Override
	public void draw(Graphics g) {
		if (!isDead()) {
			Graphics2D g2 = (Graphics2D) g.create();
			double anlgleT = playerAngle;
			g2.rotate(Math.toRadians(anlgleT), GameManager.getInstance().getPlayer().getCenterX(),
					GameManager.getInstance().getPlayer().getCenterY());
			g2.setColor(Color.RED);
			g2.fillRect(projectileScreenX + 34, projectileScreenY - 4, width, height);
			g2.dispose();
			if (0 < range && range < 2 && explosionRange > 0) {
				Graphics2D ex = (Graphics2D) g.create();
				ex.setColor(Color.RED);
				ex.rotate(Math.toRadians(anlgleT), GameManager.getInstance().getPlayer().getCenterX(),
						GameManager.getInstance().getPlayer().getCenterY());
				ex.fillRect(projectileScreenX - explosionRange / 2, projectileScreenY - explosionRange / 2,
						explosionRange, explosionRange);
				ex.dispose();
			}
		}
	}

	@Override
	public boolean isDead() {
		return dead;
	}

	@Override
	public Rectangle getBound() {
		return new Rectangle(projectileScreenX, projectileScreenY, width, height);
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
	public void destory() {
		if (HP <= 0)
			this.dead = true;
	}

}