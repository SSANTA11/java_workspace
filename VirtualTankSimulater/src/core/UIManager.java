package core;

import java.awt.CardLayout;

import javax.swing.JPanel;

import view.GamePanel;
import view.GameWindow;
import view.IngameOptionPanel;
import view.TitlePanel;
import view.TitleOptionPanel;

public class UIManager {
	private static UIManager uiManager;
	private GameWindow gameWindow;
	private TitlePanel title = TitlePanel.getInstance();
	private TitleOptionPanel titleOption = TitleOptionPanel.getInstance();
	private IngameOptionPanel ingameOption = IngameOptionPanel.getInstance();
	private GamePanel gamePanel = new GamePanel();
	private JPanel mainPanel;
	private CardLayout cardLayout;

	private UIManager() {
		mainPanel = new JPanel();
		cardLayout = new CardLayout();
		makeMainPanel();
	}

	public static UIManager getInstance() {
		if (uiManager == null) {
			uiManager = new UIManager();
		}
		return uiManager;
	}

	public void makeMainPanel() {
		mainPanel.setLayout(cardLayout);
		mainPanel.add(title, "title");
		mainPanel.add(titleOption, "titleOption");
		mainPanel.add(ingameOption, "ingameOption");
		mainPanel.add(gamePanel, "game");
	}

	public JPanel getMainPanel() {
		return mainPanel;
	}

	public void insertWindow(GameWindow gameWindow) {
		this.gameWindow = gameWindow;
	}

	public void changePanel(String panel) {
		switch (panel) {
		case "game":
			cardLayout.show(mainPanel, "game");
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
	public GameWindow getWindow(){
		return gameWindow;
	}

	public double getWindowWidth() {
		return gameWindow.getWidth();
	}

	public double getWindowHeight() {
		return gameWindow.getHeight();
	}

}
