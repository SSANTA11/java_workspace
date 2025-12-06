package core;

import java.awt.Rectangle;
import java.util.ArrayList;
import entities.Entity;

public class CollisionManager {
	private static CollisionManager collisionManager = new CollisionManager();

	private CollisionManager() {
	}

	public void isCollision() {
		ArrayList<Entity> entities = GameManager.getInstance().getEntities();
		for (int i = 0; i < entities.size(); i++) {
			for (int j = i + 1; j < entities.size(); j++) {
				Rectangle boundA = entities.get(i).getBound();
				Rectangle boundB = entities.get(j).getBound();
				if (boundA.intersects(boundB)) {
					entities.get(j).setHp(entities.get(i).getDamage());
					entities.get(i).setHp(entities.get(j).getDamage());
				}
			}
		}
	}

	public static CollisionManager getInstance() {
		return collisionManager;
	}

}
