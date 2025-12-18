package entities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import core.CameraViewLogic;
import core.MapManager;
import core.SourceManager;

public class Wall implements Entity {
	private int HP;
	private int wallWorldX, wallWorldY;
	private int wallScreenX, wallScreenY;
	private int width;
	private int height;
	private boolean dead = false;
	private BufferedImage wallIMG;

	public Wall(int wallWorldX, int wallWorldY, int n) {
		if (n == 1) {
			this.wallIMG = SourceManager.getInstance().getIMGSource("wall1");
			this.HP = 100;
		} else {
			this.wallIMG = SourceManager.getInstance().getIMGSource("wall2");
			HP = 10000;
		}
		this.width = MapManager.getInstance().getTILE_SIZE() / 2;
		this.height = MapManager.getInstance().getTILE_SIZE() / 2;
		this.wallWorldX = wallWorldX;
		this.wallWorldY = wallWorldY;

	}

	@Override
	public void draw(Graphics g) {
		if (!isDead()) {
			g.drawImage(wallIMG, wallScreenX, wallScreenY, width, height, null);
		} else {
			g.setColor(Color.red);
			g.fillRect(wallScreenX, wallScreenY, width, height);
		}
	}

	@Override
	public Rectangle getBound() {
		return new Rectangle(wallWorldX + 30, wallWorldY + 30, 30, 30);
	}

	@Override
	public int getDamage() {
		return 0;
	}

	@Override
	public void takeDamage(int damage) {
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
	public void update() {
		if (!isDead()) {
			wallScreenX = wallWorldX - (int) CameraViewLogic.getInstance().getViewPortworldX();
			wallScreenY = wallWorldY - (int) CameraViewLogic.getInstance().getViewPortworldY();
		} else {
			wallScreenX = -100;
			wallScreenY = -100;
		}
	}

	@Override
	public double getCenterX() {
		return wallWorldX + width;
	}

	@Override
	public double getCenterY() {
		return wallWorldY + height;
	}

	@Override
	public void setPosition() {
		// TODO Auto-generated method stub

	}
}
