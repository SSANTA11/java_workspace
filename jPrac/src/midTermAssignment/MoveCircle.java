package midTermAssignment;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/*

1. 그림 1을 참고하여 아래 문제를 구현하시오. 
  - 화면 중앙에 한 개의 원을 그리세요. 
  - 왼쪽, 오른쪽, 위, 아래, 새로생성 버튼을 만드세요. 
  - 방향 버튼이 눌러지면 각 방향으로 20픽셀만큼 이동하도록 하세요.
  - 새로생성 버튼을 클릭하면 화면 가운데 (200, 200) 위치에 새로운 원을 생성합니다. 이후 방향 버튼을 클릭하면 가장 마지막에 생성된 원만 움직입니다. 


*/
public class MoveCircle extends JFrame implements ActionListener {
	JButton b1 = new JButton("LEFT");
	JButton b2 = new JButton("RIGHT");
	JButton b3 = new JButton("UP");
	JButton b4 = new JButton("DOWN");
	JButton b5 = new JButton("새로생성");

	int arr[][] = new int[10000][2];
	public static int STOR = 0;
	public static int x = 200;
	public static int y = 250;

	public MoveCircle() {
		setSize(400, 500);
		setTitle("Problem 2 : Move Circle");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel p = new JPanel(new BorderLayout());
		JPanel p1 = new JPanel();
		Panel p2 = new Panel();

		p1.add(b1);
		b1.addActionListener(this);
		p1.add(b2);
		b2.addActionListener(this);
		p1.add(b3);
		b3.addActionListener(this);
		p1.add(b4);
		b4.addActionListener(this);
		p1.add(b5);
		b5.addActionListener(this);

		add(p);
		p.add(p1, BorderLayout.SOUTH);
		p.add(p2, BorderLayout.CENTER);

		setVisible(true);
	}

	public class Panel extends JPanel {

		public Panel() {
			repaint();
		}

		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			if (STOR != 0) {
				for (int i = 0; i < STOR; i++) {
					int a = arr[i][0];
					int b = arr[i][1];
					g.setColor(Color.black);
					g.fillOval(a, b, 10, 10);
				}
			}

			g.setColor(Color.black);
			g.fillOval(x, y, 10, 10);
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == b3) {
			System.out.println("up액션 인식 중 ...");
			y -= 20;
			repaint();
		} else if (e.getSource() == b4) {
			System.out.println("down액션 인식 중 ...");

			y += 20;
			repaint();
		} else if (e.getSource() == b1) {
			System.out.println("left액션 인식 중 ...");

			x -= 20;
			repaint();
		} else if (e.getSource() == b2) {
			System.out.println("right액션 인식 중 ...");

			x += 20;
			repaint();
		} else {
			System.out.println("새로생성 진입");
			arr[STOR][0] = x;
			arr[STOR][1] = y;
			STOR++;

			x = 200;
			y = 200;

			repaint();
		}

	}

	public static void main(String[] args) {
		new MoveCircle();
	}
}
