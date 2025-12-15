package view;

import javax.swing.JButton;
import javax.swing.JPanel;

import core.UIManager;

public class TitleOptionPanel extends JPanel {
	private JButton game, title;

	public TitleOptionPanel() {
		this.title = new JButton("타이틀로 돌아가기");
		title.addActionListener(e -> { 
			UIManager.getInstance().changePanel("title");
		});

		add(title);
	}

}
