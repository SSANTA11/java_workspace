package view;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

import core.GameManager;

public class TitlePanel extends JPanel {
	private final GameManager manager = GameManager.getInstance();
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
		b1.addActionListener(e -> {
			manager.changePanel("GAME");
		});

		b2.addActionListener(e -> {
			manager.changePanel("OPTION");
		});

		b3.addActionListener(e -> {
			System.exit(0);
		});
	};

	@Override
	protected void paintComponent(Graphics g) {
		g.drawImage(title, 0, 0, GameWindow.WIDTH, GameWindow.HEIGHT, null);
	}
}