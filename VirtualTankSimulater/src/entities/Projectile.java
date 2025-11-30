package entities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import core.GameManager;

public class Projectile extends Entity {
	private int speed;
	private int range;
	private int WorldX;
	private int WorldY;
	private int angleT;
	private int damage;
	private int explosionRange;
	private boolean killingTankIsPossible;
	private int width;
	private int height;

	public Projectile(String weapon, int X, int Y, int angleT) {
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


}