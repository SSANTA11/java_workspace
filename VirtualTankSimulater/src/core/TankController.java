package core;

import java.awt.event.KeyEvent;

import view.GameWindow;

public class TankController {
	private static TankController tankController;
	private boolean rightB = false, leftB = false, forwardB = false, backwardB = false;
	private boolean rightT = false, leftT = false;
	private boolean fire = false, MG = false, AP = false, HEAT = false;
	private double angleT = 0, angleB = 0;

	private TankController() {
	}

	public static TankController getInstance() {
		if (tankController == null) {
			tankController = new TankController();
		}
		return tankController;
	}

	public void setTank(int keyCode, boolean isMoving) {
		if (keyCode == KeyEvent.VK_Z) {
			rightT = isMoving;
		}
		if (keyCode == KeyEvent.VK_X) {
			leftT = isMoving;
		}
		if (keyCode == KeyEvent.VK_C) {
			fire = isMoving;
		}
		if (keyCode == KeyEvent.VK_UP) {
			forwardB = isMoving;
		}
		if (keyCode == KeyEvent.VK_DOWN) {
			backwardB = isMoving;
		}
		if (keyCode == KeyEvent.VK_LEFT) {
			leftB = isMoving;
		}
		if (keyCode == KeyEvent.VK_RIGHT) {
			rightB = isMoving;
		}
	}

}