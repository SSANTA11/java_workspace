package core;

import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

import entities.EnemySoldier;
import entities.Entity;
import entities.Tank;
import entities.Turret;
import entities.Wall;

public class CollisionManager {
	private static CollisionManager collisionManager = new CollisionManager();

	private CollisionManager() {
	}

	public void isCollision() {
		CopyOnWriteArrayList<Entity> entities = GameManager.getInstance().getEntities();
		for (int i = 0; i < entities.size(); i++) {
			for (int j = i + 1; j < entities.size(); j++) {
				Rectangle boundA = entities.get(i).getBound();
				Rectangle boundB = entities.get(j).getBound();
				if (boundA.intersects(boundB)) {
					if ((entities.get(i) instanceof Tank && entities.get(j) instanceof Entity)
							|| (entities.get(j) instanceof Tank && entities.get(i) instanceof Entity)) {
						GameManager.getInstance().getPlayer().setPlayerSpeed();

					}
					System.out.println(entities.get(i).getClass() + "와 " + entities.get(j).getClass() + "가 충돌했습니다.");
					System.out.println(entities.get(i).getClass() + " 체력 " + entities.get(i).getHP() + " "
							+ entities.get(j).getClass() + " 체력 " + entities.get(j).getHP());

					if ((entities.get(j) instanceof Wall && entities.get(i) instanceof EnemySoldier)) {
						entities.get(i).setPosition();
					} else if ((entities.get(j) instanceof EnemySoldier && entities.get(i) instanceof Wall)) {
						entities.get(j).setPosition();
					} else if ((entities.get(j) instanceof EnemySoldier && entities.get(i) instanceof EnemySoldier)) {
						continue;
					} else if ((entities.get(j) instanceof EnemySoldier && entities.get(i) instanceof Turret)) {
						continue;
					} else if ((entities.get(j) instanceof Turret && entities.get(i) instanceof EnemySoldier)) {
						continue;
					} else {
						entities.get(j).setHp(entities.get(i).getDamage());
						entities.get(i).setHp(entities.get(j).getDamage());
					}
				}
			}
		}
	}

	public static CollisionManager getInstance() {
		return collisionManager;
	}

}
