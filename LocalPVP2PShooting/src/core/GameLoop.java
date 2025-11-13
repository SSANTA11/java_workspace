package core;

import entities.Player;
import view.GamePanel;

//
public class GameLoop implements Runnable {
//
//	private GameManager manager = GameManager.getInstance();
//	private boolean running = true;
//
//	public GameLoop(GameManager manager) {
//	}
//
//	@Override
//	public void run() {
//		while (running) {
//			manager.updateGame();
//			try { Thread.sleep(16); } 
//			catch (InterruptedException e) {}
//		}
//	}
//
// --------------------------------기존 코드----------------------------------
	private GamePanel gamePanel; // 뷰(View) 갱신 요청을 위한 참조
    private Player player;       // 캐릭터 위치 업데이트를 위한 참조
    private Thread gameThread;
	// 게임 속도 제어 설정 (60 FPS 목표)
    private final int FPS_SET = 60; 
    // 초당 나노초(10억) / 목표 프레임 수 = 1프레임당 소요되어야 하는 시간
    private final double timePerUpdate = 1000000000.0 / FPS_SET;

public GameLoop(GamePanel gamePanel, Player player) {
        this.gamePanel = gamePanel;
        this.player = player;
    }

    public void startGameLoop() {
        // 맵 리소스 로드는 스레드 시작 전에 완료되어야 합니다.
        gamePanel.getMapManager().loadTileset();
        
        gameThread = new Thread(this);
        gameThread.start(); // 스레드 시작
    }

    @Override
    public void run() {
        long lastTime = System.nanoTime(); // 마지막 업데이트 시간
        double delta = 0; // 업데이트 타이머 누적 변수
        
        while (true) {
            long now = System.nanoTime();
            
            // 경과된 시간을 timePerUpdate 단위로 변환하여 delta에 누적
            delta += (now - lastTime) / timePerUpdate;
            lastTime = now;
            
            // delta가 1 이상이면 (1프레임 시간이 경과했으면)
            if (delta >= 1) {
                // 1. 게임 논리 업데이트 (Model)
                update(); 
                
                // 2. 화면 갱신 요청 (View)
                gamePanel.repaint(); // EDT에게 paintComponent()를 호출하도록 요청
                
                delta--; // 업데이트 수행 후 누적값 감소
            }

            // CPU 사용률을 줄이기 위한 스레드 슬립 (선택적)
            try {
                // 다음 업데이트까지 남은 시간만큼 잠시 대기
                long timeToWait = (long)(timePerUpdate * delta) / 1000000;
                if (timeToWait > 0) {
                    Thread.sleep(timeToWait); 
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt(); // 인터럽트 상태 복구
            }
        }
    }
}