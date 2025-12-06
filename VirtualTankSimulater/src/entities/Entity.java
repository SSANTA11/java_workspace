package entities;

import java.awt.Graphics;
import java.awt.Rectangle;

public abstract class Entity {
	public abstract int getHP();

	public abstract Rectangle getBound();

	public abstract int getDamage();

	public abstract void setHp(int damage);

	public abstract boolean isDead();

	public abstract void draw(Graphics g);

	public abstract void update();

	public abstract void destroy();

}
