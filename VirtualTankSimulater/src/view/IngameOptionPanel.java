package view;

import javax.swing.JButton;
import javax.swing.JPanel;

import core.UIManager;

public class IngameOptionPanel extends JPanel {
	private JButton game;
	private JButton title;
	private JButton exit;

	public IngameOptionPanel() {
		this.game = new JButton("게임으로 돌아가기");
		this.title = new JButton("타이틀로 돌아가기");
		this.exit = new JButton("나가기");
		game.addActionListener(e -> {
			UIManager.getInstance().changePanel("game");
		});
		title.addActionListener(e -> {
			UIManager.getInstance().changePanel("title");
		});
		exit.addActionListener(e -> {
			UIManager.getInstance().changePanel("exit");
		});
		add(game);
		add(title);
		add(exit);
	}

}
