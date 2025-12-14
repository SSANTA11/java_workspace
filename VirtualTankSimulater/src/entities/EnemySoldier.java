package entities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import core.CameraViewLogic;
import core.GameManager;
import core.SourceManager;

public class EnemySoldier extends Entity {
	private double worldX, worldY;
	private int screenX, screenY;
	private int width = 15, height = 10;

	private int HP = 10;
	private double speed = 0.5;
	private double detectionDistance = 640000;
	private double attackDistsance = 90000;

	private boolean dead = false;
	private double radian;
	private long lastFireTime = 0;
	private BufferedImage soldierIMG;

	public EnemySoldier(int startX, int startY) {
		this.soldierIMG = SourceManager.getInstance().getIMGSource("soldier");

		this.worldX = startX;
		this.worldY = startY;
	}

	@Override
	public void setPosition() {
		worldX += 1;
		worldY += 1;
	}

	@Override
	public void update() {
		if (isDead())
			return;
		trackAndKillTarget();
		screenX = (int) worldX - (int) CameraViewLogic.getInstance().getViewPortworldX();
		screenY = (int) worldY - (int) CameraViewLogic.getInstance().getViewPortworldY();
	}

	private void trackAndKillTarget() {

		double pX = GameManager.getInstance().getPlayer().getPlayerWorldCenterX();
		double pY = GameManager.getInstance().getPlayer().getPlayerWorldCenterY();

		double distance = (pX - worldX) * (pX - worldX) + (pY - worldY) * (pY - worldY);
		if (distance < detectionDistance && detectionDistance - distance > 2000) {
			this.radian = Math.atan2(pY - worldY, pX - worldX);
			if (distance < attackDistsance) {
				long currentTime = System.currentTimeMillis();
				if (currentTime - lastFireTime > 800) {
					fire();
					lastFireTime = currentTime;
				} else if (distance < detectionDistance) {
					worldX -= Math.cos(radian) * speed;
					worldY -= Math.sin(radian) * speed;
				}
			} else {
				worldX += Math.cos(radian) * speed;
				worldY += Math.sin(radian) * speed;
			}
		}
	}

	private void fire() {
		GameManager.getInstance().makeProjectile("ENEMY_MG", (int) (worldX + width / 2), (int) (worldY + height / 2),
				radian, 2, Color.blue);
		System.out.println("보병 발사");
	}

	@Override
	public void draw(Graphics g) {
		if (!isDead()) {
			Graphics2D g2 = (Graphics2D) g.create();

			int centerX = screenX + width / 2;
			int centerY = screenY + height / 2;

			g2.rotate(radian, centerX, centerY);

			g2.drawImage(soldierIMG, screenX, screenY, width, height, null);
			g2.dispose();
		} else {
			g.setColor(Color.gray);
			g.fillRect(screenX, screenY, width, height);
		}
	}

	@Override
	public Rectangle getBound() {
		return new Rectangle((int) worldX, (int) worldY, width, height);
	}

	@Override
	public int getHP() {
		return HP;
	}

	@Override
	public int getDamage() {
		return 5;
	}

	@Override
	public void setHp(int damage) {
		this.HP -= damage;
		if (this.HP <= 0)
			destroy();
	}

	@Override
	public boolean isDead() {
		return dead;
	}

	@Override
	public void destroy() {
		this.dead = true;
	}
}