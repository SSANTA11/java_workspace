package view;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JPanel;

import core.GameManager;

public class OptionPanel extends JPanel{
	private JButton b=new JButton("타이틀로 돌아가기");
	private final GameManager manager = GameManager.getInstance() ;
	public OptionPanel() {
		add(b);
		setBackground(Color.BLACK);
		b.addActionListener(e->{
			manager.changePanel("TITLE");
		});
	}

}
