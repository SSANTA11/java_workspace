package view;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JPanel;

import core.GameManager;
import core.MapManager;
import core.UIManager;
import entities.Projectile;
import entities.Tank;
import core.CameraViewLogic;

public class GamePanel extends JPanel {
	private JButton option;
	private Tank player;
	private MapManager mapManager;

	public GamePanel() {
		this.mapManager= MapManager.getInstance();
		this.player = GameManager.getInstance().getPlayer();

		this.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				player.setTank(e.getKeyCode(), true);
			}

			@Override
			public void keyReleased(KeyEvent e) {
				player.setTank(e.getKeyCode(), false);

			}
		});

		this.option = new JButton("옵션");
		option.addActionListener(e -> {
			UIManager.getInstance().changePanel("ingameOption");
		});

		add(option);
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		mapManager.draw(g);
		player.draw(g);
		
	}

}
