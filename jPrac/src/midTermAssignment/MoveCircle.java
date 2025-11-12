package midTermAssignment;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
public class MoveCircle extends JFrame implements ActionListener {
	JButton b1 = new JButton("LEFT");
	JButton b2 = new JButton("RIGHT");
	JButton b3 = new JButton("UP");
	JButton b4 = new JButton("DOWN");
	JButton b5 = new JButton("새로생성");
	P p2 = new P();
	int arr[][] = new int[10000][2];
	int STOR = 0;
	int x = 200;
	int y = 250;
	MoveCircle() {
		setSize(400, 500);
		setTitle("Problem 2 : Move Circle");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel p = new JPanel(new BorderLayout());
		JPanel p1 = new JPanel();
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
	class P extends JPanel {
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
			y -= 20;
		} else if (e.getSource() == b4) {
			y += 20;
		} else if (e.getSource() == b1) {
			x -= 20;
		} else if (e.getSource() == b2) {
			x += 20;
		} else {
			arr[STOR][0] = x;
			arr[STOR][1] = y;
			STOR++;
			x = 200;
			y = 200;
		}
		p2.repaint();
	}
	public static void main(String[] args) {
		new MoveCircle();
	}
}
