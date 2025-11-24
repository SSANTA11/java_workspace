package entities;

public class Wall extends Entity{
	private int condition;
	void block() {};
	void broken() {};
	void build() {}
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
		// TODO Auto-generated method stub
		return "WALL";
	}
	@Override
	public int getHP() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int getSpeed() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public void setPosition(int playerWorldX, int playerWorldY) {
		// TODO Auto-generated method stub
		
	};
}
