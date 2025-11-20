package core;

import java.util.ArrayList;

import entities.Entity;

public class CollisionManager {
	private ArrayList<Entity> arr = GameManager.getInstance().getList();

	public CollisionManager() {
	}

	public void checkAllCollisions() {
		for (int i = 0; i < arr.size()-1; i++) {
			for (int j = 1; j < arr.size(); j++) {
				if (isColliding(arr.get(i),arr.get(j))){
					
				}
			}
		}
	}
    private boolean isColliding(Entity a, Entity b) {
        // 이 부분이 실제 사각형/원형 충돌 검사 로직이 들어가는 곳입니다.
        // 예를 들어: a.getBounds().intersects(b.getBounds())
        
        // 여기에 a와 b의 width, height, X, Y 값을 지역 변수로 가져와서 사용합니다.
        
        return false; // 임시 반환
    }
    
    private void handleCollision(Entity a, Entity b) {
        // 충돌 발생 시 체력 감소, 득점 등 상태 변화 로직을 구현합니다.
    }
}