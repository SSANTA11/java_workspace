package core;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class SourceManager {
	private static SourceManager sourceManager = new SourceManager();
	private BufferedImage tankTop;
	private BufferedImage tankBottom;
	private BufferedImage tankTopE;
	private BufferedImage tankBottomE;
	private BufferedImage tile;
	private BufferedImage title;
	private BufferedImage wall1;
	private BufferedImage wall2;
	private BufferedImage turret;
	private BufferedImage soldier;

	private SourceManager() {
		try {
			this.title = ImageIO.read(getClass().getResource("/title.png"));
			this.tankBottom = ImageIO.read(getClass().getResource("/tankBottom.png"));
			this.tankTop = ImageIO.read(getClass().getResource("/tankTop.png"));
			this.tankBottomE = ImageIO.read(getClass().getResource("/tankBottomE.png"));
			this.tankTopE = ImageIO.read(getClass().getResource("/tankTopE.png"));
			this.tile = ImageIO.read(getClass().getResource("/floor.png"));
			this.wall1 = ImageIO.read(getClass().getResource("/wall1.png"));
			this.wall2 = ImageIO.read(getClass().getResource("/wall2.png"));
			this.turret = ImageIO.read(getClass().getResource("/turret.png"));
			this.soldier = ImageIO.read(getClass().getResource("/soldier.png"));
		} catch (IOException e) {
			System.out.println("사진 없음");
			System.exit(1);
		}
	}

	public BufferedImage getIMGSource(String img) {
		switch (img) {
		case "title":
			return title;
		case "tile":
			return tile;
		case "tankTop":
			return tankTop;
		case "tankBottom":
			return tankBottom;
		case "tankTopE":
			return tankTopE;
		case "tankBottomE":
			return tankBottomE;
		case "wall1":
			return wall1;
		case "wall2":
			return wall2;
		case "turret":
			return turret;
		case "soldier":
			return soldier;
		default:
			throw new IllegalArgumentException("input == null!");
		}
	}

	public static SourceManager getInstance() {
		return sourceManager;
	}

}