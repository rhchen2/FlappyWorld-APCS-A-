package game;

public abstract class Powerup extends Sprite{

	private String name;
	
	public Powerup(String name, int x, int y, int width, int height, String img){
		super(x, y, width, height, img);
		this.name = name;
	}
	
	public abstract void update();
}
