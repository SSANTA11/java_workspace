package view;

import java.awt.CardLayout;

import javax.swing.*;

import core.GameManager;

public class GamePanel extends JPanel {
	JButton play;
	GamePanel() {
		play = new JButton("게임 플레이!");
		play.addActionListener(e -> {
//			GameManager.changePanel("TITLE");
		});
		this.add(play);
	}
}
