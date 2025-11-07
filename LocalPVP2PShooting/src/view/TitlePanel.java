package view;

import javax.swing.*;

import core.GameManager;

public class TitlePanel extends JPanel {
    
    // ⭐ GameManager 싱글톤 인스턴스를 필드에 저장합니다. (딱 한 번 호출)
    private final GameManager manager = GameManager.getInstance();
    
	JButton b1 = new JButton("게임 시작");
	JButton b2 = new JButton("옵션");
	JButton b3 = new JButton("나가기");

	public TitlePanel() {
		this.add(b1);
		this.add(b2);
		this.add(b3);
        
		b1.addActionListener(e -> {
            // ⭐ 주입받은 manager 필드를 사용하여 화면 전환 요청
			manager.changePanel("GAME"); 
		});
        
		b2.addActionListener(e -> {
            // ⭐ 옵션 버튼 리스너도 manager 필드 사용 (옵션 패널이 있다면 "OPTIONS" 등으로 변경 필요)
//			manager.changePanel("OPTION");
			Option option =new Option();
		});
        
		b3.addActionListener(e -> {
			System.exit(0);
		});
	};
}