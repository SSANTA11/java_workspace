package core;

public class CameraViewLogic {
	private static CameraViewLogic cameraViewLogic = new CameraViewLogic();

	private final int TILE_SIZE;
	private final int TILES;
	private final int MAP_SIZE;

	private double playerScreenX;
	private double playerScreenY;

	private double viewPortWidth;
	private double viewPortHeight;
	private double viewPortworldX;
	private double viewPortworldY;

	private static final double DEAD_ZONE_WIDTH = 10;
	private static final double DEAD_ZONE_HEIGHT = 10;
	double deadZoneMinX;
	double deadZoneMaxX;
	double deadZoneMinY;
	double deadZoneMaxY;

	private CameraViewLogic() {
		this.TILE_SIZE = MapManager.TILE_SIZE;
		this.TILES = MapManager.TILES;
		this.MAP_SIZE = TILE_SIZE * TILES;
	}

	public static CameraViewLogic getInstance() {
		return cameraViewLogic;
	}

	public void update(double playerScreenX, double playerScreenY) {
		this.playerScreenX = playerScreenX;
		this.playerScreenY = playerScreenY;
	}

	public void updateViewPort() {
		double deadZoneMinX = ((viewPortWidth - DEAD_ZONE_WIDTH) / 2);
		double deadZoneMaxX = (deadZoneMinX + DEAD_ZONE_WIDTH);
		double deadZoneMinY = ((viewPortHeight - DEAD_ZONE_HEIGHT) / 2);
		double deadZoneMaxY = (deadZoneMinY + DEAD_ZONE_HEIGHT);
		this.viewPortHeight = UIManager.getInstance().getWindowHeight();
		this.viewPortWidth = UIManager.getInstance().getWindowWidth();

		if (playerScreenX > deadZoneMaxX) {
			viewPortworldX += playerScreenX - deadZoneMaxX;
		} else if (playerScreenX < deadZoneMinX) {
			viewPortworldX += playerScreenX - deadZoneMinX;
		}

		if (playerScreenY > deadZoneMaxY) {
			viewPortworldY += playerScreenY - deadZoneMaxY;
		} else if (playerScreenY < deadZoneMinY) {
			viewPortworldY += playerScreenY - deadZoneMinY;
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
