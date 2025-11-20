package entities;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import view.Camera;

public class Player extends Entity {
	private int playerWorldX = 0;
	private int playerWorldY = 500;
	private int hp = 100;
	private int power = 10;
	private int speed = 3;
	private boolean up = false, down = false, left = false, right = false;
	private BufferedImage image = null;
	private final Camera camera;

	private final int MAP_WIDTH;
	private final int MAP_HEIGHT;

	public Player(Camera camera, int mapWidth, int mapHeight) {
		try {
			image = ImageIO.read(getClass().getResource("/Player.png"));
		} catch (IOException e) {
			System.err.println("img 오류");
			e.printStackTrace();
		}
		this.camera = camera;
		this.MAP_WIDTH = mapWidth;
		this.MAP_HEIGHT = mapHeight;
	}

	public void setPosition(int playerWorldX, int playerWorldY) {
		this.playerWorldX = playerWorldX;
		this.playerWorldX = playerWorldY;
	}

	public int getX() {
		return playerWorldX;
	}

	public int getY() {
		return playerWorldY;
	}

	public int getPlayerWidth() {
		return image.getWidth();
	}

	public int getPlayerHeight() {
		return image.getHeight();
	}

	public void setMoving(int keyCode, boolean isMoving) {
		switch (keyCode) {
		case KeyEvent.VK_UP:
		case KeyEvent.VK_W:
			up = isMoving;
			break;
		case KeyEvent.VK_DOWN:
		case KeyEvent.VK_S:
			down = isMoving;
			break;
		case KeyEvent.VK_RIGHT:
		case KeyEvent.VK_D:
			right = isMoving;
			break;
		case KeyEvent.VK_LEFT:
		case KeyEvent.VK_A:
			left = isMoving;
			break;
		}
	}

	public void updatePosition() {
		int nextX = this.playerWorldX;
		int nextY = this.playerWorldY;

		if (up)
			nextY -= speed;

		if (down)
			nextY += speed;

		if (left)
			nextX -= speed;

		if (right)
			nextX += speed;

		int minX = 0;
		int minY = 0;
		int maxX = MAP_WIDTH - getPlayerWidth();
		int maxY = MAP_HEIGHT - getPlayerHeight();

		this.playerWorldX = Math.max(minX, Math.min(nextX, maxX));
		this.playerWorldY = Math.max(minY, Math.min(nextY, maxY));

		camera.updatePlayerPosition(this.playerWorldX, this.playerWorldY);
	}

	public void draw(Graphics g, int screenX, int screenY) {
		if (image != null) {
			g.drawImage(image, screenX, screenY, getPlayerWidth(), getPlayerHeight(), null);
		}
	}
}