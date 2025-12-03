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
	private double angleT;
	private int damage;
	private int explosionRange;
	private int width;
	private int height;
	private BufferedImage AP = SourceManager.getInstance().getIMGSource("AP");
	private BufferedImage HEAT = SourceManager.getInstance().getIMGSource("HEAT");

	private double playerAngle;
	private boolean suicideFlag = false;
	private int projectileScreenX;
	private int projectileScreenY;

	public Projectile(String weapon) {
		switch (weapon) {
		case "MG":
			this.speed = 50;
			this.range = 10;
			this.explosionRange = 0;
			this.damage = 3;
			this.width = 4;
			this.height = 4;
			break;

		case "AP":
			this.speed = 30;
			this.range = 50;
			this.explosionRange = 0;
			this.damage = 20;
			this.width = 6;
			this.height = 8;
			break;

		case "HEAT":
			this.speed = 30;
			this.range = 50;
			this.explosionRange = 300;
			this.damage = 100;
			this.width = 6;
			this.height = 8;
			break;
		}

		this.playerAngle = GameManager.getInstance().getPlayer().getPlayerAngle();
		this.projectileScreenX = (int) GameManager.getInstance().getPlayer().getCenterX();
		this.projectileScreenY = (int) GameManager.getInstance().getPlayer().getCenterY();
	}

	public void updateLocation() {
		projectileScreenX += speed * Math.cos(angleT);
		projectileScreenY += speed * Math.sin(angleT);
		range--;
		if (range < 0) {
			suicideFlag = true;
		}
//		else if(만일 충돌했다면){
//			
//		}
	}

	public void draw(Graphics g) {
		Graphics2D g2 = (Graphics2D) g.create();
		double anlgleT = playerAngle;
		g2.rotate(Math.toRadians(anlgleT), GameManager.getInstance().getPlayer().getCenterX(),
				GameManager.getInstance().getPlayer().getCenterY());
		g2.setColor(Color.RED);
		g2.fillRect(projectileScreenX + 34, projectileScreenY - 4, width, height);
		g2.dispose();
		if (0 < range && range < 2 && explosionRange > 0) {
			Graphics2D ex = (Graphics2D) g.create();
			ex.setColor(Color.RED);
			ex.rotate(Math.toRadians(anlgleT), GameManager.getInstance().getPlayer().getCenterX(),
					GameManager.getInstance().getPlayer().getCenterY());
			ex.fillRect(projectileScreenX - explosionRange / 2, projectileScreenY - explosionRange / 2, explosionRange,
					explosionRange);
			ex.dispose();
		}
		updateLocation();

	}

	public boolean isSuicideFlag() {
		return suicideFlag;
	}

}