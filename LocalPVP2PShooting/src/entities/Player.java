package entities;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import java.awt.Graphics2D;
import view.Camera;

public class Player extends Entity {
	private int playerWorldX = 0;
	private int playerWorldY = 500;
	private int hp = 100;
	private int power = 10;
	private int speed = 3;
	private int angleB = 0;
	private int angleT = 180;
	private boolean up = false, down = false, left = false, right = false, Z = false, X = false;
	private BufferedImage tankBottomImage = null;
	private BufferedImage tankTopImage = null;

	private final Camera camera;

	private final int MAP_WIDTH;
	private final int MAP_HEIGHT;

	public Player(Camera camera, int mapWidth, int mapHeight) {
		try {
			tankBottomImage = ImageIO.read(getClass().getResource("/Player.png"));
			tankTopImage = ImageIO.read(getClass().getResource("/tankTop.png"));
		} catch (IOException e) {
			System.err.println("img 오류");
		}
		this.camera = camera;
		this.MAP_WIDTH = mapWidth;
		this.MAP_HEIGHT = mapHeight;
	}

	public int getX() {
		return playerWorldX;
	}

	public int getY() {
		return playerWorldY;
	}

	public int getBottomWidth() {
		return tankBottomImage.getWidth();
	}

	public int getBottomHeight() {
		return tankBottomImage.getHeight();
	}

	public int getTopHeight() {
		return tankTopImage.getHeight();
	}

	public int getTopWidth() {
		return tankTopImage.getWidth();
	}

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

	public void updatePosition() {
		int nextX = this.playerWorldX;
		int nextY = this.playerWorldY;
		
		if (Z) {
			angleT+=5;
		} else if (X) {
			angleT-=5;
		}
		
		if (up && right) {
			nextX += speed;
			nextY -= speed;
			angleB = 315;
		} else if (up && left) {
			nextX -= speed;
			nextY -= speed;
			angleB = 225;
		} else if (down && left) {
			nextX -= speed;
			nextY += speed;
			angleB = 135;
		} else if (down && right) {
			nextX += speed;
			nextY += speed;
			angleB = 45;
		} else if (up) {
			nextY -= speed;
			angleB = 270;
		} else if (down) {
			nextY += speed;
			angleB = 90;
		} else if (left) {
			nextX -= speed;
			angleB = 180;
		} else if (right) {
			nextX += speed;
			angleB = 0;
		}
		int minX = 0;
		int minY = 0;
		int maxX = MAP_WIDTH - getBottomWidth();
		int maxY = MAP_HEIGHT - getBottomHeight();

		this.playerWorldX = Math.max(minX, Math.min(nextX, maxX));
		this.playerWorldY = Math.max(minY, Math.min(nextY, maxY));

		camera.updatePlayerPosition(this.playerWorldX, this.playerWorldY);
		
	}

	public void draw(Graphics g, int screenX, int screenY) {
		Graphics2D g2 = (Graphics2D) g;

		int bottomwidth = getBottomWidth() / 2;
		int bottomHeight = getBottomHeight() / 2;
		int topWidth = getTopWidth() / 2;
		int topHeight = getTopHeight() / 2;

		int bottomCenterX = screenX + 150 / 2;
		int bottomCenterY = screenY + 70 / 2;
		int topCenterX = bottomCenterX;
		int topCenterY = bottomCenterY;

		g2.rotate(Math.toRadians(angleB), bottomCenterX, bottomCenterY);
		g2.drawImage(tankBottomImage, screenX, screenY, bottomwidth, bottomHeight, null);

		g2.rotate(Math.toRadians(angleT), topCenterX, topCenterY);
		g2.drawImage(tankTopImage, screenX + 20, screenY + 10, topWidth, topHeight, null);

	}
}
