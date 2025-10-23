package week6;

import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.Color;

import java.awt.event.*;

class MyFrame extends JFrame{
	BufferedImage img = null;
	int img_x=100;
	int img_y=100;
	private JButton b1;
	private JButton b2;
	private JPanel p;
//	MyListener listener = new MyListener();
	public MyFrame() {
		this.setSize(300,200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("이벤트 예제");
		try {
		img = ImageIO.read(new File("car.jpg"));
		} catch(IOException e) {
			System.exit(1);
		}
		p=new JPanel();
		b1=new JButton("노란색");
//		b1.addActionListener(listener);
		b1.addActionListener(new MyListener());
		p.add(b1);
		b2=new JButton("핑크색");
//		b2.addActionListener(listener);
		b2.addActionListener(new MyListener());
		p.add(b2);
//		p.add();
		this.add(p);
		
		this.setVisible(true);
	}
	private class MyListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==b1) {
				p.setBackground(Color.yellow);
			}
			if(e.getSource()==b2) {
				p.setBackground(Color.pink);
			}
		}
	}
}
// 8장은 배치관리자와 상속관계를 모두 암기하고, 각 컨테이너와 컴포넌트는 존재만 알고 사용법은 필요할 때마다 찾아봐라

// 10장의 AddEventListener 사용법 5가지는 정말정말 중요하고 모두 사용할 줄 알아야한다.

// 이벤트는 소프트웨어의 인터럽트!!!!!!


// 이벤트는 크게 두가지 수준(?)이 존재한다.
// 1. 저수준 이벤트 예) Mouse, MouseMove, Key 외 多
// 2. 의미적 이벤트 예) Action 외 多