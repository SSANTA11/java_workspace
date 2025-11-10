package view;

import java.awt.CardLayout;

import javax.swing.*;
import javax.swing.SwingUtilities;

import core.GameManager;
import core.MapManager;
//import entities.Player;

public class GameWindow extends JFrame {
	public static final int WIDTH = 1250;
	public static final int HEIGHT = 1250;

	private final CardLayout cardLayout = new CardLayout();
	private final JPanel mainPanel = new JPanel(cardLayout);

	private TitlePanel titlePanel;
	private GamePanel gamePanel;
	private OptionPanel optionPanel;

	public GameWindow() {

		setSize(WIDTH, HEIGHT);
		setTitle("LocalShooting");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.titlePanel = new TitlePanel();
		this.gamePanel = new GamePanel(new MapManager());
		this.optionPanel = new OptionPanel();

		mainPanel.add(titlePanel, "TITLE");
		mainPanel.add(gamePanel, "GAME");
		mainPanel.add(optionPanel, "OPTION");

		add(mainPanel);
		setVisible(true);
	}

	public void changePanel(String panel) {
		cardLayout.show(mainPanel, panel);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			GameWindow gameWindow = new GameWindow();
			GameManager.getInstance().initialize(gameWindow);
		});
	}
}