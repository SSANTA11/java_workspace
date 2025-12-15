package core;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import entities.Wall;

public class MapManager {
	private CameraViewLogic camera;
	private BufferedImage tileIMG;
	private boolean flag = true;
	private static final int TILE_SIZE = 200;
	private static final int TILES = 40;
	private static final int SECTORS_X = 4;
	private static final int SECTORS_Y = 4;
	private static final int SECTOR_COL = 10;
	private static final int SECTOR_RAW = 10;
	private static final int MAP_SIZE = TILE_SIZE * TILES;
	private char map[][] = new char[TILES][TILES];
	
	private static MapManager mapManager = new MapManager();
	
	private static final char[][] sector1 = {
			{'w', 'w', 'w', 'w', 'w', 'w', 'w', 'w', 'w', 'w'},
    		{'w', '0', '0', '0', '0', '0', '0', '0', '0', 'w'},
    		{'w', '0', 'w', '0', '0', 't', 'w', '0', '0', 'w'},
    		{'w', '0', 'w', '0', '0', '0', 'w', '0', '0', 'w'},
    		{'w', '0', 'w', '0', '0', '0', '0', '0', '0', 'w'},
    		{'w', '0', '0', '0', 'w', 'w', 'w', '0', '0', 'w'},
    		{'w', '0', '0', '0', '0', '0', '0', '0', '0', 'w'},
    		{'w', '0', 'w', 'w', 'w', 'w', 'w', 'w', '0', 'w'},
    		{'w', '0', '0', '0', '0', '0', '0', '0', '0', 'w'},
    		{'w', 'w', 'w', 'w', 'w', 'w', 'w', 'w', 'w', 'w'}
        };
        
    private static final char[][] sector2 = {
    		{'w', 'w', 'w', 'w', 'w', 'w', 'w', 'w', 'w', 'w'},
    		{'w', '0', '0', '0', '0', '0', '0', '0', '0', 'w'},
    		{'w', '0', 'w', '0', '0', '0', 'w', '0', '0', 'w'},
    		{'w', '0', 'w', '0', '0', '0', 'w', '0', '0', 'w'},
    		{'w', '0', 'w', '0', '0', '0', 't', '0', '0', 'w'},
    		{'w', '0', '0', '0', 'w', 'w', 'w', '0', '0', 'w'},
    		{'w', '0', '0', '0', '0', '0', '0', '0', '0', 'w'},
    		{'w', '0', 'w', 'w', 'w', 'w', 'w', 'w', '0', 'w'},
    		{'w', '0', '0', '0', '0', '0', '0', '0', '0', 'w'},
    		{'w', 'w', 'w', 'w', 'w', 'w', 'w', 'w', 'w', 'w'}
    };
    
    private static final char[][] sector3 = {
    		{'w', 'w', 'w', 'w', 'w', 'w', 'w', 'w', 'w', 'w'},
    		{'w', '0', '0', '0', '0', '0', '0', '0', '0', 'w'},
    		{'w', '0', 's', 's', '0', '0', 'w', '0', '0', 'w'},
    		{'w', '0', 's', '0', '0', '0', 'w', '0', '0', 'w'},
    		{'w', '0', 's', 's', '0', '0', '0', '0', '0', 'w'},
    		{'w', '0', 's', '0', 'w', 'w', 'w', '0', '0', 'w'},
    		{'w', '0', 's', 's', '0', '0', '0', '0', '0', 'w'},
    		{'w', '0', 's', 's', 'w', 'w', 'w', 'w', '0', 'w'},
    		{'w', '0', 's', 's', '0', '0', '0', '0', '0', 'w'},
    		{'w', 'w', 's', 's', 'w', 'w', 'w', 'w', 'w', 'w'}
    };
    
    private static final char[][] sector4 = {
    		{'w', 'w', 'w', 'w', 'w', 'w', 'w', 'w', 'w', 'w'},
    		{'w', '0', '0', '0', '0', '0', '0', '0', '0', 'w'},
    		{'w', '0', 'w', 'w', '0', '0', 'w', '0', '0', 'w'},
    		{'w', '0', 'w', '0', '0', '0', 'w', '0', '0', 'w'},
    		{'w', '0', 'w', '0', '0', '0', '0', '0', '0', 'w'},
    		{'w', '0', '0', '0', 'w', 'w', 'w', '0', '0', 'w'},
    		{'w', '0', '0', '0', '0', '0', '0', '0', '0', 'w'},
    		{'w', '0', 'w', 'w', 'w', 'w', 'w', 'w', '0', 'w'},
    		{'w', '0', '0', '0', '0', '0', '0', '0', '0', 'w'},
    		{'w', 'w', 'w', 'w', 'w', 'w', 'w', 'w', 'w', 'w'}
    };
    
