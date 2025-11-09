package view;

import javax.swing.JDialog;

import core.GameManager;

public class Option extends JDialog{
	private final GameManager manager = GameManager.getInstance() ;
	public Option() {
		setSize(300,150);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setVisible(true);
	}

}
