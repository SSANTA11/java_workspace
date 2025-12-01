package core;

public class MapManager {
	static MapManager mapManager = new MapManager();
	public static final int TILE_SIZE = 200;
	public static final int TILES = 20;
	public static final int MAP_SIZE = TILE_SIZE * TILES;
	private char map[][] = new char[TILES][TILES];

	private MapManager() {
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

}
