package core;

import java.util.ArrayList;
import entities.Entity;
import entities.Player;

public class CollisionManager {
	GameManager gameManager = GameManager.getInstance();
	private ArrayList<Entity> arr = gameManager.getList();

	public CollisionManager() {
	}

	public void checkAllCollisions() {
		for (int i = 0; i < arr.size() - 1; i++) {
			for (int j = i+1; j < arr.size(); j++) {
				if (isColliding(arr.get(i), arr.get(j))) {
					handleCollision(arr.get(i), arr.get(j));
				}
			}
		}
	}

	private boolean isColliding(Entity a, Entity b) {

		int aH = a.getHeight();
		int aW = a.getWidth();
		double aX = a.getWorldX();
		double aY = a.getWorldY();

		int bH = b.getHeight();
		int bW = b.getWidth();
		double bX = b.getWorldX();
		double bY = b.getWorldY();

		boolean overlapX = (aX < bX + bW) && (aX + aW > bX);
		boolean overlapY = (aY < bY + bH) && (aY + aH > bY);
		return overlapX && overlapY;
	}// aabb충돌로직(임시). 추후에 전각도 관련 상황에서 히트 지점 수정해야함

	private void handleCollision(Entity a, Entity b) {
		if (a.getType() == "PLAYER") {
			String type = b.getType();
			switch (type) {
			case "PROJECTILE":
				gameManager.HPhandeler(a, 10);
				gameManager.removeEntity(b);
				break;
			case "WALL":
				gameManager.HPhandeler(b, 10);
				gameManager.getEntity(0).setPosition(a.getWorldX() - a.getSpeed(), a.getWorldY() - a.getSpeed());
				break;
			case "FOOTSOLDIER":
				gameManager.HPhandeler(b, 100);
				break;
			}
		}
	}
}