package project_assignment;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

public class Prototype extends JFrame implements ActionListener {
    // 🎨 이미지 관련 변수
    BufferedImage img = null;
    int img_x = 100;
    int img_y = 100;
    
    // 💡 버튼과 레이블 필드는 Prototype 클래스에 선언 유지
    JButton b; 
    JLabel f;
    
    // 🖼️ MP는 이미지를 그리고 컴포넌트를 담는 주 패널 역할
    private final MP mp;

    // 💡 1번 오류 수정: 이미지를 그리는 메서드를 MP 클래스 안으로 옮겼습니다.
    class MP extends JPanel { 
        MP() {
            // 패널에 버튼과 레이블을 배치하기 위한 레이아웃 설정
            setLayout(new BorderLayout()); 
            setBackground(Color.BLACK);
            
            // Prototype의 초기화된 b와 f 필드를 추가합니다. (생성자에서 초기화 순서 조정됨)
            add(b, BorderLayout.EAST); 
            // 텍스트가 잘 보이도록 레이블 색상 설정
            f.setForeground(Color.WHITE); 
            f.setHorizontalAlignment(SwingConstants.CENTER);
            add(f, BorderLayout.SOUTH);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g); // 필수: 기본 배경을 그립니다.
            
            // Prototype의 필드 img, img_x, img_y에 접근하여 그립니다.
            if (img != null) {
                g.drawImage(img, img_x, img_y, null);
            }
        }
    }
    
    // 🏗️ 생성자: 객체 초기화 및 설정
    Prototype() {
        // 1. 이미지 로드
        try {
            img = ImageIO.read(new File("earth.jpg"));
        } catch (IOException e) {
            System.out.println("No IMG: 'earth.jpg' 파일을 찾을 수 없습니다.");
            System.exit(1);
        }
        
        // 2. 💡 2번 오류 수정: 버튼과 레이블을 MP 생성자 호출 전에 먼저 초기화합니다.
        b = new JButton("push!");
        f = new JLabel("dd"); 
        
        // 3. MP 패널 생성 및 추가
        mp = new MP(); // 이제 MP가 b와 f가 초기화된 후에 생성됩니다.
        add(mp);

        // 4. 이벤트 리스너 연결
        b.addActionListener(this);
        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {}
            @Override
            public void keyReleased(KeyEvent e) {}

            @Override
            public void keyPressed(KeyEvent e) {
                int keycode = e.getKeyCode();
                switch (keycode) {
                    case KeyEvent.VK_UP:    img_y -= 10; break;
                    case KeyEvent.VK_DOWN:  img_y += 10; break;
                    case KeyEvent.VK_RIGHT: img_x += 10; break;
                    case KeyEvent.VK_LEFT:  img_x -= 10; break;
                }
                mp.repaint(); // 키 입력 시 이미지를 다시 그리도록 요청
            }
        });
        
        // 5. 프레임 설정
        this.requestFocusInWindow(); // 포커스 요청 (KeyListener가 동작하도록)
//        setFocusable(true); 

        setSize(500, 800);
        setTitle("이미지 이동 프로젝트");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    

    @Override
    public void actionPerformed(ActionEvent e) {
        if (f != null) {
            f.setText(f.getText() + "ss");
        }
    }

    public static void main(String[] args) {
        // Swing 애플리케이션은 EDT에서 실행하는 것이 권장됩니다.
        SwingUtilities.invokeLater(() -> new Prototype());
    }
}