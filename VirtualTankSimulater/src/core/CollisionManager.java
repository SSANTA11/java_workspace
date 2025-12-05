package core;

import java.awt.Rectangle;
import java.util.ArrayList;
import entities.Entity;

public class CollisionManager {
	private static CollisionManager collisionManager = new CollisionManager();
	private ArrayList<Entity> entities;

	private CollisionManager() {
	}

	public void isCollision() {
		for (int i = 0; i < entities.size(); i++) {
			Rectangle boundA = entities.get(i).getBound();
			for (int j = i + 1; j < entities.size(); j++) {
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
