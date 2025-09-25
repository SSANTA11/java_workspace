package jPrac;
import javax.swing.*;
import java.awt.FlowLayout;
public class MyFrame extends JFrame {
//	JPanel p=new JPanel();
	JTextField jtext1= new JTextField(20);
	JTextField jtext2= new JTextField(20);
	JTextField jtext3= new JTextField(20);
	JButton e = new JButton("=");
	public MyFrame() {
		JLabel label1=new JLabel("+");
//		p.add(jtext1);
//		p.add(label1);
//		p.add(jtext2);
//		p.add(jtext3);
//		MyFrame.add(p);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("버튼연습장");
		setVisible(true);
		
		setLayout(new FlowLayout());// 화면에서 좌측부터 순서대로 배치한후 화면에 차면 다음 행으로 넘김
		this.add(jtext1);
		this.add(label1);
		this.add(jtext2);
		
		this.add(e);
		this.add(jtext3);
		
		setVisible(true);
		setResizable(true);
	}
	public static void main(String[] args) {
		 MyFrame f = new MyFrame();
		 
	}

}

// 인라인과 인라인 없는 것은 차이 C언어
// static C언어
// 지역변수와 전역변수의 개념 C언어
// 위 3가지는 복습 할 내용