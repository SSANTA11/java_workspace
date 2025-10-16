package week5_assignment;

import javax.swing.*;
import java.awt.FlowLayout;
import java.awt.event.*;

public class assignment extends JFrame {
	private JTextField num1, num2;
	private JButton equal;
	private JRadioButton p, m;
	private JLabel answer;
	
	public class PMpanel extends JPanel {
		public PMpanel() {
			p = new JRadioButton("+");
			m = new JRadioButton("-");
			ButtonGroup group = new ButtonGroup();
			group.add(p);
			group.add(m);
			this.add(p);
			this.add(m);
		}
	}

	public assignment() {
		setSize(500, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("HomeWork 1");
		setLayout(new FlowLayout());
		num1 = new JTextField(10);
		PMpanel radio = new PMpanel();
		num2 = new JTextField(10);
		equal = new JButton("=");
		answer = new JLabel("");
		this.add(num1);
		this.add(radio);
		this.add(num2);
		this.add(equal);
		this.add(answer);

		equal.addActionListener(new MyListener()); //jvm에게 요구!

		setVisible(true);
	}

	private class MyListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String n1 = num1.getText();
			String n2 = num2.getText();
			int a = Integer.parseInt(n1);
			int b = Integer.parseInt(n2);
			if (p.isSelected())
				answer.setText(Integer.toString(a + b));
			else if (m.isSelected())
				answer.setText(Integer.toString(a - b));
		}

	}
}