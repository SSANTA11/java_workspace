package entities;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import core.CameraViewLogic;
import core.SourceManager;

public class Tank {
	private int playerWorldX = 0;
	private int playerWorldY = 500;
	private double viewPortworldX;
	private double viewPortworldY;
	private int HP = 100;
	private int speed = 3;
	private int playerX;
	private int playerY;
	private BufferedImage tankTop;
	private BufferedImage tankBottom;

	public Tank() {
		this.tankTop = SourceManager.getInstance().getIMGSource("tankTop");
		this.tankBottom = SourceManager.getInstance().getIMGSource("tankBottom");

		this.viewPortworldX = CameraViewLogic.getInstance().getViewPortworldX();
		this.viewPortworldY = CameraViewLogic.getInstance().getViewPortworldY();
		this.playerX = (int)(playerWorldX + viewPortworldX);
		this.playerY = (int)(playerWorldY + viewPortworldY);
	}

//	public void moveTank() {
//		if 
//	}

	public void draw(Graphics g) {
		g.drawImage(tankBottom, playerX, playerY, tankBottom.getWidth(), tankBottom.getHeight(), null);
	}
}
