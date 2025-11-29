package core;

import view.GameWindow;

public class CameraViewLogic {
	private static CameraViewLogic camera;
	GameWindow gameWindow;
	private final int TILE_SIZE;
	private final int TILES;
	private final int MAP_SIZE;
	private double viewPortWidth;
	private double viewPortHeight;

	private double viewPortworldX;
	private double viewPortworldY;

	private double deadZoneX;
	private double deadZoneY;

	private CameraViewLogic() {
		this.gameWindow = UIManager.getInstance().getWindow();
		this.TILE_SIZE = MapManager.getInstance().getTileSize();
		this.TILES = MapManager.getInstance().getTiles();
		this.viewPortHeight = gameWindow.getHeight();
		this.viewPortWidth = gameWindow.getWidth();
		this.MAP_SIZE = TILE_SIZE * TILES;
	}

	public static CameraViewLogic getInstance() {
		if (camera == null) {
			camera = new CameraViewLogic();
		}
		return camera;
	}

	public void update(double playerWorldX, double playerWorldY) {
		viewPortworldX = Math.max(0, Math.min(playerWorldX, MAP_SIZE) - viewPortWidth);
		viewPortworldY = Math.max(0, Math.min(playerWorldY, MAP_SIZE) - viewPortHeight);
	}

	public void setWindow(GameWindow gameWindow) {
		this.gameWindow = gameWindow;
	}

	public double getViewPortworldX() {
		return viewPortworldX;
	}

	public double getViewPortworldY() {
		return viewPortworldY;
	}

}