    private static final char[][] sector5 = {
    		{'w', 'w', 'w', 'w', 'w', 'w', 'w', 'w', 'w', 'w'},
    		{'w', '0', '0', '0', '0', '0', '0', '0', '0', 'w'},
    		{'w', '0', 't', 'w', '0', '0', 'w', '0', '0', 'w'},
    		{'w', '0', 't', '0', '0', '0', 'w', '0', '0', 'w'},
    		{'w', '0', 'w', '0', '0', '0', '0', '0', '0', 'w'},
    		{'w', '0', '0', '0', 'w', 'w', 'w', '0', '0', 'w'},
    		{'w', '0', '0', '0', '0', '0', '0', '0', '0', 'w'},
    		{'w', '0', 't', 'w', 'w', 'w', 'w', 'w', '0', 'w'},
    		{'w', '0', '0', '0', '0', '0', '0', '0', '0', 'w'},
    		{'w', 'w', 'w', 'w', 'w', 'w', 'w', 'w', 'w', 'w'}
    };
    
    private static final char[][] sector6 = {
    		{'w', 'w', 'w', 'w', 'w', 'w', 'w', 'w', 'w', 'w'},
    		{'w', '0', '0', '0', '0', '0', '0', '0', '0', 'w'},
    		{'w', '0', 'w', 'w', '0', '0', 'w', '0', '0', 'w'},
    		{'w', '0', 'w', '0', '0', '0', 'w', '0', '0', 'w'},
    		{'w', '0', 'w', '0', '0', '0', '0', '0', '0', 'w'},
    		{'w', '0', '0', '0', 'w', 'w', 'w', '0', '0', 'w'},
    		{'w', '0', '0', '0', '0', '0', '0', '0', '0', 'w'},
    		{'w', '0', 'w', 'w', 'w', 'w', 'w', 'w', '0', 'w'},
    		{'w', '0', '0', '0', '0', '0', '0', '0', '0', 'w'},
    		{'w', 'w', 'w', 'w', 'w', 'w', 'w', 'w', 'w', 'w'}
    };
    
    private static final char[][] sector7 = {
    		{'w', 'w', 'w', 'w', 'w', 'w', 'w', 'w', 'w', 'w'},
    		{'w', '0', '0', '0', '0', '0', '0', '0', '0', 'w'},
    		{'w', '0', 'w', 'w', '0', '0', 'w', '0', '0', 'w'},
    		{'w', '0', 'w', '0', '0', '0', 'w', '0', '0', 'w'},
    		{'w', '0', 'w', '0', '0', '0', '0', '0', '0', 'w'},
    		{'w', '0', '0', '0', 'w', 'w', 'w', '0', '0', 'w'},
    		{'w', '0', '0', '0', '0', '0', '0', '0', '0', 'w'},
    		{'w', '0', 'w', 'w', 'w', 'w', 'w', 'w', '0', 'w'},
    		{'w', '0', '0', '0', '0', '0', '0', '0', '0', 'w'},
    		{'w', 'w', 'w', 'w', 'w', 'w', 'w', 'w', 'w', 'w'}
    };
    
    private static final char[][] sector8 = {
    		{'w', 'w', 'w', 'w', 'w', 'w', 'w', 'w', 'w', 'w'},
    		{'w', '0', '0', '0', '0', '0', '0', '0', '0', 'w'},
    		{'w', '0', 'w', 'w', '0', '0', 'w', '0', '0', 'w'},
    		{'w', '0', 'w', '0', '0', '0', 'w', '0', '0', 'w'},
    		{'w', '0', 'w', '0', '0', '0', '0', '0', '0', 'w'},
    		{'w', '0', '0', '0', 'w', 'w', 'w', '0', '0', 'w'},
    		{'w', '0', '0', '0', '0', '0', '0', '0', '0', 'w'},
    		{'w', '0', 'w', 'w', 'w', 'w', 'w', 'w', '0', 'w'},
    		{'w', '0', '0', '0', '0', '0', '0', '0', '0', 'w'},
    		{'w', 'w', 'w', 'w', 'w', 'w', 'w', 'w', 'w', 'w'}
    };
    
