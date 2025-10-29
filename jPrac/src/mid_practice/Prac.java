package mid_practice;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

// 1단계 연습문제 JFrame과 JPanel

//import javax.swing.*;
//
//public class Prac extends JFrame{
//	Prac(){
//		setTitle("기본 GUI 연습");
//		setSize(300,100);
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		JPanel p = new JPanel();
//		JLabel jL= new JLabel();
//		JTextField jF=new JTextField(10);
//		p.add(jF);
//		JButton jB=new JButton("입력");
//		p.add(jB);
//		add(p);
//		setVisible(true);
//	}
//	
//	
//	public static void main(String[]arr) {
//		Prac p =new Prac();
//	}
//}
//------------------------------------------------------------------------------------------------------------------------------------

//2단계 이벤트 처리와 상태변경

//class Prac extends JFrame{
//	private int count=0;
//	JLabel l;
//	JButton b;
//	Prac(){
//		JPanel p=new JPanel();
//		setSize(300,100);
//		setTitle("기본 GUI 연습");
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		JTextField tF= new JTextField(10);
//		b=new JButton("입력");
//		l =new JLabel("클릭횟수:0");
//		p.add(tF);
////		b.addActionListener(e->{
////			l.setText("클릭횟수:"+Integer.toString(count++));
////		});
//		b.addActionListener(new MyListener());
//		p.add(b);
//		p.add(l);
//		add(p);
//		setVisible(true);
//	}
//	private class MyListener implements ActionListener{
//		@Override
//		public void actionPerformed(ActionEvent e) {
//			l.setText("클릭횟수:"+Integer.toString(count++));
//		}
//	}
//		
//	public static void main(String []args) {
//		Prac p =new Prac();
//	}
//}
//------------------------------------------------------------------------------------------------------------------------------------

//3단계: 복합 레이아웃 및 입력 값 처리

//class Prac extends JFrame{
//	private JPanel p;
//	private JLabel l;
//	private JButton b;
//	private JTextField n1;
//	private JTextField n2;
//	Prac(){
//		setSize(300,100);
//		setTitle("기본 GUI 연습");
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		n1=new JTextField(10);
//		n2=new JTextField(10);
//		p=new JPanel();
//		l=new JLabel("");
//		b= new JButton("+");
//
//		setLayout(new BorderLayout());
//		
//		
//		add(p, BorderLayout.CENTER);
//		add(l, BorderLayout.NORTH);
//		p.add(n1);
//		b.addActionListener(new MyListener());
//		p.add(b);
//		p.add(n2);
//		setVisible(true);
//	}
//	private class MyListener implements ActionListener{
//		@Override
//		public void actionPerformed(ActionEvent e) {
//			try {				
//			int a=Integer.parseInt(n1.getText());
//			int b=Integer.parseInt(n2.getText());
//			int n=a+b;
//			l.setText("결과: "+Integer.toString(n));
//			}catch(NumberFormatException err){
//				l.setText("올바른 숫자를 입력하세요");
//			}
//		}		
//	}
//	public static void main(String[]args) {
//		Prac p = new Prac();
//	}
//}
//------------------------------------------------------------------------------------------------------------------------------------

//4단계 라디오 버튼

//class Prac extends JFrame implements ActionListener {
//	private JPanel p;
//	private JLabel l;
//	private JRadioButton b1;
//	private JRadioButton b2;
//	private JTextField n1;
//	private JTextField n2;
//
//	Prac() {
//		setSize(300, 100);
//		setTitle("기본 GUI 연습");
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		n1 = new JTextField(10);
//		n2 = new JTextField(10);
//		p = new JPanel();
//		l = new JLabel("");
//		b1 = new JRadioButton("+");
//		b2 = new JRadioButton("-");
//		ButtonGroup b = new ButtonGroup();
//		b.add(b1);
//		b.add(b2);
//		setLayout(new BorderLayout());
//
//		add(p, BorderLayout.CENTER);
//		add(l, BorderLayout.NORTH);
//		p.add(n1);
//		b1.addActionListener(this);
//		b2.addActionListener(this);
//		p.add(b1);
//		p.add(b2);
//		p.add(n2);
//		setVisible(true);
//	}
//
//	@Override
//	public void actionPerformed(ActionEvent e) {
//		try {
//			if (b1.isSelected()) {
//				int a = Integer.parseInt(n1.getText());
//				int b = Integer.parseInt(n2.getText());
//				int n = a + b;
//				l.setText("결과: " + Integer.toString(n));
//			} else if (b2.isSelected()) {
//				int a = Integer.parseInt(n1.getText());
//				int b = Integer.parseInt(n2.getText());
//				int n = a - b;
//				l.setText("결과: " + Integer.toString(n));
//
//			}
//		} catch (NumberFormatException err) {
//			l.setText("올바른 숫자를 입력하세요");
//		}
//	}
//
//	public static void main(String[] args) {
//		Prac p = new Prac();
//	}
//}