package week7;
//
//import java.awt.Color;
//import java.awt.Graphics;
//import java.awt.event.MouseAdapter;
//import java.awt.event.MouseEvent;
//
//import javax.swing.BorderFactory;
//import javax.swing.JFrame;
//import javax.swing.JPanel;

//public class W7 extends JFrame{
//	public W7() {
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setSize(500,200);
//		setTitle("상자 그리기");
//		this.add(new MyPanel());
//		setVisible(true);
//	}
//	public class MyPanel extends JPanel{
//		private int squareX=50;
//		private int squareY=50;
//		private int squareW=20;
//		private int squareH=20;
//		public MyPanel() {
//			setBorder(BorderFactory.createLineBorder(Color.BLACK));
//			addMouseListener(new MouseAdapter() {
//				public void mousePressed(MouseEvent e) {
//					moveSquare(e.getX(),e.getY());
//				}
//
//			});
//			addMouseMotionListener(new MouseAdapter() {
//				public void mouseDragged(MouseEvent e) {
//					moveSquare(e.getX(),e.getY());
//				}
//			
//			});
//		}
//		private void moveSquare(int x, int y) {
//			int OFFSET=1;
//			if((squareX != x)||(squareY != y)) {
//				repaint(squareX,squareY,squareW+OFFSET,squareH+OFFSET);
//				squareX=x;
//				squareY=y;
//				repaint(squareX,squareY,squareW+OFFSET,squareH+OFFSET);
//			}
//		}
//	}
//	protected void paintComponent(Graphics g) {
//		super.paintComponents(g);
//		g.drawString("마우스를 클릭하면 사각형이 그려집니다.", 10, 20);
//		g.setColor(Color.red);
//		g.fillRect(squareX,squareY,squareW,squareH);
//		g.setColor(Color.black);
//		g.drawRect(squareX,squareY,squareW,squareH);
//		
//		
//	}
//}
// 집가서 제미나이 내용으로 수정하기












// 486pg 전공서적
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// 신호등의 상태를 나타내는 변수 (W7에 있었으나 MyPanel에서 사용되므로 MyPanel로 이동)
// light_number = 0; // 초기값은 MyPanel 내부 필드에서 설정

//public class W7 extends JFrame {
//
//    public W7() {
//
//        add(new MyPanel());
//        setSize(300, 500);
//        setVisible(true);
//
//    }
//
//    public static void main(String[] arg) {
//        new W7();
//    }
//
//public class MyPanel extends JPanel implements ActionListener {
//
//    boolean flag = false;
//    private int light_number = 0; // 0=빨강, 1=초록, 2=노랑
//    public MyPanel() {
//        setLayout(new BorderLayout());
//        JButton b = new JButton("traffic light turn on");
//        b.addActionListener(this);
//        add(b, BorderLayout.SOUTH);
//    }
//
//    @Override
//
//    protected void paintComponent(Graphics g) {
//        super.paintComponent(g);
//        g.setColor(Color.BLACK);
//        // 세 개의 신호등 틀을 그립니다.
//        g.drawOval(100, 100, 100, 100);
//        g.drawOval(100, 200, 100, 100);
//        g.drawOval(100, 300, 100, 100);
//
//        // light_number 값에 따라 해당 위치의 원을 채웁니다.
//        if (light_number == 0) {
//            // 빨간불 (맨 위)
//            g.setColor(Color.RED);
//            g.fillOval(100, 100, 100, 100);
//        } else if (light_number == 1) {
//            // 초록불 (맨 아래)
//            g.setColor(Color.GREEN);
//            g.fillOval(100, 300, 100, 100);
//            } else {
//            // 노란불 (중간)
//            g.setColor(Color.YELLOW);
//            g.fillOval(100, 200, 100, 100);
//        }
//    }
//
//    @Override
//    public void actionPerformed(ActionEvent arg0) {
//        // 35
//        if (++light_number >= 3) {
//            light_number = 0; // 0, 1, 2 순환
//        }
//        repaint(); // 화면 갱신
//    }
//}
//}


// 타이머에 따라 일정하게 이동하는 물체 그리기- 교수님 오리지널
//public class W7 extends JFrame{
//	public W7() {
//		add(new MyPanel());
//		setSize(300, 800);
//		setVisible(true);
//		
//	}
//public class MyPanel extends JPanel implements ActionListener{
//	int x,y;
//	public MyPanel() {
//		x=30;
//		y=30;
////		setSize(300,800);
//		Timer t = new Timer(50,this);
//		t.start();
////		setVisible(true);
//	}
//	public void actionPerformed(ActionEvent e) {
//		y+=30;
//		repaint();
//	}
//	public void paintComponent(Graphics g) {
//		super.paintComponent(g);
//		g.fillOval(x, y, 20, 20);
//		g.fillOval(x, y, 20, 20);
//	}
//	
//}
//}
//



//전공서적 492pg - 화면에 사각형 그리기 





























//시험범위 10장 전체,11장 앞까지 타이머는 제외

// 상자연속해서 만들기






// 7주차
// 10장. 인터페이스는 추상클래스의 내용을 사용하지 않더라도 채워야하는 경우가 생긴다.
	// 이는 귀찮음이 있으니 어댑터 클래스 상속이라는 개념이 있다.
	// 자동으로 채워주는건데 부모가 두명 생기는 사유로 잘 쓰이지는 않는다.

//11장. 자바에서의 그래픽스 (Swing 기초)

//[논평] 
	//자바는 그래픽 연산의 최적화가 주 목적은 아니기에 '찍먹' 수준으로 기본 원리를 이해하는 것이 좋다.
	//앞으로 그래픽에 관심이 생긴다면, 전용 엔진이나 다른 이론을 깊이 파보는 것을 권장한다.

//[핵심 구조] 
	//자바 Swing에서 그림 그리기는 기본적으로
	//최상위 창인 JFrame 위에 도화지 역할을 하는 JPanel을 배치하여 진행한다.

//[그리기 구현] 
	//JPanel은 JComponent를 상속받으며, 
	//사용자 정의 그림을 그리기 위해서는 JComponent의 paintComponent(Graphics g) 메서드를 오버라이딩해야 한다.
	//참고: 이 메서드는 사용자가 그림을 추가하기 위해 재정의하는 것이며, 부모의 기능을 유지하기 위해 super를 호출하는 것이 일반적이다.
	//그리기는 모두 이벤트 기반이다.-->이벤트를 매개로하지 않고 직접 호출은 지양...
	// 할때마다 repaint




// 앞으로의 진로 설계
	// 2학년 때부터는 슬슬 내가 무엇을 할 것인지를 구체적으로 해야한다.
	// 어떻게?? 어느 분야??-->X
	// 어느 회사!!
		// 특정 회사에 어느 곳이 무엇을 원하는지 알아야한다.




//과거학습요약
// 8장
	// 컨테이너 와 컴포넌트
		// 최상위 컨테이너
		// 배치관리자
// 10장
	// 이벤트 10.2절에 5가지 방법 --- 1번째 방법만 쓰지 말기
	// 버튼과 일을 연결시켜주는 절차 구현
// 11장 
	//그림그리기(?)

// 기타
	//되도록 jpanel 위해 작성하기

// 다음주 시험이며 8장 9장 10장 문제 2문제 
// 다다음주는 발표