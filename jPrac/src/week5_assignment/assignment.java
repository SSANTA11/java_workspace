package week5_assignment;

import javax.swing.*;
import java.awt.FlowLayout;
import java.awt.event.*;

public class assignment extends JFrame{
	private JTextField num1, num2;
	private JButton equal;
	private JLabel plus;
	private JLabel answer;
	public assignment() {
		setSize(1000,200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("HomeWork 1");
		setLayout(new FlowLayout());
		
		num1 = new JTextField(10);
		plus = new JLabel("+");
		num2 = new JTextField(10);
		equal= new JButton("=");
		answer=new JLabel("");
		this.add(num1);
		this.add(plus);
		this.add(num2);
		this.add(equal);
		this.add(answer);

		equal.addActionListener(new MyListener());
		
		setVisible(true);
	}
    private class MyListener implements ActionListener {	
    	@Override
        public void actionPerformed(ActionEvent e) {

        	String n1=num1.getText();
        	String n2=num2.getText();
        	int a= Integer.parseInt(n1);
        	int b= Integer.parseInt(n2);
        	
        	answer.setText(Integer.toString(a+b));        
    }

}
}