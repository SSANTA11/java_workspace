package core;

public class CameraViewLogic {
	private static CameraViewLogic cameraViewLogic = new CameraViewLogic();

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
		viewPortworldX = Math.max(0, Math.min(viewPortworldX, MapManager.getInstance().getTILE_SIZE() * MapManager.getInstance().getTILES() - viewPortWidth));
		viewPortworldY = Math.max(0, Math.min(viewPortworldY, MapManager.getInstance().getTILE_SIZE() * MapManager.getInstance().getTILES() - viewPortHeight));
	}

	public double getViewPortworldX() {
		return viewPortworldX;
	}

	public double getViewPortworldY() {
		return viewPortworldY;
	}

}
