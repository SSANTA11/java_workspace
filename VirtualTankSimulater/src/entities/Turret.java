package entities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import core.CameraViewLogic;
import core.MapManager;
import core.SourceManager;

public class Turret extends Entity {
	private int HP = 1000;
	private int turretWorldX, turretWorldY;
	private int turretScreenX, turretScreenY;
	private int width;
	private int height;
	private int centerX;
	private int centerY;
	private boolean dead = false;
	private BufferedImage turretIMG;

	public Turret(int turretWorldX, int turretWorldY) {
		this.turretIMG = SourceManager.getInstance().getIMGSource("turret");
		this.width = MapManager.getInstance().getTILE_SIZE() / 2;
		this.height = MapManager.getInstance().getTILE_SIZE() / 2;
		this.turretWorldX = turretWorldX;
		this.turretWorldY = turretWorldY;
	}

	@Override
	public int getHP() {
		return HP;
	}

	@Override
	public Rectangle getBound() {
		return new Rectangle(turretWorldX, turretWorldY, width, height);
	}

	@Override
	public int getDamage() {
		return 0;
	}

	@Override
	public void setHp(int damage) {
		this.HP -= damage;
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

	@Override
	public void update() {
		if (!isDead()) {
			turretScreenX = turretWorldX - (int) CameraViewLogic.getInstance().getViewPortworldX();
			turretScreenY = turretWorldY - (int) CameraViewLogic.getInstance().getViewPortworldY();
		}else {
			turretScreenX = -100;
			turretScreenY = -100;
		}
	}

	@Override
	public void draw(Graphics g) {
		if (!isDead()) {
			g.drawImage(turretIMG, turretScreenX, turretScreenY, width, height, null);
		} else {
			g.setColor(Color.red);
			g.fillRect(turretScreenX, turretScreenY, width, height);
		}
	}

}
