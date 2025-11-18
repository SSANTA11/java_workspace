package core;

import entities.*;

public class CollisionManager {

	public CollisionManager() {
		
	}
	public static boolean isCollision=false;
	public void checkCollision(Entity entity) {
//		this.entityImgWidth=entity.getWidth();
//		this.entityImgHeight=entity.getHeight();
//		this.entityWorldX=entity.entityX;
//		this.entityWorldY=entity.entityX;
//		
	}

}
//package core;
//
//import entities.Entity;
//import java.util.List; // 객체 목록을 받기 위해 필요
//
//public class CollisionManager {
//    // static 변수 제거 (static boolean isCollision)
//    // 인스턴스 변수 제거 (entityImgWidth 등)
//    
//    public CollisionManager() {
//        // 생성자는 비워둡니다.
//    }
//    
//    // ⭐ 메소드를 통해 외부로부터 모든 정보를 받습니다.
//    public void checkAllCollisions(List<Entity> entities) {
//        // 이 메소드 안에서 모든 객체 쌍의 충돌을 검사하고 처리합니다.
//        
//        // 예: 이중 루프를 돌면서 모든 쌍 (A, B)을 검사합니다.
//        for (int i = 0; i < entities.size(); i++) {
//            for (int j = i + 1; j < entities.size(); j++) {
//                Entity entityA = entities.get(i);
//                Entity entityB = entities.get(j);
//                
//                // 두 객체의 충돌을 실제 검사하는 로직 호출
//                if (isColliding(entityA, entityB)) {
//                    // 충돌 처리 (데미지 주기, 총알 제거 등)
//                    handleCollision(entityA, entityB);
//                }
//            }
//        }
//    }
//
//    // ⭐ 두 객체의 충돌 여부만 boolean으로 반환하는 헬퍼 메소드
//    private boolean isColliding(Entity a, Entity b) {
//        // 이 부분이 실제 사각형/원형 충돌 검사 로직이 들어가는 곳입니다.
//        // 예를 들어: a.getBounds().intersects(b.getBounds())
//        
//        // 여기에 a와 b의 width, height, X, Y 값을 지역 변수로 가져와서 사용합니다.
//        
//        return false; // 임시 반환
//    }
//    
//    private void handleCollision(Entity a, Entity b) {
//        // 충돌 발생 시 체력 감소, 득점 등 상태 변화 로직을 구현합니다.
//    }
//}