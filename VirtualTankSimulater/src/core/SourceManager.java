package core;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class SourceManager {
	private static SourceManager sourceManager = new SourceManager();
	private BufferedImage tankTop;
	private BufferedImage tankBottom;
	private BufferedImage tile;
	private BufferedImage title;
	private BufferedImage AP;
	private BufferedImage HEAT;
	private SourceManager() {
		try {
			this.title = ImageIO.read(getClass().getResource("/title.png"));
			this.tankBottom = ImageIO.read(getClass().getResource("/tankBottom.png"));
			this.tankTop = ImageIO.read(getClass().getResource("/tankTop.png"));
			this.tile = ImageIO.read(getClass().getResource("/floor.png"));
			this.AP = ImageIO.read(getClass().getResource("/AP.png"));
			this.HEAT = ImageIO.read(getClass().getResource("/HEAT.png"));
		} catch (IOException e) {
			System.out.println("사진 없음");
			System.exit(1);
		}
	}

	public BufferedImage getIMGSource(String img) {

		switch (img) {
		case "title":
			return title;
		case "tankBottom":
			return tankBottom;
		case "tile":
			return tile;
		case "tankTop":
			return tankTop;
		case "AP":
			return AP;
		case "HEAT":
			return HEAT;
		default:
            throw new IllegalArgumentException("input == null!");
		}
	}

	public static SourceManager getInstance() {
		return sourceManager;
	}

}