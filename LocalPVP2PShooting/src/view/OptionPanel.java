package view;

import java.awt.Color;
import java.awt.Window;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;


public class OptionPanel extends JPanel{
	private JButton b=new JButton("타이틀로 돌아가기");
    
	public OptionPanel() {
		add(b);
		setBackground(Color.BLACK);
        
		b.addActionListener(e->{
			// 
			Window window = SwingUtilities.getWindowAncestor(this);
			if (window instanceof GameWindow) {
				((GameWindow) window).changePanel("TITLE");
			}
		});
	}

}