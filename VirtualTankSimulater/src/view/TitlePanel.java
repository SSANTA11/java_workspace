package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JButton;
import javax.swing.JPanel;

import core.SourceManager;
import core.UIManager;

public class TitlePanel extends JPanel {
	private static TitlePanel title;
	private JButton game;
	private JButton option;
	private JButton exit;
	private BufferedImage titleIMG;

	private TitlePanel() {
		this.titleIMG = SourceManager.getInstance().getIMGSource("title");
		this.game = new JButton("PLAY!");
		this.exit = new JButton("나가기");
		this.option = new JButton("옵션");
		setLayout(new BorderLayout());
		setBackground(Color.black);
		JPanel g = new JPanel();
		g.add(game);
		game.addActionListener(e -> {
			UIManager.getInstance().changePanel("game");
		});
		option.addActionListener(e -> {
			UIManager.getInstance().changePanel("titleOption");
		});
		exit.addActionListener(e -> {
			UIManager.getInstance().changePanel("exit");
		});
		g.add(option);
		g.add(exit);
		g.setBackground(Color.black);
		add(g, BorderLayout.SOUTH);
	}

	public static TitlePanel getInstance() {
		if (title == null) {
			title = new TitlePanel();
		}
		return title;
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(titleIMG, (getWidth() - titleIMG.getWidth() / 2) / 2, (getHeight() - titleIMG.getHeight() / 2) / 2,
				titleIMG.getWidth() / 2, titleIMG.getHeight() / 2, null);
	}

}
