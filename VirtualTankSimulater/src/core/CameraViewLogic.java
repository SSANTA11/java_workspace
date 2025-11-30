package core;


public class CameraViewLogic {
	private static CameraViewLogic cameraViewLogic = new CameraViewLogic();

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
		this.TILE_SIZE = MapManager.TILE_SIZE;
		this.TILES = MapManager.TILES;
		this.viewPortHeight = UIManager.getInstance().getWindowHeight();
		this.viewPortWidth = UIManager.getInstance().getWindowWidth();
		this.MAP_SIZE = TILE_SIZE * TILES;
	}

	public static CameraViewLogic getInstance() {
		return cameraViewLogic;
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

		double playerScreenX = playerWorldX - viewPortworldX;
	    double playerScreenY = playerWorldY - viewPortworldY;
		if (playerScreenX > deadZoneMaxX) {
	        // 플레이어가 데드 존의 오른쪽 경계를 벗어남
	        viewPortworldX += playerScreenX - deadZoneMaxX;
	    } else if (playerScreenX < deadZoneMinX) {
	        // 플레이어가 데드 존의 왼쪽 경계를 벗어남
	        viewPortworldX += playerScreenX - deadZoneMinX;
	    }

	    // **[수정] Y축 스크롤 로직:**
	    if (playerScreenY > deadZoneMaxY) {
	        // 플레이어가 데드 존의 아래쪽 경계를 벗어남
	        viewPortworldY += playerScreenY - deadZoneMaxY;
	    } else if (playerScreenY < deadZoneMinY) {
	        // 플레이어가 데드 존의 위쪽 경계를 벗어남
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
