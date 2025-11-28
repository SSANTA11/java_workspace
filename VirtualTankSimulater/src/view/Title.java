package view;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

import core.UIManager;

public class Title extends JPanel {
	private static Title title;
	private JButton game;
	private JButton option;
	private JButton exit ;

	private Title() {
		this.game = new JButton("PLAY!");
		this.exit= new JButton("나가기");
		this.option = new JButton("옵션");
		setLayout(new BorderLayout());
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
		add(g, BorderLayout.SOUTH);
	}

	public static Title getInstance() {
		if (title == null) {
			title = new Title();
		}
		return title;
	}
}
