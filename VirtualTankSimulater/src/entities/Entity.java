package entities;

import java.awt.Graphics;
import java.awt.Rectangle;

public interface Entity {
	double getCenterX();

	double getCenterY();

	int getHP();

	Rectangle getBound();

	int getDamage();

	void takeDamage(int damage);

	boolean isDead();

	void draw(Graphics g);

	void update();

	void destroy();

	public void setPosition();


}
