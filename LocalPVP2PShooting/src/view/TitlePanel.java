package view;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.Window;

public class TitlePanel extends JPanel {
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
			Window gameWindow = SwingUtilities.getWindowAncestor(this);
			((GameWindow) gameWindow).changePanel("GAME");
		});

		b2.addActionListener(e -> {
			Window gameWindow = SwingUtilities.getWindowAncestor(this);
			((GameWindow) gameWindow).changePanel("OPTION");
		});

		b3.addActionListener(e -> {
			System.exit(0);
		});
	};

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(title, 0, 0, getWidth(), getHeight(), null);
	}
}