package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Window;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

// import core.GameManager; // GameManager import 제거

public class OptionPanel extends JPanel{
	private JButton b=new JButton("타이틀로 돌아가기");
	// private final GameManager manager = GameManager.getInstance() ; // GameManager 필드 제거
    
	public OptionPanel() {
		add(b);
		setBackground(Color.BLACK);
        
        // 📢 수정: 버튼 클릭 시, GameWindow를 찾아 changePanel 호출
		b.addActionListener(e->{
            // 자신(OptionPanel)의 최상위 Window 객체를 찾습니다.
			Window window = SwingUtilities.getWindowAncestor(this);
			if (window instanceof GameWindow) {
                // GameWindow를 찾으면, changePanel("TITLE") 호출
				((GameWindow) window).changePanel("TITLE");
			}
		});
	}

}