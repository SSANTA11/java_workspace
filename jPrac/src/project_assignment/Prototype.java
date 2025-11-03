package project_assignment;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.EventListener;

import javax.imageio.ImageIO;
import javax.swing.*;

public class Prototype extends JFrame implements ActionListener{
	JButton b;
	JLabel f;
	BufferedImage img =null;
	int img_x=100;
	int img_y=100;
	
	Prototype(){
		try {
			img=ImageIO.read(new File(""));
		}catch(IOException e) {
			System.out.println("No IMG");
		}
		
		setSize(500,800);
		setTitle("미정");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		MP mp =new MP();
		add(mp);
		b.addActionListener(this);
		setVisible(true);
		
		}

	class MP extends JPanel{ // MotherPanel==MP
		MP(){
			setLayout(new BorderLayout());;
			setBackground(Color.BLACK);
			
			f =new JLabel("dd");
			b=new JButton("push!");
			add(b, BorderLayout.EAST);
			add(f,BorderLayout.SOUTH);
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		f.setText(f.getText()+"ss");
	}
	public static void main(String[] args) {
		new Prototype();
	}

}
