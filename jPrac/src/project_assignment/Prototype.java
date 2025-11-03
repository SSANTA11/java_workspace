package project_assignment;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
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
			img=ImageIO.read(new File("earth.jpg"));
		}catch(IOException e) {
			System.out.println("No IMG");
			System.exit(1);
		}
		addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				int keycode = e.getKeyCode();
				switch (keycode) {
				case KeyEvent.VK_UP:
					img_y-=10;
					break;
				case KeyEvent.VK_DOWN:
					img_y+=10;
					break;
				case KeyEvent.VK_RIGHT:
					img_x+=10;
					break;
				case KeyEvent.VK_LEFT:
					img_x-=10;
					break;
				}
				repaint();
			}
		});
		this.requestFocus();
		setFocusable(true);
		
		setSize(500,800);
		setTitle("미정");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		MP mp =new MP();
		add(mp);
		b.addActionListener(this);
		setVisible(true);
	}
		
	public void paintComponent(Graphics g) {
		super.paintComponents(g);
		g.drawImage(img, img_x, img_y, null);
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
