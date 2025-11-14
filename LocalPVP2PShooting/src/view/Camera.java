package view;

import core.MapManager;

public class Camera {

	private static final int MAP_WIDTH = MapManager.MAP_WIDTH;
	private static final int MAP_HEIGHT = MapManager.MAP_HEIGHT;

	private int playerX;
	private int playerY;

	private int cameraX = 0;
	private int cameraY = 0;
	// view/Camera.java (수정)

	private static final int DEAD_ZONE_WIDTH = 625; // 📢 데드 존 너비 (예: 200px)
	private static final int DEAD_ZONE_HEIGHT = 625; // 📢 데드 존 높이 (예: 150px)

	// ... (기존 필드 유지: playerX, playerY, cameraX, cameraY, MAP_WIDTH, FIXED_VIEW_SIZE
	// 등)
	public Camera() {
	}

	public void updatePlayerPosition(int newPlayerX, int newPlayerY) {
		this.playerX = newPlayerX;
		this.playerY = newPlayerY;
	}

	private static final int FIXED_VIEW_SIZE = 1250;

	public void updateCamera() {
		int viewWidth = FIXED_VIEW_SIZE;
		int viewHeight = FIXED_VIEW_SIZE;

		// 1. 📢 데드 존 경계 계산 (월드 좌표 기준)
		// 데드 존의 왼쪽 상단(min)과 오른쪽 하단(max) 월드 좌표를 계산합니다.

		// 화면 좌상단 기준 플레이어의 스크린 좌표
		int playerScreenX = playerX - cameraX;
		int playerScreenY = playerY - cameraY;

		// 데드 존의 왼쪽 경계 (화면 중앙 - 데드존 절반 크기)
		int deadZoneMinX = (viewWidth / 2) - (DEAD_ZONE_WIDTH / 2);
		// 데드 존의 오른쪽 경계
		int deadZoneMaxX = (viewWidth / 2) + (DEAD_ZONE_WIDTH / 2);

		// 데드 존의 위쪽 경계
		int deadZoneMinY = (viewHeight / 2) - (DEAD_ZONE_HEIGHT / 2);
		// 데드 존의 아래쪽 경계
		int deadZoneMaxY = (viewHeight / 2) + (DEAD_ZONE_HEIGHT / 2);

		// 2. 📢 플레이어가 데드 존을 벗어났는지 확인하고 카메라 오프셋 조정

		// ➡️ 오른쪽으로 벗어났다면, 플레이어를 데드 존 경계에 맞추기 위해 카메라를 이동시킵니다.
		if (playerScreenX > deadZoneMaxX) {
			// 카메라 오프셋(cameraX)을 늘립니다. (맵이 왼쪽으로 스크롤)
			cameraX += playerScreenX - deadZoneMaxX;
		}
		// ⬅️ 왼쪽으로 벗어났다면
		else if (playerScreenX < deadZoneMinX) {
			// 카메라 오프셋(cameraX)을 줄입니다. (맵이 오른쪽으로 스크롤)
			cameraX += playerScreenX - deadZoneMinX;
		}

		// ⬇️ 아래쪽으로 벗어났다면
		if (playerScreenY > deadZoneMaxY) {
			cameraY += playerScreenY - deadZoneMaxY;
		}
		// ⬆️ 위쪽으로 벗어났다면
		else if (playerScreenY < deadZoneMinY) {
			cameraY += playerScreenY - deadZoneMinY;
		}

		// 3. 🧱 맵 경계 클램핑 (Camera Bounding)
		int maxCameraX = MAP_WIDTH - viewWidth;
		int maxCameraY = MAP_HEIGHT - viewHeight;

		maxCameraX = Math.max(0, maxCameraX);
		maxCameraY = Math.max(0, maxCameraY);

		// 카메라 위치 클램핑 (0과 맵 끝 사이로 제한)
		cameraX = Math.max(0, Math.min(cameraX, maxCameraX));
		cameraY = Math.max(0, Math.min(cameraY, maxCameraY));
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