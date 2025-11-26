package view;

import core.MapManager;

public class Camera {

	private static final int MAP_WIDTH = MapManager.MAP_WIDTH;
	private static final int MAP_HEIGHT = MapManager.MAP_HEIGHT;

	private double playerWorldX;
	private double playerWorldY;
	private double cameraWorldX = 0.0; // ------------
	private double cameraWorldY = 0.0; // ------------
	private GameWindow window;
	private static final int DEAD_ZONE_WIDTH = 1;
	private static final int DEAD_ZONE_HEIGHT = 1;
	private static final int FIXED_RANDER_SIZE = 5000;

	public Camera() {
	}

	public void updatePlayerPosition(double playerWorldX, double playerWorldY) {
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

		double playerDeadZoneRefX = playerWorldX - cameraWorldX;
		double playerDeadZoneRefY = playerWorldY - cameraWorldY;

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

		double maxCameraWorldX = MAP_WIDTH - viewPortWidth; // ------------
		double maxCameraWorldY = MAP_HEIGHT - viewPortHeight; // ------------

		cameraWorldX = Math.max(0.0, Math.min(cameraWorldX, maxCameraWorldX)); // ------------
		cameraWorldY = Math.max(0.0, Math.min(cameraWorldY, maxCameraWorldY)); // ------------
	}

	public int getCameraSize() {
		return FIXED_RANDER_SIZE;
	}

	public double getplayerWorldX() {
		return playerWorldX;
	}

	public double getplayerWorldY() {
		return playerWorldY;
	}

	public int getCameraWorldX() {
		return (int) Math.round(cameraWorldX); // ------------
	}

	public int getCameraWorldY() {
		return (int) Math.round(cameraWorldY); // ------------
	}
}