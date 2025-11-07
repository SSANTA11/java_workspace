package view;

import java.awt.CardLayout;

import javax.swing.*;
import javax.swing.SwingUtilities;

import core.GameManager;

public class GameWindow extends JFrame {
	public static final int WIDTH = 1280;
	public static final int HEIGHT = 720;

	private final CardLayout cardLayout = new CardLayout();
	private final JPanel mainPanel = new JPanel(cardLayout);
    

	private TitlePanel titlePanel; 
	private GamePanel gamePanel; 

	public GameWindow() {

		setSize(WIDTH, HEIGHT);
		setTitle("LocalShooting");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.titlePanel = new TitlePanel(); 
		this.gamePanel = new GamePanel();
		
		mainPanel.add(titlePanel, "TITLE");
		mainPanel.add(gamePanel, "GAME");
		
		add(mainPanel);
		setVisible(true);
	}
 
    // ⭐ 메서드 이름 오타 수정
	public void changePanel(String panel) {
		cardLayout.show(mainPanel, panel);
	}

	public static void main(String[] args) {
			GameWindow gameWindow = new GameWindow();
			GameManager.getInstance().initialize(gameWindow);  
	}
}