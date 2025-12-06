package entities;

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
	private int HP = 100;
	private int damage = 3;
	private final int MOVING_SPEED = 3;
	private final int ROTATION_SPEED = 1;

	private double angleT = 0;
	private double angleB = 0;

	private BufferedImage tankTopIMG;
	private BufferedImage tankBottomIMG;

	private double radiansT;
	private double radiansB;
	private final int TANK_TOP_WIDTH;
	private final int TANK_TOP_HEIGHT;
	private final int TANK_BOTTOM_WIDTH;
	private final int TANK_BOTTOM_HEIGHT;

	private final int MAP_SIZE;

	private boolean rightB = false, leftB = false, forwardB = false, backwardB = false;
	private boolean rightT = false, leftT = false;

	private double centerX;
	private double centerY;

	private boolean dead = false;

	public Tank() {
		this.tankTopIMG = SourceManager.getInstance().getIMGSource("tankTop");
		this.tankBottomIMG = SourceManager.getInstance().getIMGSource("tankBottom");
		this.TANK_BOTTOM_WIDTH = tankBottomIMG.getWidth() / 3;
		this.TANK_BOTTOM_HEIGHT = tankBottomIMG.getHeight() / 3;
		this.TANK_TOP_WIDTH = tankTopIMG.getWidth() / 3;
		this.TANK_TOP_HEIGHT = tankTopIMG.getHeight() / 3;
		this.MAP_SIZE = MapManager.MAP_SIZE;
	}

	public void setTank(int keyCode, boolean isSelected) {
		Weapons.getInstance().fireControl(keyCode);

		if (keyCode == KeyEvent.VK_Z) {
			rightT = isSelected;
		}
		if (keyCode == KeyEvent.VK_X) {
			leftT = isSelected;
		}

		if (keyCode == KeyEvent.VK_UP) {
			forwardB = isSelected;
		} else if (keyCode == KeyEvent.VK_DOWN) {
			backwardB = isSelected;
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
		radiansT = Math.toRadians(angleT);
		radiansB = Math.toRadians(angleB);

		if (forwardB) {
			double deltaX = MOVING_SPEED * Math.cos(radiansB);
			double deltaY = MOVING_SPEED * Math.sin(radiansB);
			this.playerWorldX += deltaX;
			this.playerWorldY += deltaY;
		} else if (backwardB) {
			double deltaX = (MOVING_SPEED - 1) * Math.cos(radiansB);
			double deltaY = (MOVING_SPEED - 1) * Math.sin(radiansB);
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

	public double getPlayerAngle() {
		return angleT;

	}

	public double getCenterX() {
		return centerX;
	}

	public double getCenterY() {
		return centerY;
	}

	@Override
	public void draw(Graphics g) {
		Graphics2D g2b = (Graphics2D) g.create();
		Graphics2D g2t = (Graphics2D) g.create();

		centerX = playerScreenX + TANK_BOTTOM_WIDTH / 2 + 8;
		centerY = playerScreenY + TANK_BOTTOM_HEIGHT / 2;
		g2b.rotate(radiansB, centerX, centerY);
		g2b.drawImage(tankBottomIMG, (int) playerScreenX, (int) playerScreenY, TANK_BOTTOM_WIDTH, TANK_BOTTOM_HEIGHT,
				null);
		g2b.dispose();
		g2t.rotate(radiansT, centerX, centerY);
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
		if (HP <= 0)
			this.dead = true;
	}

}
