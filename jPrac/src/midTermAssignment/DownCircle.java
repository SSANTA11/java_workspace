package midTermAssignment;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.Timer;

import javax.swing.JFrame;
import javax.swing.JPanel;


class DownCircle extends JFrame {
	DownCircle() {
		setSize(400, 500);
		setTitle("4번문제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Panel p = new Panel();
		add(p);
		setVisible(true);
	}
	class Panel extends JPanel {
		int x = 200;
		int y = 10;
		Panel() {
			addKeyListener(new KeyAdapter() {
				@Override
				public void keyPressed(KeyEvent e) {
					int keyCode = e.getKeyCode();
					switch (keyCode) {
					case KeyEvent.VK_UP:
						y -= 20;
						repaint();
						break;
					case KeyEvent.VK_DOWN:
						y += 20;
						repaint();
						break;
					case KeyEvent.VK_RIGHT:
						x += 20;
						repaint();
						break;
					case KeyEvent.VK_LEFT:
						x -= 20;
						repaint();
						break;
					case KeyEvent.VK_SPACE:
						Timer t = new Timer(10, event -> {
							y += 3;
							if (y > 500) {
								x = 200;
								y = 10;
							}
							repaint();
						});
						t.start();
					}
				}
			});
			setFocusable(true);
			requestFocusInWindow();
		}
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.setColor(Color.black);
			g.fillOval(x, y, 10, 10);
		}
	}
	public static void main(String[] args) {
		new DownCircle();
	}
}

