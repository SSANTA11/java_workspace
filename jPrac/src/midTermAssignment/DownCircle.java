//package midTermAssignment;
//
//import java.awt.Color;
//import java.awt.Graphics;
//import java.awt.event.ActionListener;
//import java.awt.event.KeyAdapter;
//import java.awt.event.KeyEvent;
//import javax.swing.Timer;
//
//import javax.swing.JFrame;
//import javax.swing.JPanel;
//
///*
//
//1. 그림 1을 참고하여 아래 문제를 구현하시오. 
//  - 화면 중앙에 한 개의 원을 그리세요. 
//  - 왼쪽, 오른쪽, 위, 아래, 새로생성 버튼을 만드세요. 
//  - 방향 버튼이 눌러지면 각 방향으로 20픽셀만큼 이동하도록 하세요.‘
//  - 새로생성 버튼을 클릭하면 화면 가운데 (200, 200) 위치에 새로운 원을 생성합니다. 이후 방향 버튼을 클릭하면 가장 마지막에 생성된 원만 움직입니다. 
//
//2. 그림 2는 3진수 덧셈 화면이다. 3진수 입력과 ‘+’, ‘=’은 모두 버튼으로 구현하였다. 예를 들어, 사용자가 1 0 1 + 2 2를 입력한 후, ‘=’ 버튼을 클릭하면 3진수 합을 계산하여 계속 출력하도록 한다. 
// 
//3. 그림 3과 같이 화면 위쪽 (200, 10) 위치에 원이 하나 있다.
//  - 사용자가 왼쪽 방향키(VK_LEFT) 혹은 오른쪽 방향키(VK_RIGHT)를 누르면 원이 왼쪽 혹은 오른쪽으로 20만큼씩 이동하도록 코드를 구현하시오.
//  - 만약 스페이스 키(VK_SPACE)를 누르면 화면 아래쪽으로 원이 떨어지는 효과를 구현하시오. 원이 화면 아래로 사라지면 화면 (200, 10) 위치에 원이 그려져서 위의 기능이 다시 동작하도록 하세요. 
// */
//public class DownCircle extends JFrame {
//	public DownCircle() {
//		setSize(400, 500);
//		setTitle("4번문제");
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		Panel p = new Panel();
//		add(p);
//		setVisible(true);
//	}
//
//	public class Panel extends JPanel {
//		public static int x = 200;
//		public static int y = 10;
//
//		public Panel() {
//			addKeyListener(new KeyAdapter() {
//				@Override
//				public void keyPressed(KeyEvent e) {
//					int keyCode = e.getKeyCode();
//					switch (keyCode) {
//					case KeyEvent.VK_UP:
//						y -= 20;
//						repaint();
//						break;
//
//					case KeyEvent.VK_DOWN:
//						y += 20;
//						repaint();
//						break;
//
//					case KeyEvent.VK_RIGHT:
//						x += 20;
//						repaint();
//						break;
//
//					case KeyEvent.VK_LEFT:
//						x -= 20;
//						repaint();
//						break;
//
//					case KeyEvent.VK_SPACE:
//						Timer t = new Timer(10, event -> {
//							y += 3;
//							if (y > 500) {
//								x = 200;
//								y = 10;
//							}
//							repaint();
//						});
//						t.start();
//					}
//				}
//			});
//			setFocusable(true);
//			requestFocusInWindow();
//		}
//
//		@Override
//		protected void paintComponent(Graphics g) {
//			super.paintComponent(g);
//			g.setColor(Color.black);
//			g.fillOval(x, y, 10, 10);
//		}
//
//	}
//
//	public static void main(String[] args) {
//		new DownCircle();
//	}
//}
