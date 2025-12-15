package view;

import javax.swing.JButton;
import javax.swing.JPanel;

import core.GameLoop;
import core.UIManager;

public class IngameOptionPanel extends JPanel {
	private JButton game;
	private JButton exit;

	public IngameOptionPanel() {
		this.game = new JButton("게임으로 돌아가기");
		this.exit = new JButton("나가기");
		game.addActionListener(e -> {
			GameLoop.getInstance().startGameLoop();
			UIManager.getInstance().changePanel("game");

		});

		exit.addActionListener(e -> {
			UIManager.getInstance().changePanel("exit");
		});
		add(game);
		add(exit);
	}

}
