package core;

public class CollisionManager {
	private static CollisionManager collisionManager = new CollisionManager();

	private CollisionManager() {

	}

	public static CollisionManager getInstance() {
		return collisionManager;
	}

	public boolean isPlayerCollision() {
		int playerCenterX = (int) GameManager.getInstance().getPlayer().getCenterX();
		int playerCenterY = (int) GameManager.getInstance().getPlayer().getCenterY();

		if (playerCenterX>) {
			
		}
		// 충돌 경우의 수 
			// 1. 피탄, 구조물, 적
		// 전체 
		return true;
	}
}
