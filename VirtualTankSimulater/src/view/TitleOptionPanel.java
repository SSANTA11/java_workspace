package view;

import javax.swing.JButton;
import javax.swing.JPanel;

import core.UIManager;

public class TitleOptionPanel extends JPanel {
	private JButton game, title;

	public TitleOptionPanel() {
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

}
