package core;

public class MapManager {
	private static MapManager mapManager;
	private final int TILE_SIZE = 127;
	private final int TILES = 100;

	private char map[][] = new char[TILES][TILES];

	private MapManager() {
		for (int i = 0; i < TILES; i++) {
			for (int j = 0; j < TILES; j++) {
				map[i][j] = 'w';
			}
		}
	}

	public static MapManager getInstance() {
		if (mapManager == null) {
			mapManager = new MapManager();
		}
		return mapManager;
	}

	public char getTile(int x, int y) {
		return map[y][x];
	}

	public char getTileSize() {
		return TILE_SIZE;
	}

	public char getTiles() {
		return TILES;
	}

}
