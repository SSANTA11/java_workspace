package view;

import java.awt.Color;
import java.awt.Window;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;


public class OptionPanel extends JPanel{
	private JButton b1=new JButton("타이틀로 돌아가기");
	private JButton b2=new JButton("돌아가기");
	private JButton b3=new JButton("게임 종료");
    
	public OptionPanel() {
		add(b1);
		add(b2);
		add(b3);
	
		b1.addActionListener(e->{
			Window window = SwingUtilities.getWindowAncestor(this);
			if (window instanceof GameWindow) {
				((GameWindow) window).changePanel("TITLE");
			}
		});
		b2.addActionListener(e->{
			Window window = SwingUtilities.getWindowAncestor(this);
			if (window instanceof GameWindow) {
				((GameWindow) window).changePanel("GAME");
			}
		});
		b3.addActionListener(e -> {
			System.exit(0);
		});
	}

	
}