package core;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class MapManager {
	public static final int TILE_SIZE = 200;
	public static final int WIDTH_TILES = 100;
	public static final int HEIGHT_TILES = 100;

	public static final int MAP_WIDTH = WIDTH_TILES * TILE_SIZE;
	public static final int MAP_HEIGHT = HEIGHT_TILES * TILE_SIZE;
	private char map[][] = new char[HEIGHT_TILES][WIDTH_TILES];

	public static BufferedImage wallTileImage1; // W
	public static BufferedImage wallTileImage2; // w
	public static BufferedImage floorTileImage;
	public static BufferedImage backWallTileImage;

	public MapManager() {
		loadTileset();
	}

	public void loadTileset() {
		try {
			wallTileImage1 = ImageIO.read(getClass().getResource("/wall1.png"));
			wallTileImage2 = ImageIO.read(getClass().getResource("/wall2.png"));
			floorTileImage = ImageIO.read(getClass().getResource("/floor.png"));
			backWallTileImage = ImageIO.read(getClass().getResource("/backWall.png"));
		} catch (IOException e) {
			System.out.println("타일 이미지 로드 오류");
		}
	}

	public char getTile(int x, int y) {

		return 'w';
	}
}