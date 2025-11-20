package view;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.Window; // Window 클래스 import 추가

public class TitlePanel extends JPanel {
	// private final GameManager manager = GameManager.getInstance(); // ❌ GameManager 필드 제거
	private JPanel p = new JPanel();
	JButton b1 = new JButton("게임 시작");
	JButton b2 = new JButton("옵션");
	JButton b3 = new JButton("나가기");
	public static BufferedImage title;

	public void loadTitle() {
		try {
			title = ImageIO.read(getClass().getResource("/title.png"));
		} catch (IOException e) {
			System.out.println("no IMG");
			System.exit(1);
		}
	}

	public TitlePanel() {
		loadTitle();
		setLayout(new BorderLayout());
		p.add(b1);
		p.add(b2);
		p.add(b3);
		add(p, BorderLayout.SOUTH);

		// 📢 수정: 버튼 클릭 시, 자신을 포함하는 GameWindow 객체를 찾아 changePanel 호출
		b1.addActionListener(e -> {
			// 자신(TitlePanel)의 최상위 Window 객체를 찾습니다.
			Window window = SwingUtilities.getWindowAncestor(this);
			if (window instanceof GameWindow) {
				((GameWindow) window).changePanel("GAME");
			}
		});

		b2.addActionListener(e -> {
			Window window = SwingUtilities.getWindowAncestor(this);
			if (window instanceof GameWindow) {
				((GameWindow) window).changePanel("OPTION");
			}
		});

		b3.addActionListener(e -> {
			System.exit(0);
		});
	};

	@Override
	protected void paintComponent(Graphics g) {
        // 배경 이미지를 그리기 전에 반드시 super.paintComponent를 호출해야 합니다.
        super.paintComponent(g); 
		g.drawImage(title, 0, 0, getWidth(), getHeight(), null); // GameWindow.WIDTH 대신 getWidth() 사용 권장
	}
}