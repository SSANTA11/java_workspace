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
	private static final int RENDER_SIZE = 1250;

	public GamePanel() {
		this.mapManager = manager.getMapManager();
		this.camera = manager.getCamera();
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

		// 📢 2. 전체 뷰포트 중앙 배치를 위한 오프셋 계산
		// 맵과 플레이어를 윈도우 중앙으로 이동시키는 여백
		int viewportOffsetX = (getWidth() - RENDER_SIZE) / 2;
		int viewportOffsetY = (getHeight() - RENDER_SIZE) / 2;

		// 4. 렌더링 범위 제한 계산 (최적화, RENDER_SIZE 사용)
		int startX = camX / MapManager.TILE_SIZE;
		int startY = camY / MapManager.TILE_SIZE;
		int endX = (camX + RENDER_SIZE) / MapManager.TILE_SIZE + 1;
		int endY = (camY + RENDER_SIZE) / MapManager.TILE_SIZE + 1;

		// 맵 경계 제한
		startX = Math.max(0, startX);
		startY = Math.max(0, startY);
		endX = Math.min(endX, MapManager.WIDTH_TILES);
		endY = Math.min(endY, MapManager.HEIGHT_TILES);

		// --- 맵 배경 (floorTileImage, backWallTileImage) 그리기 ---
		for (int y = startY; y < endY; y++) {
			for (int x = startX; x < endX; x++) {
				// 📢 3. 월드 좌표 -> 스크린 좌표 변환 시 뷰포트 오프셋 적용
				int screenX = (x * MapManager.TILE_SIZE - camX) + viewportOffsetX;
				int screenY = (y * MapManager.TILE_SIZE - camY) + viewportOffsetY;

				if ((x == 0 && y == 0) || (y == 0 && x == MapManager.WIDTH_TILES - 1))
					g.drawImage(MapManager.backWallTileImage, screenX, screenY, MapManager.TILE_SIZE,
							MapManager.TILE_SIZE, null);
				else
					g.drawImage(MapManager.floorTileImage, screenX, screenY, MapManager.TILE_SIZE, MapManager.TILE_SIZE,
							null);
			}
		}

		// --- 맵 요소 (벽, wallTileImage) 그리기 ---
		for (int y = startY; y < endY; y++) {
			for (int x = startX; x < endX; x++) {
				char tileType = mapManager.getTile(x, y);

				// 📢 4. 월드 좌표 -> 스크린 좌표 변환 시 뷰포트 오프셋 적용
				int screenX = (x * MapManager.TILE_SIZE - camX) + viewportOffsetX;
				int screenY = (y * MapManager.TILE_SIZE - camY) + viewportOffsetY;

				if (tileType == 'w') {
					g.drawImage(MapManager.wallTileImage2, screenX, screenY, MapManager.TILE_SIZE, MapManager.TILE_SIZE,
							null);
				} else if (tileType == 'W') {
					g.drawImage(MapManager.wallTileImage1, screenX, screenY, MapManager.TILE_SIZE, MapManager.TILE_SIZE,
							null);
				}
			}
		}

		// --- 플레이어 그리기 ---
		// 📢 5. 플레이어 위치: 고정된 RENDER_SIZE 중앙 + 뷰포트 오프셋
		int fixedCenterX = RENDER_SIZE / 2 - mainPlayer.getWidth() / 2;
		int fixedCenterY = RENDER_SIZE / 2 - mainPlayer.getHeight() / 2;

		int playerScreenX = (mainPlayer.getX() - camX) + viewportOffsetX;
		int playerScreenY = (mainPlayer.getY() - camY) + viewportOffsetY;

		mainPlayer.draw(g, playerScreenX, playerScreenY);
		// 디버그 정보 (윈도우 좌상단 기준으로 유지)
		g.setColor(Color.WHITE);
		g.drawString("World Target: (" + mainPlayer.getX() + ", " + mainPlayer.getY() + ")", 10, 20);
		g.drawString("Camera Offset: (" + camX + ", " + camY + ")", 10, 40);
	}
}