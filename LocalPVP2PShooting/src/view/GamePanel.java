package view;

import java.awt.Graphics;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.*;
import core.GameManager;
import core.MapManager;
import entities.Entity;
import entities.Player;
import entities.TankTop;

public class GamePanel extends JPanel implements ActionListener {
	private final ArrayList<Entity> allEntities = GameManager.getInstance().getList();
	private final GameManager manager = GameManager.getInstance();
	private final Player mainPlayer;
	private final Camera camera;
	private final TankTop tankTop;
	private JButton b2 = new JButton("옵션");

	public GamePanel() {
		add(b2);

		b2.addActionListener(e -> {
			Window gameWindow = SwingUtilities.getWindowAncestor(this);
			((GameWindow) gameWindow).changePanel("OPTION");
		});
		this.camera = manager.getCamera();
		this.mainPlayer = (Player) manager.getEntity(0);
		this.tankTop = mainPlayer.getTankTop();
		addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				mainPlayer.setMoving(e.getKeyCode(), true);
				tankTop.fireControl(e.getKeyCode());
			}

			@Override
			public void keyReleased(KeyEvent e) {
				mainPlayer.setMoving(e.getKeyCode(), false);
			}
		});

	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		int cameraWorldX = camera.getCameraWorldX();
		int cameraWorldY = camera.getCameraWorldY();
		int TILE_SIZE = MapManager.TILE_SIZE;

		int startTileXIndex = cameraWorldX / TILE_SIZE;
		int startTileYIndex = cameraWorldY / TILE_SIZE;
		int endTileXIndex = (cameraWorldX + this.getWidth()) / TILE_SIZE + 3;
		int endTileYIndex = (cameraWorldY + this.getHeight()) / TILE_SIZE + 3;

		startTileXIndex = Math.max(0, startTileXIndex);
		startTileYIndex = Math.max(0, startTileYIndex);
		endTileXIndex = Math.min(endTileXIndex, MapManager.WIDTH_TILES);
		endTileYIndex = Math.min(endTileYIndex, MapManager.HEIGHT_TILES);

		for (int y = startTileYIndex; y < endTileYIndex; y++) {
			for (int x = startTileXIndex; x < endTileXIndex; x++) {
				int screenX = (x * TILE_SIZE - cameraWorldX);
				int screenY = (y * TILE_SIZE - cameraWorldY);

				g.drawImage(MapManager.floorTileImage, screenX, screenY, MapManager.TILE_SIZE, MapManager.TILE_SIZE,
						null);
			}
		}

		for (int i = 0; i < allEntities.size(); i++) {
			Entity entity = allEntities.get(i);
			int screenX = entity.getWorldX() - cameraWorldX;
			int screenY = entity.getWorldY() - cameraWorldY;

			if (screenX > -100 && screenX < getWidth() + 100 && screenY > -100 && screenY < getHeight() + 100) {
				entity.draw(g, screenX, screenY);
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {

	}
}