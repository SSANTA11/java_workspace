package entities;

import java.awt.Graphics;

public class Wall extends Entity {
	private int HP = 100;
	private int X, Y;
	private int width;
	private int height;
	// 1:물 2:진흙 3:콘크리트 4:바리게이트
	public Wall(String s) {
		switch(s) {
		case "1":
		case "2":
		case "3":
		case "4":
		}
	}

	void block() {
	};

	void broken() {
	};

	@Override
	public int getWidth() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getHeight() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getWorldX() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getWorldY() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getType() {
		return "WALL";
	}

	@Override
	public int getHP() {
		return 0;
	}

	@Override
	public int getSpeed() {
		return 0;
	}

	@Override
	public void setPosition(int playerWorldX, int playerWorldY) {
		// TODO Auto-generated method stub

	}

	@Override
	public int setHP(int HP) {
		return 0;
	}

	@Override
	public void updatePosition() {
		// TODO Auto-generated method stub

	}

	@Override
	public void draw(Graphics g, int screenX, int screenY) {
		// TODO Auto-generated method stub

	};
}
