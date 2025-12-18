package core;

import java.util.concurrent.CopyOnWriteArrayList;

import entities.Entity;
import entities.Projectile;

public class ExploManager {
	private static ExploManager exploManager = new ExploManager();

	private ExploManager() {
	}

	public static ExploManager getInstance() {
		return exploManager;
	}

	public void damageByExplo(double projectileX, double projectileY, int explosionRange, int damage) {
		CopyOnWriteArrayList<Entity> entities = GameManager.getInstance().getEntities();
		for (int i = 0; i < entities.size(); i++) {
			double centerX = entities.get(i).getCenterX();
			double centerY = entities.get(i).getCenterY();
			double distance = (projectileX - centerX) * (projectileX - centerX)
					+ (projectileY - centerY) * (projectileY - centerY);
			if (distance  < (explosionRange / 2) * (explosionRange / 2)) {
				if (!(entities.get(i) instanceof Projectile)) {
					entities.get(i).takeDamage(damage);
				}
			}
		}
	}

}
