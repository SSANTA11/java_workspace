package view;

import core.MapManager;

public class Camera {

	private static final int MAP_WIDTH = MapManager.MAP_WIDTH;
	private static final int MAP_HEIGHT = MapManager.MAP_HEIGHT;

	private int playerX;
	private int playerY;
	private int cameraX = 0;
	private int cameraY = 0;
	private static final int DEAD_ZONE_WIDTH = 625;
	private static final int DEAD_ZONE_HEIGHT = 625;
	private static final int FIXED_VIEW_SIZE = 1250;

	public Camera() {
	}

	public void updatePlayerPosition(int PlayerX, int PlayerY) {
		this.playerX = PlayerX;
		this.playerY = PlayerY;
	}

	public void updateCamera() {
		int viewWidth = FIXED_VIEW_SIZE;
		int viewHeight = FIXED_VIEW_SIZE;

		// 1. 📢 데드 존 경계 계산 (월드 좌표 기준)
		// 데드 존의 왼쪽 상단(min)과 오른쪽 하단(max) 월드 좌표를 계산합니다.

		// 화면 좌상단 기준 플레이어의 스크린 좌표
		int playerScreenX = playerX - cameraX;
		int playerScreenY = playerY - cameraY;
		int deadZoneMinX = (viewWidth / 2) - (DEAD_ZONE_WIDTH / 2);
		int deadZoneMaxX = (viewWidth / 2) + (DEAD_ZONE_WIDTH / 2);
		int deadZoneMinY = (viewHeight / 2) - (DEAD_ZONE_HEIGHT / 2);
		int deadZoneMaxY = (viewHeight / 2) + (DEAD_ZONE_HEIGHT / 2);

		// 2.플레이어가 데드 존을 벗어났는지 확인하고 카메라 오프셋 조정
		if (playerScreenX > deadZoneMaxX) {
			cameraX += playerScreenX - deadZoneMaxX;
		}
		else if (playerScreenX < deadZoneMinX) {
			cameraX += playerScreenX - deadZoneMinX;
		}
		if (playerScreenY > deadZoneMaxY) {
			cameraY += playerScreenY - deadZoneMaxY;
		}
		else if (playerScreenY < deadZoneMinY) {
			cameraY += playerScreenY - deadZoneMinY;
		}

//		// 3. 맵 경계 클램핑 (Camera Bounding)
		int maxCameraX = MAP_WIDTH - viewWidth;
		int maxCameraY = MAP_HEIGHT - viewHeight;

		// 카메라 위치 클램핑 (0과 맵 끝 사이로 제한)
		cameraX = Math.max(0, Math.min(cameraX, maxCameraX));
		cameraY = Math.max(0, Math.min(cameraY, maxCameraY));
	}
	
	public int getCameraSize() {
		return FIXED_VIEW_SIZE;
	}
	public int getPlayerX() {
		return playerX;
	}

	public int getPlayerY() {
		return playerY;
	}

	public int getCameraX() {
		return cameraX;
	}

	public int getCameraY() {
		return cameraY;
	}
}