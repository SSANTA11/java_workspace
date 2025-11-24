package entities;

public abstract class Entity {
	public abstract int getWidth();

	public abstract int getHeight();

	public abstract int getWorldX();

	public abstract int getWorldY();

	public abstract String getType();

	public abstract int getHP();

	public abstract int getSpeed();

	public abstract void setPosition(int playerWorldX, int playerWorldY);

}
