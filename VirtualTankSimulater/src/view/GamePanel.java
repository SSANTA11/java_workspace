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
	private JButton option1;
	private JButton option2;
	private Tank player;
	private MapManager mapManager;

	public GamePanel() {
		this.mapManager = MapManager.getInstance();
		this.player = GameManager.getInstance().getPlayer();

		this.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				player.setTank(e.getKeyCode(), true);
				option1.setFocusable(false);
				option2.setFocusable(false);
			}

			@Override
			public void keyReleased(KeyEvent e) {
				player.setTank(e.getKeyCode(), false);
				option1.setFocusable(false);
				option2.setFocusable(false);

			}
		});

		this.option1 = new JButton("일시 정지");
		option1.addActionListener(e -> {
			GameLoop.getInstance().stopGameLoop();

		});
		this.option2 = new JButton("시작");
		option2.addActionListener(e -> {
			GameLoop.getInstance().startGameLoop();
		});

		add(option1);
		add(option2);
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
