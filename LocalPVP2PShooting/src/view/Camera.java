package view;

import core.MapManager;

public class Camera {

	private static final int MAP_WIDTH = MapManager.MAP_WIDTH;
	private static final int MAP_HEIGHT = MapManager.MAP_HEIGHT;

	private int playerWorldX;
	private int playerWorldY;
	private int cameraWorldX = 0;
	private int cameraWorldY = 0;
	private GameWindow window;
	private static final int DEAD_ZONE_WIDTH = 10;
	private static final int DEAD_ZONE_HEIGHT = 10;
	private static final int FIXED_RANDER_SIZE = 5000;

	public Camera() {
	}

	public void updatePlayerPosition(int playerWorldX, int playerWorldY) {
		this.playerWorldX = playerWorldX;
		this.playerWorldY = playerWorldY;
	}

	public void setWindow(GameWindow window) {
		this.window = window;
	}

	public void updateCamera() {
		int viewPortWidth = window.getWidth();
		int viewPortHeight = window.getHeight();

		int deadZoneMinX = ((viewPortWidth - DEAD_ZONE_WIDTH) / 2);
		int deadZoneMaxX = (deadZoneMinX + DEAD_ZONE_WIDTH);
		int deadZoneMinY = ((viewPortHeight - DEAD_ZONE_HEIGHT) / 2);
		int deadZoneMaxY = (deadZoneMinY + DEAD_ZONE_HEIGHT);

		int playerDeadZoneRefX = playerWorldX - cameraWorldX;
		int playerDeadZoneRefY = playerWorldY - cameraWorldY;

		if (playerDeadZoneRefX > deadZoneMaxX) {
			cameraWorldX += playerDeadZoneRefX - deadZoneMaxX;
		} else if (playerDeadZoneRefX < deadZoneMinX) {
			cameraWorldX += playerDeadZoneRefX - deadZoneMinX;
		}

		if (playerDeadZoneRefY > deadZoneMaxY) {
			cameraWorldY += playerDeadZoneRefY - deadZoneMaxY;
		} else if (playerDeadZoneRefY < deadZoneMinY) {
			cameraWorldY += playerDeadZoneRefY - deadZoneMinY;
		}

		int maxCameraWorldX = MAP_WIDTH - viewPortWidth;
		int maxCameraWorldY = MAP_HEIGHT - viewPortHeight;

		cameraWorldX = Math.max(0, Math.min(cameraWorldX, maxCameraWorldX));
		cameraWorldY = Math.max(0, Math.min(cameraWorldY, maxCameraWorldY));
	}

	public int getCameraSize() {
		return FIXED_RANDER_SIZE;
	}

	public int getplayerWorldX() {
		return playerWorldX;
	}

	public int getplayerWorldY() {
		return playerWorldY;
	}

	public int getCameraWorldX() {
		return cameraWorldX;
	}

	public int getCameraWorldY() {
		return cameraWorldY;
	}
}