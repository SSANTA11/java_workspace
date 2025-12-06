package entities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import core.CameraViewLogic;

public class Wall extends Entity {
	private int HP = 100;
	private int wallWorldX = 800, wallWorldY = 800;
	private int wallScreenX, wallScreenY;
	private int width = 200;
	private int height = 200;
	private boolean dead = false;

	public Wall() {

	}

	public void draw(Graphics g) {
		if (!isDead()) {
			g.setColor(Color.black);
			g.fillRect(wallScreenX, wallScreenY, width, height);
		} else {
			g.setColor(Color.yellow);
			g.fillRect(wallScreenX, wallScreenY, width, height);
		}
	}

	@Override
	public Rectangle getBound() {
		return new Rectangle(wallWorldX, wallWorldY, width, height);
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
}
