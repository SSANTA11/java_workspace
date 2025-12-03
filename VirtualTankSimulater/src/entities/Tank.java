package entities;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

import core.CameraViewLogic;
import core.GameManager;
import core.MapManager;
import core.SourceManager;

public class Tank extends Entity {
	private double playerWorldX = 0;
	private double playerWorldY = 500;
	private double playerScreenX;
	private double playerScreenY;
	private int HP = 100;
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

	private int fireDelay;
	private String weapon = "MG";
	private long lastFireTime = 0;

	public boolean rightB = false, leftB = false, forwardB = false, backwardB = false;
	public boolean rightT = false, leftT = false;
	public boolean fire = false;
	public boolean MG = false, AP = false, HEAT = false;

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
		if (keyCode == KeyEvent.VK_C) {
			fire = isSelected;
		}

		if (keyCode == KeyEvent.VK_1) {
			MG = isSelected;
		} else if (keyCode == KeyEvent.VK_2) {
			AP = isSelected;
		} else if (keyCode == KeyEvent.VK_3) {
			HEAT = isSelected;
		}

		if (keyCode == KeyEvent.VK_Z) {
			rightT = isSelected;
		} else if (keyCode == KeyEvent.VK_X) {
			leftT = isSelected;
		}

		if (keyCode == KeyEvent.VK_UP) {
			forwardB = isSelected;
		} else if (keyCode == KeyEvent.VK_DOWN) {
			backwardB = isSelected;
		}

		if (keyCode == KeyEvent.VK_LEFT) {
			leftB = isSelected;
		} else if (keyCode == KeyEvent.VK_RIGHT) {
			rightB = isSelected;
		}
		fireControl(keyCode);
	}

	public void fireControl(int keyCode) {
		switch (keyCode) {
		case KeyEvent.VK_1:
			this.weapon = "MG";
			System.out.println("공축기관총 선택");
			fireDelay = 100;
			break;
		case KeyEvent.VK_2:
			this.weapon = "AP";
			System.out.println("철갑탄 선택");
			fireDelay = 500;
			break;
		case KeyEvent.VK_3:
			this.weapon = "HEAT";
			System.out.println("대전차고폭탄 선택");
			fireDelay = 600;
			break;
		case KeyEvent.VK_C:
			long start = System.currentTimeMillis();
//			if (start - lastFireTime > fireDelay) {
			fire();
//				lastFireTime = start;
			System.out.println("발사");
//			}
			break;
		}
	}

	public void fire() {
		int centerX = (int) getPlayerScreenX();
		int centerY = (int) getPlayerScreenY();

		GameManager.getInstance().makeProjectile(weapon, centerX, centerY, angleT);
	}

	public void updateTank() {
		if (rightB) {
			angleB += ROTATION_SPEED;
		} else if (leftB) {
			angleB -= ROTATION_SPEED;
		}
		if (rightT) {
			angleT += ROTATION_SPEED;
		} else if (leftT) {
			angleT -= ROTATION_SPEED;
		}
		radiansT = Math.toRadians(angleT);
		radiansB = Math.toRadians(angleB);
		double deltaX = MOVING_SPEED * Math.cos(radiansB);
		double deltaY = MOVING_SPEED * Math.sin(radiansB);

		if (forwardB) {
			this.playerWorldX += deltaX;
			this.playerWorldY += deltaY;
		} else if (backwardB) {
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

	public void draw(Graphics g) {
		Graphics2D g2b = (Graphics2D) g.create();
		Graphics2D g2t = (Graphics2D) g.create();

		double centerX = playerScreenX + TANK_BOTTOM_WIDTH / 2 + 8;
		double centerY = playerScreenY + TANK_BOTTOM_HEIGHT / 2;
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
}
