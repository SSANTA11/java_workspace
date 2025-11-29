package core;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class SourceManager {
	private static SourceManager sourceManager;
	private BufferedImage tankTop;
	private BufferedImage tankBottom;
	private BufferedImage tile;
	private BufferedImage wall;
	private BufferedImage title;
	private BufferedImage w;

	private SourceManager() {
		try {
			this.title = ImageIO.read(getClass().getResource("/title.png"));
			this.tankBottom = ImageIO.read(getClass().getResource("/tankBottom.png"));
			this.tankTop = ImageIO.read(getClass().getResource("/tankTop.png"));
			this.tile = ImageIO.read(getClass().getResource("/floor1.png"));
			this.wall = ImageIO.read(getClass().getResource("/wall.png"));
			this.w = ImageIO.read(getClass().getResource("/w.png"));

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
		case "wall":
			return wall;
		case "tankTop":
			return tankTop;
		default:
			return w;
		}
	}

	public static SourceManager getInstance() {
		if (sourceManager == null) {
			sourceManager = new SourceManager();
		}
		return sourceManager;
	}

}
