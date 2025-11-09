package view;

import java.awt.CardLayout;

import javax.swing.*;
import javax.swing.SwingUtilities;

import core.GameManager;
<<<<<<< HEAD
import core.MapManager;
import entities.Player;

public class GameWindow extends JFrame {
	public static final int WIDTH = 2700;
	public static final int HEIGHT = 800;

	private final CardLayout cardLayout = new CardLayout();
	private final JPanel mainPanel = new JPanel(cardLayout);

	private TitlePanel titlePanel;
	private GamePanel gamePanel;
	private OptionPanel optionPanel;
=======

public class GameWindow extends JFrame {
	public static final int WIDTH = 1280;
	public static final int HEIGHT = 720;

	private final CardLayout cardLayout = new CardLayout();
	private final JPanel mainPanel = new JPanel(cardLayout);
    

	private TitlePanel titlePanel; 
	private GamePanel gamePanel; 
>>>>>>> f183d83cef6e891962a6f13ab6eff94f2df77719

	public GameWindow() {

		setSize(WIDTH, HEIGHT);
		setTitle("LocalShooting");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
<<<<<<< HEAD
		this.titlePanel = new TitlePanel();
		this.gamePanel = new GamePanel(new MapManager(),new Player());
		this.optionPanel = new OptionPanel();

		mainPanel.add(titlePanel, "TITLE");
		mainPanel.add(gamePanel, "GAME");
		mainPanel.add(optionPanel, "OPTION");

		add(mainPanel);
		setVisible(true);
	}

=======
		this.titlePanel = new TitlePanel(); 
		this.gamePanel = new GamePanel();
		
		mainPanel.add(titlePanel, "TITLE");
		mainPanel.add(gamePanel, "GAME");
		
		add(mainPanel);
		setVisible(true);
	}
 
    // ⭐ 메서드 이름 오타 수정
>>>>>>> f183d83cef6e891962a6f13ab6eff94f2df77719
	public void changePanel(String panel) {
		cardLayout.show(mainPanel, panel);
	}

	public static void main(String[] args) {
<<<<<<< HEAD
		GameWindow gameWindow = new GameWindow();
		GameManager.getInstance().initialize(gameWindow);
=======
			GameWindow gameWindow = new GameWindow();
			GameManager.getInstance().initialize(gameWindow);  
>>>>>>> f183d83cef6e891962a6f13ab6eff94f2df77719
	}
}