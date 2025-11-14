package view;

import java.awt.CardLayout;

import javax.swing.*;
import javax.swing.SwingUtilities;

import core.GameManager;
import core.GameLoop;

public class GameWindow extends JFrame {
	public static final int WIDTH = 1250;
	public static final int HEIGHT = 1250;

	private final CardLayout cardLayout = new CardLayout();
	private final JPanel mainPanel = new JPanel(cardLayout);

	private TitlePanel titlePanel;
	private GamePanel gamePanel;
	private OptionPanel optionPanel;

	public GameWindow(TitlePanel t, GamePanel g, OptionPanel o) {
		setSize(WIDTH, HEIGHT);
		setTitle("LocalShooting");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.titlePanel = t;
		this.gamePanel = g;
		this.optionPanel = o;

		mainPanel.add(titlePanel, "TITLE");
		mainPanel.add(gamePanel, "GAME");
		mainPanel.add(optionPanel, "OPTION");

		add(mainPanel);

		setVisible(true);

	}

	public void changePanel(String panelName) {
		cardLayout.show(mainPanel, panelName);

		if ("GAME".equals(panelName)) {
			SwingUtilities.invokeLater(() -> {
		        setFocusable(true); 
				gamePanel.requestFocusInWindow();
				System.out.println("디버그 메세지: GamePanel에 포커스 요청 완료.");
			});
		}
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			GameManager manager = GameManager.getInstance();
			manager.initialize();

			TitlePanel titlePanel = new TitlePanel();
			GamePanel gamePanel = new GamePanel();
			OptionPanel optionPanel = new OptionPanel();

			GameWindow gameWindow = new GameWindow(titlePanel, gamePanel, optionPanel);

			new Thread(new GameLoop(manager, gameWindow.gamePanel)).start();
		});
	}
}