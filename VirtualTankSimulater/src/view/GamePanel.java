package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

import javax.swing.JButton;
import javax.swing.JPanel;

import core.GameManager;
import core.MapManager;
import core.SourceManager;
import core.TankController;
import core.UIManager;

public class GamePanel extends JPanel {
	private JButton option;
	private BufferedImage tileIMG;
	private final int TILE_SIZE;
	private final int TILES;
	private TankController tankController = TankController.getInstance();

	public GamePanel() {
		addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				tankController.setTank(e.getKeyCode(), true);
			}

			@Override
			public void keyReleased(KeyEvent e) {
				tankController.setTank(e.getKeyCode(), false);

			}
		});
		this.tileIMG = SourceManager.getInstance().getIMGSource("tile");
		this.TILE_SIZE = MapManager.getInstance().getTileSize();
		this.TILES = MapManager.getInstance().getTiles();
		this.option = new JButton("옵션");
		setLayout(new BorderLayout());
		option.addActionListener(e -> {
			UIManager.getInstance().changePanel("ingameOption");
		});
		add(option, BorderLayout.NORTH);
		repaint();

	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		for (int x = 0; x < TILES; x++) {
			for (int y = 0; y < TILES; y++) {
				char word =MapManager.getInstance().getTile(x, y);
				switch(word) {
				case 'w':
					g.drawImage(tileIMG, x * TILE_SIZE, y * TILE_SIZE, TILE_SIZE, TILE_SIZE, null);
					break;					
				}
			}
		}
		GameManager.getInstance().getTank().draw(g);
	}

}
