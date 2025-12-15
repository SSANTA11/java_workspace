package view;

import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.concurrent.CopyOnWriteArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;

import core.GameLoop;
import core.GameManager;
import core.MapManager;
import core.UIManager;
import entities.Entity;
import entities.Tank;

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
			GameLoop.getInstance().stopGameLoop();
			UIManager.getInstance().changePanel("ingameOption");
		});

		add(option);
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		mapManager.draw(g);
		CopyOnWriteArrayList<Entity> entities = GameManager.getInstance().getEntities();
		for (Entity e : entities) {
			e.draw(g);
		}
	}
}
