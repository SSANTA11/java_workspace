package view;

import javax.swing.JButton;
import javax.swing.JPanel;

import core.UIManager;

public class TitleOption extends JPanel {
	private static TitleOption to;
	private JButton game, title;

	private TitleOption() {
		this.game = new JButton("게임으로 돌아가기");
		this.title = new JButton("타이틀로 돌아가기");
		game.addActionListener(e -> {
			UIManager.getInstance().changePanel("game");
		});
		title.addActionListener(e -> {
			UIManager.getInstance().changePanel("title");
		});

		add(game);
		add(title);
	}

	public static TitleOption getInstance() {
		if (to == null) {
			to = new TitleOption();
		}
		return to;
	}
}
