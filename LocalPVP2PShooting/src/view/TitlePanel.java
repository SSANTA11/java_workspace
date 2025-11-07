package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.concurrent.Flow;

import javax.swing.*;

import core.GameManager;

public class TitlePanel extends JPanel {

	private final GameManager manager = GameManager.getInstance();

	JButton b1 = new JButton("게임 시작");
	JButton b2 = new JButton("옵션");
	JButton b3 = new JButton("나가기");
	JPanel p = new JPanel();
	JPanel p1 = new JPanel(new BorderLayout());

	public TitlePanel() {
		setLayout(new BorderLayout());
		JLabel title = new JLabel("LOCAL SHOOOTING");
		title.setHorizontalAlignment(SwingConstants.CENTER);
		p1.add(title);
		add(p1, BorderLayout.CENTER);
		p.add(b1);
		p.add(b2);
		p.add(b3);
		add(p, BorderLayout.SOUTH);
		b1.addActionListener(e -> {
			manager.changePanel("GAME");
		});

		b2.addActionListener(e -> {
			manager.changePanel("OPTION");
		});

		b3.addActionListener(e -> {
			System.exit(0);
		});
	};
}