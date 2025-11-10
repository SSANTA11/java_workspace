package entities;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import core.GameManager;

public class Player extends Entity {
	private static final Player instance = new Player();

	private int x = 500;
	private int y = 500;
	private int hp = 100;
	private int power = 10;
	private final int speed = 2;
	private boolean up, down, left, right;
	private BufferedImage image = null;
	GameManager gameManager;

	private Player() {
		try {
			image = ImageIO.read(getClass().getResource("/res/Player.png"));
		} catch (IOException e) {
			System.err.println("img 오류");
			e.printStackTrace();
		}
	}

	public void initialize(GameManager gameManager) {
		this.gameManager = gameManager;
	}

	public static Player getInstance() {
		return instance;
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
		boolean isDouble = (up || down) && (left || right);
		final int ADJUST = isDouble ? 2 : 1;

		if (up)
			this.y -= speed / ADJUST;
		
		if (down)
			this.y += speed / ADJUST;

		if (left)
			this.x -= speed / ADJUST;

		if (right)
			this.x += speed / ADJUST;
	}

	public void draw(Graphics g) {
		if (image != null) {
			g.drawImage(image, x, y, null);
		}
	}

}