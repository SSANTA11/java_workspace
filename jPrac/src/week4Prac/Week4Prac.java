package week4Prac;
import javax.swing.*;
import java.awt.FlowLayout;
public class Week4Prac extends JFrame{
	public Week4Prac() {
		setSize(1000,200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("MyFrame");
		
		setLayout(new FlowLayout());
		JButton button = new JButton("버튼");
		this.add(button);
		setVisible(true);
		
	}
	public static void main(String[]args) {
		Week4Prac a = new Week4Prac(); 
	}
}
