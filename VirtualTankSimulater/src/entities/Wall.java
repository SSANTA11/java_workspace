package entities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Wall extends Entity {
	private int HP = 100;
	private int X = 800, Y = 800;
	private int width = 200;
	private int height = 200;

	public Wall() {

	}

	public void draw(Graphics g) {
		g.setColor(Color.black);
		g.fillRect(X, Y, width, height);
	}

	@Override
	public Rectangle getBound() {
		return new Rectangle(X, Y, width, height);
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
}
