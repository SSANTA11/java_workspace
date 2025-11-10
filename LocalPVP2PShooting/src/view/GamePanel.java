package view;

import java.awt.Graphics;
import javax.swing.*;

import core.InputHandler;
import core.MapManager;
import entities.Player;

public class GamePanel extends JPanel {
	private MapManager mapManager;
	private Player p = new Player();

	public GamePanel(MapManager mapManager) {
		this.mapManager = mapManager;
		addKeyListener(new InputHandler(p));
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		for (int y = 0; y < MapManager.HEIGHT_TILES; y++) {
			for (int x = 0; x < MapManager.WIDTH_TILES; x++) {
				if ((x == 0 && y == 0) || (y == 0 && x == MapManager.WIDTH_TILES - 1))
					g.drawImage(MapManager.backWallTileImage, x * MapManager.TILE_SIZE, y * MapManager.TILE_SIZE,
							MapManager.TILE_SIZE, MapManager.TILE_SIZE, null);
				else
					g.drawImage(MapManager.floorTileImage, x * MapManager.TILE_SIZE, y * MapManager.TILE_SIZE,
							MapManager.TILE_SIZE, MapManager.TILE_SIZE, null);
			}
		}

		for (int y = 0; y < MapManager.HEIGHT_TILES; y++) {
			for (int x = 0; x < MapManager.WIDTH_TILES; x++) {
				char tileType = mapManager.getTile(x, y);

				if (tileType == 'w') {
					g.drawImage(MapManager.wallTileImage2, x * MapManager.TILE_SIZE, y * MapManager.TILE_SIZE,
							MapManager.TILE_SIZE, MapManager.TILE_SIZE, null);
				} else if (tileType == 'W') {
					g.drawImage(MapManager.wallTileImage1, x * MapManager.TILE_SIZE, y * MapManager.TILE_SIZE,
							MapManager.TILE_SIZE, MapManager.TILE_SIZE, null);
				}

			}
		}
	}
}
