package midTermAssignment;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


class Test1 extends JFrame implements ActionListener {
	JPanel mainP = new JPanel(new BorderLayout());
	JLabel l = new JLabel("");
	int FLAG = 0;
	String N1="";
	String N2="";
	JPanel p = new JPanel();
	JButton b1 = new JButton("0");
	JButton b2 = new JButton("1");
	JButton b3 = new JButton("2");
	JButton b4 = new JButton("+");
	JButton b5 = new JButton("=");
	Test1() {
		setSize(600, 300);
		setTitle("1번 문제 : 3진수 계산기");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		add(mainP);
		p.add(b1);
		b1.addActionListener(this);
		p.add(b2);
		b2.addActionListener(this);
		p.add(b3);
		b3.addActionListener(this);
		p.add(b4);
		b4.addActionListener(this);
		p.add(b5);
		b5.addActionListener(this);
		mainP.add(l, BorderLayout.NORTH);
		mainP.add(p, BorderLayout.CENTER);
		setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == b1) {
			l.setText(l.getText() + "0");
			if (FLAG == 0) {
				N1 += "0";
			} else {
				N2 += "0";
			}
		} else if (e.getSource() == b2) {
			l.setText(l.getText() + "1");
			if (FLAG == 0) {
				N1 += "1";
			} else {
				N2 += "1";
			}
		} else if (e.getSource() == b3) {
			l.setText(l.getText() + "2");
			if (FLAG == 0) {
				N1 += "2";
			} else {
				N2 += "2";
			}
		} else if (e.getSource() == b4) {
			if (FLAG == 0) {
				l.setText(l.getText() + " + ");
				FLAG = 1;
				System.out.println(N1);
			}
		} else {
			int a = Integer.parseInt(N1, 3) + Integer.parseInt(N2, 3);
			l.setText(l.getText() +"="+Integer.toString(a, 3));
			FLAG=0;
		}
	}
	public static void main(String[] args) {
		new Test1();
	}
}
