package entities;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Player extends Entity {
	private int x = 500;
	private int y = 500;
	private int hp = 100;
	private int power = 10;
	private final int speed = 3;
	private BufferedImage image = null;
	// entities.Player.java 슈도 코드에 추가
	// ... 기존 필드 (x, y, image 등)
	private boolean isMovingUp, isMovingDown, isMovingLeft, isMovingRight;

	public void setMoving(int keyCode, boolean isMoving) {
		// 키 코드에 따라 상태 플래그를 변경
		// 이 메서드를 InputHandler에서 호출합니다.
	}

	public void updatePosition() {
		// isMoving 플래그를 확인하여 x, y 값을 변경합니다. (GameLoop에서 호출)
		if (isMovingUp)
			this.y -= speed;
		// ...
	}

	public Player() {
		try {
			image = ImageIO.read(getClass().getResource("/res/Player.png"));
		} catch (IOException e) {
			System.err.println("img 오류");
			e.printStackTrace();
		}
	}

	// ✅ GameLoop가 호출하여 위치를 업데이트하는 메서드
	public void update() {
		// 여기에 현재 입력 상태(isMovingLeft 등)를 기반으로 위치를 변경하는 로직이 들어감
		// 예: this.x += speed;
	}

	// ✅ GamePanel이 그리기 위해 호출하는 메서드 (Model 역할)
	// GamePanel의 paintComponent에서 Graphics 객체를 받아 호출
	public void draw(Graphics g) {
		if (image != null) {
			// Player 객체 자신의 위치와 이미지를 그립니다.
			g.drawImage(image, x, y, null);
		}
	}

	// ✅ 위치 Getter (GamePanel이 그릴 때나 충돌 검사 시 사용)
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	// ✅ 이동 메서드는 상태를 변경하고 update()가 실제 위치를 바꾸도록 합니다.
	public void move(int dx, int dy) {
		// 이 메서드는 GameLoop의 update에서 호출되거나,
		// 키 입력 리스너가 호출하여 이동 플래그를 변경해야 합니다.
		this.x += dx;
		this.y += dy;
	}
}