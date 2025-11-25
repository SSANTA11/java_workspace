package entities;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import java.awt.Graphics2D;
import view.Camera;
import java.lang.Math;

public class Player extends Entity {
	private int playerWorldX = 0;
	private int playerWorldY = 500;
	private int HP = 100;
	public int speed = 3;
	private int angleB = 0;
	private int angleT = 180;
	private boolean up = false, down = false, left = false, right = false, Z = false, X = false;
	private BufferedImage tankBottomImage = null;
	private BufferedImage tankTopImage = null;

	private final int TANK_BOTTOM_WIDTH;
	private final int TANK_BOTTOM_HEIGHT;
	private final int TANK_TOP_WIDTH;
	private final int TANK_TOP_HEIGHT;

	private final Camera camera;
	private final TankTop tankTop;
	private final int MAP_WIDTH;
	private final int MAP_HEIGHT;

	public Player(Camera camera, int mapWidth, int mapHeight) {
		try {
			tankBottomImage = ImageIO.read(getClass().getResource("/Player.png"));
			tankTopImage = ImageIO.read(getClass().getResource("/tankTop.png"));
		} catch (IOException e) {
			System.err.println("img 오류");
		}

		this.TANK_BOTTOM_WIDTH = tankBottomImage.getWidth() / 2;
		this.TANK_BOTTOM_HEIGHT = tankBottomImage.getHeight() / 2;
		this.TANK_TOP_WIDTH = tankTopImage.getWidth() / 2;
		this.TANK_TOP_HEIGHT = tankTopImage.getHeight() / 2;

		this.camera = camera;
		this.MAP_WIDTH = mapWidth;
		this.MAP_HEIGHT = mapHeight;
		this.tankTop = new TankTop();
	}

	public TankTop getTankTop() {
		return tankTop;
	}


	public int getBottomWidth() {
		return TANK_BOTTOM_WIDTH;
	}

	public int getBottomHeight() {
		return TANK_BOTTOM_HEIGHT;
	}

	public int getTopHeight() {
		return TANK_TOP_HEIGHT;
	}

	public int getTopWidth() {
		return TANK_TOP_WIDTH;
	}

	@Override
	public void setPosition(int playerWorldX, int playerWorldY) {
		this.playerWorldX = playerWorldX;
		this.playerWorldY = playerWorldY;
	}

	public void setMoving(int keyCode, boolean isMoving) {
		switch (keyCode) {
		case KeyEvent.VK_UP:
			up = isMoving;
			break;
		case KeyEvent.VK_DOWN:
			down = isMoving;
			break;
		case KeyEvent.VK_RIGHT:
			right = isMoving;
			break;
		case KeyEvent.VK_LEFT:
			left = isMoving;
			break;
		case KeyEvent.VK_Z:
			Z = isMoving;
			break;
		case KeyEvent.VK_X:
			X = isMoving;
			break;
		}
	}

	@Override
	public void updatePosition() {

		if (Z) {
			angleT += 1;
		} else if (X) {
			angleT -= 1;
		}

		double movementSpeed = 0;
		int rotationSpeed = 0;

		if (up) {
			movementSpeed = speed;
		} else if (down) {
			movementSpeed = -speed + 1;
		}

		if (left) {
			rotationSpeed = -1;
		} else if (right) {
			rotationSpeed = 1;
		}

		angleB += rotationSpeed;

		if (movementSpeed != 0) {
			double radians = Math.toRadians(angleB);

			int nextX = this.playerWorldX + (int) Math.round(Math.cos(radians) * movementSpeed);
			int nextY = this.playerWorldY + (int) Math.round(Math.sin(radians) * movementSpeed);

			int minX = 0;
			int minY = 0;
			int maxX = MAP_WIDTH - TANK_BOTTOM_WIDTH;
			int maxY = MAP_HEIGHT - TANK_BOTTOM_HEIGHT;

			this.playerWorldX = Math.max(minX, Math.min(nextX, maxX));
			this.playerWorldY = Math.max(minY, Math.min(nextY, maxY));
		}

		camera.updatePlayerPosition(this.playerWorldX, this.playerWorldY);
	}

	public int getAngleT() {
		return angleT;
	}

	public void draw(Graphics g, int screenX, int screenY) {
		Graphics2D g2 = (Graphics2D) g;

		int bottomwidth = TANK_BOTTOM_WIDTH;
		int bottomHeight = TANK_BOTTOM_HEIGHT;
		int topWidth = TANK_TOP_WIDTH;
		int topHeight = TANK_TOP_HEIGHT;

		int bottomCenterX = screenX + 150 / 2;
		int bottomCenterY = screenY + 70 / 2;
		int topCenterX = bottomCenterX;
		int topCenterY = bottomCenterY;

		g2.rotate(Math.toRadians(angleB), bottomCenterX + 20, bottomCenterY);
		g2.drawImage(tankBottomImage, screenX, screenY, bottomwidth, bottomHeight, null);

		g2.rotate(Math.toRadians(angleT), topCenterX, topCenterY);
		g2.drawImage(tankTopImage, screenX + 20, screenY + 10, topWidth, topHeight, null);

	}

	@Override
	public int getWidth() {
		return TANK_BOTTOM_WIDTH;
	}

	@Override
	public int getHeight() {
		return TANK_BOTTOM_HEIGHT;
	}

	@Override
	public int getWorldX() {
		return playerWorldX;
	}

	@Override
	public int getWorldY() {
		return playerWorldY;
	}

	@Override
	public String getType() {
		return "PLAYER";
	}

	@Override
	public int getHP() {
		return HP;
	}

	@Override
	public int getSpeed() {
		return speed;
	}

	@Override
	public int setHP(int HP) {
		return 0;
	}

}