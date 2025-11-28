package view;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class GameWindow extends JFrame {

	public GameWindow(JPanel mainPanel) {
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setUndecorated(true);
		add(mainPanel);
		setVisible(true);
	}

}
