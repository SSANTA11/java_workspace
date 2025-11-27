package core;

import view.GameWindow;

public class Camera {

	private static final double MAP_WIDTH = MapManager.MAP_WIDTH;
	private static final double MAP_HEIGHT = MapManager.MAP_HEIGHT;

	private double playerWorldX;
	private double playerWorldY;
	private double cameraWorldX = 0.0;
	private double cameraWorldY = 0.0;
	private GameWindow window;
	private static final double DEAD_ZONE_WIDTH = 1;
	private static final double DEAD_ZONE_HEIGHT = 1;
	private static final double FIXED_RANDER_SIZE = 5000;

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
		double viewPortWidth = window.getWidth();
		double viewPortHeight = window.getHeight();

		double deadZoneMinX = ((viewPortWidth - DEAD_ZONE_WIDTH) / 2);
		double deadZoneMaxX = (deadZoneMinX + DEAD_ZONE_WIDTH);
		double deadZoneMinY = ((viewPortHeight - DEAD_ZONE_HEIGHT) / 2);
		double deadZoneMaxY = (deadZoneMinY + DEAD_ZONE_HEIGHT);

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

		double maxCameraWorldX = MAP_WIDTH - viewPortWidth;
		double maxCameraWorldY = MAP_HEIGHT - viewPortHeight;

		cameraWorldX = Math.max(0.0, Math.min(cameraWorldX, maxCameraWorldX));
		cameraWorldY = Math.max(0.0, Math.min(cameraWorldY, maxCameraWorldY));
	}

	public double getCameraSize() {
		return FIXED_RANDER_SIZE;
	}

	public double getplayerWorldX() {
		return playerWorldX;
	}

	public double getplayerWorldY() {
		return playerWorldY;
	}

	public double getCameraWorldX() {
		return (double) Math.round(cameraWorldX);
	}

	public double getCameraWorldY() {
		return (double) Math.round(cameraWorldY);
	}
}