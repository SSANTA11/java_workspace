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
import entities.Tank;

public class GamePanel extends JPanel {
	private JButton option;
	private BufferedImage tileIMG;
	private final int TILE_SIZE;
	private final int TILES;
	private Tank tank;
	private Tank player;

	public GamePanel() {
		this.tank = GameManager.getInstance().getPlayer();
		this.player = GameManager.getInstance().getPlayer();
		addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				tank.setTank(e.getKeyCode(), true);
			}

			@Override
			public void keyReleased(KeyEvent e) {
				tank.setTank(e.getKeyCode(), false);

			}
		});

		try {
			tileIMG = ImageIO.read(getClass().getResource("/floor.png"));
		} catch (IOException e) {
			System.err.println("img 오류");
		}
		this.TILE_SIZE = MapManager.TILE_SIZE;
		this.TILES = MapManager.TILES;
		this.option = new JButton("옵션");
		option.addActionListener(e -> {
			UIManager.getInstance().changePanel("ingameOption");
		});

		add(option);
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		for (int x = 0; x < TILES; x++) {
			for (int y = 0; y < TILES; y++) {
				char word = MapManager.getInstance().getTile(x, y);
				switch (word) {
				case 'w':
					g.drawImage(tileIMG, x * TILE_SIZE, y * TILE_SIZE, TILE_SIZE, TILE_SIZE, null);
					break;
				}
			}
		}
		player.draw(g);
	}

}
