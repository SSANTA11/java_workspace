package entities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

import core.CameraViewLogic;
import core.MapManager;
import core.SourceManager;
import core.Weapons;

public class Tank extends Entity {
	private double playerWorldX = 0;
	private double playerWorldY = 500;
	private double playerScreenX;
	private double playerScreenY;
	private int HP = 1000;
	private int damage = 3;
	private final int MOVING_SPEED = 3;
	private final int ROTATION_SPEED = 1;

	private double angleT = 0;
	private double angleB = 0;

	private BufferedImage tankTopIMG;
	private BufferedImage tankBottomIMG;

	private double radianT;
	private double radianB;
	private final int TANK_TOP_WIDTH;
	private final int TANK_TOP_HEIGHT;
	private final int TANK_BOTTOM_WIDTH;
	private final int TANK_BOTTOM_HEIGHT;

	private final int MAP_SIZE;

	private boolean rightB = false, leftB = false, forwardB = false, backwardB = false;
	private boolean rightT = false, leftT = false;

	private double playerScreenCenterX;
	private double playerScreenCenterY;

	private boolean dead = false;

	public Tank() {
		this.tankTopIMG = SourceManager.getInstance().getIMGSource("tankTop");
		this.tankBottomIMG = SourceManager.getInstance().getIMGSource("tankBottom");
		this.TANK_BOTTOM_WIDTH = tankBottomIMG.getWidth() / 16;
		this.TANK_BOTTOM_HEIGHT = tankBottomIMG.getHeight() / 16;
		this.TANK_TOP_WIDTH = tankTopIMG.getWidth() / 20;
		this.TANK_TOP_HEIGHT = tankTopIMG.getHeight() / 20;
		this.MAP_SIZE = MapManager.getInstance().getMAP_SIZE();
	}

	public void setTank(int keyCode, boolean isSelected) {
		Weapons.getInstance().fireControl(keyCode);

		if (keyCode == KeyEvent.VK_Z) {
			rightT = isSelected;
		}
		if (keyCode == KeyEvent.VK_X) {
			leftT = isSelected;
		}

		if (keyCode == KeyEvent.VK_DOWN) {
			backwardB = isSelected;
		} else if (keyCode == KeyEvent.VK_UP) {
			forwardB = isSelected;
		}

		if (keyCode == KeyEvent.VK_LEFT) {
			leftB = isSelected;
		}
		if (keyCode == KeyEvent.VK_RIGHT) {
			rightB = isSelected;
		}

	}

	public void update() {
		if (rightB) {
			angleB += ROTATION_SPEED;
		}
		if (leftB) {
			angleB -= ROTATION_SPEED;
		}
		if (rightT) {
			angleT += ROTATION_SPEED;
		}
		if (leftT) {
			angleT -= ROTATION_SPEED;
		}
		radianT = Math.toRadians(angleT);
		radianB = Math.toRadians(angleB);

		if (forwardB) {
			double deltaX = MOVING_SPEED * Math.cos(radianB);
			double deltaY = MOVING_SPEED * Math.sin(radianB);
			this.playerWorldX += deltaX;
			this.playerWorldY += deltaY;
		} else if (backwardB) {
			double deltaX = (MOVING_SPEED - 1) * Math.cos(radianB);
			double deltaY = (MOVING_SPEED - 1) * Math.sin(radianB);
			this.playerWorldX -= deltaX;
			this.playerWorldY -= deltaY;
		}

		playerWorldX = Math.max(0, Math.min(playerWorldX, MAP_SIZE - TANK_BOTTOM_WIDTH));
		playerWorldY = Math.max(0, Math.min(playerWorldY, MAP_SIZE - TANK_BOTTOM_HEIGHT));
		double viewPortworldX = CameraViewLogic.getInstance().getViewPortworldX();
		double viewPortworldY = CameraViewLogic.getInstance().getViewPortworldY();

		playerScreenX = playerWorldX - viewPortworldX;
		playerScreenY = playerWorldY - viewPortworldY;

		CameraViewLogic.getInstance().update(playerScreenX, playerScreenY);
	}

	public double getPlayerScreenX() {
		return playerScreenX;
	}

	public double getPlayerScreenY() {
		return playerScreenY;

	}

	public void setPlayerSpeed() {
		if (this.forwardB) {
			double deltaX = (MOVING_SPEED) * Math.cos(radianB);
			double deltaY = (MOVING_SPEED) * Math.sin(radianB);
			this.playerWorldX -= deltaX;
			this.playerWorldY -= deltaY;
		} else if (this.backwardB) {
			double deltaX = MOVING_SPEED * Math.cos(radianB);
			double deltaY = MOVING_SPEED * Math.sin(radianB);
			this.playerWorldX += deltaX;
			this.playerWorldY += deltaY;
		}
	}

	public double getRadianT() {
		return radianT;
	}

	@Override
	public void draw(Graphics g) {
		Graphics2D g2b = (Graphics2D) g.create();
		Graphics2D g2t = (Graphics2D) g.create();

		playerScreenCenterX = playerScreenX + TANK_BOTTOM_WIDTH / 2;
		playerScreenCenterY = playerScreenY + TANK_BOTTOM_HEIGHT / 2;
		g2b.setColor(Color.RED);
		g2b.fillRect((int) playerScreenCenterX - HP / 2, (int) playerScreenCenterY - 50, HP, 5);
		g2b.rotate(radianB, playerScreenCenterX, playerScreenCenterY);
		g2b.drawImage(tankBottomIMG, (int) playerScreenX, (int) playerScreenY, TANK_BOTTOM_WIDTH, TANK_BOTTOM_HEIGHT,
				null);
		g2b.dispose();
		g2t.rotate(radianT, playerScreenCenterX, playerScreenCenterY);
		g2t.drawImage(tankTopIMG, (int) playerScreenX + (TANK_BOTTOM_WIDTH - TANK_TOP_WIDTH) / 2 + 10,
				(int) playerScreenY + (TANK_BOTTOM_HEIGHT - TANK_TOP_HEIGHT) / 2, TANK_TOP_WIDTH, TANK_TOP_HEIGHT,
				null);
		g2t.dispose();
	}

	@Override
	public Rectangle getBound() {
		return new Rectangle((int) playerWorldX, (int) playerWorldY, TANK_BOTTOM_WIDTH, TANK_BOTTOM_HEIGHT);
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
	public boolean isDead() {
		return dead;
	}

	@Override
	public void destroy() {
		this.dead = true;
	}

	@Override
	public double getCenterX() {
		return playerWorldX + TANK_BOTTOM_WIDTH / 2;
	}

	@Override
	public double getCenterY() {
		return playerWorldY + TANK_TOP_HEIGHT / 2;
	}
}