    private static final char[][] sector9 = {
    		{'w', 'w', 'w', 'w', 'w', 'w', 'w', 'w', 'w', 'w'},
    		{'w', '0', '0', '0', '0', '0', '0', '0', '0', 'w'},
    		{'w', '0', 'w', 'w', '0', '0', 'w', '0', '0', 'w'},
    		{'w', '0', 'w', '0', '0', '0', 'w', '0', '0', 'w'},
    		{'w', '0', 'w', '0', '0', '0', '0', '0', '0', 'w'},
    		{'w', '0', '0', '0', 'w', 'w', 'w', '0', '0', 'w'},
    		{'w', '0', '0', '0', '0', '0', '0', '0', '0', 'w'},
    		{'w', '0', 'w', 'w', 'w', 'w', 'w', 'w', '0', 'w'},
    		{'w', '0', '0', '0', '0', '0', '0', '0', '0', 'w'},
    		{'w', 'w', 'w', 'w', 'w', 'w', 'w', 'w', 'w', 'w'}
    };
    
    private static final char[][] sector10 = {
    		{'w', 'w', 'w', 'w', 'w', 'w', 'w', 'w', 'w', 'w'},
    		{'w', '0', '0', '0', '0', '0', '0', '0', '0', 'w'},
    		{'w', '0', 'w', 'w', '0', '0', 'w', '0', '0', 'w'},
    		{'w', '0', 'w', '0', '0', '0', 'w', '0', '0', 'w'},
    		{'w', '0', 'w', '0', '0', '0', '0', '0', '0', 'w'},
    		{'w', '0', '0', '0', 'w', 'w', 'w', '0', '0', 'w'},
    		{'w', '0', '0', '0', '0', '0', '0', '0', '0', 'w'},
    		{'w', '0', 'w', 'w', 'w', 'w', 'w', 'w', '0', 'w'},
    		{'w', '0', '0', '0', '0', '0', '0', '0', '0', 'w'},
    		{'w', 'w', 'w', 'w', 'w', 'w', 'w', 'w', 'w', 'w'}
    };
    
    private static final char[][] sector11 = {
    		{'w', 'w', 'w', 'w', 'w', 'w', 'w', 'w', 'w', 'w'},
    		{'w', '0', '0', '0', '0', '0', '0', '0', '0', 'w'},
    		{'w', '0', 'w', 'w', '0', '0', 'w', '0', '0', 'w'},
    		{'w', '0', 'w', '0', '0', '0', 'w', '0', '0', 'w'},
    		{'w', '0', 'w', '0', '0', '0', '0', '0', '0', 'w'},
    		{'w', '0', '0', '0', 'w', 'w', 'w', '0', '0', 'w'},
    		{'w', '0', '0', '0', '0', '0', '0', '0', '0', 'w'},
    		{'w', '0', 'w', 'w', 'w', 'w', 'w', 'w', '0', 'w'},
    		{'w', '0', '0', '0', '0', '0', '0', '0', '0', 'w'},
    		{'w', '0', '0', '0', '0', '0', '0', '0', '0', 'w'}
    };
    
    private static final char[][] sector12 = {
    		{'w', '0', '0', '0', '0', '0', '0', '0', '0', 'w'},
    		{'w', '0', '0', '0', '0', '0', '0', '0', '0', 'w'},
    		{'w', '0', 'w', 'w', '0', '0', 'w', '0', '0', 'w'},
    		{'w', '0', 'w', '0', '0', '0', 'w', '0', '0', 'w'},
    		{'w', '0', 'w', '0', '0', '0', '0', '0', '0', 'w'},
    		{'w', '0', '0', '0', 'w', 'w', 'w', '0', '0', 'w'},
    		{'w', '0', '0', '0', '0', '0', '0', '0', '0', 'w'},
    		{'w', '0', 'w', 'w', 'w', 'w', 'w', 'w', '0', 'w'},
    		{'w', '0', '0', '0', '0', '0', '0', '0', '0', 'w'},
    		{'w', '0', '0', '0', '0', '0', '0', '0', '0', 'w'}
    };
    
    private static final char[][] sector13 = {
    		{'w', '0', '0', '0', '0', '0', '0', '0', '0', 'w'},
    		{'w', '0', '0', '0', '0', '0', '0', '0', '0', 'w'},
    		{'w', '0', 'w', 'w', '0', '0', 'w', '0', '0', 'w'},
    		{'w', '0', 'w', '0', '0', '0', 'w', '0', '0', 'w'},
    		{'w', '0', 'w', '0', '0', '0', '0', '0', '0', 'w'},
    		{'w', '0', '0', '0', 'w', 'w', 'w', '0', '0', 'w'},
    		{'w', '0', '0', '0', '0', '0', '0', '0', '0', 'w'},
    		{'w', '0', 'w', 'w', 'w', 'w', 'w', 'w', '0', 'w'},
    		{'w', '0', '0', '0', '0', '0', '0', '0', '0', 'w'},
    		{'w', 'w', 'w', 'w', 'w', 'w', 'w', 'w', 'w', 'w'}
    };
    
