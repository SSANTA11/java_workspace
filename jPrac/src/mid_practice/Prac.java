package mid_practice;
//

//import javax.swing.*;
//import java.awt.event.*;
//import java.awt.*;

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
//import javax.swing.*;
//import java.awt.event.*;
//import java.awt.*;
//
//public class Prac extends JFrame implements ActionListener{
//	private JTextField t;
//	JPanel p;
//	Prac(){
//		setTitle("키패드 만들기");
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		t=new JTextField(20);
//		add(t, BorderLayout.NORTH);
//		JPanel p = new JPanel();
//		p.setLayout(new GridLayout(3,3));
//		add(p, BorderLayout.CENTER);
//		for (int i=1; i<=9; i++) {			
//			JButton b=new JButton(""+i);
//			b.addActionListener(this);
//			b.setPreferredSize(new Dimension(100,100));
//			p.add(b);
//		}
//		pack();
//		setVisible(true);
//	}
//	@Override
//	public void actionPerformed(ActionEvent e) {
//		String actionCommand=e.getActionCommand();
//		t.setText(t.getText()+actionCommand);
//	}
//	public static void main(String [] args) {
//		new Prac();
//	}
//}

//import javax.swing.*;
//import java.awt.event.*;
//import java.awt.*;
//import java.util.*;
//
//public class Prac extends JFrame implements ActionListener {
//	static final int ROCK = 0, PAPER = 1, SCISSOR = 2;
//	private JButton rock, paper, scissor;
//	private JTextField t1, t2;
//
//	Prac() {
//		setTitle("가위 바위 보");
//		setSize(500, 300);
//		JPanel p = new JPanel();
//		p.setLayout(new GridLayout(0, 3));
//		t1=new JTextField("가위바위보 해보실까여!");
//		t2=new JTextField(20);
//		rock = new JButton("ROCK");
//		paper = new JButton("PAPER");
//		scissor = new JButton("SCISSOR");
//		ButtonGroup b= new ButtonGroup();
//		add(t1, BorderLayout.NORTH);
//		add(p);
//		rock.addActionListener(this);
//		p.add(rock);
//		paper.addActionListener(this);
//		p.add(paper);
//		scissor.addActionListener(this);
//		p.add(scissor);
//		add(t2, BorderLayout.SOUTH);
//		setVisible(true);
//	}
//	@Override
//	public void actionPerformed(ActionEvent e) {
//		Random r = new Random();
//		int hand = r.nextInt(3);
//		if (e.getSource()==rock) {
//			if (hand == ROCK) {
//				t2.setText("무승부");
//			} else if (hand == SCISSOR) {
//				t2.setText("승리");
//
//			} else {
//				t2.setText("패배");
//
//			}
//		} else if (e.getSource()==paper) {
//			if (hand == PAPER) {
//
//				t2.setText("무승부");
//			} else if (hand == SCISSOR) {
//
//				t2.setText("패배");
//
//			} else {
//
//				t2.setText("승리");
//			}
//		} else if (e.getSource()==scissor)  {
//			if (hand == SCISSOR) {
//
//				t2.setText("무승부");
//			} else if (hand == ROCK) {
//
//				t2.setText("패배");
//			} else {
//
//				t2.setText("승리");
//			}
//		}
//	}
//
//	public static void main(String[] args) {
//		new Prac();
//	}
//}
