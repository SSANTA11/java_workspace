package entities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import core.CameraViewLogic;
import core.GameManager;
import core.SourceManager;

public class Turret extends Entity {
	private int HP = 1000;
	private int turretWorldX, turretWorldY;
	private int turretScreenX, turretScreenY;
	private int width;
	private int height;
	private boolean dead = false;
	private BufferedImage turretIMG;
	private double tAngle;
	private long lastFireTime = 0;

	public Turret(int turretWorldX, int turretWorldY) {
		this.turretIMG = SourceManager.getInstance().getIMGSource("turret");
		this.width = turretIMG.getWidth() / 4;
		this.height = turretIMG.getHeight() / 4;
		this.turretWorldX = turretWorldX;
		this.turretWorldY = turretWorldY;
	}

	public void trackAndKillTarget() {
		double playerWorldX = GameManager.getInstance().getPlayer().getPlayerWorldCenterX();
		double playerWorldY = GameManager.getInstance().getPlayer().getPlayerWorldCenterY();
		double distance = (playerWorldX - turretWorldX) * (playerWorldX - turretWorldX)
				+ (playerWorldY - turretWorldY) * (playerWorldY - turretWorldY);
		if (distance < 800000) {
			tAngle = Math.atan2(playerWorldY - turretWorldY, playerWorldX - turretWorldX);
			long start = System.currentTimeMillis();
			if (start - lastFireTime > 600) {
				fire();
				lastFireTime = start;
				System.out.println("발사");
			}
		}
	}

	@Override
	public int getHP() {
		return HP;
	}

	@Override
	public Rectangle getBound() {
		return new Rectangle(turretWorldX, turretWorldY, width, height);
	}

	@Override
	public int getDamage() {
		return 2;
	}

	@Override
	public void setHp(int damage) {
		this.HP -= damage;
	}

	@Override
	public boolean isDead() {
		return dead;
	}

	@Override
	public void destroy() {
		if (HP <= 0)
			this.dead = true;
	}

	@Override
	public void update() {
		if (!isDead()) {
			trackAndKillTarget();
			turretScreenX = turretWorldX - (int) CameraViewLogic.getInstance().getViewPortworldX();
			turretScreenY = turretWorldY - (int) CameraViewLogic.getInstance().getViewPortworldY();
		}

	}

	private void fire() {
		GameManager.getInstance().makeProjectile("ENEMY_HEAT", turretWorldX + width / 4, turretWorldY + height / 2, tAngle,
				23);
	}

	@Override
	public void draw(Graphics g) {
		if (!isDead()) {
			Graphics2D g2 = (Graphics2D) g.create();

			g2.rotate(tAngle, turretScreenX + width / 4, turretScreenY + height / 2);
			g2.drawImage(turretIMG, turretScreenX, turretScreenY, width, height, null);
			g2.dispose();

		} else {
			g.setColor(Color.red);
			g.fillRect(turretScreenX, turretScreenY, width, height);
		}
	}

}
