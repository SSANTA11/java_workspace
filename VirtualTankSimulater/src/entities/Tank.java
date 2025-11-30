package entities;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import core.CameraViewLogic;
import core.MapManager;

public class Tank extends Entity {
	private double playerWorldX = 0;
	private double playerWorldY = 500;
	private double viewPortworldX;
	private double viewPortworldY;
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

	public boolean rightB = false, leftB = false, forwardB = false, backwardB = false;
	public boolean rightT = false, leftT = false;
	public boolean fire = false;
	public boolean MG = false, AP = false, HEAT = false;

	public Tank() {
		try {
			tankTopIMG = ImageIO.read(getClass().getResource("/tankTop.png"));
			tankBottomIMG = ImageIO.read(getClass().getResource("/tankBottom.png"));
		} catch (IOException e) {
			System.err.println("img 오류");
		}
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
		CameraViewLogic.getInstance().update(playerWorldX, playerWorldY);
	}

	public void draw(Graphics g) {
		Graphics2D g2b = (Graphics2D) g.create();
		Graphics2D g2t = (Graphics2D) g.create();

		double centerX = playerWorldX + TANK_BOTTOM_WIDTH / 2 + 8;
		double centerY = playerWorldY + TANK_BOTTOM_HEIGHT / 2;
		g2b.rotate(radiansB, centerX, centerY);
		g2b.drawImage(tankBottomIMG, (int) playerWorldX, (int) playerWorldY, TANK_BOTTOM_WIDTH, TANK_BOTTOM_HEIGHT,
				null);
		g2b.dispose();
		g2t.rotate(radiansT, centerX, centerY);
		g2t.drawImage(tankTopIMG, (int) playerWorldX + (TANK_BOTTOM_WIDTH - TANK_TOP_WIDTH) / 2 + 10,
				(int) playerWorldY + (TANK_BOTTOM_HEIGHT - TANK_TOP_HEIGHT) / 2, TANK_TOP_WIDTH, TANK_TOP_HEIGHT, null);
		g2t.dispose();
	}
}
