package core;

import view.GameWindow;

public class CameraViewLogic {
	private static CameraViewLogic camera;

	private final int TILE_SIZE;
	private final int TILES;
	private final int MAP_SIZE;

	private double playerWorldX;
	private double playerWorldY;

	private double viewPortWidth;
	private double viewPortHeight;
	private double viewPortworldX;
	private double viewPortworldY;

	private static final double DEAD_ZONE_WIDTH = 1;
	private static final double DEAD_ZONE_HEIGHT = 1;
	double deadZoneMinX;
	double deadZoneMaxX;
	double deadZoneMinY;
	double deadZoneMaxY;

	private CameraViewLogic() {
		this.TILE_SIZE = MapManager.getInstance().getTileSize();
		this.TILES = MapManager.getInstance().getTiles();
		this.viewPortHeight = UIManager.getInstance().getWindowHeight();
		this.viewPortWidth = UIManager.getInstance().getWindowWidth();
		this.MAP_SIZE = TILE_SIZE * TILES;
	}

	public static CameraViewLogic getInstance() {
		if (camera == null) {
			camera = new CameraViewLogic();
		}
		return camera;
	}

	public void update(double playerWorldX, double playerWorldY) {
		this.playerWorldX = playerWorldX;
		this.playerWorldY = playerWorldY;
	}

	public void updateViewPort() {
		double deadZoneMinX = ((viewPortWidth - DEAD_ZONE_WIDTH) / 2);
		double deadZoneMaxX = (deadZoneMinX + DEAD_ZONE_WIDTH);
		double deadZoneMinY = ((viewPortHeight - DEAD_ZONE_HEIGHT) / 2);
		double deadZoneMaxY = (deadZoneMinY + DEAD_ZONE_HEIGHT);

		double playerDeadZoneRefX = playerWorldX - viewPortworldX;
		double playerDeadZoneRefY = playerWorldY - viewPortworldY;

		if (playerWorldX > deadZoneMaxX) {
			viewPortworldX += playerDeadZoneRefX + deadZoneMaxX;
		} else if (playerWorldX < deadZoneMinX) {
			viewPortworldX -= deadZoneMinX - playerDeadZoneRefX;
		}

		if (playerDeadZoneRefY > deadZoneMaxY) {
			viewPortworldY += playerDeadZoneRefY - deadZoneMaxY;
		} else if (playerWorldY < deadZoneMinY) {
			viewPortworldY -= deadZoneMinY - playerDeadZoneRefY;
		}

		viewPortworldX = Math.max(0, Math.min(viewPortworldX, MAP_SIZE - viewPortWidth));
		viewPortworldY = Math.max(0, Math.min(viewPortworldY, MAP_SIZE - viewPortHeight));
	}

	public double getViewPortworldX() {
		return viewPortworldX;
	}

	public double getViewPortworldY() {
		return viewPortworldY;
	}

}
