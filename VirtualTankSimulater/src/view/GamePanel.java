package view;

import java.awt.BorderLayout;
import java.awt.Graphics;

import javax.swing.JButton;
import javax.swing.JPanel;

import core.UIManager;

public class GamePanel extends JPanel {
	private JButton option;

	public GamePanel() {
		this.option = new JButton("옵션");
		setLayout(new BorderLayout());
		option.addActionListener(e -> {
			UIManager.getInstance().changePanel("ingameOption");
		});

		add(option, BorderLayout.SOUTH);
	}
	@Override
	public void paintComponents(Graphics g) {
		super.paintComponents(g);
		g.draw3DRect(111, 111, 111, 111, true);
	}
}
