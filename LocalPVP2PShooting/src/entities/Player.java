package entities;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import view.Camera;

public class Player extends Entity {
	private int x = 500;
	private int y = 500;
	private int hp = 100;
	private int power = 10;
	private final int speed = 20;
	private boolean up = false, down = false, left = false, right = false;
	private BufferedImage image = null;
	private final Camera camera;

	// 맵 경계 필드
	private final int MAP_WIDTH;
	private final int MAP_HEIGHT;

	// 생성자: Camera와 맵 경계를 주입받습니다.
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

	public void setPosition(int x, int y) {
		this.x = x;
		this.y = y;
	}

	// 📢 추가됨: 현재 X 좌표를 반환합니다.
	public int getX() {
		return x;
	}

	// 📢 추가됨: 현재 Y 좌표를 반환합니다.
	public int getY() {
		return y;
	}

	public int getWidth() {
		return image != null ? image.getWidth() : 0;
	}

	public int getHeight() {
		return image != null ? image.getHeight() : 0;
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
		int nextX = this.x;
		int nextY = this.y;

		if (up)
			nextY -= speed;

		if (down)
			nextY += speed;

		if (left)
			nextX -= speed;

		if (right)
			nextX += speed;

         		// 경계 클램핑 로직
		int minX = 0;
		int minY = 0;
		int maxX = MAP_WIDTH - getWidth();
		int maxY = MAP_HEIGHT - getHeight();

		this.x = Math.max(minX, Math.min(nextX, maxX));
		this.y = Math.max(minY, Math.min(nextY, maxY));

		camera.updatePlayerPosition(this.x, this.y);
	}

	public void draw(Graphics g, int screenX, int screenY) {
		if (image != null) {
			g.drawImage(image, screenX, screenY, getWidth(), getHeight(), null);
		}
	}
}