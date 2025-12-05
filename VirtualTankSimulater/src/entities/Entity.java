package entities;

import java.awt.Rectangle;

public abstract class Entity {
	public abstract int getHP();

	public abstract Rectangle getBound();

	public abstract int getDamage();

	public abstract void setHp(int damage);
}
