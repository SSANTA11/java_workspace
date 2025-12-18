package core;

import java.util.concurrent.CopyOnWriteArrayList;

import entities.Enemy;
import entities.Entity;

public class CollisionManager {
	private static CollisionManager collisionManager = new CollisionManager();

	private CollisionManager() {
	}

	public void isCollision() {
		CopyOnWriteArrayList<Entity> entities = GameManager.getInstance().getEntities();
		for (int i = 0; i < entities.size(); i++) {
			for (int j = i + 1; j < entities.size(); j++) {
				if (entities.get(i).getBound().intersects(entities.get(j).getBound())) {
					if ((entities.get(j) instanceof Enemy && entities.get(i) instanceof Enemy)) {
						entities.get(i).setPosition();
						entities.get(j).setPosition();
					} else {
						entities.get(i).setPosition();
						entities.get(j).setPosition();
						entities.get(j).takeDamage(entities.get(i).getDamage());
						entities.get(i).takeDamage(entities.get(j).getDamage());
					}
				}
			}
		}
	}

	public static CollisionManager getInstance() {
		return collisionManager;
	}

}
