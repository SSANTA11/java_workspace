package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage; // BufferedImage는 사용하지 않지만 import는 유지

import javax.swing.*;

import core.GameManager;
import core.MapManager;
import entities.Player;

public class GamePanel extends JPanel {

	private final MapManager mapManager;
	private final GameManager manager = GameManager.getInstance();
	private final Player mainPlayer;
	private final Camera camera;
	private final int FIXED_VIEW_SIZE;

	public GamePanel() {
		this.mapManager = manager.getMapManager();
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

		camera.updateCamera();

		int camX = camera.getCameraX();
		int camY = camera.getCameraY();

		int viewportOffsetX = (getWidth() - FIXED_VIEW_SIZE) / 2;
		int viewportOffsetY = (getHeight() - FIXED_VIEW_SIZE) / 2;

		int startX = camX / MapManager.TILE_SIZE;
		int startY = camY / MapManager.TILE_SIZE;
		int endX = (camX + FIXED_VIEW_SIZE) / MapManager.TILE_SIZE;
		int endY = (camY + FIXED_VIEW_SIZE) / MapManager.TILE_SIZE;
//
//		startX = Math.max(0, startX);
//		startY = Math.max(0, startY);
//		endX = Math.min(endX, MapManager.WIDTH_TILES);
//		endY = Math.min(endY, MapManager.HEIGHT_TILES);

		for (int y = startY; y < endY; y++) {
			for (int x = startX; x < endX; x++) {
				int screenX = (x * MapManager.TILE_SIZE - camX) + viewportOffsetX;
				int screenY = (y * MapManager.TILE_SIZE - camY) + viewportOffsetY;

				g.drawImage(MapManager.floorTileImage, screenX, screenY, MapManager.TILE_SIZE, MapManager.TILE_SIZE,
						null);
			}
		}

		// --- 플레이어 그리기 ---

		int playerScreenX = (mainPlayer.getX() - camX) + viewportOffsetX;
		int playerScreenY = (mainPlayer.getY() - camY) + viewportOffsetY;

		mainPlayer.draw(g, playerScreenX, playerScreenY);

	}
}