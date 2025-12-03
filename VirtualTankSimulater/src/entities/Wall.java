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
}
