package core;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class MapManager {
	private static MapManager mapManager = new MapManager();
	private CameraViewLogic camera;
	private BufferedImage tileIMG;

	public static final int TILE_SIZE = 200;
	public static final int TILES = 40;
	public static final int MAP_SIZE = TILE_SIZE * TILES;
	private char map[][] = new char[TILES][TILES];

	private MapManager() {
		this.camera = CameraViewLogic.getInstance();
		this.tileIMG = SourceManager.getInstance().getIMGSource("tile");
		for (int i = 0; i < TILES; i++) {
			for (int j = 0; j < TILES; j++) {
				map[i][j] = 'w';
			}
		}
	}

	public static MapManager getInstance() {
		return mapManager;
	}

	public char getTile(int x, int y) {
		return map[y][x];
	}

	public void draw(Graphics g) {
		double viewPortworldX = camera.getViewPortworldX();
		double viewPortworldY = camera.getViewPortworldY();

		double screenWidth = UIManager.getInstance().getWindowWidth();
		double screenHeight = UIManager.getInstance().getWindowHeight();

		int startTileXIndex = Math.max(0, (int) viewPortworldX / TILE_SIZE);
		int startTileYIndex = Math.max(0, (int) viewPortworldY / TILE_SIZE);
		int endTileXIndex = Math.min(startTileXIndex + (int) (screenWidth / TILE_SIZE) + 100, TILES);
		int endTileYIndex = Math.min(startTileYIndex + (int) (screenHeight / TILE_SIZE) + 100, TILES);

		for (int x = startTileXIndex; x < endTileXIndex; x++) {
			for (int y = startTileYIndex; y < endTileYIndex; y++) {
				int screenX = (int) (x * TILE_SIZE - viewPortworldX);
				int screenY = (int) (y * TILE_SIZE - viewPortworldY);
				g.drawImage(tileIMG, screenX, screenY, TILE_SIZE, TILE_SIZE, null);
			}
		}
	}
}
