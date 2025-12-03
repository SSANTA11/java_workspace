package entities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import core.GameManager;
import core.SourceManager;

public class Projectile extends Entity {
	private int speed;
	private int range;
	private int WorldX;
	private int WorldY;
	private double angleT;
	private int damage;
	private int explosionRange;
	private boolean killingTankIsPossible;
	private int width;
	private int height;
	private static BufferedImage AP = SourceManager.getInstance().getIMGSource("AP");
	private static BufferedImage HEAT = SourceManager.getInstance().getIMGSource("HEAT");

	public Projectile(String weapon, int X, int Y, double angleT) {
		switch (weapon) {
		case "MG":
			this.speed = 50;
			this.range = 10;
			this.explosionRange = 0;
			this.killingTankIsPossible = false;
			this.damage = 3;
			this.width = 4;
			this.height = 4;
			break;

		case "AP":
			this.speed = 30;
			this.range = 20;
			this.explosionRange = 0;
			this.killingTankIsPossible = true;
			this.damage = 20;
			this.width = 6;
			this.height = 8;
			break;

		case "HE":
			this.speed = 30;
			this.range = 20;
			this.explosionRange = 300;
			this.killingTankIsPossible = false;
			this.damage = 3;
			this.width = 6;
			this.height = 8;
			break;

		case "HEAT":
			this.speed = 30;
			this.range = 20;
			this.explosionRange = 300;
			this.killingTankIsPossible = true;
			this.damage = 100;
			this.width = 6;
			this.height = 8;
			break;
		}
		this.WorldX = X;
		this.WorldY = Y;
		this.angleT = angleT;

	}

	public void updatePosition() {
		double radians = Math.toRadians(angleT);
		this.WorldX += (int) Math.round(this.speed * Math.cos(radians));
		this.WorldY += (int) Math.round(this.speed * Math.sin(radians));
		this.range--;
		if (this.range <= 0) {
			GameManager.getInstance().removeProjectile(this);
		}
	}

	public void drawExplo(Graphics g, int screenX, int screenY) {
		g.setColor(Color.YELLOW);
		g.fillRect(screenX, screenY, explosionRange - 20, explosionRange - 20);
		System.out.println("폭발 완료");

	}

	public void draw(Graphics g, int screenX, int screenY) {
		updatePosition();
		if (this.range <= 0 && explosionRange > 0) {
			drawExplo(g, screenX - explosionRange / 2, screenY - explosionRange / 2);
		}
		Graphics2D g2 = (Graphics2D) g.create();

		g2.rotate(Math.toRadians(angleT), screenX + width / 2, screenY + height / 2);
		g2.drawImage(AP, screenX + 80, screenY, width, height, null);

		g2.dispose();
	}
}