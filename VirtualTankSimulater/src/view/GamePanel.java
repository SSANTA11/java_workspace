package view;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;

import core.GameManager;
import core.MapManager;
import core.UIManager;
import entities.Projectile;
import entities.Tank;
import entities.Wall;

public class GamePanel extends JPanel {
	private JButton option;
	private Tank player;
	private MapManager mapManager;

	public GamePanel() {
		this.mapManager = MapManager.getInstance();
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
		ArrayList<Projectile> projectiles = GameManager.getInstance().getProjectiles();
		for (Projectile e : projectiles) {
			e.draw(g);
		}
		ArrayList<Wall> walls = GameManager.getInstance().getWalls();
		for (Wall e : walls) {
			e.draw(g);
		}

	}
}
