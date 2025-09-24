package jPrac;
import javax.swing.*;
import java.awt.FlowLayout;
public class MyFrame extends JFrame {
	public MyFrame() {
		setSize(300,200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("버튼연습장");
		setVisible(true);
		
		setLayout(new FlowLayout());
		JButton button=new  JButton("버튼");
		this.add(button);
		setVisible(true);
		setResizable(true);
	}
	public static void main(String[] args) {
		 MyFrame f = new MyFrame();
		 
	}

}
//...