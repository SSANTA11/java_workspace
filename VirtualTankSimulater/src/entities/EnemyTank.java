package entities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import core.CameraViewLogic;
import core.GameManager;
import core.SourceManager;

public class EnemyTank implements Entity, Enemy {
	private double worldX, worldY;
	private int screenX, screenY;
	private int HP = 100;
	private double detectionDistance = 640000;
	private double attackDistsance = 400000;
	private long lastFireTime = 0;

	private final int MOVING_SPEED = 2;

	private BufferedImage tankTopIMG;
	private BufferedImage tankBottomIMG;

	private double radian;
	private final int TANK_TOP_WIDTH;
	private final int TANK_TOP_HEIGHT;
	private final int TANK_BOTTOM_WIDTH;
	private final int TANK_BOTTOM_HEIGHT;

	private boolean dead = false;
	private boolean forwardFlag;

	public EnemyTank(int startX, int startY) {
		this.worldX = startX;
		this.worldY = startY;

		this.tankTopIMG = SourceManager.getInstance().getIMGSource("tankTopE");
		this.tankBottomIMG = SourceManager.getInstance().getIMGSource("tankBottomE");

		this.TANK_BOTTOM_WIDTH = tankBottomIMG.getWidth() / 16;
		this.TANK_BOTTOM_HEIGHT = tankBottomIMG.getHeight() / 16;
		this.TANK_TOP_WIDTH = tankTopIMG.getWidth() / 20;
		this.TANK_TOP_HEIGHT = tankTopIMG.getHeight() / 20;

	}

	@Override
	public void update() {
		trackAndKillTargetOrReturn();
		screenX = (int) worldX - (int) CameraViewLogic.getInstance().getViewPortworldX();
		screenY = (int) worldY - (int) CameraViewLogic.getInstance().getViewPortworldY();

	}

	private void trackAndKillTargetOrReturn() {
		double playerX = GameManager.getInstance().getPlayer().getCenterX();
		double playerY = GameManager.getInstance().getPlayer().getCenterY();

		double deltaX = playerX - getCenterX();
		double deltaY = playerY - getCenterY();
		double distance = deltaX * deltaX + deltaY * deltaY;

		if (distance < detectionDistance) {
			this.radian = Math.atan2(deltaY, deltaX);
			if (distance < attackDistsance) {
				long currentTime = System.currentTimeMillis();
				if (currentTime - lastFireTime > 1200) {
					fire();
					lastFireTime = currentTime;
				} else {
					forwardFlag = false;
					worldX -= Math.cos(radian) * (MOVING_SPEED);
					worldY -= Math.sin(radian) * (MOVING_SPEED);
				}
			} else {
				forwardFlag = true;
				worldX += Math.cos(radian) * (MOVING_SPEED);
				worldY += Math.sin(radian) * (MOVING_SPEED);
			}
		}
	}

	private void fire() {
		double bulletStartX = getCenterX();
		double bulletStartY = getCenterY();

		GameManager.getInstance().makeProjectile("AP", bulletStartX, bulletStartY, this.radian, 10, Color.BLACK);

		System.out.println("적 탱크 사격");
	}

	@Override
	public void draw(Graphics g) {

		double centerX = screenX + TANK_BOTTOM_WIDTH / 2;
		double centerY = screenY + TANK_BOTTOM_HEIGHT / 2;

		g.setColor(Color.blue);
		g.fillRect((int) centerX - TANK_BOTTOM_WIDTH / 2, (int) centerY - 50, (int) (HP / 100.0), 5);

		Graphics2D g2b = (Graphics2D) g.create();
		g2b.rotate(radian, centerX, centerY);
		g2b.drawImage(tankBottomIMG, screenX, screenY, TANK_BOTTOM_WIDTH, TANK_BOTTOM_HEIGHT, null);
		g2b.dispose();

		Graphics2D g2t = (Graphics2D) g.create();
		g2t.rotate(radian, centerX, centerY);
		int topX = screenX + (TANK_BOTTOM_WIDTH - TANK_TOP_WIDTH) / 2 + 10;
		int topY = screenY + (TANK_BOTTOM_HEIGHT - TANK_TOP_HEIGHT) / 2;
		g2t.drawImage(tankTopIMG, topX, topY, TANK_TOP_WIDTH, TANK_TOP_HEIGHT, null);
		g2t.dispose();

	}

	@Override
	public Rectangle getBound() {
		return new Rectangle((int) worldX, (int) worldY, TANK_BOTTOM_WIDTH, TANK_BOTTOM_HEIGHT);
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
	public void takeDamage(int damage) {
		this.HP -= damage;
		if (this.HP <= 0) {
			this.HP = 0;
			destroy();
		}
	}

	@Override
	public boolean isDead() {
		return dead;
	}

	@Override
	public void destroy() {
		this.dead = true;
	}

	@Override
	public double getCenterX() {
		return worldX + TANK_BOTTOM_WIDTH / 2.0;
	}

	@Override
	public double getCenterY() {
		return worldY + TANK_BOTTOM_HEIGHT / 2.0;
	}

	@Override
	public void setPosition() {
		double deltaX = (MOVING_SPEED) * Math.cos(radian);
		double deltaY = (MOVING_SPEED) * Math.sin(radian);
		if (forwardFlag) {
			this.worldX -= deltaX;
			this.worldY -= deltaY;
		} else {
			this.worldX += deltaX;
			this.worldY += deltaY;
		}
	}
}