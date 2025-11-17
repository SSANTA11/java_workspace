package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.*;
import core.GameManager;
import core.MapManager;
import entities.Player;

public class GamePanel extends JPanel {

	private final GameManager manager = GameManager.getInstance();
	private final Player mainPlayer;
	private final Camera camera;
	private final int FIXED_VIEW_SIZE;

	public GamePanel() {
		this.camera = manager.getCamera();
		this.FIXED_VIEW_SIZE = camera.getCameraSize();
		this.mainPlayer = manager.getPlayer(0);

		addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				mainPlayer.setMoving(e.getKeyCode(), true);
			}

			@Override
			public void keyReleased(KeyEvent e) {
				mainPlayer.setMoving(e.getKeyCode(), false);
			}
		});

		setBackground(Color.BLACK);
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		int cameraWorldX = camera.getCameraWorldX();
		int cameraWorldY = camera.getCameraWorldY();
		int TILE_SIZE = MapManager.TILE_SIZE;

		int viewportOffsetX = (getWidth() - FIXED_VIEW_SIZE) / 2;
		int viewportOffsetY = (getHeight() - FIXED_VIEW_SIZE) / 2;

		int startTileXIndex = cameraWorldX / TILE_SIZE;
		int startTileYIndex = cameraWorldY / TILE_SIZE;
		int endTileXIndex = (cameraWorldX + FIXED_VIEW_SIZE) / TILE_SIZE;
		int endTileYIndex = (cameraWorldY + FIXED_VIEW_SIZE) / TILE_SIZE;

		startTileXIndex = Math.max(0, startTileXIndex);
		startTileYIndex = Math.max(0, startTileYIndex);
		endTileXIndex = Math.min(endTileXIndex, MapManager.WIDTH_TILES);
		endTileYIndex = Math.min(endTileYIndex, MapManager.HEIGHT_TILES);

		for (int y = startTileYIndex; y < endTileYIndex; y++) {
			for (int x = startTileXIndex; x < endTileXIndex; x++) {
				int screenX = viewportOffsetX + (x * TILE_SIZE - cameraWorldX);
				int screenY = viewportOffsetY + (y * TILE_SIZE - cameraWorldY);

				g.drawImage(MapManager.floorTileImage, screenX, screenY, MapManager.TILE_SIZE, MapManager.TILE_SIZE,
						null);
			}
		}

		// --- 플레이어 그리기 ---

		int playerScreenX = (mainPlayer.getX() - cameraWorldX) + viewportOffsetX;
		int playerScreenY = (mainPlayer.getY() - cameraWorldY) + viewportOffsetY;

		mainPlayer.draw(g, playerScreenX, playerScreenY);

	}
}