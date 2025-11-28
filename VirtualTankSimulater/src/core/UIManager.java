package core;

import java.awt.CardLayout;

import javax.swing.JPanel;

import view.GamePanel;
import view.GameWindow;
import view.IngameOption;
import view.Title;
import view.TitleOption;

public class UIManager {
	private static UIManager UI;
	private GameWindow gw;
	private Title title = Title.getInstance();
	private TitleOption titleOption = TitleOption.getInstance();
	private IngameOption ingameOption = IngameOption.getInstance();
	private GamePanel game = new GamePanel();
	private JPanel p;
	private CardLayout cardLayout;

	private UIManager() {
		p = new JPanel();
		cardLayout = new CardLayout();
		makeMainPanel();
	}

	public static UIManager getInstance() {
		if (UI == null) {
			UI = new UIManager();
		}
		return UI;
	}

	public void makeMainPanel() {
		p.setLayout(cardLayout);
		p.add(title, "title");
		p.add(titleOption, "titleOption");
		p.add(ingameOption, "ingameOption");
		p.add(game, "game");
	}

	public JPanel getMainPanel() {
		return p;
	}

	public void insertWindow(GameWindow gw) {
		this.gw = gw;
	}

	public void changePanel(String panel) {
		switch (panel) {
		case "game":
			cardLayout.show(p, "game");
			break;
		case "titleOption":
			cardLayout.show(p, "titleOption");
			break;
		case "ingameOption":
			cardLayout.show(p, "ingameOption");
			break;
		case "title":
			cardLayout.show(p, "title");
			break;
		case "exit":
			System.exit(0);
			break;

		}
	}

	public GameWindow getWindow() {
		return gw;
	}

}
