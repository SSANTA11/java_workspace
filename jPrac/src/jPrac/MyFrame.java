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
		setSize(1000,220);
		JLabel label1=new JLabel("+");

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


//인라인과 인라인 없는 것은 차이 C언어
//static C언어
//지역변수와 전역변수의 개념 C언어
//위 3가지는 복습 할 내용

// 일단 예제 들어가서 모르는것을 차근차근 검색해서 채워나가는 식으로 공부!
// 인터페이스 부모의 자식 업캐스팅은 가능하나