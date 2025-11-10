package core;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import entities.Player;

// KeyAdapter를 상속받으면 KeyListener 인터페이스 구현 불필요 (선택)
public class InputHandler extends KeyAdapter { 
    
    // 1. 인스턴스 필드 사용 (GameManager에서 전달받아야 함)
    private Player player; 

    // 2. 생성자를 통해 실제 Player 인스턴스를 전달받음 (필수)
    public InputHandler(Player player) {
        this.player = player;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        // 3. Player 객체의 이동 플래그만 변경
        player.setMoving(e.getKeyCode(), true); 
    }
    
    @Override
    public void keyReleased(KeyEvent e) {
        // 키를 떼면 이동 플래그를 false로 변경하여 움직임을 멈춥니다.
        player.setMoving(e.getKeyCode(), false); 
    }
}