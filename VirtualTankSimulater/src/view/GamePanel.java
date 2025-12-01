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
import core.CameraViewLogic;

public class GamePanel extends JPanel {
	private JButton option;
	private BufferedImage tileIMG;
	private final int TILE_SIZE;
	private final int TILES;
	private Tank player;
	private CameraViewLogic camera;
	private double viewPortWorldX;
	private double viewPortWorldY;

	public GamePanel() {
		this.player = GameManager.getInstance().getPlayer();
		this.camera = CameraViewLogic.getInstance();

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

		double viewPortworldX = camera.viewPortworldX;
		double viewPortworldY = camera.viewPortworldY;

		int startTileX = Math.max(0, (int) viewPortworldX / TILE_SIZE);
		int startTileY = Math.max(0, (int) viewPortworldY / TILE_SIZE);
		int endTileX = Math.min(startTileX + (int) viewPortworldX / TILE_SIZE, TILES);
		int endTileY = Math.min(startTileY + (int) viewPortworldY / TILE_SIZE, TILES);

		for (int x = startTileX; x < endTileX; x++) {
			for (int y = startTileY; y < endTileY; y++) {
				int screenX = (int) (x * TILE_SIZE - viewPortworldX);
				int screenY = (int) (y * TILE_SIZE - viewPortworldY);
				g.drawImage(tileIMG, screenX, screenY, TILE_SIZE, TILE_SIZE, null);
			}
		}

		player.draw(g);
	}

}
