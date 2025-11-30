package core;

import java.awt.CardLayout;

import javax.swing.JPanel;

import view.GamePanel;
import view.GameWindow;
import view.IngameOptionPanel;
import view.TitlePanel;
import view.TitleOptionPanel;

public class UIManager {
	private static UIManager uiManager = new UIManager();
	private GameWindow gameWindow;
	private TitlePanel title;
	private TitleOptionPanel titleOption;
	private IngameOptionPanel ingameOption;
	private GamePanel gamePanel;
	private JPanel mainPanel;
	private CardLayout cardLayout;

	private UIManager() {
		mainPanel = new JPanel();
		cardLayout = new CardLayout();
		title = TitlePanel.getInstance();
		gamePanel = new GamePanel();
		titleOption = new TitleOptionPanel();
		ingameOption=new IngameOptionPanel();
		makeMainPanel();
	}

	public static UIManager getInstance() {

		return uiManager;
	}

	public void makeMainPanel() {
		mainPanel.setLayout(cardLayout);
		mainPanel.add(title, "title");
		mainPanel.add(titleOption, "titleOption");
		mainPanel.add(gamePanel, "game");
		mainPanel.add(ingameOption, "ingameOption");
	}

	public JPanel getMainPanel() {
		return mainPanel;
	}

	public GamePanel getGamePanel() {
		return gamePanel;
	}

	public void insertWindow(GameWindow gameWindow) {
		this.gameWindow = gameWindow;
	}

	public void changePanel(String panel) {
		switch (panel) {
		case "game":
			cardLayout.show(mainPanel, "game");
			gamePanel.setFocusable(true);
			gamePanel.requestFocusInWindow();
			break;
		case "titleOption":
			cardLayout.show(mainPanel, "titleOption");
			break;
		case "ingameOption":
			cardLayout.show(mainPanel, "ingameOption");
			break;
		case "title":
			cardLayout.show(mainPanel, "title");
			break;
		case "exit":
			System.exit(0);
			break;

		}
	}

	public GameWindow getWindow() {
		return gameWindow;
	}

	public double getWindowWidth() {
		return gameWindow.getWidth();
	}

	public double getWindowHeight() {
		return gameWindow.getHeight();
	}

}
