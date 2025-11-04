package project_assignment;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;

import javax.swing.*;
import javax.imageio.*;

public class P extends JFrame implements ActionListener {
	BufferedImage img = null;
	int img_x = 100;
	int img_y = 100;

	JButton b = new JButton();
	JLabel l=new JLabel();

	private final MP mp;

	class MP extends JPanel {
		MP() {
			setLayout(new BorderLayout());
			setBackground(Color.LIGHT_GRAY);

			add(b, BorderLayout.EAST);

			l.setForeground(Color.GREEN);
			l.setHorizontalAlignment(SwingConstants.CENTER);
			add(l, BorderLayout.SOUTH);
		}

		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);

			if (img != null) {
				g.drawImage(img, img_x, img_y, null);
			}
		}
	}

	P() {
		try {
			img = ImageIO.read(new File("earth.jpg"));
		} catch (IOException e) {
			System.out.println("No IMG: 'earth.jpg' 파일을 찾을 수 없습니다.");
			System.exit(1);
		}

		
		mp = new MP();
		add(mp);

		b.addActionListener(this);
		addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
			}

			@Override
			public void keyReleased(KeyEvent e) {
			}

			@Override
			public void keyPressed(KeyEvent e) {
				int keycode = e.getKeyCode();
				switch (keycode) {
				case KeyEvent.VK_UP:
					img_y -= 10;
					break;

				case KeyEvent.VK_DOWN:
					img_y += 10;
					break;

				case KeyEvent.VK_RIGHT:
					img_x += 10;
					break;

				case KeyEvent.VK_LEFT:
					img_x -= 10;
					break;

				}
				mp.repaint();
			}
		});
		this.requestFocusInWindow();
		setFocusable(true);
		
		setSize(500,800);
		setTitle("각 관계성 이해위한 복습");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		if (l!=null) {
			l.setText(l.getText()+"ss");
		}
	}

	public static void main(String[] args) {
		new P();
	}
}
