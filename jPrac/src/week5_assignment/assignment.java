package week5_assignment;

import javax.swing.*;
import java.awt.FlowLayout;
import java.awt.event.*;

public class assignment extends JFrame{
	private JTextField num1, num2;
	private JButton equal;
	private JLabel plus;
	private JLabel answer;
	private int num;
	public assignment() {
		setSize(1000,200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("HomeWork 1");
		setLayout(new FlowLayout());
		
		plus=new JLabel(Integer.toString(num));
		num1 = new JTextField(10);
		num2 = new JTextField(10);
		plus = new JLabel("+");
		answer=new JLabel("");
		this.add(num1);
		this.add(plus);
		this.add(num2);
		this.add(equal);
		this.add(answer);
		setVisible(true);
		setResizable(true);
	}
//    private class MyListener implements ActionListener {
//        public void actionPerformed(ActionEvent e) {
//            if (e.getSource() == button1) {
//           	 number+=1;
//            }
//            else {
//           	 number-=1;
//            }
//            label.setText(Integer.toString(number));            	 
//        }
//    }

}