    private static final char[][] sector14 = {
    		{'w', '0', '0', '0', '0', '0', '0', '0', '0', 'w'},
    		{'w', '0', '0', '0', '0', '0', '0', '0', '0', 'w'},
    		{'w', '0', 'w', 'w', '0', '0', 'w', '0', '0', 'w'},
    		{'w', '0', 'w', '0', '0', '0', 'w', '0', '0', 'w'},
    		{'w', '0', 'w', '0', '0', '0', '0', '0', '0', 'w'},
    		{'w', '0', '0', '0', 'w', 'w', 'w', '0', '0', 'w'},
    		{'w', '0', '0', '0', '0', '0', '0', '0', '0', 'w'},
    		{'w', '0', 'w', 'w', 'w', 'w', 'w', 'w', '0', 'w'},
    		{'w', '0', '0', '0', '0', '0', '0', '0', '0', 'w'},
    		{'w', 'w', 'w', 'w', 'w', 'w', 'w', 'w', 'w', 'w'}
    };
    
    private static final char[][] sector15 = {
    		{'w', '0', '0', '0', '0', '0', '0', '0', '0', 'w'},
    		{'w', '0', '0', '0', '0', '0', '0', '0', '0', 'w'},
    		{'w', '0', 'w', 'w', '0', '0', 'w', '0', '0', 'w'},
    		{'w', '0', 'w', '0', '0', '0', 'w', '0', '0', 'w'},
    		{'w', '0', 'w', '0', '0', '0', '0', '0', '0', 'w'},
    		{'w', '0', '0', '0', 'w', 'w', 'w', '0', '0', 'w'},
    		{'w', '0', '0', '0', '0', '0', '0', '0', '0', 'w'},
    		{'w', '0', 'w', 'w', 'w', 'w', 'w', 'w', '0', 'w'},
    		{'w', '0', '0', '0', '0', '0', '0', '0', '0', 'w'},
    		{'w', 'w', 'w', 'w', 'w', 'w', 'w', 'w', 'w', 'w'}
    };
    
    private static final char[][] sector16 = {
    		{'w', '0', '0', '0', '0', '0', '0', '0', '0', 'w'},
    		{'w', '0', '0', '0', '0', '0', '0', '0', '0', 'w'},
    		{'w', '0', 'w', 'w', '0', '0', 'w', '0', '0', 'w'},
    		{'w', '0', 'w', '0', '0', '0', 'w', '0', '0', 'w'},
    		{'w', '0', 'w', '0', '0', '0', '0', '0', '0', 'w'},
    		{'w', '0', '0', '0', 'w', 'w', 'w', '0', '0', 'w'},
    		{'w', '0', '0', '0', '0', '0', '0', '0', '0', 'w'},
    		{'w', '0', 'w', 'w', 'w', 'w', 'w', 'w', '0', 'w'},
    		{'w', '0', '0', '0', '0', '0', '0', '0', '0', 'w'},
    		{'w', 'w', 'w', 'w', 'w', 'w', 'w', 'w', 'w', 'w'}
    };

	private static final char[][][][] ALL_SECTOR = {

			{ sector1, sector2, sector3, sector4 },

			{ sector5, sector6, sector7, sector8 },

			{ sector9, sector10, sector11, sector12 },

			{ sector13, sector14, sector15, sector16 }

	};

	private MapManager() {
		this.camera = CameraViewLogic.getInstance();
		this.tileIMG = SourceManager.getInstance().getIMGSource("tile");

	}

	public void initalize() {
		for (int x = 0; x < SECTORS_X; x++) {
			for (int y = 0; y < SECTORS_Y; y++) {
				for (int r = 0; r < SECTOR_RAW; r++) {
					for (int c = 0; c < SECTOR_COL; c++) {

						int mapY = (y * SECTOR_RAW) + r;
						int mapX = (x * SECTOR_COL) + c;

						map[mapY][mapX] = ALL_SECTOR[y][x][r][c];
					}
				}
			}
		}
	}

	public static MapManager getInstance() {
		return mapManager;
	}

	public int getTILE_SIZE() {
		return TILE_SIZE;
	}

	public int getTILES() {
		return TILES;
	}
	public int getMAP_SIZE() {
		return MAP_SIZE;
	}
	public char[][] getMapData(){
		return map;
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
