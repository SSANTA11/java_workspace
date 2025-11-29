package view;

import javax.swing.JButton;
import javax.swing.JPanel;

import core.UIManager;

public class TitleOptionPanel extends JPanel {
	private static TitleOptionPanel to;
	private JButton game, title;

	private TitleOptionPanel() {
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

	public static TitleOptionPanel getInstance() {
		if (to == null) {
			to = new TitleOptionPanel();
		}
		return to;
	}
}
