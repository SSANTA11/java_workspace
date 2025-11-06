package project_assignment;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;

import javax.swing.*;
import javax.imageio.*;

public class P extends JFrame implements ActionListener {
	BufferedImage img = null;
	int img_x = 10;
	int img_y = 10;

	JButton b = new JButton();
	JLabel l=new JLabel();
	static boolean uppressed=false;
	static boolean downpressed=false;
	static boolean rightpressed=false;
	static boolean leftpressed=false;
	
	private final MP mp;

	class MP extends JPanel {
		MP() {
			setLayout(new BorderLayout());
			setBackground(Color.LIGHT_GRAY);

			add(b, BorderLayout.EAST);

			l.setForeground(Color.GREEN);
			l.setHorizontalAlignment(SwingConstants.CENTER);
			add(l, BorderLayout.SOUTH);
		}

		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);

			if (img != null) {
				g.drawImage(img, img_x, img_y, null);
			}
		}
	}

	P() {
		try {
			img = ImageIO.read(new File("earth.jpg"));
		} catch (IOException e) {
			System.out.println("No IMG: 'earth.jpg' 파일을 찾을 수 없습니다.");
			System.exit(1);
		}

		
		mp = new MP();
		add(mp);

		b.addActionListener(this);
		addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
			}

			@Override
			public void keyReleased(KeyEvent e) {
				int keycode = e.getKeyCode();
				switch (keycode) {
				case KeyEvent.VK_UP:
					uppressed=false;
					break;

				case KeyEvent.VK_DOWN:
					downpressed=false;
					break;

				case KeyEvent.VK_RIGHT:
					rightpressed=false;
					break;

				case KeyEvent.VK_LEFT:
					
					leftpressed=false;
					break;

				}
				processMovement();
			}

			@Override
			public void keyPressed(KeyEvent e) {
				int keycode = e.getKeyCode();
				switch (keycode) {
				case KeyEvent.VK_UP:
//					img_y -= 10;
					uppressed=true;
					break;

				case KeyEvent.VK_DOWN:
//					img_y += 10;
					downpressed=true;
					break;

				case KeyEvent.VK_RIGHT:
//					img_x += 10;
					rightpressed=true;
					break;

				case KeyEvent.VK_LEFT:
//					img_x -= 10;
					leftpressed=true;
					break;

				}
				processMovement();
//				mp.repaint();
			}
		});
		this.requestFocusInWindow();
		setFocusable(true);
		
		setSize(500,800);	
		setTitle("각 관계성 이해위한 복습");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	// P 클래스 내부 (P() 생성자 바깥, actionPerformed 위쪽 등)에 추가
	private void processMovement() {
	    int dx = 0; // 수평 이동량
	    int dy = 0; // 수직 이동량
	    int SPEED = 1; // 이동 속도 통일 (기존 코드 10)

	    // 플래그 상태에 따라 dx, dy를 누적합니다. (동시 입력 처리)
	    if (uppressed) dy -= SPEED;
	    if (downpressed) dy += SPEED;
	    if (leftpressed) dx -= SPEED;
	    if (rightpressed) dx += SPEED;

	    // 실제로 좌표 갱신 (keyPressed에서 했던 직접 이동 로직을 여기로 가져옴)
	    img_x += dx;
	    img_y += dy;

	    // 화면 다시 그리기 요청
	    mp.repaint();
	}
	public void actionPerformed(ActionEvent e) {
		if (l!=null) {
			l.setText(l.getText()+"ss");
		}
	}

	public static void main(String[] args) {
		new P();
	}
}


 
/* 
LocalPVP2PShooting/
├── src/ 
│    ├── 핵심 관리 및 화면 출력/                             // 게임의 핵심 로직 및 실행 관련 클래스
│    │   ├── GameManager.java              // 게임 상태, 진행 관리, 화면 출력
│    │   ├── InputHandler.java              // 키보드 입력 처리 (KeyListener 구현)
│    │   ├── CollisionDetector.java 
│	 │	 ├── AssetManager.java            // 이미지, 사운드 등 리소스 로드 및 관리
│    │   └── LevelManager.java   
│    └── entities/                      // 게임 세계 내의 모든 객체 (엔티티)
│      	 ├── Entity.java                      // [추상 클래스/인터페이스] 모든 엔티티의 부모
│  	   	 ├── Player.java                   // 플레이어 캐릭터 (MovableEntity 상속)
│      	 ├── Projectile.java 
│        ├── Weapon.java
│        └── Wall.java                      // 벽, 가구 등 (Scenery 상속)
└── res/                                     // 게임 리소스 (이미지, 사운드, 맵 파일 등)
    ├── images/
    │   ├── player_sprite.png
    │   └── tile_wall.png
    └── level/
        └── level.txt                         //나중에 스트림으로 맵설정
*/
