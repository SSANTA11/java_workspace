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

	public static BufferedImage floorTileImage;

	public MapManager() {
		loadTileset();
	}

	public void loadTileset() {
		try {
			floorTileImage = ImageIO.read(getClass().getResource("/floor.png"));
		} catch (IOException e) {
			System.out.println("타일 이미지 로드 오류");
		}
	}

	public char getTile(int x, int y) {

		return 'w';
	}
}